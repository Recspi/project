/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginetest;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    }
    
    public void addObject(String nev, int x, int y, int width, int height, Image image){
        GameArea.addRectangle(nev,x,y,width,height,image);
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
