import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DetallePedidoCliente {

	private int idDetalle;
	private int idPedidoCliente;
	private int idProducto;
	private int cantidad;
	private float precio;
	private float precioT;
	private String observaciones;
	private Connection conexion;

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public int getIdPedidoCliente() {
		return idPedidoCliente;
	}

	public void setIdPedidoCliente(int idPedidoCliente) {
		this.idPedidoCliente = idPedidoCliente;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getPrecioT() {
		return precioT;
	}

	public void setPrecioT(float precioT) {
		this.precioT = precioT;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public DetallePedidoCliente() {

	}

	public void registrarDetalle(int idPedidoC, int idProducto, int cantidad, float precio, float precioT, String obser) {

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());

			// Registra la petición a proveedor

			PreparedStatement ps = conexion
					.prepareStatement("INSERT INTO clientes_pedidos_detalles (ID_pedido_cliente, "
							+ "ID_producto, cantidad_det, precio_unitario, precio_total_det, observaciones_det) "
							+ " VALUES (?, ?, ?, ?, ?, ?)");

			ps.setInt(1, idPedidoC);
			ps.setInt(2, idProducto);
			ps.setInt(3, cantidad);
			ps.setFloat(4, precio);
			ps.setFloat(5, precioT);
			ps.setString(6, obser);

			ps.execute();

			JOptionPane.showMessageDialog(null, "OK! Detalle registrado");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error SQL:" + '\n' + e);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error de datos:" + '\n' + e1);
		}
	}

	public ArrayList<DetallePedidoCliente> leerDetalles(String consulta) { // Leer consulta de detalles de pedidos

		ArrayList<DetallePedidoCliente> listaDetalles = new ArrayList<DetallePedidoCliente>();
		DetallePedidoCliente detPedidoC = null;
		Connection conexion = null;
		Statement s = null;
		ResultSet rs = null;

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());
			s = (Statement) conexion.createStatement();
			rs = s.executeQuery(consulta);

			// Mientras haya elementos en el ResultSet de la consulta, los va agregando al
			// ArrayList de detalles de pedidos de cliente
			while (rs.next()) {

				detPedidoC = new DetallePedidoCliente();
				detPedidoC.setIdDetalle(rs.getInt("ID_detalle"));
				detPedidoC.setIdPedidoCliente(rs.getInt("ID_pedido_cliente"));
				detPedidoC.setIdProducto(rs.getInt("ID_producto"));
				detPedidoC.setCantidad(rs.getInt("cantidad_det"));
				detPedidoC.setPrecio(rs.getFloat("precio_unitario"));
				detPedidoC.setPrecioT(rs.getFloat("precio_total_det"));
				detPedidoC.setObservaciones(rs.getString("observaciones_det"));

				listaDetalles.add(detPedidoC);

			}
			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL:" + '\n' + e);
		}

		return listaDetalles;
	}

	public boolean eliminarDetalle(int id) {

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());

			PreparedStatement ps = conexion
					.prepareStatement("DELETE FROM clientes_pedidos_detalles WHERE ID_cliente=?");
			ps.setInt(1, id);
			ps.execute();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL:" + '\n' + e);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error de datos:" + '\n' + e1);
		}

		return false;
	}

	public boolean actualizarDetalle(int id, int cantidad, float precio, float precioT, String obser) {
		try {

			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());

			PreparedStatement ps = conexion
					.prepareStatement("UPDATE clientes_pedidos_detalles SET cantidad_det=?, precio_unitario=?,"
							+ "precio_total_det=?, observaciones_det=? WHERE ID_detalle=?");
			ps.setInt(1, cantidad);
			ps.setFloat(2, precio);
			ps.setFloat(3, precioT);
			ps.setInt(4, id);
			ps.setString(5, obser);
			ps.execute();

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL:" + '\n' + e);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error de datos:" + '\n' + e1);
		}

		return false;
	}
}
