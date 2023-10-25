/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2_kenken.classes;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author amontero
 */
public class Cell {
    private int row;
    private int col;
    private int value;
    
    
    public Cell (int pRow, int pCol, int pVal){
        row = pRow;
        col = pCol;
        value = pVal;
    }
    
    @XmlElement
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return col;
    }
    public int getValue(){
        return value;
    }
    public void setRow(int pRow){
        row = pRow;
    }
    public void setColumn(int pCol){
        col = pCol;
    }
    public void setValue(int pValue){
        value = pValue;
    }
}
