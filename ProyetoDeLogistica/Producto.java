import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Producto {

	private int id;
	private int zona_almacen;
	private String categoria;
	private String nombre;
	private String modelo;
	private String fabricante;
	private String descripcion;
	private int cantidad;
	private float precio_mayorista;
	private float precio_venta;
	private String SKU;
	private int EAN;
	private String observaciones;
	private Connection conexion;

	public Producto() {
		this.cantidad = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getZona_almacen() {
		return zona_almacen;
	}

	public void setZona_almacen(int zona_almacen) {
		this.zona_almacen = zona_almacen;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio_mayorista() {
		return precio_mayorista;
	}

	public void setPrecio_mayorista(float precio_mayorista) {
		this.precio_mayorista = precio_mayorista;
	}

	public float getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(float precio_venta) {
		this.precio_venta = precio_venta;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public int getEAN() {
		return EAN;
	}

	public void setEAN(int eAN) {
		EAN = eAN;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public ArrayList<Producto> leerProductos(String consulta) { // Leer consulta de productos

		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		Producto prod = null;
		Connection conexion = null;
		Statement s = null;
		ResultSet rs = null;

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());
			s = (Statement) conexion.createStatement();
			rs = s.executeQuery(consulta);

			while (rs.next()) {

				prod = new Producto();
				prod.setId(rs.getInt("ID_producto"));
				prod.setZona_almacen(rs.getInt("zona_almacen"));
				prod.setCategoria(rs.getString("categoria"));
				prod.setNombre(rs.getString("nombre_prod"));

				prod.setModelo(rs.getString("modelo"));
				prod.setFabricante(rs.getString("fabricante"));
				prod.setDescripcion(rs.getString("descripcion"));
				prod.setCantidad(rs.getInt("cantidad_prod"));
				prod.setPrecio_mayorista(rs.getFloat("precio_mayorista"));
				prod.setPrecio_venta(rs.getFloat("precio_venta"));
				prod.setSKU(rs.getString("SKU"));
				prod.setEAN(rs.getInt("EAN"));
				prod.setObservaciones(rs.getString("observaciones_prod"));

				listaProductos.add(prod);

			}
			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL" + '\n' + e);
		}

		return listaProductos;
	}

	public void actualizarProductoUds(int id, int uds, boolean aumentar) throws SQLException {

		Connection conexion = null;
		conexion = (Connection) DriverManager.getConnection(
				"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());
		PreparedStatement ps = null;

		if (aumentar == true) {
			ps = conexion.prepareStatement(
					"UPDATE productos SET cantidad_prod=cantidad_prod+" + uds + " WHERE ID_producto=" + id);
		} else {
			ps = conexion.prepareStatement(
					"UPDATE productos SET cantidad_prod=cantidad_prod-" + uds + " WHERE ID_producto=" + id);
		}

		ps.execute();
		ps.close();
		JOptionPane.showMessageDialog(null, "Stock actualizado.");
	}

	public void registrarProducto(int zona, String cat, String nombre, String modelo, String fabricante,
			String descripcion, float precioMayorista, float precioVenta, String SKU, int EAN, String obs) {

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL" + '\n' + e1);
		}
		try {

			// Inserta en proveedores uno nuevo con los datos introducidos y ya validados

			PreparedStatement ps = conexion.prepareStatement("INSERT INTO productos (zona_almacen, categoria, "
					+ "nombre_prod, modelo, fabricante, descripcion, precio_mayorista, precio_venta, SKU, EAN,"
					+ "observaciones_prod) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			ps.setInt(1, zona);
			ps.setString(2, cat);
			ps.setString(3, nombre);
			ps.setString(4, modelo);
			ps.setString(5, fabricante);
			ps.setString(6, descripcion);
			ps.setFloat(7, precioMayorista);
			ps.setFloat(8, precioVenta);
			ps.setString(9, SKU);
			ps.setInt(10, EAN);
			ps.setString(11, obs);

			ps.execute();

			JOptionPane.showMessageDialog(null, "Registro OK");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL" + '\n' + e);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error de datos" + '\n' + e1);
		}
	}

}
