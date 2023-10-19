package proyecto_2_kenken;

import java.io.Serializable;
import java.time.Duration;

public class Data implements Serializable{
    private String dificultad;
    private String reloj;
    private String posicion;
    private boolean sonido;
    private Duration duration;
    
    public Data(String pDificultad, String pReloj, String pPosicion, boolean pSonido, Duration pDuration){
        dificultad = pDificultad;
        reloj = pReloj;
        posicion = pPosicion;
        duration = pDuration;
        sonido = pSonido;
    }
    
    public String getDificultad(){
        return dificultad;
    }
    public String getReloj(){
        return reloj;
    }
    public String getPosicion(){
        return posicion;
    }
    public boolean getSonido(){
        return sonido;
    }
    
}
