/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginetest;

/**
 *
 * @author Viki
 */
public class Shotgun extends Weapon {
    
    public Shotgun(int magazineCapacity, int fullCapacity, double fireRate, double reloadTime, double damage) {
        super(8, 3, 0.7, 2.5, 70.0);
    }
}
