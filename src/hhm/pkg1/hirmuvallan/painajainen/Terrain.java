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
public enum Terrain {
    // built areas
    cityStreet("city street", true, 1),
    cityBuilding("building", false, 0),
    
    // door
    // @TODO: how should doors work?
    door("door", false, 0),
    // interiors
    interiorOpen("building interior", true, 1),
    interiorObstacle("miscellaneous object", false, 0.9),
    interiorWall("interior wall", false, 0),
    
    
    // open terrains
    grassland("grassland", true, 0),
    farmland("farmland", true, 0.1),
    desert("desert", true, 0.1),
    
    // heavy vegetation terrains
    forest("forest", true, 0.3),
    jungle("jungle", true, 0.5),
    swamp("swamp", true, 0.4),
    
    // heavy elevation terrains
    
    fell("fell", true, 0.1),
    mountain("mountain", true, 0.1),
    
    // water areas
    pond("pond", false, 0.1),
    river("river", false, 0.2),
    ocean("ocean", false, 0);

    // variables
    public final String terrainName;
    public final boolean traversable;
    public final double visibility;
    
    private Terrain (String terrainName, boolean traversable, double visibility) {
        this.terrainName = terrainName;
        this.traversable = traversable;
        this.visibility = visibility;
    }
}
