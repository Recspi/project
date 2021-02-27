/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginetest;

import java.awt.Graphics; 
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Prokkály László
 */
public class Rectangle {
    
    protected String Name;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Image image;
    public ArrayList<Point> Waypoints;
    public Point Destination;

    public Rectangle(String Name, int x, int y, int width, int height, Image image) {
        this.Name = Name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
        Waypoints = new ArrayList<>();
        Destination = new Point(x,y);
    }
    
    public void AddPoint(int x, int y, int multiply, int Xoffset, int Yoffset){
        Point tmp = new Point();
        tmp.x = x / (40 * multiply) * 40;
        tmp.y = y / (40 * multiply) * 40;
        Waypoints.add(tmp);
        System.out.println("ADDED " + tmp.x + "," + tmp.y);
    }
    
    public void Move(int speed){
        if (Destination.getX() == x && Destination.getY() == y && Waypoints.isEmpty() == true){
            return;
        }
        if (Destination.getX() == x && Destination.getY() == y){
            System.out.println("REMOVED " + Waypoints.get(0).x + "," + Waypoints.get(0).y);
            Destination = Waypoints.remove(0);
        }
        if (x < Destination.getX()){
            x += speed;
        }
        else if (x > Destination.getX()){
            x -= speed;
        }
        if (y < Destination.getY()){
            y += speed;
        }
        else if (y > Destination.getY()){
            y -= speed;
        }
    }
    
    public void draw(Graphics g, int multiply, int Xoffset, int Yoffset) {   
        g.drawImage(image, x * multiply - Xoffset, y * multiply - Yoffset, width * multiply, height * multiply, null);
    }
    
    public String getName(){
        return Name;
    }
    
    public void setName(String Name){
        this.Name = Name;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
