import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ListarDevolucionesProveedor extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane_devProv;
	private ModeloTabla modeloDevProv = new ModeloTabla();
	private DevolucionProveedor devProv = new DevolucionProveedor();
	private ArrayList<DevolucionProveedor> listaDevProv = new ArrayList<DevolucionProveedor>();

	/**
	 * Create the panel.
	 */
	public ListarDevolucionesProveedor() {
		setLayout(null);

		modeloDevProv.setModo("listar");
		String[] columnas = { "ID_devolucion_prov", "ID_peticion", "ID_producto", "ID_proveedor",
				"cantidad_devuelta_prov", "observaciones_dev_prov" };
		modeloDevProv.setColumnas(columnas);
		JTable tableDevProv = new JTable(modeloDevProv);
		tableDevProv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listaDevProv = devProv.leerDevoluciones("SELECT * FROM proveedores_devoluciones");

		modeloDevProv.setRegistros(listaDevProv.size(), 6);

		for (int i = 0; i < listaDevProv.size(); i++) {
			modeloDevProv.setValueAt((listaDevProv.get(i)).getId_dev_prov(), i, 0);
			modeloDevProv.setValueAt((listaDevProv.get(i)).getId_pet(), i, 1);
			modeloDevProv.setValueAt((listaDevProv.get(i)).getId_prod(), i, 2);
			modeloDevProv.setValueAt((listaDevProv.get(i)).getId_prov(), i, 3);
			modeloDevProv.setValueAt((listaDevProv.get(i)).getCant_dev_prov(), i, 4);
			modeloDevProv.setValueAt((listaDevProv.get(i)).getObs_dev_prov(), i, 5);

		}

		tableDevProv.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_devProv = new JScrollPane(tableDevProv);
		scrollPane_devProv.setBounds(0, 0, 1010, 651);
		add(scrollPane_devProv);
	}

}
