/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2_kenken.classes;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amonteros
 */
public class Partida {
    private Grid grid;
    private String dificultad;
    
    @XmlElement
    public Grid getGrid(){
        return grid;
    }
    public String getDificultad(){
        return dificultad;
    }
    public void setGrid(Grid pGrid){
        grid = pGrid;
    }
    public void setDifiultad(String pDificultad){
        dificultad = pDificultad;
    }
}