import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

public class NuevoCliente extends JPanel {
	/**
	 * 
	 */
  
	private static final long serialVersionUID = 1L;
	private JTextField txt_nom_cli, txt_ape1, txt_ape2, txt_nif_cli, txt_dir_cli,
  txt_loc_cli, txt_prov_cli, txt_cp_cli, txt_pais_cli, txt_tlf_cli, txt_email_cli, txt_web_cli;
	private JTextArea txt_obs_cli;
	private JLabel lbl_nom_cli, lbl_ape1, lbl_ape2, lbl_nif_cli, lbl_dir_cli, lbl_loc_cli,
  lbl_prov_cli, lbl_cp_cli, lbl_pais_cli, lbl_tlf_cli, lbl_email_cli, lbl_web_cli,
  lbl_obs_cli, lbl_req, lbl_ast, lbl_ast_1, lbl_ast_2, lbl_ast_3, lbl_ast_4, lbl_ast_5,
  lbl_ast_6, lbl_ast_7, lbl_ast_8;
	private JButton btn_nuevoCliente;
	private Pedido cliente = new Pedido();

	/**
	 * Create the panel.
	 */
	public NuevoCliente() {

		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);

		lbl_ape1 = new JLabel("Apellido 1");
		lbl_ape1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ape1.setBounds(10, 73, 74, 41);
		add(lbl_ape1);

		txt_nom_cli = new JTextField();
		txt_nom_cli.setBounds(122, 24, 292, 41);
		add(txt_nom_cli);
		txt_nom_cli.setColumns(10);

		lbl_ape2 = new JLabel("Apellido 2");
		lbl_ape2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ape2.setBounds(10, 124, 74, 41);
		add(lbl_ape2);

		lbl_nif_cli = new JLabel("NIF");
		lbl_nif_cli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_nif_cli.setBounds(10, 175, 62, 41);
		add(lbl_nif_cli);

		lbl_dir_cli = new JLabel("Direcci\u00F3n");
		lbl_dir_cli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_dir_cli.setBounds(10, 226, 74, 41);
		add(lbl_dir_cli);

		lbl_loc_cli = new JLabel("Localidad");
		lbl_loc_cli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_loc_cli.setBounds(10, 277, 74, 41);
		add(lbl_loc_cli);

		lbl_prov_cli = new JLabel("Provincia");
		lbl_prov_cli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_prov_cli.setBounds(10, 328, 93, 41);
		add(lbl_prov_cli);

		lbl_cp_cli = new JLabel("C\u00F3digo postal");
		lbl_cp_cli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_cp_cli.setBounds(10, 379, 93, 41);
		add(lbl_cp_cli);

		lbl_pais_cli = new JLabel("Pa\u00EDs");
		lbl_pais_cli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_pais_cli.setBounds(10, 430, 62, 41);
		add(lbl_pais_cli);

		lbl_tlf_cli = new JLabel("Tel\u00E9fono");
		lbl_tlf_cli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_tlf_cli.setBounds(10, 481, 74, 41);
		add(lbl_tlf_cli);

		lbl_email_cli = new JLabel("e-mail");
		lbl_email_cli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_email_cli.setBounds(10, 532, 45, 41);
		add(lbl_email_cli);

		lbl_web_cli = new JLabel("Web");
		lbl_web_cli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_web_cli.setBounds(10, 583, 62, 41);
		add(lbl_web_cli);

		lbl_nom_cli = new JLabel("Nombre");
		lbl_nom_cli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_nom_cli.setBounds(10, 22, 62, 41);
		add(lbl_nom_cli);

		lbl_obs_cli = new JLabel("Observaciones");
		lbl_obs_cli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_obs_cli.setBounds(685, 137, 104, 39);
		add(lbl_obs_cli);

		txt_ape1 = new JTextField();
		txt_ape1.setColumns(10);
		txt_ape1.setBounds(122, 75, 292, 41);
		add(txt_ape1);

		txt_ape2 = new JTextField();
		txt_ape2.setColumns(10);
		txt_ape2.setBounds(122, 126, 292, 41);
		add(txt_ape2);

		txt_nif_cli = new JTextField();
		txt_nif_cli.setColumns(10);
		txt_nif_cli.setBounds(122, 177, 292, 41);
		add(txt_nif_cli);

		txt_dir_cli = new JTextField();
		txt_dir_cli.setColumns(10);
		txt_dir_cli.setBounds(122, 228, 292, 41);
		add(txt_dir_cli);

		txt_loc_cli = new JTextField();
		txt_loc_cli.setColumns(10);
		txt_loc_cli.setBounds(122, 279, 292, 41);
		add(txt_loc_cli);

		txt_prov_cli = new JTextField();
		txt_prov_cli.setColumns(10);
		txt_prov_cli.setBounds(122, 330, 292, 41);
		add(txt_prov_cli);

		txt_cp_cli = new JTextField();
		txt_cp_cli.setColumns(10);
		txt_cp_cli.setBounds(122, 381, 292, 41);
		add(txt_cp_cli);

		txt_pais_cli = new JTextField();
		txt_pais_cli.setColumns(10);
		txt_pais_cli.setBounds(122, 432, 292, 41);
		add(txt_pais_cli);

		txt_tlf_cli = new JTextField();
		txt_tlf_cli.setColumns(10);
		txt_tlf_cli.setBounds(122, 483, 292, 41);
		add(txt_tlf_cli);

		txt_email_cli = new JTextField();
		txt_email_cli.setColumns(10);
		txt_email_cli.setBounds(122, 534, 292, 41);
		add(txt_email_cli);

		txt_web_cli = new JTextField();
		txt_web_cli.setColumns(10);
		txt_web_cli.setBounds(122, 585, 292, 41);
		add(txt_web_cli);

		txt_obs_cli = new JTextArea();
		txt_obs_cli.setLineWrap(true);
		txt_obs_cli.setBounds(558, 180, 360, 321);
		add(txt_obs_cli);

		lbl_req = new JLabel("* Campos requeridos");
		lbl_req.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_req.setBounds(778, 27, 140, 31);
		add(lbl_req);

		lbl_ast = new JLabel("*");
		lbl_ast.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast.setBounds(424, 22, 62, 41);
		add(lbl_ast);

		lbl_ast_1 = new JLabel("*");
		lbl_ast_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast_1.setBounds(424, 73, 62, 41);
		add(lbl_ast_1);

		lbl_ast_2 = new JLabel("*");
		lbl_ast_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast_2.setBounds(424, 124, 62, 41);
		add(lbl_ast_2);

		lbl_ast_3 = new JLabel("*");
		lbl_ast_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast_3.setBounds(424, 175, 62, 41);
		add(lbl_ast_3);

		lbl_ast_4 = new JLabel("*");
		lbl_ast_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast_4.setBounds(424, 226, 62, 41);
		add(lbl_ast_4);

		lbl_ast_5 = new JLabel("*");
		lbl_ast_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast_5.setBounds(424, 277, 62, 41);
		add(lbl_ast_5);

		lbl_ast_6 = new JLabel("*");
		lbl_ast_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast_6.setBounds(424, 328, 62, 41);
		add(lbl_ast_6);

		lbl_ast_7 = new JLabel("*");
		lbl_ast_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast_7.setBounds(424, 379, 62, 41);
		add(lbl_ast_7);

		lbl_ast_8 = new JLabel("*");
		lbl_ast_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast_8.setBounds(424, 430, 62, 41);
		add(lbl_ast_8);

		btn_nuevoCliente = new JButton("Registrar");
		btn_nuevoCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_nuevoCliente.setBounds(655, 544, 171, 41);
		add(btn_nuevoCliente);

		JLabel lbl_ast_9 = new JLabel("*");
		lbl_ast_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast_9.setBounds(424, 481, 62, 41);
		add(lbl_ast_9);

		btn_nuevoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (checkCamposCliente()) {
					try {

						cliente.setNombre(txt_nom_cli.getText());
						cliente.setApellido1(txt_ape1.getText());
						cliente.setApellido2(txt_ape2.getText());
						cliente.setNif(txt_nif_cli.getText());
						cliente.setDireccion(txt_dir_cli.getText());
						cliente.setLocalidad(txt_loc_cli.getText());
						cliente.setProvincia(txt_prov_cli.getText());
						cliente.setCodigoPostal(txt_cp_cli.getText());
						cliente.setPais(txt_pais_cli.getText());
						cliente.setTelefono(Integer.parseInt(txt_tlf_cli.getText()));
						cliente.setEmail(txt_email_cli.getText());
						cliente.setWeb(txt_web_cli.getText());
						cliente.setObservaciones(txt_obs_cli.getText());

						cliente.registrarCliente(cliente.getNombre(), cliente.getApellido1(), cliente.getApellido2(),
								cliente.getNif(), cliente.getDireccion(), cliente.getLocalidad(),
								cliente.getProvincia(), cliente.getCodigoPostal(), cliente.getPais(),
								cliente.getTelefono(), cliente.getEmail(), cliente.getWeb(),
								cliente.getObservaciones());
						JOptionPane.showMessageDialog(null, "Registro OK");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Error: faltan datos o datos incorrectos:" + '\n' + ex);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Error: faltan datos o datos incorrectos");
				}
			}
		});
	}

	public boolean checkCamposCliente() {

		if ((!txt_nom_cli.getText().isEmpty()) && (!txt_nom_cli.getText().isBlank())
				&& (!txt_nom_cli.getText().equalsIgnoreCase("NULL")) && !(txt_ape1.getText().isEmpty())
				&& (!txt_ape1.getText().isBlank()) && (!txt_ape1.getText().equalsIgnoreCase("NULL"))
				&& !(txt_ape2.getText().isEmpty()) && (!txt_ape2.getText().isBlank())
				&& (!txt_ape2.getText().equalsIgnoreCase("NULL")) && !(txt_nif_cli.getText().isEmpty())
				&& (!txt_nif_cli.getText().isBlank()) && (!txt_nif_cli.getText().equalsIgnoreCase("NULL"))
				&& !(txt_dir_cli.getText().isEmpty()) && (!txt_dir_cli.getText().isBlank())
				&& (!txt_dir_cli.getText().equalsIgnoreCase("NULL")) && !(txt_loc_cli.getText().isEmpty())
				&& (!txt_loc_cli.getText().isBlank()) && (!txt_loc_cli.getText().equalsIgnoreCase("NULL"))
				&& !(txt_prov_cli.getText().isEmpty()) && (!txt_prov_cli.getText().isBlank())
				&& (!txt_prov_cli.getText().equalsIgnoreCase("NULL")) && !(txt_cp_cli.getText().isEmpty())
				&& (!txt_cp_cli.getText().isBlank()) && (!txt_cp_cli.getText().equalsIgnoreCase("NULL"))
				&& !(txt_pais_cli.getText().isEmpty()) && (!txt_pais_cli.getText().isBlank())
				&& (!txt_pais_cli.getText().equalsIgnoreCase("NULL") && !(txt_tlf_cli.getText().isEmpty())
						&& (!txt_tlf_cli.getText().isBlank()) && (!txt_tlf_cli.getText().equalsIgnoreCase("NULL")))) {
			return true;
		} else {
			return false;
		}
	}
}
