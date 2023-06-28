import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ListarProveedor extends JPanel {

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
	public ListarProveedor() {
		setLayout(null);

		modeloProveedor.setModo("listar");
		String[] columnas = { "ID_proveedor", "nombre_prov", "categorías", "NIF_prov", "direccion_prov",
				"localidad_prov", "provincia_prov", "cp_prov", "pais_prov", "tlf_prov", "email_prov", "web_prov",
				"catalogo_prov", "observaciones_prov" };
		modeloProveedor.setColumnas(columnas);
		JTable tableProv = new JTable(modeloProveedor);
		tableProv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
		scrollPane_prov.setBounds(0, 0, 1010, 651);
		add(scrollPane_prov);
	}

}
