/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloAnimal;

import Clases.MySQL;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BayBay
 */
public class EspecieRazaAnimalP extends javax.swing.JInternalFrame {

    /**
     * Creates new form AMEspecie
     */
    public EspecieRazaAnimalP() {
        initComponents();
        ImgAnimalp img = new ImgAnimalp();
        jpimagen.add(img);
        jpimagen.repaint();
        cargarTabla();
        cargarEspecies();
        cargarEspecies2();
        cargarRazas();
        cargarRazas2();
    }
    private void cargarTabla(){
        if (jrbEspecie.isSelected() == true) {
        String[] columNames = {"Codigo de Especie","Nombre de la especie"};          
        String colName[] = {"cod_especie","especie"}; 
        //nombre de columnas, tabla, instruccion sql
        dtAnimal = animal.GetTabla(colName, "lista_especie", "SELECT  *FROM `lista_especie`");
// se colocan los datos en la tabla
        DefaultTableModel datos = new DefaultTableModel(dtAnimal,columNames);                        
        jtEspecie.setModel(datos);
        }
        if (jrbEspecieRaza.isSelected() == true) {
        String[] columNames = {"Codigo de Especie","Nombre de la especie","Codigo de Raza","Nombre de la raza"};          
        String colName[] = {"cod_especie","especie","cod_raza","raza"}; 
        //nombre de columnas, tabla, instruccion sql
        dtAnimal = animal.GetTabla(colName, "lista_especie,lista_raza", "SELECT  *FROM `lista_especie`,`lista_raza`WHERE `lista_especie`.`cod_especie` =`lista_raza`.`cod_especie`");
// se colocan los datos en la tabla
        DefaultTableModel datos = new DefaultTableModel(dtAnimal,columNames);                        
        jtEspecie.setModel(datos);
        // se colocan los datos en la tabla
        int a = jtEspecie.getRowCount();
        //depurador de jtDuenio de item null
        int i=0;
        a--;
        while(a>=i){
            if(jtEspecie.getValueAt(i,1)==null){
                ((DefaultTableModel)jtEspecie.getModel()).removeRow(i);
                a--;
                i--;
            }
            i++;
        }
        }
    }
    private void desbloquearAgregar(){
        jcbEspecie.setEnabled(true);
        jcbRaza.setEnabled(true);
        jbActualizarRaza.setEnabled(false);
        jbActualizarEspecie.setEnabled(false);
        jbCrearRaza.setEnabled(false);
        jbAgregarRaza.setEnabled(true);
        jbAgregarEspecie.setEnabled(true);
        jbAgregarEspecie2.setEnabled(false);
        jbAgregarRaza2.setEnabled(false);
        jtfEspecie.setEnabled(false);
        jtfRaza.setEnabled(false);
    }
    private void desbloquearModificar(){
        jcbEspecie.setEnabled(false);
        jcbRaza.setEnabled(false);
        jbAgregarRaza.setEnabled(false);
        jbCrearRaza.setEnabled(true);
        jbAgregarEspecie2.setEnabled(true);
        jbAgregarEspecie.setEnabled(false);
        jtfEspecie.setEnabled(true);
        jbActualizarEspecie.setEnabled(true);
        if (jrbEspecieRaza.isSelected() == true) {
        jtfRaza.setEnabled(true);
        jbAgregarRaza2.setEnabled(true);
        jbActualizarRaza.setEnabled(true);
        }else{
            jtfRaza.setEnabled(false);
        jbAgregarRaza2.setEnabled(false);
        jbActualizarRaza.setEnabled(false);
        }
    }

    private void cargarEspecies(){
        //nombre de columnas, tabla, instruccion sql
        dcEspecie = animal.GetColumna("lista_especie", "especie", "SELECT * FROM `lista_especie");
        // se colocan los datos en la tabla
        DefaultComboBoxModel datos = new DefaultComboBoxModel(dcEspecie);
        jcbEspecie.setModel(datos);
    }
    private void cargarEspecies2(){
        //nombre de columnas, tabla, instruccion sql
        dcEspecie = animal.GetColumna("lista_especie", "especie", "SELECT * FROM `lista_especie");
        // se colocan los datos en la tabla
        DefaultComboBoxModel datos = new DefaultComboBoxModel(dcEspecie);
        jcbEspecie2.setModel(datos);
    }
    private void cargarRazas(){
        jcbRaza.removeAllItems();
        String especie = jcbEspecie.getSelectedItem().toString();
               String cod_especie = animal.GetData("cod_especie", "SELECT cod_especie FROM lista_especie WHERE especie = \""+especie+"\"");
        //nombre de columnas, tabla, instruccion sql
        dcRaza = animal.GetColumna("lista_raza", "raza", "SELECT * FROM lista_raza WHERE cod_especie =\""+cod_especie+"\"");
                // se colocan los datos en la tabla
        DefaultComboBoxModel datos = new DefaultComboBoxModel(dcRaza);
        jcbRaza.setModel(datos);
        int a = jcbRaza.getItemCount();
        //depurador de jcbRaza de item null
        int i=0;
        a--;
        while(a>=i){
            if(jcbRaza.getItemAt(i)==null){
                jcbRaza.removeItemAt(i);
                a--;
                i--;
            }
            i++;
        }
 }
    private void cargarRazas2(){
       jcbRaza2.removeAllItems(); 
       String especie = jcbEspecie2.getSelectedItem().toString();
       String cod_especie = animal.GetData("cod_especie", "SELECT cod_especie FROM lista_especie WHERE especie = \""+especie+"\"");
        //nombre de columnas, tabla, instruccion sql
        dcRaza = animal.GetColumna("lista_raza", "raza", "SELECT * FROM lista_raza WHERE cod_especie =\""+cod_especie+"\"");        
        // se colocan los datos en la tabla
        DefaultComboBoxModel datos = new DefaultComboBoxModel(dcRaza);
        jcbRaza2.setModel(datos);
        int a = jcbRaza2.getItemCount();
        //depurador de jcbRaza de item null
        int i=0;
        a--;
        while(a>=i){
            if(jcbRaza2.getItemAt(i)==null){
                jcbRaza2.removeItemAt(i);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmiModificarEspecie = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jbAgregarRaza = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcbEspecie = new javax.swing.JComboBox();
        jbAgregarEspecie = new javax.swing.JButton();
        jcbRaza = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jbActualizarRaza = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jlCodigoEspecie = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbEspecie2 = new javax.swing.JComboBox();
        jbAgregarEspecie2 = new javax.swing.JButton();
        jcbRaza2 = new javax.swing.JComboBox();
        jbAgregarRaza2 = new javax.swing.JButton();
        jtfEspecie = new javax.swing.JTextField();
        jbActualizarEspecie = new javax.swing.JButton();
        jtfRaza = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jlCodigoRaza = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEspecie = new javax.swing.JTable();
        jrbEspecie = new javax.swing.JRadioButton();
        jrbEspecieRaza = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jpimagen = new javax.swing.JPanel();
        jbCrearRaza = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();

        jmiModificarEspecie.setText("Modificar");
        jmiModificarEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiModificarEspecieActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmiModificarEspecie);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AGREGAR NUEVA ESPECIE O RAZA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jbAgregarRaza.setText("Agregar Raza");
        jbAgregarRaza.setEnabled(false);
        jbAgregarRaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarRazaActionPerformed(evt);
            }
        });

        jLabel1.setText("Especie:");

        jLabel4.setText("Raza:");

        jcbEspecie.setEnabled(false);
        jcbEspecie.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbEspecieItemStateChanged(evt);
            }
        });

        jbAgregarEspecie.setText("Agregar Especie");
        jbAgregarEspecie.setEnabled(false);
        jbAgregarEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarEspecieActionPerformed(evt);
            }
        });

        jcbRaza.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcbEspecie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbRaza, 0, 119, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbAgregarRaza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbAgregarEspecie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAgregarEspecie))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregarRaza)
                    .addComponent(jLabel4)
                    .addComponent(jcbRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MODIFICAR  ESPECIE O RAZA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setText("Especie:");

        jbActualizarRaza.setText("Actualizar Raza");
        jbActualizarRaza.setEnabled(false);
        jbActualizarRaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarRazaActionPerformed(evt);
            }
        });

        jLabel3.setText("Codigo Especie:");

        jLabel5.setText("Raza:");

        jcbEspecie2.setEnabled(false);
        jcbEspecie2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbEspecie2ItemStateChanged(evt);
            }
        });

        jbAgregarEspecie2.setText("Agregar Especie");
        jbAgregarEspecie2.setEnabled(false);
        jbAgregarEspecie2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarEspecie2ActionPerformed(evt);
            }
        });

        jcbRaza2.setEnabled(false);

        jbAgregarRaza2.setText("Agregar Raza");
        jbAgregarRaza2.setEnabled(false);
        jbAgregarRaza2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarRaza2ActionPerformed(evt);
            }
        });

        jtfEspecie.setEnabled(false);

        jbActualizarEspecie.setText("Actualizar Especie");
        jbActualizarEspecie.setEnabled(false);
        jbActualizarEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarEspecieActionPerformed(evt);
            }
        });

        jtfRaza.setEnabled(false);

        jLabel6.setText("Codigo Raza:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addComponent(jlCodigoEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jLabel6)
                .addGap(35, 35, 35)
                .addComponent(jlCodigoRaza, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jcbEspecie2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(25, 25, 25))
                        .addComponent(jtfEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbRaza2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfRaza, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbActualizarRaza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbAgregarEspecie2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbActualizarEspecie, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(jbAgregarRaza2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbEspecie2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAgregarEspecie2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbActualizarEspecie))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbRaza2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAgregarRaza2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbActualizarRaza)
                    .addComponent(jtfRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlCodigoEspecie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlCodigoRaza, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel3)))
                        .addContainerGap(18, Short.MAX_VALUE))))
        );

        jtEspecie.setModel(new javax.swing.table.DefaultTableModel(
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
        jtEspecie.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jtEspecie);

        buttonGroup1.add(jrbEspecie);
        jrbEspecie.setSelected(true);
        jrbEspecie.setText("Especie");
        jrbEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbEspecieActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbEspecieRaza);
        jrbEspecieRaza.setText("Especie con Razas");
        jrbEspecieRaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbEspecieRazaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jrbEspecie)
                .addGap(35, 35, 35)
                .addComponent(jrbEspecieRaza)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbEspecie)
                    .addComponent(jrbEspecieRaza))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpimagen.setPreferredSize(new java.awt.Dimension(128, 128));

        javax.swing.GroupLayout jpimagenLayout = new javax.swing.GroupLayout(jpimagen);
        jpimagen.setLayout(jpimagenLayout);
        jpimagenLayout.setHorizontalGroup(
            jpimagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );
        jpimagenLayout.setVerticalGroup(
            jpimagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );

        jbCrearRaza.setText("Agregar Nueva Raza");
        jbCrearRaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearRazaActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpimagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbCrearRaza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jpimagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbCrearRaza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbCancelar)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiModificarEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiModificarEspecieActionPerformed
        // TODO add your handling code here:
        int filamodificar = jtEspecie.getSelectedRow();
        if (jrbEspecie.isSelected() == true) {
            desbloquearModificar();
           if (filamodificar >= 0) {
            jlCodigoEspecie.setText(jtEspecie.getValueAt(filamodificar, 0).toString());
            jcbEspecie2.setSelectedItem(jtEspecie.getValueAt(filamodificar, 1).toString());
            jtfEspecie.setText(jtEspecie.getValueAt(filamodificar, 1).toString());
            } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado ");
        } 
        }
        if (jrbEspecieRaza.isSelected() == true) {
        if (filamodificar >= 0) {
            desbloquearModificar();
            jlCodigoEspecie.setText(jtEspecie.getValueAt(filamodificar, 0).toString());
            jcbEspecie2.setSelectedItem(jtEspecie.getValueAt(filamodificar, 1).toString());
            jtfEspecie.setText(jtEspecie.getValueAt(filamodificar, 1).toString());
            jlCodigoRaza.setText(jtEspecie.getValueAt(filamodificar, 2).toString());
            jcbRaza2.setSelectedItem(jtEspecie.getValueAt(filamodificar, 3).toString());
            jtfRaza.setText(jtEspecie.getValueAt(filamodificar, 3).toString());
            } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado ");
        }
        }
    }//GEN-LAST:event_jmiModificarEspecieActionPerformed

    private void jbCrearRazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearRazaActionPerformed
        // TODO add your handling code here:
        desbloquearAgregar();
    }//GEN-LAST:event_jbCrearRazaActionPerformed

    private void jbAgregarRazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarRazaActionPerformed
        // TODO add your handling code here:
        String especie= (String)jcbEspecie.getSelectedItem();
        String cod_especie = animal.GetData("cod_especie", "SELECT cod_especie FROM lista_especie WHERE especie = \""+especie+"\"");
        String nuevaraza = JOptionPane.showInputDialog(rootPane,"Ingrese una raza para "+especie+"","Nueva Raza",WIDTH);
        boolean aux = animal.existe("lista_raza", "raza", nuevaraza);
        if (aux==true){
            JOptionPane.showMessageDialog(rootPane, "El registro ya existe");
        }else{
            String dato[]= {cod_especie,nuevaraza};
            animal.InsertarRegistro(dato, "insert into lista_raza (`cod_especie`,`raza`)values(?,?)");
        cargarRazas();
        cargarRazas2();
        }
    }//GEN-LAST:event_jbAgregarRazaActionPerformed

    private void jbActualizarRazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarRazaActionPerformed
        // TODO add your handling code here:
        String raza = jtfRaza.getText();
        String cod_raza = jlCodigoRaza.getText();
        String datos[] = {raza,cod_raza};
        animal.UpdateRegistro(datos, "UPDATE `lista_raza`SET`raza`=? WHERE `cod_raza`=?");
        cargarTabla();
        cargarRazas();
        cargarRazas2();
    }//GEN-LAST:event_jbActualizarRazaActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbAgregarEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarEspecieActionPerformed
        // TODO add your handling code here:
        String nuevaesp = JOptionPane.showInputDialog(rootPane,"Ingrese la especie que desea agregar:","Nueva Especie", WIDTH);
        boolean aux = animal.existe("lista_especie", "especie", nuevaesp);
        if (aux==true){
            JOptionPane.showMessageDialog(rootPane, "El registro ya existe");
        }else{
            String datos[] = {nuevaesp};
            //array de datos , instruccion sql
            animal.InsertarRegistro(datos, "insert into lista_especie (`especie`)values(?)");
            cargarEspecies();
            cargarEspecies2();
        }
    }//GEN-LAST:event_jbAgregarEspecieActionPerformed

    private void jcbEspecieItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbEspecieItemStateChanged
        // TODO add your handling code here:
        cargarRazas();
    }//GEN-LAST:event_jcbEspecieItemStateChanged

    private void jcbEspecie2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbEspecie2ItemStateChanged
        // TODO add your handling code here:
        cargarRazas2();
    }//GEN-LAST:event_jcbEspecie2ItemStateChanged

    private void jbAgregarEspecie2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarEspecie2ActionPerformed
        // TODO add your handling code here:
        String nuevaesp = JOptionPane.showInputDialog(rootPane,"Ingrese la especie que desea agregar:","Nueva Especie", WIDTH);
        boolean aux = animal.existe("lista_especie", "especie", nuevaesp);
        if (aux==true){
            JOptionPane.showMessageDialog(rootPane, "El registro ya existe");
        }else{
            String datos[] = {nuevaesp};
            //array de datos , instruccion sql
            animal.InsertarRegistro(datos, "insert into lista_especie (`especie`)values(?)");
            cargarEspecies();
            cargarEspecies2();
        }
    }//GEN-LAST:event_jbAgregarEspecie2ActionPerformed

    private void jbAgregarRaza2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarRaza2ActionPerformed
        // TODO add your handling code here:
        String especie= (String)jcbEspecie2.getSelectedItem();
        String cod_especie = animal.GetData("cod_especie", "SELECT cod_especie FROM lista_especie WHERE especie = \""+especie+"\"");
        String nuevaraza = JOptionPane.showInputDialog(rootPane,"Ingrese una raza para "+especie+"","Nueva Raza",WIDTH);
        boolean aux = animal.existe("lista_raza", "raza", nuevaraza);
        if (aux==true){
            JOptionPane.showMessageDialog(rootPane, "El registro ya existe");
        }else{
            String dato[]= {cod_especie,nuevaraza};
            animal.InsertarRegistro(dato, "insert into lista_raza (`cod_especie`,`raza`)values(?,?)");
        cargarRazas();
        cargarRazas2();
        }
    }//GEN-LAST:event_jbAgregarRaza2ActionPerformed

    private void jbActualizarEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarEspecieActionPerformed
        // TODO add your handling code here:
        String especie = jtfEspecie.getText();
        String cod_especie = jlCodigoEspecie.getText();
        String datos[] = {especie,cod_especie};
        animal.UpdateRegistro(datos, "UPDATE `lista_especie`SET`especie`=? WHERE `cod_especie`=?");
        cargarTabla();
        cargarEspecies();
        cargarEspecies2();  
    }//GEN-LAST:event_jbActualizarEspecieActionPerformed

    private void jrbEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEspecieActionPerformed
        // TODO add your handling code here:
        cargarTabla();
    }//GEN-LAST:event_jrbEspecieActionPerformed

    private void jrbEspecieRazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEspecieRazaActionPerformed
        // TODO add your handling code here:
        cargarTabla();
    }//GEN-LAST:event_jrbEspecieRazaActionPerformed
    Object[][] dtAnimal; 
    MySQL animal = new MySQL();
    Object[] dcEspecie;
    Object[] dcRaza;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizarEspecie;
    private javax.swing.JButton jbActualizarRaza;
    private javax.swing.JButton jbAgregarEspecie;
    private javax.swing.JButton jbAgregarEspecie2;
    private javax.swing.JButton jbAgregarRaza;
    private javax.swing.JButton jbAgregarRaza2;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbCrearRaza;
    private javax.swing.JComboBox jcbEspecie;
    private javax.swing.JComboBox jcbEspecie2;
    private javax.swing.JComboBox jcbRaza;
    private javax.swing.JComboBox jcbRaza2;
    private javax.swing.JLabel jlCodigoEspecie;
    private javax.swing.JLabel jlCodigoRaza;
    private javax.swing.JMenuItem jmiModificarEspecie;
    private javax.swing.JPanel jpimagen;
    private javax.swing.JRadioButton jrbEspecie;
    private javax.swing.JRadioButton jrbEspecieRaza;
    private javax.swing.JTable jtEspecie;
    private javax.swing.JTextField jtfEspecie;
    private javax.swing.JTextField jtfRaza;
    // End of variables declaration//GEN-END:variables
}
