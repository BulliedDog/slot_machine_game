/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import GamePanel.MainPanel;
import javax.swing.JFrame;

/**
 * @author utente
 */
public class AnimationFrame extends JFrame {
    
    private MainPanel mp;
    
    public AnimationFrame(int credito)
    {
        super("Slot Machine Capialbi-Rovai");
        this.setSize(795, 470);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        mp= new MainPanel(credito);
        add(mp);
    }
    
}
