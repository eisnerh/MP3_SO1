package AppPackage;

import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
public class MainClass 
{
    FileInputStream fis;
    BufferedInputStream bis;
    
    public Player player;
    //guarda lo que queda de la canción
    public long pauseLocation;
    
    //guarda el total de la canción
    public long totalCancion;
    
    public String fileLocation;
    
    public void Stop()
    {
        if (player != null)
        {
            player.close();
            // deteniendo el archivo los valores iniciales serán 0
            pauseLocation = 0;
            totalCancion = 0;
        }
    }
    
    public void Pause()
    {
        if (player != null)
        {
            try {
                
                pauseLocation = fis.available();
                player.close();
            } catch (IOException ex) {
                
            }
            
        }
    }
    
    public void Play(String ruta)
    {
        try {
            fis = new FileInputStream(ruta);
            bis = new BufferedInputStream(fis);
            
            player = new Player(bis);
            
            totalCancion = fis.available();
            
            fileLocation = ruta + "";
            
        } catch (FileNotFoundException | JavaLayerException ex) {
            
        } catch (IOException ex) {
           
        }
    
        
        new Thread()
        {
            @Override
            public void run()
            {
                try {
                    player.play();
                } catch (JavaLayerException ex) {
                    
                }
            }
        }
                .start();
    }
    
    public void Resume()
    {
        try {
            fis = new FileInputStream(fileLocation);
            bis = new BufferedInputStream(fis);
            
            player = new Player(bis);
            
            fis.skip(totalCancion - pauseLocation);
        } catch (FileNotFoundException | JavaLayerException ex) {
            
        } catch (IOException ex) {
            
        }
    
        
        new Thread()
        {
            @Override
            public void run()
            {
                try {
                    player.play();
                } catch (JavaLayerException ex) {
                    
                }
            }
        }
                .start();
    }
    
}
