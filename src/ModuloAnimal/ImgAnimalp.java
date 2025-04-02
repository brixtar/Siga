/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ModuloAnimal;

import ModuloDueño.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Ale
 */
public class ImgAnimalp extends javax.swing.JPanel {
    
    
    public ImgAnimalp(){    
        this.setSize(128,128);
    }
    
   
   
    @Override
    //public void paintComponent(Graphics g){
    public void paint(Graphics g){
        //Dimension tamanio = getSize();
        
      
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/animalp.png"));                                 
        g.drawImage(imagenFondo.getImage(),0,0,128,128, null);                
                   
        setOpaque(false);
        super.paintComponent(g);
    }    
}

