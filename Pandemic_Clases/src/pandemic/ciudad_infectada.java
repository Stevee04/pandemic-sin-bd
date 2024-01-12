package pandemic;


// TODO: Auto-generated Javadoc
/**
 * The Class ciudad_infectada.
 */
public class ciudad_infectada {
	
	/** The Ciudad. */
	private String Ciudad; 
	
	/** The Infeccion. */
	private int Infeccion;
	
	/** The Brote. */
	private int Brote;
	
	/** The num ciu. */
	private int numCiu;
	
	/** The Virus. */
	private String Virus;
	
	/**
	 * Instantiates a new ciudad infectada.
	 */
	public ciudad_infectada() {
		
	}

	/**
	 * Instantiates a new ciudad infectada.
	 *
	 * @param numCiu the num ciu
	 * @param Ciudad the ciudad
	 * @param Infeccion the infeccion
	 * @param Brote the brote
	 * @param Virus the virus
	 */
	public ciudad_infectada( int numCiu, String Ciudad, int Infeccion, int Brote, String Virus) {
		this.Ciudad = Ciudad;
		this.Infeccion = Infeccion;
		this.Brote = Brote;
		this.numCiu = numCiu;
		this.Virus = Virus;
	}

	/**
	 * Gets the ciudad.
	 *
	 * @return the ciudad
	 */
	public String getCiudad() {
		return Ciudad;
	}

	/**
	 * Gets the infeccion.
	 *
	 * @return the infeccion
	 */
	public int getInfeccion() {
		return Infeccion;
	}
	
	/**
	 * Gets the num ciudad.
	 *
	 * @return the num ciudad
	 */
	public int getNumCiudad() {
		return numCiu;
	}
	
	/**
	 * Sets the infeccion.
	 *
	 * @param nueva_infeccion the new infeccion
	 */
	public void setInfeccion(int nueva_infeccion) {
	    this.Infeccion = nueva_infeccion;
	}
	
	/**
	 * Sets the brote.
	 *
	 * @param nuevo_brote the new brote
	 */
	public void setBrote(int nuevo_brote) {
	    this.Brote = nuevo_brote;
	}

	/**
	 * Gets the brote.
	 *
	 * @return the brote
	 */
	public int getBrote() {
		return Brote;
	}

	/**
	 * Gets the virus.
	 *
	 * @return the virus
	 */
	public String getVirus() {
		return Virus;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {

		return (this.getCiudad() + ", " + this.getInfeccion() + ", " + this.getBrote() + ", " + this.getNumCiudad() + ", " + this.getVirus());
		
		}
	}