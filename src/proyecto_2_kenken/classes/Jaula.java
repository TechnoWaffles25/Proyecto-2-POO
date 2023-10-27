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
public class Jaula {
    private int target;
    private char operation;
    private List<Cell> cells;
   
    public Jaula(int pTarget, char pOperation, List<Cell> pCells){
        target = pTarget;
        operation = pOperation;
        cells = pCells;
    }
    public int getTarget(){
        return target;
    }
    public char getOperation(){
        return operation;
    }
    public List<Cell> getCells(){
        return cells;
    }
    
    public void setTarget(int pTarget){
        target = pTarget;
    }
    public void setOperation(char pOperation){
        operation = pOperation;
    }
    public void setCells(List<Cell> pCells){
        cells = pCells;
    }
}
