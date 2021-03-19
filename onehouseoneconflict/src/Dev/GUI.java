package dev;

import static dev.Dev.GeneralUserInterface;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Prokkály László
 */
public class GUI {
    public JFrame frame;
    public GameEngine GameArea;
    public GameEngine GameArea2;
    public Map map;
    
    public GUI(){
        frame = new JFrame("TEST Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameArea = new GameEngine(1);
        GameArea2 = new GameEngine(2);
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        gameMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        frame.addKeyListener(new MoveKeyListener());
        //GameArea.addKeyListener(new MoveKeyListener());
       
        
        GameArea.setPreferredSize(new Dimension(800, 600));
        GameArea2.setPreferredSize(new Dimension(800, 600));
        
        map = new Map();
        GameArea.addWalls(map.generateMap());
        GameArea2.addWalls(map.generateMap());
        
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        container.add(GameArea);
        container.add(GameArea2);
        
        frame.getContentPane().add(container);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setFocusable(true);
    }
    
    public void addObject(String nev, int x, int y, int width, int height, Image image){
        GameArea.addRectangle(nev,x,y,width,height,image);
    }
    
    public class MoveKeyListener extends JFrame implements KeyListener{

        
      
        public void keyTyped(KeyEvent e) {
            
        }

    
        public void keyPressed(KeyEvent e) {
            //W - 87, A - 65 , S - 83 , D - 68 
            //Move player with WASD
            //W pressed
            if(e.getKeyCode() == 87)
            {   
                GameArea.Players.get(0).moveForward();
            }
            //S pressed
            if(e.getKeyCode() == 83)
            {
                GameArea.Players.get(0).moveBackward();
            }
            //A pressed
            if(e.getKeyCode() == 65)
            {
                GameArea.Players.get(0).moveLeft();
            }
            //D pressed
            if(e.getKeyCode() == 68)
            {
                GameArea.Players.get(0).moveRight();
            }
            
            // Move Player with Arrows
            //Up arrow
            if(e.getKeyCode() == 38)
            {
                GameArea2.Players.get(1).moveForward();
            }
            //Down arrow
            if(e.getKeyCode() == 40)
            {
                GameArea2.Players.get(1).moveBackward();
            }
            //Left Arrow
            if(e.getKeyCode() == 37)
            {
                GameArea2.Players.get(1).moveLeft();
            }
            //Right Arrow
            if(e.getKeyCode() == 39)
            {
                GameArea2.Players.get(1).moveRight();
            }
        }

        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == 87 || e.getKeyCode() == 83)
            {   
                GameArea.Players.get(0).setZeroY();
            }
            //S pressed
            if(e.getKeyCode() == 65 || e.getKeyCode() == 68)
            {
                GameArea.Players.get(0).setZeroX();
            }
            
            if(e.getKeyCode() == 38 || e.getKeyCode() == 40)
            {   
                GameArea2.Players.get(1).setZeroY();
            }
            
            if(e.getKeyCode() == 37 || e.getKeyCode() == 39)
            {   
                GameArea2.Players.get(1).setZeroX();
            }
            
        }
    }
    
    /*public void addWall(int x, int y, int width, int height, Image image){
        GameArea.addWall(x,y,width,height,image);//bal oldali ablakhoz ad hozza
        GameArea2.addWall(x,y,width,height,image);//jobb oldali ablakhoz ad hozza
    }*/
    
    /*public void addWall(Wall wall) {
        GameArea.addWall(wall); //bal oldali ablakhoz ad hozza
        GameArea2.addWall(wall); //jobb oldali ablakhoz ad hozza
    }*/
}
