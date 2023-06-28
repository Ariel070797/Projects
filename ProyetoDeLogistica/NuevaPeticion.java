import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class NuevaPeticion extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_id_prod;
	private final JScrollPane scrollPane_prod;
	private JScrollPane scrollPane_prov;
	private JTextField txt_id_prov;
	private JTextField txt_uds;
	private JTextField txt_llegada;
	private JTextField txt_precio_u;
	private JTextField txt_envio;
	private JTextField txt_iva_c;
	private ModeloTabla modeloProducto = new ModeloTabla();
	private Producto producto = new Producto();
	private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
	private ModeloTabla modeloProveedor = new ModeloTabla();
	private Cliente proveedor = new Cliente();
	private ArrayList<Cliente> listaProveedores = new ArrayList<Cliente>();
	private Peticion peticion = new Peticion();
	boolean calculado = false;
	private String fechaActual = Instant.now().atZone(ZoneOffset.UTC).format(DateTimeFormatter.ISO_LOCAL_DATE);
	private LocalDate localDate = LocalDate.parse(fechaActual);

	/**
	 * Create the panel.
	 */
	public NuevaPeticion() {
		setLayout(null);

		modeloProducto.setModo("listar");
		String[] columnasProd = { "ID_producto", "zona_almacen", "categoria", "nombre_prod", "modelo", "fabricante",
				"descripcion", "cantidad_prod", "precio_mayorista", "precio_venta", "SKU", "EAN",
				"observaciones_prod" };
		modeloProducto.setColumnas(columnasProd);
		JTable tableProd = new JTable(modeloProducto);
		tableProd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listaProductos = producto.leerProductos("SELECT * FROM productos");

		modeloProducto.setRegistros(listaProductos.size(), 13);

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

		tableProd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableProd.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_prod = new JScrollPane(tableProd);
		scrollPane_prod.setBounds(0, 0, 1010, 260);
		add(scrollPane_prod);

		JPanel panel_nuevaPeticion = new JPanel();
		panel_nuevaPeticion.setBounds(0, 540, 1010, 112);
		add(panel_nuevaPeticion);
		panel_nuevaPeticion.setLayout(null);

		txt_id_prod = new JTextField();
		txt_id_prod.setBounds(121, 19, 49, 26);
		txt_id_prod.setColumns(10);
		txt_id_prod.setEditable(false);
		panel_nuevaPeticion.add(txt_id_prod);

		JLabel lbl_id_prod = new JLabel("ID_producto");
		lbl_id_prod.setBounds(24, 10, 94, 38);
		panel_nuevaPeticion.add(lbl_id_prod);
		lbl_id_prod.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lbl_id_prov = new JLabel("ID_proveedor");
		lbl_id_prov.setBounds(202, 10, 108, 38);
		lbl_id_prov.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_nuevaPeticion.add(lbl_id_prov);

		txt_id_prov = new JTextField();
		txt_id_prov.setBounds(310, 19, 49, 26);
		txt_id_prov.setColumns(10);
		txt_id_prov.setEditable(false);
		panel_nuevaPeticion.add(txt_id_prov);

		JLabel lbl_uds = new JLabel("Unidades");
		lbl_uds.setBounds(386, 10, 66, 38);
		lbl_uds.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_nuevaPeticion.add(lbl_uds);

		txt_uds = new JTextField();
		txt_uds.setBounds(459, 19, 49, 26);
		txt_uds.setColumns(10);
		txt_uds.setText("1");
		panel_nuevaPeticion.add(txt_uds);

		JLabel lbl_llegada = new JLabel("Llegada");
		lbl_llegada.setBounds(424, 47, 86, 38);
		lbl_llegada.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_nuevaPeticion.add(lbl_llegada);

		txt_llegada = new JTextField();
		txt_llegada.setBounds(508, 73, 108, 26);
		txt_llegada.setColumns(10);
		txt_llegada.setText(fechaActual);
		panel_nuevaPeticion.add(txt_llegada);

		JLabel lbl_llegada_fmt = new JLabel("a\u00F1o-mes-d\u00EDa");
		lbl_llegada_fmt.setBounds(416, 86, 94, 26);
		lbl_llegada_fmt.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_nuevaPeticion.add(lbl_llegada_fmt);

		JLabel lbl_precio_u = new JLabel("Precio u.");
		lbl_precio_u.setBounds(24, 64, 66, 38);
		lbl_precio_u.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_nuevaPeticion.add(lbl_precio_u);

		txt_precio_u = new JTextField();
		txt_precio_u.setBounds(97, 73, 49, 26);
		txt_precio_u.setColumns(10);
		panel_nuevaPeticion.add(txt_precio_u);

		JLabel lbl_envio = new JLabel("Env\u00EDo");
		lbl_envio.setBounds(174, 64, 49, 38);
		lbl_envio.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_nuevaPeticion.add(lbl_envio);

		txt_envio = new JTextField();
		txt_envio.setBounds(220, 73, 49, 26);
		txt_envio.setColumns(10);
		txt_envio.setText("0");
		panel_nuevaPeticion.add(txt_envio);

		JLabel lbl_iva_c = new JLabel("IVA");
		lbl_iva_c.setBounds(292, 64, 49, 38);
		lbl_iva_c.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_nuevaPeticion.add(lbl_iva_c);

		txt_iva_c = new JTextField();
		txt_iva_c.setBounds(328, 73, 49, 26);
		txt_iva_c.setColumns(10);
		txt_iva_c.setText("21");

		panel_nuevaPeticion.add(txt_iva_c);

		JLabel lbl_obs_pet = new JLabel("Observaciones");
		lbl_obs_pet.setBounds(736, 10, 108, 38);
		lbl_obs_pet.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_nuevaPeticion.add(lbl_obs_pet);

		JTextArea txt_obs_pet = new JTextArea();
		txt_obs_pet.setBounds(705, 47, 171, 55);
		panel_nuevaPeticion.add(txt_obs_pet);

		JLabel lbl_precio_t = new JLabel("TOTAL");
		lbl_precio_t.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_precio_t.setBounds(567, 25, 49, 38);
		panel_nuevaPeticion.add(lbl_precio_t);

		JTextField txt_precio_t = new JTextField();
		txt_precio_t.setEditable(false);
		txt_precio_t.setColumns(10);
		txt_precio_t.setBounds(621, 34, 66, 26);
		panel_nuevaPeticion.add(txt_precio_t);

		JButton btn_calcular = new JButton("Calcular");
		btn_calcular.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btn_calcular.setBounds(886, 10, 114, 38);
		panel_nuevaPeticion.add(btn_calcular);

		btn_calcular.addActionListener(new ActionListener() { // Gestión del cálculo y la validación del pedido
			public void actionPerformed(ActionEvent e) {

				try {

					if (checkCamposPeticion()) {

						JOptionPane.showMessageDialog(null, "OK. Datos calculados y validados.");

						int cantidad_pet = Integer.parseInt(txt_uds.getText());
						float precio_pet = Float.parseFloat(txt_precio_u.getText());
						float envio_pet = Float.parseFloat(txt_envio.getText());
						int IVA_compra = Integer.parseInt(txt_iva_c.getText());

						// Fórmula para calcular el precio total del pedido
						txt_precio_t.setText(Float
								.toString(((precio_pet * cantidad_pet) + envio_pet) * ((IVA_compra / 100.0f) + 1.0f)));

					} else {
						JOptionPane.showMessageDialog(null, "Error: faltan datos o datos incorrectos");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: faltan datos o datos incorrectos");
				}

			}
		});

		JButton btn_regPet = new JButton("PEDIR");
		btn_regPet.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_regPet.setBounds(886, 64, 114, 38);
		panel_nuevaPeticion.add(btn_regPet);
		btn_regPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (checkCamposPeticion()) {

						// Si todos los campos están correctos, los mete en la instancia de petición

						int ID_producto = Integer.parseInt(txt_id_prod.getText());
						int ID_proveedor = Integer.parseInt(txt_id_prov.getText());
						int cantidad_pet = Integer.parseInt(txt_uds.getText());
						String llegada = txt_llegada.getText();
						float precio_pet = Float.parseFloat(txt_precio_u.getText());
						float envio_pet = Float.parseFloat(txt_envio.getText());
						int IVA_compra = Integer.parseInt(txt_iva_c.getText());

						// Fórmula para calcular el precio total del pedido
						txt_precio_t.setText(Float
								.toString(((precio_pet * cantidad_pet) + envio_pet) * ((IVA_compra / 100.0f) + 1.0f)));

						float precio_total = Float.parseFloat(txt_precio_t.getText());
						String observaciones_pet = txt_obs_pet.getText();
						calculado = true;

						peticion.setIdProd(ID_producto);
						peticion.setIdProv(ID_proveedor);
						peticion.setCantidad(cantidad_pet);
						peticion.setFllegada(llegada);
						peticion.setPrecioProd(precio_pet);
						peticion.setPrecioEnvio(envio_pet);
						peticion.setIva(IVA_compra);
						peticion.setPrecioTpet(precio_total);
						peticion.setObservaciones(observaciones_pet);

						peticion.registrarPeticion(peticion.getIdProd(), peticion.getIdProv(), peticion.getCantidad(),
								peticion.getFllegada(), peticion.getPrecioProd(), peticion.getPrecioEnvio(),
								peticion.getIva(), peticion.getPrecioTpet(), peticion.getObservaciones());

					} else {
						JOptionPane.showMessageDialog(null, "Error: faltan datos o datos incorrectos");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error: faltan datos o datos incorrectos");

				}
			}
		});

		scrollPane_prod.setBounds(0, 0, 1010, 260);
		add(scrollPane_prod);

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

					txt_id_prod.setText((tableProd.getValueAt(tableProd.getSelectedRow(), 0).toString()));
					txt_precio_u.setText((tableProd.getValueAt(tableProd.getSelectedRow(), 8).toString()));

					// Carga/actualiza los proveedores cuyas categorías coincidan con la del
					// producto seleccionado

					modeloProveedor.setModo("listar");
					String[] columnasProv = { "ID_proveedor", "nombre_prov", "categorías", "NIF_prov", "direccion_prov",
							"localidad_prov", "provincia_prov", "cp_prov", "pais_prov", "tlf_prov", "email_prov",
							"web_prov", "catalogo_prov", "observaciones_prov" };
					modeloProveedor.setColumnas(columnasProv);
					JTable tableProv = new JTable(modeloProveedor);
					tableProv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

					String cat = (tableProd.getValueAt(tableProd.getSelectedRow(), 2).toString());

					listarProveedor();
					
					modeloProveedor.setRegistros(listaProveedores.size(), 14);
					if (listaProveedores.size() == 0)
						txt_id_prov.setText("");

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
					scrollPane_prov.setBounds(0, 282, 1010, 260);
					add(scrollPane_prov);

					// Eventos de la tabla proveedores

					tableProv.addMouseListener(new MouseListener() {
						@Override
						public void mouseReleased(MouseEvent e) {
						}

						@Override
						public void mousePressed(MouseEvent e) {

							if (tableProv.getSelectedRowCount() <= 0 || listaProveedores.size() == 0) {

							} else {
								// Actualiza los datos del panel de petición según el proveedor seleccionado

								int idProv = (Integer) tableProv.getValueAt(tableProv.getSelectedRow(), 0);
								txt_id_prov.setText(Integer.toString(idProv));

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

			private void listarProveedor() {
				// TODO Auto-generated method stub
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

	public boolean checkCamposPeticion() {

		// Si todos los campos están correctos, sin valores nulos o vacíos, y la fecha
		// no es anterior a la actual...

		localDate = LocalDate.parse(txt_llegada.getText()); // Por si cambiamos la fecha

		if ((!txt_id_prod.getText().isEmpty()) && (!txt_id_prod.getText().isBlank())
				&& (!txt_id_prod.getText().equalsIgnoreCase("NULL")) && !(txt_id_prov.getText().isEmpty())
				&& (!txt_id_prov.getText().isBlank()) && (!txt_id_prov.getText().equalsIgnoreCase("NULL"))
				&& (!txt_uds.getText().isEmpty()) && (!txt_uds.getText().isBlank())
				&& (!txt_uds.getText().equalsIgnoreCase("NULL"))
				&& (!((Integer.parseInt(txt_uds.getText())) < 1) && !(txt_precio_u.getText().isEmpty())
						&& (!txt_precio_u.getText().isBlank()) && (!txt_precio_u.getText().equalsIgnoreCase("NULL"))
						&& (!(Float.parseFloat(txt_precio_u.getText()) < 0) && !(txt_envio.getText().isEmpty())
								&& (!txt_envio.getText().isBlank()) && (!txt_envio.getText().equalsIgnoreCase("NULL"))
								&& (!((Float.parseFloat(txt_envio.getText())) < 0)) && !(txt_iva_c.getText().isEmpty())
								&& (!txt_iva_c.getText().isBlank()) && (!txt_iva_c.getText().equalsIgnoreCase("NULL"))
								&& (!((Integer.parseInt(txt_iva_c.getText())) < 0))
								&& !(txt_llegada.getText().isEmpty()) && (!txt_llegada.getText().isBlank())
								&& (!txt_llegada.getText().equalsIgnoreCase("NULL"))
								&& (!localDate.isBefore(LocalDate.now()))))) {

			return true; // ...devuelve true
		} else {
			return false;
		}
	}
}
