
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class PlayMusic {

	void music(String musicLocation) {
		try {
			File musicPath = new File(musicLocation);
			if(musicPath.exists()) {
				AudioInputStream audioinput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioinput);
				clip.start();
				
				JOptionPane.showMessageDialog(null, "Press ok to stop playing");
				
			}
			else {
				System.out.println("Cant find file");
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
