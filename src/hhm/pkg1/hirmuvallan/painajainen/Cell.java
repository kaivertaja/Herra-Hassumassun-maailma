/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhm.pkg1.hirmuvallan.painajainen;

/**
 *
 * @author sysadmin
 */
public class Cell {
    Grid grid; // on what grid does this cell belong to?
    Terrain terrain; // set terrain type (if it matters)
    // boolean occupied; // is the tile occupied by somebody? // it is if there's an occupant
    boolean traversable; // is the tile traversable? Usually defined by terrain
    boolean gateway; // does the tile lead somewhere else (i.e. another grid?)
    int locX; // x-axis index of the cell
    int locY; // y-axis index of the cell
    Character occupant; // if the cell contains a character, it goes here
    
    public Cell (int x, int y, boolean traversable) {
        locX = x;
        locY = y;
        this.traversable = traversable;
    }
    
    public boolean setTerrain (Terrain type) {
        terrain = type;
        return true;
    }
    
}
