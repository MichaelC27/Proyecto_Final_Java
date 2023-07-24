/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controlador.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dbpan
 */
public class frmPlanilla extends javax.swing.JFrame {

    /**
     * Creates new form frmPlanilla
     */
    public frmPlanilla() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtPlanilla = new javax.swing.JTable();
        btnCrear = new javax.swing.JButton();
        btnVer = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtPlanilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Planilla", "Fecha", "T.S Bruto", "T.S.S", "T.E.E", "T.S.N"
            }
        ));
        jtPlanilla.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtPlanillaPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jtPlanilla);

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnVer.setText("Ver");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCrear)
                        .addGap(43, 43, 43)
                        .addComponent(btnVer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnVer)
                    .addComponent(btnCerrar))
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        frmCrearPlanilla frm = new frmCrearPlanilla();
        frm.setVisible(true);
        frm.setTitle("Crear Planilla");
    }//GEN-LAST:event_btnCrearActionPerformed

    private void jtPlanillaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtPlanillaPropertyChange
        DefaultTableModel modelo = (DefaultTableModel) jtPlanilla.getModel();

        //Borrar datos
        int cantidad = modelo.getRowCount();
        while (cantidad > 0) {
            modelo.removeRow(0);
            cantidad = modelo.getRowCount();
        }
        MostrarPlanilla obj_planilla = new MostrarPlanilla();
        ArrayList<MostrarPlanilla> lista = new ArrayList<MostrarPlanilla>();
        lista = obj_planilla.mostrar_planillas();

        for (MostrarPlanilla lista1 : lista) {
            //String []arreglo = {String.valueOf(lista1.getId_planilla()),lista1.getFecha_creacion(),lista1.String.valueOf(getTotal_empleados()),lista1.String.valueOf(getTotal_salario_bruto()),String.valueOf(getTotal_salario_neto())};
            String[] arreglo = {
                String.valueOf(lista1.getId_planilla()),
                lista1.getFecha_creacion(),
                String.valueOf(lista1.getTotal_salario_bruto()),
                String.valueOf(lista1.getTotal_seguro_social()),
                String.valueOf(lista1.getTotal_empleados()),
                String.valueOf(lista1.getTotal_salario_neto())
            };
            modelo.addRow(arreglo);
        }

    }//GEN-LAST:event_jtPlanillaPropertyChange

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        int idPlanillaSeleccionada = obtenerIDPlanillaSeleccionada();

        frmDetallePlanilla frm = new frmDetallePlanilla();
        System.out.println("Antes de llar a  FrmDetalle Planilla "+idPlanillaSeleccionada);
        frm.setIdPlanilla(idPlanillaSeleccionada);
        frm.cargarDetallePlanilla();
        frm.setVisible(true);
        frm.setTitle("Detalle Planilla");
    }//GEN-LAST:event_btnVerActionPerformed
    
    
    private int obtenerIDPlanillaSeleccionada() {
        int idPlanillaSeleccionada = -1; // Valor por defecto en caso de que no se seleccione ninguna fila
        int filaSeleccionada = jtPlanilla.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) jtPlanilla.getModel();
            idPlanillaSeleccionada = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 0).toString());
        } 
        return idPlanillaSeleccionada; // Retorna el valor del campo "ID Planilla" o -1 si no se seleccionó ninguna fila
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(frmPlanilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPlanilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPlanilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPlanilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPlanilla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnVer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtPlanilla;
    // End of variables declaration//GEN-END:variables
}
