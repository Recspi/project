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
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 *
 * @author Prokkály László
 */
public class GameEngine extends JPanel {
    
    public ArrayList<Rectangle> List;
    private Image OrangeImage;
    private Image GreenImage;
    private Image BlueImage;
    private Timer newFrameTimer;
    private final int FPS = 60;
    private int gridSize = 40;//segedhalo racsmerete
    private int zoomLevel = 1;//zoomlevel szamítson az eltolasnal? nem.
    private int cameraMoveSpeed = 3;//kamera mozgasi sebessege
    private int Xoffset = 0;//kamera X iranyu kimozdulasa
    private int Yoffset = 0;//kamera Y iranyu kimozdulasa
    private int motionSpeed = 1; //pixel jump/tick
    
    public GameEngine() {
        super();
        this.addMouseListener(new MouseAdapter() {
        @Override 
        public void mousePressed(MouseEvent e) {
            System.out.println(e.getX() + "," + e.getY() );
            for (int i = 0; i < List.size(); i++) {
                //ha beleclickeltem egy objektumba (teglalap)
                if ((List.get(i).x < e.getX() && (List.get(i).x + List.get(i).width) > e.getX()) && List.get(i).y < e.getY() && (List.get(i).y + List.get(i).height) > e.getY()){
                    System.out.println(List.get(i).getName() + " clicked");
                }
            }
            List.get(0).addPoint(e.getX(), e.getY(), gridSize, zoomLevel, Xoffset, Yoffset);
        }
    });
        this.getInputMap().put(KeyStroke.getKeyStroke('+'), "pressed plus");//ZOOM IN
        this.getActionMap().put("pressed plus", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                zoomLevel++;
            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke('-'), "pressed minus");//ZOOM OUT
        this.getActionMap().put("pressed minus", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (zoomLevel != 1){
                    zoomLevel--;
                }
            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "pressed left");//CAMERA MOVE LEFT
        this.getActionMap().put("pressed left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Xoffset += cameraMoveSpeed * zoomLevel;
            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "pressed right");//CAMERA MOVE RIGHT
        this.getActionMap().put("pressed right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Xoffset -= cameraMoveSpeed * zoomLevel;
            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "pressed up");//CAMERA MOVE UP
        this.getActionMap().put("pressed up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Yoffset += cameraMoveSpeed * zoomLevel;
            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "pressed down");//CAMERA MOVE DOWN
        this.getActionMap().put("pressed down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Yoffset -= cameraMoveSpeed * zoomLevel;
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
    }
    
    public void addRectangle(String nev, int x, int y, int width, int height, Image image){
        List.add(new Rectangle(nev,x,y,width,height,image));
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        setBackground(Color.LIGHT_GRAY);//hatter
        for (int i = 0; i < (600 / gridSize) + 1; i++) {//vizszintes seged vonalak
            grphcs.drawLine(0 + Xoffset, i * gridSize * zoomLevel + Yoffset, 800 * zoomLevel + Xoffset, i * gridSize * zoomLevel  + Yoffset);
        }
        for (int i = 0; i < (800 / gridSize) + 1; i++) {//fuggoleges seged vonalak
            grphcs.drawLine(i * gridSize * zoomLevel + Xoffset, 0  + Yoffset, i * gridSize * zoomLevel + Xoffset, 600 * zoomLevel  + Yoffset);
        }
        for (int i = 0; i < List.size(); i++) {
            List.get(i).draw(grphcs, zoomLevel, Xoffset, Yoffset);
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
                repaint();
                }
            catch(NullPointerException e)//ezt meg meg kellene oldani.
            {
                System.out.println();
            }
        }
    }
}
