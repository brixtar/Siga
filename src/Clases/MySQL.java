/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Ale
 */
public class MySQL {
  ConexionBD con;
  
  public MySQL (){
    con = new ConexionBD();
  } 
  public int contarregistros(String tabla){
      int registros=0;
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM " + tabla);
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
      return registros;
  }

  /*  METODO PARA DETERMINAR SI UN REGISTRO YA EXISTE EN LA BASE DE DATOS
      TIENE COMO PARAMETROS (nombre de la tabla, nombre columna,
   */
  public boolean existe(String tabla, String colName, String id){
     int registros = 0;
     try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM " + tabla + " where " + colName + " = ?");
         pstm.setString(1, id);
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
     if (registros >0){return true;}else{return false;}    
  }
  
  /* INSERTRA UN NUEVO REGISTRO EN LA BASE DE DATOS
   * PARAMETROS(Un array de String con los datos a insertar,la instruccion sql)
   */
  public void InsertarRegistro(String datos[], String sql){
       try {          
            PreparedStatement pstm = con.getConnection().prepareStatement(sql);            
            for(int i=0; i<=datos.length-1;i++){
                pstm.setString(i+1, datos[i]);             
            }             
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp==0){ 
            pstm.execute();
            pstm.close(); 
            JOptionPane.showMessageDialog(null, "Registro Guardado");}     
            
            
         }catch(SQLException e){
         System.out.println(e);
      }
   }
     
  /* BORRA UN REGISTRO DE LA BASE DE DATOS
   * parametros (Nombre de la tabla, nombre columna, Codigo unico)
   */
  public void DeleteRegistro(String tabla, String col, String id){  
            try {                
                PreparedStatement pstm = con.getConnection().prepareStatement("delete from " + tabla + " where " + col + " = ?");
                pstm.setString(1, id);                   
                pstm.execute();
                pstm.close();            
            }catch(SQLException e){
            System.out.println(e);
            }            
   }
  
  /* ACTUALIZA UNA TABLA DE LA BASE DE DATOS
   * parametros (Un Array de string con los datos a actualizar, la instruccion sql )
   */
    public void UpdateRegistro(String datos[], String sql){
       try {
            PreparedStatement pstm = con.getConnection().prepareStatement(sql);      
            for(int i=0; i<=datos.length-1;i++){
                pstm.setString(i+1, datos[i]);        
            }  
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp==0){ 
            pstm.execute();
            pstm.close();   
            JOptionPane.showMessageDialog(null, "Registro Actualizado");
            }
         }catch(SQLException e){
         System.out.println(e);
      }
   }
    
   /*  METODO PARA OBTENER TODOS LOS DATOS DE UNA TABLA
    *  parametros (Un array con los nombres de las columnas, el nombre de la tabla, la instruccion sql)
    */
public Object [][] GetTabla(String colName[], String tabla, String sql){
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM " + tabla);
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
      
    Object[][] data = new String[registros][colName.length];  
    String col[] = new String[colName.length];
    
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement(sql);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){            
            for(int j=0; j<=colName.length-1;j++){
                col[j] = res.getString(colName[j]);
                data[i][j] = col[j];            
            }          
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }  
 
/* METODO PARA TODOS LOS DATOS DE UNA COLUMNA
 * parametros (Nombre de la tabla, nombre columna, instruccion sql )
 */
public Object [] GetColumna(String tabla, String colName, String sql){
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM " + tabla);
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
      
    Object[] data = new String[registros];    
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement(sql);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){            
            data[i] = res.getString(colName);
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }  

/* METODO PARA OBTENER UN DATO DE UNA TABLA
    PARAMETROS (nombre columna, instruccion sql)
 */
public String GetData(String colName, String sql){
    String data = new String();    
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement(sql);
         ResultSet res = pstm.executeQuery();         
         while(res.next()){            
            data = res.getString(colName);        
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }  

}
