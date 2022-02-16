/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Image;
import java.awt.Toolkit;

/**
 * @author Alessandro Capialbi - Alberto Rovai
 */
public class FaiClic 
{
    private int altezza;
    private int larghezza;
    private int x;
    private int y;
    private String pathImages;
    private Image image;
    
    public FaiClic(int larghezza, int altezza, int x, int y, String pathImages) {
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.x = x;
        this.y = y;
        this.pathImages=pathImages;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        this.image= toolkit.getImage(getClass().getResource(pathImages));
    }
    
    public void changeImage(String pathImages) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        image = toolkit.getImage(getClass().getResource(pathImages));
        this.pathImages = pathImages;
    }

    public int getAltezza() {
        return altezza;
    }

    public int getLarghezza() {
        return larghezza;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getPathImages() {
        return pathImages;
    }

    public Image getImage() {
        return image;
    }
    
    
}
