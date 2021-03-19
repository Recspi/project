/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev;

/**
 *
 * @author Viki
 */
public class Shotgun extends Weapon {
    
    public Shotgun(int magazineCapacity, int fullCapacity, double fireRate, double reloadTime, int damage) {
        super(8, 3, 0.7, 2.5, 70);
    }
}
