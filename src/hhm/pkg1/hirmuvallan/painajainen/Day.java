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
public enum Day {
    monday(),
    tuesday(), // kehäpäätelmällä on vapaapäivä, ymmärrys vahvistuu
    wednesday(),
    thursday(), // kehäpäätelmä harrastaa (seesteistä) itsetutkiskelua, tahto vahvistuu
    friday(),
    saturday(), // kehäpäätelmä jää ylitöihin, usko vahvistuu
    sunday();
    
    
    // 
    public static Day[] dateArray;
    
    private Day () {
        buildArray();
    }
    
    private void buildArray () {
        this.dateArray = new Day[] {monday, tuesday, wednesday, thursday, friday, saturday, sunday};
    }
    
    public static void boarDay (Grid grid) { // boarDay because the day set by racing boars
        // @TODO: play sound when date changes
        grid.weekday = dateArray[(int) (Math.random() * 7)];
    }
}
