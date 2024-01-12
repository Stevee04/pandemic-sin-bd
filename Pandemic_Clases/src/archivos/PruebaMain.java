package archivos;

// TODO: Auto-generated Javadoc
/**
 * The Class PruebaMain.
 */
public class PruebaMain {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	// Es el main del Juego Pandemic
	public static void main(String[] args) {
		
		// hace referencia a las clases
		P_Ciudades ciudades = new P_Ciudades();
		P_Virus virus = new P_Virus();
		
		// ejecuta GenerarCiudades de la clase ciudades
		ciudades.GenerarCiudades();
		
		// ejecuta VirusCiudades de la clase virus
		virus.VirusCiudades();
		
		
	}

}
