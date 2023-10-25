package proyecto_2_kenken;

 import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
/**
 *
 * @author fabri
 */
public class LeerXMLKenKen {
   

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("kenken_partidas.xml");

            Element kenKen = document.getDocumentElement();
            NodeList jaulas = kenKen.getElementsByTagName("jaula");

            // Itera a través de las jaulas
            for (int i = 0; i < jaulas.getLength(); i++) {
                Node jaulaNode = jaulas.item(i);
                if (jaulaNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element jaula = (Element) jaulaNode;

                    // Obtiene el contenido de la jaula para obtener el tipo
                    String contenido = jaula.getTextContent();

                    System.out.println("Contenido: " + contenido);
                }
            }

            // También puedes acceder a las constantes
            Element constantes = (Element) kenKen.getElementsByTagName("constantes").item(0);
            String constantesTexto = constantes.getTextContent();
            System.out.println("Constantes: " + constantesTexto);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
