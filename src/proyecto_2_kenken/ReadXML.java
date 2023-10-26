/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2_kenken;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import org.xml.sax.SAXException;

public class ReadXML {
    public void ReadXMLFile() {
        try {
            // Load and parse the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("kenken_partidas.xml")); // Replace with your XML file path

            // Choose the difficulty level to load (e.g., "Facil")
            String desiredDifficulty = "Facil";

            // Get the list of <partida> elements
            NodeList partidaList = document.getElementsByTagName("partida");

            // Loop through <partida> elements and load the one with the desired difficulty
            for (int i = 0; i < partidaList.getLength(); i++) {
                Element partida = (Element) partidaList.item(i);
                Element nivelDeDificultad = (Element) partida.getElementsByTagName("nivel_de_dificultad").item(0);
                String difficulty = nivelDeDificultad.getTextContent();

                if (desiredDifficulty.equals(difficulty)) {
                    // You have found the <partida> with the desired difficulty, you can now process it
                    processPartida(partida);
                    break; // Optional: exit the loop after finding the matching partida
                }
            }
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void processPartida(Element partida) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            // Create a JFrame to hold the grid of buttons
            JFrame frame = new JFrame("KenKen Puzzle");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(6, 6));

            // Create an array to keep track of the buttons for each cell
            JButton[][] buttons = new JButton[6][6];

            // Extract the jaula data
            NodeList jaulaList = partida.getElementsByTagName("jaula");
            for (int i = 0; i < jaulaList.getLength(); i++) {
                Element jaula = (Element) jaulaList.item(i);
                String[] jaulaData = jaula.getTextContent().split(", "); // Split by comma and space

                // Extract jaulaData and create a button for each cell
                int value = Integer.parseInt(jaulaData[0]);
                char operation = jaulaData[1].charAt(0);

                for (int j = 2; j < jaulaData.length; j++) {
                    String cellData = jaulaData[j].substring(1, jaulaData[j].length() - 1); // Remove parentheses
                    String[] cellCoordinates = cellData.split(","); // Split by comma

                    int row = Integer.parseInt(cellCoordinates[0]) - 1;
                    int col = Integer.parseInt(cellCoordinates[1]) - 1;

                    JButton button = new JButton(value + " " + operation);

                    // Customize button appearance based on the operation (you can further customize this)
                    if (operation == 'x') {
                        button.setBackground(Color.GREEN);
                    } else if (operation == '+') {
                        button.setBackground(Color.BLUE);
                    } else if (operation == '-') {
                        button.setBackground(Color.RED);
                    } else if (operation == '/') {
                        button.setBackground(Color.YELLOW);
                    }

                    buttons[row][col] = button;
                }
            }

            // Create buttons for any remaining cells
            for (int row = 0; row < 6; row++) {
                for (int col = 0; col < 6; col++) {
                    if (buttons[row][col] == null) {
                        JButton button = new JButton("");
                        buttons[row][col] = button;
                    }
                    frame.add(buttons[row][col]);
                }
            }

            frame.setSize(400, 400);
            frame.setVisible(true);
        }
    });
}

}

