package enginetest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Viki
 */
public class Weapon {
    protected int magazineCapacity; // per bullet
    protected int fullCapacity;     // per magazine
    protected double fireRate;      // RPS (rounds per second)
    protected double reloadTime;    // per second
    protected double damage;        // adjusted to player's health
    
    protected int remainingAmmos;
    protected int remainingMags;
    
    
    public Weapon(int magazineCapacity, int fullCapacity, double fireRate, double reloadTime, double damage) {
        this.magazineCapacity = magazineCapacity;
        this.fullCapacity = fullCapacity;
        this.fireRate = fireRate;
        this.reloadTime = reloadTime;
        this.damage = damage;
        
        this.magazineCapacity = remainingAmmos;
        this.fullCapacity = remainingMags;
    }
    
    
    public void shoot(Player target) {
        // collision detection missing for now
        if(remainingAmmos > 0) { remainingAmmos -= 1; target.changeHP(-damage); }
        //else reload();
    }
    
    public void reload() {
        if(remainingMags > 0) { remainingMags -= 1; remainingAmmos = magazineCapacity; }
    }
    
    
    
    /* getters */

    public int getMagazineCapacity() {
        return magazineCapacity;
    }

    public int getFullCapacity() {
        return fullCapacity;
    }

    public double getFireRate() {
        return fireRate;
    }

    public double getReloadTime() {
        return reloadTime;
    }

    public double getDamage() {
        return damage;
    }

    /* setters */
    
    public void setMagazineCapacity(int magazineCapacity) {
        this.magazineCapacity = magazineCapacity;
    }

    public void setFullCapacity(int fullCapacity) {
        this.fullCapacity = fullCapacity;
    }

    public void setFireRate(double fireRate) {
        this.fireRate = fireRate;
    }

    public void setReloadTime(double reloadTime) {
        this.reloadTime = reloadTime;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

}
