import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevoUsuario extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_usuario;
	private JPasswordField txt_pass;
	private Connection conexion;
	private JButton btn_nuevoUsuario;

	public JTextField getTxt_usuario() {
		return txt_usuario;
	}

	public void setTxt_usuario(JTextField txt_usuario) {
		this.txt_usuario = txt_usuario;
	}

	public JPasswordField getTxt_pass() {
		return txt_pass;
	}

	public void setTxt_pass(JPasswordField txt_pass) {
		this.txt_pass = txt_pass;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public JButton getBtn_nuevoUsuario() {
		return btn_nuevoUsuario;
	}

	public void setBtn_nuevoUsuario(JButton btn_nuevoUsuario) {
		this.btn_nuevoUsuario = btn_nuevoUsuario;
	}

	/**
	 * Create the panel.
	 */
	public NuevoUsuario() {
		setLayout(null);

		txt_usuario = new JTextField();
		txt_usuario.setColumns(10);
		txt_usuario.setBounds(90, 20, 292, 41);
		add(txt_usuario);

		txt_pass = new JPasswordField();
		txt_pass.setColumns(10);
		txt_pass.setBounds(492, 20, 292, 41);
		add(txt_pass);

		JLabel lbl_usuario = new JLabel("Usuario");
		lbl_usuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_usuario.setBounds(33, 18, 47, 41);
		add(lbl_usuario);

		JLabel lbl_pass = new JLabel("Clave");
		lbl_pass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_pass.setBounds(441, 18, 41, 41);
		add(lbl_pass);

		btn_nuevoUsuario = new JButton("Nuevo usuario");

		btn_nuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_nuevoUsuario.setBounds(817, 20, 171, 41);
		add(btn_nuevoUsuario);

		btn_nuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String clave = new String(txt_pass.getPassword());

				nuevoUsuario(txt_usuario.getText(), clave);

				setEnabled(false);
				setVisible(false);
				Start.getPanel_menu().remove(0);

				// Cuando completa el registro, vuelve al PreLogin
				PreLogin preLogin = new PreLogin();
				preLogin.setEnabled(true);
				preLogin.setVisible(true);
				preLogin.setBounds(0, 0, 1010, 82);
				Start.getPanel_menu().add(preLogin);

			}
		});
	}

	public boolean nuevoUsuario(String u, String p) { // Login

		try {

			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());

			// Primer paso es crear el usuario con su contraseña
			PreparedStatement ps = conexion.prepareStatement("CREATE USER ?@'%' IDENTIFIED BY ?");
			ps.setString(1, u);
			ps.setString(2, p);
			ps.execute();
			JOptionPane.showMessageDialog(null, "Creación de usuario OK");

			// Después habrá que otorgarle todos los privilegios en la base de datos de
			// Plain Gest
			ps = conexion.prepareStatement("GRANT ALL PRIVILEGES ON plaingest.* TO ?@'%' WITH GRANT OPTION");
			ps.setString(1, u);
			ps.execute();
			conexion.close();
			JOptionPane.showMessageDialog(null, "Privilegios a usuario OK");

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error al crear usuario");
		}
		return false;
	}

}
