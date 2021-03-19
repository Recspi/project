
package dev;

/** This is a specific weapon's class with realistic weapon data.
 *
 * @author Viki
 * @version 1.0
 * @since 1.0
 */
public class AssaultRifle extends Weapon {
    
    public AssaultRifle(int magazineCapacity, int fullCapacity, int fireRate, int reloadTime, int damage) {
        super(30, 3, 10, 1, 30);
    }
}
