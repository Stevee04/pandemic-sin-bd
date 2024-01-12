package pandemic;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * The Class mouse.
 */
public class mouse extends JFrame {

	/**
	 * Instantiates a new mouse.
	 */
	public mouse() {

		// Obtener la imagen del logo
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		// Cargar la imagen original del cursor
		Image image = toolkit.getImage("src/mouseimg/prueba2.png");

		// Escalar la imagen a 64x64 (cambia el tamaño según lo que necesites)
		Image scaledImage = image.getScaledInstance(16400, 16400, Image.SCALE_SMOOTH);

		// Crear un nuevo cursor con la imagen escalada
		Cursor cursor = toolkit.createCustomCursor(scaledImage, new Point(0, 0), "CustomCursor");

		// Asignar el nuevo cursor al componente que lo necesita (en este caso, el
		// JFrame)
		setCursor(cursor);
	}

	// -----------------------------------------------------
	/*
	 * IconImg. Función: guarda la información de las ciudades Entrada:
	 * 
	 * @param i the i Salida:
	 * 
	 * @return the string
	 */
	// -----------------------------------------------------
	public String IconImg(int i) {

		String Iconimg = "";

		switch (i) {
		case 1:
			Iconimg = "src/image/fuego.png";
			break;
		case 2:
			Iconimg = "src/image/bulb.png";
			break;
		case 3:
			Iconimg = "src/image/squirt.png";
			break;
		default:
			Iconimg = "src/image/demanda.png";
		}
		return Iconimg;
	}

	// -----------------------------------------------------
	/*
	 * imgmouse. Función: guarda la información de las ciudades Entrada:
	 * 
	 * @param i the i Salida:
	 * 
	 * @return the string
	 */
	// -----------------------------------------------------
	public String imgmouse(int i) {

		String pokemon = "";

		switch (i) {
		case 1:
			pokemon = "src/mouse/char.png";
			break;
		case 2:
			pokemon = "src/mouse/bulbasur.png";
			break;
		case 3:
			pokemon = "src/mouse/squirtle.png";
			break;
		default:
			pokemon = "src/mouse/pokeball.png";
		}
		return pokemon;
	}

}