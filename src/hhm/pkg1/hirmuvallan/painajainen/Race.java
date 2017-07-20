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
public enum Race {

    // player character races
    koipeliini(0,0,0,0, "Koipeliinit", true), // == general PC's and NPC's
    pitkäkorva(0,0,0,0, "Pitkäkorvat", true),
    hybridi(0,0,0,0, "Hybridit", true),
    
    // mechanoids
    konstrukti(0,0,0,0, "Konstruktit", false),
    
    // enemy races
    kasvis(-1,1,0,0, "Kasvikset", false),
    juusto(2,-2,1,-1, "Juustot", false),
    lieriö(0,-1,2,-1, "Lieriöt", false),
    peto(2,-1,-1,0, "Pedot", false),
    osteri(1,-3,2,0, "Osterit", false),
    lennokas(-1,-1,0,2, "Lennokkaat", false);

    // enemyTribe tribe;
    public int str;
    public int wis;
    public int dex;
    public int cha;
    public final boolean PCR;
    public final String raceName;
    

    private Race(int str, int wis, int dex, int cha, String raceName, boolean PCR) {
        this.str = str;
        this.wis = wis;
        this.dex = dex;
        this.cha = cha;
        this.raceName = raceName;
        this.PCR = PCR;
        
    }
}
