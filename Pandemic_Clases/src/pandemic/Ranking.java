package pandemic;
import java.beans.*;
import java.sql.*;
import java.sql.Statement;

// TODO: Auto-generated Javadoc
/**
 * The Class Ranking.
 */
public class Ranking {
	
	/** The Constant USER. */
	// variables de conexión
	private static final String USER = "DAW_PNDC22_23_EDOR";
	
	/** The Constant PWD. */
	private static final String PWD = "EO123";
	
	/** The Constant URL. */
	// Si estáis desde casa, la url será oracle.ilerna.com y no 192.168.3.26
	private static final String URL = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe";

	/**
	 * Ranking mejores punt.
	 */
	private static void rankingMejoresPunt() {
		System.out.println("Posicion  //  Jugador  //  Puntos  //  Dificultad  //  Resultado");
		try (Connection con = conectarBaseDatos();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM RANKINGM")) {

			while (rs.next()) {
				int posicion = rs.getInt("POSICION");
				String apodo = rs.getString("APODO");
				int puntos = rs.getInt("PUNTOSOBTENIDOS");
				String dificultad = rs.getString("DIFICULTAD");
				String resultado = rs.getString("RESULTADO");
				System.out.println(posicion + apodo + puntos + dificultad + resultado);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Ranking peores punt.
	 */
	private static void rankingPeoresPunt() {
		System.out.println("Posicion  //  Jugador  //  Puntos  //  Dificultad  //  Resultado");
		try (Connection con = conectarBaseDatos();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM RANKINGP")) {

			while (rs.next()) {
				int posicion = rs.getInt("POSICION");
				String apodo = rs.getString("APODO");
				int puntos = rs.getInt("PUNTOSOBTENIDOS");
				String dificultad = rs.getString("DIFICULTAD");
				String resultado = rs.getString("RESULTADO");
				System.out.println(posicion + apodo + puntos + dificultad + resultado);
			} System.out.println(" me cago en tu puta madre ya colñooo");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Conectar base datos.
	 *
	 * @return the connection
	 */
	public static Connection conectarBaseDatos() {
		// variables
		Connection con = null;

		System.out.println(" Intentando conectarse a la base de datos");

		// - - - - - - - - - - - - - - - - - -
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PWD);
			System.out.println(" Conectados a la base de datos");
		} catch (ClassNotFoundException e) {
			System.out.println(" No se ha encontrado el driver " + e);
		} catch (SQLException e) {
			System.out.println(" Error en las credenciales o en la URL " + e);
		}
		// - - - - - - - - - - - - - - - - - -

		System.out.println("Conectados a la base de datos");

		return con;
	}
}
