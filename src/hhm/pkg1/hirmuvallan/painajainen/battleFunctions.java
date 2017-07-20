/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhm.pkg1.hirmuvallan.painajainen;

import static hhm.pkg1.hirmuvallan.painajainen.gameTools.dice;

/**
 *
 * @author sysadmin
 */
public class battleFunctions {

    public static void attack(Character attacker, Character target) {
        // assuming all characters have just one dice
        // using str instead of calculated values
        if (!target.dying) {
            /*
            int dice = dice(thudDice);
            int battleResult = (str + dice + f_curve) - (target.str - target.f_curve);
            System.out.println(fullName + " attacks " + target.fullName
                    + " with " + battleResult + " thud (" + str + " + " + dice + " + " + f_curve
                    + ") - (" + target.str + " - " + target.f_curve + ")");
             */
            int battleResult = battle(attacker, target);
            System.out.println(attacker.fullName + " attacks " + target.fullName + " with " + battleResult + " thud.");
            target.injuries(target, battleResult);

        } else {
            System.out.println(target.fullName + " is dying. You can't attack defenceless creatures.");

        }

    }

    // from here
    public static int battle(Character attacker, Character defender) {
        int attackPower = getAttackPower(attacker); // dice, level & other basics
        int defencePower = getDefencePower(defender);
        int matdiff = getMaterialDifference(attacker, defender);

        return (attackPower + matdiff) - defencePower;
    }

    public static int getAttackPower(Character character) {

        // @TODO: clean these when you understand the battle procedure better
        int level = character.level;
        int dice = dice(character.thudDice);
        int str = character.str;
        int weaponpower = getWeaponPower(character);
        int handicap = getIntegerModifiers(character, StatusModifierType.attackModifier);
        double percentage = getPercentageModifiers(character, StatusModifierType.attackModifier);

        int rawresult = level + dice + str + weaponpower;
        double resultDouble = (rawresult + handicap) * percentage;
        int result = (int) resultDouble;

        System.out.println("Raw attack power is " + rawresult + ", " + result + " after modifiers.");
        //System.out.println(character.fullName + " attacks with " + result + " thud. (" + level + dice + str + weaponpower);
        return result;
    }

    public static int getIntegerModifiers(Character character, StatusModifierType modifierType) {
        int returnValue = 0;
        System.out.println("Getting integer status modifiers");
        for (int i = 0; i < character.statusModifierList.size(); i++) {
            StatusModifier currentModifier = character.statusModifierList.get(i);
            if (currentModifier.type == modifierType && !currentModifier.isPercentage) {
                returnValue = returnValue + (int) currentModifier.handicapStack[currentModifier.depth - 1];
                System.out.println("Found active modifier: " + currentModifier.handicapStack[currentModifier.depth - 1]);
            }
        }
        System.out.println("Returning integer modifier is: " + returnValue);
        return returnValue;
    }

    public static double getPercentageModifiers(Character character, StatusModifierType modifierType) {
        double returnValue = 1.0;
        //System.out.println("Getting percentage status modifiers");
        for (int i = 0; i < character.statusModifierList.size(); i++) {
            StatusModifier currentModifier = character.statusModifierList.get(i);
            //System.out.println(compare.value + ", " + compare.type + ", " + compare.isPercentage);
            if (currentModifier.type == modifierType && currentModifier.isPercentage) {
                returnValue = returnValue + currentModifier.handicapStack[currentModifier.depth - 1];
                System.out.println("Found active modifier: " + currentModifier.handicapStack[currentModifier.depth - 1]);
            }
        }
        System.out.println("Returning percentage modifier is: " + returnValue);
        return returnValue;
    }


    public static int getWeaponPower(Character character) {
        if (character.weapon == null) {
            return 0;
        } else {
            return character.weapon.powerConstant;
        }
    }

    public static int getMaterialDifference(Character attacker, Character defender) {
        // @TODO: implement exiting and creepified material bonuses
        if (attacker.weapon == null && defender.panzer == null) {
            return 0;
        }

        if (defender.panzer == null) {
            return 3;
        }

        if (attacker.weapon == null) {
            return -3;
        }
        int returnValue;

        if (defender.panzer.materialType == MaterialType.teel) {
            returnValue = attacker.weapon.materialType.againstBlasce;
        } else if (defender.panzer.materialType == MaterialType.diamang) {
            returnValue = attacker.weapon.materialType.againstDiamang;
        } else if (defender.panzer.materialType == MaterialType.laziness) {
            returnValue = attacker.weapon.materialType.againstLaziness;
        } else if (defender.panzer.materialType == MaterialType.plastic) {
            returnValue = attacker.weapon.materialType.againstPlastic;
        } else if (defender.panzer.materialType == MaterialType.wood) {
            returnValue = attacker.weapon.materialType.againstWood;
        } else if (defender.panzer.materialType == MaterialType.wool) {
            returnValue = attacker.weapon.materialType.againstWool;
        } else {
            returnValue = -3;
        }

        return returnValue;

    }

    public static int getDefencePower(Character character) {
        // getDefenceTraitBonus(character) ;
        int level = character.level;
        int panzerModifier = getPanzerPower(character);
        int fcurve = character.f_curve;
        int handicap = getIntegerModifiers(character, StatusModifierType.defenceModifier);
        double percentage = getPercentageModifiers(character, StatusModifierType.defenceModifier);

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

    public static int getPanzerPower(Character character) {
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
}
