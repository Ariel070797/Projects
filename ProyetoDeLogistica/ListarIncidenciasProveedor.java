import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ListarIncidenciasProveedor extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane_incdProv;
	private ModeloTabla modeloIncdProv = new ModeloTabla();
	private IncidenciaProveedor incdProv = new IncidenciaProveedor();
	private ArrayList<IncidenciaProveedor> listaIncdProv = new ArrayList<IncidenciaProveedor>();

	/**
	 * Create the panel.
	 */
	public ListarIncidenciasProveedor() {
		setLayout(null);

		modeloIncdProv.setModo("listar");
		String[] columnas = { "ID_incidencia_prov", "ID_peticion", "ID_producto", "ID_proveedor", "cantidad_incd",
				"incidencias_prov", "devolver" };
		modeloIncdProv.setColumnas(columnas);
		JTable tableIncdProv = new JTable(modeloIncdProv);
		tableIncdProv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listaIncdProv = incdProv.leerIncidencias("SELECT * FROM proveedores_incidencias");

		modeloIncdProv.setRegistros(listaIncdProv.size(), 7);

		for (int i = 0; i < listaIncdProv.size(); i++) {
			modeloIncdProv.setValueAt((listaIncdProv.get(i)).getId_incd_prov(), i, 0);
			modeloIncdProv.setValueAt((listaIncdProv.get(i)).getId_pet(), i, 1);
			modeloIncdProv.setValueAt((listaIncdProv.get(i)).getId_prod(), i, 2);
			modeloIncdProv.setValueAt((listaIncdProv.get(i)).getId_prov(), i, 3);
			modeloIncdProv.setValueAt((listaIncdProv.get(i)).getCant_incd(), i, 4);
			modeloIncdProv.setValueAt((listaIncdProv.get(i)).getIncidencia_prov(), i, 5);
			modeloIncdProv.setValueAt((listaIncdProv.get(i)).isDevolver(), i, 6);

		}

		tableIncdProv.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_incdProv = new JScrollPane(tableIncdProv);
		scrollPane_incdProv.setBounds(0, 0, 1010, 651);
		add(scrollPane_incdProv);
	}

}
