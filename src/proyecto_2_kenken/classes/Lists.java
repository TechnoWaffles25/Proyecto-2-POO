/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2_kenken.classes;
import java.util.ArrayList;
/**
 *
 * @author fabri
 */


public class Lists {
    public Nodo cabeza;
    public Nodo cola;

    public Lists() {
        this.cabeza = null;
    }
    public void agregarJugada(int row, int col, String numerocambiado){
        Nodo newnodo= new Nodo(col,row,numerocambiado);
        if (cabeza==null){
            cabeza=newnodo;
            cola=newnodo;
        }
        else{
            newnodo.predecesor=cola;
            cola.sucesor=newnodo;
            cola=newnodo;
        }
    }
    public Nodo verUltimaJugada(){
        return cola;    
    }
    public Nodo popUltimaJugada() {
    if (cola == null) {
        System.out.println("Lista vacía, retornando null");
        return null;
    }
    if (cola.sucesor==null && cola.predecesor==null){
        Nodo nodo = cola;
        cola=null;
        return nodo;
    }
    else{
        Nodo nodo = cola;
        cola = cola.predecesor;
        cola.sucesor=null;
        return nodo;
        }
    }
}
