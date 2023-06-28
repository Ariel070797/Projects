import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ListarPedidoCliente extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane_prov;
	private ModeloTabla modeloPedidoCli = new ModeloTabla();
	private PedidoCliente pedidoCliente = new PedidoCliente();
	private ArrayList<PedidoCliente> listaPedidoCliente = new ArrayList<PedidoCliente>();

	/**
	 * Create the panel.
	 */
	public ListarPedidoCliente() {
		setLayout(null);

		modeloPedidoCli.setModo("listar");
		String[] columnas = { "ID_pedido", "ID_cliente", "fecha_pedido", "fecha_entrega", "precio_ped",
				"envio_ped", "IVA_venta", "precio_total_ped", "observaciones_ped"};
		modeloPedidoCli.setColumnas(columnas);
		JTable tableProv = new JTable(modeloPedidoCli);
		tableProv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listaPedidoCliente = pedidoCliente.leerPedidosCliente("SELECT * FROM clientes_pedidos");

		modeloPedidoCli.setRegistros(listaPedidoCliente.size(), 9);

		for (int i = 0; i < listaPedidoCliente.size(); i++) {
			modeloPedidoCli.setValueAt((listaPedidoCliente.get(i)).getIdPedido(), i, 0);
			modeloPedidoCli.setValueAt((listaPedidoCliente.get(i)).getIdCliente(), i, 1);
			modeloPedidoCli.setValueAt((listaPedidoCliente.get(i)).getFechaPedido(), i, 2);
			modeloPedidoCli.setValueAt((listaPedidoCliente.get(i)).getFechaEntrega(), i, 3);
			modeloPedidoCli.setValueAt((listaPedidoCliente.get(i)).getPrecio(), i, 4);
			modeloPedidoCli.setValueAt((listaPedidoCliente.get(i)).getEnvio(), i, 5);
			modeloPedidoCli.setValueAt((listaPedidoCliente.get(i)).getIva(), i, 6);
			modeloPedidoCli.setValueAt((listaPedidoCliente.get(i)).getPrecioTotal(), i, 7);
			modeloPedidoCli.setValueAt((listaPedidoCliente.get(i)).getObservaciones(), i, 8);
		
		}

		tableProv.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_prov = new JScrollPane(tableProv);
		scrollPane_prov.setBounds(0, 0, 1010, 651);
		add(scrollPane_prov);
	}

}
