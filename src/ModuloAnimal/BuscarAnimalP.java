/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloAnimal;

import Clases.MySQL;
import Clases.PantallaPrincipal;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BayBay
 */
public class BuscarAnimalP extends javax.swing.JInternalFrame {

    /**
     * Creates new form EliminarAnimalP
     */
    public BuscarAnimalP() {
        initComponents();
        ImgAnimalp img = new ImgAnimalp();
        jpImagen.add(img);
        jpImagen.repaint();
        cargarTabla();
    }

    private void cargarTabla(){
        String[] columNames = {"Apellido","Nombre","DNI","Nombre","Especie","Raza","Peso","Fecha","Sexo","Color","Vivo","Codigo Animal"};          
        String colName[] = {"apellido","nombre","dni_duenio","animal_pequenios.nombre","especie","raza","peso","nacimiento","sexo","color","vivo","cod_animal"};        
//nombre de columnas, tabla, instruccion sql
        dtAnimal = animal.GetTabla(colName, "animal_pequenios, duenio,lista_especie,lista_raza", "SELECT  `duenio`.`nombre`, `duenio`.`apellido`,`lista_especie`.`especie`, `lista_raza`.`raza`,`animal_pequenios`.*FROM animal_pequenios, duenio,lista_especie,lista_raza WHERE (`duenio`.`dni_duenio` =`animal_pequenios`.`dni_duenio`) AND (`animal_pequenios`.`cod_especie` =`lista_especie`.`cod_especie`) AND (`animal_pequenios`.`cod_raza` =`lista_raza`.`cod_raza`)");
// se colocan los datos en la tabla
        DefaultTableModel datos = new DefaultTableModel(dtAnimal,columNames);                        
        jtAnimal.setModel(datos);// se colocan los datos en la tabla
    //depurador de jtDuenio de item null
        int a = jtAnimal.getRowCount();       
        int i=0;
        a--;
        while(a>=i){
            if(jtAnimal.getValueAt(i,1)==null){
                ((DefaultTableModel)jtAnimal.getModel()).removeRow(i);
                a--;
                i--;
            }
            i++;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jtfBuscar = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jrbNombre = new javax.swing.JRadioButton();
        jrbDni = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jbDetalle = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jpImagen = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAnimal = new javax.swing.JTable();

        setClosable(true);
        setTitle("ELIMINAR ANIMAL PEQUEÑO");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Animal Pequeño", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbNombre);
        jrbNombre.setText("Por Nombre Animal");

        buttonGroup1.add(jrbDni);
        jrbDni.setText("Por DNI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbNombre)
                    .addComponent(jrbDni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jrbNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrbDni))
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jbDetalle.setText("Ver Detalle");
        jbDetalle.setMaximumSize(new java.awt.Dimension(93, 23));
        jbDetalle.setPreferredSize(new java.awt.Dimension(93, 23));
        jbDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDetalleActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jpImagen.setPreferredSize(new java.awt.Dimension(128, 128));

        javax.swing.GroupLayout jpImagenLayout = new javax.swing.GroupLayout(jpImagen);
        jpImagen.setLayout(jpImagenLayout);
        jpImagenLayout.setHorizontalGroup(
            jpImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jpImagenLayout.setVerticalGroup(
            jpImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jbDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jtAnimal.setModel(new javax.swing.table.DefaultTableModel(
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
        jtAnimal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAnimalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtAnimal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jtAnimalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAnimalMouseClicked
        // TODO add your handling code here:
        fila=jtAnimal.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_jtAnimalMouseClicked

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // TODO add your handling code here:
                String texto= jtfBuscar.getText();
        String[] columNames = {"Apellido","Nombre","DNI","Nombre","Especie","Raza","Peso","Fecha","Sexo","Color","Vivo","Codigo Animal"};          
        String colName[] = {"apellido","nombre","dni_duenio","animal_pequenios.nombre","especie","raza","peso","nacimiento","sexo","color","vivo","cod_animal"};         //nombre de columnas, tabla, instruccion sql
        //nombre de columnas, tabla, instruccion sql
        if(jrbDni.isSelected()==true){
            dtAnimal = animal.GetTabla(colName, "animal_pequenios, duenio,lista_especie,lista_raza", "SELECT  `duenio`.`nombre`, `duenio`.`apellido`,`lista_especie`.`especie`, `lista_raza`.`raza`,`animal_pequenios`.*FROM animal_pequenios, duenio,lista_especie,lista_raza WHERE `duenio`.`dni_duenio` =`animal_pequenios`.`dni_duenio` AND `animal_pequenios`.`cod_especie` =`lista_especie`.`cod_especie` AND `animal_pequenios`.`cod_raza` =`lista_raza`.`cod_raza` AND `duenio`.`dni_duenio`="+texto+" ");
        }
        if(jrbNombre.isSelected()==true){

            dtAnimal = animal.GetTabla(colName, "animal_pequenios, duenio,lista_especie,lista_raza", "SELECT  `duenio`.`nombre`, `duenio`.`apellido`,`lista_especie`.`especie`, `lista_raza`.`raza`,`animal_pequenios`.*FROM animal_pequenios, duenio,lista_especie,lista_raza WHERE (`duenio`.`dni_duenio` =`animal_pequenios`.`dni_duenio`) AND (`animal_pequenios`.`cod_especie` =`lista_especie`.`cod_especie`) AND (`animal_pequenios`.`cod_raza` =`lista_raza`.`cod_raza`) AND (`animal_pequenios`.`nombre`= \"" + texto + "\") ");
        }      
        DefaultTableModel datos = new DefaultTableModel(dtAnimal,columNames);
        jtAnimal.setModel(datos); // se colocan los datos en la tabla
    //depurador de jtDuenio de item null
        int a = jtAnimal.getRowCount();        
        int i=0;
        a--;
        while(a>=i){
            if(jtAnimal.getValueAt(i,1)==null){
                ((DefaultTableModel)jtAnimal.getModel()).removeRow(i);
                a--;
                i--;
            }
            i++;
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDetalleActionPerformed
        // TODO add your handling code here:
        DetalleAnimal det=new DetalleAnimal();
        PantallaPrincipal.jdpFondo.add(det);
        det.show();
    }//GEN-LAST:event_jbDetalleActionPerformed

    Object[][] dtAnimal;
    Object[] registro;
    MySQL animal = new MySQL();
    int fila = -1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbDetalle;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JPanel jpImagen;
    private javax.swing.JRadioButton jrbDni;
    private javax.swing.JRadioButton jrbNombre;
    public static javax.swing.JTable jtAnimal;
    private javax.swing.JTextField jtfBuscar;
    // End of variables declaration//GEN-END:variables
}
