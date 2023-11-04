/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2_kenken;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
/**
 *
 * @author amontero
 */
public class SoundPlayer {

    public void playSound(String pathToSound){
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(pathToSound));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e){
            e.printStackTrace();
            System.out.println("Excepcion en el audio...");
        }
        
    }
}
