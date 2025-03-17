package ejemplos.ejemploBD.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejemplos.ejemploBD.config.ConfigMySql;
import ejemplos.ejemploBD.modelo.Departamento;
import entrada.Teclado;

public class AccesoDepartamento {
	// Consulta los departamentos de la base de datos personal.db
	// con la misma ubicaci�n y ordenados por nombre de forma ascendente.
	public static List<Departamento> consultarDepartamentos(String ubicacion) {

		List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
		PreparedStatement ps = null;
		Connection conexion = null;

		try {
			conexion = ConfigMySql.abrirConexion();

			String query = "SELECT * FROM departamento WHERE ubicacion = ? ORDER BY nombre";

			ps = conexion.prepareStatement(query);
			// Al primer interrogante
			ps.setString(1, ubicacion);

			ResultSet resultados = ps.executeQuery();
			while (resultados.next()) {
				Departamento departamento = new Departamento(resultados.getInt("codigo"),
						resultados.getString("nombre"), resultados.getString("ubicacion"));
				listaDepartamentos.add(departamento);
			}
		} catch (SQLException e) {
			System.out.println("Error al ejecutar la consulta consultarDepartamentos");
			e.printStackTrace();
		}

		finally {
			ConfigMySql.cerrarConexion(conexion);
		}
		return listaDepartamentos;
	}

	// Consulta los departamentos de la base de datos con la misma ubicaci�n y
	// ordenados por nombre de forma ascendente.
	public static void main(String[] args) {
		// Realiza la consulta
		String ubicacion = Teclado.leerCadena("�Ubicaci�n? ");		
		List<Departamento> departamentos = AccesoDepartamento.consultarDepartamentos(ubicacion);

		if (departamentos.size() == 0) {
			System.out.println("No se ha encontrado ning�n departamento con esa ubicaci�n en la base de datos.");
		} else {
			for (Departamento departamento : departamentos) {
				System.out.println(departamento.toString());
			}
			System.out.println("Se han consultado " + departamentos.size() + " departamentos de la base de datos.");
		}
	}
}
