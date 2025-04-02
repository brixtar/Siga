/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.view.save.JRPdfSaveContributor.*;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.save.JRMultipleSheetsXlsSaveContributor.*;




/**
 *
 * @author BayBay
 */
public class IniciarReporte {
    static String bd = "siga";
   static String login = "root";
   static String password = "";
   static String url = "jdbc:mysql://localhost/"+bd;

   Connection conn = null;
   public IniciarReporte(){
       try{
//obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         conn = DriverManager.getConnection(url,login,password);
         if (conn!=null){
            System.out.println("Conección a base de datos "+bd+". listo");
         }
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
   }
   
   public void ejecutarReporte(String protocolo_lab,String reporte){
       try{
           String archivo = "C:\\Users\\BayBay\\Documents\\NetBeansProjects\\Siga1\\src\\Reportes\\"+reporte+".jasper";
           System.out.println("Cargando desde: " + archivo);
           if(archivo == null){
              System.out.println("No se encuentra el archivo. ");
           System.exit(2); 
           }
           JasperReport masterReport = null;  
       try{
           masterReport =(JasperReport)JRLoader.loadObject(new File(archivo));
       }catch(JRException e){
           System.out.println("Error cargando el reporte maestro: "+ e.getMessage());
           System.exit(3);
       }
       //este es el parametro
       Map parametro = new HashMap();
       parametro.put("protocolo_lab",protocolo_lab);
       //reporte diseñado y compilado con ireport
       JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro, conn);
       //Se lanza el viewer de jasper, no termina aplicacion al salir
       JasperViewer jviewer = new JasperViewer(jasperPrint,false);
       jviewer.setTitle("Geniz-Report");
       jviewer.setVisible(true);
       }catch(Exception j){
           System.out.println("Mensaje de Error:" + j.getMessage());
       }
   }
   public void cerrar(){
       try{
           conn.close();
       }catch(SQLException ex){
           ex.printStackTrace();
       }
   }
}
