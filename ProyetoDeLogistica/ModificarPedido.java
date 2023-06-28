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

public class ModificarPedido extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane_pedidoClien;
	private ModeloTabla modeloPedidoCliente = new ModeloTabla();
	private DetallePedidoCliente detallePedidocliente = new DetallePedidoCliente();
	private ArrayList<DetallePedidoCliente> listaDetalleCliente = new ArrayList<DetallePedidoCliente>();

	/**
	 * Create the panel.
	 */
	public ModificarPedido() {
		setLayout(null);

		// Carga/actualiza los clientes cuyas categorías coincidan con la del
		// producto seleccionado

		modeloPedidoCliente.setModo("listar");
		String[] columnas = { "ID_pedido_cliente", "ID_producto", "cantidad_det", "precio_unitario", "precio_total_det",
				"observaciones_det"};
		modeloPedidoCliente.setColumnas(columnas);
		JTable tableDetallePedidoClient = new JTable(modeloPedidoCliente);
		tableDetallePedidoClient.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modeloPedidoCliente.setModo("modificar");

		listaDetalleCliente = detallePedidocliente.leerDetalles("SELECT * FROM clientes_pedidos_detalles");

		modeloPedidoCliente.setRegistros(listaDetalleCliente.size(), 14);

		for (int i = 0; i < listaDetalleCliente.size(); i++) {
			modeloPedidoCliente.setValueAt((listaDetalleCliente.get(i)).getIdDetalle(), i, 0);
			modeloPedidoCliente.setValueAt((listaDetalleCliente.get(i)).getIdPedidoCliente(), i, 1);
			modeloPedidoCliente.setValueAt((listaDetalleCliente.get(i)).getIdProducto(), i, 2);
			modeloPedidoCliente.setValueAt((listaDetalleCliente.get(i)).getCantidad(), i, 3);
			modeloPedidoCliente.setValueAt((listaDetalleCliente.get(i)).getPrecio(), i, 4);
			modeloPedidoCliente.setValueAt((listaDetalleCliente.get(i)).getPrecioT(), i, 5);
			modeloPedidoCliente.setValueAt((listaDetalleCliente.get(i)).getObservaciones(), i, 6);
			
		}

		tableDetallePedidoClient.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_pedidoClien = new JScrollPane(tableDetallePedidoClient);
		scrollPane_pedidoClien.setBounds(0, 0, 1010, 600);
		add(scrollPane_pedidoClien);

		JPanel panel_modificarClient = new JPanel();
		panel_modificarClient.setBounds(0, 0, 1010, 600);
		add(panel_modificarClient);
		panel_modificarClient.setBounds(0, 600, 1010, 51);
		add(panel_modificarClient);

		JButton btn_modificarPedidoClient = new JButton("Modificar");
		btn_modificarPedidoClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_modificarPedidoClient.setBounds(65, 602, 85, 38);
		panel_modificarClient.add(btn_modificarPedidoClient);

		btn_modificarPedidoClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int fila = tableDetallePedidoClient.getSelectedRow();

					int idDetalle = Integer.parseInt(tableDetallePedidoClient.getValueAt(fila, 0).toString());
					int idPedido = Integer.parseInt(tableDetallePedidoClient.getValueAt(fila, 1).toString());
					int idProducto = Integer.parseInt(tableDetallePedidoClient.getValueAt(fila, 2).toString());
					int cant = Integer.parseInt(tableDetallePedidoClient.getValueAt(fila, 3).toString());
					float idPrecio= Integer.parseInt(tableDetallePedidoClient.getValueAt(fila, 4).toString());
					float idPrecioT = Integer.parseInt(tableDetallePedidoClient.getValueAt(fila, 5).toString());
					String obser = tableDetallePedidoClient.getValueAt(fila, 6).toString();
					
					detallePedidocliente.actualizarDetalle(idDetalle, cant, idPrecio, idPrecioT, obser);
					JOptionPane.showMessageDialog(null, "OK! Pedido actualizado");

				}

				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error SQL");

				}

			}
		});

	}

}
