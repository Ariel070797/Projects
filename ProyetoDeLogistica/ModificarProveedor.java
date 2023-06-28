import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class ModificarProveedor extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane_prov;
	private ModeloTabla modeloProveedor = new ModeloTabla();
	private Cliente proveedor = new Cliente();
	private ArrayList<Cliente> listaProveedores = new ArrayList<Cliente>();

	/**
	 * Create the panel.
	 */
	public ModificarProveedor() {
		setLayout(null);

		// Carga/actualiza los proveedores cuyas categorías coincidan con la del
		// producto seleccionado

		modeloProveedor.setModo("listar");
		String[] columnas = { "ID_proveedor", "nombre_prov", "categorías", "NIF_prov", "direccion_prov",
				"localidad_prov", "provincia_prov", "cp_prov", "pais_prov", "tlf_prov", "email_prov", "web_prov",
				"catalogo_prov", "observaciones_prov" };
		modeloProveedor.setColumnas(columnas);
		JTable tableProv = new JTable(modeloProveedor);
		tableProv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modeloProveedor.setModo("modificar");

		listaProveedores = proveedor.leerProveedores("SELECT * FROM proveedores");

		modeloProveedor.setRegistros(listaProveedores.size(), 14);

		for (int i = 0; i < listaProveedores.size(); i++) {
			modeloProveedor.setValueAt((listaProveedores.get(i)).getId(), i, 0);
			modeloProveedor.setValueAt((listaProveedores.get(i)).getNombre(), i, 1);
			modeloProveedor.setValueAt((listaProveedores.get(i)).getCategorias(), i, 2);
			modeloProveedor.setValueAt((listaProveedores.get(i)).getNif(), i, 3);
			modeloProveedor.setValueAt((listaProveedores.get(i)).getDireccion(), i, 4);
			modeloProveedor.setValueAt((listaProveedores.get(i)).getLocalidad(), i, 5);
			modeloProveedor.setValueAt((listaProveedores.get(i)).getProvincia(), i, 6);
			modeloProveedor.setValueAt((listaProveedores.get(i)).getCodigoPostal(), i, 7);
			modeloProveedor.setValueAt((listaProveedores.get(i)).getPais(), i, 8);
			modeloProveedor.setValueAt((listaProveedores.get(i)).getTelefono(), i, 9);
			modeloProveedor.setValueAt((listaProveedores.get(i)).getEmail(), i, 10);
			modeloProveedor.setValueAt((listaProveedores.get(i)).getWeb(), i, 11);
			modeloProveedor.setValueAt((listaProveedores.get(i)).getCatalogo(), i, 12);
			modeloProveedor.setValueAt((listaProveedores.get(i)).getObservaciones(), i, 13);
		}

		tableProv.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_prov = new JScrollPane(tableProv);
		scrollPane_prov.setBounds(0, 0, 1010, 600);
		add(scrollPane_prov);

		JPanel panel_modificarProv = new JPanel();
		panel_modificarProv.setBounds(0, 0, 1010, 600);
		add(panel_modificarProv);
		panel_modificarProv.setBounds(0, 600, 1010, 51);
		add(panel_modificarProv);

		JButton btn_modificarProv = new JButton("Modificar");
		btn_modificarProv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_modificarProv.setBounds(65, 602, 85, 38);
		panel_modificarProv.add(btn_modificarProv);

		btn_modificarProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int fila = tableProv.getSelectedRow();

					int id = Integer.parseInt(tableProv.getValueAt(fila, 0).toString());
					String nom = tableProv.getValueAt(fila, 1).toString();
					String cat = tableProv.getValueAt(fila, 2).toString();
					String nif = tableProv.getValueAt(fila, 3).toString();
					String direc = tableProv.getValueAt(fila, 4).toString();
					String loca = tableProv.getValueAt(fila, 5).toString();
					String prov = tableProv.getValueAt(fila, 6).toString();
					String cp = tableProv.getValueAt(fila, 7).toString();
					String pais = tableProv.getValueAt(fila, 8).toString();
					int telf = (int) tableProv.getValueAt(fila, 9);
					String email = tableProv.getValueAt(fila, 10).toString();
					String web = tableProv.getValueAt(fila, 11).toString();
					String catalogo = tableProv.getValueAt(fila, 12).toString();
					String obser = tableProv.getValueAt(fila, 13).toString();

					proveedor.modificarProveedor(id, nom, cat, nif, direc, loca, prov, cp, pais, telf, email, web,
							catalogo, obser);
					JOptionPane.showMessageDialog(null, "OK! Proveedor actualizado");

				}

				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error SQL");

				}

			}
		});

	}

}
