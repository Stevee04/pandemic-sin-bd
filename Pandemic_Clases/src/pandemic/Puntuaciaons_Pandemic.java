package pandemic;

// TODO: Auto-generated Javadoc
/**
 * The Class Puntuaciaons_Pandemic.
 */
public class Puntuaciaons_Pandemic {
	
	/** dificultad. */
	static int dificultad = 0;// 
	
	/** vacunasNum. */
	static int vacunasNum = 0;// cuantas vacunas se han realizado en la partida
	
	/** vacunasCompletadas. */
	static int vacunasCompletadas = 0; // cuantas vacunas se han realizado en la partida

	/**
	 * Puntuacion partida.
	 */
	public static int puntuacionPartida() {
		// algunos de los valores son para hacer pruebas, luego se tendrán que modificas
		int totalPuntos = 0; // puntos totales para el ranking
		int puntosBase = 300; // puntos base del juego

		int contarInfecciones = busc_ciudad.contarInfecciones(); // cuantas enfermedades han quedado tras perder o ganar la partida
		int contarBrotes = busc_ciudad.contarBrotes(); // ciuantos brotes han quedado tras ganar o perder la partida
		int puntosPerdidos = 0; // total de putos perdidos

		boolean victoria = true; // es victoria o derrota
		int puntosGanados = 0; // total de puntos ganados
		
		vacunasCompletadas += vacunasNum;

		puntosPerdidos = calculoPuntosPerdidos(contarBrotes, contarInfecciones); // calcula los puntos perdidos
		puntosGanados = calculoPuntosGanados(victoria, puntosBase, vacunasCompletadas); // calcula los
		
		System.out.println(puntosPerdidos);
		System.out.println(puntosGanados);

		totalPuntos = puntosGanados - puntosPerdidos; // total de puntos calculados para el ranking

		System.out.println(totalPuntos); // testeo de resultados
		
		return totalPuntos;
	}

	/**
	 * Gets the vacunas.
	 *
	 * @return the vacunas
	 */
	public static int getVacunas(){
		return vacunasCompletadas;
	}
	
	/**
	 * Calculo puntos perdidos.
	 *
	 * @param contarBrotes the contar brotes
	 * @param contarInfecciones the contar infecciones
	 * @return the int
	 */
	// calcula los puntos perdidos al final de la partida
	public static int calculoPuntosPerdidos(int contarBrotes, int contarInfecciones) {
		int puntosPerdidos = 0;

		puntosPerdidos = (contarBrotes * 50) + (contarInfecciones * 10);

		return puntosPerdidos;
	}

	/**
	 * Calculo puntos ganados.
	 *
	 * @param victoria the victoria
	 * @param puntosBase the puntos base
	 * @param vacunasCompletadas the vacunas completadas
	 * @return the int
	 */
	// calcula los puntos ganados al final de la partida
	public static int calculoPuntosGanados(boolean victoria, int puntosBase, int vacunasCompletadas) {

		int puntosGanados = 0;

		switch (dificultad) {
		case 1:

			if (victoria == true) {

				puntosGanados = 100 + 400 + (vacunasCompletadas * 100);

			} else {
				puntosGanados = 0;
			}
			break;
		case 2:

			if (victoria == true) {

				puntosGanados = 200 + 400 + (vacunasCompletadas * 100);

			} else {
				puntosGanados = 0;
			}
			break;
		case 3:

			if (victoria == true) {

				puntosGanados = 300 + 400 + (vacunasCompletadas * 100);

			} else {
				puntosGanados = 0;
			}
			break;
		}

		return puntosGanados;
	}
}
