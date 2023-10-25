package proyecto_2_kenken;

import proyecto_2_kenken.classes.KenKen;
import proyecto_2_kenken.classes.Partida;
import proyecto_2_kenken.classes.Jaula;
import proyecto_2_kenken.classes.Cell;

import proyecto_2_kenken.classes.Grid;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateXML {
    
    public GenerateXML() throws JAXBException {
        try{
            // Nuevo Archivo KenKen
            KenKen kenken = new KenKen();
            // Creamos la lista de partidas;
            List<Partida> partidas = new ArrayList<>();
            // -----------------------------------------------------------------
            // Partida 1 Facil
            Partida partida1F = new Partida();
            
            // Creamos el grid de partida1F
            Grid grid1F = new Grid();
            grid1F.setSize("6x6");
            
            // Creamos las lista de jaulas para ese tablero
            List <Jaula> jaulas1F = new ArrayList<>();
            
            // Jaula(Numero Jaula / Dificultad / Numero partida por dificultad)
            Jaula jaula1F1 = new Jaula();
            jaula1F1.setTarget(11);
            jaula1F1.setOperation('+');
            
            // Creamos la lista de celdas de jaula1F1
            List<Cell> cellsJ1F1 = new ArrayList<>();
            Cell cell1J1F1 = new Cell(1,1,5);
            cellsJ1F1.add(cell1J1F1);
            Cell cell2J1F1 = new Cell(1, 2,4);
            cellsJ1F1.add(cell2J1F1);
            Cell cell3J1F1 = new Cell(2, 1,2);
            cellsJ1F1.add(cell3J1F1);
            
            // Agregamos la jaula a la lista de jaulas
            jaula1F1.setCells(cellsJ1F1);
            jaulas1F.add(jaula1F1);
            //-----------------------------------------------------------------
            grid1F.setCages(jaulas1F);
            partida1F.setGrid(grid1F);
            kenken.setPartidas(partidas);

            
            
            // Create a JAXB context for the KenKen class
            JAXBContext context = JAXBContext.newInstance(KenKen.class);

            // Create a Marshaller
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Marshal the KenKen object to an XML file
            marshaller.marshal(kenken, new File("kenken_partidas.xml"));

            System.out.println("XML file generated successfully using JAXB with predefined classes.");
        } catch(JAXBException e) {
            e.printStackTrace();
        }
    }
}
