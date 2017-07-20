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
public enum Time {
    day18(0),
    day17(0.1),
    day16(0.1),
    day15(0.1),
    day14(0.1),
    day13(0.2),
    day12(0.2),
    day11(0.2),
    day10(0.2),
    day9(0.3),
    day8(0.3),
    day7(0.3),
    day6(0.3),
    day5(0.4),
    day4(0.4),
    day3(0.4),
    day2(0.5),
    day1(0.5),
    night1(0.5),
    night2(0.5),
    night3(0.6),
    night4(0.6),
    night5(0.6),
    night6(0.7),
    night7(0.7),
    night8(0.7),
    night9(0.7),
    night10(0.8),
    night11(0.8),
    night12(0.8),
    night13(0.8),
    night14(0.9),
    night15(0.9),
    night16(0.9),
    night17(0.9),
    night18(1);
    // VARIABLES
    public final double visibility;
    private static Time[] phases;
    
    private Time (double visibility) {
        this.visibility = visibility;
        //this.phases = new Time[36];
        buildArray();
    }
    
    private void buildArray() {
        this.phases = new Time[] {day18, day17, day16, day15, day14, day13, 
            day12, day11, day10, day9, day8, day7, day6, day5, day4, day3, 
            day2, day1, night1, night2, night3, night4, night5, night6, night7,
         night8, night9, night10, night11, night12, night13, night14, night15,
         night16, night17, night18,};
    }
    
    public static void passTime (Grid grid) {
        int pointer = gameTools.dice(1) + ((gameTools.dice(1) - 1) * 6) - 1;
        grid.timeOfDay = phases[pointer];
        if (phases[pointer] == night18) {
            Day.boarDay(grid);
        }
    }
}
