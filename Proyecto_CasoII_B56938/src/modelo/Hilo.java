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
       while(true)
        {
            try
            {
                sleep(100);
                frm_VentanaJuego.moverFondo();
                moverPersonaje();
                frm_VentanaJuego.limite();
                frm_VentanaJuego.moverObstaculo();
                frm_VentanaJuego.colision();
                frm_VentanaJuego.verificarPaso();
                frm_VentanaJuego.pasoArriba();
                frm_VentanaJuego.reducirVida();
                
            }
            catch(Exception e)
            {
                
            }
        }
   }
   
   public void moverPersonaje()
    {
        if(frm_VentanaJuego.estado.equals("subiendo"))
            frm_VentanaJuego.moverArriba(10);
        
        if(frm_VentanaJuego.estado.equals("bajando"))
            frm_VentanaJuego.moverAbajo(10);
        
        if(frm_VentanaJuego.estado.equals("Limite superior"))
            frm_VentanaJuego.moverAbajo(10);
       
        if(frm_VentanaJuego.estado.equals("Limite inferior"))
            frm_VentanaJuego.moverArriba(10);
        
    }
   
   
   
    
    
}
