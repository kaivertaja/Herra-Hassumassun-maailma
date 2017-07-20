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

// Material class objects are actual physical material lumps 
public class Material {

    public final MaterialType materialType;
    public final boolean exiting;
    public boolean creepified;

    public Material(MaterialType materialType, boolean exiting) {
        this.materialType = materialType;
        this.exiting = exiting;
    }
}
