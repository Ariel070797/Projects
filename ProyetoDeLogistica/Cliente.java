import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Cliente {

	private int id;
	private String nombre;
	private String categorias;
	private String nif;
	private String direccion;
	private String localidad;
	private String provincia;
	private String codigoPostal;
	private String pais;
	private int telefono;
	private String email;
	private String web;
	private String catalogo;
	private String observaciones;
	private Connection conexion;

	public Cliente() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategorias() {
		return categorias;
	}

	public void setCategorias(String categorias) {
		this.categorias = categorias;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(String catalogo) {
		this.catalogo = catalogo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public void registrarProveedor(String nProv, String cats, String nifProv, String dirProv, String locProv,
			String prvnProv, String cpProv, String paisProv, int tlfProv, String mailProv, String webProv,
			String ctlgProv, String obsProv) {

		String nombre_prov = nProv;
		String categorias = cats;
		String NIF_prov = nifProv;
		String direccion_prov = dirProv;
		String localidad_prov = locProv;
		String provincia_prov = prvnProv;
		String cp_prov = cpProv;
		String pais_prov = paisProv;
		int tlf_prov = tlfProv;
		String email_prov = mailProv;
		String web_prov = webProv;
		String catalogo_prov = ctlgProv;
		String observaciones_prov = obsProv;

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL: " + '\n' + e1);

		}
		try {

			// Inserta en proveedores uno nuevo con los datos introducidos y ya validados

			PreparedStatement ps = conexion.prepareStatement("INSERT INTO proveedores (nombre_prov, categorias, "
					+ "NIF_prov, direccion_prov, localidad_prov, provincia_prov, cp_prov, pais_prov, tlf_prov,"
					+ "email_prov, web_prov, catalogo_prov, observaciones_prov) VALUES (?, ?, ?, ?, ?, ?, ?, ?,"
					+ "?, ?, ?, ?, ?)");

			ps.setString(1, nombre_prov);
			ps.setString(2, categorias);
			ps.setString(3, NIF_prov);
			ps.setString(4, direccion_prov);
			ps.setString(5, localidad_prov);
			ps.setString(6, provincia_prov);
			ps.setString(7, cp_prov);
			ps.setString(8, pais_prov);
			ps.setInt(9, tlf_prov);
			ps.setString(10, email_prov);
			ps.setString(11, web_prov);
			ps.setString(12, catalogo_prov);
			ps.setString(13, observaciones_prov);

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL: " + '\n' + e);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error de datos: " + '\n' + e1);
		}
	}

	public ArrayList<Cliente> leerProveedores(String consulta) { // Leer consulta de proveedores

		ArrayList<Cliente> listaProveedores = new ArrayList<Cliente>();
		Cliente prov = null;
		Connection conexion = null;
		Statement s = null;
		ResultSet rs = null;

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());
			s = (Statement) conexion.createStatement();
			rs = s.executeQuery(consulta);

			// Mientras haya elementos en el ResultSet de la consulta, los va agregando al
			// ArrayList de proveedores
			while (rs.next()) {

				prov = new Cliente();
				prov.setId(rs.getInt("ID_proveedor"));
				prov.setNombre(rs.getString("nombre_prov"));
				prov.setCategorias(rs.getString("categorias"));
				prov.setNif(rs.getString("NIF_prov"));
				prov.setDireccion(rs.getString("direccion_prov"));
				prov.setLocalidad(rs.getString("localidad_prov"));
				prov.setProvincia(rs.getString("provincia_prov"));
				prov.setCodigoPostal(rs.getString("cp_prov"));
				prov.setPais(rs.getString("pais_prov"));
				prov.setTelefono(rs.getInt("tlf_prov"));
				prov.setEmail(rs.getString("email_prov"));
				prov.setWeb(rs.getString("web_prov"));
				prov.setCatalogo(rs.getString("catalogo_prov"));
				prov.setObservaciones(rs.getString("observaciones_prov"));

				listaProveedores.add(prov);

			}
			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL");
		}

		return listaProveedores;
	}

	public boolean checkID_proveedor(int id) { // Comprobar ID de proveedor antes de eliminar

		Statement s = null;
		ResultSet rs = null;

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());
			s = (Statement) conexion.createStatement();
			rs = s.executeQuery("SELECT * FROM proveedores WHERE ID_proveedor=" + id);

			if (!rs.isBeforeFirst()) {
				JOptionPane.showMessageDialog(null, "Error: el proveedor no existe");
				return false;
			}

			else {
				return true;
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL");
		}

		catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error de datos");
		}

		return false;

	}

	public boolean eliminarProveedor(int id) {

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());

			PreparedStatement ps = conexion.prepareStatement("DELETE FROM proveedores WHERE ID_proveedor=?");
			ps.setInt(1, id);
			ps.execute();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL");
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error de datos");
		}

		return false;
	}

	public boolean modificarProveedor(int idProv, String nProv, String cats, String nifProv, String dirProv,
			String locProv, String prvnProv, String cpProv, String paisProv, int tlfProv, String mailProv,
			String webProv, String ctlgProv, String obsProv) {

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());

			PreparedStatement ps = conexion.prepareStatement("UPDATE proveedores SET nombre_prov=?, categorias=?, "
					+ "NIF_prov=?, direccion_prov=?, localidad_prov=?, provincia_prov=?, cp_prov=?, pais_prov=?, "
					+ "tlf_prov=?, email_prov=?, web_prov=?, catalogo_prov=?, observaciones_prov=? WHERE ID_proveedor=?");

			ps.setString(1, nProv);
			ps.setString(2, cats);
			ps.setString(3, nifProv);
			ps.setString(4, dirProv);
			ps.setString(5, locProv);
			ps.setString(6, prvnProv);
			ps.setString(7, cpProv);
			ps.setString(8, paisProv);
			ps.setInt(9, tlfProv);
			ps.setString(10, mailProv);
			ps.setString(11, webProv);
			ps.setString(12, ctlgProv);
			ps.setString(13, obsProv);
			ps.setInt(14, idProv);
			ps.execute();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL");
			return false;
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error de datos");
			return false;
		}
	}

}
