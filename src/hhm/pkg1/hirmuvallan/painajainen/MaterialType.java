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
public enum MaterialType {
    laziness(0, 0, 0, false, 0, -2, 1, -1, -1, 1),
    wool(0, 0, 0, false, 1, 0, -1, -2, 1, -1),
    wood(0, 0, 0, false, -2, 1, 0, 1, -1, -1),
    plastic(0, 0, 0, false, 1, -1, -1, 0, -2, 1),
    teel(0, 0, 0, false, -1, -1, 1, 1, 0, -2),
    diamang(0, 0, 0, false, -1, 1, -2, -1, 1, 0);

    public boolean exiting;
    public boolean creepified;

    private final int constructModifier;
    private final int owlModifier;
    private final int coneModifier;

    // these values are meant as in attacking against said element
    public final int againstLaziness;
    public final int againstWood;
    public final int againstWool;
    public final int againstPlastic;
    public final int againstBlasce;
    public final int againstDiamang;

    private MaterialType(int construct, int owl, int cone, boolean filler,
            int againstLaziness, int againstWood,
            int againstWool, int againstPlastic,
            int againstBlasce, int againstDiamang) {
        this.constructModifier = construct;
        this.owlModifier = owl;
        this.coneModifier = cone;
        this.againstLaziness = againstLaziness;
        this.againstWood = againstWood;
        this.againstWool = againstWool;
        this.againstPlastic = againstPlastic;
        this.againstBlasce = againstBlasce;
        this.againstDiamang = againstDiamang;
    }
}
