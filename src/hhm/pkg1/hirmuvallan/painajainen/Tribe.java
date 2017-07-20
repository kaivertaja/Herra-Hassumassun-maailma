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
public enum Tribe {
    // The point here is to define all the species that belong to each tribe.
    // Method spawnEnemy (or something) can then be used to randomize
    // the actual creature that is spawned.
    
    // PCR tribes
    pösilö(Race.koipeliini, "Pösilöt", 2, 0, -2, 2),
    rumilus(Race.koipeliini, "Rumilukset", 0, 1, 5, -4),
    pula_aho(Race.koipeliini, "Pula-ahot", -2, 3, 1, -1),
    hanu(Race.koipeliini, "Hanut", 4, -2, -4, 4),
    hassutassu(Race.koipeliini, "Hassutassut", 3, -1, 2, -2),
    pöllökarhu(Race.koipeliini, "Pöllökarhut", -2, 1, 2, 1),
    
    pupu(Race.pitkäkorva, "Puput", 0, 0, 0, 0),
    jänis(Race.pitkäkorva, "Jänikset", 0, 0, 0, 0),
    rusakko(Race.pitkäkorva, "Rusakot", 0, 0, 0, 0),
    kanit(Race.pitkäkorva, "Kanit", 0, -2, +2, +1), // Ölli
    kengurut(Race.pitkäkorva, "Kengurut", 0, 0, 0, 0),
    knarkit(Race.pitkäkorva, "Korkeanopeuksiset alienirumpukanit", 0, 0, 0, 0),
   
    hybridit(Race.hybridi, "Hybridi", 0, 0, 0, 0),
   
    // constructs
    kaani(Race.konstrukti, "Kaani", 0,0,0,0),
    
    // enemy tribes
    // kasvikset
    marja(Race.kasvis, "Marjat", 0, 0, 0, 1),
    hapatus(Race.kasvis, "Hapatukset", 0, 0, 1, 0),
    hedelmä(Race.kasvis, "Hedelmät", 0, 0, 1, 0),
    sporofyytti(Race.kasvis, "Sporofyytit", 0, 1, 0, 0),
    juures(Race.kasvis, "Juurekset", 1, 0, 0, 0),
    lehtevä(Race.kasvis, "Lehtevät", 0, 0, 0, 1),
    // juustot
    fetajuusto(Race.juusto, "Fetajuustot", 0, 1, 0, 0),
    kermajuusto(Race.juusto, "Kermajuustot", 0, 0, 0, 1),
    sulatejuusto(Race.juusto, "Sulatejuustot", 0, 0, 0, 1),
    homejuusto(Race.juusto, "Homejuustot", 1, 0, 0, 0),
    juustonaksu(Race.juusto, "Juustonaksut", 0, 0, 1, 0),
    raaste(Race.juusto, "Raasteet", 0, 0, 1, 0),
    // sylinterit
    pönäkkä(Race.lieriö, "Pönäkät", 1, 0, 0, 0),
    väriliitu(Race.lieriö, "Väriliidut", 0, 0, 0, 1),
    lisko(Race.lieriö, "Liskot", 0, 0, 1, 0),
    parasiittiö(Race.lieriö, "Parasiittiöt", 0, 1, 0, 0),
    toukka(Race.lieriö, "Toukat", 1, 0, 0, 0),
    vieteri(Race.lieriö, "Vieterit", 0, 1, 0, 0),
    // pedot
    hammaskeijo(Race.peto, "Hammaskeijot", 0, 0, 1, 0),
    töpökämmen(Race.peto, "Töpökämmenet", 1, 0, 0, 0),
    fantti(Race.peto, "Fantit", 1, 0, 0, 0),
    jylsijä(Race.peto, "Jylsijät", 0, 1, 0, 0),
    pieni_eläin(Race.peto, "Pienet eläimet", 0, 0, 0, 1),
    AKNMP(Race.peto, "Aivokuolleet Neuvostomutanttipäästäiset", 0, 1, 0, 0),
    // osterit
    tärppä(Race.osteri, "Tärpät", 0, 0, 1, 0),
    mustekala(Race.osteri, "Mustekalat", 1, 0, 0, 0),
    strutsi(Race.osteri, "Strutsit", 0, 0, 0, 1),
    käkirousku(Race.osteri, "Käkirouskut", 0, 1, 0, 0),
    viemäriseepra(Race.osteri, "Viemäriseeprat", 0, 0, 1, 0),
    tohveli(Race.osteri, "Tohvelit", 0, 0, 0, 1),
    // lennokkaat
    lepakko(Race.lennokas, "Lepakot", 1, 0, 0, 0),
    ötökkä(Race.lennokas, "Ötökät", 0, 0, 1, 0),
    poliittinen_broileri(Race.lennokas, "Poliittiset broilerit", 0, 0, 0, 1),
    lintunen(Race.lennokas, "Lintuset", 0, 0, 0, 1),
    lentävä_moottorisaha(Race.lennokas, "Lentävät moottorisahat", 1, 0, 0, 0),
    laiskiainen(Race.lennokas, "Laiskiaiset", 0, 1, 0, 0);
    

    ////////////////////////////////////
    public Race race;

    public int str;
    public int wis;
    public int dex;
    public int cha;
    public final String tribeName;
   

    private Tribe(Race race, String tribeName, int str, int wis, int dex, int cha) {
        this.race = race;
        this.tribeName = tribeName;

        this.str = str;
        this.wis = wis;
        this.dex = dex;
        this.cha = cha;
        
       
    }
}
