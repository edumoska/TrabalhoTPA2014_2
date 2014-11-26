/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa;

import java.awt.Frame;
import javax.swing.JFrame;
import trabalhotpa.modelo.CursoDummy;
import trabalhotpa.ui.MenuPrincipal;

/**
 *
 * @author Eduardo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MenuPrincipal menu = new MenuPrincipal(new Curso());
        while(menu.menu());
    }
    
}
