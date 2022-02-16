/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animator;

import Main.FaiClic;
import Main.Jackpot;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 * @author Alessandro Capialbi - Alberto Rovai
 */
public class ThreadJackpot extends Thread {
    
    private JPanel pn1;
    private Jackpot j1;

    public ThreadJackpot(JPanel pn1, Jackpot j1) {
        this.pn1 = pn1;
        this.j1=j1;
    }
    
    @Override
    public void run()
    {
        int num = 2;
        for (;;)
        {
                String nomeFileAvatar = "jackpot" + String.valueOf(num) + ".png";
                j1.changeImage("/Images/" + nomeFileAvatar);
                pn1.repaint();
                num--;
                if (num==0)
                num=2;
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadJackpot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }
   
