/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Prokkály László
 */
public class GUI {
    public JFrame frame;
    public GameEngine GameArea;
    
    public GUI(){
        frame = new JFrame("TEST Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameArea = new GameEngine();
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
        frame.getContentPane().add(GameArea);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
    
    public void addObject(String nev, int x, int y, int width, int height, Image image){
        GameArea.addRectangle(nev,x,y,width,height,image);
    }
    
    public void addWall(int x, int y, int width, int height, Image image){
        GameArea.addWall(x,y,width,height,image);
    }
}
