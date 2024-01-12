package pandemic;

import archivos.P_Ciudades;
import archivos.P_Virus;

// TODO: Auto-generated Javadoc
/**
 * The Class main.
 */
public class main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		// hace referencia a las clases
		P_Ciudades ciudades = new P_Ciudades();
		P_Virus virus = new P_Virus();
		mouse m = new mouse();

		// ejecuta GenerarCiudades de la clase ciudades
		ciudades.GenerarCiudades();

		// ejecuta VirusCiudades de la clase virus
		virus.VirusCiudades();

		MenuInterfaz.runMenu();

	}
}
