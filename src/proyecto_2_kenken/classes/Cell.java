/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2_kenken.classes;

import javax.swing.JButton;
/**
 *
 * @author amontero
 */
public class Cell extends JButton{
    private int jailTargetValue;
    private char operation;
    private int row;
    private int col;
    private int targetValue;
    private int currentValue;
    
    
    public Cell (int pJailTargetVal, char pOp, int pRow, int pCol, int pVal){
        jailTargetValue = pJailTargetVal;
        operation = pOp;
        row = pRow;
        col = pCol;
        targetValue = pVal;
    }
    
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return col;
    }
    public int getJailTargetValue(){
        return jailTargetValue;
    }
    public char getOperation(){
        return operation;
    }
    public int getTargetValue(){
        return targetValue;
    }
    public int getCurrentValue(){
        return currentValue;
    }
    @Override
    public String toString() {
        return "Cell [Row: " + row + ", Column: " + col + ", Jail Target Value: " + jailTargetValue +
               ", Operation: " + operation + ", Target Value: " + targetValue + ", Current Value: " + currentValue + "]";
    }
}
