/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginetest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Prokkály László
 */
public class GameEngine extends JPanel {
    
    //private int PosX;
    //private int PosY;
    public ArrayList<Rectangle> List;
    private Image OrangeImage;
    private Image GreenImage;
    private Image BlueImage;
    private Timer newFrameTimer;
    private final int FPS = 60;
    private int gridSize = 40;
    private int zoomLevel = 1;
    private int motionSpeed = 5; //pixel jump/tick
    
    public GameEngine() {
        super();
        this.addMouseListener(new MouseAdapter() {// provides empty implementation of all
                                           // MouseListener`s methods, allowing us to
                                           // override only those which interests us
        @Override //I override only one method for presentation
        public void mousePressed(MouseEvent e) {
            System.out.println(e.getX() + "," + e.getY() );
            //PosX = e.getX();
            //PosY = e.getY();
            for (int i = 0; i < List.size(); i++) {
                //ha beleclickeltem egy objektumba (teglalap)
                if ((List.get(i).x < e.getX() && (List.get(i).x + List.get(i).width) > e.getX()) && List.get(i).y < e.getY() && (List.get(i).y + List.get(i).height) > e.getY()){
                    System.out.println(List.get(i).getName() + " clicked");
                }
            }
            //test objects
            int corGridSize = gridSize * zoomLevel;
            List.get(2).setX((((e.getX()) / corGridSize) * corGridSize) / zoomLevel);
            List.get(2).setY((((e.getY()) / corGridSize) * corGridSize) / zoomLevel);
            List.get(2).Destination.x = (e.getX() / corGridSize) * corGridSize / zoomLevel;
            List.get(2).Destination.y = (e.getY() / corGridSize) * corGridSize / zoomLevel;
            //List.get(0).addPoint((e.getX() / gridSize) * gridSize, (e.getY() / gridSize) * gridSize);
            List.get(0).addPoint(e.getX(), e.getY(), gridSize, zoomLevel);
            //System.out.println("ADDED " + (e.getX() / gridSize) * gridSize + "," + (e.getY() / gridSize) * gridSize);
        }
    });
        newFrameTimer = new Timer(1000 / FPS, new NewFrameListener());
        newFrameTimer.start();
        Setup();
    }
    
    public void Setup (){
        OrangeImage = new ImageIcon("design/images/orange.png").getImage();
        GreenImage = new ImageIcon("design/images/green.png").getImage();
        BlueImage = new ImageIcon("design/images/blue.png").getImage();
        List = new ArrayList<>();
        List.add(new Rectangle("Orange", 0, 0, gridSize, gridSize, OrangeImage));
        List.add(new Rectangle("Green", 0, 0, 0, 0, GreenImage));
        List.add(new Rectangle("Blue", -gridSize, -gridSize, gridSize, gridSize, BlueImage));
    }
    
    public void addRectangle(){//hianyzo parameterek.(nev, x, y, szelesseg, magassag, kep) NYI
        List.add(new Rectangle("New",0,0,gridSize,gridSize,GreenImage));
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        setBackground(Color.LIGHT_GRAY);//hatter
        for (int i = 0; i < (600 / gridSize) + 1; i++) {//vizszintes vonalak
            grphcs.drawLine(0, i * gridSize * zoomLevel, 800 * zoomLevel, i * gridSize * zoomLevel);
        }
        for (int i = 0; i < (800 / gridSize) + 1; i++) {//fuggoleges vonalak
            grphcs.drawLine(i * gridSize * zoomLevel, 0, i * gridSize * zoomLevel, 600 * zoomLevel);
        }
        for (int i = 0; i < List.size(); i++) {
            List.get(i).draw(grphcs, zoomLevel);
        }
    }
    
    class NewFrameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try
            {
                for (int i = 0; i < List.size(); i++) {
                    List.get(i).move(motionSpeed);
                }
                //List.get(0).setX(List.get(0).getX()+2);
                //List.add(new Rectangle(100,120,40,60,BlueImage)); //Ha itt adom hozza akkor annyit ad hozza ahanyszor lefut a framelistener (sokat)
                repaint();
                }
            catch(NullPointerException e)//ezt meg meg kellene oldani.
            {
                System.out.println();
            }
        }
    }
    /*
    public int GetPosX(){
        return PosX;
    }
    
    public int GetPosY(){
        return PosY;
    }*/
}
