package pandemic;
/**
 * The Class Vacunas.
 */
public class VacunasBD {

	// Variables globales
	private int id_vacunas;
	private String nombreVacuna;
	private int porcentajeRealizado;
	
	// -----------------------------------------------------
	/*
	 * Instantiates a new vacunas.
	 * Función: es la encargada de restar infeciones de las ciudades
	 * Entrada: 
	 * @param id_vacunas the id vacunas
	 * @param nombreVacuna the nombre vacuna
	 * @param porcentajeRealizado the porcentaje realizado
	 */
	// -----------------------------------------------------
	public VacunasBD(int id_vacunas, String nombreVacuna, int porcentajeRealizado) {
		super();
		this.id_vacunas = id_vacunas;
		this.nombreVacuna = nombreVacuna;
		this.porcentajeRealizado = porcentajeRealizado;
	}

	/**
	 * Gets the id vacunas.
	 *
	 * @return the id vacunas
	 */
	public int getid_Vacunas() {
		return id_vacunas;
	}

	/**
	 * Sets the id vacunas.
	 *
	 * @param id_vacunas the new id vacunas
	 */
	public void setid_Vacunas(int id_vacunas) {
		this.id_vacunas = id_vacunas;
	}

	/**
	 * Gets the nombre vacuna.
	 *
	 * @return the nombre vacuna
	 */
	public String getnombreVacuna() {
		return nombreVacuna;
	}

	/**
	 * Sets the nombre vacuna.
	 *
	 * @param nombreVacuna the new nombre vacuna
	 */
	public void setnombreVacuna(String nombreVacuna) {
		this.nombreVacuna = nombreVacuna;
	}

	/**
	 * Gets the porcentaje realizado.
	 *
	 * @return the porcentaje realizado
	 */
	public int getporcentajeRealizado() {
		return porcentajeRealizado;
	}

	/**
	 * Sets the porcentaje realizado.
	 *
	 * @param domicilio the new porcentaje realizado
	 */
	public void setporcentajeRealizado(int domicilio) {
		this.porcentajeRealizado = domicilio;
	}

	// -----------------------------------------------------
	/*
	 * toString. 
	 * Función: da la información introducida
	 * Entrada: void
	 * Salida: 
	 * @return the string
	 */
	// -----------------------------------------------------
	@Override
	public String toString() {
		return "Vacunas [Vacunas= " + this.id_vacunas + ", nombre= " + this.nombreVacuna + this.porcentajeRealizado
				+ " %" + "]";
	}
}
