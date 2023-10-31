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
    public String valoranterior;
    public int coll;
    public int row;
    public Nodo predecesor;
    public Nodo sucesor;
    
    Nodo(int columna, int fila, String numerocambiado){
        coll=columna;
        row=fila;
        valoranterior=numerocambiado;
        predecesor=null;
        sucesor=null;
    }
    
}
