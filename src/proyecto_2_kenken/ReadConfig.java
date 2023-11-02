/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2_kenken;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.Duration;

/**
 *
 * @author amontero
 */
public class ReadConfig {
    private Data config;
    
    public void readConfiguration() {
        try (FileInputStream fileInputStream = new FileInputStream("config.dat");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
       
            config = (Data) objectInputStream.readObject();
            System.out.println("Dificultad: " + config.getDificultad());
            System.out.println("Reloj: " + config.getReloj());
            System.out.println("Lado Panel: " + config.getPosicion());
            System.out.println("Sonido: " + config.getSonido());
            System.out.println("Tiempo Juego: " + config.getDuration());
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public String getDificultad(){
        return config.getDificultad();
    }
    public String getReloj(){
        return config.getReloj();
    }
    public boolean getPosicion(){
        return config.getPosicion();
    }
    public boolean getSonido(){
        return config.getSonido();
    }
    public Duration getDuration(){
        return config.getDuration();
    }
}
