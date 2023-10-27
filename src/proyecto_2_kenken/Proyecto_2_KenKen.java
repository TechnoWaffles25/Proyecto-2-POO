package proyecto_2_kenken;

import proyecto_2_kenken.ventanas.MenuPrincipal;
import proyecto_2_kenken.classes.*;

public class Proyecto_2_KenKen {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReadPartidaXML reader = new ReadPartidaXML();
                Partida partida = reader.parseXML();

                if (partida != null) {
                    System.out.println("goofy ahh");
                }
                MenuPrincipal gui = new MenuPrincipal(); // Create an instance of the GUI class
                gui.setVisible(true); // Make the GUI visible
            }
         });
    }
    
}
