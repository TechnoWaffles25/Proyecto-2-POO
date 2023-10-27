/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2_kenken.classes;

import java.util.List;

/**
 *
 * @author amonteros
 */
public class Partida {
    private String dificultad;
    private List<Jaula> cages;
    
    public Partida(String pDificultad, List<Jaula> pCages){
        dificultad = pDificultad;
        cages = pCages;
    }
    public List<Jaula> getCages(){
        return cages;
    }
    public void setCages(List<Jaula> pCages){
        cages = pCages;
    }
    public String getDificultad(){
        return dificultad;
    }
    public void setDifiultad(String pDificultad){
        dificultad = pDificultad;
    }
}