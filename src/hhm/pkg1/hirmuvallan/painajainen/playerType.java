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

// THIS CLASS WOULD BE NAMED 'CharacterClass' BUT JAVA CLASSES CAN'T BE NAMED 'Class'

public enum playerType {
    inkvisiittori(3),
    kapinallinen(4),
    kepuli(4),
    luikuri(1),
    pastori(1),
    pioneeri(3),
    ritari(6),
    rosmo(6),
    soturi(6),
    trulli(1),
    vouti(4),
    yrtisti(3);
    
    public final int maxThudDice;
    // public final int classPath;
    
    private playerType (int maxDice) {
        this.maxThudDice = maxDice;
        
    }
    
    
}
