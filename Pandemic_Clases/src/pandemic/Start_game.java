package pandemic;


// TODO: Auto-generated Javadoc
/**
 * The Class Start_game.
 */
public class Start_game {
	
	/** The cont. */
	static int cont = 0;

	/**
	 * Start.
	 *
	 * @param Infeccion the infeccion
	 */
	public static void Start(int Infeccion) {
		// TODO Auto-generated method stub

		busc_ciudad bc = new busc_ciudad();

		bc.SaveInfCiu(Infeccion);
		cont ++;
		System.out.println("Contador rondas: " + cont);
		//GuardarBD.rondas = cont;
	}

	
}
