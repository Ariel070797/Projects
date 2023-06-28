import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class PedidoCliente {

	private int idPedido;
	private int idCliente;
	private String fechaPedido;
	private String fechaEntrega;
	private float precio;
	private float envio;
	private int iva;
	private float precioTotal;
	private String observaciones;
	private Connection conexion;

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getEnvio() {
		return envio;
	}

	public void setEnvio(float envio) {
		this.envio = envio;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
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

	public PedidoCliente() {

	}

	public void registrarPedido(int idCliente, String fechaEntrega, float precio, float envio, int iva, float precioT,
			String obs) {

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());

			// Registra la petición a proveedor

			PreparedStatement ps = conexion.prepareStatement("INSERT INTO clientes_pedidos (ID_cliente, fecha_entrega, "
					+ "precio_ped, envio_ped, IVA_venta, precio_total_ped, observaciones_ped) "
					+ " VALUES (?, ?, ?, ?, ?, ?, ?)");

			ps.setInt(1, idCliente);
			ps.setString(2, fechaEntrega);
			ps.setFloat(3, precio);
			ps.setFloat(4, envio);
			ps.setInt(5, iva);
			ps.setFloat(6, precioT);
			ps.setString(7, obs);

			ps.execute();

			JOptionPane.showMessageDialog(null, "OK! Pedido registrado");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error SQL:" + '\n' + e);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error de datos:" + '\n' + e1);
		}
	}

	public ArrayList<PedidoCliente> leerPedidosCliente(String consulta) { // Leer consulta de pedidos de cliente

		ArrayList<PedidoCliente> listaPedidosCliente = new ArrayList<PedidoCliente>();
		PedidoCliente pedidoC = null;
		Connection conexion = null;
		Statement s = null;
		ResultSet rs = null;

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());
			s = (Statement) conexion.createStatement();
			rs = s.executeQuery(consulta);

			// Mientras haya elementos en el ResultSet de la consulta, los va agregando al
			// ArrayList de pedidos de cliente
			while (rs.next()) {

				pedidoC = new PedidoCliente();
				pedidoC.setIdPedido(rs.getInt("ID_pedido"));
				pedidoC.setIdCliente(rs.getInt("ID_cliente"));
				pedidoC.setFechaPedido(rs.getString("fecha_pedido"));
				pedidoC.setFechaEntrega(rs.getString("fecha_entrega"));
				pedidoC.setPrecio(rs.getFloat("precio_ped"));
				pedidoC.setEnvio(rs.getFloat("envio_ped"));
				pedidoC.setIva(rs.getInt("IVA_venta"));
				pedidoC.setPrecioTotal(rs.getFloat("precio_total_ped"));
				pedidoC.setObservaciones(rs.getString("observaciones_ped"));

				listaPedidosCliente.add(pedidoC);

			}
			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL:" + '\n' + e);
		}

		return listaPedidosCliente;
	}

}
