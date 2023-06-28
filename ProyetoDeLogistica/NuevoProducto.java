import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

public class NuevoProducto extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_zona, txt_cat_prod, txt_nombre_prod, txt_modelo, txt_fabricante,
  txt_precio_mayorista, txt_precio_venta, txt_sku, txt_ean;
	private JTextArea txt_descripcion;
	private JTextArea txt_obs_prod;
	private JLabel lbl_zona, lbl_cat_prod, lbl_nombre_prod, lbl_modelo, lbl_fabricante,
  lbl_descripcion, lbl_precio_mayorista, lbl_precio_venta, lbl_sku, lbl_ean, lbl_obs_prod, lbl_req, lbl_ast1;
	private JButton btn_nuevoProducto;
	private Producto prod = new Producto();

	/**
	 * Create the panel.
	 */
	public NuevoProducto() {

		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);

		lbl_cat_prod = new JLabel("Categor\u00EDa");
		lbl_cat_prod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_cat_prod.setBounds(10, 59, 74, 41);
		add(lbl_cat_prod);

		txt_zona = new JTextField();
		txt_zona.setBounds(130, 10, 292, 41);
		add(txt_zona);
		txt_zona.setColumns(10);

		lbl_nombre_prod = new JLabel("Nombre");
		lbl_nombre_prod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_nombre_prod.setBounds(10, 110, 62, 41);
		add(lbl_nombre_prod);

		lbl_modelo = new JLabel("Modelo");
		lbl_modelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_modelo.setBounds(10, 161, 62, 41);
		add(lbl_modelo);

		lbl_fabricante = new JLabel("Fabricante");
		lbl_fabricante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_fabricante.setBounds(10, 212, 74, 41);
		add(lbl_fabricante);

		lbl_descripcion = new JLabel("Descripci\u00F3n");
		lbl_descripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_descripcion.setBounds(10, 528, 74, 41);
		add(lbl_descripcion);

		lbl_precio_mayorista = new JLabel("Precio mayorista");
		lbl_precio_mayorista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_precio_mayorista.setBounds(10, 263, 110, 41);
		add(lbl_precio_mayorista);

		lbl_precio_venta = new JLabel("Precio de venta");
		lbl_precio_venta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_precio_venta.setBounds(10, 314, 110, 41);
		add(lbl_precio_venta);

		lbl_sku = new JLabel("SKU");
		lbl_sku.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_sku.setBounds(10, 365, 62, 41);
		add(lbl_sku);

		lbl_ean = new JLabel("EAN");
		lbl_ean.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ean.setBounds(10, 416, 45, 41);
		add(lbl_ean);

		lbl_zona = new JLabel("Zona almac\u00E9n");
		lbl_zona.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_zona.setBounds(10, 8, 93, 41);
		add(lbl_zona);

		lbl_obs_prod = new JLabel("Observaciones");
		lbl_obs_prod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_obs_prod.setBounds(696, 173, 104, 39);
		add(lbl_obs_prod);

		txt_cat_prod = new JTextField();
		txt_cat_prod.setColumns(10);
		txt_cat_prod.setBounds(130, 61, 292, 41);
		add(txt_cat_prod);

		txt_nombre_prod = new JTextField();
		txt_nombre_prod.setColumns(10);
		txt_nombre_prod.setBounds(130, 112, 292, 41);
		add(txt_nombre_prod);

		txt_modelo = new JTextField();
		txt_modelo.setColumns(10);
		txt_modelo.setBounds(130, 163, 292, 41);
		add(txt_modelo);

		txt_fabricante = new JTextField();
		txt_fabricante.setColumns(10);
		txt_fabricante.setBounds(130, 214, 292, 41);
		add(txt_fabricante);

		txt_precio_mayorista = new JTextField();
		txt_precio_mayorista.setColumns(10);
		txt_precio_mayorista.setBounds(130, 265, 292, 41);
		add(txt_precio_mayorista);

		txt_precio_venta = new JTextField();
		txt_precio_venta.setColumns(10);
		txt_precio_venta.setBounds(130, 316, 292, 41);
		add(txt_precio_venta);

		txt_sku = new JTextField();
		txt_sku.setColumns(10);
		txt_sku.setBounds(130, 367, 292, 41);
		add(txt_sku);

		txt_ean = new JTextField();
		txt_ean.setColumns(10);
		txt_ean.setBounds(130, 418, 292, 41);
		add(txt_ean);

		txt_obs_prod = new JTextArea();
		txt_obs_prod.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txt_obs_prod.setLineWrap(true);
		txt_obs_prod.setBounds(558, 222, 360, 164);
		add(txt_obs_prod);

		lbl_req = new JLabel("* Campos requeridos");
		lbl_req.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_req.setBounds(778, 27, 140, 31);
		add(lbl_req);

		lbl_ast1 = new JLabel("*");
		lbl_ast1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast1.setBounds(424, 8, 62, 41);
		add(lbl_ast1);

		btn_nuevoProducto = new JButton("Registrar");
		btn_nuevoProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_nuevoProducto.setBounds(655, 527, 171, 41);
		add(btn_nuevoProducto);

		txt_descripcion = new JTextArea();
		txt_descripcion.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txt_descripcion.setLineWrap(true);
		txt_descripcion.setBounds(130, 469, 360, 164);
		add(txt_descripcion);

		JLabel lbl_ast2 = new JLabel("*");
		lbl_ast2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast2.setBounds(424, 59, 62, 41);
		add(lbl_ast2);

		JLabel lbl_ast3 = new JLabel("*");
		lbl_ast3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast3.setBounds(424, 110, 62, 41);
		add(lbl_ast3);

		JLabel lbl_ast4 = new JLabel("*");
		lbl_ast4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast4.setBounds(424, 212, 62, 41);
		add(lbl_ast4);

		JLabel lbl_ast5 = new JLabel("*");
		lbl_ast5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast5.setBounds(424, 263, 62, 41);
		add(lbl_ast5);

		JLabel lbl_ast6 = new JLabel("*");
		lbl_ast6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast6.setBounds(424, 314, 62, 41);
		add(lbl_ast6);

		JLabel lbl_ast7 = new JLabel("*");
		lbl_ast7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast7.setBounds(424, 365, 62, 41);
		add(lbl_ast7);

		JLabel lbl_ast8 = new JLabel("*");
		lbl_ast8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ast8.setBounds(491, 528, 62, 41);
		add(lbl_ast8);

		btn_nuevoProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					if (checkCamposProducto()) {

						prod.setZona_almacen(Integer.parseInt(txt_zona.getText()));
						prod.setCategoria(txt_cat_prod.getText());
						prod.setNombre(txt_nombre_prod.getText());
						prod.setModelo(txt_modelo.getText());
						prod.setFabricante(txt_fabricante.getText());
						prod.setDescripcion(txt_descripcion.getText());
						prod.setPrecio_mayorista(Float.parseFloat(txt_precio_mayorista.getText()));
						prod.setPrecio_venta(Float.parseFloat(txt_precio_venta.getText()));
						prod.setSKU(txt_sku.getText());

						if (!(txt_ean.getText().isEmpty()) && (!txt_ean.getText().isBlank())
								&& (!txt_ean.getText().equalsIgnoreCase("NULL"))) {
							prod.setEAN(Integer.parseInt(txt_ean.getText()));
						}

						prod.setObservaciones(txt_obs_prod.getText());

						prod.registrarProducto(prod.getZona_almacen(), prod.getCategoria(), prod.getNombre(),
								prod.getModelo(), prod.getFabricante(), prod.getDescripcion(),
								prod.getPrecio_mayorista(), prod.getPrecio_venta(), prod.getSKU(), prod.getEAN(),
								prod.getObservaciones());

					}

					else {
						JOptionPane.showMessageDialog(null, "Error: faltan datos o datos incorrectos");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: faltan datos o datos incorrectos" + '\n' + ex);
				}

			}
		});
	};

	public boolean checkCamposProducto() {

		if ((!txt_zona.getText().isEmpty()) && (!txt_zona.getText().isBlank())
				&& (!txt_zona.getText().equalsIgnoreCase("NULL")) && !(txt_cat_prod.getText().isEmpty())
				&& (!txt_cat_prod.getText().isBlank()) && (!txt_cat_prod.getText().equalsIgnoreCase("NULL"))
				&& !(txt_nombre_prod.getText().isEmpty()) && (!txt_nombre_prod.getText().isBlank())
				&& (!txt_nombre_prod.getText().equalsIgnoreCase("NULL")) && !(txt_fabricante.getText().isEmpty())
				&& (!txt_fabricante.getText().isBlank()) && (!txt_fabricante.getText().equalsIgnoreCase("NULL"))
				&& !(txt_descripcion.getText().isEmpty()) && (!txt_descripcion.getText().isBlank())
				&& (!txt_descripcion.getText().equalsIgnoreCase("NULL")) && !(txt_precio_mayorista.getText().isEmpty())
				&& (!txt_precio_mayorista.getText().isBlank())
				&& (!txt_precio_mayorista.getText().equalsIgnoreCase("NULL")) && !(txt_precio_venta.getText().isEmpty())
				&& (!txt_precio_venta.getText().isBlank()) && (!txt_precio_venta.getText().equalsIgnoreCase("NULL"))
				&& !(txt_sku.getText().isEmpty()) && (!txt_sku.getText().isBlank())
				&& (!txt_sku.getText().equalsIgnoreCase("NULL"))) {
			return true;
		} else {
			return false;
		}
	}
}
