import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EliminarProveedor extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private ModeloTabla modeloProveedor = new ModeloTabla();
	private Cliente proveedor = new Cliente();
	private ArrayList<Cliente> listaProveedores = new ArrayList<Cliente>();
	JButton btn_eliminarProv;
	JTextField txt_eliminarProv;
	JLabel lbl_eliminarProv;

	/**
	 * Create the panel.
	 */
	public EliminarProveedor() {
		setLayout(null);

		modeloProveedor.setModo("listar");
		String[] columnas = { "ID_proveedor", "nombre_prov", "categorías", "NIF_prov", "direccion_prov",
				"localidad_prov", "provincia_prov", "cp_prov", "pais_prov", "tlf_prov", "email_prov", "web_prov",
				"catalogo_prov", "observaciones_prov" };
		modeloProveedor.setColumnas(columnas);
		JTable tableProv = new JTable(modeloProveedor);
		tableProv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listaProveedores = proveedor.leerProveedores("SELECT * FROM proveedores LEFT JOIN proveedores_peticiones "
				+ "ON proveedores.ID_proveedor=proveedores_peticiones.ID_proveedor "
				+ "WHERE proveedores_peticiones.ID_proveedor IS NULL");

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

		scrollPane = new JScrollPane(tableProv);
		scrollPane.setBounds(0, 0, 1010, 600);
		add(scrollPane);

		JPanel panel_eliminarProv = new JPanel();
		panel_eliminarProv.setBounds(0, 0, 1010, 600);
		add(panel_eliminarProv);
		panel_eliminarProv.setBounds(0, 600, 1010, 51);
		add(panel_eliminarProv);

		JLabel lbl_eliminarProv = new JLabel("ID");
		lbl_eliminarProv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_eliminarProv.setBounds(20, 602, 24, 38);
		panel_eliminarProv.add(lbl_eliminarProv);

		txt_eliminarProv = new JTextField();
		txt_eliminarProv.setBounds(54, 615, 49, 26);
		panel_eliminarProv.add(txt_eliminarProv);
		txt_eliminarProv.setColumns(5);
		txt_eliminarProv.setEditable(false);

		JButton btn_eliminarProv = new JButton("Eliminar");
		btn_eliminarProv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_eliminarProv.setBounds(131, 602, 85, 38);
		panel_eliminarProv.add(btn_eliminarProv);

		btn_eliminarProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = 0;

				try {
					id = Integer.parseInt(txt_eliminarProv.getText());
				}

				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error: ID debe ser numérico");

				}

				if (proveedor.checkID_proveedor(id) && (proveedor.eliminarProveedor(id))) {
					JOptionPane.showMessageDialog(null, "OK! Proveedor eliminado");
					Menu.getMenu_stock().setSelectedItem("");
					Menu.getMenu_stock().setSelectedItem("PROVEEDORES->Eliminar");
				}

			}
		});

		tableProv.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {

				if (tableProv.getSelectedRowCount() <= 0) {

				} else {

					// Actualiza el proveedor a eliminar con el seleccionado

					txt_eliminarProv.setText((tableProv.getValueAt(tableProv.getSelectedRow(), 0).toString()));

				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}
}
