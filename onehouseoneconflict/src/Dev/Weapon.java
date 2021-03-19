package dev;


/** This is the general Weapon class.
 *
 * @author Viki
 * @version 1.0
 * @since 1.0
 */
public class Weapon {
<<<<<<< HEAD
    /** An int representing the magazine capacity in bullets per magazine.
     * 
     */
    protected int magazineCapacity;
    /** An int representing the full capacity in magazines.
     * 
     */
    protected int fullCapacity;
    /** A double representing the weapon's fire rate in rounds per second (RPS).
     * 
     */
    protected double fireRate;
    /** A double representing the weapon's reload time in seconds.
     * 
     */
    protected double reloadTime;
    /** A double representing the weapon's damage per bullet.
     * 
     */
    protected double damage;
    
=======
    protected int magazineCapacity; // per bullet
    protected int fullCapacity;     // per magazine
    protected double fireRate;      // RPS (rounds per second)
    protected double reloadTime;    // per second
    protected int damage;        // adjusted to player's health
>>>>>>> dev
    
    /** An int representing the remaining ammunitions in the magazine of a weapon.
     * 
     */
    protected int remainingAmmos;
    /** An int representing the remaining magazines the player has for a weapon.
     * 
     */
    protected int remainingMags;
    
<<<<<<< HEAD
    /** Constructor for a weapon.
     *
     * @param magazineCapacity
     * @param fullCapacity
     * @param fireRate
     * @param reloadTime
     * @param damage
     */
    public Weapon(int magazineCapacity, int fullCapacity, double fireRate, double reloadTime, double damage) {
=======
    
    public Weapon(int magazineCapacity, int fullCapacity, double fireRate, double reloadTime, int damage) {
>>>>>>> dev
        this.magazineCapacity = magazineCapacity;
        this.fullCapacity = fullCapacity;
        this.fireRate = fireRate;
        this.reloadTime = reloadTime;
        this.damage = damage;
        
        this.magazineCapacity = remainingAmmos;
        this.fullCapacity = remainingMags;
    }
    
    /** Fires the gun if the player has enough ammo.
     *  Decreases the enemy's health if it hits the target.
     *
     * @param target
     */
    public void shoot(Player target) {
        // collision detection missing for now
        if(remainingAmmos > 0) { remainingAmmos -= 1; target.loseHp(damage); }
        //else reload();
    }
    
    /** Reloads the weapon.
     *  
     */
    public void reload() {
        if(remainingMags > 0) { remainingMags -= 1; remainingAmmos = magazineCapacity; }
    }
    
    
    
    /* getters */

    
    /** Get the magazine capacity of a weapon.
     *
     * @return The magazine capacity of a weapon in bullets.
     */
    public int getMagazineCapacity() {
        return magazineCapacity;
    }

    /** Get the full capacity of a weapon.
     *
     * @return The full capacity of a weapon in magazines
     */
    public int getFullCapacity() {
        return fullCapacity;
    }

    /** Get the fire rate of a weapon.
     *
     * @return The fire rate of a weapon.
     */
    public double getFireRate() {
        return fireRate;
    }

    /** Get the reload time of a weapon.
     *
     * @return The reload time of a weapon.
     */
    public double getReloadTime() {
        return reloadTime;
    }

    /** Get the weapon's damage.
     *
     * @return The weapon's damage.
     */
    public double getDamage() {
        return damage;
    }

    /* setters */

    
    /** Set the magazine's capacity.
     *
     * @param magazineCapacity
     */
    public void setMagazineCapacity(int magazineCapacity) {
        this.magazineCapacity = magazineCapacity;
    }

    /** Set the weapon's full capacity.
     *
     * @param fullCapacity
     */
    public void setFullCapacity(int fullCapacity) {
        this.fullCapacity = fullCapacity;
    }

    /** Set the weapon's fire rate.
     *
     * @param fireRate
     */
    public void setFireRate(double fireRate) {
        this.fireRate = fireRate;
    }

    /** Set the weapon's reload time.
     *
     * @param reloadTime
     */
    public void setReloadTime(double reloadTime) {
        this.reloadTime = reloadTime;
    }

<<<<<<< HEAD
    /** Set the weapon's damage.
     *
     * @param damage
     */
    public void setDamage(double damage) {
=======
    public void setDamage(int damage) {
>>>>>>> dev
        this.damage = damage;
    }

}
