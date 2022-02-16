/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import GamePanel.RulesPanel;
import javax.swing.JFrame;

/**
 * @author Alessandro Capialbi - Alberto Rovai
 */
public class RulesFrame extends JFrame {
    
    private RulesPanel rp1;
    
    public RulesFrame()
    {
        super("Regole Slot Machine");
        this.setSize(795, 470);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        rp1= new RulesPanel();
        add(rp1);
        
    }
    
    
}
