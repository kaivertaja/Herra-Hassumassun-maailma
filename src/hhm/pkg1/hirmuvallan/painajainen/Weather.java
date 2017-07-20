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
public enum Weather {
    sees("merevä", MaterialType.laziness, 0.0),
    pouta("kelmeä", MaterialType.plastic, 0.05),
    pilvinen("töpöisä", MaterialType.wool, 0.2),
    kuuroinen("pölöjä", MaterialType.wood, 0.5),
    myrskyisä("haipakka", MaterialType.teel, 0.6),
    hirmumyrsky("garmiwa", MaterialType.diamang, 0.8),
    sisätila("tasainen", null, 0.0);
    
    // variables
    public double visibility;
    public MaterialType elementBoost;
    public String description;
    
    private Weather (String description, MaterialType elementBoost, double visibility) {
        this.elementBoost = elementBoost;
        this.description = description;
    }
}
