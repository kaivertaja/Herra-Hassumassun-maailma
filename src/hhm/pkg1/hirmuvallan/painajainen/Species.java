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
    Omena(Tribe.hedelmä, "omena"),
    Kiivi(Tribe.hedelmä, "kiivi"),
    Melooni(Tribe.hedelmä, "melooni"),
    Mango(Tribe.hedelmä, "mango"),
    Guava(Tribe.hedelmä, "guava"),
    Ananasbanaani(Tribe.hedelmä, "ananasbanaani"),
    // kasvikset, sporofyytit
    Papu(Tribe.sporofyytti, "papu"),
    Kookospähkinä(Tribe.sporofyytti, "kookospähkinä"),
    Riisi(Tribe.sporofyytti, "riisi"),
    Hernes(Tribe.sporofyytti, "hernes"),
    Kurkuma(Tribe.sporofyytti, "kurkuma"),
    Linssi(Tribe.sporofyytti, "linssi"),
    // kasvikset, juurekset
    Porkkana(Tribe.juures, "porkkana"),
    Peruna(Tribe.juures, "peruna"),
    Lanttu(Tribe.juures, "lanttu"),
    Retikka(Tribe.juures, "retikka"),
    Laukka(Tribe.juures, "laukka"),
    Bataatti(Tribe.juures, "bataatti"),
    // kasvikset, lehtevät
    Ketunleipä(Tribe.lehtevä, "ketunleipä"),
    Minttu(Tribe.lehtevä, "minttu"),
    Kaali(Tribe.lehtevä, "kaali"),
    Pinaatti(Tribe.lehtevä, "pinaatti"),
    Basilika(Tribe.lehtevä, "basilika"),
    Persilja(Tribe.lehtevä, "persilja"),
    // JUUSTOT
    // juustot, fetajuustot
    Telemakhos(Tribe.fetajuusto, "telemakhos"),
    Tyfon(Tribe.fetajuusto, "tyfon"),
    Faidra(Tribe.fetajuusto, "faidra"),
    Aigeus(Tribe.fetajuusto, "aigeus"),
    Helles(Tribe.fetajuusto, "helles"),
    Melantho(Tribe.fetajuusto, "melantho"),
    // juustot, kermajuustot
    Laufey(Tribe.kermajuusto, "laufey"),
    Surtur(Tribe.kermajuusto, "surtur"),
    Rindr(Tribe.kermajuusto, "rindr"),
    Lifthrasir(Tribe.kermajuusto, "lifthrasir"),
    Embla(Tribe.kermajuusto, "embla"),
    Heidrun(Tribe.kermajuusto, "heidrun"),
    // juustot, sulatejuustot
    Blanchefleur(Tribe.kermajuusto, "blanchefleur"),
    Adhan(Tribe.kermajuusto, "adhan"),
    Culhwch(Tribe.kermajuusto, "culhwch"),
    Dindrane(Tribe.kermajuusto, "dindrane"),
    Gingalain(Tribe.kermajuusto, "gingalain"),
    Igraine(Tribe.kermajuusto, "igraine"),
    // juustot, homejuustot
    Aude(Tribe.homejuusto, "aude"),
    Pinabel(Tribe.homejuusto, "pinabel"),
    Bramimonde(Tribe.homejuusto, "bramimonde"),
    Bertrada(Tribe.homejuusto, "bertrada"),
    Grandoyne(Tribe.homejuusto, "grandoyne"),
    Othon(Tribe.homejuusto, "othon"),
    // juustot, juustonaksut
    Turso(Tribe.juustonaksu, "turso"),
    Äkräs(Tribe.juustonaksu, "äkräs"),
    Nonttu(Tribe.juustonaksu, "nonttu"),
    Raako(Tribe.juustonaksu, "raako"),
    Lalli(Tribe.juustonaksu, "lalli"),
    Inehmo(Tribe.juustonaksu, "inehmo"),
    // juustot, raasteet
    Vitsojaana(Tribe.raaste, "vitsojaana"),
    Annitammi(Tribe.raaste, "annitammi"),
    Katinkaivo(Tribe.raaste, "katinkaivo"),
    Lepakkomestari(Tribe.raaste, "lepakkomestari"),
    Aurinkoskidi(Tribe.raaste, "aurinkoskidi"),
    Ronipapu(Tribe.raaste, "ronipapu");

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
