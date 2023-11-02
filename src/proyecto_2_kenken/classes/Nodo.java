/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2_kenken.classes;

/**
 *
 * @author fabri
 */
public class Nodo {
    private String valoranterior;
    private int coll;
    private int row;
    public Nodo predecesor;
    public Nodo sucesor;
    
    Nodo(int columna, int fila, String numerocambiado){
        coll=columna;
        row=fila;
        valoranterior=numerocambiado;
        predecesor=null;
        sucesor=null;
    }
    public int getCol(){
        return coll;
    }
    public int getRow(){
        return row;
    }
    public String getValorAnterior(){
        return valoranterior;
    }
    @Override 
    public String toString(){
        System.out.println("Valor anterior: " + valoranterior);
        System.out.println("Columna: " + coll);
        System.out.println("Fila: " + row);
        //System.out.println("Predecesor: " + predecesor.toString());
        //System.out.println("Sucesor: " + sucesor.toString());
        return "";
    }
}
