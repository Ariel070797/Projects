import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class Llegadas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane_prov;
	private ModeloTabla modeloLlegadas = new ModeloTabla();
	private Peticion llegadas = new Peticion();
	private ArrayList<Peticion> listaLlegadas = new ArrayList<Peticion>();

	/**
	 * Create the panel.
	 */
	public Llegadas() {
		setLayout(null);

		modeloLlegadas.setModo("listar");
		String[] columnas = { "ID_peticion", "ID_producto", "ID_proveedor", "cantidad_pet", "fecha_pedido",
				"fecha_llegada", "precio_pet", "envio_pet", "IVA_compra", "precio_total", "observaciones_pet"};
		modeloLlegadas.setColumnas(columnas);
		JTable tableProv = new JTable(modeloLlegadas);
		tableProv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listaLlegadas = llegadas.leerPeticiones("SELECT * FROM proveedores_peticiones WHERE proveedores_peticiones.fecha_pedido >= proveedores_peticiones.fecha_llegada");

		modeloLlegadas.setRegistros(listaLlegadas.size(), 11);

		for (int i = 0; i < listaLlegadas.size(); i++) {
			modeloLlegadas.setValueAt((listaLlegadas.get(i)).getIdPet(), i, 0);
			modeloLlegadas.setValueAt((listaLlegadas.get(i)).getIdProd(), i, 1);
			modeloLlegadas.setValueAt((listaLlegadas.get(i)).getIdProv(), i, 2);
			modeloLlegadas.setValueAt((listaLlegadas.get(i)).getCantidad(), i, 3);
			modeloLlegadas.setValueAt((listaLlegadas.get(i)).getFpedido(), i, 4);
			modeloLlegadas.setValueAt((listaLlegadas.get(i)).getFllegada(), i, 5);
			modeloLlegadas.setValueAt((listaLlegadas.get(i)).getPrecioProd(), i, 6);
			modeloLlegadas.setValueAt((listaLlegadas.get(i)).getPrecioEnvio(), i, 7);
			modeloLlegadas.setValueAt((listaLlegadas.get(i)).getIva(), i, 8);
			modeloLlegadas.setValueAt((listaLlegadas.get(i)).getPrecioTpet(), i, 9);
			modeloLlegadas.setValueAt((listaLlegadas.get(i)).getObservaciones(), i, 10);

		}

		tableProv.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_prov = new JScrollPane(tableProv);
		scrollPane_prov.setBounds(0, 0, 1010, 651);
		add(scrollPane_prov);
	}

}
