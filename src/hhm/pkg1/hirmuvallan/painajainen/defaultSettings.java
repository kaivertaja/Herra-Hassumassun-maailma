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
public class defaultSettings {
    // because these are the default settings,
    // there's pretty much just a FUCKLOAD of
    // variables being initialized here

    // FIRST: define everything the actual game might need as a template
    // public player character races
    
    

    // public character classes
   

    // public materials
   
    
    // public weapons
    
    // public panzers
    
    // public wearables

    // public default battle statuses
    
    /*
    public StatusModifier attackLimbDamage1;
    public StatusModifier attackLimbDamage2;
    public StatusModifier attackLimbDamage3;
    public StatusModifier attackLimbDamage4;

    public StatusModifier defenceLimbDamage;
    public StatusModifier mobilityLimbDamage1;
    public StatusModifier supportLimbDamage;
    public StatusModifier torsoDamage;
    public StatusModifier headDamage;

    public StatusModifier diceModifier;

    */
    
    public defaultSettings() {
        // there is no need for constructor
    }

    public static void initialize() {
        // make things happen
    }

    /*
    private void createClasses() {
        inkvisiittori = new charClass();
        kapinallinen = new charClass();
        kepuli = new charClass();
        luikuri = new charClass();
        pastori = new charClass();
        pioneeri = new charClass();
        ritari = new charClass();
        rosmo = new charClass();
        soturi = new charClass();
        trulli = new charClass();
        vouti = new charClass();
        yrtisti = new charClass();
    }

    */
    private void createMonsters() {

    }

    private void createPCs() {

    }

    private void createModifiers() {
        
        /*
        attackLimbDamage1 = new StatusModifier("Attack limb damage 1");
        attackLimbDamage1.attackModifier = -25;
        attackLimbDamage2 = new StatusModifier("Attack limb damage 2");
        attackLimbDamage2.attackModifier = -50;
        attackLimbDamage3 = new StatusModifier("Attack limb damage 3");
        attackLimbDamage3.attackModifier = -75;
        attackLimbDamage4 = new StatusModifier("Attack limb damage 4");
        attackLimbDamage4.attackModifier = -100;

        defenceLimbDamage = new StatusModifier("Defence limb damage 1");
        defenceLimbDamage.defenceModifier = -25;

        mobilityLimbDamage1 = new StatusModifier("Mobility limb damage 1");
        mobilityLimbDamage1.movementModifier = -50;
        mobilityLimbDamage1.attackModifier = -25;

        supportLimbDamage = new StatusModifier("Support limb damage 1");
        torsoDamage = new StatusModifier("Torso damage 1");
        headDamage = new StatusModifier("Head damage 1");

        diceModifier = new StatusModifier("Extra thud dices");
        diceModifier.diceModifier = 1;
        */
    }

    /*
    private void createMaterials() {
        laziness = new material();
        wool = new material();
        wood = new material();
        plastic = new material();
        blasce = new material();
        diamang = new material();

        element laziness = element.laziness;
        element.laziness.creepified = true;
        laziness.exiting = true;
        int whee = element.diamang.againstDiamang;
    }
*/

    /*
    private void createWeapons() {
        weapon vispilä = new weapon(1, 1, "Vispilä", 1, plastic, diamang, laziness);
        weapon pistin = new weapon(1, 1, "Pistin", 1, diamang, wood, wool);
        weapon ruuantähde = new weapon(1, 1, "Ruuantähde", 1, laziness, wood, blasce);
        weapon rautalinko = new weapon(2, 10, "Vispilä", 1, wool, diamang, blasce);
        weapon astalo = new weapon(1, 1, "Astalo", 2, wood, plastic, diamang);
        weapon kävelykeppi = new weapon(1, 1, "Kävelyheppi", 2, wood, blasce, wool);
        weapon kalpa = new weapon(1, 1, "Kalpa", 2, diamang, wood, wool);
        weapon väkipuukko = new weapon(1, 1, "Väkipuukko", 2, blasce, wood, plastic);
        weapon kettinki = new weapon(1, 1, "Kettinki", 3, plastic, diamang, wood);
        weapon käsipultti = new weapon(2, 10, "Käsipultti", 3, wool, blasce, plastic);
        weapon atrain = new weapon(1, 10, "Atrain", 3, laziness, plastic, wood);
        weapon hilpari = new weapon(1, 1, "Hilpari", 3, blasce, laziness, wool);

    }

*/
    private void createPanzers() {
        
    }

    public void execute() {
        // running this method will init generic assets using set values
        // note that the values can be modified before init
        this.createMonsters();
        //this.createClasses();
        this.createPCs();
        this.createModifiers();

    }

}
