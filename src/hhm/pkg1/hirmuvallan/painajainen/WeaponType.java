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
public enum WeaponType {
    vispilä(1, 1, "Vispilä", 1, MaterialType.plastic, MaterialType.diamang, MaterialType.laziness),
    pistin(1, 1, "Pistin", 1, MaterialType.diamang, MaterialType.wood, MaterialType.wool),
    ruuantähde(1, 1, "Ruuantähde", 1, MaterialType.laziness, MaterialType.wood, MaterialType.teel),
    rautalinko(2, 10, "Vispilä", 1, MaterialType.wool, MaterialType.diamang, MaterialType.teel),
    astalo(1, 1, "Astalo", 2, MaterialType.wood, MaterialType.plastic, MaterialType.diamang),
    kävelykeppi(1, 1, "Kävelyheppi", 2, MaterialType.wood, MaterialType.teel, MaterialType.wool),
    kalpa(1, 1, "Kalpa", 2, MaterialType.diamang, MaterialType.wood, MaterialType.wool),
    väkipuukko(1, 1, "Väkipuukko", 2, MaterialType.teel, MaterialType.wood, MaterialType.plastic),
    kettinki(1, 1, "Kettinki", 3, MaterialType.plastic, MaterialType.diamang, MaterialType.wood),
    käsipultti(2, 10, "Käsipultti", 3, MaterialType.wool, MaterialType.teel, MaterialType.plastic),
    atrain(1, 10, "Atrain", 3, MaterialType.laziness, MaterialType.plastic, MaterialType.wood),
    hilpari(1, 1, "Hilpari", 3, MaterialType.teel, MaterialType.laziness, MaterialType.wool);

    public String name;
    public int minRange;
    public int maxRange;
    public final int size;
    
    public final MaterialType optimum;
    public final MaterialType awful;
    public final MaterialType bad;

    private WeaponType(int minRange, int maxRange, String name, int size, MaterialType optimum, MaterialType awful, MaterialType bad) {
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.name = name;
        this.size = size;
        this.optimum = optimum;
        this.awful = awful;
        this.bad = bad;
    }

}
