package pandemic;
import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class VacunasPor.
 */
public class VacunasPor {
	
	/** The Alfa. */
	int Alfa = 0;
	
	/** The Beta. */
	int Beta = 0;
	
	/** The Delta. */
	int Delta = 0;
	
	/** The Gama. */
	int Gama = 0;
	
	/** The repetir. */
	int repetir[] = {0,0,0,0};
	
	/**
	 * Gets the alfa.
	 *
	 * @return the alfa
	 */
	public int getALFA() {
		return Alfa;
	}

	/**
	 * Gets the beta.
	 *
	 * @return the beta
	 */
	public int getBETA() {
		return Beta;
	}

	/**
	 * Gets the delta.
	 *
	 * @return the delta
	 */
	public int getDELTA() {
		return Delta;
	}

	/**
	 * Gets the gama.
	 *
	 * @return the gama
	 */
	public int getGAMA() {
		return Gama;
	}
	
	/**
	 * Sets the alfa.
	 *
	 * @param cantidad the new alfa
	 */
	public void setALFA(int cantidad) {
		Alfa += cantidad;
		System.out.println(Alfa);
	}

	/**
	 * Sets the beta.
	 *
	 * @param cantidad the new beta
	 */
	public void setBETA(int cantidad) {
		Beta += cantidad;		
		System.out.println(Beta);
	}

	/**
	 * Sets the delta.
	 *
	 * @param cantidad the new delta
	 */
	public void setDELTA(int cantidad) {
		Delta += cantidad;
		System.out.println(Delta);
	}

	/**
	 * Sets the gama.
	 *
	 * @param cantidad the new gama
	 */
	public void setGAMA(int cantidad) {
		Gama += cantidad;
		System.out.println(Gama);
	}
	
	
	
	/**
	 * Gets the alfa image.
	 *
	 * @return the alfa image
	 */
	public ImageIcon getAlfaImage() {
		String imagePath ="/play/loadAlfa/Alfa"+Alfa+".png";
		if (Alfa == 100 && repetir[0] != 1) {
			Puntuaciaons_Pandemic.vacunasNum = 1;
			repetir[0] = 1;
		}
		return new ImageIcon(Play.class.getResource(imagePath));
	}
	
	/**
	 * Gets the beta image.
	 *
	 * @return the beta image
	 */
	public ImageIcon getBetaImage() {
		String imagePath = "/play/loadBeta/Beta"+Beta+".png";
		if (Beta == 100 && repetir[1] != 1) {
			Puntuaciaons_Pandemic.vacunasNum = 1;
			repetir[1] = 1;
		}
		return new ImageIcon(Play.class.getResource(imagePath));
	}
	
	/**
	 * Gets the delta image.
	 *
	 * @return the delta image
	 */
	public ImageIcon getDeltaImage() {
		String imagePath ="/play/loadDelta/Delta"+Delta+".png";
		if (Delta == 100 && repetir[2] != 1) {
			Puntuaciaons_Pandemic.vacunasNum = 1;
			repetir[2] = 1;
		}
		return new ImageIcon(Play.class.getResource(imagePath));
	}
	
	/**
	 * Gets the gama image.
	 *
	 * @return the gama image
	 */
	public ImageIcon getGamaImage() {
		String imagePath ="/play/loadGama/Gama"+Gama+".png";
		if (Gama == 100 && repetir[3] != 1) {
			Puntuaciaons_Pandemic.vacunasNum = 1;
			repetir[3] = 1;
		}
		return new ImageIcon(Play.class.getResource(imagePath));
	}

}
