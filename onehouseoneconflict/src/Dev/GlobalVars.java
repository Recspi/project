package enginetest;

/**
 *
 * @author Németh Csaba
 */


public class GlobalVars {
    //Game options
    public static final int FPS = 60;
    public static final int GRIDSIZE = 100;

    //Start options
    public static final int PLAYER_START_HEALTH = 100; //Kezdő élet
    public static final int PLAYER_START_SHIELD = 0; //Kezdő pajzs
    public static final int PLAYER_START_SPEED = 5; //kezdő sebesség
    
    //Weapon options
    public static final int WEAPON1_DAMAGE_FROM = 10;
    public static final int WEAPON1_DAMAGE_TO = 15;
    public static final int WEAPON1_BULLET_SPEED = 20;
    
    public static final int WEAPON2_DAMAGE_FROM = 20;
    public static final int WEAPON2_DAMAGE_TO = 30;
    public static final int WEAPON2_BULLET_SPEED = 30;
    
    //Trap options
    public static final int TRAP_DAMAGE = 10;
    public static final int TRAP_PLACE_TIME = 500; //millisec
    
    //Utility spawn options
    public static final int WEAPON_SPAWN_FREQUENCY = 5;
    public static final int TRAP_SPAWN_FREQUENCY = 5;
    public static final int BONUS_HEALTH_SPAWN_FREQUENCY = 6;
    public static final int BONUS_SHIELD_SPAWN_FREQUENCY = 4;
    public static final int BONUS_SPEED_SPAWN_FREQUENCY = 2;
    
    //Utility bonus options
    public static final int BONUS_HEALTH = 25;
    public static final int BONUS_SHIELD = 25;
    public static final int BONUS_SPEED = 2;
    
   
    //NPC options
    public static final int NPC_NUMBER = 1;
    public static final int NPC_SPEED = 3;
    public static final int NPC_HEALTH = 50;
    public static final int NPC_MAX_HEALTH = 100;
    public static final boolean NPC_CAN_EQUIP_WEAPON = false;
    public static final boolean NPC_CAN_SHOOT = false;
    
    //Other options
    public static final int MAX_HEALTH = 150;
    public static final int MAX_SHIELD = 50;
    public static final int MAX_SPEED = 5;
    public static final int MIN_SPEED = 1; //Ha kell, például a csapda nem csak sebez hanem lassít is
    //public static final Utility START_WEAPON = new Pistol(); Kezdő fegyver
      
}
