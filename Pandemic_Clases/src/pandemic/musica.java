package pandemic;
import java.net.URL;
import javax.sound.sampled.*;

/**
 * La Classe musica.
 */
public class musica {
	// Variable global
	private Clip clip; // variable de instancia para el Clip

	// -----------------------------------------------------
	/*
	 * menuMusic. 
	 * Función: menu de contro de la musica del juego
	 * Entrada: void
	 * Salida: void
	 */
	// -----------------------------------------------------
	public void menuMusic() {
		try {
			URL url = main.class.getResource("/musica/PuebloLavanda.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();

			// Cambiar el volumen a la mitad
			// Obtener el control de volumen del clip
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

			// Cambiar el volumen a la mitad
			gainControl.setValue(-10.0f); // -6dB equivale a la mitad del volumen

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// -----------------------------------------------------
	/*
	 * stopMusic. 
	 * Función: para la musica
	 * Entrada: void
	 * Salida: void
	 */
	// -----------------------------------------------------
	public void stopMusic() {
		if (clip != null) {
			clip.stop();
			clip.close();
			clip = null;
		}
	}

	// -----------------------------------------------------
	/*
	 * playmusica. 
	 * Función: inicia la musica
	 * Entrada: void
	 * Salida: void
	 */
	// -----------------------------------------------------
	public void playmusica() {

		try {
			URL url = main.class.getResource("/musica/PuebloTerracota.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();

			// Cambiar el volumen a la mitad
			// Obtener el control de volumen del clip
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

			// Cambiar el volumen a la mitad
			gainControl.setValue(-0.0f); // -6dB equivale a la mitad del volumen

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
