package pandemic;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextPane;

import archivos.P_Ciudades;
import archivos.P_Virus;

import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class FinGame.
 */
public class FinGame extends JFrame {

	P_Ciudades ciudades = new P_Ciudades();
	P_Virus virus = new P_Virus();
	mouse m = new mouse();

	/** The char 1. */
	private JLabel char1;

	/** The char 2. */
	private JLabel char2;

	/** The bulb 1. */
	private JLabel bulb1;

	/** The bulb 2. */
	private JLabel bulb2;

	/** The squir 1. */
	private JLabel squir1;

	/** The squir 2. */
	private JLabel squir2;

	/** The i. */
	public static int i = 0;

	/** The ver. */
	public boolean ver = false;

	/**
	 * Instantiates a new fin game.
	 */
	public FinGame() {
		//GuardarBD.insertarPuntosJugador(GuardarBD.conectarBaseDatos());

		if (i == 0) {
			setVisible(false);
		} else {
			setVisible(true);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1264, 738);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		char1 = new JLabel("");
		char1.setVisible(false);
		char1.setIcon(new ImageIcon(FinGame.class.getResource("/video/deathchar.gif")));
		char1.setBounds(0, 0, 446, 700);
		getContentPane().add(char1);

		char2 = new JLabel("");
		char2.setVisible(false);
		char2.setIcon(new ImageIcon(FinGame.class.getResource("/video/deathchar.gif")));
		char2.setBounds(802, 0, 446, 700);
		getContentPane().add(char2);

		bulb1 = new JLabel("");
		bulb1.setVisible(false);
		bulb1.setIcon(new ImageIcon(FinGame.class.getResource("/video/deathbulb.gif")));
		bulb1.setBounds(0, 0, 446, 700);
		getContentPane().add(bulb1);

		bulb2 = new JLabel("");
		bulb2.setVisible(false);
		bulb2.setIcon(new ImageIcon(FinGame.class.getResource("/video/deathbulb.gif")));
		bulb2.setBounds(802, 0, 446, 700);
		getContentPane().add(bulb2);

		squir1 = new JLabel("");
		squir1.setVisible(false);
		squir1.setIcon(new ImageIcon(FinGame.class.getResource("/video/deathsquir.gif")));
		squir1.setBounds(0, 0, 446, 700);
		getContentPane().add(squir1);

		squir2 = new JLabel("");
		squir2.setVisible(false);
		squir2.setIcon(new ImageIcon(FinGame.class.getResource("/video/deathsquir.gif")));
		squir2.setBounds(802, 0, 446, 700);
		getContentPane().add(squir2);

		if (i == 1) {
			char1.setVisible(true);
			char2.setVisible(true);
		} else if (i == 2) {
			bulb1.setVisible(true);
			bulb2.setVisible(true);
		} else if (i == 3) {
			squir1.setVisible(true);
			squir2.setVisible(true);
		}

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(444, 0, 361, 700);
		getContentPane().add(panel);
		panel.setLayout(null);

		JTextPane txtpnGameOver = new JTextPane();
		txtpnGameOver.setAutoscrolls(false);
		txtpnGameOver.setDropMode(DropMode.INSERT);
		txtpnGameOver.setForeground(new Color(255, 255, 0));
		txtpnGameOver.setFont(txtpnGameOver.getFont().deriveFont(txtpnGameOver.getFont().getSize() + 107f));
		txtpnGameOver.setText("GAME\r\nOVER");
		txtpnGameOver.setOpaque(false);
		txtpnGameOver.setEditable(false);
		txtpnGameOver.setBounds(0, 15, 361, 310);
		panel.add(txtpnGameOver);

		JButton btnSalir = new JButton("");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSalir.setIcon(new ImageIcon(ganador.class.getResource("/segundobtn/btn_salida_pequeño.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSalir.setIcon(new ImageIcon(ganador.class.getResource("/primerbtn/btn_salida_pequeño.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				btnSalir.setIcon(new ImageIcon(ganador.class.getResource("/tercerbtn/btn_salida_pequeño.png")));
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(ganador.class.getResource("/primerbtn/btn_salida_pequeño.png")));
		btnSalir.setForeground((Color) null);
		btnSalir.setFocusPainted(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setBackground((Color) null);
		btnSalir.setBounds(10, 482, 343, 77);
		panel.add(btnSalir);

		JTextPane txtpnTotalPuntos = new JTextPane();
		txtpnTotalPuntos.setBackground(new Color(0, 0, 0));
		txtpnTotalPuntos.setForeground(new Color(255, 255, 255));
		txtpnTotalPuntos.setFont(new Font("Times New Roman", Font.BOLD, 40));
		// devuelve los puntos que tiene
		txtpnTotalPuntos.setText("Total Puntos:  " + Puntuaciaons_Pandemic.puntuacionPartida());
		txtpnTotalPuntos.setBounds(10, 335, 351, 59);
		panel.add(txtpnTotalPuntos);

//		System.out.println(i);
//		System.out.println(ver);
	}

	/**
	 * Mainfin.
	 */
	public static void mainfin() {
		new FinGame();
	}
}
