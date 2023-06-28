import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_usuario;
	private JPasswordField txt_pass;
	//private Connection conexion;
	private JButton btn_login;
	private BBDD baseDatos=new BBDD();

	public JButton getBtn_login() {
		return btn_login;
	}

	public void setBtn_login(JButton btn_login) {
		this.btn_login = btn_login;
	}

	public JTextField getTxt_usuario() {
		return txt_usuario;
	}

	public void setTxt_usuario(JTextField txt_usuario) {
		this.txt_usuario = txt_usuario;
	}

	public JTextField getTxt_pass() {
		return txt_pass;
	}

	public void setTxt_pass(JPasswordField txt_pass) {
		this.txt_pass = txt_pass;
	}


	/**
	 * Create the panel.
	 */
	public Login() {
		setLayout(null);

		txt_usuario = new JTextField();
		txt_usuario.setColumns(10);
		txt_usuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txt_usuario.setBounds(90, 20, 292, 41);
		add(txt_usuario);

		txt_pass = new JPasswordField();
		txt_pass.setColumns(10);
		txt_pass.setFont(new Font("Tahoma", Font.PLAIN, 20));
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

		btn_login = new JButton("Login");

		btn_login.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_login.setBounds(817, 20, 171, 41);
		add(btn_login);

		getBtn_login().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usuario=txt_usuario.getText();
				String clave=new String(txt_pass.getPassword());
				
				if (baseDatos.login(usuario, clave))

				{
					baseDatos.setUsuario(usuario);
					baseDatos.setPassword(clave);
					// Si el login es exitoso, cierra login y carga menú
										
					setEnabled(false);
					setVisible(false);
					remove(0);

					Menu menu = new Menu();
					menu.setEnabled(true);
					menu.setVisible(true);
					menu.setBounds(0, 0, 1010, 82);
					Start.getPanel_menu().add(menu);

				} else {
					
					// Si el login falla, cierra login y vuelve a cargar PreLogin

					setEnabled(false);
					setVisible(false);
					Start.getPanel_menu().remove(0);

					PreLogin preLogin = new PreLogin();
					preLogin.setEnabled(true);
					preLogin.setVisible(true);
					preLogin.setBounds(0, 0, 1010, 82);
					Start.getPanel_menu().add(preLogin);

				}

			}
		});
	}
}
