/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2_kenken.classes;

import javax.xml.bind.annotation.XmlElement;
import javax.swing.JButton;
/**
 *
 * @author amontero
 */
public class Cell extends JButton{
    private int row;
    private int col;
    private int targetValue;
    private int currentValue;
    
    
    public Cell (int pRow, int pCol, int pVal){
        row = pRow;
        col = pCol;
        targetValue = pVal;
    }
    
    @XmlElement
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return col;
    }
    public int getTargetValue(){
        return targetValue;
    }
    public int getCurrentValue(){
        return currentValue;
    }
    public void setRow(int pRow){
        row = pRow;
    }
    public void setColumn(int pCol){
        col = pCol;
    }
    public void setTargetValue(int pValue){
        targetValue = pValue;
    }
    public void setCurrentValue(int pValue){
        currentValue = pValue;
    }
}
