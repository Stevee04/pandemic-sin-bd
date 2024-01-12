package archivos;

import java.io.*;
import java.text.DecimalFormat;

/**
 * Classe P_Ciudades.
 */
public class P_Ciudades {

	// Variables que guardan archivos
	String GuardarCiudades = "ciudadesRedactadas.txt";
	String ciudades = "ciutats.txt";

	// Variables de importación
	DecimalFormat df = new DecimalFormat("#.00");

	// Variables globales
	String fraseLeida = null;
	String[] fraseEnPartes = null;
	String[] partesXY1 = null;
	String[] partesXY2 = null;
	String[] partesCiudades = null;
	double distanciatotal = 0;

	// -----------------------------------------------------
	/*
	 * GenerarCiudades. 
	 * Función: ? 
	 * Entrada: void 
	 * Salida: void
	 */
	// -----------------------------------------------------
	public void GenerarCiudades() {
		// ---------------------------------
		try {
			// Variables ficheros
			FileReader fr = new FileReader(ciudades);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(GuardarCiudades, true);
			BufferedWriter bw = new BufferedWriter(fw);

			do {
				// lee línea
				fraseLeida = br.readLine();

				if (fraseLeida != null) {
					fraseEnPartes = fraseLeida.split(";");

					partesXY1 = fraseEnPartes[2].split(",");
					partesCiudades = fraseEnPartes[3].split(",");

					bw.write("La ciudad " + fraseEnPartes[0] + " esta en las cordenadas (" + fraseEnPartes[2]
							+ ") sus ciudades colindantes son: ");
					fw.flush();
					bw.flush();
					bw.newLine();

					for (int i = 0; i < partesCiudades.length; i++) {
						// coje las coordenadas de la función
						partesXY2 = cordenadas2(fr, br, i);
						distanciatotal = ClacularCor();

						bw.write("• " + partesCiudades[i] + ", que esta a una distancia de "
								+ df.format(distanciatotal));
						fw.flush();
						bw.flush();
						bw.newLine();
					}
					fw.flush();
					bw.flush();
					bw.newLine();
				}
			} while (fraseLeida != null);
			bw.close();

		} catch (IOException e) {
			System.out.println(" Error E/S: " + e);
		}
		// ---------------------------------
	}

	// -----------------------------------------------------
	/*
	 * ClacularCor. 
	 * Función: calcula las coordenadas de las ciudades 
	 * Entrada: void
	 * @return the long
	 */
	// -----------------------------------------------------
	public long ClacularCor() {
		// Variables de la función
		double ciudad1PosX = Integer.parseInt(partesXY1[0]);
		double ciudad1PosY = Integer.parseInt(partesXY1[1]);
		double ciudad2PosX = Integer.parseInt(partesXY2[0]);
		double ciudad2PosY = Integer.parseInt(partesXY2[1]);
		long distancia = 0;

		distancia = (long) Math.sqrt(Math.pow(ciudad2PosX - ciudad1PosX, 2) + Math.pow(ciudad2PosY - ciudad1PosY, 2));

		return distancia;
	}

	// -----------------------------------------------------
	/*
	 * cordenadas2. 
	 * Función: ? 
	 * Entrada:
	 * @param fr the fr
	 * @param br the br
	 * @param i the i
	 * @return the string[]
	 */
	// -----------------------------------------------------
	public String[] cordenadas2(FileReader fr, BufferedReader br, int i) {
		// Variables de la función
		String[] partes_frase = null;
		String linea = null;

		try {

			// Se inicializa para que empieze a leer el archivo desde 0
			fr = new FileReader(ciudades);
			br = new BufferedReader(fr);

			do {

				// Lee la linea
				linea = br.readLine();

				// Si el pueblo/ciudad es el mismo que el conyucente devuelve las cordenadas
				if (linea != null) {
					partes_frase = linea.split(";");
					if (partes_frase[0].equals(partesCiudades[i])) {
						partesXY2 = partes_frase[2].split(",");
					}
				}

			} while (linea != null);

			// Cierra el archivo
			fr.close();
			br.close();

		} catch (IOException e) {
			System.out.println(" Error E/S: " + e);
		}

		// Devuelve las cordenadas
		return partesXY2;
	}

}
