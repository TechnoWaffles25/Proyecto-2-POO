package proyecto_2_kenken.classes;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
/**
 *
 * @author amontero
 */
@XmlRootElement
public class KenKen {
    private List<Partida> partidas;
    
    public List<Partida> getPartidas(){
        return partidas;
    }
    public void setPartidas(List<Partida> pPartidas){
       partidas = pPartidas;
    }
}
