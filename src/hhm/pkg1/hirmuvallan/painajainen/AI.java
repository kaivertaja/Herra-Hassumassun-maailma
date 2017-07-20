/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhm.pkg1.hirmuvallan.painajainen;
import java.util.*;
/**
 *
 * @author sysadmin
 */
public class AI {

    public static boolean simpleAI(Character character) {
        // idea is simple: give simpleAI a character and it 
        // will attempt to do something (likely just attack)

        /*
        
        Character nearestEnemy = character.nearestEnemy();
        
        int xDiff = character.location.locX - nearestEnemy.location.locX;
        int yDiff = character.location.locY - nearestEnemy.location.locY;       
                
        
        if ()
         */
        return false;
    }

    public static boolean simpleMove(Character character, Cell target) {
        gameTools.idle(300);

        int xDiff = character.location.locX - target.locX;
        int yDiff = character.location.locY - target.locY;

        int destX = character.location.locX;
        int destY = character.location.locY;

        if (Math.abs(xDiff) > Math.abs(yDiff)) {

            if (xDiff < 0) {
                destX++;
            } else if (xDiff > 0) {
                destX--;
            }

        } else if (Math.abs(xDiff) < Math.abs(yDiff)) {
            if (yDiff < 0) {
                destY++;
            } else if (yDiff > 0) {
                destY--;
            }

        } else if (Math.abs(xDiff) == Math.abs(yDiff) && character.location != target) {
            if (yDiff < 0) {
                destY++;
            } else if (yDiff > 0) {
                destY--;
            }
        } else {
            System.out.println("Target cell is the same as character location");
            return false;
        }

        return character.map.tryMove(destX, destY, character);
    }

    public static ArrayList<Cell> calculateRoute (Character character, Cell target) {
        ArrayList<Cell> route = new ArrayList<>();
        
        int xDiff = character.location.locX - target.locX;
        int yDiff = character.location.locY - target.locY;
        
        if (xDiff > yDiff) {
            // move 
        }
        
        
        
        
        return route;
}
 
}
