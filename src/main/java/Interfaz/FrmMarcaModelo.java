/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import DAO.MarcaDAO;
import DAO.ModeloDAO;
import Entidad.Marca;
import Entidad.Modelo;
import java.awt.event.ItemEvent;
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
public final class FrmMarcaModelo extends javax.swing.JFrame {

    Marca marca = new Marca();
    MarcaDAO marcaDAO = new MarcaDAO();
    Modelo modelo = new Modelo();
    ModeloDAO modeloDAO = new ModeloDAO();

    /**
     * Creates new form FrmModelosMarca
     *
     * @throws java.sql.SQLException
     */
    public FrmMarcaModelo() throws SQLException {
        initComponents();
        comboBoxMarca();
        mostrarTablaModelosMarca(((Marca) comboMarca.getSelectedItem()).getIdMarca());

    }

    private void comboBoxMarca() throws SQLException {
        //Creo un nuevo objeto de tipo DefaultComboBoxModel y llamo al metodo
        DefaultComboBoxModel modeloMarca = new DefaultComboBoxModel(this.marcaDAO.mostrarMarcas());
        //añado el objeto al modeloMarca
        comboMarca.setModel(modeloMarca);
    }

    public void mostrarTablaModelosMarca(int pIdMarca) {
        //se crea un nuevo objeto de tipo DefaultTableModel
        DefaultTableModel modelo = new DefaultTableModel();

        //añado las columnas al modelo
        modelo.addColumn("ID");
        modelo.addColumn("IDMARCA");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("MODELO");
        modelo.addColumn("AÑO");
        modelo.addColumn("PRECIO");

        //Agrego el modelo a la tabla
        tablaModelo.setModel(modelo);

        String datos[] = new String[6];

        try {
            //Creo una nueva lista de tipo Marca
            List<Modelo> lstModelo = marcaDAO.listarModelos(pIdMarca);

            //se recorre la lista para obtener los valores de la lista 
            lstModelo.forEach(m -> {

                //se obtienen los valores de la lista
                datos[0] = String.valueOf(m.getIdModelo());
                datos[1] = String.valueOf(m.getIdMarca());
                datos[2] = m.getNombre();
                datos[3] = m.getModelo();
                datos[4] = String.valueOf(m.getAnio());
                datos[5] = String.valueOf(m.getPrecio());

                //se añaden los datos al modelo
                modelo.addRow(datos);
            });
        } catch (Exception e) {
            //muestro mensaje de error en caso de que no se ejecute correctamente
            System.out.println("Error al obtener datos " + e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboMarca = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaModelo = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modelos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setText("Marca");

        comboMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboMarcaItemStateChanged(evt);
            }
        });

        tablaModelo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaModelo);

        jButton2.setText("Cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 464, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        FrmMarca ventana = new FrmMarca();

        ventana.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboMarcaItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            //alumno = (Alumno) comboalumnos.getSelectedItem();
            this.mostrarTablaModelosMarca(((Marca) comboMarca.getSelectedItem()).getIdMarca());
        }
    }//GEN-LAST:event_comboMarcaItemStateChanged

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
            java.util.logging.Logger.getLogger(FrmMarcaModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMarcaModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMarcaModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMarcaModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new FrmMarcaModelo().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(FrmMarcaModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboMarca;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaModelo;
    // End of variables declaration//GEN-END:variables
}