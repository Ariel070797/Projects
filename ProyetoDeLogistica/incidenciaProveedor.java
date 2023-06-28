import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class IncidenciaProveedor {

	private int id_incd_prov;
	private int id_pet;
	private int id_prod;
	private int id_prov;
	private int cant_incd;
	private String incidencia_prov;
	private boolean devolver;
	private Connection conexion;

	public IncidenciaProveedor() {

	}

	public int getId_incd_prov() {
		return id_incd_prov;
	}

	public void setId_incd_prov(int id_incd_prov) {
		this.id_incd_prov = id_incd_prov;
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

	public int getCant_incd() {
		return cant_incd;
	}

	public void setCant_incd(int cant_incd) {
		this.cant_incd = cant_incd;
	}

	public String getIncidencia_prov() {
		return incidencia_prov;
	}

	public void setIncidencia_prov(String incidencia_prov) {
		this.incidencia_prov = incidencia_prov;
	}

	public boolean isDevolver() {
		return devolver;
	}

	public void setDevolver(boolean devolver) {
		this.devolver = devolver;
	}

	public void registrarIncidencia(int idpet, int idprod, int idprov, int cantidad, String incd, boolean devolver) {

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL" + '\n' + e1);
		}
		try {

			// Registra la incidencia

			PreparedStatement ps = conexion.prepareStatement(
					"INSERT INTO proveedores_incidencias (ID_peticion, ID_producto, ID_proveedor, cantidad_incd, "
							+ "incidencias_prov, devolver) VALUES (?, ?, ?, ?, ?, ?)");

			ps.setInt(1, idpet);
			ps.setInt(2, idprod);
			ps.setInt(3, idprov);
			ps.setInt(4, cantidad);
			ps.setString(5, incd);
			ps.setBoolean(6, devolver);

			ps.execute();

			JOptionPane.showMessageDialog(null, "OK! Incidencia registrada");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error SQL" + '\n' + e);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error de datos" + '\n' + e1);
		}
	}

	public ArrayList<IncidenciaProveedor> leerIncidencias(String consulta) { // Leer consulta de devoluciones

		ArrayList<IncidenciaProveedor> listaIncidenciasProv = new ArrayList<IncidenciaProveedor>();
		IncidenciaProveedor incd = null;
		Connection conexion = null;
		Statement s = null;
		ResultSet rs = null;

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());
			s = (Statement) conexion.createStatement();
			rs = s.executeQuery(consulta);

			// Mientras haya elementos en el ResultSet de la consulta, los va agregando al
			// ArrayList de incidencias de proveedor
			while (rs.next()) {

				incd = new IncidenciaProveedor();
				incd.setId_incd_prov(rs.getInt("ID_incidencia_prov"));
				incd.setId_prod(rs.getInt("ID_producto"));
				incd.setId_prov(rs.getInt("ID_proveedor"));
				incd.setCant_incd(rs.getInt("cantidad_incd"));
				incd.setIncidencia_prov(rs.getString("incidencias_prov"));
				incd.setDevolver(rs.getBoolean("devolver"));
				listaIncidenciasProv.add(incd);

			}
			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL");
		}

		return listaIncidenciasProv;
	}

}
