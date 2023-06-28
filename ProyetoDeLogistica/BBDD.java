import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;

public class BBDD {

	// Datos estáticos para usar en el proceso de autenticación y registro

	protected static String servidor = "localhost";
	protected static String usuario = "root";
	protected static String nombreBD = "nombreEmpresa?useServerPrepStmts=true";
	protected static String pass = "";
	protected static Connection conexion;

	public static String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public static String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public static String getNombreBD() {
		return nombreBD;
	}

	public void setNombreBD(String nombreBD) {
		this.nombreBD = nombreBD;
	}

	public static String getPass() {
		return pass;
	}

	public void setPassword(String password) {
		this.pass = password;
	}

	public Connection getConexion() {
		return this.conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public BBDD() {

	}

	public BBDD(String servidor, String nombreBD, String usuario, String password) {

		this.servidor = servidor;
		this.nombreBD = nombreBD;
		this.usuario = usuario;
		this.pass = password;

		// Registramos el driver para conectarse a BBDD de MySQL
		try {
			DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL(0): "+'\n'+e);
		}

	}
	
	public static void conectar() {
		try {
			DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error de conexión SQL(1): "+'\n'+e);
		}
	}
  
  // Login
	public static boolean login(String u, String p) { 		
			try {
				conexion = (Connection) DriverManager
						.getConnection("jdbc:mysql://" + BBDD.getServidor() + "/" + BBDD.getNombreBD(), u, p);
				JOptionPane.showMessageDialog(null, "Login OK");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Datos incorrectos, error Login");				
			}			
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			usuario=u;
			pass=p;
			return true;
  }
}
