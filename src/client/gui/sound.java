package client.gui;
import java.io.FileInputStream;  
  
import sun.audio.*;  
  
public class sound {  
    
	public static void main(String args[]) {  
        try {  
            // 1.wav 文件放在java project 下面  
            FileInputStream fileau = new FileInputStream(  
                    System.getProperty("user.dir") + "\\I want to eat.wav");  

            AudioStream as = new AudioStream(fileau);  
            AudioPlayer.player.start(as);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
}
