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
public enum armWall {
    parmula(1, MaterialType.wood, 1),
    clipeus(1, MaterialType.diamang, 2),
    mjääh(2, MaterialType.laziness, 0),
    adarga(2, MaterialType.wool, 6),
    scutum(3, MaterialType.plastic, 4),
    hoplon(3, MaterialType.teel, 2);
    
    public final int size;
    public final MaterialType material;
    public final int defenceModifier;
    
    private armWall(int size, MaterialType material, int defenceModifier) {
        this.size = size;
        this.material = material;
        this.defenceModifier = defenceModifier;
    }
}
