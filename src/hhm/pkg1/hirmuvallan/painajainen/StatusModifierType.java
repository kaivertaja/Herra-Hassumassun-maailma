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

// StatusModifierType defines modifier types for other classes to use
// i.e. attack functions should check all attackModifier-type StatusModifiers
// on attacking character

public enum StatusModifierType {
    attackModifier,
    defenceModifier,
    manaModifier,
    diceModifier,
    movementModifier,
    
    weaponFunctionModifier,
    panzerFunctionModifier,
    
    strModifier,
    wisModifier,
    dexModifier,
    chaModifier,
    
    levelModifier,
    hangoverModifier,
    f_curveModifier,
    
    sightModifier;
    
    
    private StatusModifierType () {
        
    }
    
    
    
}
