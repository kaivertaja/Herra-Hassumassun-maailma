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
public enum PanzerType {
    pyjama(0, MaterialType.laziness),
    kaapu(0, MaterialType.laziness),
    tunika(0, MaterialType.wool),
    paita(1, MaterialType.wool),
    nuttu(1, MaterialType.wood),
    takki(1, MaterialType.wood),
    saketti(2, MaterialType.plastic),
    mekko(2, MaterialType.plastic),
    anorakki(2, MaterialType.teel),
    trenssi(3, MaterialType.teel),
    ulsteri(3, MaterialType.diamang),
    mantteli(3, MaterialType.diamang);

    public final int strength;
    public final MaterialType optimum;

    private PanzerType(int strength, MaterialType optimum) {
        this.strength = strength;
        this.optimum = optimum;
    }
}
