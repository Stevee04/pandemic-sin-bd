package pandemic;

import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JToggleButton;
import java.awt.Toolkit;

// TODO: Auto-generated Javadoc
/**
 * The Class Play.
 */
public class Play extends JFrame {

	/** The N poke. */
	static int NPoke = 0;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void runGame() {

		mouse m = new mouse();

		try {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Cursor cursor = toolkit.createCustomCursor(toolkit.getImage(m.imgmouse(NPoke)), new Point(0, 0), "Logo");
			Play frame = new Play();
			frame.setCursor(cursor);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** The Num acc. */
	int NumAcc = 0;

	/** The ronda. */
	int ronda = 1;

	/** The btciu. */
	boolean btciu = false;

	/** The ver. */
	boolean ver = false;

	/** The ver 2. */
	boolean ver2 = true;

	/** The p. */
	LeerParametros P = new LeerParametros();

	/** The ci. */
	ciudad_infectada ci = new ciudad_infectada();

	/** The fg. */
	FinGame fg = new FinGame();

	/** The m. */
	musica m = new musica();

	/** The content panel. */
	private JPanel contentPanel;

	/**
	 * The Class RoundedButton.
	 */
	// es una clase para poder redondear el boton
	public class RoundedButton extends JButton {

		/**
		 * Instantiates a new rounded button.
		 *
		 * @param label the label
		 */
		public RoundedButton(String label) {
			super(label);

			// Asegurarse de que el botón sea completamente opaco
			setContentAreaFilled(false);
		}

		/**
		 * Paint component.
		 *
		 * @param g the g
		 */
		// Anular el método paintComponent() para dibujar el botón personalizado
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;

			// Dibujar un rectángulo redondeado
			RoundRectangle2D rect = new RoundRectangle2D.Float(0, 0, (getWidth() - 1) * 2, (getHeight() - 1) * 2, 26,
					26);

			// Establecer un color de fondo redondeado utilizando GradientPaint
			GradientPaint gradient = new GradientPaint(0, 0, new Color(255, 255, 255), 0, getHeight(),
					new Color(255, 255, 255));
			g2.setPaint(gradient);

			g2.fill(rect);

			// Dibujar el texto
			super.paintComponent(g);
		}

		// Anular el método paintBorder() para eliminar el borde predeterminado del
		/**
		 * Paint border.
		 *
		 * @param g the g
		 */
		// botón
		protected void paintBorder(Graphics g) {
			// No hacer nada
		}
	}

	/**
	 * Create the frame.
	 */
	public Play() {

		int[] NVirus = new int[4];
		boolean[] visible = new boolean[50];
		busc_ciudad bc = new busc_ciudad();
		VacunasPor Vacuna = new VacunasPor();
		mouse mouse = new mouse();
		fin f = new fin();

		setFont(new Font("Times New Roman", Font.PLAIN, 29));
		setIconImage(Toolkit.getDefaultToolkit().getImage(mouse.IconImg(NPoke)));
		setBackground(Color.BLACK);
		setTitle("PANDEMIC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 1257, 792);
		setResizable(false);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		m.playmusica();

		// es el panel general va debajo de todo
		JPanel panel_general = new JPanel();
		panel_general.setBorder(new LineBorder(new Color(15, 255, 177), 6, true));
		panel_general.setBackground(new Color(0, 0, 0));
		panel_general.setBounds(0, 0, 1241, 755);
		contentPanel.add(panel_general);
		panel_general.setLayout(null);

		// ==============================================================================================================================================================================================================================================================================
		// ==============================================================================================================================================================================================================================================================================

		JPanel infoCura = new JPanel();
		infoCura.setOpaque(false);
		infoCura.setBorder(new LineBorder(new Color(15, 255, 177), 6));
		infoCura.setVisible(ver);
		infoCura.setBackground(null);
		infoCura.setBounds(358, 569, 883, 187);
		infoCura.setLayout(null);
		panel_general.add(infoCura);

		JPanel cura = new JPanel();
		cura.setOpaque(false);
		cura.setBorder(new LineBorder(new Color(15, 255, 177), 6));
		cura.setVisible(ver);
		cura.setBackground(null);
		cura.setBounds(0, 569, 1241, 187);
		cura.setLayout(null);
		panel_general.add(cura);

		// ==============================================================================================================================================================================================================================================================================
		// ==============================================================================================================================================================================================================================================================================

		JPanel panel_ciudades = new JPanel();
		panel_ciudades.setOpaque(false);
		panel_ciudades.setForeground(null);
		panel_ciudades.setBackground(null);
		panel_ciudades.setBounds(363, 4, 872, 561);
		panel_general.add(panel_ciudades);
		panel_ciudades.setLayout(null);

		JLabel lblciudades = new JLabel("");
		lblciudades.setBounds(-4, 0, 876, 561);
		panel_ciudades.add(lblciudades);

		// ==============================================================================================================================================================================================================================================================================
		// ==============================================================================================================================================================================================================================================================================

		int[] vacunasimg = { Vacuna.Alfa, Vacuna.Beta, Vacuna.Delta, Vacuna.Gama };

		JButton[] btn = new JButton[50];

		for (int i = 0; i < btn.length; i++) {

			btn[0] = new JButton("");
			btn[0].setVisible(false);
			btn[0].setBorderPainted(false);
			btn[0].setBackground(new Color(0, 0, 0));
			btn[0].setOpaque(false);
			btn[0].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[0] == 100) {
							btn[0].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
							System.out.println(vacunasimg[0]);
						} else {
							btn[0].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}
					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[0].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
					}
				}
			});
			btn[0].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
			btn[0].setBounds(66, 94, 29, 29);
			panel_ciudades.add(btn[0]);

			btn[1] = new JButton("");
			btn[1].setVisible(false);
			btn[1].setBorderPainted(false);
			btn[1].setBackground(new Color(0, 0, 0));
			btn[1].setOpaque(false);
			btn[1].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[0] == 100) {
							btn[1].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[1].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[1].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
					}
				}
			});
			btn[1].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
			btn[1].setBounds(164, 98, 29, 29);
			panel_ciudades.add(btn[1]);

			btn[2] = new JButton("");
			btn[2].setVisible(false);
			btn[2].setBorderPainted(false);
			btn[2].setBackground(new Color(0, 0, 0));
			btn[2].setOpaque(false);
			btn[2].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[0] == 100) {
							btn[2].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[2].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[2].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
					}
				}
			});
			btn[2].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
			btn[2].setBounds(143, 142, 29, 29);
			panel_ciudades.add(btn[2]);

			btn[3] = new JButton("");
			btn[3].setVisible(false);
			btn[3].setBorderPainted(false);
			btn[3].setBackground(new Color(0, 0, 0));
			btn[3].setOpaque(false);
			btn[3].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[0] == 100) {
							btn[3].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[3].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[3].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
					}
				}
			});
			btn[3].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
			btn[3].setBounds(79, 226, 29, 29);
			panel_ciudades.add(btn[3]);

			btn[4] = new JButton("");
			btn[4].setVisible(false);
			btn[4].setBorderPainted(false);
			btn[4].setBackground(new Color(0, 0, 0));
			btn[4].setOpaque(false);
			btn[4].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[0] == 100) {
							btn[4].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[4].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[4].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
					}
				}
			});
			btn[4].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
			btn[4].setBounds(199, 131, 29, 29);
			panel_ciudades.add(btn[4]);

			btn[5] = new JButton("");
			btn[5].setVisible(false);
			btn[5].setBorderPainted(false);
			btn[5].setBackground(new Color(0, 0, 0));
			btn[5].setOpaque(false);
			btn[5].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[0] == 100) {
							btn[5].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[5].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[5].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
					}
				}
			});
			btn[5].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
			btn[5].setBounds(232, 94, 29, 29);
			panel_ciudades.add(btn[5]);

			btn[6] = new JButton("");
			btn[6].setVisible(false);
			btn[6].setBorderPainted(false);
			btn[6].setBackground(new Color(0, 0, 0));
			btn[6].setOpaque(false);
			btn[6].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[0] == 100) {
							btn[6].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[6].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[6].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
					}
				}
			});
			btn[6].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
			btn[6].setBounds(245, 163, 29, 29);
			panel_ciudades.add(btn[6]);

			btn[7] = new JButton("");
			btn[7].setVisible(false);
			btn[7].setBorderPainted(false);
			btn[7].setBackground(new Color(0, 0, 0));
			btn[7].setOpaque(false);
			btn[7].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[0] == 100) {
							btn[7].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[7].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[7].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
					}
				}
			});
			btn[7].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
			btn[7].setBounds(137, 277, 29, 29);
			panel_ciudades.add(btn[7]);

			btn[8] = new JButton("");
			btn[8].setVisible(false);
			btn[8].setBorderPainted(false);
			btn[8].setBackground(new Color(0, 0, 0));
			btn[8].setOpaque(false);
			btn[8].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[0] == 100) {
							btn[8].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[8].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[8].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
					}
				}
			});
			btn[8].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
			btn[8].setBounds(110, 401, 29, 29);
			panel_ciudades.add(btn[8]);

			btn[9] = new JButton("");
			btn[9].setVisible(false);
			btn[9].setBorderPainted(false);
			btn[9].setBackground(new Color(0, 0, 0));
			btn[9].setOpaque(false);
			btn[9].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[0] == 100) {
							btn[9].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[9].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[9].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
					}
				}
			});
			btn[9].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
			btn[9].setBounds(141, 441, 29, 29);
			panel_ciudades.add(btn[9]);

			btn[10] = new JButton("");
			btn[10].setVisible(false);
			btn[10].setBorderPainted(false);
			btn[10].setBackground(new Color(0, 0, 0));
			btn[10].setOpaque(false);
			btn[10].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[0] == 100) {
							btn[10].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[10].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[10].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
					}
				}
			});
			btn[10].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
			btn[10].setBounds(208, 400, 29, 29);
			panel_ciudades.add(btn[10]);

			btn[11] = new JButton("");
			btn[11].setVisible(false);
			btn[11].setBorderPainted(false);
			btn[11].setBackground(new Color(0, 0, 0));
			btn[11].setOpaque(false);
			btn[11].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[0] == 100) {
							btn[11].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[11].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[11].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
					}
				}
			});
			btn[11].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
			btn[11].setBounds(300, 431, 29, 29);
			panel_ciudades.add(btn[11]);

			btn[12] = new JButton("");
			btn[12].setVisible(false);
			btn[12].setBorderPainted(false);
			btn[12].setBackground(new Color(0, 0, 0));
			btn[12].setOpaque(false);
			btn[12].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[0] == 100) {
							btn[12].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[12].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[12].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
					}
				}
			});
			btn[12].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
			btn[12].setBounds(311, 374, 29, 29);
			panel_ciudades.add(btn[12]);

			btn[13] = new JButton("");
			btn[13].setVisible(false);
			btn[13].setBorderPainted(false);
			btn[13].setBackground(new Color(0, 0, 0));
			btn[13].setOpaque(false);
			btn[13].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[1] == 100) {
							btn[13].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[13].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[13].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
					}
				}
			});
			btn[13].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
			btn[13].setBounds(389, 289, 29, 29);
			panel_ciudades.add(btn[13]);

			btn[14] = new JButton("");
			btn[14].setVisible(false);
			btn[14].setBorderPainted(false);
			btn[14].setBackground(new Color(0, 0, 0));
			btn[14].setOpaque(false);
			btn[14].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[1] == 100) {
							btn[14].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[14].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[14].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
					}
				}
			});
			btn[14].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
			btn[14].setBounds(476, 485, 29, 29);
			panel_ciudades.add(btn[14]);

			btn[15] = new JButton("");
			btn[15].setVisible(false);
			btn[15].setBorderPainted(false);
			btn[15].setBackground(new Color(0, 0, 0));
			btn[15].setOpaque(false);
			btn[15].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[1] == 100) {
							btn[15].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[15].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[15].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
					}
				}
			});
			btn[15].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
			btn[15].setBounds(515, 505, 29, 29);
			panel_ciudades.add(btn[15]);

			btn[16] = new JButton("");
			btn[16].setVisible(false);
			btn[16].setBorderPainted(false);
			btn[16].setBackground(new Color(0, 0, 0));
			btn[16].setOpaque(false);
			btn[16].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[1] == 100) {
							btn[16].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[16].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[16].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
					}
				}
			});
			btn[16].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
			btn[16].setBounds(531, 435, 29, 29);
			panel_ciudades.add(btn[16]);

			btn[17] = new JButton("");
			btn[17].setVisible(false);
			btn[17].setBorderPainted(false);
			btn[17].setBackground(new Color(0, 0, 0));
			btn[17].setOpaque(false);
			btn[17].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[1] == 100) {
							btn[17].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[17].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[17].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
					}
				}
			});
			btn[17].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
			btn[17].setBounds(721, 506, 29, 29);
			panel_ciudades.add(btn[17]);

			btn[18] = new JButton("");
			btn[18].setVisible(false);
			btn[18].setBorderPainted(false);
			btn[18].setBackground(new Color(0, 0, 0));
			btn[18].setOpaque(false);
			btn[18].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[1] == 100) {
							btn[18].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[18].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[18].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
					}
				}
			});
			btn[18].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
			btn[18].setBounds(658, 471, 29, 29);
			panel_ciudades.add(btn[18]);

			btn[19] = new JButton("");
			btn[19].setVisible(false);
			btn[19].setBorderPainted(false);
			btn[19].setBackground(new Color(0, 0, 0));
			btn[19].setOpaque(false);
			btn[19].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[1] == 100) {
							btn[19].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[19].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[19].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
					}
				}
			});
			btn[19].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
			btn[19].setBounds(761, 478, 29, 29);
			panel_ciudades.add(btn[19]);

			btn[20] = new JButton("");
			btn[20].setVisible(false);
			btn[20].setBorderPainted(false);
			btn[20].setBackground(new Color(0, 0, 0));
			btn[20].setOpaque(false);
			btn[20].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[1] == 100) {
							btn[20].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[20].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[20].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
					}
				}
			});
			btn[20].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
			btn[20].setBounds(790, 444, 29, 29);
			panel_ciudades.add(btn[20]);

			btn[21] = new JButton("");
			btn[21].setVisible(false);
			btn[21].setBorderPainted(false);
			btn[21].setBackground(new Color(0, 0, 0));
			btn[21].setOpaque(false);
			btn[21].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[1] == 100) {
							btn[21].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[21].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[21].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
					}
				}
			});
			btn[21].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
			btn[21].setBounds(708, 429, 29, 29);
			panel_ciudades.add(btn[21]);

			btn[22] = new JButton("");
			btn[22].setVisible(false);
			btn[22].setBorderPainted(false);
			btn[22].setBackground(new Color(0, 0, 0));
			btn[22].setOpaque(false);
			btn[22].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[1] == 100) {
							btn[22].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[22].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[22].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
					}
				}
			});
			btn[22].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
			btn[22].setBounds(717, 384, 29, 29);
			panel_ciudades.add(btn[22]);

			btn[23] = new JButton("");
			btn[23].setVisible(false);
			btn[23].setBorderPainted(false);
			btn[23].setBackground(new Color(0, 0, 0));
			btn[23].setOpaque(false);
			btn[23].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[1] == 100) {
							btn[23].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[23].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[23].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
					}
				}
			});
			btn[23].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
			btn[23].setBounds(622, 392, 29, 29);
			panel_ciudades.add(btn[23]);

			btn[24] = new JButton("");
			btn[24].setVisible(false);
			btn[24].setBorderPainted(false);
			btn[24].setBackground(new Color(0, 0, 0));
			btn[24].setOpaque(false);
			btn[24].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[1] == 100) {
							btn[24].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[24].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[24].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
					}
				}
			});
			btn[24].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
			btn[24].setBounds(669, 377, 29, 29);
			panel_ciudades.add(btn[24]);

			btn[25] = new JButton("");
			btn[25].setVisible(false);
			btn[25].setBorderPainted(false);
			btn[25].setBackground(new Color(0, 0, 0));
			btn[25].setOpaque(false);
			btn[25].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[1] == 100) {
							btn[25].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[25].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[25].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
					}
				}
			});
			btn[25].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
			btn[25].setBounds(796, 348, 29, 29);
			panel_ciudades.add(btn[25]);

			btn[26] = new JButton("");
			btn[26].setVisible(false);
			btn[26].setBorderPainted(false);
			btn[26].setBackground(new Color(0, 0, 0));
			btn[26].setOpaque(false);
			btn[26].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[2] == 100) {
							btn[26].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[26].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[26].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
					}
				}
			});
			btn[26].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
			btn[26].setBounds(691, 338, 29, 29);
			panel_ciudades.add(btn[26]);

			btn[27] = new JButton("");
			btn[27].setVisible(false);
			btn[27].setBorderPainted(false);
			btn[27].setBackground(new Color(0, 0, 0));
			btn[27].setOpaque(false);
			btn[27].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[2] == 100) {
							btn[27].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[27].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[27].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
					}
				}
			});
			btn[27].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
			btn[27].setBounds(528, 327, 29, 29);
			panel_ciudades.add(btn[27]);

			btn[28] = new JButton("");
			btn[28].setVisible(false);
			btn[28].setBorderPainted(false);
			btn[28].setBackground(new Color(0, 0, 0));
			btn[28].setOpaque(false);
			btn[28].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[2] == 100) {
							btn[28].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[28].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[28].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
					}
				}
			});
			btn[28].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
			btn[28].setBounds(559, 308, 29, 29);
			panel_ciudades.add(btn[28]);

			btn[29] = new JButton("");
			btn[29].setVisible(false);
			btn[29].setBorderPainted(false);
			btn[29].setBackground(new Color(0, 0, 0));
			btn[29].setOpaque(false);
			btn[29].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[2] == 100) {
							btn[29].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[29].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[29].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
					}
				}
			});
			btn[29].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
			btn[29].setBounds(735, 236, 29, 29);
			panel_ciudades.add(btn[29]);

			btn[30] = new JButton("");
			btn[30].setVisible(false);
			btn[30].setBorderPainted(false);
			btn[30].setBackground(new Color(0, 0, 0));
			btn[30].setOpaque(false);
			btn[30].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[2] == 100) {
							btn[30].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[30].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[30].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
					}
				}
			});
			btn[30].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
			btn[30].setBounds(767, 211, 29, 29);
			panel_ciudades.add(btn[30]);

			btn[31] = new JButton("");
			btn[31].setVisible(false);
			btn[31].setBorderPainted(false);
			btn[31].setBackground(new Color(0, 0, 0));
			btn[31].setOpaque(false);
			btn[31].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[2] == 100) {
							btn[31].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[31].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[31].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
					}
				}
			});
			btn[31].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
			btn[31].setBounds(779, 106, 29, 29);
			panel_ciudades.add(btn[31]);

			btn[32] = new JButton("");
			btn[32].setVisible(false);
			btn[32].setBorderPainted(false);
			btn[32].setBackground(new Color(0, 0, 0));
			btn[32].setOpaque(false);
			btn[32].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[2] == 100) {
							btn[32].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[32].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[32].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
					}
				}
			});
			btn[32].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
			btn[32].setBounds(794, 39, 29, 29);
			panel_ciudades.add(btn[32]);

			btn[33] = new JButton("");
			btn[33].setVisible(false);
			btn[33].setBorderPainted(false);
			btn[33].setBackground(new Color(0, 0, 0));
			btn[33].setOpaque(false);
			btn[33].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[2] == 100) {
							btn[33].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[33].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[33].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
					}
				}
			});
			btn[33].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
			btn[33].setBounds(723, 46, 29, 29);
			panel_ciudades.add(btn[33]);

			btn[34] = new JButton("");
			btn[34].setVisible(false);
			btn[34].setBorderPainted(false);
			btn[34].setBackground(new Color(0, 0, 0));
			btn[34].setOpaque(false);
			btn[34].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[2] == 100) {
							btn[34].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[34].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[34].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
					}
				}
			});
			btn[34].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
			btn[34].setBounds(719, 151, 29, 29);
			panel_ciudades.add(btn[34]);

			btn[35] = new JButton("");
			btn[35].setVisible(false);
			btn[35].setBorderPainted(false);
			btn[35].setBackground(new Color(0, 0, 0));
			btn[35].setOpaque(false);
			btn[35].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[2] == 100) {
							btn[35].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[35].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[35].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
					}
				}
			});
			btn[35].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
			btn[35].setBounds(704, 106, 29, 29);
			panel_ciudades.add(btn[35]);

			btn[36] = new JButton("");
			btn[36].setVisible(false);
			btn[36].setBorderPainted(false);
			btn[36].setBackground(new Color(0, 0, 0));
			btn[36].setOpaque(false);
			btn[36].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[2] == 100) {
							btn[36].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[36].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[36].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
					}
				}
			});
			btn[36].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
			btn[36].setBounds(658, 135, 29, 29);
			panel_ciudades.add(btn[36]);

			btn[37] = new JButton("");
			btn[37].setVisible(false);
			btn[37].setBorderPainted(false);
			btn[37].setBackground(new Color(0, 0, 0));
			btn[37].setOpaque(false);
			btn[37].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[2] == 100) {
							btn[37].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[37].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[37].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
					}
				}
			});
			btn[37].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
			btn[37].setBounds(597, 95, 29, 29);
			panel_ciudades.add(btn[37]);

			btn[38] = new JButton("");
			btn[38].setVisible(false);
			btn[38].setBorderPainted(false);
			btn[38].setBackground(new Color(0, 0, 0));
			btn[38].setOpaque(false);
			btn[38].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[3] == 100) {
							btn[38].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[38].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[38].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
					}
				}
			});
			btn[38].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
			btn[38].setBounds(597, 156, 29, 29);
			panel_ciudades.add(btn[38]);

			btn[39] = new JButton("");
			btn[39].setVisible(false);
			btn[39].setBorderPainted(false);
			btn[39].setBackground(new Color(0, 0, 0));
			btn[39].setOpaque(false);
			btn[39].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[3] == 100) {
							btn[39].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[39].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[39].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
					}
				}
			});
			btn[39].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
			btn[39].setBounds(642, 201, 29, 29);
			panel_ciudades.add(btn[39]);

			btn[40] = new JButton("");
			btn[40].setVisible(false);
			btn[40].setBorderPainted(false);
			btn[40].setBackground(new Color(0, 0, 0));
			btn[40].setOpaque(false);
			btn[40].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[3] == 100) {
							btn[40].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[40].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[40].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
					}
				}
			});
			btn[40].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
			btn[40].setBounds(607, 223, 29, 29);
			panel_ciudades.add(btn[40]);

			btn[41] = new JButton("");
			btn[41].setVisible(false);
			btn[41].setBorderPainted(false);
			btn[41].setBackground(new Color(0, 0, 0));
			btn[41].setOpaque(false);
			btn[41].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[3] == 100) {
							btn[41].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[41].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[41].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
					}
				}
			});
			btn[41].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
			btn[41].setBounds(503, 246, 29, 29);
			panel_ciudades.add(btn[41]);

			btn[42] = new JButton("");
			btn[42].setVisible(false);
			btn[42].setBorderPainted(false);
			btn[42].setBackground(new Color(0, 0, 0));
			btn[42].setOpaque(false);
			btn[42].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[3] == 100) {
							btn[42].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[42].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[42].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
					}
				}
			});
			btn[42].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
			btn[42].setBounds(511, 109, 29, 29);
			panel_ciudades.add(btn[42]);

			btn[43] = new JButton("");
			btn[43].setVisible(false);
			btn[43].setBorderPainted(false);
			btn[43].setBackground(new Color(0, 0, 0));
			btn[43].setOpaque(false);
			btn[43].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[3] == 100) {
							btn[43].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[43].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[43].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
					}
				}
			});
			btn[43].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
			btn[43].setBounds(421, 239, 29, 29);
			panel_ciudades.add(btn[43]);

			btn[44] = new JButton("");
			btn[44].setVisible(false);
			btn[44].setBorderPainted(false);
			btn[44].setBackground(new Color(0, 0, 0));
			btn[44].setOpaque(false);
			btn[44].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[3] == 100) {
							btn[44].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[44].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[44].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
					}
				}
			});
			btn[44].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
			btn[44].setBounds(359, 213, 29, 29);
			panel_ciudades.add(btn[44]);

			btn[45] = new JButton("");
			btn[45].setVisible(false);
			btn[45].setBorderPainted(false);
			btn[45].setBackground(new Color(0, 0, 0));
			btn[45].setOpaque(false);
			btn[45].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[3] == 100) {
							btn[45].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[45].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[45].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
					}
				}
			});
			btn[45].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
			btn[45].setBounds(416, 173, 29, 29);
			panel_ciudades.add(btn[45]);

			btn[46] = new JButton("");
			btn[46].setVisible(false);
			btn[46].setBorderPainted(false);
			btn[46].setBackground(new Color(0, 0, 0));
			btn[46].setOpaque(false);
			btn[46].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[3] == 100) {
							btn[46].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[46].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[46].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
					}
				}
			});
			btn[46].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
			btn[46].setBounds(349, 165, 29, 29);
			panel_ciudades.add(btn[46]);

			btn[47] = new JButton("");
			btn[47].setVisible(false);
			btn[47].setBorderPainted(false);
			btn[47].setBackground(new Color(0, 0, 0));
			btn[47].setOpaque(false);
			btn[47].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[3] == 100) {
							btn[47].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[47].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[47].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
					}
				}
			});
			btn[47].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
			btn[47].setBounds(411, 123, 29, 29);
			panel_ciudades.add(btn[47]);

			btn[48] = new JButton("");
			btn[48].setVisible(false);
			btn[48].setBorderPainted(false);
			btn[48].setBackground(new Color(0, 0, 0));
			btn[48].setOpaque(false);
			btn[48].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[3] == 100) {
							btn[48].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[48].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[48].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
					}
				}
			});
			btn[48].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
			btn[48].setBounds(497, 65, 29, 29);
			panel_ciudades.add(btn[48]);

			btn[49] = new JButton("");
			btn[49].setVisible(false);
			btn[49].setBorderPainted(false);
			btn[49].setBackground(new Color(0, 0, 0));
			btn[49].setOpaque(false);
			btn[49].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if (btciu == true) {
						if (vacunasimg[3] == 100) {
							btn[49].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocionMax.png")));
						} else {
							btn[49].setIcon(new ImageIcon(Play.class.getResource("/ciudades/pocion.png")));
						}					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (btciu == true) {
						btn[49].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
					}
				}
			});
			btn[49].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
			btn[49].setBounds(337, 58, 29, 29);
			panel_ciudades.add(btn[49]);

		}

		System.out.println("\n");

		class ActualizarBtn {

			private void actualizarVisibilidadBotones() {
				int c = 0;
				do {
					ciudad_infectada e = bc.CiudadInfectada.get(c);

					if (e.getInfeccion() >= 1 || (e.getInfeccion() == 0 && visible[c])) {
						visible[c] = true;
					} else if (e.getInfeccion() == 0 || !visible[c]) {
						visible[c] = false;
					}
					c++;
				} while (c < visible.length);

				c = 0;
				System.out.println("\n");
				do {
					for (int i = 0; i < btn.length && c < visible.length; i++) {
						btn[i].setVisible(visible[c]);
						c++;
					}
				} while (c < visible.length);

				for (int i = 0; i < btn.length && i < visible.length; i++) {
					btn[i].setVisible(visible[i]);
				}
			}

		}

		if (ronda == 1) {

			int c = 0;

			for (int i = 0; i < 49; i++) {
				ciudad_infectada e = bc.CiudadInfectada.get(i);

				if (e.getInfeccion() >= 1) {
					visible[i] = true;
				} else if (e.getInfeccion() == 0) {
					visible[i] = false;
				}
				// System.out.println(e.getNumCiudad() + ", " + e.getCiudad() + " , " + i + ": "
				// + visible[i]);
			}

			System.out.println("\n");

			do {
				for (int i = 0; i < btn.length; i++) {
					btn[i].setVisible(visible[c]);
					// System.out.println(c + ": " + visible[c]);
					// System.out.println(i + ": " + btn[i]);
					c++;
				}
			} while (c < 49);

			ronda = 0;

		}

		JTextPane txtpnInfoCiudades = new JTextPane();
		txtpnInfoCiudades.setEditable(false);
		// INTRODUZCO EL TEXTO PARA QUE SALGA LA CIUDAD
		txtpnInfoCiudades.setText("\r\n   ");
		txtpnInfoCiudades.setForeground(Color.WHITE);
		txtpnInfoCiudades.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		txtpnInfoCiudades.setBackground(new Color(0, 0, 0));
		txtpnInfoCiudades.setBounds(19, 87, 388, 92);
		infoCura.add(txtpnInfoCiudades);

		JTextPane txtpnInfoINFECCION = new JTextPane();
		txtpnInfoINFECCION.setEditable(false);
		txtpnInfoINFECCION.setForeground(Color.WHITE);
		txtpnInfoINFECCION.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		txtpnInfoINFECCION.setBackground(Color.BLACK);
		txtpnInfoINFECCION.setBounds(458, 87, 97, 92);
		infoCura.add(txtpnInfoINFECCION);

		JTextPane txtpnInfoBRTOES = new JTextPane();
		txtpnInfoBRTOES.setEditable(false);
		txtpnInfoBRTOES.setForeground(Color.WHITE);
		txtpnInfoBRTOES.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		txtpnInfoBRTOES.setBackground(Color.BLACK);
		txtpnInfoBRTOES.setBounds(619, 87, 97, 92);
		infoCura.add(txtpnInfoBRTOES);

		JTextPane txtpnInfoVIRUS = new JTextPane();
		txtpnInfoVIRUS.setEditable(false);
		txtpnInfoVIRUS.setForeground(Color.WHITE);
		txtpnInfoVIRUS.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		txtpnInfoVIRUS.setBackground(Color.BLACK);
		txtpnInfoVIRUS.setBounds(737, 87, 136, 92);
		infoCura.add(txtpnInfoVIRUS);

		JTextPane txtpnInfoCiudad = new JTextPane();
		txtpnInfoCiudad.setEditable(false);
		txtpnInfoCiudad.setText(
				" |              NOMBRE CIUDADES              |    INFECCIONES    |    BROTES    |      VIRUS      |");
		txtpnInfoCiudad.setForeground(Color.WHITE);
		txtpnInfoCiudad.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtpnInfoCiudad.setBackground(Color.BLACK);
		txtpnInfoCiudad.setBounds(9, 11, 1222, 77);
		infoCura.add(txtpnInfoCiudad);

		JTextPane txtpnInfoCiudades_1 = new JTextPane();
		txtpnInfoCiudades_1.setText("\r\n   ");
		txtpnInfoCiudades_1.setForeground(Color.WHITE);
		txtpnInfoCiudades_1.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		txtpnInfoCiudades_1.setBackground(Color.BLACK);
		txtpnInfoCiudades_1.setBounds(9, 87, 874, 92);
		infoCura.add(txtpnInfoCiudades_1);

		// ==============================================================================================================================================================================================================================================================================
		// ==============================================================================================================================================================================================================================================================================

		JPanel vacuna = new JPanel();
		vacuna.setBorder(new LineBorder(new Color(15, 255, 177), 6));
		vacuna.setVisible(ver);
		vacuna.setBackground(null);
		vacuna.setBounds(0, 568, 1241, 187);
		vacuna.setLayout(null);
		panel_general.add(vacuna);

		JButton btnAlfa = new JButton("");
		btnAlfa.setDisabledIcon(new ImageIcon(Play.class.getResource("/vacunas/alfaNegro.png")));
		btnAlfa.setEnabled(true);
		btnAlfa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAlfa.setIcon(new ImageIcon(Play.class.getResource("/vacunas/alfa2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAlfa.setIcon(new ImageIcon(Play.class.getResource("/vacunas/alfa1.png")));
			}
		});

		btnAlfa.setIcon(new ImageIcon(Play.class.getResource("/vacunas/alfa1.png")));
		btnAlfa.setContentAreaFilled(false);
		btnAlfa.setBorderPainted(false);
		btnAlfa.setBorder(null);
		btnAlfa.setBackground((Color) null);
		btnAlfa.setBounds(10, 40, 305, 108);
		vacuna.add(btnAlfa);

		JButton btnBeta = new JButton("");
		btnBeta.setDisabledIcon(new ImageIcon(Play.class.getResource("/vacunas/betaNegro.png")));
		btnBeta.setEnabled(true);
		btnBeta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBeta.setIcon(new ImageIcon(Play.class.getResource("/vacunas/beta2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnBeta.setIcon(new ImageIcon(Play.class.getResource("/vacunas/beta1.png")));
			}
		});

		btnBeta.setIcon(new ImageIcon(Play.class.getResource("/vacunas/beta1.png")));
		btnBeta.setContentAreaFilled(false);
		btnBeta.setBorderPainted(false);
		btnBeta.setBorder(null);
		btnBeta.setBackground((Color) null);
		btnBeta.setBounds(313, 40, 305, 108);
		vacuna.add(btnBeta);

		JButton btnDelta = new JButton("");
		btnDelta.setDisabledIcon(new ImageIcon(Play.class.getResource("/vacunas/deltaNegro.png")));
		btnDelta.setEnabled(true);
		btnDelta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDelta.setIcon(new ImageIcon(Play.class.getResource("/vacunas/delta2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnDelta.setIcon(new ImageIcon(Play.class.getResource("/vacunas/delta1.png")));
			}
		});

		btnDelta.setIcon(new ImageIcon(Play.class.getResource("/vacunas/delta1.png")));
		btnDelta.setContentAreaFilled(false);
		btnDelta.setBorderPainted(false);
		btnDelta.setBorder(null);
		btnDelta.setBackground((Color) null);
		btnDelta.setBounds(623, 40, 305, 108);
		vacuna.add(btnDelta);

		JButton btnGama = new JButton("");
		btnGama.setDisabledIcon(new ImageIcon(Play.class.getResource("/vacunas/gamaNegro.png")));
		btnGama.setEnabled(true);
		btnGama.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGama.setIcon(new ImageIcon(Play.class.getResource("/vacunas/gama2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnGama.setIcon(new ImageIcon(Play.class.getResource("/vacunas/gama1.png")));
			}
		});

		btnGama.setIcon(new ImageIcon(Play.class.getResource("/vacunas/gama1.png")));
		btnGama.setContentAreaFilled(false);
		btnGama.setBorderPainted(false);
		btnGama.setBorder(null);
		btnGama.setBackground((Color) null);
		btnGama.setBounds(926, 40, 305, 108);
		vacuna.add(btnGama);

		// ==============================================================================================================================================================================================================================================================================
		// ==============================================================================================================================================================================================================================================================================

		JPanel Action1 = new JPanel();
		Action1.setBorder(new LineBorder(new Color(15, 255, 177), 6));
		Action1.setVisible(true);
		Action1.setBackground(null);
		Action1.setBounds(352, 568, 889, 187);
		panel_general.add(Action1);
		Action1.setLayout(null);

		JButton btnCura = new JButton("");
		btnCura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCura.setIcon(new ImageIcon(Play.class.getResource("/play/btn/btnCura2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCura.setIcon(new ImageIcon(Play.class.getResource("/play/btn/btnCura1.png")));
			}
		});
		btnCura.setContentAreaFilled(false);
		btnCura.setBorderPainted(false);
		btnCura.setBorder(null);
		btnCura.setBackground(null);
		btnCura.setIcon(new ImageIcon(Play.class.getResource("/play/btn/btnCura1.png")));
		btnCura.setBounds(15, 11, 469, 165);
		Action1.add(btnCura);

		JButton btnVacuna = new JButton("");
		btnVacuna.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVacuna.setIcon(new ImageIcon(Play.class.getResource("/play/btn/btnCrearVac2.png")));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnVacuna.setIcon(new ImageIcon(Play.class.getResource("/play/btn/btnCrearVac1.png")));
			}
		});
		btnVacuna.setContentAreaFilled(false);
		btnVacuna.setBorderPainted(false);
		btnVacuna.setBorder(null);
		btnVacuna.setBackground(null);
		btnVacuna.setIcon(new ImageIcon(Play.class.getResource("/play/btn/btnCrearVac1.png")));
		btnVacuna.setBounds(496, 10, 372, 165);
		Action1.add(btnVacuna);

		JToggleButton tglbtnEye = new JToggleButton("");
		tglbtnEye.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tglbtnEye.isSelected()) {
					// Si el botón de alternancia está seleccionado, actualizar la posición y tamaño
					// de los componentes
					btnCura.setIcon(new ImageIcon(Play.class.getResource("/play/btn/CuraEnf1.png")));
					btnCura.setBounds(20, 11, 660, 166);
					btnCura.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							btnCura.setIcon(new ImageIcon(Play.class.getResource("/play/btn/CuraEnf2.png")));
						}

						@Override
						public void mouseExited(MouseEvent e) {
							btnCura.setIcon(new ImageIcon(Play.class.getResource("/play/btn/CuraEnf1.png")));
						}
					});
					btnVacuna.setIcon(new ImageIcon(Play.class.getResource("/play/btn/CrearVac1.png")));
					btnVacuna.setBounds(700, 11, 523, 165);
					btnVacuna.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							btnVacuna.setIcon(new ImageIcon(Play.class.getResource("/play/btn/CrearVac2.png")));
						}

						@Override
						public void mouseExited(MouseEvent e) {
							btnVacuna.setIcon(new ImageIcon(Play.class.getResource("/play/btn/CrearVac1.png")));
						}
					});
					Action1.setBounds(0, 568, 1241, 187);
				} else {
					// Si el botón de alternancia no está seleccionado, restaurar la posición y
					// tamaño predeterminados de los componentes
					btnCura.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							btnCura.setIcon(new ImageIcon(Play.class.getResource("/play/btn/btnCura2.png")));
						}

						@Override
						public void mouseExited(MouseEvent e) {
							btnCura.setIcon(new ImageIcon(Play.class.getResource("/play/btn/btnCura1.png")));
						}
					});
					btnCura.setContentAreaFilled(false);
					btnCura.setBorderPainted(false);
					btnCura.setBorder(null);
					btnCura.setBackground(null);
					btnCura.setIcon(new ImageIcon(Play.class.getResource("/play/btn/btnCura1.png")));
					btnCura.setBounds(15, 11, 469, 165);
					Action1.add(btnCura);

					btnVacuna.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							btnVacuna.setIcon(new ImageIcon(Play.class.getResource("/play/btn/btnCrearVac2.png")));

						}

						@Override
						public void mouseExited(MouseEvent e) {
							btnVacuna.setIcon(new ImageIcon(Play.class.getResource("/play/btn/btnCrearVac1.png")));
						}
					});
					btnVacuna.setContentAreaFilled(false);
					btnVacuna.setBorderPainted(false);
					btnVacuna.setBorder(null);
					btnVacuna.setBackground(null);
					btnVacuna.setIcon(new ImageIcon(Play.class.getResource("/play/btn/btnCrearVac1.png")));
					btnVacuna.setBounds(496, 10, 372, 165);
					Action1.add(btnVacuna);
					Action1.setBounds(352, 568, 889, 187);
				}
			}
		});

		JButton btnAtras = new JButton("");
		btnAtras.setVisible(false);
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vacuna.setVisible(ver);
				btnAtras.setVisible(false);
				infoCura.setVisible(false);
				tglbtnEye.setVisible(true);
				if (!infoCura.isVisible() && btciu == true) {
					btciu = false;
				}
				Action1.setVisible(!vacuna.isVisible());

			}
		});
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setIcon(new ImageIcon(Play.class.getResource("/play/atras2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setIcon(new ImageIcon(Play.class.getResource("/play/atras1.png")));
			}
		});
		btnAtras.setBorderPainted(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBackground(null);
		btnAtras.setIcon(new ImageIcon(Play.class.getResource("/play/atras1.png")));
		btnAtras.setBounds(363, 518, 84, 47);

		// Botón vacunas
		btnVacuna.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Action1.setVisible(ver);
				// Al llegar la vacuna al 100% deshabilita el botón
				if (Vacuna.Alfa == 100) {
					// Si es la ultima vacuna, al completarla ganas el juego
					if (f.fin() == true) {
						dispose();
					}
					btnAlfa.setEnabled(false);
				}
				if (Vacuna.Beta == 100) {
					// Si es la ultima vacuna, al completarla ganas el juego
					if (f.fin() == true) {
						dispose();
					}
					btnBeta.setEnabled(false);
				}
				if (Vacuna.Delta == 100) {
					// Si es la ultima vacuna, al completarla ganas el juego
					if (f.fin() == true) {
						dispose();
					}
					btnDelta.setEnabled(false);
				}
				if (Vacuna.Gama == 100) {
					// Si es la ultima vacuna, al completarla ganas el juego
					if (f.fin() == true) {
						dispose();
					}
					btnGama.setEnabled(false);
				}
				vacuna.setVisible(!vacuna.isVisible());
				btnAtras.setVisible(true);
				tglbtnEye.setVisible(false);
			}
		});

		/*
		 * estamos obteniendo todos los componentes dentro del panel panel_ciudades y
		 * verificando si son botones antes de habilitarlos. Si el componente es un
		 * botón, lo habilitamos usando el método setEnabled(true).
		 */

		btnCura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Action1.setVisible(false);
				tglbtnEye.setVisible(true);
				btciu = true;
				btnAtras.setVisible(true);
				infoCura.setVisible(true);
			}
		});

		// ==============================================================================================================================================================================================================================================================================
		// ==============================================================================================================================================================================================================================================================================

		panel_general.add(btnAtras);

		JButton Guardar = new JButton("");
		Guardar.setDefaultCapable(false);
		Guardar.setOpaque(false);
		Guardar.setContentAreaFilled(false);
		Guardar.setBorderPainted(false);
		Guardar.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				//GuardarBD.baseDeDatos();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Guardar.setIcon(new ImageIcon(Play.class.getResource("/image/save2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Guardar.setIcon(new ImageIcon(Play.class.getResource("/image/save.png")));
			}
		});
		Guardar.setIcon(new ImageIcon(Play.class.getResource("/image/save.png")));
		Guardar.setBounds(378, 352, 69, 63);
		panel_general.add(Guardar);

		tglbtnEye.setContentAreaFilled(false);
		tglbtnEye.setBorder(null);
		tglbtnEye.setBorderPainted(false);
		tglbtnEye.setPressedIcon(new ImageIcon(Play.class.getResource("/play/eye.png")));
		tglbtnEye.setBackground(null);
		tglbtnEye.setOpaque(false);
		tglbtnEye.setIcon(new ImageIcon(Play.class.getResource("/play/eye2.png")));
		tglbtnEye.setSelectedIcon(new ImageIcon(Play.class.getResource("/play/eye.png")));
		tglbtnEye.setBounds(363, 463, 69, 47);
		panel_general.add(tglbtnEye);

		// ==============================================================================================================================================================================================================================================================================
		// ==============================================================================================================================================================================================================================================================================

		JLabel LabelMapImage = new JLabel("");
		LabelMapImage.setIcon(new ImageIcon(Play.class.getResource("/image/rutas pokemon.png")));
		LabelMapImage.setBounds(-2, 0, 1242, 572);
		panel_general.add(LabelMapImage);

		// ==============================================================================================================================================================================================================================================================================
		// ==============================================================================================================================================================================================================================================================================

		JPanel panel = new JPanel();
		panel.setName("");
		panel.setBackground(Color.BLACK);
		panel.setBounds(6, 573, 346, 175);
		panel_general.add(panel);
		panel.setLayout(null);

		JTextPane txtpnAlfa = new JTextPane();
		txtpnAlfa.setVisible(true);

		JTextPane txtpnInfo = new JTextPane();
		// txtpnInfo.setText("Nº Infeccion: " + busc_ciudad.contarInfecciones() + "Nº
		// Brotes: "+ busc_ciudad.contarBrotes());
		txtpnInfo.setText(
				" Nº Infeccion: " + busc_ciudad.contarInfecciones() + "   Nº Brotes: " + busc_ciudad.contarBrotes());
		txtpnInfo.setForeground(Color.YELLOW);
		txtpnInfo.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtpnInfo.setEditable(false);
		txtpnInfo.setBackground(Color.BLACK);
		txtpnInfo.setBounds(0, 0, 346, 30);
		panel.add(txtpnInfo);

		txtpnAlfa.setText("Alfa");
		txtpnAlfa.setForeground(Color.BLUE);
		txtpnAlfa.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtpnAlfa.setEditable(false);
		txtpnAlfa.setBackground(null);
		txtpnAlfa.setBounds(10, 24, 70, 31);
		panel.add(txtpnAlfa);

		btnAlfa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NumAcc++;
				if (NumAcc == 4) {
					ronda = 1;
					Start_game.Start(LeerParametros.CiuInfIRonda);
					txtpnInfo.setText(" Nº Infeccion: " + busc_ciudad.contarInfecciones() + "   Nº Brotes: "
							+ busc_ciudad.contarBrotes());
					ActualizarBtn ActB = new ActualizarBtn();
					ActB.actualizarVisibilidadBotones();
					NumAcc = 0;
				}
				Action1.setVisible(true);
				btnAtras.setVisible(false);
				tglbtnEye.setVisible(true);

				if (Vacuna.Alfa == 100 && Vacuna.Beta == 100 && Vacuna.Delta == 100 && Vacuna.Gama == 100) {
					fg.ver = true;
					//GuardarBD.resultado = "V";
					//System.out.println("Letra =" + GuardarBD.resultado);
					ganador.i = NPoke;
					//GuardarBD.baseDeDatos();
					ganador.mainfin();
					// System.out.println(NPoke);
					dispose();
				} else if (f.fin() == true) {
					fg.ver = true;
					//GuardarBD.resultado = "F";
					//System.out.println("Letra =" + GuardarBD.resultado);
					FinGame.i = NPoke;
					//GuardarBD.baseDeDatos();
					FinGame.mainfin();
					// System.out.println(NPoke);
					dispose();
				}
			}
		});
		btnBeta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NumAcc++;
				if (NumAcc == 4) {
					ronda = 1;
					Start_game.Start(LeerParametros.CiuInfIRonda);
					txtpnInfo.setText(" Nº Infeccion: " + busc_ciudad.contarInfecciones() + "   Nº Brotes: "
							+ busc_ciudad.contarBrotes());
					ActualizarBtn ActB = new ActualizarBtn();
					ActB.actualizarVisibilidadBotones();
					NumAcc = 0;
				}
				Action1.setVisible(true);
				btnAtras.setVisible(false);
				tglbtnEye.setVisible(true);

				if (Vacuna.Alfa == 100 && Vacuna.Beta == 100 && Vacuna.Delta == 100 && Vacuna.Gama == 100) {
					fg.ver = true;
					//GuardarBD.resultado = "V";
					//System.out.println("Letra =" + GuardarBD.resultado);
					ganador.i = NPoke;
					//GuardarBD.baseDeDatos();
					ganador.mainfin();
					// System.out.println(NPoke);
					dispose();
				} else if (f.fin() == true) {
					fg.ver = true;
					//GuardarBD.resultado = "F";
					//System.out.println("Letra =" + GuardarBD.resultado);
					FinGame.i = NPoke;
					//GuardarBD.baseDeDatos();
					FinGame.mainfin();
					// System.out.println(NPoke);
					dispose();
				}
			}
		});
		btnDelta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NumAcc++;
				if (NumAcc == 4) {
					ronda = 1;
					Start_game.Start(LeerParametros.CiuInfIRonda);
					txtpnInfo.setText(" Nº Infeccion: " + busc_ciudad.contarInfecciones() + "   Nº Brotes: "
							+ busc_ciudad.contarBrotes());
					ActualizarBtn ActB = new ActualizarBtn();
					ActB.actualizarVisibilidadBotones();
					NumAcc = 0;
				}
				Action1.setVisible(true);
				btnAtras.setVisible(false);
				tglbtnEye.setVisible(true);

				if (Vacuna.Alfa == 100 && Vacuna.Beta == 100 && Vacuna.Delta == 100 && Vacuna.Gama == 100) {
					fg.ver = true;
					//GuardarBD.resultado = "V";
					//System.out.println("Letra =" + GuardarBD.resultado);
					ganador.i = NPoke;
					//GuardarBD.baseDeDatos();
					ganador.mainfin();
					// System.out.println(NPoke);
					dispose();
				} else if (f.fin() == true) {
					fg.ver = true;
					//GuardarBD.resultado = "F";
					//System.out.println("Letra =" + GuardarBD.resultado);
					FinGame.i = NPoke;
					//GuardarBD.baseDeDatos();
					FinGame.mainfin();
					// System.out.println(NPoke);
					dispose();
				}
			}
		});
		btnGama.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NumAcc++;
				if (NumAcc == 4) {
					ronda = 1;
					Start_game.Start(LeerParametros.CiuInfIRonda);
					txtpnInfo.setText(" Nº Infeccion: " + busc_ciudad.contarInfecciones() + "   Nº Brotes: "
							+ busc_ciudad.contarBrotes());
					ActualizarBtn ActB = new ActualizarBtn();
					ActB.actualizarVisibilidadBotones();
					NumAcc = 0;
				}
				Action1.setVisible(true);
				btnAtras.setVisible(false);
				tglbtnEye.setVisible(true);

				if (Vacuna.Alfa == 100 && Vacuna.Beta == 100 && Vacuna.Delta == 100 && Vacuna.Gama == 100) {
					fg.ver = true;
					//GuardarBD.resultado = "V";
					//System.out.println("Letra =" + GuardarBD.resultado);
					ganador.i = NPoke;
					//GuardarBD.baseDeDatos();
					ganador.mainfin();
					// System.out.println(NPoke);
					dispose();
				} else if (f.fin() == true) {
					fg.ver = true;
					//GuardarBD.resultado = "F";
					//System.out.println("Letra =" + GuardarBD.resultado);
					FinGame.i = NPoke;
					//GuardarBD.baseDeDatos();
					FinGame.mainfin();
					// System.out.println(NPoke);
					dispose();
				}
			}

		});

		for (int i = 0; i < btn.length; i++) {

			int N = i;

			btn[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					String[] info = bc.getCiuInfo(N);
					switch (N) {
					case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12:
						txtpnInfoCiudades.setForeground(new Color(77, 186, 251));
						txtpnInfoINFECCION.setForeground(new Color(77, 186, 251));
						txtpnInfoBRTOES.setForeground(new Color(77, 186, 251));
						txtpnInfoVIRUS.setForeground(new Color(77, 186, 251));
						break;
					case 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25:
						txtpnInfoCiudades.setForeground(Color.red);
						txtpnInfoINFECCION.setForeground(Color.red);
						txtpnInfoBRTOES.setForeground(Color.red);
						txtpnInfoVIRUS.setForeground(Color.red);
						break;
					case 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37:
						txtpnInfoCiudades.setForeground(Color.green);
						txtpnInfoINFECCION.setForeground(Color.green);
						txtpnInfoBRTOES.setForeground(Color.green);
						txtpnInfoVIRUS.setForeground(Color.green);
						break;
					case 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49:
						txtpnInfoCiudades.setForeground(Color.yellow);
						txtpnInfoINFECCION.setForeground(Color.yellow);
						txtpnInfoBRTOES.setForeground(Color.yellow);
						txtpnInfoVIRUS.setForeground(Color.yellow);
						break;
					}
					txtpnInfoCiudades.setText("  " + info[0]); // Por ejemplo, accediendo al primer elemento del arreglo
					txtpnInfoINFECCION.setText(info[1]);
					txtpnInfoBRTOES.setText(info[2]);
					txtpnInfoVIRUS.setText(info[3]);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					txtpnInfoCiudades.setText(" ");
					txtpnInfoINFECCION.setText(" ");
					txtpnInfoBRTOES.setText(" ");
					txtpnInfoVIRUS.setText(" ");
				}

				@Override
				public void mouseClicked(MouseEvent e) {

					int[] vacunas = { Vacuna.Alfa, Vacuna.Beta, Vacuna.Delta, Vacuna.Gama };

					if (btciu == true) {
						visible[N] = bc.RestarInfCiu(N, vacunas);

						// System.out.println("Boton Apretado");
						switch (N) {
						case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12:
							btn[N].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo azul.png")));
							break;
						case 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25:
							btn[N].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo rojo.png")));
							break;
						case 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37:
							btn[N].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo verde.png")));
							break;
						case 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49:
							btn[N].setIcon(new ImageIcon(Play.class.getResource("/ciudades/circulo amarillo.png")));
							break;
						}
						NumAcc++;
						txtpnInfo.setText(" Nº Infeccion: " + busc_ciudad.contarInfecciones() + "   Nº Brotes: "
								+ busc_ciudad.contarBrotes());
						if (NumAcc == 4) {
							ronda = 1;
							Start_game.Start(LeerParametros.CiuInfIRonda);
							txtpnInfo.setText(" Nº Infeccion: " + busc_ciudad.contarInfecciones() + "   Nº Brotes: "
									+ busc_ciudad.contarBrotes());
							ActualizarBtn ActB = new ActualizarBtn();
							ActB.actualizarVisibilidadBotones();
							NumAcc = 0;
						}
						ActualizarBtn ActB = new ActualizarBtn();
						ActB.actualizarVisibilidadBotones();
						btnAtras.setVisible(false);
						infoCura.setVisible(false);
						Action1.setVisible(true);
						btciu = false;

						if (Vacuna.Alfa == 100 && Vacuna.Beta == 100 && Vacuna.Delta == 100 && Vacuna.Gama == 100) {
							fg.ver = true;
							//GuardarBD.resultado = "V";
							//System.out.println("Letra =" + GuardarBD.resultado);
							ganador.i = NPoke;
							//GuardarBD.baseDeDatos();
							ganador.mainfin();
							// System.out.println(NPoke);
							dispose();
						} else if (f.fin() == true) {
							fg.ver = true;
							//GuardarBD.resultado = "F";
							//System.out.println("Letra =" + GuardarBD.resultado);
							FinGame.i = NPoke;
							//GuardarBD.baseDeDatos();
							FinGame.mainfin();
							// System.out.println(NPoke);
							dispose();
						}
					}
				}

			});

		}

		JTextPane txtpnBeta = new JTextPane();
		txtpnBeta.setVisible(true);
		txtpnBeta.setText(" Beta");
		txtpnBeta.setForeground(Color.RED);
		txtpnBeta.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtpnBeta.setEditable(false);
		txtpnBeta.setBackground(null);
		txtpnBeta.setBounds(74, 24, 70, 31);
		panel.add(txtpnBeta);

		JTextPane txtpnDelta = new JTextPane();
		txtpnDelta.setVisible(true);
		txtpnDelta.setText("Delta");
		txtpnDelta.setForeground(Color.ORANGE);
		txtpnDelta.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtpnDelta.setEditable(false);
		txtpnDelta.setBackground(null);
		txtpnDelta.setBounds(154, 24, 71, 31);
		panel.add(txtpnDelta);

		JTextPane txtpnGama = new JTextPane();
		txtpnGama.setVisible(true);
		txtpnGama.setText("Gama");
		txtpnGama.setForeground(Color.GREEN);
		txtpnGama.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtpnGama.setEditable(false);
		txtpnGama.setBackground(null);
		txtpnGama.setBounds(235, 24, 79, 31);
		panel.add(txtpnGama);

		JLabel LoadAlfa = new JLabel("New label");
		LoadAlfa.setVisible(true);
		LoadAlfa.setIcon(new ImageIcon(Play.class.getResource("/play/loadAlfa/0.png")));
		LoadAlfa.setBounds(12, 56, 44, 119);
		panel.add(LoadAlfa);

		btnAlfa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vacuna.setALFA(10);
				LoadAlfa.setIcon(Vacuna.getAlfaImage());
				vacuna.setVisible(false);
			}
		});

		JLabel LoadBeta = new JLabel("New label");
		LoadBeta.setVisible(true);
		LoadBeta.setIcon(new ImageIcon(Play.class.getResource("/play/loadBeta/0.png")));
		LoadBeta.setBounds(85, 55, 44, 119);
		panel.add(LoadBeta);

		btnBeta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Vacuna.setBETA(10);
				LoadBeta.setIcon(Vacuna.getBetaImage());
				vacuna.setVisible(false);
			}
		});

		JLabel LoadDelta = new JLabel("New label");
		LoadDelta.setVisible(true);
		LoadDelta.setIcon(new ImageIcon(Play.class.getResource("/play/loadDelta/0.png")));
		LoadDelta.setBounds(163, 57, 44, 119);
		panel.add(LoadDelta);

		btnDelta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Vacuna.setDELTA(10);
				LoadDelta.setIcon(Vacuna.getDeltaImage());
				vacuna.setVisible(false);
			}
		});

		JLabel LoadGama = new JLabel("New label");
		LoadGama.setVisible(true);
		LoadGama.setIcon(new ImageIcon(Play.class.getResource("/play/loadGama/0.png")));
		LoadGama.setBounds(250, 55, 44, 119);
		panel.add(LoadGama);

		btnGama.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Vacuna.setGAMA(10);
				LoadGama.setIcon(Vacuna.getGamaImage());
				vacuna.setVisible(false);
			}
		});
	}
}