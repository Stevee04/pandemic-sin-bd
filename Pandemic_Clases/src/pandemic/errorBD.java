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

public class errorBD extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void runErrorBd() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					errorBD frame = new errorBD();
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
	public errorBD() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(710, 300, 369, 149);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnErrorEsteNombre = new JTextPane();
		txtpnErrorEsteNombre.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtpnErrorEsteNombre.setAutoscrolls(false);
		txtpnErrorEsteNombre.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnErrorEsteNombre.setEditable(false);
		//txtpnErrorEsteNombre.setText(GuardarBD.ErrorBD);
		txtpnErrorEsteNombre.setBounds(0, 0, 366, 112);
		contentPane.add(txtpnErrorEsteNombre);
		
	}
}
