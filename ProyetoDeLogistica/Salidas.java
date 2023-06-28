import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class Salidas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane_prov;
	private ModeloTabla modeloSalidas = new ModeloTabla();
	private Peticion salidas = new Peticion();
	private ArrayList<Peticion> listaSalidas = new ArrayList<Peticion>();
	
	/**
	 * Create the panel.
	 */
	public Salidas() {
		setLayout(null);

		modeloSalidas.setModo("listar");
		String[] columnas = { "ID_peticion", "ID_producto", "ID_proveedor", "cantidad_pet", "fecha_pedido",
				"fecha_llegada", "precio_pet", "envio_pet", "IVA_compra", "precio_total", "observaciones_pet"};
		modeloSalidas.setColumnas(columnas);
		JTable tableProv = new JTable(modeloSalidas);
		tableProv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listaSalidas = salidas.leerPeticiones("SELECT * FROM proveedores_peticiones WHERE proveedores_peticiones.fecha_pedido < proveedores_peticiones.fecha_llegada");

		modeloSalidas.setRegistros(listaSalidas.size(), 11);

		for (int i = 0; i < listaSalidas.size(); i++) {
			modeloSalidas.setValueAt((listaSalidas.get(i)).getIdPet(), i, 0);
			modeloSalidas.setValueAt((listaSalidas.get(i)).getIdProd(), i, 1);
			modeloSalidas.setValueAt((listaSalidas.get(i)).getIdProv(), i, 2);
			modeloSalidas.setValueAt((listaSalidas.get(i)).getCantidad(), i, 3);
			modeloSalidas.setValueAt((listaSalidas.get(i)).getFpedido(), i, 4);
			modeloSalidas.setValueAt((listaSalidas.get(i)).getFllegada(), i, 5);
			modeloSalidas.setValueAt((listaSalidas.get(i)).getPrecioProd(), i, 6);
			modeloSalidas.setValueAt((listaSalidas.get(i)).getPrecioEnvio(), i, 7);
			modeloSalidas.setValueAt((listaSalidas.get(i)).getIva(), i, 8);
			modeloSalidas.setValueAt((listaSalidas.get(i)).getPrecioTpet(), i, 9);
			modeloSalidas.setValueAt((listaSalidas.get(i)).getObservaciones(), i, 10);

		}
		

		tableProv.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_prov = new JScrollPane(tableProv);
		scrollPane_prov.setBounds(0, 0, 1010, 651);
		add(scrollPane_prov);
	}

}
