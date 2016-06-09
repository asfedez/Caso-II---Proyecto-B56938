/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import static java.applet.Applet.newAudioClip;
import java.applet.AudioClip;
import modelo.Hilo;

/**
 *
 * @author Casa
 */
public class FRM_VentanaJuego extends javax.swing.JFrame {

    Hilo hilo;
    public String estado="";
    String verificarPaso="";
     String verificarArriba="";
   
    int aleatorioX= 0;
    int aleatorioY=0;
    
    int vidaActual=0;
    int restaVida=0;
    
    public FRM_VentanaJuego() {
        initComponents();
        hilo = new Hilo(this);
        hilo.start();
        this.vida.setValue(100);
        
       labelVida.setText("100%");
    }
    
    
    public void moverFondo()
    {
        if(fondo.getX()>=-1000)
        {
            fondo.setLocation(fondo.getX()-5, fondo.getY());
        }
        else
        {
            fondo.setLocation(0,fondo.getY());
        }
    }
    
    
    
    public void moverArriba(int intensidad)
    {
       
        personaje.setLocation(personaje.getX(), personaje.getY()-5-intensidad);
        
    }
    public void moverAbajo(int intensidad)
    {
        
        personaje.setLocation(personaje.getX(), personaje.getY()+5+intensidad);
        aleatorioY=(int) (Math.random()*(365-200))+200;
        aleatorioX= (int) (Math.random()*(600-350))+350;
    }
    public void limite()
    {
        if(personaje.getY()<=200)
        {
            
            personaje.setLocation(personaje.getX(), 200);
            estado="Limite superior";
        } 
        
        if(personaje.getY()>365)
        {
           
            personaje.setLocation(personaje.getX(), 365);
            estado="Limite inferior";
        } 
        
    }
    int contador=0;
    
 
    public void moverObstaculo()
    {

        
        obstaculo1.setLocation(obstaculo1.getX()-10+contador, obstaculo1.getY());
//        System.out.println("Obstaculo "+obstaculo1.getX());
        
//        if (obstaculo1.getX()==personaje.getX()+100)
//            System.out.println("Coinciden");
        
        if(obstaculo1.getX()<personaje.getX()-80)
        {
            contador+=-5;
//            System.out.println("Personaje "+personaje.getX());
            System.out.println("pasó "+contador );
            
            obstaculo1.setLocation(aleatorioX, aleatorioY);
//            System.out.println("Y "+ obstaculo1.getY() +" X " +obstaculo1.getX() );
            if(contador == -20)
                contador=0;
        }
            
    }
   
    public void verificarPaso()
    {
         if(obstaculo1.getX()-20<personaje.getX())
        {
            verificarPaso="paso";
                System.out.println("pasó de verificar" );
        }
         else
         {
             System.out.println("colision en X");
             verificarPaso="no paso";
         }
    }
    
    public void pasoArriba()
    {
        if(personaje.getY()+50<obstaculo1.getY() &&  personaje.getX()>=obstaculo1.getX()-100)
        {
            verificarArriba="paso";
            System.out.println("paso arriba");
                
        }
        else
        {
             verificarArriba="no paso";
           
        }
    }
    
    String colision="";
    int i = 0;
    public void colision()
    {
        
        if(personaje.getX()>=obstaculo1.getX()-100 && personaje.getY()<=obstaculo1.getY())
        {
            if(verificarPaso.equals("paso")||verificarArriba.equals("paso"))
            {
                colision="no colision";
                System.out.println("no colision?"); 
            }
            else
            {
                colision="colision";
                i++;
                restaVida+=5;
                System.out.println("colision ");
            }
                       
        }
          
    }
    
    
    public void reducirVida()
   {
        
       if(colision.equals("colision"))
       {
           vida.setValue(100-restaVida);
           
           labelVida.setText(100-restaVida+"%");
           
           System.out.println("vida restante "+restaVida);
       }
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        personaje = new javax.swing.JLabel();
        obstaculo1 = new javax.swing.JLabel();
        labelVida = new javax.swing.JLabel();
        vida = new javax.swing.JProgressBar();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 500));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        personaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/kayak.gif"))); // NOI18N
        getContentPane().add(personaje);
        personaje.setBounds(40, 240, 180, 130);

        obstaculo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/quimicos.png"))); // NOI18N
        getContentPane().add(obstaculo1);
        obstaculo1.setBounds(560, 230, 70, 60);

        labelVida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelVida);
        labelVida.setBounds(190, 20, 160, 20);
        getContentPane().add(vida);
        vida.setBounds(190, 20, 160, 20);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoRio.jpg"))); // NOI18N
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 2040, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
        
        if(evt.getKeyCode()==38)
        {    
                estado="subiendo";
//                System.out.println(personaje.getY());
        }
        if(evt.getKeyCode()==40)
        {
                estado="bajando";

        }
    }//GEN-LAST:event_formKeyPressed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_VentanaJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel labelVida;
    private javax.swing.JLabel obstaculo1;
    private javax.swing.JLabel personaje;
    private javax.swing.JProgressBar vida;
    // End of variables declaration//GEN-END:variables
}
