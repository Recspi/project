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
    private final int FPS = 120;
    
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
            List.get(2).setX(((e.getX()) / 40) * 40);
            List.get(2).setY(((e.getY()) / 40) * 40);
            List.get(2).Destination.x = (e.getX() / 40) * 40;
            List.get(2).Destination.y = (e.getY() / 40) * 40;
            List.get(0).AddPoint((e.getX() / 40) * 40, (e.getY() / 40) * 40);
            //List.get(0).AddPoint(e.getX(), e.getY());
            System.out.println("ADDED " + (e.getX() / 40) * 40 + "," + (e.getY() / 40) * 40);
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
        List.add(new Rectangle("Orange", 0,0,40,40,OrangeImage));
        List.add(new Rectangle("Green", 0,0,0,0,GreenImage));
        List.add(new Rectangle("Blue", -40, -40, 40, 40, BlueImage));
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        setBackground(Color.LIGHT_GRAY);
        for (int i = 0; i < 16; i++) {//vizszintes vonalak
            grphcs.drawLine(0, i * 40, 800, i * 40);
        }
        for (int i = 0; i < 21; i++) {//fuggoleges vonalak
            grphcs.drawLine(i * 40, 0, i * 40, 600);
        }
        for (int i = 0; i < List.size(); i++) {
            List.get(i).draw(grphcs);
        }
    }
    
    class NewFrameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try
            {
                for (int i = 0; i < List.size(); i++) {
                    List.get(i).Move(2);
                }
                //List.get(0).setX(List.get(0).getX()+2);
                //List.add(new Rectangle(100,120,40,60,BlueImage)); //Ha itt adom hozza akkor annyit ad hozza ahanyszor lefut a framelistener (qwasokat)
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
