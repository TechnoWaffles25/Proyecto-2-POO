/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2_kenken.classes;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author amontero
 */
public class Grid {
    private String size;
    private List<Jaula> cages;
    
    @XmlElement
    public String getSize(){
        return size;
    }
    public List<Jaula> getCages(){
        return cages;
    }
    public void setSize(String pSize){
        size = pSize;
    }
    public void setCages(List<Jaula> pCages){
        cages = pCages;
    }
}
