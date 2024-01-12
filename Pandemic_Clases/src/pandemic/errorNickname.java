package pandemic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class errorNickname extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void runErrorName() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					errorNickname frame = new errorNickname();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public errorNickname() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(710, 300, 340, 149);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnErrorEsteNombre = new JTextPane();
		txtpnErrorEsteNombre.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtpnErrorEsteNombre.setAutoscrolls(false);
		txtpnErrorEsteNombre.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnErrorEsteNombre.setEditable(false);
		txtpnErrorEsteNombre.setText("ERROR:\r\nEste nombre ya a sido introducido !!!\r\nPon otro nickname.");
		txtpnErrorEsteNombre.setBounds(0, 0, 341, 78);
		contentPane.add(txtpnErrorEsteNombre);
		
		JButton btnCambiarNombre = new JButton("Cambiar Nombre");
		btnCambiarNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCambiarNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCambiarNombre.setBounds(0, 79, 341, 33);
		contentPane.add(btnCambiarNombre);
	}
}
