/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Clases.MySQL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author BayBay
 */
public class EstadisticaAnalisisDocenteAlumno extends javax.swing.JInternalFrame {
private IniciarReporte2 jasper;
    /**
     * Creates new form EstadisticaAnalisisDocenteAlumno
     */
    public EstadisticaAnalisisDocenteAlumno() {
        initComponents();
        jcbLista.setVisible(false);
        jlApellidoNombre.setVisible(false);
        jDateChooser1.setDate(new Date());
        jDateChooser2.setDate(new Date());
        String dia = Integer.toString(jDateChooser1.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(jDateChooser1.getCalendar().get(Calendar.MONTH) + 1);
        String year = Integer.toString(jDateChooser1.getCalendar().get(Calendar.YEAR));
        String fecha = (year + "-" + mes+ "-" + dia);
        jlFecha1.setText("2015-1-1");
        jlFecha2.setText(fecha);
        jasper = new IniciarReporte2();
    }
    private void cargarLista(){
    dcLista = lista.GetColumna("doctor", "dni_doctor", "SELECT * FROM doctor");
    // se colocan los datos en la tabla
        DefaultComboBoxModel datos = new DefaultComboBoxModel(dcLista);
        jcbLista.setModel(datos);
        int a = jcbLista.getItemCount();
        //depurador de jcbRaza de item null
        int i=0;
        a--;
        while(a>=i){
            if(jcbLista.getItemAt(i)==null){
                jcbLista.removeItemAt(i);
                a--;
                i--;
            }
            i++;
        }
    doctorAP();        
}
    private void cargarLista2(){
    dcLista = lista.GetColumna("alumno", "dni_alumno", "SELECT * FROM alumno");
    // se colocan los datos en la tabla
        DefaultComboBoxModel datos = new DefaultComboBoxModel(dcLista);
        jcbLista.setModel(datos);
        int a = jcbLista.getItemCount();
        //depurador de jcbRaza de item null
        int i=0;
        a--;
        while(a>=i){
            if(jcbLista.getItemAt(i)==null){
                jcbLista.removeItemAt(i);
                a--;
                i--;
            }
            i++;
        }
    alumnoAP();
}    
private void doctorAP(){
        String dni= (String)jcbLista.getSelectedItem();
            String apellido = lista.GetData("apellido", "SELECT apellido FROM doctor WHERE dni_doctor = \""+dni+"\"");
            String nombre = lista.GetData("nombre", "SELECT nombre FROM doctor WHERE dni_doctor = \""+dni+"\"");
        jlApellidoNombre.setText(apellido+", "+ nombre);        
}
private void alumnoAP(){
        String dni= (String)jcbLista.getSelectedItem();
            String apellido = lista.GetData("apellido", "SELECT apellido FROM alumno WHERE dni_alumno = \""+dni+"\"");
            String nombre = lista.GetData("nombre", "SELECT nombre FROM alumno WHERE dni_alumno = \""+dni+"\"");
        jlApellidoNombre.setText(apellido+", "+ nombre);        
}
private void fechaLabel (){
        String comparar =jcbLista3.getSelectedItem().toString();
        String comparar2 ="Todas las Fechas";
        String comparar3 ="Un Año";
        String comparar4 ="Un Mes";
        String comparar5 ="Una Semana";
        String comparar6 ="Un Dia";
        String comparar7 ="Tiempo Especifico";
        String dia = Integer.toString(jDateChooser1.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(jDateChooser1.getCalendar().get(Calendar.MONTH) + 1);
        String year = Integer.toString(jDateChooser1.getCalendar().get(Calendar.YEAR));
        String fecha = (year + "-" + mes+ "-" + dia);
        DateFormat fecha0 = new SimpleDateFormat("yyyy-MM-dd");
        Date nacio = jDateChooser2.getDate();        
        if(comparar2==comparar){
        jlFecha1.setText("1990-1-1");
        jlFecha2.setText("2050-1-1");   
        }
        if(comparar3==comparar){
        jlFecha1.setText(year+"-1-1");
        jlFecha2.setText(year+"-12-31");   
        }
        if(comparar4==comparar){
        jlFecha1.setText(year + "-" + mes+ "-1");
        dia = Integer.toString(jDateChooser1.getCalendar().getActualMaximum(Calendar.DAY_OF_MONTH));
        jlFecha2.setText(year + "-" + mes+ "-" + dia);   
        }
        if(comparar5==comparar){
        int diaSemana = jDateChooser1.getCalendar().get(Calendar.DAY_OF_WEEK);
        int diaSemana2 = 8 - diaSemana;
        int diaSemana3 = diaSemana-2;
        nacio = jDateChooser1.getDate();
        Calendar fecha3 = Calendar.getInstance();
        fecha3.setTime(nacio);
        fecha3.add(Calendar.DATE, -diaSemana3 );
        //Date fecha4 = fecha3.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format1.format(fecha3.getTime());
        jlFecha1.setText(formatted.toString());
        //jlFecha1.setText(fecha4.toString());
        fecha3.setTime(nacio);
        fecha3.add(Calendar.DATE, diaSemana2 );
        //fecha4 = fecha3.getTime();
        formatted = format1.format(fecha3.getTime());
        jlFecha2.setText(formatted.toString());
        /*SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        String fecha5 = fecha4.toString().trim() ;  
        Date dato = null;
            try {
            dato = formatoDelTexto.parse(fecha5);
            } catch (ParseException ex) {
            ex.printStackTrace();
            }
            jDateChooser2.setDate(dato);*/
        }
        if(comparar6==comparar){
        jlFecha1.setText(fecha);
        jlFecha2.setText(fecha);   
        }
        if(comparar7==comparar){
        jlFecha1.setText(fecha);
        jlFecha2.setText(fecha0.format(nacio));
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

        jLabel1 = new javax.swing.JLabel();
        jcbLista2 = new javax.swing.JComboBox();
        jcbLista = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jcbLista3 = new javax.swing.JComboBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jlFecha1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlFecha2 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jlApellidoNombre = new javax.swing.JLabel();
        jbReporte = new javax.swing.JButton();

        setClosable(true);
        setTitle("Estadistica Consultas de Docentes y Alumnos");
        setVisible(false);

        jLabel1.setText("Seleccione sobre quien es la estadistica:");

        jcbLista2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos Docentes y alumnos", "Todos Docentes", "Todos Alumnos", "Solo un Docente", "Solo un Alumno" }));
        jcbLista2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbLista2ItemStateChanged(evt);
            }
        });

        jcbLista.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbListaItemStateChanged(evt);
            }
        });

        jLabel2.setText("Selecione el tiempo el cual se encuentre la estadistica:");

        jcbLista3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas las Fechas", "Un Año", "Un Mes", "Una Semana", "Un Dia", "Tiempo Especifico" }));
        jcbLista3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbLista3ItemStateChanged(evt);
            }
        });

        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jLabel3.setText("Estadistica entre las fechas:");

        jlFecha1.setText("jLabel4");

        jLabel5.setText("y");

        jlFecha2.setText("jLabel6");

        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });

        jlApellidoNombre.setText("apellido,nombre");

        jbReporte.setText("Ver Informe");
        jbReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jcbLista3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jcbLista2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jcbLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                        .addGap(203, 203, 203))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jlApellidoNombre)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jlFecha1)
                        .addGap(85, 85, 85)
                        .addComponent(jLabel5)
                        .addGap(82, 82, 82)
                        .addComponent(jlFecha2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(jbReporte)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbLista2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlApellidoNombre))
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbLista3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFecha1)
                    .addComponent(jLabel5)
                    .addComponent(jlFecha2))
                .addGap(55, 55, 55)
                .addComponent(jbReporte)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbLista2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbLista2ItemStateChanged
        // TODO add your handling code here:
        jcbLista.setVisible(false);
        jlApellidoNombre.setVisible(false);
        String comparar =jcbLista2.getSelectedItem().toString();
        String comparar2 ="Solo un Docente";
        String comparar3 ="Solo un Alumno";
        if(comparar2==comparar){
        cargarLista();
        jcbLista.setVisible(true);
        jlApellidoNombre.setVisible(true);
        }
        if(comparar3==comparar){
        cargarLista2(); 
        jcbLista.setVisible(true);
        jlApellidoNombre.setVisible(true);
        }
    }//GEN-LAST:event_jcbLista2ItemStateChanged

    private void jcbListaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbListaItemStateChanged
        // TODO add your handling code here:
        String comparar =jcbLista2.getSelectedItem().toString();
        String comparar2 ="Solo un Docente";
        String comparar3 ="Solo un Alumno";
        if(comparar2==comparar){
        doctorAP();   
        }
        if(comparar3==comparar){
        alumnoAP();   
        }
    }//GEN-LAST:event_jcbListaItemStateChanged

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        // TODO add your handling code here:
        fechaLabel();
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
        // TODO add your handling code here:
        fechaLabel();
    }//GEN-LAST:event_jDateChooser2PropertyChange

    private void jcbLista3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbLista3ItemStateChanged
        // TODO add your handling code here:
        fechaLabel();
    }//GEN-LAST:event_jcbLista3ItemStateChanged

    private void jbReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReporteActionPerformed
        // TODO add your handling code here:
        String reporte="newReport1";
        String fecha1 = jlFecha1.getText();
        String fecha2 = jlFecha2.getText();
        String dni= jcbLista.getSelectedItem().toString();
        jasper.ejecutarReporte(dni,fecha1,fecha2,reporte);
    }//GEN-LAST:event_jbReporteActionPerformed

    MySQL lista = new MySQL(); 
    Object[] dcLista;
    Object[] dcLista2;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbReporte;
    private javax.swing.JComboBox jcbLista;
    private javax.swing.JComboBox jcbLista2;
    private javax.swing.JComboBox jcbLista3;
    private javax.swing.JLabel jlApellidoNombre;
    private javax.swing.JLabel jlFecha1;
    private javax.swing.JLabel jlFecha2;
    // End of variables declaration//GEN-END:variables
}
