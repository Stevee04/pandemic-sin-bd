package pandemic;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * La Classe GuardarBD.
 */
public class GuardarBD_ {
	// Variables globales
	static String apodoJugador;
	// static int inserts = 0;
	public static int dificultad;
	public static int rondas;
	public static String resultado = "T";
	public static String ErrorBD = "";

	// Variables de conexión
	private static final String USER = "DAW_PNDC22_23_EDOR";
	private static final String PWD = "EO123";
	private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";
	// Si estáis desde casa, la url será oracle.ilerna.com y no 192.168.3.26
	Connection con = conectarBaseDatos();

	// -----------------------------------
	// -----------------------------------

	public static void baseDeDatos() {
		// variable con la conexión
		Connection con = conectarBaseDatos();
		ArrayList<VacunasBD> listaVacunas = new ArrayList<>();

		if (con != null) {
			// Funciones programadas
			System.out.println(" Guardar vacunas en arrayList");
			guardarVacunas(listaVacunas);

			System.out.println("Tamaño de listaVacunas: " + listaVacunas.size());

			System.out.println(" Insert de partida");
			insertarPartida(con, listaVacunas, busc_ciudad.CiudadInfectada);

			// si no se puede cerrar la conexión muestra el error
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//		}

	}

	/**
	 * ConectarBaseDatos.
	 *
	 * @return the connection
	 */
	public static Connection conectarBaseDatos() {
		// Variables
		Connection con = null;

		System.out.println(" Intentando conectarse a la base de datos");

		// - - - - - - - - - - - - - - - - - -
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PWD);
			System.out.println(" Conectados a la base de datos");
		} catch (ClassNotFoundException e) {
			ErrorBD = (" No se ha encontrado el driver " + e);
			System.out.println(" No se ha encontrado el driver " + e);
			errorBD.runErrorBd();
		} catch (SQLException e) {
			ErrorBD = (" Error en las credenciales o en la URL " + e);
			System.out.println(" Error en las credenciales o en la URL " + e);
			errorBD.runErrorBd();

		}
		// - - - - - - - - - - - - - - - - - -

		System.out.println("Conectados a la base de datos");

		return con;
	}

	/**
	 * InsertarJugador.
	 *
	 * @param con the con
	 */
	public static boolean insertarJugador(Connection con) {
		// variables del programa
		boolean jugadorEncontrado = false;
		String apodoParaComprobar = apodoJugador;
		String apodoRecojidoBD;

		System.out.println("Hace el select para saber el jugador");
		// Realizamos un select y se guarda en la variable
		String comprobarApodo = "SELECT J.APODO FROM JUGADORES J";

		System.out.print(" Introduce tu apodo de jugador: " + apodoParaComprobar);

		// ---------------------------------
		try {
			System.out.println(" Entra en el try");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(comprobarApodo);

			if (rs.isBeforeFirst()) {
				System.out.println(" Entra en el bucle");
				while (rs.next()) {
					// recoje el valor
					apodoRecojidoBD = rs.getString("APODO");

					// comprobará si el usuario ya está introducido
					if (apodoRecojidoBD.equals(apodoParaComprobar)) {
						jugadorEncontrado = true;
						System.out.println(" El jugador ha sido encontrado");
					} else if (jugadorEncontrado != true) {
						jugadorEncontrado = false;
						System.out.println(" El jugador NO ha sido encontrado");
					}
				}
				System.out.println("Sale del try");
			}

		} catch (SQLException e) {
			System.out.println("Salta error");
			e.printStackTrace();
		}
		// ---------------------------------
		System.out.println();
		System.out.println("finiquitado el error");

		// Si el jugador es nuevo introduce al usuario a la BD
		if (jugadorEncontrado == false) {
			/*
			 * el valor de la ID siempre será un autonumerico ya programado, la puntuación
			 * por defecto será 0 y ya se agregara al finalizar la partida
			 */
			String sql = "INSERT INTO JUGADORES VALUES(autoidjugador.nextval, '" + apodoJugador + "', " + 0 + ")";

			// ---------------------------------
			try {
				Statement st = con.createStatement();
				st.execute(sql);

				System.out.println(" Persona registrada correctamente");
			} catch (SQLException e) {
				System.out.println(" Ha habido un error en el Insert " + e);
			}
			// ---------------------------------
		} else {
			System.out.println(" El jugador ya esta introducido, repita el nombre.");
		}
		// Si el jugador ya esta introducido pedira otro nombre

		return jugadorEncontrado;
	}

	/**
	 * insertarPartida.
	 * 
	 * Función: inserta los datos especificados de la partida en ese momento en la
	 * BD
	 *
	 * @param con             the con
	 * @param listaVacunas    the lista vacunas
	 * @param CiudadInfectada the ciudad infectada
	 */
	public static void insertarPartida(Connection con, ArrayList<VacunasBD> listaVacunas,
			ArrayList<ciudad_infectada> CiudadInfectada) {
		
		// hace el insert
		// realizamos un select y se guarda en la variable
		// String cojerIdJugador = "SELECT J.IDJUGADOR FROM JUGADORES J WHERE J.APODO =
		// apodoJugador";
		int idJugadorActual = saberIdUsuario(con);
		System.out.println(" Inserta partida pruebas");
		System.out.println(idJugadorActual);
		System.out.println(dificultad);
		System.out.println(rondas);
		System.out.println(resultado);
		System.out.println("Va pal insert");
		String sql = "INSERT INTO Partidas VALUES (autoidpartida.nextval, " + idJugadorActual + ", " + dificultad + ", "
				+ rondas + ", '" + resultado + "', vacunasPartida(";
		for (int i = 0; i < listaVacunas.size(); i++) {
			VacunasBD vac = listaVacunas.get(i);
			sql += "vacunas(" + vac.getid_Vacunas() + ", '" + vac.getnombreVacuna() + "', "
					+ vac.getporcentajeRealizado() + ")";
			if (i < listaVacunas.size() - 1) {
				sql += ", ";
			}
		}
		sql += "), ciudadesPartida(";
		for (int e = 0; e < 50; e++) {
			System.out.println("Ciudad numero " + e);
			ciudad_infectada ciu = CiudadInfectada.get(e);
			sql += "ciudades(" + ciu.getNumCiudad() + ", '" + ciu.getCiudad() + "', " + ciu.getInfeccion() + ", "
					+ ciu.getBrote() + ", '" + ciu.getVirus() + "')";
			if (e < 50 - 1) {
				sql += ", ";
			}
		}
		sql += "))";
		// - - - - - - - - - - - - - - - - - -
		try {
			Statement st = con.createStatement();
			System.out.println(sql);
			st.execute(sql);
			System.out.println(" Partida registrada correctamente");
		} catch (SQLException e) {
			System.out.println(" Ha habido un error en el Insert de partida: " + e);
		}
	}

	/**
	 * guardarVacunas
	 * 
	 * Función: guarda en el arrayList los datos de las cuatro vacunas
	 * 
	 * @param ArrayList<VacunasBD> listaVacunas
	 */
	public static void guardarVacunas(ArrayList<VacunasBD> listaVacunas) {
		// Variables
		VacunasPor VPor = new VacunasPor();

		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				// Poneos los datos al objeto
				VacunasBD v = new VacunasBD(1, "Alfa", VPor.Alfa);

				// Añadimos el objeto al Arraylist
				listaVacunas.add(v);
			}
			if (i == 1) {
				// Poneos los datos al objeto
				VacunasBD v = new VacunasBD(2, "Beta", VPor.Beta);

				// Añadimos el objeto al Arraylist
				listaVacunas.add(v);
			}
			if (i == 2) {
				// Poneos los datos al objeto
				VacunasBD v = new VacunasBD(3, "Delta", VPor.Delta);

				// Añadimos el objeto al Arraylist
				listaVacunas.add(v);
			}
			if (i == 3) {
				// Poneos los datos al objeto
				VacunasBD v = new VacunasBD(4, "Gama", VPor.Gama);

				// Añadimos el objeto al Arraylist
				listaVacunas.add(v);
			}
		}
	}

	/**
	 * insertarPuntosJugador
	 *
	 * Función: guarda en el arrayList los datos de las cuatro vacunas
	 *
	 * @param con es la conección a la BD
	 */
	public static void insertarPuntosJugador(Connection con) {
		int p = Puntuaciaons_Pandemic.puntuacionPartida(); // prueba
		
		System.out.println(p);
		System.out.println(apodoJugador);
		// prueba
		System.out.print(" El usuario es: " + apodoJugador);

		String sql = "UPDATE JUGADORES SET PUNTOSREALIZADOS = " + p + " WHERE APODO = '" + apodoJugador + "'";

		// - - - - - - - - - - - - - - - - - -
		try {
			Statement st = con.createStatement();
			st.execute(sql);

			System.out.println(" Update de puntos echo correctamente");
		} catch (SQLException e) {
			System.out.println(" Ha habido un error en el update " + e);
		}
	}

	/**
	 * fabricarRankings
	 *
	 * Función: manda ejecutar los procedimientos que actualizan las tablas de
	 * rankings
	 *
	 * @param con the con
	 */
	public static void fabricarRankings(Connection con) {

		// - - - - - - - - - - - - - - - - - -
		try (CallableStatement statement = con.prepareCall("{call llenarrankingm()}");) {

			statement.execute();
			statement.close();

			System.out.println("Stored procedure called successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// - - - - - - - - - - - - - - - - - -
		try (CallableStatement statement = con.prepareCall("{call llenarrankingp()}");) {

			statement.execute();
			statement.close();

			System.out.println("Stored procedure called successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * recojerRankingM
	 *
	 * Función: recoje los datos de la tabla rankingm
	 *
	 * @param con the con
	 */
	public static String recojerRankingM(Connection con) {
		// Variables
		String apodo;
		String resultado;
		int posicion;
		int puntos;
		int dificultad;
		String Ranking = "";

		Statement stmt = null;
		ResultSet rs = null;
		
		try (CallableStatement statement = con.prepareCall("{call llenarrankingm()}");) {

            statement.execute();
            statement.close();

            System.out.println("Stored procedure called successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

		// ---------------------------------
		try {
			// Crear una declaración
			stmt = con.createStatement();

			// Ejecutar una consulta SQL
			String sql = "SELECT * FROM rankingm";
			rs = stmt.executeQuery(sql);

			// Procesar los resultados
			while (rs.next()) {
				// Obtener los valores de las columnas
				posicion = rs.getInt("POSICION");
				apodo = rs.getString("APODOJUGADOR");
				puntos = rs.getInt("PUNTOSOBTENIDOS");
				dificultad = rs.getInt("DIFICULTAD");
				resultado = rs.getString("RESULTADO");

				//                Puesto  //  Jugador  //  Puntos  //  Dif.  //  Resultado //
				
				// Mostrar los datos obtenidos
				Ranking += ("  " + posicion + "    //    " + apodo + "    //    " + puntos + "    //    " + dificultad + "    //    " + resultado + "    //\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			// Cerrar los recursos
			if (rs != null) {
				// ---------------------------------
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				// ---------------------------------
			}
			if (stmt != null) {
				// ---------------------------------
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				// ---------------------------------
			}
		}
		// ---------------------------------
		return Ranking;
	}

	/**
	 * recojerRankingP
	 *
	 * Función: recoje los datos de la tabla rankingp
	 *
	 * @param con the con
	 */
	public static String recojerRankingP(Connection con) {
		// Variables
		String apodo;
		String resultado;
		int posicion;
		int puntos;
		int dificultad;
		String Ranking = "";

		Statement stmt = null;
		ResultSet rs = null;
		
		 try (CallableStatement statement = con.prepareCall("{call llenarrankingp()}");) {

	            statement.execute();
	            statement.close();

	            System.out.println("Stored procedure called successfully!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

		// ---------------------------------
		try {
			// Crear una declaración
			stmt = con.createStatement();

			// Ejecutar una consulta SQL
			String sql = "SELECT * FROM rankingp";
			rs = stmt.executeQuery(sql);

			// Procesar los resultados
			while (rs.next()) {
				// Obtener los valores de las columnas
				posicion = rs.getInt("POSICION");
				apodo = rs.getString("APODOJUGADOR");
				puntos = rs.getInt("PUNTOSOBTENIDOS");
				dificultad = rs.getInt("DIFICULTAD");
				resultado = rs.getString("RESULTADO");

				// Mostrar los datos obtenidos
				Ranking += ("  " + posicion + "    //    " + apodo + "    //    " + puntos + "    //    " + dificultad + "    //    " + resultado + "    //\n");

			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			// Cerrar los recursos
			if (rs != null) {
				// ---------------------------------
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				// ---------------------------------
			}
			if (stmt != null) {
				// ---------------------------------
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				// ---------------------------------
			}
		}
		// ---------------------------------
		return Ranking;
	}

	private static int saberIdUsuario(Connection con) {
		int idJugadorPartidaActual = 0;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			// Crear una declaración
			stmt = con.createStatement();

			// Ejecutar una consulta SQL
			String sql = "SELECT IDJUGADOR FROM jugadores where apodo = '" + apodoJugador + "'";
			rs = stmt.executeQuery(sql);

			// Procesar los resultados
			while (rs.next()) {
				// Obtener los valores de las columnas
				idJugadorPartidaActual = rs.getInt("IDJUGADOR");

				// Hacer algo con los datos obtenidos
				System.out.println(idJugadorPartidaActual);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerrar los recursos
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		// - - - - - - - - - - - - - - - - - -
		return idJugadorPartidaActual;
	}
}
