import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;

public class Start {

	private static JDesktopPane panel_datos;
	private static JPanel panel_menu;
	private PreLogin preLogin;
	private JFrame frame;
	private JScrollPane scrollPane;

	public static JPanel getPanel_menu() {
		return panel_menu;
	}

	public void setPanel_menu(JPanel panel_menu) {
		Start.panel_menu = panel_menu;
	}

	public static JDesktopPane getPanel_datos() {
		return panel_datos;
	}

	public static void setPanel_datos(JDesktopPane panel_datos) {
		Start.panel_datos = panel_datos;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(0, 0, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel_datos = new JDesktopPane();
		panel_datos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_datos.setBackground(SystemColor.control);
		panel_datos.setAutoscrolls(true);
		panel_datos.setBounds(0, 82, 1010, 651);
		frame.getContentPane().add(panel_datos);

		panel_menu = new JPanel();
		panel_menu.setBounds(0, 0, 1010, 82);
		frame.getContentPane().add(panel_menu);
		panel_menu.setLayout(null);

		preLogin = new PreLogin();
		preLogin.setEnabled(true);
		preLogin.setVisible(true);
		preLogin.setBounds(0, 0, 1010, 82);
		panel_menu.add(preLogin);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 81, 1010, 600);
		preLogin.add(scrollPane);

	}
}
