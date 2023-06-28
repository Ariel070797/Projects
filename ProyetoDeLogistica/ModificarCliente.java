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

public class ModificarCliente extends JPanel {

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
	public ModificarCliente() {
		setLayout(null);

		// Carga/actualiza los clientes cuyas categorías coincidan con la del
		// producto seleccionado

		modeloCliente.setModo("listar");
		String[] columnas = { "ID_cliente", "nombre_cli", "apellido1", "apellido2", "NIF_cli",
				"direccion_cli", "localidad_cli", "provincia_cli", "cp_cli", "pais_cli", "tlf_cli", "email_cli",
				"web_cli", "observaciones_cli"};
		modeloCliente.setColumnas(columnas);
		JTable tableClient = new JTable(modeloCliente);
		tableClient.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modeloCliente.setModo("modificar");

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
		scrollPane_client.setBounds(0, 0, 1010, 600);
		add(scrollPane_client);

		JPanel panel_modificarClient = new JPanel();
		panel_modificarClient.setBounds(0, 0, 1010, 600);
		add(panel_modificarClient);
		panel_modificarClient.setBounds(0, 600, 1010, 51);
		add(panel_modificarClient);

		JButton btn_modificarClient = new JButton("Modificar");
		btn_modificarClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_modificarClient.setBounds(65, 602, 85, 38);
		panel_modificarClient.add(btn_modificarClient);

		btn_modificarClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int fila = tableClient.getSelectedRow();

					int id = Integer.parseInt(tableClient.getValueAt(fila, 0).toString());
					String nom = tableClient.getValueAt(fila, 1).toString();
					String ape1 = tableClient.getValueAt(fila, 2).toString();
					String ape2 = tableClient.getValueAt(fila, 3).toString();
					String nif = tableClient.getValueAt(fila, 4).toString();
					String dir = tableClient.getValueAt(fila, 5).toString();
					String local = tableClient.getValueAt(fila, 6).toString();
					String pro = tableClient.getValueAt(fila, 7).toString();
					String cp = tableClient.getValueAt(fila, 8).toString();
					String pais = tableClient.getValueAt(fila, 9).toString();
					int telf = (int) tableClient.getValueAt(fila, 10);
					String email = tableClient.getValueAt(fila, 11).toString();
					String web = tableClient.getValueAt(fila, 12).toString();
					String obser = tableClient.getValueAt(fila, 13).toString();


					cliente.modificarPedido(id, nom, ape1, ape2, nif, dir, local, pro, cp, pais, telf, email, web,
							 obser);
					JOptionPane.showMessageDialog(null, "OK! Cliente actualizado");

				}

				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error SQL");

				}

			}
		});

	}

}
