import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class NuevoPedidoCliente extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_id_prod;
	private JScrollPane scrollPane_prod;
	private JScrollPane scrollPane_cli;
	private JTextField txt_id_cli;
	private JTextField txt_envio;
	private JTextField txt_precioTotal;
	private JTextField txt_iva;
	private JTextField txt_precio;
	private JTextField txt_fEntrega;
	private JTextArea txt_obs_ped;
	private JTable tableProd;
	private ModeloTabla modeloProducto = new ModeloTabla();
	private Producto producto = new Producto();
	private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
	private ModeloTabla modeloCliente = new ModeloTabla();
	private Pedido cliente = new Pedido();
	private ArrayList<Pedido> listaClientes = new ArrayList<Pedido>();
	private PedidoCliente pedidoC = new PedidoCliente();
	private DetallePedidoCliente detalle = new DetallePedidoCliente();
	boolean calculado = false;
	private String fechaActual = "";
	private Connection conexion;
	private Statement s;
	private ResultSet rs;
	private String consulta = "";

	/**
	 * Create the panel.
	 */
	public NuevoPedidoCliente() {
		setLayout(null);

		modeloProducto.setModo("listar");
		String[] columnasProd = { "ID_producto", "zona_almacen", "categoria", "nombre_prod", "modelo", "fabricante",
				"descripcion", "cantidad_prod", "precio_mayorista", "precio_venta", "SKU", "EAN", "observaciones_prod"};
		modeloProducto.setColumnas(columnasProd);
		tableProd = new JTable(modeloProducto);
		tableProd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listaProductos = producto.leerProductos("SELECT * FROM productos WHERE cantidad_prod>0");

		modeloProducto.setRegistros(listaProductos.size(), 15);

		for (int i = 0; i < listaProductos.size(); i++) {
			modeloProducto.setValueAt((listaProductos.get(i)).getId(), i, 0);
			modeloProducto.setValueAt((listaProductos.get(i)).getZona_almacen(), i, 1);
			modeloProducto.setValueAt((listaProductos.get(i)).getCategoria(), i, 2);
			modeloProducto.setValueAt((listaProductos.get(i)).getNombre(), i, 3);
			modeloProducto.setValueAt((listaProductos.get(i)).getModelo(), i, 4);
			modeloProducto.setValueAt((listaProductos.get(i)).getFabricante(), i, 5);
			modeloProducto.setValueAt((listaProductos.get(i)).getDescripcion(), i, 6);
			modeloProducto.setValueAt((listaProductos.get(i)).getCantidad(), i, 7);
			modeloProducto.setValueAt((listaProductos.get(i)).getPrecio_mayorista(), i, 8);
			modeloProducto.setValueAt((listaProductos.get(i)).getPrecio_venta(), i, 9);
			modeloProducto.setValueAt((listaProductos.get(i)).getSKU(), i, 10);
			modeloProducto.setValueAt((listaProductos.get(i)).getEAN(), i, 11);
			modeloProducto.setValueAt((listaProductos.get(i)).getObservaciones(), i, 12);

		}

		tableProd.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_prod = new JScrollPane(tableProd);
		scrollPane_prod.setBounds(0, 0, 1010, 260);
		add(scrollPane_prod);

		JPanel panel_pedidoC = new JPanel();
		panel_pedidoC.setBounds(0, 540, 1010, 112);
		add(panel_pedidoC);
		panel_pedidoC.setLayout(null);

		JLabel lbl_id_cli = new JLabel("ID_cliente");
		lbl_id_cli.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_id_cli.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_id_cli.setBounds(10, 10, 78, 30);
		panel_pedidoC.add(lbl_id_cli);

		txt_id_cli = new JTextField();
		txt_id_cli.setEditable(false);
		txt_id_cli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_id_cli.setBounds(91, 12, 59, 27);
		panel_pedidoC.add(txt_id_cli);
		txt_id_cli.setColumns(10);

		JLabel lbl_envio = new JLabel("Gastos env\u00EDo");
		lbl_envio.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_envio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_envio.setBounds(160, 60, 101, 30);
		panel_pedidoC.add(lbl_envio);

		txt_envio = new JTextField();
		txt_envio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_envio.setColumns(10);
		txt_envio.setBounds(271, 62, 59, 27);
		panel_pedidoC.add(txt_envio);

		JLabel lbl_precioT = new JLabel("PRECIO TOTAL");
		lbl_precioT.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_precioT.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_precioT.setBounds(445, 60, 114, 30);
		panel_pedidoC.add(lbl_precioT);

		txt_precioTotal = new JTextField();
		txt_precioTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_precioTotal.setEditable(false);
		txt_precioTotal.setColumns(10);
		txt_precioTotal.setBounds(569, 62, 78, 27);
		panel_pedidoC.add(txt_precioTotal);

		JLabel lbl_obs_ped = new JLabel("Observaciones");
		lbl_obs_ped.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_obs_ped.setBounds(705, 0, 119, 30);
		panel_pedidoC.add(lbl_obs_ped);

		txt_obs_ped = new JTextArea();
		txt_obs_ped.setLineWrap(true);
		txt_obs_ped.setBounds(657, 27, 203, 75);
		panel_pedidoC.add(txt_obs_ped);

		JLabel lbl_iva = new JLabel("IVA");
		lbl_iva.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_iva.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_iva.setBounds(328, 60, 41, 30);
		panel_pedidoC.add(lbl_iva);

		txt_iva = new JTextField();
		txt_iva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_iva.setColumns(10);
		txt_iva.setBounds(376, 63, 59, 27);
		txt_iva.setText("21");
		panel_pedidoC.add(txt_iva);

		txt_precio = new JTextField();
		txt_precio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_precio.setEditable(false);
		txt_precio.setColumns(10);
		txt_precio.setBounds(91, 62, 59, 27);
		panel_pedidoC.add(txt_precio);

		JLabel lbl_precio = new JLabel("Precio");
		lbl_precio.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_precio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_precio.setBounds(22, 60, 59, 30);
		panel_pedidoC.add(lbl_precio);

		JLabel lbl_formatofecha = new JLabel("(a\u00F1o-mes-dia HH:MM)");
		lbl_formatofecha.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_formatofecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_formatofecha.setBounds(184, 10, 185, 30);
		panel_pedidoC.add(lbl_formatofecha);

		JLabel lbl_fecha_entrega = new JLabel("Fecha Entrega");
		lbl_fecha_entrega.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_fecha_entrega.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_fecha_entrega.setBounds(362, 10, 114, 30);
		panel_pedidoC.add(lbl_fecha_entrega);

		txt_fEntrega = new JTextField();
		txt_fEntrega.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_fEntrega.setColumns(10);
		txt_fEntrega.setBounds(486, 10, 161, 27);
		panel_pedidoC.add(txt_fEntrega);

		JButton btn_calcular = new JButton("Calcular");
		btn_calcular.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btn_calcular.setBounds(886, 10, 114, 38);
		panel_pedidoC.add(btn_calcular);

		btn_calcular.addActionListener(new ActionListener() { // Gestión del cálculo del pedido
			public void actionPerformed(ActionEvent e) {

				try {
					calcularPedido();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: faltan datos o datos incorrectos:" + '\n' + ex);
				}

			}
		});

		JButton btn_regPet = new JButton("PEDIR");
		btn_regPet.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_regPet.setBounds(886, 64, 114, 38);
		panel_pedidoC.add(btn_regPet);

		btn_regPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (checkCamposPedido()) {

						float precioTotal = (Float.parseFloat(txt_precio.getText()))
								+ (Float.parseFloat(txt_envio.getText()))
										* (((Integer.parseInt(txt_iva.getText()) / 100.0f) + 1.0f));
						int idCliente = Integer.parseInt(txt_id_cli.getText());
						String fechaEntrega = (txt_fEntrega.getText());
						float precio = 3.0f;
						//float precio = Float.parseFloat(txt_precio.getText());
						float envio = Float.parseFloat(txt_envio.getText());
						int iva = Integer.parseInt(txt_iva.getText());
						String obs = txt_obs_ped.getText();

						pedidoC.setIdCliente(idCliente);
						pedidoC.setFechaEntrega(fechaEntrega);
						pedidoC.setPrecio(precio);
						pedidoC.setEnvio(envio);
						pedidoC.setIva(iva);
						pedidoC.setPrecioTotal(precioTotal);
						pedidoC.setObservaciones(obs);

						pedidoC.registrarPedido(idCliente, fechaEntrega, precio, envio, iva, precioTotal, obs);

						conexion = (Connection) DriverManager.getConnection(
								"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(),
								BBDD.getPass());
						s = (Statement) conexion.createStatement();
						consulta = "SELECT MAX(ID_pedido) FROM clientes_pedidos"; // Obtenemos el último ID_pedido
																					// autoinsertado
						rs = s.executeQuery(consulta);
						rs.first(); // Nos colocamos en el primer (y único) resultado del ResultSet

						for (int i = 0; i < listaProductos.size(); i++) {
							if ((listaProductos.get(i).getPrecio_venta()) > 0 && ((int) tableProd.getValueAt(i, 1) > 0)
									&& ((int) tableProd.getValueAt(i, 1)) <= ((int) tableProd.getValueAt(i, 7))) {

								detalle.setIdPedidoCliente(rs.getInt("MAX(ID_pedido)"));
								detalle.setIdProducto((int) tableProd.getValueAt(i, 0));
								detalle.setCantidad((int) tableProd.getValueAt(i, 1));
								detalle.setPrecio(listaProductos.get(i).getPrecio_venta());
								detalle.setPrecioT((Float.parseFloat(txt_precio.getText())
										* (((int) tableProd.getValueAt(i, 1)))));
								detalle.setObservaciones(((String) tableProd.getValueAt(i, 12)));

								detalle.registrarDetalle(detalle.getIdPedidoCliente(), detalle.getIdProducto(),
										detalle.getCantidad(), detalle.getPrecio(), detalle.getPrecioT(),
										detalle.getObservaciones());

								producto.actualizarProductoUds(detalle.getIdProducto(), detalle.getCantidad(), false);
							}
						}

					} else {
						JOptionPane.showMessageDialog(null, "Error: faltan datos o datos incorrectos");
					}

				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, "Error: faltan datos o datos incorrectos:" + '\n' + e1);

				}
			}
		});

		// Eventos de la tabla productos

		tableProd.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {

				if (tableProd.getSelectedRowCount() <= 0) {

				} else {

					// Actualiza los datos del panel de petición según el producto seleccionado

					// Carga/actualiza los proveedores cuyas categorías coincidan con la del
					// producto seleccionado

					modeloCliente.setModo("listar");
					String[] columnasCli = { "ID_cliente", "nombre_cli", "apellido1", "apellido2", "NIF_cli",
							"direccion_cli", "localidad_cli", "provincia_cli", "cp_cli", "pais_cli", "tlf_cli",
							"email_cli", "web_cli", "observaciones_cli" };
					modeloCliente.setColumnas(columnasCli);
					JTable tableCliente = new JTable(modeloCliente);
					tableCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

					listaClientes = cliente.leerClientes("SELECT * FROM clientes");

					modeloCliente.setRegistros(listaClientes.size(), 14);
					if (listaClientes.size() == 0)
						txt_id_cli.setText("");

					for (int i = 0; i < listaClientes.size(); i++) {
						modeloCliente.setValueAt((listaClientes.get(i)).getId(), i, 0);
						modeloCliente.setValueAt((listaClientes.get(i)).getNombre(), i, 1);
						modeloCliente.setValueAt((listaClientes.get(i)).getApellido1(), i, 2);
						modeloCliente.setValueAt((listaClientes.get(i)).getApellido2(), i, 3);
						modeloCliente.setValueAt((listaClientes.get(i)).getNif(), i, 4);
						modeloCliente.setValueAt((listaClientes.get(i)).getDireccion(), i, 5);
						modeloCliente.setValueAt((listaClientes.get(i)).getLocalidad(), i, 6);
						modeloCliente.setValueAt((listaClientes.get(i)).getProvincia(), i, 7);
						modeloCliente.setValueAt((listaClientes.get(i)).getCodigoPostal(), i, 8);
						modeloCliente.setValueAt((listaClientes.get(i)).getPais(), i, 9);
						modeloCliente.setValueAt((listaClientes.get(i)).getTelefono(), i, 10);
						modeloCliente.setValueAt((listaClientes.get(i)).getEmail(), i, 11);
						modeloCliente.setValueAt((listaClientes.get(i)).getWeb(), i, 12);
						modeloCliente.setValueAt((listaClientes.get(i)).getObservaciones(), i, 13);
					}

					tableCliente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					scrollPane_cli = new JScrollPane(tableCliente);
					scrollPane_cli.setBounds(0, 282, 1010, 260);
					add(scrollPane_cli);

					// Eventos de la tabla cliente

					tableCliente.addMouseListener(new MouseListener() {
						@Override
						public void mouseReleased(MouseEvent e) {
						}

						@Override
						public void mousePressed(MouseEvent e) {

							if (tableCliente.getSelectedRowCount() <= 0 || listaClientes.size() == 0) {

							} else {
								// Actualiza los datos del panel de pedido según el cliente seleccionado

								int idCliente = (Integer) tableCliente.getValueAt(tableCliente.getSelectedRow(), 0);
								txt_id_cli.setText(Integer.toString(idCliente));

							}
						}

						@Override
						public void mouseExited(MouseEvent e) {
						}

						@Override
						public void mouseEntered(MouseEvent e) {
						}

						@Override
						public void mouseClicked(MouseEvent e) {
						}
					});

				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	public boolean checkCamposPedido() {

		LocalDate fechaEntrega = LocalDate.parse(txt_fEntrega.getText());

		if ((!txt_fEntrega.getText().isEmpty()) && (!txt_fEntrega.getText().isBlank())
				&& (!txt_fEntrega.getText().equalsIgnoreCase("NULL"))
				&& ((!fechaEntrega.isBefore(LocalDate.now())) && (!txt_precio.getText().isEmpty())
						&& (!txt_precio.getText().isBlank()) && (!txt_precio.getText().equalsIgnoreCase("NULL"))
						&& (!txt_envio.getText().isEmpty()) && (Float.parseFloat(txt_precio.getText()) > 0)
						&& (!txt_envio.getText().isBlank()) && (!txt_envio.getText().equalsIgnoreCase("NULL"))
						&& (!((Integer.parseInt(txt_envio.getText())) < 0) && !(txt_precioTotal.getText().isEmpty())
								&& (!txt_precioTotal.getText().isBlank())
								&& (!txt_precioTotal.getText().equalsIgnoreCase("NULL"))
								&& (!(Float.parseFloat(txt_precioTotal.getText()) < 0) && !(txt_iva.getText().isEmpty())
										&& (!txt_iva.getText().isBlank())
										&& (!txt_iva.getText().equalsIgnoreCase("NULL"))
										&& (!((Integer.parseInt(txt_iva.getText())) < 0)))))) {

			JOptionPane.showMessageDialog(null, "OK! Datos validados");
			return true; // ...devuelve true
		} else {
			JOptionPane.showMessageDialog(null, "Error: faltan datos o datos incorrectos");
			return false;
		}
	}

	public void calcularPedido() { // Recalculamos el precio del pedido, por producto y en total

		float precioP = 0.0f;
		float precio = 0.0f;
		float precioTotal = 0.0f;
		int iva = Integer.parseInt(txt_iva.getText());
		float envio = Float.parseFloat(txt_envio.getText());

		txt_precioTotal.setText("");

		for (int i = 0; i < tableProd.getRowCount(); i++) {

			float precioV = (float) tableProd.getValueAt(i, 9);
			int udsDisp = (int) tableProd.getValueAt(i, 7);
			int udsPedidas = (int) tableProd.getValueAt(i, 1);

			if ((precioV > 0) && (udsPedidas > 0) && (udsPedidas <= udsDisp)) {
				precioP = precioV * ((int) tableProd.getValueAt(i, 1));
				tableProd.setValueAt(precioP, i, 1);

				precio = precio + precioP;
			}

		}
		if (precio > 0) {
			txt_precio.setText(Float.toString(precio));
			precioTotal = (precio + envio) * ((iva / 100.0f) + 1.0f);
			txt_precioTotal.setText(Float.toString(precioTotal));

			checkCamposPedido();
		} else {
			JOptionPane.showMessageDialog(null, "Error: no hay productos en el pedido");
		}

	}
}
