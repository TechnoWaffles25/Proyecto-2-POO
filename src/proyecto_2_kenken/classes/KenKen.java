/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2_kenken.classes;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

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
