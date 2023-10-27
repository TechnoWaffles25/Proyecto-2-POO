package proyecto_2_kenken;

import java.io.File;
import java.io.FileInputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import proyecto_2_kenken.classes.*;

public class ReadPartidaXML {
    public Partida parseXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Create a File object with the given file path
            File xmlFile = new File("kenken_partidas2.xml");

            // Check if the file exists
            if (!xmlFile.exists()) {
                System.out.println("El xml no existe tonto.");
                return null;
            }

            // Create a FileInputStream to read the file
            FileInputStream fileInputStream = new FileInputStream(xmlFile);
        
            // Parse the XML using the FileInputStream
            Document doc = builder.parse(fileInputStream);
                
            // Retrieve the first Partida element (assuming at least one exists)
            NodeList partidas = doc.getElementsByTagName("partida");
            if (partidas.getLength() > 0) {
                Element partidaElement = (Element) partidas.item(0);
                
                // Extract difficulty level
                String nivelDeDificultad = partidaElement.getElementsByTagName("nivel_de_dificultad").item(0).getTextContent();

                // Extract Cages (Jaula)
                NodeList jaulas = partidaElement.getElementsByTagName("jaula");
                // Creamos la lista de jaulas para la partida
                List<Jaula> jaulaList = new ArrayList<>();

                for (int i = 0; i < jaulas.getLength(); i++) {
                    Element jaulaElement = (Element) jaulas.item(i);

                    // Extract target and operation from Jaula
                    int target = Integer.parseInt(jaulaElement.getElementsByTagName("target").item(0).getTextContent());
                    String operationString = jaulaElement.getElementsByTagName("operation").item(0).getTextContent();
                    char operation = operationString.charAt(0);
                    
                    // Extract Cells within the Jaula
                    NodeList cells = jaulaElement.getElementsByTagName("cell");
                    // Creamos la lista de celdas para la jaula 
                    List<Cell> cellList = new ArrayList<>();

                    for (int j = 0; j < cells.getLength(); j++) {
                        Element cellElement = (Element) cells.item(j);

                        // Extract row, col, and target_value
                        int row = Integer.parseInt(cellElement.getElementsByTagName("row").item(0).getTextContent());
                        int col = Integer.parseInt(cellElement.getElementsByTagName("col").item(0).getTextContent());
                        int targetValue = Integer.parseInt(cellElement.getElementsByTagName("target_value").item(0).getTextContent());

                        // Create a Cell object
                        Cell cell = new Cell(row, col, targetValue);
                        cellList.add(cell);
                    }

                    // Create a Jaula object
                    Jaula jaula = new Jaula(target, operation, cellList);
                    jaulaList.add(jaula);
                }

                // Create the Partida object
                return new Partida(nivelDeDificultad, jaulaList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
