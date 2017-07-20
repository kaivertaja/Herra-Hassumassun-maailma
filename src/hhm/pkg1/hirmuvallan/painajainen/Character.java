/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhm.pkg1.hirmuvallan.painajainen;

import static hhm.pkg1.hirmuvallan.painajainen.gameTools.*;
import javax.sound.sampled.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author sysadmin
 */
public class Character {

    public Cell location;
    public Grid map;
    public int enemyDistance; // distance to nearest enemy

    public String name;
    public String fullName;
    public Species creatureType;

    public playerType charClass;
    public int team;
    /*
    0 = neutral
    1 = player
    2 -> = enemies
     */

    public int str;
    public int dex;
    public int wis;
    public int cha;
    public int mana;
    public int thudDice = 1;

    // triad / trinity / tricode
    // this needs an idea since the values are dependant on each other
    public int triadFaith;
    public int triadUnderstanding;
    public int triadReason;

    public StatusModifier[] modifier;

    // equipment
    public Weapon weapon;
    public Panzer panzer;
    public armWall armWall;

    // damage variables
    public boolean alive = true;
    public boolean dying = false;
    public int katatoniaCountdown = 0;
    public int f_curve = 0; // this can be anything
    // these can't exceed 4
    public int blockDMG = 0;
    public int moverDMG = 0;
    public int attDMG = 0;
    public int supportDMG = 0;
    public int linkerDMG = 0;
    public int thinkerDMG = 0;

    // potion and poison states
    public int hangover = 0;
    public int hangoverModifier = 0;
    public int hangoverRoundsLeft = 0;

    public int metanolPoison = -1;
    public int ricinPoison = -1;
    public int cyanidePoison = -1;
    public int strychninePoison = -1;
    public int arsenicPoison = -1;
    public int poloniumPoison = -1;

    public ArrayList<StatusModifier> statusModifierList;

    // level and skills
    public int level;

    // Sound interface
    File missSND = new File("/home/sysadmin/Cloud/soundeffects/miss.aiff");
    File ouchSND = new File("/home/sysadmin/Cloud/soundeffects/ouchhit.aiff");
    File woundSND = new File("/home/sysadmin/Cloud/soundeffects/woundhit.aiff");
    File dyingSND = new File("/home/sysadmin/Cloud/soundeffects/katatonia.aiff");
    File deathSND = new File("/home/sysadmin/Cloud/soundeffects/monsterdeath.aiff");
    File deathCoalBucketSND = new File("/home/sysadmin/Cloud/soundeffects/deathCoalBucket.aiff");

    public Character(Species creatureType, playerType charClass, String name, int level, int team) {
        this.statusModifierList = new ArrayList<StatusModifier>();
        this.fullName = name;
        if (name.length() < 7) {
            name = name + "         ";
        }
        this.name = name.substring(0, 7);
        this.creatureType = creatureType;
        this.charClass = charClass;
        // this.race = race;
        this.level = level;
        this.team = team;
        this.modifier = new StatusModifier[20];
        
    }

    // @TODO: enable the use of the rest of the battle arguments (weapon type etc.)
    /*
    THINGS THAT AFFECT ON BATTLE:
    -character levels (simple integer)
    -amount of attack dice (depends on level and class, sometimes on other factors)
    -weapon material vs. armor material
    -weapon type vs. armor type
    -injuries (both attacker and defender)
    -active bonuses and handicaps (spells & other affectors)
    -hangover
    -ability modifiers (mainly müscles, see battle mechanics)
     */
    public void printStats() {
        System.out.println(this.fullName + " stats are: str " + this.str + ", wis " + this.wis + ", dex " + this.dex + ", cha " + this.cha);
    }

    public ArrayList<Character> checkSurroundings() {
        // get everybody on the character's map
        if (!this.alive) {
            System.out.println(this.fullName + " is dead");
            return null;
        }
        
        Character[] occupantList = this.map.getOccupantList();
        ArrayList<Character> visibleCreatures = new ArrayList<>();
        
        // if clairvoyance, see everything
        if (battleFunctions.getIntegerModifiers(this, StatusModifierType.sightModifier) == 1) {
            Collections.addAll(visibleCreatures, occupantList);
            return visibleCreatures;
        } else {
            
            // if not, check straight lines
            for (int i = 0; i < occupantList.length; i++) {
                // System.out.println(occupantList[i].location.locX + ", " + this.location.locX + ", " + occupantList[i].location.locY + ", " + this.location.locY);
                if (occupantList[i].location.locX == this.location.locX || occupantList[i].location.locY == this.location.locY) {
                    visibleCreatures.add(occupantList[i]);
                }
            }
            
            for (int f = 0; f < visibleCreatures.size(); f++) {
                System.out.println(this.fullName + " sees: " + visibleCreatures.get(f).fullName);
            }
            return visibleCreatures;
        }
    }

    public boolean setModifier(StatusModifier modifier, Character character) {
        if (character.statusModifierList.contains(modifier)) {
            StatusModifier active = character.statusModifierList.get(character.statusModifierList.indexOf(modifier));

            if (active.depth >= active.handicapStack.length) {
                System.out.println("This modifier is already at its max value");
                return false;
            } else {
                character.statusModifierList.get(character.statusModifierList.indexOf(modifier)).depth++;
                return true;
            }
        } else {
            character.statusModifierList.add(modifier);
            return true;
        }
    }

    public boolean dropModifier(StatusModifier modifier, Character character) {
        if (character.statusModifierList.contains(modifier)) {
            StatusModifier active = character.statusModifierList.get(character.statusModifierList.indexOf(modifier));

            if (active.depth == 1) {
                System.out.println("Modifier value drops to zero -> it is removed");
                return character.statusModifierList.remove(modifier);
            } else {
                character.statusModifierList.get(character.statusModifierList.indexOf(modifier)).depth--;
                return true;
            }
        } else {
            System.out.println("Character does not have this modifier");
            return false;
        }
    }

    public void injuries(Character target, int thud) {
        if (thud < 6) {
            gameTools.soundBoardEffect(missSND);
            System.out.println("Missed, no damage");
        } else if (thud < 12) {
            gameTools.soundBoardEffect(ouchSND);
            int fDelta = ((thud - 5) / 2);
            target.f_curve = target.f_curve + fDelta;
            System.out.println("Ouch! " + target.fullName + " F-curve goes up to " + target.f_curve);
        } else if (thud < 18) {
            gameTools.soundBoardEffect(woundSND);
            int fDelta = ((thud - 5) / 2);
            target.f_curve = target.f_curve + fDelta;
            if (target.causeWounds(target, thud)) {
                // System.out.println(target.fullName + " took limb damage");
            } else {
                System.out.println(target.fullName + " took limb damage but it's already crippled");
            }
            System.out.println(target.fullName + " F-curve also goes up to " + target.f_curve);
        } else if (thud < 24) {
            gameTools.soundBoardEffect(dyingSND);
            int countdown = 24 - thud;
            target.katatoniaCountdown = countdown;
            target.dying = true;
            System.out.println(target.fullName + " got knocked out and will die within " + countdown + " rounds if not treated.");
        } else {
            gameTools.soundBoardEffect(deathSND);
            System.out.println("Overkill. Defender dies instantly");
            death(target);

        }

    }

    private void death(Character target) {
        gameTools.soundBoardEffect(deathCoalBucketSND);
        System.out.println(target.fullName + " has died and been taken to the Twilight Forest.");
        target.alive = false;
        target.dying = false;
        target.katatoniaCountdown = 0;
        target.map.deleteOccupant(target, target.location.locX, target.location.locY);
        // should the whole character instance be destroyed?
        // this is Java, you can't destroy objects

    }

    public boolean causeWounds(Character target, int thud) {
        switch (thud) {
            case 12:
                System.out.println(target.fullName + ": " + StatusModifier.defenceHandWound.description);
                return target.setModifier(StatusModifier.defenceHandWound, target);
            case 13:
                boolean a = target.setModifier(StatusModifier.mobilityLegWound_def, target);
                System.out.println(target.fullName + ": " + StatusModifier.mobilityLegWound_def.description);
                boolean b = target.setModifier(StatusModifier.mobilityLegWound_mov, target);
                System.out.println(target.fullName + ": " + StatusModifier.mobilityLegWound_mov.description);
                return !(!a && !b);
            case 14:
                System.out.println(target.fullName + ": " + StatusModifier.attackHandWound.description);
                return target.setModifier(StatusModifier.attackHandWound, target);
            case 15:
                boolean c = target.setModifier(StatusModifier.supportLegWound_att, target);
                System.out.println(target.fullName + ": " + StatusModifier.supportLegWound_att.description);
                boolean d = target.setModifier(StatusModifier.supportLegWound_mov, target);
                System.out.println(target.fullName + ": " + StatusModifier.supportLegWound_mov.description);
                return !(!c && !d);
            case 16:
                System.out.println(target.fullName + ": " + StatusModifier.torsoWound.description);
                return target.setModifier(StatusModifier.torsoWound, target);
            case 17:
                System.out.println(target.fullName + ": " + StatusModifier.headWound.description);
                return target.setModifier(StatusModifier.headWound, target);
        }
        return false;
    }

    public boolean lastTeamStanding() {
        Character[] inhabitants = this.map.getOccupantList();
        ArrayList<Integer> teams = new ArrayList<>();
        for (int i = 0; i < inhabitants.length; i++) {
            if (inhabitants[i].team != team) {
                teams.add(inhabitants[i].team);
            }
        }
        return teams.isEmpty();
    }

    public boolean teamAlive() {
        try {
            Character[] inhabitants = this.map.getOccupantList();
            for (int i = 0; i < inhabitants.length; i++) {
                if (inhabitants[i].team == this.team && inhabitants[i].alive == true) {
                    return true;
                }
            }
        } catch (NullPointerException e) {
            System.out.println(this.fullName + " is no longer on the map");
            return false;
        }
        return false;
    }

    public Character nearestEnemy() {
        Character[] enemies = new Character[this.map.getOccupantList().length];
        ArrayList<Character> enemylist = new ArrayList<Character>();
        //System.out.println("Occupant list size: " + this.map.getOccupantList().length);

        for (int i = 0; i < this.map.getOccupantList().length; i++) {
            //System.out.println("Cell inhabitant: " + this.map.getOccupantList()[i].fullName);
            if (this.map.getOccupantList()[i].team != this.team) {
                //System.out.println("Got enemy " + this.map.getOccupantList()[i].fullName);
                enemylist.add(this.map.getOccupantList()[i]);
                this.map.getOccupantList()[i].enemyDistance = this.map.calculateDistance(this.location, this.map.getOccupantList()[i].location);
                //System.out.println(this.map.getOccupantList()[i].fullName + " distance is " + this.map.getOccupantList()[i].enemyDistance);
            }
        }

        //@DONE: sort enemylist by nearest enemy property in Character object
        int shortestDistance = 99;
        Character returnCharacter = this;
        for (int i = 0; i < enemylist.size(); i++) {
            if (enemylist.get(i).enemyDistance < shortestDistance) {
                shortestDistance = enemylist.get(i).enemyDistance;
                returnCharacter = enemylist.get(i);

            }
        }
        return returnCharacter;
    }

    public void roundOperations() {
        // if f-curve is positive, drop it by one

        if (this.statusModifierList.contains(StatusModifier.torsoWound)) {
            f_curve = f_curve + battleFunctions.getIntegerModifiers(this, StatusModifierType.f_curveModifier);
            System.out.println(fullName + " F-curve rises by " + battleFunctions.getIntegerModifiers(this, StatusModifierType.f_curveModifier) + " to total " + f_curve + " due to head injury");
        } else if (f_curve > 0) {
            f_curve--;
            System.out.println(fullName + " F-curve is " + f_curve);
        }

        // if katatonia counter has reached zero, kill character
        if (katatoniaCountdown <= 1 && dying) {
            death(this);
        }
        // if character is in katatonia, drop counter by one
        if (katatoniaCountdown > 1 && dying) {
            katatoniaCountdown--;
            System.out.println(fullName + " will die after " + katatoniaCountdown + " rounds");
        }

        // if character has hangover, either..
        // drop hangover by one point if one state has been in effect long enough
        if (hangover > 0 && hangoverRoundsLeft > 0) {
            hangoverRoundsLeft = hangoverModifier;
            hangover--;
        } // or drop hangover round counter by one
        else if (hangover > 0 && hangoverRoundsLeft == 0) {
            hangoverRoundsLeft--;
        }
        
        this.checkSurroundings();

    }

    /*OLD
    
                // delete when sure new one works
    public boolean causeWoundsOld(int thud) {
        switch (thud) {
            case 12:
                if (blockDMG < 5) {
                    blockDMG++;
                    System.out.println(fullName + " blocking hand got #" + blockDMG + " wounds. Blocking is now harder");
                    return true;
                }
            case 13:
                if (moverDMG < 5) {
                    moverDMG++;
                    System.out.println(fullName + " primary mobility leg got #" + moverDMG + " wounds. Attacks are slightly weaker and moving is harder.");
                    return true;
                }
            case 14:
                if (attDMG < 5) {
                    attDMG++;
                    System.out.println(fullName + " attack appendage got #" + attDMG + " wounds. Attacks are now weaker");
                    return true;
                }
            case 15:
                if (supportDMG < 5) {
                    supportDMG++;
                    System.out.println(fullName + " support leg got #" + supportDMG + " wounds. Blocking and moving is now harder");
                    return true;
                }
            case 16:
                if (linkerDMG < 5) {
                    linkerDMG++;
                    System.out.println(fullName + " torso got hit by #" + linkerDMG + " wounds. F-curve will be rising every round now.");
                    return true;
                }
            case 17:
                if (thinkerDMG < 5) {
                    thinkerDMG++;
                    System.out.println(fullName + " sustained level #" + thinkerDMG + " head injury. Hangover will be rising every round.");
                    return true;
                }

        }
        return false;
    }
    
    
    
     */
 /* TRANSFERRED
    
        // method attack is now in battleFunctions
    public void attack(Character target) {
        // assuming all characters have just one dice
        // using str instead of calculated values
        if (!target.dying) {
            
            int dice = dice(thudDice);
            int battleResult = (str + dice + f_curve) - (target.str - target.f_curve);
            System.out.println(fullName + " attacks " + target.fullName
                    + " with " + battleResult + " thud (" + str + " + " + dice + " + " + f_curve
                    + ") - (" + target.str + " - " + target.f_curve + ")");
             
            int battleResult = battle(this, target);
            System.out.println(fullName + " attacks " + target.fullName + " with " + battleResult + " thud.");
            injuries(target, battleResult);

        } else {
            System.out.println(target.fullName + " is dying. You can't attack defenceless creatures.");

        }

    }
    // method attack is now in battleFunctions
    
    
    
    
    
        // from here
    public int battle(Character attacker, Character defender) {
        int attackPower = getAttackPower(attacker); // dice, level & other basics
        int defencePower = getDefencePower(defender);
        int matdiff = getMaterialDifference(attacker, defender);

        return (attackPower + matdiff) - defencePower;
    }

    public int getAttackPower(Character character) {

        // @TODO: clean these when you understand the battle procedure better
        int level = character.level;
        int dice = dice(character.thudDice);
        int str = character.str;
        int weaponpower = getWeaponPower(character);
        int handicap = getIntegerModifiers(StatusModifierType.attackModifier);
        double percentage = getPercentageModifiers(StatusModifierType.attackModifier);

        int rawresult = level + dice + str + weaponpower;
        double resultDouble = (rawresult + handicap) * percentage;
        int result = (int) resultDouble;
        
        System.out.println("Raw attack power is " + rawresult + ", " + result + " after modifiers.");
        //System.out.println(character.fullName + " attacks with " + result + " thud. (" + level + dice + str + weaponpower);
        return result;
    }

    public int getIntegerModifiers(StatusModifierType modifierType) {
        int returnValue = 0;
        System.out.println("Getting integer status modifiers");
        for (int i = 0; i < this.statusModifierList.size(); i++) {
            StatusModifier currentModifier = this.statusModifierList.get(i);
            if (currentModifier.type == modifierType && !currentModifier.isPercentage) {
                returnValue = returnValue + (int) currentModifier.handicapStack[currentModifier.depth - 1];
                System.out.println("Found active modifier: " + currentModifier.handicapStack[currentModifier.depth - 1]);
            }
        }
        System.out.println("Returning integer modifier is: " + returnValue);
        return returnValue;
    }

    public double getPercentageModifiers(StatusModifierType modifierType) {
        double returnValue = 1.0;
        //System.out.println("Getting percentage status modifiers");
        for (int i = 0; i < this.statusModifierList.size(); i++) {
            StatusModifier currentModifier = this.statusModifierList.get(i);
            //System.out.println(compare.value + ", " + compare.type + ", " + compare.isPercentage);
            if (currentModifier.type == modifierType && currentModifier.isPercentage) {
                returnValue = returnValue + currentModifier.handicapStack[currentModifier.depth - 1];
                System.out.println("Found active modifier: " + currentModifier.handicapStack[currentModifier.depth - 1]);

            }
        }
        System.out.println("Returning percentage modifier is: " + returnValue);
        return returnValue;

    }

    public int getWeaponPower(Character character) {
        if (character.weapon == null) {
            return 0;
        } else {
            return character.weapon.powerConstant;
        }
    }

    public int getMaterialDifference(Character attacker, Character defender) {
        // @TODO: implement exiting and creepified material bonuses
        if (defender.panzer == null) {
            return 3;
        }

        if (attacker.weapon == null) {
            return -3;
        }
        int returnValue;

        if (defender.panzer.materialType == MaterialType.blasce) {
            returnValue = attacker.weapon.materialType.againstBlasce;
        } else if (defender.panzer.materialType == MaterialType.diamang) {
            returnValue =  attacker.weapon.materialType.againstDiamang;
        } else if (defender.panzer.materialType == MaterialType.laziness) {
            returnValue =  attacker.weapon.materialType.againstLaziness;
        } else if (defender.panzer.materialType == MaterialType.plastic) {
            returnValue =  attacker.weapon.materialType.againstPlastic;
        } else if (defender.panzer.materialType == MaterialType.wood) {
            returnValue =  attacker.weapon.materialType.againstWood;
        } else if (defender.panzer.materialType == MaterialType.wool) {
            returnValue =  attacker.weapon.materialType.againstWool;
        } else {
            returnValue = -3;
        }
        
        return returnValue;
        
    }

    public int getDefencePower(Character character) {
        // getDefenceTraitBonus(character) ;
        int level = character.level;
        int panzerModifier = getPanzerPower(character);
        int fcurve = character.f_curve;
        int handicap = character.getIntegerModifiers(StatusModifierType.defenceModifier);
        double percentage = character.getPercentageModifiers(StatusModifierType.defenceModifier);
        
        int rawresult = level + panzerModifier - fcurve;
        
        int calc = rawresult + handicap;
        double resultDouble;
        

        
        if (calc > 0) {
            resultDouble = calc * percentage;            
        } else {
            resultDouble = calc + (calc - (calc * percentage));
        } 
        
        
        int result = (int) resultDouble;
        System.out.println("Raw defence power is " + rawresult + ", " + result + " after modifiers.");     
        return result;
    }

    public int getPanzerPower(Character character) {
        if (character.panzer == null) {
            return 0;
        }

        switch (character.panzer.panzerClass.strength) {
            case 0:
                if (character.str > 0 && character.dex > 0) {
                    return character.str + character.dex;
                } else if (character.str > character.dex) {
                    return character.str;
                } else if (character.str > character.dex) {
                    return character.dex;
                }

                return character.dex;
            case 1:
                return character.dex;
            case 2:
                return character.str / 2;
            case 3:
                return character.str / 3;
            default:
                return 0;
        }

    }
    // to here

     */
}
