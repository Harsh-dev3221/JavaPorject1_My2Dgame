/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import javax.swing.JFrame;

/**
 *
 * @author HARSH
 */
public class Main {
    
            public static void main(String args[])
            {
                JFrame window = new JFrame();
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setResizable(false);
                window.setTitle("2d Adventure");
                
                gamepannel gamepannel1 = new gamepannel();
                window.add(gamepannel1);
                window.pack();
                
                
                window.setLocationRelativeTo(null);
                window.setVisible(true);
                    
                gamepannel1.setupGame();
                gamepannel1.startGameThread();
                
                
            }
    
}
