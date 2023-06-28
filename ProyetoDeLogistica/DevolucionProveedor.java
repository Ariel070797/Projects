import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DevolucionProveedor {

	private int id_dev_prov;
	private int id_pet;
	private int id_prod;
	private int id_prov;
	private int cant_dev_prov;
	private String obs_dev_prov;
	private Connection conexion;

	public DevolucionProveedor() {

	}

	public int getId_dev_prov() {
		return id_dev_prov;
	}

	public void setId_dev_prov(int id_dev_prov) {
		this.id_dev_prov = id_dev_prov;
	}

	public int getId_pet() {
		return id_pet;
	}

	public void setId_pet(int id_pet) {
		this.id_pet = id_pet;
	}

	public int getId_prod() {
		return id_prod;
	}

	public void setId_prod(int id_prod) {
		this.id_prod = id_prod;
	}

	public int getId_prov() {
		return id_prov;
	}

	public void setId_prov(int id_prov) {
		this.id_prov = id_prov;
	}

	public int getCant_dev_prov() {
		return cant_dev_prov;
	}

	public void setCant_dev_prov(int cant_dev_prov) {
		this.cant_dev_prov = cant_dev_prov;
	}

	public String getObs_dev_prov() {
		return obs_dev_prov;
	}

	public void setObs_dev_prov(String obs_dev_prov) {
		this.obs_dev_prov = obs_dev_prov;
	}

	public void registrarDevolucion(int idpet, int idprod, int idprov, int cantidad, String obs) {

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL" + '\n' + e1);
		}
		try {

			// Registra la devolución a proveedor

			PreparedStatement ps = conexion
					.prepareStatement("INSERT INTO proveedores_devoluciones (ID_peticion, ID_producto, ID_proveedor, "
							+ "cantidad_devuelta_prov, observaciones_dev_prov) VALUES (?, ?, ?, ?, ?)");

			ps.setInt(1, idpet);
			ps.setInt(2, idprod);
			ps.setInt(3, idprov);
			ps.setInt(4, cantidad);
			ps.setString(5, obs);

			ps.execute();

			JOptionPane.showMessageDialog(null, "OK! Devolución efectuada");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error SQL" + '\n' + e);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error de datos" + '\n' + e1);
		}
	}

	public ArrayList<DevolucionProveedor> leerDevoluciones(String consulta) { // Leer consulta de devoluciones

		ArrayList<DevolucionProveedor> listaDevoluciones = new ArrayList<DevolucionProveedor>();
		DevolucionProveedor devProv = null;
		Connection conexion = null;
		Statement s = null;
		ResultSet rs = null;

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());
			s = (Statement) conexion.createStatement();
			rs = s.executeQuery(consulta);

			// Mientras haya elementos en el ResultSet de la consulta, los va agregando al
			// ArrayList de devoluciones a proveedor
			while (rs.next()) {

				devProv = new DevolucionProveedor();
				devProv.setId_dev_prov(rs.getInt("ID_devolucion_prov"));
				devProv.setId_pet(rs.getInt("ID_peticion"));
				devProv.setId_prod(rs.getInt("ID_producto"));
				devProv.setCant_dev_prov(rs.getInt("cantidad_devuelta_prov"));
				devProv.setObs_dev_prov(rs.getString("observaciones_dev_prov"));

				listaDevoluciones.add(devProv);

			}
			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL");
		}

		return listaDevoluciones;
	}
}
