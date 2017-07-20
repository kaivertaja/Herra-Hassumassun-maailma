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
public class Panzer {

    public MaterialType materialType;
    public Material material;
    public PanzerType panzerClass;
    public int powerConstant;

    public Panzer(PanzerType panzerClass, Material material) {
        this.panzerClass = panzerClass;
        this.materialType = material.materialType;
        this.material = material;
        materialModifier();

    }

    private void materialModifier() {
        if (panzerClass.optimum == materialType) {
            powerConstant = 1;
        } else {
            powerConstant = -2;
        }

        if (material.exiting) {
            powerConstant++;
        }
        if (material.creepified) {
            powerConstant = powerConstant + 2;
        }
    }
}
