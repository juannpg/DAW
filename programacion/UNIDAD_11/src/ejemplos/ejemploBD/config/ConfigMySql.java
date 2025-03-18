package ejemplos.ejemploBD.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigMySql {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URLBD = "jdbc:mysql://localhost:3306/empresa";

	private static final String usuario = "root";
	private static final String contrasena = "";

	public static Connection abrirConexion() throws SQLException, ClassNotFoundException {
		Connection conexion = null;

		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URLBD,usuario,contrasena);
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("Error al cargar driver" + e.getMessage());
		} catch (SQLException e) {
			throw new SQLException("Error al obtener la conexi�n a la bd" + e.getMessage());
		}

		return conexion;
	}

	public static void cerrarConexion(Connection conexion) throws SQLException {
		conexion.close();
	}
}
