import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EliminarCliente extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private ModeloTabla modeloCliente = new ModeloTabla();
	private Pedido cliente = new Pedido();
	private ArrayList<Pedido> listaCliente = new ArrayList<Pedido>();
	JButton btn_eliminarClient;
	JTextField txt_eliminarClient;
	JLabel lbl_eliminarClient;

	/**
	 * Create the panel.
	 */
	public EliminarCliente() {
		setLayout(null);

		modeloCliente.setModo("listar");
		String[] columnas = { "ID_cliente", "nombre_cli", "apellido1", "apellido2", "NIF_cli",
				"direccion_cli", "localidad_cli", "provincia_cli", "cp_cli", "pais_cli", "tlf_cli", "email_cli",
				"web_cli", "observaciones_cli"};
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

		scrollPane = new JScrollPane(tableClient);
		scrollPane.setBounds(0, 0, 1010, 600);
		add(scrollPane);

		JPanel panel_eliminarClie = new JPanel();
		panel_eliminarClie.setBounds(0, 0, 1010, 600);
		add(panel_eliminarClie);
		panel_eliminarClie.setBounds(0, 600, 1010, 51);
		add(panel_eliminarClie);

		JLabel lbl_eliminarClie = new JLabel("ID");
		lbl_eliminarClie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_eliminarClie.setBounds(20, 602, 24, 38);
		panel_eliminarClie.add(lbl_eliminarClie);

		txt_eliminarClient = new JTextField();
		txt_eliminarClient.setBounds(54, 615, 49, 26);
		panel_eliminarClie.add(txt_eliminarClient);
		txt_eliminarClient.setColumns(5);
		txt_eliminarClient.setEditable(false);

		JButton btn_eliminarClient = new JButton("Eliminar");
		btn_eliminarClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_eliminarClient.setBounds(131, 602, 85, 38);
		panel_eliminarClie.add(btn_eliminarClient);

		btn_eliminarClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = 0;

				try {
					id = Integer.parseInt(txt_eliminarClient.getText());
				}

				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error: ID debe ser numérico");

				}

				if (cliente.checkID_cliente(id) && (cliente.eliminarCliente(id))) {
					JOptionPane.showMessageDialog(null, "OK! Cliente eliminado");
					Menu.getMenu_stock().setSelectedItem("");
					Menu.getMenu_stock().setSelectedItem("CLIENTES->Eliminar");
				}

			}
		});

		tableClient.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {

				if (tableClient.getSelectedRowCount() <= 0) {

				} else {

					// Actualiza el CLIENTE a eliminar con el seleccionado

					txt_eliminarClient.setText((tableClient.getValueAt(tableClient.getSelectedRow(), 0).toString()));

				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}
}
