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
public class Weapon {
    public MaterialType materialType;
    public Material material;
    public WeaponType weaponClass;
    public int powerConstant;
    
    public Weapon(WeaponType weaponClass, Material material) {
        this.weaponClass = weaponClass;
        this.materialType = material.materialType;
        this.material = material;
        materialModifier();
        
    }
    
    private void materialModifier() {
        if (weaponClass.optimum == materialType) {
            powerConstant = 3;
        } else if (weaponClass.bad == materialType) {
            powerConstant = -1;
        } else if (weaponClass.awful == materialType) {
            powerConstant = -2;
        } else {
            powerConstant = 0;
        }
        
        if (material.exiting) {
            powerConstant++;
        }
        if (material.creepified) {
            powerConstant = powerConstant + 2;
        }
    }
}
