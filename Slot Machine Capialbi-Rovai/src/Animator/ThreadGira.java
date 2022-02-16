/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animator;

import Animator.ThreadRullo1;
import Main.Gira;
import Main.Rullo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Alessandro
 */
public class ThreadGira extends Thread {
    
    private JPanel pn1;
    private Gira g1;

    public ThreadGira(JPanel pn1, Gira g1) {
        this.pn1 = pn1;
        this.g1 = g1;
    }

    @Override
    public void run() {
        
        int num=2;
        
        for (int i = 0; i <= 1; i++) 
        {
            String nomeFileAvatar = "butt" + num + ".png";
            g1.changeImage("/Images/" + nomeFileAvatar);
            pn1.repaint();
            num--;
             try {
             Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadGira.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    
}
}
