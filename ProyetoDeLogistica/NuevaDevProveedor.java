import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

public class NuevaDevolucionProveedor extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane_peticion;
	private ModeloTabla modeloPeticion = new ModeloTabla();
	private Peticion peticion = new Peticion();
	private ArrayList<Peticion> listaPeticiones = new ArrayList<Peticion>();
	private Producto p1 = new Producto();
	private JTextField txt_id_pet;
	private JTextField txt_id_prod;
	private JTextField txt_id_prov;
	private JTextField txt_uds_pet;
	private JTextField txt_uds_disp;
	private JTextField txt_uds_dev;

	/**
	 * Create the panel.
	 */
	public NuevaDevolucionProveedor() {
		setLayout(null);

		modeloPeticion.setModo("listar");
		String[] columnas = { "ID_peticion", "ID_producto", "ID_proveedor", "cantidad_pet", "fecha_pedido",
				"fecha_llegada", "precio_pet", "envio_pet", "IVA_compra", "precio_total", "observaciones_pet" };
		modeloPeticion.setColumnas(columnas);
		JTable tablePeticion = new JTable(modeloPeticion);
		tablePeticion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listaPeticiones = peticion.leerPeticiones("SELECT * FROM proveedores_peticiones "
				+ "WHERE fecha_llegada <= CURRENT_TIMESTAMP ORDER BY fecha_llegada DESC");

		modeloPeticion.setRegistros(listaPeticiones.size(), 11);

		for (int i = 0; i < listaPeticiones.size(); i++) {
			modeloPeticion.setValueAt((listaPeticiones.get(i)).getIdPet(), i, 0);
			modeloPeticion.setValueAt((listaPeticiones.get(i)).getIdProd(), i, 1);
			modeloPeticion.setValueAt((listaPeticiones.get(i)).getIdProv(), i, 2);
			modeloPeticion.setValueAt((listaPeticiones.get(i)).getCantidad(), i, 3);
			modeloPeticion.setValueAt((listaPeticiones.get(i)).getFpedido(), i, 4);
			modeloPeticion.setValueAt((listaPeticiones.get(i)).getFllegada(), i, 5);
			modeloPeticion.setValueAt((listaPeticiones.get(i)).getPrecioProd(), i, 6);
			modeloPeticion.setValueAt((listaPeticiones.get(i)).getPrecioEnvio(), i, 7);
			modeloPeticion.setValueAt((listaPeticiones.get(i)).getIva(), i, 8);
			modeloPeticion.setValueAt((listaPeticiones.get(i)).getPrecioTpet(), i, 9);
			modeloPeticion.setValueAt((listaPeticiones.get(i)).getObservaciones(), i, 10);

		}

		tablePeticion.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_peticion = new JScrollPane(tablePeticion);
		scrollPane_peticion.setBounds(0, 0, 1010, 540);
		add(scrollPane_peticion);

		JPanel panel_nuevaDevProv = new JPanel();
		panel_nuevaDevProv.setBounds(0, 540, 1010, 112);
		add(panel_nuevaDevProv);
		panel_nuevaDevProv.setLayout(null);

		JLabel lbl_id_pet = new JLabel("ID_peticion");
		lbl_id_pet.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_id_pet.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_id_pet.setBounds(10, 10, 92, 30);
		panel_nuevaDevProv.add(lbl_id_pet);

		txt_id_pet = new JTextField();
		txt_id_pet.setEditable(false);
		txt_id_pet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_id_pet.setBounds(112, 12, 59, 27);
		txt_id_pet.setColumns(10);

		panel_nuevaDevProv.add(txt_id_pet);

		JLabel lbl_id_prod = new JLabel("ID_producto");
		lbl_id_prod.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_id_prod.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_id_prod.setBounds(10, 60, 92, 30);
		panel_nuevaDevProv.add(lbl_id_prod);

		txt_id_prod = new JTextField();
		txt_id_prod.setEditable(false);
		txt_id_prod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_id_prod.setColumns(10);
		txt_id_prod.setBounds(112, 62, 59, 27);
		panel_nuevaDevProv.add(txt_id_prod);

		JLabel lbl_id_prov = new JLabel("ID_proveedor");
		lbl_id_prov.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_id_prov.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_id_prov.setBounds(205, 10, 101, 30);
		panel_nuevaDevProv.add(lbl_id_prov);

		txt_id_prov = new JTextField();
		txt_id_prov.setEditable(false);
		txt_id_prov.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_id_prov.setColumns(10);
		txt_id_prov.setBounds(310, 12, 59, 27);
		panel_nuevaDevProv.add(txt_id_prov);

		JLabel lbl_uds_disp = new JLabel("disp.");
		lbl_uds_disp.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_uds_disp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_uds_disp.setBounds(368, 60, 42, 30);
		panel_nuevaDevProv.add(lbl_uds_disp);

		txt_uds_pet = new JTextField();
		txt_uds_pet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_uds_pet.setEditable(false);
		txt_uds_pet.setColumns(10);
		txt_uds_pet.setBounds(310, 63, 59, 27);
		panel_nuevaDevProv.add(txt_uds_pet);

		JLabel lbl_uds_pet = new JLabel("Uds. pedidas");
		lbl_uds_pet.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_uds_pet.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_uds_pet.setBounds(208, 60, 92, 30);
		panel_nuevaDevProv.add(lbl_uds_pet);

		txt_uds_disp = new JTextField();
		txt_uds_disp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_uds_disp.setEditable(false);
		txt_uds_disp.setColumns(10);
		txt_uds_disp.setBounds(420, 62, 59, 27);
		panel_nuevaDevProv.add(txt_uds_disp);

		JLabel lbl_uds_dev = new JLabel("a devolver");
		lbl_uds_dev.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_uds_dev.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_uds_dev.setBounds(489, 60, 84, 30);
		panel_nuevaDevProv.add(lbl_uds_dev);

		txt_uds_dev = new JTextField();
		txt_uds_dev.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_uds_dev.setColumns(10);
		txt_uds_dev.setBounds(583, 62, 59, 27);
		panel_nuevaDevProv.add(txt_uds_dev);

		JLabel lbl_nombre_prod = new JLabel("Nombre del producto");
		lbl_nombre_prod.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lbl_nombre_prod.setBounds(431, 10, 346, 30);
		panel_nuevaDevProv.add(lbl_nombre_prod);

		JLabel lbl_obs_dev = new JLabel("Observaciones");
		lbl_obs_dev.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_obs_dev.setBounds(705, 0, 119, 30);
		panel_nuevaDevProv.add(lbl_obs_dev);

		JTextArea txt_obs_dev = new JTextArea();
		txt_obs_dev.setBounds(657, 27, 203, 75);
		panel_nuevaDevProv.add(txt_obs_dev);

		JButton btnDevolverPet = new JButton("Devolver");
		btnDevolverPet.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDevolverPet.setBounds(878, 44, 114, 38);
		panel_nuevaDevProv.add(btnDevolverPet);

		btnDevolverPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if ((Integer.parseInt(txt_uds_dev.getText())) < 1) {
						JOptionPane.showMessageDialog(null, "Error: uds. a devolver < 1");
						return;
					}

					else if ((Integer.parseInt(txt_uds_dev.getText())) > (Integer.parseInt(txt_uds_disp.getText()))) {
						JOptionPane.showMessageDialog(null, "Error: uds. a devolver > uds. disponibles");
						return;
					}

					else if ((Integer.parseInt(txt_uds_dev.getText())) > (Integer.parseInt(txt_uds_pet.getText()))) {
						JOptionPane.showMessageDialog(null, "Error: uds. a devolver > uds. pedidas");
						return;
					}

					DevolucionProveedor devProv = new DevolucionProveedor();
					devProv.setId_pet(Integer.parseInt(txt_id_pet.getText()));
					devProv.setId_prod(Integer.parseInt(txt_id_prod.getText()));
					devProv.setId_prov(Integer.parseInt(txt_id_prov.getText()));
					devProv.setCant_dev_prov(Integer.parseInt(txt_uds_dev.getText()));
					devProv.setObs_dev_prov(txt_obs_dev.getText());

					// Registramos la devolución en la tabla de devoluciones a proveedor

					devProv.registrarDevolucion(devProv.getId_pet(), devProv.getId_prod(), devProv.getId_prov(),
							devProv.getCant_dev_prov(), devProv.getObs_dev_prov());

					// Actualizamos el stock restándole las unidades devueltas

					p1.actualizarProductoUds(devProv.getId_prod(), devProv.getCant_dev_prov(), false);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error de datos" + '\n' + e1);
				}

			}
		});

		// Eventos de la tabla de peticiones a proveedor

		tablePeticion.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {

				if (tablePeticion.getSelectedRowCount() <= 0 || listaPeticiones.size() == 0) {

				} else {
					// Actualiza los datos del panel de devolución según el proveedor seleccionado

					int idPet = (Integer) tablePeticion.getValueAt(tablePeticion.getSelectedRow(), 0);
					txt_id_pet.setText(Integer.toString(idPet));

					int idProd = (Integer) tablePeticion.getValueAt(tablePeticion.getSelectedRow(), 1);
					txt_id_prod.setText(Integer.toString(idProd));

					int idProv = (Integer) tablePeticion.getValueAt(tablePeticion.getSelectedRow(), 2);
					txt_id_prov.setText(Integer.toString(idProv));

					ArrayList<Producto> consulta = p1
							.leerProductos("SELECT * FROM productos WHERE ID_producto=" + idProd);
					int uds_disp = consulta.get(0).getCantidad();
					txt_uds_disp.setText(Integer.toString(uds_disp));

					String nombre = consulta.get(0).getNombre();
					lbl_nombre_prod.setText(nombre);

					int uds_pet = (Integer) tablePeticion.getValueAt(tablePeticion.getSelectedRow(), 3);
					txt_uds_pet.setText(Integer.toString(uds_pet));

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
