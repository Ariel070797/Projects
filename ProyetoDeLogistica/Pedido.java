import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Pedido {

	private int id;
  private int telefono;
	private String nombre, apellido1, apellido2, nif, direccion,
  localidad, provincia, codigoPostal, pais, email, web, observaciones;
	private Connection conexion;

	public Pedido() {

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

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
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

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public void registrarCliente(String nom, String ape1, String ape2, String nif, String dir, String loc, String prov,
			String cp, String pais, int tlf, String email, String web, String obs) {

		try {

			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());

			// Inserta en clientes uno nuevo con los datos introducidos y ya validados

			PreparedStatement ps = conexion.prepareStatement("INSERT INTO clientes (nombre_cli, apellido1, "
					+ "apellido2, NIF_cli, direccion_cli, localidad_cli, provincia_cli, cp_cli, pais_cli,"
					+ "tlf_cli, email_cli, web_cli, observaciones_cli) VALUES (?, ?, ?, ?, ?, ?, ?, ?,"
					+ "?, ?, ?, ?, ?)");

			ps.setString(1, nom);
			ps.setString(2, ape1);
			ps.setString(3, ape2);
			ps.setString(4, nif);
			ps.setString(5, dir);
			ps.setString(6, loc);
			ps.setString(7, prov);
			ps.setString(8, cp);
			ps.setString(9, pais);
			ps.setInt(10, tlf);
			ps.setString(11, email);
			ps.setString(12, web);
			ps.setString(13, obs);

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL(2):" + '\n' + e);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error de datos" + '\n' + e1);
		}
	}

	public ArrayList<Pedido> leerClientes(String consulta) { // Leer consulta de clientes

		ArrayList<Pedido> listaClientes = new ArrayList<Pedido>();
		Pedido cli = null;
		Connection conexion = null;
		Statement s = null;
		ResultSet rs = null;

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());
			s = (Statement) conexion.createStatement();
			rs = s.executeQuery(consulta);

			// Mientras haya elementos en el ResultSet de la consulta, los va agregando al
			// ArrayList de clientes
			while (rs.next()) {

				cli = new Pedido();
				cli.setId(rs.getInt("ID_cliente"));
				cli.setNombre(rs.getString("nombre_cli"));
				cli.setApellido1(rs.getString("apellido1"));
				cli.setApellido2(rs.getString("apellido2"));
				cli.setNif(rs.getString("NIF_cli"));
				cli.setDireccion(rs.getString("direccion_cli"));
				cli.setLocalidad(rs.getString("localidad_cli"));
				cli.setProvincia(rs.getString("provincia_cli"));
				cli.setCodigoPostal(rs.getString("cp_cli"));
				cli.setPais(rs.getString("pais_cli"));
				cli.setTelefono(rs.getInt("tlf_cli"));
				cli.setEmail(rs.getString("email_cli"));
				cli.setWeb(rs.getString("web_cli"));
				cli.setObservaciones(rs.getString("observaciones_cli"));

				listaClientes.add(cli);

			}
			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL(3):" + '\n' + e);
		}

		return listaClientes;
	}
	
	public boolean checkID_cliente(int id) { // Comprobar ID de proveedor antes de eliminar

		Statement s = null;
		ResultSet rs = null;

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());
			s = (Statement) conexion.createStatement();
			rs = s.executeQuery("SELECT * FROM clientes WHERE ID_cliente=" + id);

			if (!rs.isBeforeFirst()) {
				JOptionPane.showMessageDialog(null, "Error: el cliente no existe");
				return false;
			}

			else {
				return true;
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL(04)");
		}

		catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error de datos");
		}

		return false;

	}

	public boolean eliminarCliente(int id) {

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());

			PreparedStatement ps = conexion.prepareStatement("DELETE FROM clientes WHERE ID_cliente=?");
			ps.setInt(1, id);
			ps.execute();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL(5):" + '\n' + e);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error de datos:" + '\n' + e1);
		}

		return false;
	}

	public boolean modificarPedido(int id, String nom, String ape1, String ape2, String nif, String dir, String loc,
			String prov, String cp, String pais, int tlf, String email, String web, String obs) {

		try {
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), BBDD.getUsuario(), BBDD.getPass());

			PreparedStatement ps = conexion.prepareStatement("UPDATE clientes SET nombre_cli=?, apellido1=?, "
					+ "apellido2=?, NIF_cli=?, direccion_cli=?, localidad_cli=?, provincia_cli=?, cp_cli=?, "
					+ "pais_cli=?, tlf_cli=?, email_cli=?, web_cli=?, observaciones_cli=? WHERE ID_proveedor=?");

			ps.setString(1, nom);
			ps.setString(2, ape1);
			ps.setString(3, ape2);
			ps.setString(4, nif);
			ps.setString(5, dir);
			ps.setString(6, loc);
			ps.setString(7, prov);
			ps.setString(8, cp);
			ps.setString(9, pais);
			ps.setInt(10, tlf);
			ps.setString(11, email);
			ps.setString(12, web);
			ps.setString(13, obs);
			ps.setInt(14, id);
			ps.execute();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL(6):" + '\n' + e);
			return false;
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error de datos:" + '\n' + e1);
			return false;
		}
	}

}
