
package vista;

import modelo.MetodosPuntaje;




public class FRM_IngresarPuntaje extends javax.swing.JFrame {

    String arreglo[] = new String[2];
    public MetodosPuntaje metodosPuntaje = new MetodosPuntaje();
    
    public FRM_IngresarPuntaje() {
        initComponents(); 
        setLocationRelativeTo(null);

    }
    
    public void setPuntaje(int puntaje)
    {
        txtPuntos.setText(""+puntaje);
    }
   
    
    public String[] getInformacionIngresada()
    {
        arreglo[0]= txtNombre.getText();
        arreglo[1]= ""+txtPuntos.getText();
        return arreglo;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPuntos = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setTitle("Nuevo Puntaje Alto");
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(270, 200));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(12, 44, 56, 15);
        getContentPane().add(txtNombre);
        txtNombre.setBounds(80, 42, 169, 30);

        jLabel2.setText("Puntaje");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(12, 81, 60, 20);

        txtPuntos.setEnabled(false);
        getContentPane().add(txtPuntos);
        txtPuntos.setBounds(80, 79, 169, 30);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(20, 130, 74, 25);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ingrese el puntaje");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 260, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
        metodosPuntaje.escribirInformacionEnArchivos();
    }//GEN-LAST:event_formComponentHidden

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        metodosPuntaje.agregarPuntaje(getInformacionIngresada());
        this.hide();
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPuntos;
    // End of variables declaration//GEN-END:variables
}
