package hhm.pkg1.hirmuvallan.painajainen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sysadmin
 */
public enum Path {
    Athos(playerType.ritari),
    Porthos(playerType.ritari),
    Aramis(playerType.ritari),
    Ronin(playerType.soturi),
    Svaabi(playerType.soturi),
    Hakkapeliitta(playerType.soturi),
    Väijyjä(playerType.rosmo),
    Speduiini(playerType.rosmo),
    Päällekarkaaja(playerType.rosmo),
    V(playerType.kapinallinen),
    Machete(playerType.kapinallinen),
    Hellsingius(playerType.kapinallinen),
    Metsästäjä(playerType.vouti),
    Keräilijä(playerType.vouti),
    Rautahanska(playerType.vouti),
    Arpin(playerType.kepuli),
    Farran(playerType.kepuli),
    Tonks(playerType.kepuli),
    Saalistaja(playerType.inkvisiittori),
    Tuomari(playerType.inkvisiittori),
    Pyöveli(playerType.inkvisiittori),
    Puoskari(playerType.yrtisti),
    Välskäri(playerType.yrtisti),
    Apteekkari(playerType.yrtisti),
    PUM(playerType.pioneeri),
    klik(playerType.pioneeri),
    klang_klang(playerType.pioneeri),
    Apotti(playerType.pastori),
    Saarnaaja(playerType.pastori),
    Suntio(playerType.pastori),
    Klassinen(playerType.luikuri),
    Hevi(playerType.luikuri),
    Iskelmä(playerType.luikuri),
    Myrddin(playerType.trulli),
    Malich(playerType.trulli),
    Raistlin(playerType.trulli);
////////////////////////////////////
    
    public final playerType charClass;
    
    private Path (playerType charClass) {
        this.charClass = charClass;

    }

}
