package proyecto_2_kenken;

import java.io.Serializable;
import java.time.Duration;

public class Data implements Serializable{
    private static final long serialVersionUID = 123456789L;
    private final String dificultad;
    private final String reloj;
    private final boolean posicion;
    private final boolean sonido;
    private final Duration duration;
    
    public Data(String pDificultad, String pReloj, boolean pPosicion, boolean pSonido, Duration pDuration){
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
    public boolean getPosicion(){
        return posicion;
    }
    public boolean getSonido(){
        return sonido;
    }
    public Duration getDuration(){
        return duration;
    }
    
}
