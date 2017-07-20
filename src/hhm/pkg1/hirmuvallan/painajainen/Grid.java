/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhm.pkg1.hirmuvallan.painajainen;
import static hhm.pkg1.hirmuvallan.painajainen.battleFunctions.*;

import java.util.*;

// import java.util.Arrays;

/**
 *
 * @author sysadmin
 */
public class Grid {

    int gridWidth;
    int gridHeight;
    int cellCount;
    String name;
    public Cell[][] gridArray;
    
    public Time timeOfDay;
    public Day weekday;
    public Weather weather;
    
    
    public Grid(int width, int height) {
        gridWidth = width;
        gridHeight = height;
        cellCount = width * height;
        int x = 0;
        int y = 0;
        gridArray = new Cell[width][height];

        for (int i = 0; i < cellCount; i++) {
            if (x >= gridWidth) {
                //System.out.println("Exceeding x-axis, flip row");
                y++;
                x = 0;
            }
            // System.out.println("Writing cell #" + i + " to [" + x + "," + y + "]");
            gridArray[x][y] = new Cell(x, y, true);
            x++;
        }
        System.out.println("The grid is ready");

        gameTools gameTools = new gameTools();
    }

    public Character[] getOccupantList() {
        // find all creatures on map
        // @TODO: use arraylist instead of array
        int occupants = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < cellCount; i++) {
            if (x >= gridWidth) {
                //System.out.println("Exceeding x-axis, flip row");
                y++;
                x = 0;
            }

            if (gridArray[x][y].occupant != null) {
                occupants++;
            }

            x++;
        }

        // store all creatures to an array
        Character[] creatureList = new Character[occupants];
        x = 0;
        y = 0;
        int index = 0;
        for (int i = 0; i < cellCount; i++) {
            if (x >= gridWidth) {
                //System.out.println("Exceeding x-axis, flip row");
                y++;
                x = 0;
            }

            if (gridArray[x][y].occupant != null) {
                creatureList[index] = gridArray[x][y].occupant;
                index++;
            }
            x++;
        }

        return creatureList;
    }
    
        public ArrayList<Character> getOccupantArrayList() {  
        // find all creatures on map
        ArrayList<Character> occupantList = new ArrayList<>();
        int x = 0;
        int y = 0;
        for (int i = 0; i < cellCount; i++) {
            if (x >= gridWidth) {
                //System.out.println("Exceeding x-axis, flip row");
                y++;
                x = 0;
            }
            if (gridArray[x][y].occupant != null) {
                occupantList.add(gridArray[x][y].occupant);
            }
            x++;
        }


        return occupantList;
    }

    public boolean setOccupant(Character occupant, int x, int y) {
        if (gridArray[x][y].occupant == null) {
            gridArray[x][y].occupant = occupant;
            occupant.location = gridArray[x][y];
            occupant.map = this;
            System.out.println("Setting " + occupant.fullName + " to map");
            return true;
        } else {
            System.out.println("The tile at [" + x + "," + y + "] is already occupied by " + gridArray[x][y].occupant.fullName);
            return false;
        }
    }

    public boolean deleteOccupant(Character occupant, int x, int y) {
        if (gridArray[x][y].occupant != null) {
            gridArray[x][y].occupant = null;
            occupant.location = null;
            occupant.map = null;
            return true;
        } else {
            System.out.println("There's nothing to remove");
            return false;
        }

    }

    public boolean moveTo(Character character, int direction) {
        if (!character.alive) {
            System.out.println(character.fullName + " is dead and therefore not allocated anywhere. You shouldn't call this method with dead characters");
            return false;
        }
        if (character.dying) {
            System.out.println(character.fullName + " is in katatonia and unable to move");
            return false;
        }
        
        
        System.out.println("Moving from [" + character.location.locX + "," + character.location.locY + "]");
        int toX = -1;
        int toY = -1;

        switch (direction) {
            case 1:
                //System.out.println("Going southwest");
                toX = character.location.locX - 1;
                toY = character.location.locY + 1;
                break;
            case 2:
                //System.out.println("Going south");
                toX = character.location.locX;
                toY = character.location.locY + 1;
                break;
            case 3:
                toX = character.location.locX + 1;
                toY = character.location.locY + 1;
                break;
            case 4:
                toX = character.location.locX - 1;
                toY = character.location.locY;
                break;
            case 5:
                // pass (don't move)
                System.out.println("You decide to stand still");
                toX = character.location.locX;
                toY = character.location.locY;
                break;
            case 6:
                toX = character.location.locX + 1;
                toY = character.location.locY;
                break;
            case 7:
                toX = character.location.locX - 1;
                toY = character.location.locY - 1;
                break;
            case 8:
                toX = character.location.locX;
                toY = character.location.locY - 1;
                break;
            case 9:
                toX = character.location.locX + 1;
                toY = character.location.locY - 1;
                break;
            default:
                System.out.println("Your input is not valid");
                return false;
        }

        return (tryMove(toX, toY, character));

    }

    public boolean tryMove(int toX, int toY, Character character) {
        // note: illegal move means losing your turn
        System.out.println("Trying to move to [" + toX + "," + toY + "]");

        if (moveLegality(toX, toY, character)) {
            // gridArray[character.location.locX][character.location.locY] = null;
            gridArray[character.location.locX][character.location.locY].occupant = null;
            gridArray[toX][toY].occupant = character;
            character.location = gridArray[toX][toY];
            System.out.println("Move successful");
            return true;
        } else {
            return false;
        }

    }

    private boolean moveLegality(int toX, int toY, Character character) {
        // implement handling of map edges
        try {
            boolean i = gridArray[toX][toY].traversable;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You're trying to move off map");
            //character.map.draw();
            return false;
        }

        if (!gridArray[toX][toY].traversable) {
            System.out.println("Destination cell is not traversable");
            return false;
        } else if (gridArray[toX][toY].occupant == null) {
            System.out.println("Destination cell is empty, move is legal");
            return true;
        } else if (gridArray[toX][toY].occupant.team == character.team) {
            System.out.println("Destination cell is occupied by a friendly, " + gridArray[toX][toY].occupant.fullName);
            return false;
        } else if (gridArray[toX][toY].occupant.team != character.team) {
            System.out.println("Destination cell contains an enemy. You are attacking.");
            //gameTools.attack(character, gridArray[toX][toY].occupant);
            battleFunctions.attack(character, gridArray[toX][toY].occupant);
            return false;
        }
        return false;

    }
    
    public int calculateDistance (Cell from, Cell to) {
        int xDiff = Math.abs(to.locX - from.locX);
        int yDiff = Math.abs(to.locY - from.locY);
        
        if (yDiff > xDiff) {
            return yDiff;
        } else {
            return xDiff;
        }
    }

    public void draw() {
        int x = 0;
        int y = 0;

        // cell string must be exactly 9 characters
        String cellString1 = "         ";
        String cellString2 = "         ";
        String cellString3 = "         ";
        String cellString4 = "         ";

        // 1st line
        int r = 0;
        System.out.print("_");
        while (r < gridWidth) {

            for (int i = 0; i < 10; i++) {
                System.out.print("_");
            }

            r++;
        }
        System.out.print("\n");

        for (int f = 0; f < gridHeight; f++) {

            // @TODO: see rows below
            // 2nd line
            // -get rid of coordinates
            // -print character status or terrain
            r = 0;
            System.out.print("|");
            while (r < gridWidth) {
                System.out.print("[" + x + "," + y + "]    " + "|");
                x++;
                r++;
            }
            x = 0;
            System.out.print("\n");

            // 3rd line
            // print character name or terrain
            r = 0;
            System.out.print("|");
            while (r < gridWidth) {
                if (gridArray[x][y].occupant != null) {
                    System.out.print(" " + gridArray[x][y].occupant.name + " |");
                } else {
                    System.out.print(cellString2 + "|");
                }
                x++;

                r++;
            }
            System.out.print("\n");
            x = 0;

            // 4th line
            r = 0;
            System.out.print("|");
            while (r < gridWidth) {
                System.out.print(cellString3 + "|");

                r++;
            }
            System.out.print("\n");

            // 5th line
            r = 0;
            System.out.print("|");
            while (r < gridWidth) {
                System.out.print(cellString4 + "|");

                r++;
            }
            System.out.print("\n");

            // 6th line
            r = 0;
            System.out.print("|");
            while (r < gridWidth) {

                for (int i = 1; i < 10; i++) {
                    System.out.print("_");
                }
                System.out.print("|");
                r++;
            }
            System.out.print("\n");

            y++;
        }

    }
}
