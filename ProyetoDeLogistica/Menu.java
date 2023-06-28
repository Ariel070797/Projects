import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Menu extends JPanel {

	/**
	 * Create the panel.
	 */
	private static JComboBox<?> menu_stock = new JComboBox();

	public static JComboBox<?> getMenu_stock() {
		return menu_stock;
	}

	private JComboBox menu_pedidosClientes;
	private JComboBox menu_logistica;
	private JComboBox menu_config;

	public Menu() {
		setLayout(null);
		menu_stock.setBounds(10, 36, 199, 33);
		menu_stock.setFont(new Font("Tahoma", Font.BOLD, 13));
		menu_stock.setModel(
				new DefaultComboBoxModel(new String[] { "", "--STOCK--", "NUEVO PRODUCTO", "", "--PROVEEDORES--", 
						"NUEVO PROV", "MODIFICAR PROV", "ELIMINAR PROV", "PETICION PROV","" , "--DEVOLUCIONES--",
						 "NUEVA DEV","" , "--INCIDENCIAS--", "NUEVA INC", }));
		add(menu_stock);

		menu_pedidosClientes = new JComboBox<Object>();
		menu_pedidosClientes.setBounds(219, 36, 199, 33);
		menu_pedidosClientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		menu_pedidosClientes.setModel(new DefaultComboBoxModel(
				new String[] { "", "--CLIENTES--", "NUEVO CLI", "MODIFICAR CLI", "ELIMINAR CLI",
						 "", "--PEDIDOS--", "NUEVO PED", "MODIFICAR PED" }));
		add(menu_pedidosClientes);

		menu_logistica = new JComboBox<Object>();
		menu_logistica.setBounds(430, 36, 199, 33);
		menu_logistica.setFont(new Font("Tahoma", Font.BOLD, 13));
		menu_logistica.setModel(new DefaultComboBoxModel(new String[] { "", "LLEGADAS", "SALIDAS" }));
		add(menu_logistica);

		menu_config = new JComboBox<Object>();
		menu_config.setBounds(639, 36, 199, 33);
		menu_config.setFont(new Font("Tahoma", Font.BOLD, 13));
		menu_config.setModel(new DefaultComboBoxModel(new String[] { "", "SALIR" }));
		add(menu_config);

		JLabel label_stock = new JLabel("STOCK");
		label_stock.setBounds(10, 10, 199, 27);
		label_stock.setHorizontalAlignment(SwingConstants.CENTER);
		label_stock.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(label_stock);

		JLabel label_pedidosClientes = new JLabel("CLIENTES/PEDIDOS");
		label_pedidosClientes.setBounds(219, 10, 199, 27);
		label_pedidosClientes.setHorizontalAlignment(SwingConstants.CENTER);
		label_pedidosClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(label_pedidosClientes);

		JLabel label_logistica = new JLabel("LOG\u00CDSTICA");
		label_logistica.setBounds(428, 10, 199, 27);
		label_logistica.setHorizontalAlignment(SwingConstants.CENTER);
		label_logistica.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(label_logistica);

		JLabel label_confi = new JLabel("CONFIGURACI\u00D3N");
		label_confi.setBounds(639, 10, 199, 27);
		label_confi.setHorizontalAlignment(SwingConstants.CENTER);
		label_confi.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(label_confi);

		Start.getPanel_datos().removeAll();

		menu_stock.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				menu_pedidosClientes.setSelectedItem("");

				if (menu_stock.getSelectedItem() == "") {
					Start.getPanel_datos().removeAll();
					Start.getPanel_datos().setVisible(false);

				}

				if (menu_stock.getSelectedItem() == "PETICION PROV") {
					Start.getPanel_datos().removeAll();
					NuevaPeticion nuevaPeticion = new NuevaPeticion();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					nuevaPeticion.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(nuevaPeticion);

				}

				if (menu_stock.getSelectedItem() == "--PROVEEDORES--") {
					Start.getPanel_datos().removeAll();
					ListarProveedor listarProv = new ListarProveedor();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					listarProv.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(listarProv);

				}

				if (menu_stock.getSelectedItem() == "NUEVO PROV") {
					Start.getPanel_datos().removeAll();
					NuevoProveedor nuevoProveedor = new NuevoProveedor();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					nuevoProveedor.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(nuevoProveedor);
				}

				if (menu_stock.getSelectedItem() == "MODIFICAR PROV") {
					Start.getPanel_datos().removeAll();
					ModificarProveedor modificarProv = new ModificarProveedor();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					modificarProv.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(modificarProv);

				}

				if (menu_stock.getSelectedItem() == "ELIMINAR PROV") {
					Start.getPanel_datos().removeAll();
					EliminarProveedor eliminarProveedor = new EliminarProveedor();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					eliminarProveedor.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(eliminarProveedor);
				}

				if (menu_stock.getSelectedItem() == "--DEVOLUCIONES--") {
					Start.getPanel_datos().removeAll();
					ListarDevolucionesProveedor listarDevProv = new ListarDevolucionesProveedor();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					listarDevProv.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(listarDevProv);

				}

				if (menu_stock.getSelectedItem() == "NUEVA DEV") {
					Start.getPanel_datos().removeAll();
					NuevaDevolucionProveedor nuevaDev = new NuevaDevolucionProveedor();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					nuevaDev.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(nuevaDev);

				}

				if (menu_stock.getSelectedItem() == "--INCIDENCIAS--") {
					Start.getPanel_datos().removeAll();
					ListarIncidenciasProveedor listarIncdProv = new ListarIncidenciasProveedor();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					listarIncdProv.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(listarIncdProv);
				}

				if (menu_stock.getSelectedItem() == "NUEVA INC") {
					Start.getPanel_datos().removeAll();
					NuevaIncidenciaProveedor nuevaIncdProv = new NuevaIncidenciaProveedor();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					nuevaIncdProv.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(nuevaIncdProv);

				}

				if (menu_stock.getSelectedItem() == "--STOCK--") {
					Start.getPanel_datos().removeAll();
					StockTotal stockTotal = new StockTotal();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					stockTotal.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(stockTotal);

				}

				if (menu_stock.getSelectedItem() == "NUEVO PRODUCTO") {
					Start.getPanel_datos().removeAll();
					NuevoProducto nuevoProd = new NuevoProducto();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					nuevoProd.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(nuevoProd);

				}

			}
		});

		menu_pedidosClientes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				menu_stock.setSelectedItem("");

				if (menu_pedidosClientes.getSelectedItem() == "") {
					Start.getPanel_datos().removeAll();
					Start.getPanel_datos().setVisible(false);

				}

				if (menu_pedidosClientes.getSelectedItem() == "--CLIENTES--") {
					Start.getPanel_datos().removeAll();
					ListarCliente listarCliente = new ListarCliente();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					listarCliente.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(listarCliente);
				}

				if (menu_pedidosClientes.getSelectedItem() == "NUEVO CLI") {
					Start.getPanel_datos().removeAll();
					NuevoCliente nuevoCli = new NuevoCliente();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					nuevoCli.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(nuevoCli);

				}

				if (menu_pedidosClientes.getSelectedItem() == "MODIFICAR CLI") {
					Start.getPanel_datos().removeAll();
					ModificarCliente modificarCliente = new ModificarCliente();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					modificarCliente.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(modificarCliente);
				}

				if (menu_pedidosClientes.getSelectedItem() == "ELIMINAR CLI") {
					Start.getPanel_datos().removeAll();
					EliminarCliente eliminarCliente = new EliminarCliente();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					eliminarCliente.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(eliminarCliente);
				}
				
				if (menu_pedidosClientes.getSelectedItem() == "--PEDIDOS--") {
					Start.getPanel_datos().removeAll();
					ListarPedidoCliente listarPedido = new ListarPedidoCliente();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					listarPedido.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(listarPedido);
				}
				
				if (menu_pedidosClientes.getSelectedItem() == "NUEVO PED") {
					Start.getPanel_datos().removeAll();
					NuevoPedidoCliente nuevoPedidoC = new NuevoPedidoCliente();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					nuevoPedidoC.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(nuevoPedidoC);
				}
				if (menu_pedidosClientes.getSelectedItem() == "MODIFICAR PED") {
					Start.getPanel_datos().removeAll();
					ModificarPedido modificarPedido = new ModificarPedido();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					modificarPedido.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(modificarPedido);
				}

			}
		});

		menu_logistica.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				menu_logistica.setSelectedItem("");

				if (menu_logistica.getSelectedItem() == "LLEGADAS") {
					Start.getPanel_datos().removeAll();
					Llegadas llegadas = new Llegadas();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					llegadas.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(llegadas);

				}

				if (menu_logistica.getSelectedItem() == "SALIDAS") {
					Start.getPanel_datos().removeAll();
					Salidas salidas = new Salidas();
					Start.getPanel_datos().setEnabled(true);
					Start.getPanel_datos().setVisible(true);
					salidas.setBounds(0, 0, 1010, 651);
					Start.getPanel_datos().add(salidas);
				}
			
			}
		});
		
		menu_config.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				menu_config.setSelectedItem("");

				if (menu_logistica.getSelectedItem() == "SALIR") {
					
				}
				System.exit(WIDTH);

				
			}
		});
		
		
	}
}
