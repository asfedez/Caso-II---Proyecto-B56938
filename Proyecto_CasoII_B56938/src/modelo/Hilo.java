/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vista.FRM_VentanaJuego;

/**
 *
 * @author Casa
 */
public class Hilo extends Thread{
    
   FRM_VentanaJuego frm_VentanaJuego;
   
   public Hilo(FRM_VentanaJuego frm_VentanaJuego)
   {
       this.frm_VentanaJuego=frm_VentanaJuego;
   }
   
   public void run()
   {
       int milisegundos=0;
       while(true)
        {
            try
            {
                sleep(100);
                milisegundos+=100;
                frm_VentanaJuego.moverFondo();
                moverPersonaje();
                frm_VentanaJuego.limite();
                frm_VentanaJuego.moverObstaculo();
                frm_VentanaJuego.colision();
                frm_VentanaJuego.colisionX();
                frm_VentanaJuego.colisionY();
                frm_VentanaJuego.reducirVida();
                //System.out.println("milisegundos = "+milisegundos);
                if(milisegundos==1000)
                {
                    
                }
                
            }
            catch(Exception e)
            {
                
            }
        }
   }
   
   public void moverPersonaje()
    {
        if(frm_VentanaJuego.estado.equals("subiendo"))
            frm_VentanaJuego.moverArriba(15);
        
        if(frm_VentanaJuego.estado.equals("bajando"))
            frm_VentanaJuego.moverAbajo(15);
        
        if(frm_VentanaJuego.estado.equals("Limite superior"))
            frm_VentanaJuego.moverAbajo(15);
       
        if(frm_VentanaJuego.estado.equals("Limite inferior"))
            frm_VentanaJuego.moverArriba(15);
        
    }
   
   
   
    
    
}
