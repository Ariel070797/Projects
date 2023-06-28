import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PreLogin extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn_nuevoUsuario;
	private JButton btn_login;

	/**
	 * Create the panel.
	 */
	public PreLogin() {
		setLayout(null);

		// Botón que da acceso al registro de nuevo usuario

		btn_nuevoUsuario = new JButton("Nuevo usuario");
		btn_nuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_nuevoUsuario.setBounds(535, 20, 171, 41);
		add(btn_nuevoUsuario);

		btn_nuevoUsuario.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setEnabled(false);
				setVisible(false);
				Start.getPanel_menu().remove(0);

				// Cargará el módulo de Nuevo Usuario
				NuevoUsuario nuevoUsuario = new NuevoUsuario();
				nuevoUsuario.setEnabled(true);
				nuevoUsuario.setVisible(true);
				nuevoUsuario.setBounds(0, 0, 1010, 82);
				Start.getPanel_menu().add(nuevoUsuario);
			}
		});

		// Botón que da acceso al login

		btn_login = new JButton("Login");
		btn_login.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_login.setBounds(245, 20, 171, 41);
		add(btn_login);

		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setEnabled(false);
				setVisible(false);
				Start.getPanel_menu().remove(0);

				// Cargará el módulo de Login
				Login login = new Login();
				login.setEnabled(true);
				login.setVisible(true);
				login.setBounds(0, 0, 1010, 82);
				Start.getPanel_menu().add(login);
			}
		});

	}

	public JButton getBtn_nuevoUsuario() {
		return btn_nuevoUsuario;
	}

	public void setBtn_nuevoUsuario(JButton btn_nuevoUsuario) {
		this.btn_nuevoUsuario = btn_nuevoUsuario;
	}

	public JButton getBtn_login() {
		return btn_login;
	}

	public void setBtn_login(JButton btn_login) {
		this.btn_login = btn_login;
	}

}
