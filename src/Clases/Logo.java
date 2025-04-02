/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Ale
 */
public class Logo extends javax.swing.JPanel {
    
    
    public Logo(){    
        this.setSize(600,300);//se selecciona el tamaño del panel
    }
    
  
   
    @Override
    //public void paintComponent(Graphics g){
    //Se crea un método cuyo parámetro debe ser un objeto Graphics
    public void paint(Graphics g){
        
        
      //se dibuja la imagen que tenemos en el paquete
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/logo.png"));                                 
        g.drawImage(imagenFondo.getImage(),0,0,600,300, null);                
                   
        setOpaque(false);
        super.paintComponent(g);
    }    
}