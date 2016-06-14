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
    public String estado="", estadoJuego="";
     String colision="", colisionY="", colisionX="";

    int aleatorioX= 0,aleatorioY=0, puntos=0;
    
    int vidaActual=0;
    int restaVida=0;
    
    FRM_VentanaGameOver fRM_VentanaGameOver= new FRM_VentanaGameOver();
    public FRM_IngresarPuntaje fRM_IngresarPuntaje = new FRM_IngresarPuntaje();
    
    
    AudioClip sonido=newAudioClip(getClass().getResource("/audios/rio.wav"));
    public FRM_VentanaJuego() {
        initComponents();
//        hilo = new Hilo(this);
//        //hilo.start();
//        this.vida.setValue(100);
//        sonido.loop();
//        labelVida.setText("100%");
        setLocationRelativeTo(null);
        
    }
    
    public void iniciarJuego()
    {
       hilo = new Hilo(this);
        hilo.start();
         this.vida.setValue(100);
        sonido.loop();
        labelVida.setText("100%");
        estadoJuego="Play";
    }
    public void pararJuego()
    {
        hilo.stop();
        estadoJuego="Stop";
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
        aleatorioY=(int) (Math.random()*(365-200))+200;
        aleatorioX= (int) (Math.random()*(600-350))+350;
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
            contador+=-2;
//            System.out.println("Personaje "+personaje.getX());
            System.out.println("pasó "+contador );
            
            obstaculo1.setLocation(aleatorioX, aleatorioY);
//            System.out.println("Y "+ obstaculo1.getY() +" X " +obstaculo1.getX() );
            if(contador == -70)
                contador=0;
        }
            
    }
                

    public void colisionX()
    {
                //choque con X
        if(personaje.getX()+100 >= obstaculo1.getX()-40)
        {
            if(obstaculo1.getX()<personaje.getX())
            {
                System.out.println("no choque");
                colisionX="No colision";
            }
            else
            {
                System.out.println("choque en X");
                colisionX="Colision";
            }
        }
        else
        colisionX="No colision";
    }
    public void colisionY()
    {
        if(personaje.getY()<=obstaculo1.getY()+40) 
        {
            if(personaje.getY()+86<=obstaculo1.getY())
            {
                System.out.println("no choque");
                colisionY="No colision";
            }
            else
            {
                System.out.println("choque Y");
                colisionY="Colision";
            }
        }
        else
            colisionY="No colision";
    }
    
    
    int i = 0;
    public void colision()
    {
        if(colisionX.equalsIgnoreCase("Colision")&&colisionY.equalsIgnoreCase("Colision"))
        {
            colision="Colision";
            restaVida+=5;
        }
        else
        {
            puntos+=1;
            labelPuntos.setText(""+puntos);
        }
        
          
    }
    
    
    public void reducirVida()
   {
        
       if(colision.equals("Colision"))
       {
           vida.setValue(100-restaVida);
           
           labelVida.setText(100-restaVida+"%");
           
           System.out.println("vida restante "+restaVida);
           
           if(vida.getValue()<=0)
           {
               if(puntos>=350)
                {
                   fRM_IngresarPuntaje.setVisible(true);
                   fRM_IngresarPuntaje.setPuntaje(puntos);
                }
               
               fRM_VentanaGameOver.setVisible(true);
               this.dispose();
               hilo.stop();
           }
       }
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        personaje = new javax.swing.JLabel();
        obstaculo1 = new javax.swing.JLabel();
        labelPuntos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelVida = new javax.swing.JLabel();
        vida = new javax.swing.JProgressBar();
        fondo = new javax.swing.JLabel();

        setTitle("Juego");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(400, 500));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
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

        labelPuntos.setFont(new java.awt.Font("Virtual DJ", 0, 18)); // NOI18N
        labelPuntos.setText("0");
        getContentPane().add(labelPuntos);
        labelPuntos.setBounds(280, 40, 70, 30);

        jLabel1.setFont(new java.awt.Font("Virtual DJ", 0, 14)); // NOI18N
        jLabel1.setText("Puntos:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 40, 90, 30);

        labelVida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelVida);
        labelVida.setBounds(190, 20, 160, 20);

        vida.setBorderPainted(false);
        vida.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
       pararJuego();
        
    }//GEN-LAST:event_formComponentHidden


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelPuntos;
    private javax.swing.JLabel labelVida;
    private javax.swing.JLabel obstaculo1;
    private javax.swing.JLabel personaje;
    private javax.swing.JProgressBar vida;
    // End of variables declaration//GEN-END:variables
}
