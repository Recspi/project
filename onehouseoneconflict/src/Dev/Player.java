package dev;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
/**
 *
 * @author Németh Csaba
 */
public class Player{
    //Játékos tulajdonságok
    private int HP; //HealthPoint
    private int SP; //ShieldPoint
    private int Speed;
    
    private int[][] direction = new int[3][3]; 
    /*
    A játékos pillanatnyi irányának megjegyzésére egy mátrixot használok.
    Ha a játékos felfelé néz akkor a mátrix így néz ki:
    0 1 0
    0 0 0
    0 0 0
    
    Jobb:
    0 0 0
    0 0 1
    0 0 0
    */
    //private ArrayList<Utility> Hand; Készülőben, a kézben lévő tárgyakat gyűjtjük ide fegyverek csapdák kulcs stb.. 
    
    private boolean CanShoot; //Ha a játékos lőni próbál ez a változó alapján dől el, hogy tüzelő képes-e vagy sem.
    // Amint fegyver kerül a kézbe és megvan töltve a változót True-ra kell állítani.
    // A lövések közötti időt a fegyver osztályban kell szabályozni
    
    //Egy player lerakásához szükséges változók
    protected String name;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Image image;
    public ArrayList<Point> Waypoints;
    public Point Destination;
    
    private int moveX = 0;
    private int moveY = 0;
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public Player(String name, int x, int y, int width, int height, Image image)
    {
        this.HP = GlobalVars.PLAYER_START_HEALTH;
        this.SP = GlobalVars.PLAYER_START_SHIELD;
        this.Speed = GlobalVars.PLAYER_START_SPEED;
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
        Destination = new Point(x,y);
    }
    
   
    public void draw(Graphics g, int zoomLevel, int Xoffset, int Yoffset) {//kiolvassa a valodi koordinatakat es visszaszamolja azoknak jelenelg hol kell elhelyezkedniuk a torzitott kepen.
        g.drawImage(image, x * zoomLevel + Xoffset, y * zoomLevel + Yoffset, width * zoomLevel, height * zoomLevel, null);
    }
    
    public void moveForward()
    {
        moveY = -1;
    }
    
    public void moveBackward()
    {
        moveY = 1;
    }
    
    public void moveRight()
    {
        moveX = 1;
    }
    
    public void moveLeft()
    {
        moveX = -1;
    }
  
    public void setZeroY()
    {
        moveY = 0;
    }
    
    public void setZeroX()
    {
        moveX = 0;
    }
    
    
    public void move(int speed)
    {
        x += moveX * speed;
        y += moveY * speed;
    }
    
    
    
    
    
    
}
