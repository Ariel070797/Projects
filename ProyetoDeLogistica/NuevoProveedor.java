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

public class NuevoProveedor extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_nom_prov, txt_cats_prov, txt_nif_prov, txt_loc_prov,
  txt_prvn_prov, txt_cp_prov, txt_pais_prov, txt_tlf_prov, txt_mail_prov,
  txt_web_prov, txt_ctlg_prov;
	private JTextArea txt_obs_prov;
	private JLabel lbl_nom_prov, lbl_cats_prov, lbl_nif_prov, lbl_dir_prov, lbl_loc_prov,
  lbl_prvn_prov, lbl_cp_prov, lbl_pais_prov, lbl_tlf_prov, lbl_mail_prov, lbl_web_prov,
  lbl_ctlg_prov, lbl_obs_prov, lbl_req, lbl_ast, lbl_ast_1, lbl_ast_2, lbl_ast_3,
  lbl_ast_4, lbl_ast_5, lbl_ast_6, lbl_ast_7, lbl_ast_8;
	private JButton btn_nuevoProveedor;
	private Cliente proveedor = new Cliente();

	/**
	 * Create the panel.
	 */
	public NuevoProveedor() {

		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);

		lbl_cats_prov = new JLabel("Categor\u00EDas");
		lbl_cats_prov.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_cats_prov.setBounds(10, 73, 74, 41);
		add(lbl_cats_prov);

		txt_nom_prov = new JTextField();
		txt_nom_prov.setBounds(122, 24, 292, 41);
		add(txt_nom_prov);
		txt_nom_prov.setColumns(10);

		lbl_nif_prov = new JLabel("NIF");
		lbl_nif_prov.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_nif_prov.setBounds(10, 124, 32, 41);
		add(lbl_nif_prov);

		lbl_dir_prov = new JLabel("Direcci\u00F3n");
		lbl_dir_prov.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_dir_prov.setBounds(10, 175, 62, 41);
		add(lbl_dir_prov);

		lbl_loc_prov = new JLabel("Localidad");
		lbl_loc_prov.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_loc_prov.setBounds(10, 226, 74, 41);
		add(lbl_loc_prov);

		lbl_prvn_prov = new JLabel("Provincia");
		lbl_prvn_prov.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_prvn_prov.setBounds(10, 277, 74, 41);
		add(lbl_prvn_prov);

		lbl_cp_prov = new JLabel("C\u00F3digo postal");
		lbl_cp_prov.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_cp_prov.setBounds(10, 328, 93, 41);
		add(lbl_cp_prov);

		lbl_pais_prov = new JLabel("Pa\u00EDs");
		lbl_pais_prov.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_pais_prov.setBounds(10, 379, 32, 41);
		add(lbl_pais_prov);

		lbl_tlf_prov = new JLabel("Tel\u00E9fono");
		lbl_tlf_prov.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_tlf_prov.setBounds(10, 430, 62, 41);
		add(lbl_tlf_prov);

		lbl_mail_prov = new JLabel("e-mail");
		lbl_mail_prov.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_mail_prov.setBounds(10, 481, 45, 41);
		add(lbl_mail_prov);

		lbl_web_prov = new JLabel("Web");
		lbl_web_prov.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_web_prov.setBounds(10, 532, 45, 41);
		add(lbl_web_prov);

		lbl_ctlg_prov = new JLabel("Cat\u00E1logo");
		lbl_ctlg_prov.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ctlg_prov.setBounds(10, 583, 62, 41);
		add(lbl_ctlg_prov);

		lbl_nom_prov = new JLabel("Nombre");
		lbl_nom_prov.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_nom_prov.setBounds(10, 22, 62, 41);
		add(lbl_nom_prov);

		lbl_obs_prov = new JLabel("Observaciones");
		lbl_obs_prov.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_obs_prov.setBounds(685, 137, 104, 39);
		add(lbl_obs_prov);

		txt_cats_prov = new JTextField();
		txt_cats_prov.setColumns(10);
		txt_cats_prov.setBounds(122, 75, 292, 41);
		add(txt_cats_prov);

		txt_nif_prov = new JTextField();
		txt_nif_prov.setColumns(10);
		txt_nif_prov.setBounds(122, 126, 292, 41);
		add(txt_nif_prov);

		txt_dir_prov = new JTextField();
		txt_dir_prov.setColumns(10);
		txt_dir_prov.setBounds(122, 177, 292, 41);
		add(txt_dir_prov);

		txt_loc_prov = new JTextField();
		txt_loc_prov.setColumns(10);
		txt_loc_prov.setBounds(122, 228, 292, 41);
		add(txt_loc_prov);

		txt_prvn_prov = new JTextField();
		txt_prvn_prov.setColumns(10);
		txt_prvn_prov.setBounds(122, 279, 292, 41);
		add(txt_prvn_prov);

		txt_cp_prov = new JTextField();
		txt_cp_prov.setColumns(10);
		txt_cp_prov.setBounds(122, 330, 292, 41);
		add(txt_cp_prov);

		txt_pais_prov = new JTextField();
		txt_pais_prov.setColumns(10);
		txt_pais_prov.setBounds(122, 381, 292, 41);
		add(txt_pais_prov);

		txt_tlf_prov = new JTextField();
		txt_tlf_prov.setColumns(10);
		txt_tlf_prov.setBounds(122, 432, 292, 41);
		add(txt_tlf_prov);

		txt_mail_prov = new JTextField();
		txt_mail_prov.setColumns(10);
		txt_mail_prov.setBounds(122, 483, 292, 41);
		add(txt_mail_prov);

		txt_web_prov = new JTextField();
		txt_web_prov.setColumns(10);
		txt_web_prov.setBounds(122, 534, 292, 41);
		add(txt_web_prov);

		txt_ctlg_prov = new JTextField();
		txt_ctlg_prov.setColumns(10);
		txt_ctlg_prov.setBounds(122, 585, 292, 41);
		add(txt_ctlg_prov);

		txt_obs_prov = new JTextArea();
		txt_obs_prov.setLineWrap(true);
		txt_obs_prov.setBounds(558, 180, 360, 321);
		add(txt_obs_prov);

		lbl_req = new JLabel("* Campos requeridos");
		lbl_req.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_req.setBounds(778, 27, 140, 31);
		add(lbl_req);

		lbl_ast = new JLabel("*");
		lbl_ast.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast.setBounds(424, 36, 62, 41);
		add(lbl_ast);

		lbl_ast_1 = new JLabel("*");
		lbl_ast_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast_1.setBounds(424, 85, 62, 41);
		add(lbl_ast_1);

		lbl_ast_2 = new JLabel("*");
		lbl_ast_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast_2.setBounds(424, 136, 62, 41);
		add(lbl_ast_2);

		lbl_ast_3 = new JLabel("*");
		lbl_ast_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast_3.setBounds(424, 187, 62, 41);
		add(lbl_ast_3);

		lbl_ast_4 = new JLabel("*");
		lbl_ast_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast_4.setBounds(424, 238, 62, 41);
		add(lbl_ast_4);

		lbl_ast_5 = new JLabel("*");
		lbl_ast_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast_5.setBounds(424, 289, 62, 41);
		add(lbl_ast_5);

		lbl_ast_6 = new JLabel("*");
		lbl_ast_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast_6.setBounds(424, 340, 62, 41);
		add(lbl_ast_6);

		lbl_ast_7 = new JLabel("*");
		lbl_ast_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast_7.setBounds(424, 391, 62, 41);
		add(lbl_ast_7);

		lbl_ast_8 = new JLabel("*");
		lbl_ast_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast_8.setBounds(424, 442, 62, 41);
		add(lbl_ast_8);

		btn_nuevoProveedor = new JButton("Registrar");
		btn_nuevoProveedor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_nuevoProveedor.setBounds(655, 544, 171, 41);
		add(btn_nuevoProveedor);

		btn_nuevoProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (checkCamposProveedor()) {
					try {

						proveedor.setNombre(txt_nom_prov.getText());
						proveedor.setCategorias(txt_cats_prov.getText());
						proveedor.setNif(txt_nif_prov.getText());
						proveedor.setDireccion(txt_dir_prov.getText());
						proveedor.setLocalidad(txt_loc_prov.getText());
						proveedor.setProvincia(txt_prvn_prov.getText());
						proveedor.setCodigoPostal(txt_cp_prov.getText());
						proveedor.setPais(txt_pais_prov.getText());
						proveedor.setTelefono(Integer.parseInt(txt_tlf_prov.getText()));
						proveedor.setEmail(txt_mail_prov.getText());
						proveedor.setWeb(txt_web_prov.getText());
						proveedor.setCatalogo(txt_ctlg_prov.getText());
						proveedor.setObservaciones(txt_obs_prov.getText());

						proveedor.registrarProveedor(proveedor.getNombre(), proveedor.getCategorias(),
								proveedor.getNif(), proveedor.getDireccion(), proveedor.getLocalidad(),
								proveedor.getProvincia(), proveedor.getCodigoPostal(), proveedor.getPais(),
								proveedor.getTelefono(), proveedor.getEmail(), proveedor.getWeb(),
								proveedor.getCatalogo(), proveedor.getObservaciones());
						JOptionPane.showMessageDialog(null, "Registro OK");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Error: faltan datos o datos incorrectos");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Error: faltan datos o datos incorrectos");
				}
			}
		});
	}

	public boolean checkCamposProveedor() {

		if ((!txt_nom_prov.getText().isEmpty()) && (!txt_nom_prov.getText().isBlank())
				&& (!txt_nom_prov.getText().equalsIgnoreCase("NULL")) && !(txt_cats_prov.getText().isEmpty())
				&& (!txt_cats_prov.getText().isBlank()) && (!txt_cats_prov.getText().equalsIgnoreCase("NULL"))
				&& !(txt_nif_prov.getText().isEmpty()) && (!txt_nif_prov.getText().isBlank())
				&& (!txt_nif_prov.getText().equalsIgnoreCase("NULL")) && !(txt_dir_prov.getText().isEmpty())
				&& (!txt_dir_prov.getText().isBlank()) && (!txt_dir_prov.getText().equalsIgnoreCase("NULL"))
				&& !(txt_loc_prov.getText().isEmpty()) && (!txt_loc_prov.getText().isBlank())
				&& (!txt_loc_prov.getText().equalsIgnoreCase("NULL")) && !(txt_prvn_prov.getText().isEmpty())
				&& (!txt_prvn_prov.getText().isBlank()) && (!txt_prvn_prov.getText().equalsIgnoreCase("NULL"))
				&& !(txt_cp_prov.getText().isEmpty()) && (!txt_cp_prov.getText().isBlank())
				&& (!txt_cp_prov.getText().equalsIgnoreCase("NULL")) && !(txt_pais_prov.getText().isEmpty())
				&& (!txt_pais_prov.getText().isBlank()) && (!txt_pais_prov.getText().equalsIgnoreCase("NULL"))
				&& !(txt_tlf_prov.getText().isEmpty()) && (!txt_tlf_prov.getText().isBlank())
				&& (!txt_tlf_prov.getText().equalsIgnoreCase("NULL"))) {
			return true;
		} else {
			return false;
		}
	}
}
