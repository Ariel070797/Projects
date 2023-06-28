import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Peticion {

	private int idPet;
	private int idProd;
	private int idProv;
	private float precioProd;
	private int cantidad;
	private float precioEnvio;
	private String fpedido;
	private String fllegada;
	private int iva;
	private float precioTpet;
	private String cat;
	private String observaciones;
	private Connection conexion;

	public Peticion() {

	}

	public int getIdPet() {
		return idPet;
	}

	public void setIdPet(int idPet) {
		this.idPet = idPet;
	}

	public String getFpedido() {
		return fpedido;
	}

	public void setFpedido(String fpedido) {
		this.fpedido = fpedido;
	}

	public String getFllegada() {
		return fllegada;
	}

	public void setFllegada(String fllegada) {
		this.fllegada = fllegada;
	}

	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public int getIdProv() {
		return idProv;
	}

	public void setIdProv(int idProv) {
		this.idProv = idProv;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public float getPrecioProd() {
		return precioProd;
	}

	public void setPrecioProd(float precioProd) {
		this.precioProd = precioProd;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecioEnvio() {
		return precioEnvio;
	}

	public void setPrecioEnvio(float precioEnvio) {
		this.precioEnvio = precioEnvio;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public float getPrecioTpet() {
		return precioTpet;
	}

	public void setPrecioTpet(float precioTpet) {
		this.precioTpet = precioTpet;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public void registrarPeticion(int idprod, int idprov, int cantidad, String llegada, float precioU, float envio,
			int ivaC, float precioT, String obs) {

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL");
		}
		try {

			// Registra la petición a proveedor

			PreparedStatement ps = conexion
					.prepareStatement("INSERT INTO proveedores_peticiones (ID_producto, ID_proveedor, "
							+ "cantidad_pet, fecha_llegada, precio_pet, envio_pet, IVA_compra, precio_total, observaciones_pet) "
							+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

			ps.setInt(1, idprod);
			ps.setInt(2, idprov);
			ps.setInt(3, cantidad);
			ps.setString(4, llegada);
			ps.setFloat(5, precioU);
			ps.setFloat(6, envio);
			ps.setInt(7, ivaC);
			ps.setFloat(8, precioT);
			ps.setString(9, obs);

			ps.execute();

			JOptionPane.showMessageDialog(null, "OK! Petición registrada");

			// Hay que tener en muy cuenta las fechas para el siguiente paso

			LocalDate fechaHoy = LocalDate.now();
			LocalDate fechaPedido = LocalDate.parse(llegada);

			// Si el pedido llega hoy, se actualizará de inmediato el stock

			if (fechaPedido.isEqual(fechaHoy)) {

				ps = conexion.prepareStatement("UPDATE productos SET cantidad_prod=cantidad_prod+" + cantidad
						+ " WHERE ID_producto=" + idprod + "");
				ps.execute();
				ps.close();
				JOptionPane.showMessageDialog(null, "Stock actualizado.");

			} else { // En caso contrario, se crea evento para actualizar stock en la fecha de
						// llegada

				// Cada evento sql debe tener nombre único, generamos aquí la parte parte
				// variable
				String idEvento = Long.toString(System.currentTimeMillis() / 5);

				ps = conexion.prepareStatement("CREATE EVENT UPD" + idEvento + " ON SCHEDULE AT '" + llegada
						+ " 00:00:00' " + "ON COMPLETION PRESERVE DO UPDATE productos SET cantidad_prod=cantidad_prod+"
						+ cantidad + "" + " WHERE ID_producto=" + idprod + "");
				ps.execute();
				ps.close();
				JOptionPane.showMessageDialog(null, "Fecha de actualización del stock: " + llegada);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error SQL: " + '\n' + e);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error de datos: " + '\n' + e1);
		}
	}

	public ArrayList<Peticion> leerPeticiones(String consulta) { // Leer consulta de peticiones

		ArrayList<Peticion> listaPeticiones = new ArrayList<Peticion>();
		Peticion peticion = null;
		Connection conexion = null;
		Statement s = null;
		ResultSet rs = null;

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());
			s = (Statement) conexion.createStatement();
			rs = s.executeQuery(consulta);

			// Mientras haya elementos en el ResultSet de la consulta, los va agregando al
			// ArrayList de peticiones
			while (rs.next()) {

				peticion = new Peticion();
				peticion.setIdPet(rs.getInt("ID_peticion"));
				peticion.setIdProd(rs.getInt("ID_producto"));
				peticion.setIdProv(rs.getInt("ID_proveedor"));
				peticion.setCantidad(rs.getInt("cantidad_pet"));
				peticion.setFpedido(rs.getString("fecha_pedido"));
				peticion.setFllegada(rs.getString("fecha_llegada"));
				peticion.setPrecioProd(rs.getFloat("precio_pet"));
				peticion.setPrecioEnvio(rs.getFloat("envio_pet"));
				peticion.setIva(rs.getInt("IVA_compra"));
				peticion.setPrecioTpet(rs.getInt("precio_total"));
				peticion.setObservaciones(rs.getString("observaciones_pet"));

				listaPeticiones.add(peticion);

			}
			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL");
		}

		return listaPeticiones;
	}

}
