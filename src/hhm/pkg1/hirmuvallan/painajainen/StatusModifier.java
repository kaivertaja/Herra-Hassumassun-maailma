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

// status modifiers are TEMPORARY status changes that wear off, are curable, or are bound to an item
// permanent status modifications are handled through feat class (when its done someday)
// @TODO: implement feat class

public enum StatusModifier {
    // battle wounds
    attackHandWound(StatusModifierType.attackModifier, true, new double[] {-0.25, -0.5, -0.75, -1.0}, "attack limb is damaged. Attacks are now weaker"),
    defenceHandWound(StatusModifierType.defenceModifier, true, new double[] {-0.25, -0.5, -0.75, -1.0}, "defending appendage is damaged. Defence is now harder."),
    mobilityLegWound_mov(StatusModifierType.movementModifier, true, new double[] {-0.5, -0.5, -0.75, -0.75}, "mobility leg is damaged. Movement is now slower."),
    mobilityLegWound_def(StatusModifierType.defenceModifier, true, new double[] {-0.25, -0.50, -0.50, -0.75}, "mobility leg is damaged. Defending is now harder due to sluggish moves."),
    supportLegWound_mov(StatusModifierType.movementModifier, true, new double[] {-0.50, -0.50, -0.75, -0.75}, "support leg is damaged. Movement is now slower."),
    supportLegWound_att(StatusModifierType.attackModifier, true, new double[] {-0.25, -0.50, -0.50, -0.75}, "support leg is damaged. Attacking is now harder due to sluggish moves."),
    torsoWound(StatusModifierType.f_curveModifier, false, new double[] {1.0, 2.0, 3.0, 4.0}, "bleeding from torso. F-curve will now be rising every round."),
    headWound(StatusModifierType.hangoverModifier, false, new double[] {1.0, 2.0, 3.0, 4.0}, "sustained head injury. Hangover will now be rising every round."),
    
    
    clairvoyance(StatusModifierType.sightModifier, false, new double[] {1.0}, "is clairvoyant and can see through walls");
    
    
    public final StatusModifierType type;     // status modifier type
    public final boolean isPercentage;        // if false, is integer
    public final double[] handicapStack;      // array of different level handicaps
                                              // array length provides stackability
    public int depth;
    public final String description;
    /*
    int weaponModifier;         // attack power modifier (integer)
    int panzerModifier;         // defence power modifier (integer)
    int diceModifier;           // attack dice modifier (integer, default 1);
    
    int attackModifier;         // attack power modification percent
    int defenceModifier;        // defence power modification percent
    int movementModifier;       // (what the fuck this should do?)
    int fCurveModifier;         // f-curve change (integer) modifier by round (default -1)
    int hangoverModifier;       // hangover change (integer) modifier by round
    int levelModifier;          // level modifier (integer)
    int manaModifier;           // mana modifier (integer)
    
    int strModifier;            // müscle modifier (integer)
    int dexModifier;            // handiness modifier (integer)
    int intModifier;            // cleverness modifier (integer)
    int chaModifier;            // face factor modifier (integer)
    */

    private StatusModifier (StatusModifierType type, boolean isPercentage, double[] handicapStack, String description) {
        this.type = type;
        this.isPercentage = isPercentage;
        this.handicapStack = handicapStack;
        this.description = description;
        this.depth = 1;
    }
    
    
    
   
}
