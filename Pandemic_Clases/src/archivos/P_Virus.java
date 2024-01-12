package archivos;

import java.io.*;

/**
 * P_Virus.
 */
public class P_Virus {
	// Variables globales
	int CodigoEnfermedad = 0;
	String NombreEnfermedad = null;
	String ColorEnfermedad = null;
	
	// Variables que guardan archivos
	static String Info = "ciutats.txt";
	static String InfoVirus = "ciudades_enefermedad.bin";
	

	String green = "\033[32m", red = "\033[31m", blue = "\033[34m", yellow = "\033[37m";
	int x = 0, y = 0;

	// -----------------------------------------------------
	/*
	 * VirusCiudades. 
	 * Función: ? 
	 * Entrada: void 
	 * Salida: void
	 */
	// -----------------------------------------------------
	public void VirusCiudades() {
		// Variables de la función
		String frase = null;
		String[] PartesFrase = null;

		try {

			// Abrimos fr,br y fw,bw para poder escribir y leer los archivos
			FileReader fr = new FileReader(Info);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(InfoVirus, true);
			BufferedWriter bw = new BufferedWriter(fw);

			do {

				// Lee la linea del archivo
				frase = br.readLine();

				if (frase != null) {

					// Separa la frase por partes
					PartesFrase = frase.split(";");

					// Se la partes separadas coge el numero y depende de que numero escribe una
					// cosa o otra en el archivo
					switch (Integer.parseInt(PartesFrase[1])) {

					// Si el numero es 0 escribe alfa despues del pueblo
					case 0:
						bw.write(PartesFrase[0] + ",Alfa");
						break;

					// Si el numero es 1 escribe Beta despues del pueblo
					case 1:
						bw.write(PartesFrase[0] + ",Beta");
						break;

					// Si el numero es 2 escribe Gama despues del pueblo
					case 2:
						bw.write(PartesFrase[0] + ",Gama");
						break;

					// Si el numero es 3 escribe Delta despues del pueblo
					case 3:
						bw.write(PartesFrase[0] + ",Delta");
						break;
					}

					// Saltamos de linea
					bw.newLine();

				}

			} while (frase != null);

			// Ceramos todo
			fr.close();
			br.close();
			bw.close();

			// Esta el cath para el caso que haya un error salte y diga cual es
		} catch (IOException e) {
			System.out.println(" Error E/S: " + e);
		}

	}

}