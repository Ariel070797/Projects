import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class StockTotal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane_prod;
	private ModeloTabla modeloProducto = new ModeloTabla();
	private Producto prod = new Producto();
	private ArrayList<Producto> listaProductos = new ArrayList<Producto>();

	/**
	 * Create the panel.
	 */
	public StockTotal() {
		setLayout(null);

		modeloProducto.setModo("listar");
		String[] columnas = { "ID_producto", "zona_almacen", "categoria", "nombre_prod", "modelo", "fabricante",
				"descripcion", "cantidad_prod", "precio_mayorista", "precio_venta", "SKU", "EAN",
				"observaciones_prod" };
		modeloProducto.setColumnas(columnas);
		JTable tableProd = new JTable(modeloProducto);
		tableProd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listaProductos = prod.leerProductos("SELECT * FROM productos");

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

		tableProd.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_prod = new JScrollPane(tableProd);
		scrollPane_prod.setBounds(0, 0, 1010, 651);
		add(scrollPane_prod);
	}

}
