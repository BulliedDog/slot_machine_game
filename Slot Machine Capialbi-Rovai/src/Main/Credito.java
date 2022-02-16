/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 * @author Alessandro Capialbi - Alberto Rovai
 */
public class Credito {
    
    private int credito=0;
    private String esito;
    
    public Credito(int credito)
    {
        this.credito=credito;
    }       
    
    public void jackpot()
    {
        credito+=500;
    }
    
    public void dueuguali()
    {
        credito+=100;    
    }
    
    public void gira()
    {
       credito-=50;
    }
    
    public void vincitaDueUguali()
    {
        esito="100";
    }
    
    public void vincitaJackpot()
    {
        esito="500";
    }
    
    public void perdita()
    {
        esito="-50";
    }
    

    public int getCredito() {
      return credito;
    }

    public String getEsito()
    {
        return esito;
    }
    
    public String setEsito(String esito)
    {
        this.esito=esito;
        return esito;
    }
    
    
}
