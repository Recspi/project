package dev;


/** This is a specific weapon's class with realistic weapon data.
 *
 * @author Viki
 * @version 1.0
 * @since 1.0
 */
public class Shotgun extends Weapon {
    
    public Shotgun(int magazineCapacity, int fullCapacity, double fireRate, double reloadTime, int damage) {
        super(8, 3, 0.7, 2.5, 70);
    }
}
