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
    public Partida parseKenKenPartidas(String fileName) {
        try {
            File xmlFile = new File(fileName);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Root element
            Element root = doc.getDocumentElement();

            // Find the Facil element
            NodeList facilList = root.getElementsByTagName("Facil");
            if (facilList.getLength() > 0) {
                Element facilElement = (Element) facilList.item(0);

                // Create a list to store cells
                List<Cell> cells = new ArrayList<>();

                // Find the Partida element
                NodeList partidaList = facilElement.getElementsByTagName("partida");
                if (partidaList.getLength() > 0) {
                    Element partidaElement = (Element) partidaList.item(0);

                    // Find all cell elements
                    NodeList cellList = partidaElement.getElementsByTagName("cell");
                    for (int i = 0; i < cellList.getLength(); i++) {
                        Element cellElement = (Element) cellList.item(i);
                        String cellData = cellElement.getTextContent();
                        String[] cellParts = cellData.split(",");

                        if (cellParts.length == 5) {
                            int jailTargetValue = Integer.parseInt(cellParts[0]);
                            char operation = cellParts[1].charAt(0);
                            int row = Integer.parseInt(cellParts[2]);
                            int col = Integer.parseInt(cellParts[3]);
                            int targetValue = Integer.parseInt(cellParts[4]);

                            // Create a Cell object and add it to the list
                            Cell cell = new Cell(jailTargetValue, operation, row, col, targetValue);
                            cells.add(cell);
                        }
                    }
                }
                // Create a Partida object with the list of cells
                Partida partida = new Partida(cells);
                // Return the Partida object
                return partida;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null in case of an error
    }
}
