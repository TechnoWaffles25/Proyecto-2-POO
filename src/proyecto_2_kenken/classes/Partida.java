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
    private List<Cell> cells;
    
    public Partida(List<Cell> pCells){
        cells = pCells;
    }
    public List<Cell> getCells(){
        return cells;
    }
}