/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detodosa;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class BusquedaPorPrecioView extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    /**
     * Creates new form BusquedaPorPrecio
     */
    public BusquedaPorPrecioView() {
        initComponents();
        armarCabecera();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtPrecio1 = new javax.swing.JTextField();
        jtPrecio2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(500, 300));

        jLabel1.setText("Busqueda por Precio");

        jLabel2.setText("Entre");

        jLabel3.setText("y");

        jtPrecio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPrecio1ActionPerformed(evt);
            }
        });
        jtPrecio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtPrecio1KeyReleased(evt);
            }
        });

        jtPrecio2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtPrecio2KeyReleased(evt);
            }
        });

        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jtPrecio1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtPrecio2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jtPrecio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtPrecio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 159, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtPrecio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPrecio1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jtPrecio1ActionPerformed

    private void jtPrecio1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPrecio1KeyReleased
        // TODO add your handling code here:
        borrarFilas();

        try {

            double Precio1 = 0.0;
            double Precio2 = 0.0;
            if (jtPrecio1.getText().isEmpty() == false) {
                Precio1 = Double.parseDouble(this.jtPrecio1.getText());
            }

            if (jtPrecio2.getText().isEmpty() != true) {
                Precio2 = Double.parseDouble(this.jtPrecio2.getText());
            }

            double max = Math.max(Precio2, Precio1);
            double min = Math.min(Precio2, Precio1);

            for (Producto prod : Menu.listaProductos) {
                double precioF = prod.getPrecio();
                if ((precioF >= min) && (precioF <= max)) {
                    modelo.addRow(new Object[]{
                        prod.getCodigo(),
                        prod.getDescripcion(),
                        prod.getPrecio(),
                        prod.getStock(),});
                }
            }
        } catch (NumberFormatException e) {
            // no deberia salir nada
            JOptionPane.showMessageDialog(this, "Solo ingrese valores numericos");

        }
    }//GEN-LAST:event_jtPrecio1KeyReleased

    private void jtPrecio2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPrecio2KeyReleased
        borrarFilas();

        try {

            double Precio1 = 0.0;
            double Precio2 = 0.0;
            if (jtPrecio1.getText().isEmpty() == false) {
                Precio1 = Double.parseDouble(this.jtPrecio1.getText());
            }

            if (jtPrecio2.getText().isEmpty() != true) {
                Precio2 = Double.parseDouble(this.jtPrecio2.getText());
            }

            double max = Math.max(Precio2, Precio1);
            double min = Math.min(Precio2, Precio1);

            for (Producto prod : Menu.listaProductos) {
                double precioF = prod.getPrecio();
                if ((precioF >= min) && (precioF <= max)) {
                    modelo.addRow(new Object[]{
                        prod.getCodigo(),
                        prod.getDescripcion(),
                        prod.getPrecio(),
                        prod.getStock(),});
                }
            }
        } catch (NumberFormatException e) {
            // no deberia salir nada
            JOptionPane.showMessageDialog(this, "Solo ingrese valores numericos");

        }
    }//GEN-LAST:event_jtPrecio2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtPrecio1;
    private javax.swing.JTextField jtPrecio2;
    private javax.swing.JTable jtProductos;
    // End of variables declaration//GEN-END:variables
private void armarCabecera() {
        modelo.addColumn("Codigo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        jtProductos.setModel(modelo);
    }

    private void borrarFilas() {
        int filas = jtProductos.getRowCount() - 1;
        for (int f = filas; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }
}
