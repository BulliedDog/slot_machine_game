/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GamePanel;

import Animator.ThreadControllo;
import Animator.ThreadFaiClic;
import Animator.ThreadGira;
import Animator.ThreadRullo1;
import Animator.ThreadRullo2;
import Animator.ThreadRullo3;
import Main.Credito;
import Main.FaiClic;
import Main.Gira;
import Main.Rullo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * @author Alessandro Capialbi- Alberto Rovai
 */
public class MainPanel extends JPanel implements MouseListener {

    private Image sfondo, rullo;
    private Credito c;
    private String credito;
    private Integer cred, result;
    private Rullo r1;
    private Rullo r2;
    private Rullo r3;
    private FaiClic fc1;
    private ThreadRullo1 tr1;
    private ThreadRullo2 tr2;
    private ThreadRullo3 tr3;
    private ThreadFaiClic trfc1;
    private ThreadGira tg1;
    private Gira g1;
    private ThreadControllo trc;
    private int num1 = 3;
    private int num2 = 1;
    private int num3 = 5;
    private Boolean count = true;
    private AudioStream backGroungMusic;
    private String m1 = "src/Music/1.wav";
    public MainPanel(int credit) {

        try {
            InputStream test = new FileInputStream(m1);
            backGroungMusic = new AudioStream(test);
            AudioPlayer.player.start(backGroungMusic);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cred = new Integer(credit);
        addMouseListener(this);
        r1 = new Rullo(100, 250, 229, 30, "/Images/0.png");
        r2 = new Rullo(100, 250, 344, 30, "/Images/0.png");
        r3 = new Rullo(100, 250, 459, 30, "/Images/0.png");
        fc1 = new FaiClic(135, 10, 330, 320, "/Images/faiclic2.png");
        c = new Credito(cred.intValue());
        g1 = new Gira(98, 57, 596, 350, "/Images/butt1.png");
        setDoubleBuffered(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        sfondo = toolkit.getImage(getClass().getResource("/Images/slotmachine3rulli.jpg"));
        trfc1 = new ThreadFaiClic(this, fc1);
        trfc1.start();
    }

    public AudioStream getBackGroungMusic() {
        return backGroungMusic;
    }
    
    
    
    public Credito getC() {
        return c;
    }

    public String getCredito() {
        return credito;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        credito = String.valueOf(c.getCredito());
        if (count == true) {
            c.setEsito("0");
            count = false;
        } else {
            c.getEsito();
        }
        g2.setColor(Color.LIGHT_GRAY);
        g2.drawImage(sfondo, 0, 0, this.size().width, this.size().height, this);
        g2.drawImage(r1.getImage(), r1.getX(), r1.getY(), r1.getLarghezza(), r1.getAltezza(), this);
        g2.drawImage(r2.getImage(), r2.getX(), r2.getY(), r2.getLarghezza(), r2.getAltezza(), this);
        g2.drawImage(r3.getImage(), r3.getX(), r3.getY(), r3.getLarghezza(), r3.getAltezza(), this);
        g2.drawImage(fc1.getImage(), fc1.getX(), fc1.getY(), fc1.getLarghezza(), fc1.getAltezza(), this);
        g2.drawImage(g1.getImage(), g1.getX(), g1.getY(), g1.getLarghezza(), g1.getAltezza(), this);
        g2.setFont(new Font("TimesNewRoman", Font.PLAIN, 20));
        g2.drawString(credito, 100, 383);
        if (c.getEsito() == "0") {
            g2.setColor(Color.WHITE);
        } else if (c.getEsito() == "-50") {
            g2.setColor(Color.RED);
        } else if (c.getEsito() == "100") {
            g2.setColor(Color.GREEN);
        } else {
            g2.setColor(Color.YELLOW);
        }
        g2.drawString(c.getEsito(), 625, 350);
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial Black", Font.BOLD, 20));
        g2.drawString("GIRA", 615, 385);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(c.getCredito()<=0){
            JOptionPane.showMessageDialog(this, "HEHE!!! Hai finito i soldi e quindi ora me li tengo tutti io!");
            System.exit(0);
        }
        int x = e.getX();
        int y = e.getY();
        if (x >= 597 && x <= 690 && y >= 352 && y <= 407) {
            tr1 = new ThreadRullo1(this, r1, num1);
            tr2 = new ThreadRullo2(this, r2, num2);
            tr3 = new ThreadRullo3(this, r3, num3);
            trc = new ThreadControllo(tr1, tr2, tr3, this);
            tr1.setPriority(10);
            tr2.setPriority(10);
            tr3.setPriority(10);
            trc.setPriority(1);
            tg1 = new ThreadGira(this, g1);
            tr1.start();
            tr2.start();
            tr3.start();
            trc.start();
            tg1.start();
            trfc1.stop();
            fc1.changeImage("/Images/faiclic2.png");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
