import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ListarCliente extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane_client;
	private ModeloTabla modeloCliente = new ModeloTabla();
	private Pedido cliente = new Pedido();
	private ArrayList<Pedido> listaCliente = new ArrayList<Pedido>();

	/**
	 * Create the panel.
	 */
	public ListarCliente() {
		setLayout(null);

		modeloCliente.setModo("listar");
		String[] columnas = { "ID_cliente", "nombre_cli", "apellido1", "apellido2", "NIF_cli",
				"direccion_cli", "localidad_cli", "provincia_cli", "cp_cli", "pais_cli", "tlf_cli", "email_cli",
				"web_cli", "observaciones_cli" };
		modeloCliente.setColumnas(columnas);
		JTable tableClient = new JTable(modeloCliente);
		tableClient.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listaCliente = cliente.leerClientes("SELECT * FROM clientes");

		modeloCliente.setRegistros(listaCliente.size(), 14);

		for (int i = 0; i < listaCliente.size(); i++) {
			modeloCliente.setValueAt((listaCliente.get(i)).getId(), i, 0);
			modeloCliente.setValueAt((listaCliente.get(i)).getNombre(), i, 1);
			modeloCliente.setValueAt((listaCliente.get(i)).getApellido1(), i, 2);
			modeloCliente.setValueAt((listaCliente.get(i)).getApellido2(), i, 3);
			modeloCliente.setValueAt((listaCliente.get(i)).getNif(), i, 4);
			modeloCliente.setValueAt((listaCliente.get(i)).getDireccion(), i, 5);
			modeloCliente.setValueAt((listaCliente.get(i)).getLocalidad(), i, 6);
			modeloCliente.setValueAt((listaCliente.get(i)).getProvincia(), i, 7);
			modeloCliente.setValueAt((listaCliente.get(i)).getCodigoPostal(), i, 8);
			modeloCliente.setValueAt((listaCliente.get(i)).getPais(), i, 9);
			modeloCliente.setValueAt((listaCliente.get(i)).getTelefono(), i, 10);
			modeloCliente.setValueAt((listaCliente.get(i)).getEmail(), i, 11);
			modeloCliente.setValueAt((listaCliente.get(i)).getWeb(), i, 12);
			modeloCliente.setValueAt((listaCliente.get(i)).getObservaciones(), i, 13);

		}

		tableClient.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_client = new JScrollPane(tableClient);
		scrollPane_client.setBounds(0, 0, 1010, 651);
		add(scrollPane_client);
	}

}

