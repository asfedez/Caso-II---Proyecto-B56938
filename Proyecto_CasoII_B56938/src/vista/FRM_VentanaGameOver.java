/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Casa
 */
public class FRM_VentanaGameOver extends javax.swing.JFrame {

    /**
     * Creates new form FRM_VentanaGameOver
     */
    public FRM_VentanaGameOver() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelFin = new javax.swing.JLabel();
        btnIntentar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setTitle("Fin del juego");
        setPreferredSize(new java.awt.Dimension(451, 225));
        getContentPane().setLayout(null);

        labelFin.setFont(new java.awt.Font("Virtual DJ", 1, 48)); // NOI18N
        labelFin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFin.setText("Game over");
        getContentPane().add(labelFin);
        labelFin.setBounds(0, 10, 450, 140);

        btnIntentar.setText("Intentar de nuevo");
        btnIntentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntentarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIntentar);
        btnIntentar.setBounds(60, 160, 130, 25);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(260, 160, 110, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnIntentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntentarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnIntentarActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIntentar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel labelFin;
    // End of variables declaration//GEN-END:variables
}
