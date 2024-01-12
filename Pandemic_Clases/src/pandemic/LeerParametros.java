package pandemic;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.transform.*;
import java.io.File;

// TODO: Auto-generated Javadoc
/**
 * The Class LeerParametros.
 */
public class LeerParametros {

	/** The opcion. */
	static int opcion = 0;
	
	/** The Ciu inf inicio. */
	static int CiuInfInicio = 0;
	
	/** The Ciu inf I ronda. */
	static int CiuInfIRonda = 0;
	
	/** The Enf act derrota. */
	static int EnfActDerrota = 0;
	
	/** The Num bro derrota. */
	static int NumBroDerrota = 0;
	
	/** The por vacuna. */
	static int porVacuna = 0;

	
	
	/**
	 * Leer.
	 */
	public void Leer() {
		try {
			// 1. Crear una instancia de DocumentBuilderFactory y DocumentBuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// 2. Leer el archivo XML y crear un objeto Document
			Document document = builder.parse(new File("parametros.xml"));

			NodeList dificultad = document.getElementsByTagName("parametros");

			for (int i = 0; i < dificultad.getLength(); i++) {

				Node nodo = dificultad.item(i);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) nodo;
					NodeList hijos = e.getChildNodes();
					for (int j = 0; j < hijos.getLength(); j++) {

						Node hijo = hijos.item(j);
						if (hijo.getNodeType() == Node.ELEMENT_NODE) {
							Element ehijo = (Element) hijo;
							//System.out.println("Propiedad: " + hijo.getNodeName() + " valor: " + hijo.getTextContent());
						}

					}
				}

			}

		} catch (Exception e) {
			// En caso de que ocurra una excepción, mostrar un mensaje de error en la
			// consola
			System.err.println("Error al editar el archivo XML: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Editar.
	 *
	 * @param opcion the opcion
	 */
	public void editar(int opcion) {
		try {

			// 1. Crear una instancia de DocumentBuilderFactory y DocumentBuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// 2. Leer el archivo XML y crear un objeto Document
			Document document = builder.parse(new File("parametros.xml"));

			// Obtener el elemento "numCiudadesInfectadasInicio"
			Node numCiudadesInfectadasInicio = document.getElementsByTagName("numCiudadesInfectadasInicio").item(0);
			Node numCuidadesInfectadasRonda = document.getElementsByTagName("numCuidadesInfectadasRonda").item(0);
			Node numEnfermedadesActivasDerrota = document.getElementsByTagName("numEnfermedadesActivasDerrota").item(0);
			Node numBrotesDerrota = document.getElementsByTagName("numBrotesDerrota").item(0);
			Node porcentajeVacuna = document.getElementsByTagName("porcentajeVacuna").item(0);

			// Actualizar su valor a 10
			if (opcion != 0) {
				NivelDificutlad(numCiudadesInfectadasInicio, numCuidadesInfectadasRonda, numEnfermedadesActivasDerrota,
						numBrotesDerrota,porcentajeVacuna, opcion);
			}

			// Guardar los cambios en el archivo XML
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "0");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File("parametros.xml"));
			transformer.transform(source, result);

			System.out.println("Archivo XML actualizado con éxito \n\n");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Nivel dificutlad.
	 *
	 * @param numCiudadesInfectadasInicio the num ciudades infectadas inicio
	 * @param numCuidadesInfectadasRonda the num cuidades infectadas ronda
	 * @param numEnfermedadesActivasDerrota the num enfermedades activas derrota
	 * @param numBrotesDerrota the num brotes derrota
	 * @param porcentajeVacuna the porcentaje vacuna
	 * @param opcion the opcion
	 */
	public static void NivelDificutlad(Node numCiudadesInfectadasInicio, Node numCuidadesInfectadasRonda,
			Node numEnfermedadesActivasDerrota, Node numBrotesDerrota,Node porcentajeVacuna, int opcion) {

		switch (opcion) {
		// dependiendo de la opcion cambia la dificultad
		case 1:
			System.out.println("Nivel Facil Actualizado");
			// Cambia los parametros en el xml
			numCiudadesInfectadasInicio.setTextContent("5");
			numCuidadesInfectadasRonda.setTextContent("2");
			numEnfermedadesActivasDerrota.setTextContent("40");
			numBrotesDerrota.setTextContent("15");
			porcentajeVacuna.setTextContent("10");
			
			CiuInfInicio = 5;
			CiuInfIRonda = 2;
			EnfActDerrota = 40;
			NumBroDerrota = 15;
			porVacuna = 10;

			break;
		case 2:
			System.out.println("Nivel Normal Actualizado");
			// Cambia los parametros en el xml
			numCiudadesInfectadasInicio.setTextContent("5");
			numCuidadesInfectadasRonda.setTextContent("4");
			numEnfermedadesActivasDerrota.setTextContent("30");
			numBrotesDerrota.setTextContent("8");
			porcentajeVacuna.setTextContent("10");


			CiuInfInicio = 5;
			CiuInfIRonda = 4;
			EnfActDerrota = 30;
			NumBroDerrota = 8;
			porVacuna = 10;

			break;
		case 3:
			System.out.println("Nivel Dificil Actualizado");
			// Cambia los parametros en el xml
			numCiudadesInfectadasInicio.setTextContent("9");
			numCuidadesInfectadasRonda.setTextContent("6");
			numEnfermedadesActivasDerrota.setTextContent("30");
			numBrotesDerrota.setTextContent("8");
			porcentajeVacuna.setTextContent("10");

			
			CiuInfInicio = 9;
			CiuInfIRonda = 6;
			EnfActDerrota = 30;
			NumBroDerrota = 8;
			porVacuna = 10;


			break;
		}
	}

	/**
	 * Infectar ciudades.
	 *
	 * @param CiuInfInicio the ciu inf inicio
	 * @return the int
	 */
	public int InfectarCiudades(int CiuInfInicio) {
		int a = CiuInfInicio;

		return a;

	}

	/**
	 * Infeccion ronda.
	 *
	 * @param CiuInfIRonda the ciu inf I ronda
	 * @return the int
	 */
	public int InfeccionRonda(int CiuInfIRonda) {
		int a = CiuInfIRonda;

		return a;
	}

	/**
	 * Num enfermedades activas.
	 *
	 * @param EnfActDerrota the enf act derrota
	 * @return the int
	 */
	public int NumEnfermedadesActivas(int EnfActDerrota) {
		int a = EnfActDerrota;

		return a;
	}

	/**
	 * Num brotes.
	 *
	 * @param NumBroDerrota the num bro derrota
	 * @return the int
	 */
	public int NumBrotes(int NumBroDerrota) {
		int a = NumBroDerrota;
		
		return a;
	}
	
	/**
	 * Porcentaje de vacuna.
	 *
	 * @param porVacuna the por vacuna
	 * @return the int
	 */
	public int PorcentajeDeVacuna(int porVacuna) {
		int a = porVacuna;
		
		return a;
	}

}