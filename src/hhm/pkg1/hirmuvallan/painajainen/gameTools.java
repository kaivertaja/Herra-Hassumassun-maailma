/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhm.pkg1.hirmuvallan.painajainen;
import javax.sound.sampled.*;
import java.io.*;
/**
 *
 * @author sysadmin
 */



public class gameTools {

    
    public File themeSong = new File("/home/sysadmin/Cloud/soundeffects/VintageNewsLong.aiff");
    public File fanfare = new File("/home/sysadmin/Cloud/soundeffects/fanfare.aiff");

    public int throwDice(int amount) {
        int output = 0;
        int value = 0;
        for (int i = 0; i < amount; i++) {
            while (true) { // Törttö! Kerro se randomi kuudella ja pyöristä
                double raw = Math.random();

                if (raw < 0.125) {
                    // do nothing aka. re-roll   
                } else if (raw < 0.250) {
                    value = 1;
                    break;
                } else if (raw < 0.375) {
                    value = 2;
                    break;
                } else if (raw < 0.500) {
                    value = 3;
                    break;
                } else if (raw < 0.625) {
                    value = 4;
                    break;
                } else if (raw < 0.750) {
                    value = 5;
                    break;
                } else if (raw < 0.875) {
                    value = 6;
                    break;
                } // if raw is over 0.875 the die is re-rolled

            }
            // System.out.println("Die #" + i + " got value " + value);
            output = output + value;
        }
        return output;
    }

    // give amount of dices, get random results
    public static int dice(int amount) {
        int output = 0;
        int value = 0;

        for (int i = 0; i < amount; i++) {
            while (value <= 0) {
                value = (int) Math.round(Math.random() * 6);
                // System.out.println("Dice #" + i + " got value " + value);
                output = output + value;
            }
            value = 0;
        }
        return output;
    }

    public Character randomEnemy (Tribe tribe) {
        int dice = dice(1)-1;
        int a = 0;
        Species[] creatureArray = new Species[6];
        for (int i = 0; i < Species.values().length; i++) {
            
            if (Species.values()[i].tribe == tribe) {
                creatureArray[a] = Species.values()[i];
                a++;
            }
        }    
        Species creature = creatureArray[dice];
        //System.out.println("Created a " + creature.speciesName);
        //return new Character(creature, 1, creature.speciesName, 1);
        return createCharacter(creature, null, creature.speciesName, 1, 2);
        
    }
    
    public Character createCharacter (Species species, playerType charClass, String name, int level, int team) {
        Character character = new Character(species, charClass, name, level, team);
        character.str = species.str + species.tribe.str + species.tribe.race.str;
        character.wis = species.wis + species.tribe.wis + species.tribe.race.wis;
        character.dex = species.dex + species.tribe.dex + species.tribe.race.dex;
        character.cha = species.cha + species.tribe.cha + species.tribe.race.cha;
        return character;
        
        
    }
    
public static boolean soundBoardEffect (File soundFile) {
    try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            //System.out.println("Got inputstream");
            Clip attack = AudioSystem.getClip();
            //System.out.println("Got clip");
            attack.open(audioIn);
            //System.out.println("Loaded clip");
            attack.start();
            //System.out.println("Played sound");
            return true;
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } finally {
        return false;
    }
}
    
    public static boolean soundBoardLoop (File soundFile) {
    try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            //System.out.println("Got inputstream");
            Clip attack = AudioSystem.getClip();
            //System.out.println("Got clip");
            attack.open(audioIn);
            //System.out.println("Loaded clip");
            attack.start();
            //System.out.println("Played sound");
            return true;
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } finally {
        return false;
    }
}
    
    public static boolean idle (int millisecs) {
        try {
            Thread.sleep(Math.abs(millisecs));
            return true;
        } catch (InterruptedException e) {
            return false;
           }
    }


}