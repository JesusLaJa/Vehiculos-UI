/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import DAO.ConcesionarioDAO;
import DAO.ModeloDAO;
import DAO.VehiculoDAO;
import Entidad.Concesionario;
import Entidad.Modelo;
import Entidad.Vehiculo;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class FrmVehiculo extends javax.swing.JFrame {

    //creo un nuevo objeto/instancia de tipo Vehiculo
    Vehiculo vehiculo = new Vehiculo();
    //creo un nuevo objeto/instancia de tipo VehiculoDAO
    VehiculoDAO vehiculoDAO = new VehiculoDAO();
    //creo un nuevo objeto/instancia de tipo Modelo
    Modelo modelo = new Modelo();
    //creo un nuevo objeto/instancia de tipo ModeloDAO
    ModeloDAO modeloDAO = new ModeloDAO();
    //creo un nuevo objeto/instancia de tipo Concesionario
    Concesionario conce = new Concesionario();
    //creo un nuevo objeto/instancia de tipo ConcesionarioDAO
    ConcesionarioDAO conceDAO = new ConcesionarioDAO();

    /**
     * Creates new form FrmVehiculo
     *
     * @throws java.sql.SQLException
     */
    public FrmVehiculo() throws SQLException {
        initComponents();
        mostrarTablaVehiculos();
        comboBoxModelo();
        comboBoxConcesionario();
        txtId.setEnabled(false);
        txtEstado.setEnabled(false);
    }

    private void comboBoxModelo() throws SQLException {
        //Creo un nuevo objete de tipo DefaultComboBoxModel
        DefaultComboBoxModel modeloMarca = new DefaultComboBoxModel(this.modeloDAO.mostrarModelos());
        //le asigno el objeto al modeloMarca
        comboModelo.setModel(modeloMarca);
    }

    private void comboBoxConcesionario() throws SQLException {
        //Creo un nuevo objete de tipo DefaultComboBoxModel
        DefaultComboBoxModel modeloConce = new DefaultComboBoxModel(this.conceDAO.mostrarConcesionarios());
        //le asigno el objeto al modeloConce
        comboConcesionario.setModel(modeloConce);
    }

    public void mostrarTablaVehiculos() {

        //Creo un nuevo objeto de tipo DefaultTableModel
        DefaultTableModel modelo = new DefaultTableModel();

        //a??ado las columnas al modelo
        modelo.addColumn("ID");
        modelo.addColumn("MODELO");
        modelo.addColumn("CONCESIONARIO");
        modelo.addColumn("COLOR");
        modelo.addColumn("SERIE");

        //aigno el modelo a la tabla
        tablaVehiculo.setModel(modelo);
        //se crea ujn nuevo objeto de tipo String
        String datos[] = new String[5];

        try {
            //creo una nueva listra de tipo Vehiculo
            List<Vehiculo> lstVehiculo = vehiculoDAO.listar();
            //Recorro la lista para obtener los valores de los registros
            lstVehiculo.forEach(v -> {
                //se obtienen los valores
                datos[0] = String.valueOf(v.getId());
                datos[1] = v.getModelo();
                datos[2] = v.getConcesionario();
                datos[3] = v.getColor();
                datos[4] = v.getSerie();

                //se a??aden los datos a modelo
                modelo.addRow(datos);
            });
        } catch (Exception e) {
            //Mostramos el mensaje de error en caso de que haya alg??n error 
            System.out.println("Error al obtener datos" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error en el llenado de la tabla");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        popEliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        txtSerie = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        comboModelo = new javax.swing.JComboBox<>();
        comboConcesionario = new javax.swing.JComboBox<>();

        popEliminar.setText("Eliminar");
        popEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popEliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vehiculos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tablaVehiculo.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaVehiculo.setComponentPopupMenu(jPopupMenu1);
        tablaVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVehiculoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaVehiculo);

        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("Modelo:");

        jLabel3.setText("Concesionario:");

        jLabel4.setText("Color:");

        jLabel5.setText("Serie:");

        jLabel6.setText("Estado:");

        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton3)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(comboConcesionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboModelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtColor, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(txtSerie)
                            .addComponent(txtEstado))
                        .addGap(169, 169, 169))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboConcesionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        Principal ventana = new Principal();

        ventana.setVisible(true);

        this.dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        FrmNuevoVehiculo ventana = null;
        try {
            ventana = new FrmNuevoVehiculo();
        } catch (SQLException ex) {
            Logger.getLogger(FrmVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }

        ventana.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        //Obtengo el item seleccionado del comboModelo y lo asigno a modelo
        this.modelo = (Modelo) comboModelo.getSelectedItem();
        //Obtengo el item seleccionado del comboCOncesionario y lo asigno a conce
        this.conce = (Concesionario) comboConcesionario.getSelectedItem();

        //obtengo el valor de los parametros
        vehiculo.setId(Integer.parseInt(txtId.getText()));
        vehiculo.setIdModelo(modelo.getIdModelo());
        vehiculo.setIdConcesionario(conce.getIdConcesionario());
        vehiculo.setColor(txtColor.getText());
        vehiculo.setSerie(txtSerie.getText());

        try {
            //lamo al metodo
            vehiculoDAO.modificar(vehiculo);
            //muestro el mensaje en caso de que se ejecute correctamente
            JOptionPane.showMessageDialog(null, "Registro Actualizado!!!");
            //muestro la tabla para que se actualicen los registros
            mostrarTablaVehiculos();
        } catch (Exception e) {
            //muestro el error 
            System.err.println("Error: " + e.getMessage());
            //muestro el mensaje en caso de que no se ejecute 
            JOptionPane.showMessageDialog(null, "Error al actualizar!!!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tablaVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVehiculoMouseClicked

        int fila = this.tablaVehiculo.getSelectedRow();

        this.txtId.setText(this.tablaVehiculo.getValueAt(fila, 0).toString());
        this.txtColor.setText(this.tablaVehiculo.getValueAt(fila, 3).toString());
        this.txtSerie.setText(this.tablaVehiculo.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_tablaVehiculoMouseClicked

    private void popEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popEliminarActionPerformed

        try {
            //llamo al metodo
            vehiculoDAO.eliminar(Integer.parseInt(txtId.getText()));
            //muestro un mensaje de que se ejecuto bien
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente!!!");
            //muestro la tabla para que se apliquen los cambios 
            mostrarTablaVehiculos();

        } catch (Exception e) {
            //muestro un mensaje en caso de que haya ocurrido un error al ejecutar
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro!!!");
            //muestro el mensaje de error en caso de que no se haya ejecutado correctamente
            System.err.println("Error al eliminar" + e.getMessage());
        }
    }//GEN-LAST:event_popEliminarActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmVehiculo().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmVehiculo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboConcesionario;
    private javax.swing.JComboBox<String> comboModelo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem popEliminar;
    private javax.swing.JTable tablaVehiculo;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
