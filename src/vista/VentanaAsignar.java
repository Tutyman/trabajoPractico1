/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Tomas
 */
public class VentanaAsignar extends javax.swing.JFrame {

    /**
     * Creates new form VentanaNiveles
     */
    public VentanaAsignar() {
        initComponents();
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dispose();
                controlador.ControladorGrafica.Iniciar();
            }
        });
    }

    public JLabel getLbNivel() {
        return LbNivel;
    }

    public void setLbNivel(JLabel LbNivel) {
        this.LbNivel = LbNivel;
    }

    public JTable getTbAsiganar() {
        return TbAsiganar;
    }

    public void setTbAsiganar(JTable TbAsiganar) {
        this.TbAsiganar = TbAsiganar;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LbNivel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbAsiganar = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asignar Recurso");
        setPreferredSize(new java.awt.Dimension(640, 480));
        setResizable(false);

        LbNivel.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        LbNivel.setText("Este paciente es de nivel 2");

        TbAsiganar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        TbAsiganar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TbAsiganar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbAsiganarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbAsiganar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LbNivel)
                        .addGap(0, 352, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbNivel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TbAsiganarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbAsiganarMouseClicked
        controlador.ControladorGestionRecursos.AsignarRecurso();
    }//GEN-LAST:event_TbAsiganarMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbNivel;
    private javax.swing.JTable TbAsiganar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
