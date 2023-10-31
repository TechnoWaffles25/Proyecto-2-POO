package proyecto_2_kenken;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import proyecto_2_kenken.classes.*;

public class ReadPartidaXML {
    public Partida parseKenKenPartidas(String fileName, String difficulty) {
        try {
            File xmlFile = new File(fileName);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Root element
            Element root = doc.getDocumentElement();

            // Find the specified difficulty element
            NodeList difficultyList = root.getElementsByTagName(difficulty);
            if (difficultyList.getLength() > 0) {
                Element difficultyElement = (Element) difficultyList.item(0);

                // Find all partida elements within the specified difficulty
                NodeList partidaList = difficultyElement.getElementsByTagName("partida");

                // Check if there are any partida elements
                if (partidaList.getLength() > 0) {
                    // Choose a random partida
                    int randomPartidaIndex = (int) (Math.random() * partidaList.getLength());
                    Element partidaElement = (Element) partidaList.item(randomPartidaIndex);

                    // Create a list to store cells
                    List<Cell> cells = new ArrayList<>();

                    // Find all cell elements within the random partida
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

                    // Create a Partida object with the list of cells
                    Partida partida = new Partida(cells);

                    // Return the Partida object
                    return partida;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null in case of an error or if no partida is found
    }
}
