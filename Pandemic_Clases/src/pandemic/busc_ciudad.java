package pandemic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class busc_ciudad {
	// Variables que guardan archivos
	static String ciudades = "ciutats.txt";
	static String VirusCiudades = "ciudades_enefermedad.bin";
	
	// Variables de importación
	public static ArrayList<ciudad_infectada> CiudadInfectada = new ArrayList<>();
	
	// Variables globales
	static String[] PartesFrase;
	static String[] CiuInf;
	static String[] partesCiudades = null;
	static String NPueblo = "";
	static int[] VirusPueblo = { 0, 0, 0, 0 };
	static int[] numInicio = {};

	// -----------------------------------------------------
	/*
	 * SaveInfCiu. 
	 * Función: guarda la información de las ciudades
	 * Entrada: 
	 * @param InRonda numero de ronda
	 * Salida: void
	 */
	// -----------------------------------------------------
	public void SaveInfCiu(int InRonda) {
		// Variables de la función
		int infeccion_actual = 0;
		int brotes_actual = 0;
		CiuInf = new String[InRonda];
		int[] a = new int[InRonda];
		a = InicioRonda(InRonda);

		for (int i = 0; i < CiudadInfectada.size(); i++) {
			for (int j = 0; j < a.length; j++) {
				ciudad_infectada e = CiudadInfectada.get(a[j]);
				infeccion_actual = e.getInfeccion();
				if (infeccion_actual == 3) {
					brotes_actual = e.getBrote();
					e.setBrote(brotes_actual + 1);
					System.out.println(brotes_actual);
					NPueblo = e.getCiudad();
					System.out.println(NPueblo);
					InfeccionColindantes();
				} else {
					System.out.println(e.getCiudad() + ", " + e.getInfeccion() + ", " + e.getBrote());
					e.setInfeccion(infeccion_actual + 1);
					System.out.println(CiudadInfectada.get(a[j]));
					System.out.println(e.getCiudad() + ", " + e.getInfeccion() + ", " + e.getBrote());
				}
				if (j < a.length) {
					i = CiudadInfectada.size();
				}
			}
		}
	}

	// -----------------------------------------------------
	/*
	 * getCiuInfo. 
	 * Función: obtiene la información de las ciudades
	 * Entrada: 
	 * @param NumCiudad es el numero de la ciudad
	 * Salida: 
	 * @return String[] la info de la ciudad
	 */
	// -----------------------------------------------------
	public String[] getCiuInfo(int NumCiudad) {
		// Variables de la funcón
		int a = NumCiudad;
		String[] info = new String[4];

		for (int i = 0; i < CiudadInfectada.size(); i++) {
			ciudad_infectada e = CiudadInfectada.get(a);
			if (i == a) {
				info[0] = e.getCiudad();
				if (e.getInfeccion() == 0) {
					info[1] = String.valueOf(e.getInfeccion() + 1);
				} else {
					info[1] = String.valueOf(e.getInfeccion());
				}
				info[2] = String.valueOf(e.getBrote());
				info[3] = e.getVirus();
			}
		}
		return info;
	}

	// -----------------------------------------------------
	/*
	 * RestarInfCiu. 
	 * Función: es la encargada de restar infeciones de las ciudades
	 * Entrada: 
	 * @param NumCiudad es el numero de la ciudad
	 * @param porVacuna porcentaje que tiene la vacuna
	 * Salida: 
	 * @return boolean
	 */
	// -----------------------------------------------------
	public boolean RestarInfCiu(int NumCiudad, int[] porVacuna) {
		VacunasPor vacuna = new VacunasPor();
		
		int infeccion_actual = 0;
		int a = NumCiudad;
		boolean visible = true;

		for (int i = 0; i < CiudadInfectada.size(); i++) {
			ciudad_infectada e = CiudadInfectada.get(a);
			switch (e.getVirus()) {
			case "Alfa":
				if (e.getInfeccion() != 0) {
					if (porVacuna[0] == 100) {
						infeccion_actual = e.getInfeccion();
						System.out.println("Vacuna: " + vacuna.Alfa);
						e.setInfeccion(infeccion_actual - infeccion_actual);
						System.out.print(e.getInfeccion());
						if (e.getInfeccion() == 0) {
							visible = false;
						}
					} else {
						infeccion_actual = e.getInfeccion();
						System.out.println("Vacuna: " + porVacuna[0]);
						e.setInfeccion(infeccion_actual - 1);
						System.out.print(e.getInfeccion());
						if (e.getInfeccion() == 0) {
							visible = false;
						}
					}
					i = CiudadInfectada.size();
				}
				break;
			case "Beta":
				if (e.getInfeccion() != 0) {
					if (porVacuna[1] == 100) {
						infeccion_actual = e.getInfeccion();
						System.out.println(CiudadInfectada.get(a));
						System.out.print(e.getInfeccion());
						e.setInfeccion(infeccion_actual - infeccion_actual);
						System.out.print(e.getInfeccion());
						if (e.getInfeccion() == 0) {
							visible = false;
						}
					} else {
						infeccion_actual = e.getInfeccion();
						System.out.println(CiudadInfectada.get(a));
						System.out.print(e.getInfeccion());
						e.setInfeccion(infeccion_actual - 1);
						System.out.print(e.getInfeccion());
						if (e.getInfeccion() == 0) {
							visible = false;
						}
					}
					i = CiudadInfectada.size();
				}
				break;
			case "Delta":
				if (e.getInfeccion() != 0) {
					if (porVacuna[2] == 100) {
						infeccion_actual = e.getInfeccion();
						System.out.println(CiudadInfectada.get(a));
						System.out.print(e.getInfeccion());
						e.setInfeccion(infeccion_actual - infeccion_actual);
						System.out.print(e.getInfeccion());
						if (e.getInfeccion() == 0) {
							visible = false;
						}
					} else {
						infeccion_actual = e.getInfeccion();
						System.out.println(CiudadInfectada.get(a));
						System.out.print(e.getInfeccion());
						e.setInfeccion(infeccion_actual - 1);
						System.out.print(e.getInfeccion());
						if (e.getInfeccion() == 0) {
							visible = false;
						}
					}
					i = CiudadInfectada.size();
				}
				break;
			case "Gama":
				if (e.getInfeccion() != 0) {
					if (porVacuna[3] == 100) {
						infeccion_actual = e.getInfeccion();
						System.out.println(CiudadInfectada.get(a));
						System.out.print(e.getInfeccion());
						e.setInfeccion(infeccion_actual - infeccion_actual);
						System.out.print(e.getInfeccion());
						if (e.getInfeccion() == 0) {
							visible = false;
						}
					} else {
						infeccion_actual = e.getInfeccion();
						System.out.println(CiudadInfectada.get(a));
						System.out.print(e.getInfeccion());
						e.setInfeccion(infeccion_actual - 1);
						System.out.print(e.getInfeccion());
						if (e.getInfeccion() == 0) {
							visible = false;
						}
					}
					i = CiudadInfectada.size();
				}
				break;

			}
		}
		System.out.println("\n Ciutat restada: ");
		System.out.println(CiudadInfectada.get(a));
		
		return visible;
	}

	/*
	 * InfeccionColindantes. 
	 * Función: se encarga de infectar colindantes
	 * Entrada: void 
	 * Salida: void
	 */
	// -----------------------------------------------------
	public static void InfeccionColindantes() {

		String Nciu = "";
		int numInfeccion = 0;

		GuardarColindantes();
		System.out.println("\n\n InfeccionColindanteeees");
		for (int i = 0; i < CiudadInfectada.size(); i++) {
			ciudad_infectada e = CiudadInfectada.get(i);
			Nciu = e.getCiudad();
			if (Nciu.equals(NPueblo)) {
				System.out.println(NPueblo + " se la metioo");
				for (int j2 = 0; j2 < partesCiudades.length; j2++) {
					System.out.println("\n\nllego hasta el fondo");
					System.out.println(partesCiudades[j2]);
					for (int j = 0; j < CiudadInfectada.size(); j++) {
						ciudad_infectada a = CiudadInfectada.get(j);
						if (partesCiudades[j2].equals(a.getCiudad())) {
							System.out.println("\n\n\n");
							System.out.println(a.getCiudad() + ", " + a.getInfeccion());
							numInfeccion = a.getInfeccion();
							if (numInfeccion != 3) {
								a.setInfeccion(numInfeccion + 1);
							}
							System.out.println(a.getCiudad() + ", " + a.getInfeccion());
						}
					}
				}

			}
		}
	}

	// -----------------------------------------------------
	/*
	 * GuardarColindantes. 
	 * Función: ? 
	 * Entrada: void 
	 * Salida: void
	 */
	// -----------------------------------------------------
	public static void GuardarColindantes() {

		String fraseLeida = null;
		String[] fraseEnPartes = null;

		try {
			// variables ficheros
			FileReader fr = new FileReader(ciudades);
			BufferedReader br = new BufferedReader(fr);

			do {
				// lee línea
				fraseLeida = br.readLine();

				if (fraseLeida != null) {
					fraseEnPartes = fraseLeida.split(";");

					// busca el pueblo y escribe las colindantes cuando lo encuentra
					if (fraseEnPartes[0].equals(NPueblo)) {
						partesCiudades = fraseEnPartes[3].split(",");
					}
				}

			} while (fraseLeida != null);

		} catch (IOException e) {
			System.out.println(" Error E/S: " + e);
		}
	}

	// -----------------------------------------------------
	/*
	 * contarInfecciones. 
	 * Función: cuenta las infeciones totales en la partida
	 * Entrada: void 
	 * Salida: 
	 * @return the int
	 */
	// -----------------------------------------------------
	public static int contarInfecciones() {
		int cont = 0;

		for (int i = 0; i < CiudadInfectada.size(); i++) {

			ciudad_infectada c = CiudadInfectada.get(i);

			if (c.getInfeccion() >= 1) {
				cont += c.getInfeccion();
			}
		}
		return cont;
	}

	// -----------------------------------------------------
	/*
	 * contarBrotes. 
	 * Función: cuenta los brotes totales en la partida
	 * Entrada: void 
	 * Salida: 
	 * @return the int
	 */
	// -----------------------------------------------------
	public static int contarBrotes() {
		int cont = 0;
		// System.out.println(" ");

		for (int i = 0; i < CiudadInfectada.size(); i++) {

			ciudad_infectada c = CiudadInfectada.get(i);

			if (c.getInfeccion() >= 1) {
				cont += c.getBrote();
			}

		}

		return cont;
	}

	// -----------------------------------------------------
	/*
	 * GuardarArray. 
	 * Función: ? 
	 * Entrada: void 
	 * Salida: void
	 */
	// -----------------------------------------------------
	public static void GuardarArray() {

		String Info = "ciudades_enefermedad.bin";
		int x = 0, y = 0;

		// creamos las variables de VirusCiudades
		String frase = null;
		PartesFrase = new String[2];

		try {

			// abrimos fr,br y fw,bw para poder escribir y leer los archivos
			FileReader fr = new FileReader(Info);
			BufferedReader br = new BufferedReader(fr);

			for (int i = 0; i < 50; i++) {

				// lee la linea del archivo
				frase = br.readLine();

				if (frase != null) {
					// separa la frase por partes
					PartesFrase = frase.split(",");

				}

				ciudad_infectada InfectarCiudad = new ciudad_infectada(i, PartesFrase[0], 0, 0, PartesFrase[1]);
				CiudadInfectada.add(i, InfectarCiudad);

			}
		} catch (IOException e) {
			System.out.println(" Error E/S: " + e);
		}
	}

	// -----------------------------------------------------
	/*
	 * InicioRonda. 
	 * Función: ? 
	 * Entrada: 
	 * @param InRonda the in ronda 
	 * Salida: 
	 * @return the int[]
	 */
	// -----------------------------------------------------
	public static int[] InicioRonda(int InRonda) {

		int[] a = new int[InRonda];
		numInicio = new int[InRonda];
		int numero = 0;

		for (int i = 0; i < a.length; i++) {
			numero = (int) (Math.random() * 50);

			a[i] = numero;
			numInicio[i] = numero;
		}
		return a;
	}

}
