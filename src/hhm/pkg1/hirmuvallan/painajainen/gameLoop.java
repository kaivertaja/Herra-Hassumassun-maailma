/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhm.pkg1.hirmuvallan.painajainen;

import static hhm.pkg1.hirmuvallan.painajainen.defaultSettings.*;
import static hhm.pkg1.hirmuvallan.painajainen.battleFunctions.*;
// import static hhm.pkg1.hirmuvallan.painajainen.StatusModifier.*;

import java.util.*;

/**
 *
 * @author sysadmin
 */
public class gameLoop {

    public gameLoop() {

    }

    public static void run() {

        Scanner sc = new Scanner(System.in);        // create input scanner
        gameTools gameTools = new gameTools();      // create basic toolset (=dice)

        gameTools.soundBoardEffect(gameTools.themeSong);
        // create the grid where we're playing
        Grid kehveli = new Grid(7, 6);

        // create some spesific characters directly
        Character Armand = gameTools.createCharacter(Species.defaultPösilö, null, "Armand van der Eld", 1, 1);
        Character Pege = gameTools.createCharacter(Species.defaultHassutassu, null, "Sir Pege von Richthofen", 1, 1);
        //Character Pyynö = new Character (Race.pitkäkorva, 1, "Pyynö Jopeliini", 3);
        //Character Ölli = new Character(Race.pitkäkorva, 1, "Ölli", 1);
        //Character Satüria = new Character(Race.pula_aho, 1, "Satüria Kauhukoala", 1);

        // create some monsters with randomization
        Character sporofyytti = gameTools.randomEnemy(Tribe.sporofyytti);
        Character feta = gameTools.randomEnemy(Tribe.fetajuusto);

        // check stats
        Armand.printStats();
        Pege.printStats();
        sporofyytti.printStats();
        feta.printStats();

        // create a few different materials
        Material lumpOfWood = new Material(MaterialType.wood, false);
        Material epicShit = new Material(MaterialType.laziness, true);
        epicShit.creepified = true;
        // create some weapons
        Weapon mätkin = new Weapon(WeaponType.astalo, lumpOfWood);
        Weapon kolmipiikki = new Weapon(WeaponType.atrain, epicShit);
        Weapon tökkäin = new Weapon(WeaponType.pistin, lumpOfWood);
        // equip them
        Armand.weapon = mätkin;
        Pege.weapon = kolmipiikki;
        sporofyytti.weapon = tökkäin;
        feta.weapon = tökkäin;
        // create some armor
        Panzer nuttu = new Panzer(PanzerType.nuttu, lumpOfWood);
        Armand.panzer = nuttu;
        Pege.panzer = nuttu;
        sporofyytti.panzer = nuttu;
        feta.panzer = nuttu;

        /*
        Armand.setModifier(StatusModifier.torsoWound, Armand);
        Pege.setModifier(StatusModifier.attackHandWound, Pege);
        Pege.setModifier(StatusModifier.attackHandWound, Pege);
        feta.setModifier(StatusModifier.defenceHandWound, feta);
        feta.setModifier(StatusModifier.defenceHandWound, feta);
         */
        // place characters on board
        // @TODO: randomize character placement
        kehveli.setOccupant(Armand, 3, 3);
        kehveli.setOccupant(Pege, 6, 3);
        //kehveli.setOccupant(Ölli, 3, 7);
        //kehveli.setOccupant(Satüria, 2, 4);

        kehveli.setOccupant(sporofyytti, 4, 3);
        kehveli.setOccupant(feta, 2, 3);

        // preparations
        Character[] charList = kehveli.getOccupantList();             
        Character current = charList[0];
        int i = 1;

        ArrayList<Character> mapCreatures = kehveli.getOccupantArrayList();

        
        // start loop
        while (!current.lastTeamStanding()) {

            if (current.alive) {
                current.roundOperations();
                //re-check because round operations might kill the character
                if (current.alive && !current.dying) {
                    kehveli.draw();
                    // System.out.println("Nearest enemy is " + current.nearestEnemy().fullName + " (distance: " + current.nearestEnemy().enemyDistance + ")");
                    if (current.team == 1) {
                        System.out.print("Move character: " + current.fullName + ": ");
                        kehveli.moveTo(current, sc.nextInt());
                    } else {
                        System.out.println("AI character " + current.fullName + " makes the next move");
                        AI.simpleMove(current, current.nearestEnemy().location);
                        
                    }

                } else if (current.alive && current.dying) {
                    System.out.println(current.fullName + " is dying and unable to move");
                } else {
                    System.out.println(current.fullName + " is dead and removed from character pool.");
                }

            }

            charList = kehveli.getOccupantList();
            if (i >= charList.length) {
                i = 0;
            }
            current = charList[i];
            i++;

        }

        gameTools.idle(5000);

        System.out.println("Team #" + current.team + " has emerged victorious");
        gameTools.soundBoardEffect(gameTools.fanfare);
    }
}
