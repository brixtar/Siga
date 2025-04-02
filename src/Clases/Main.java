/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Ale
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //probamos la conexion a la base de datos
        ConexionBD test = new ConexionBD();
        
        
        //codigo substance
        JFrame.setDefaultLookAndFeelDecorated(true); //que nos permite dejar a Substance la decoracion ( por asi decirlo) 
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");//aplicamos skin deseado
        SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceGenericNoiseWatermark");//aplicamos marca de agua 
        PantallaPrincipal principal = new PantallaPrincipal();
        principal.show();  
    }
    
}
