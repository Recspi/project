/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Prokkály László
 */
public class Rectangle {
    
    protected String name;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Image image;
    public ArrayList<Point> Waypoints;
    public Point Destination;

    public Rectangle(String name, int x, int y, int width, int height, Image image) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
        Waypoints = new ArrayList<>();
        Destination = new Point(x,y);
    }
    
    public void addPoint(int x, int y, int gridSize, int zoomLevel, int Xoffset, int Yoffset){ //megkapja a kattintast(+modositokat) es visszaszamolja a valodi koordinatakat a jatekteren.
        Point tmp = new Point();
        tmp.x = ((x / zoomLevel - (Xoffset / zoomLevel)) / gridSize) * gridSize;
        System.out.println("Stored X: " + tmp.x + " Input X: " + x + " Xoffset: " + Xoffset + " Zoom: " + zoomLevel);
        tmp.y = ((y / zoomLevel - (Yoffset / zoomLevel)) / gridSize) * gridSize;
        System.out.println("Stored Y: " + tmp.y + " Input Y: " + y + " Xoffset: " + Yoffset + " Zoom: " + zoomLevel);
        Waypoints.add(tmp);//tarolja a koordinatat ahova kattintottunk (valodi jatekteren es nema  torzitott kepernyo szerint)
        System.out.println("ADDED " + tmp.x + "," + tmp.y + "| on the grid: " + (x - Xoffset) / zoomLevel / gridSize + "," + (y - Xoffset) / zoomLevel / gridSize);
    }
    
    public void move(int speed){
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
    
    public void draw(Graphics g, int zoomLevel, int Xoffset, int Yoffset) {//kiolvassa a valodi koordinatakat es visszaszamolja azoknak jelenelg hol kell elhelyezkedniuk a torzitott kepen.
        g.drawImage(image, x * zoomLevel + Xoffset, y * zoomLevel + Yoffset, width * zoomLevel, height * zoomLevel, null);
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String Name){
        this.name = Name;
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
    
    public void setDestination (Point dest){
        this.Destination = dest;
    }
    
    public Point getDestination(){
        return this.Destination;
    }
}
