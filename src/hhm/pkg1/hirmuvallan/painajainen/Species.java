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
public enum Species {
    // PELATTAVAT RODUT
    defaultPösilö(Tribe.pösilö, "pösilö"),
    defaultRumilus(Tribe.rumilus, "rumilus"),
    defaultPula_aho(Tribe.pula_aho, "pula-aho"),
    defaultHanu(Tribe.hanu, "hanu"),
    defaultHassutassu(Tribe.hassutassu, "hassutassu"),
    defaultPöllökarhu(Tribe.pöllökarhu, "pöllökarhu"),
    // PUPUT
    defaultSpecial(Tribe.pupu, "pupu"),
    
    // KAANIT
    domini(Tribe.kaani, "domini"),
    astra(Tribe.kaani, "astra"),
    peli(Tribe.kaani, "peli"),
    mohi(Tribe.kaani, "mohi"),
    tsingis(Tribe.kaani, "tsingis"),
    hurri(Tribe.kaani, "hurri"),
    
    // KASVIKSET
    // kasvikset, marjat
    Mustikka(Tribe.marja, "mustikka"),
    Tyrni(Tribe.marja, "tyrni"),
    Puolukka(Tribe.marja, "puolukka"),
    Vatelma(Tribe.marja, "vatelma"),
    Mantsikka(Tribe.marja, "mantsikka"),
    Tomaatti(Tribe.marja, "tomaatti"),
    // kasvikset, hapatukset
    Sitruuna(Tribe.hapatus, "sitruuna"),
    Lime(Tribe.hapatus, "lime"),
    Raparperi(Tribe.hapatus, "raparperi"),
    Hulluruoho(Tribe.hapatus, "hulluruoho"),
    Levä(Tribe.hapatus, "levä"),
    Melissa(Tribe.hapatus, "melissa"),
    // @TODO: muuuttujien nimet yksikkömuotoon
    // kasvikset, hedelmät
    Omenat(Tribe.hedelmä, "omena"),
    Kiivit(Tribe.hedelmä, "kiivi"),
    Meloonit(Tribe.hedelmä, "melooni"),
    Mangot(Tribe.hedelmä, "mango"),
    Guavat(Tribe.hedelmä, "guava"),
    Ananasbanaanit(Tribe.hedelmä, "ananasbanaani"),
    // kasvikset, sporofyytit
    Pavut(Tribe.sporofyytti, "papu"),
    Kookospähkinät(Tribe.sporofyytti, "kookospähkinä"),
    Riisit(Tribe.sporofyytti, "riisi"),
    Hernekset(Tribe.sporofyytti, "hernes"),
    Kurkumat(Tribe.sporofyytti, "kurkuma"),
    Linssit(Tribe.sporofyytti, "linssi"),
    // kasvikset, juurekset
    Porkkanat(Tribe.juures, "porkkana"),
    Perunat(Tribe.juures, "peruna"),
    Lantut(Tribe.juures, "lanttu"),
    Retikat(Tribe.juures, "retikka"),
    Laukat(Tribe.juures, "laukka"),
    Bataatit(Tribe.juures, "bataatti"),
    // kasvikset, lehtevät
    Ketunleivät(Tribe.lehtevä, "ketunleipä"),
    Mintut(Tribe.lehtevä, "minttu"),
    Kaalit(Tribe.lehtevä, "kaali"),
    Pinaatit(Tribe.lehtevä, "pinaatti"),
    Basilikat(Tribe.lehtevä, "basilika"),
    Persiljat(Tribe.lehtevä, "persilja"),
    // JUUSTOT
    // juustot, fetajuustot
    Telemakhokset(Tribe.fetajuusto, "telemakhos"),
    Tyfonit(Tribe.fetajuusto, "tyfon"),
    Faidrat(Tribe.fetajuusto, "faidra"),
    Aigeukset(Tribe.fetajuusto, "aigeus"),
    Helleet(Tribe.fetajuusto, "helles"),
    Melanthot(Tribe.fetajuusto, "melantho"),
    // juustot, kermajuustot
    Laufeyt(Tribe.kermajuusto, "laufey"),
    Surturit(Tribe.kermajuusto, "surtur"),
    Rindrit(Tribe.kermajuusto, "rindr"),
    Lifthrasirit(Tribe.kermajuusto, "lifthrasir"),
    Emblat(Tribe.kermajuusto, "embla"),
    Heidrunit(Tribe.kermajuusto, "heidrun"),
    // juustot, sulatejuustot
    Blanchefleurit(Tribe.kermajuusto, "blanchefleur"),
    Adhanit(Tribe.kermajuusto, "adhan"),
    Culhwchit(Tribe.kermajuusto, "culhwchit"),
    Dindranet(Tribe.kermajuusto, "dindrane"),
    Gingalainit(Tribe.kermajuusto, "gingalain"),
    Igrainet(Tribe.kermajuusto, "igraine"),
    // juustot, homejuustot
    Audet(Tribe.homejuusto, "aude"),
    Pinabelit(Tribe.homejuusto, "pinabel"),
    Bramimondet(Tribe.homejuusto, "bramimonde"),
    Bertradat(Tribe.homejuusto, "bertrada"),
    Grandoynet(Tribe.homejuusto, "grandoyne"),
    Othonit(Tribe.homejuusto, "othon"),
    // juustot, juustonaksut
    Tursot(Tribe.juustonaksu, "turso"),
    Äkräskset(Tribe.juustonaksu, "äkräs"),
    Nontut(Tribe.juustonaksu, "nonttu"),
    Raakot(Tribe.juustonaksu, "raako"),
    Lallit(Tribe.juustonaksu, "lalli"),
    Inehmot(Tribe.juustonaksu, "inehmo"),
    // juustot, raasteet
    Vitsojaanat(Tribe.raaste, "vitsojaana"),
    Annitammet(Tribe.raaste, "annitammi"),
    Katinkaivot(Tribe.raaste, "katinkaivo"),
    Lepakkomestarit(Tribe.raaste, "lepakkomestari"),
    Aurinkoskidit(Tribe.raaste, "aurinkoskidi"),
    Ronipavut(Tribe.raaste, "ronipapu");

    // @TODO: specify the rest of the species
    // LIERIÖT
    // 
    // 
    // 
    // 
    // 
    // 
    // PEDOT
    //
    //
    //
    //
    //
    //
    // OSTERIT
    //
    //
    //
    //
    //
    //
    // LENNOKKAAT
    // 
    // 
    // 
    // 
    // 
    // 
    ////////////////////////////////////////////
    public final Tribe tribe;
    public final String speciesName;

    public int str;
    public int wis;
    public int dex;
    public int cha;

    public playerType defaultClass;

// juustot, kermajuustot
    private Species(Tribe tribe, String speciesName) {
        this.tribe = tribe;
        this.speciesName = speciesName;

        // set these when all species are specified
        this.str = 0;
        this.wis = 0;
        this.dex = 0;
        this.cha = 0;
        this.defaultClass = null;

    }

}
