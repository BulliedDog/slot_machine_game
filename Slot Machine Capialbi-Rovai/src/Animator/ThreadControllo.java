/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animator;

import GamePanel.MainPanel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * @author Alessandro Capialbi - Alberto Rovai
 */
public class ThreadControllo extends Thread {

    private ThreadRullo1 tr1;
    private ThreadRullo2 tr2;
    private ThreadRullo3 tr3;
    private MainPanel mp;
    private int credito;
    private String m2 = "src/Music/2.wav";
    private String m3 = "src/Music/3.wav";
    private AudioStream dueUgualiMusic;
    private AudioStream jackpotMusic;

    public ThreadControllo(ThreadRullo1 tr1, ThreadRullo2 tr2, ThreadRullo3 tr3, MainPanel mp) {
        this.tr1 = tr1;
        this.tr2 = tr2;
        this.tr3 = tr3;
        this.mp = mp;
    }

    @Override
    public void run() {
        //Controllo di vita dei rulli
        while (tr1.isAlive() == true || tr2.isAlive() == true || tr3.isAlive() == true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadControllo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Esecuzione regole e musica
        if (tr1.getNomeFileAvatar().equals(tr2.getNomeFileAvatar()) && tr2.getNomeFileAvatar().equals(tr3.getNomeFileAvatar())) {
            
            try {
                InputStream test = new FileInputStream(m3);
                jackpotMusic = new AudioStream(test);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            mp.getC().jackpot();
            mp.getC().vincitaJackpot();
            AudioPlayer.player.stop(mp.getBackGroungMusic());
            AudioPlayer.player.start(jackpotMusic);
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadControllo.class.getName()).log(Level.SEVERE, null, ex);
            }
            AudioPlayer.player.stop(jackpotMusic);
            AudioPlayer.player.start(mp.getBackGroungMusic());
        } else if (tr1.getNomeFileAvatar().equals(tr2.getNomeFileAvatar())) {

            try {
                InputStream test = new FileInputStream(m2);
                dueUgualiMusic = new AudioStream(test);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            mp.getC().dueuguali();
            mp.getC().vincitaDueUguali();
            AudioPlayer.player.stop(mp.getBackGroungMusic());
            AudioPlayer.player.start(dueUgualiMusic);
            try {
                sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadControllo.class.getName()).log(Level.SEVERE, null, ex);
            }
            AudioPlayer.player.stop(dueUgualiMusic);
            AudioPlayer.player.start(mp.getBackGroungMusic());
        } else if (tr2.getNomeFileAvatar().equals(tr3.getNomeFileAvatar())) {

            try {
                InputStream test = new FileInputStream(m2);
                dueUgualiMusic = new AudioStream(test);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            mp.getC().dueuguali();
            mp.getC().vincitaDueUguali();
            AudioPlayer.player.stop(mp.getBackGroungMusic());
            AudioPlayer.player.start(dueUgualiMusic);
            try {
                sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadControllo.class.getName()).log(Level.SEVERE, null, ex);
            }
            AudioPlayer.player.stop(dueUgualiMusic);
            AudioPlayer.player.start(mp.getBackGroungMusic());

        } else if (tr1.getNomeFileAvatar().equals(tr3.getNomeFileAvatar())) {

            try {
                InputStream test = new FileInputStream(m2);
                dueUgualiMusic = new AudioStream(test);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            mp.getC().dueuguali();
            mp.getC().vincitaDueUguali();
            AudioPlayer.player.stop(mp.getBackGroungMusic());
            AudioPlayer.player.start(dueUgualiMusic);
            try {
                sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadControllo.class.getName()).log(Level.SEVERE, null, ex);
            }
            AudioPlayer.player.stop(dueUgualiMusic);
            AudioPlayer.player.start(mp.getBackGroungMusic());
        } else {
            mp.getC().gira();
            mp.getC().perdita();
        }
        mp.repaint();
    }

}
