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

	// Consultar el departamento por codigo
	public static Departamento consultarDepartamentoCodigo(int codigo) {
		Departamento departamentoReturn = null;
		Connection conexion = null;

		try {
			conexion = ConfigMySql.abrirConexion();

			String query = "SELECT * FROM departamento WHERE codigo = " + codigo;

			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery(query);

			String nombre = "", ubicacion = "";
			if (resultado.next()) {
				nombre = resultado.getString("nombre");
				ubicacion = resultado.getString("ubicacion");

				departamentoReturn = new Departamento(codigo, nombre, ubicacion);
			}

		} catch (SQLException e) {
			System.out.println("Error al ejecutar la consulta consultarDepartamentos");
			e.printStackTrace();
		}

		finally {
			ConfigMySql.cerrarConexion(conexion);
		}
		return departamentoReturn;
	}

	// Modificar la ubicacion de un departamento
	public static boolean modificarUbicacionDepartamentoCodigo(int codigo, String ubicacion) {
		int filasAfectadas = 0;
		Connection conexion = null;

		try {
			conexion = ConfigMySql.abrirConexion();
			Statement sentencia = conexion.createStatement();

			String queryUpdate = "UPDATE departamento SET ubicacion = '" + ubicacion +
					"' WHERE codigo = " + codigo;
			filasAfectadas = sentencia.executeUpdate(queryUpdate);
		} catch (SQLException e) {
			System.out.println("Error al ejecutar la consulta consultarDepartamentos");
			e.printStackTrace();
		} finally {
			ConfigMySql.cerrarConexion(conexion);
		}
		return filasAfectadas == 1;
	}
	// Borrar un departamento por codigo
	public static boolean borrarDepartamentoCodigo(int codigo) {
		int filas = 0;
		Connection conexion = null;

		try {
			conexion = ConfigMySql.abrirConexion();
			Statement sentencia = conexion.createStatement();

			String queryDelete = "DELETE FROM departamento WHERE codigo = " + codigo;
			filas = sentencia.executeUpdate(queryDelete);
		} catch (SQLException e) {
			System.out.println("Error al ejecutar la consulta consultarDepartamentos");
			e.printStackTrace();
		} finally {
			ConfigMySql.cerrarConexion(conexion);
		}
		return filas == 1;
	}
	// Consultar todos los departamentos ordenados por nombre
	public static List<Departamento> consultarDepartamentosOrdenNombre() {
		List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
		Connection conexion = null;

		try {
			conexion = ConfigMySql.abrirConexion();

			String query = "SELECT * FROM departamento ORDER BY nombre";
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery(query);

			while (resultado.next()) {
				Departamento departamento = new Departamento(resultado.getInt("codigo"),
						resultado.getString("nombre"), resultado.getString("ubicacion"));
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
		int codigo = Teclado.leerEntero("�codigo�n? ");
		String ubicacion = Teclado.leerCadena("�Ubicaci�n? ");

		System.out.println("############### ANTES ###############");
		System.out.println(consultarDepartamentoCodigo(codigo));

		boolean modificado = modificarUbicacionDepartamentoCodigo(codigo, ubicacion);
		System.out.println(modificado ? "Departamento modificado" : "Departamento no modificado");

		if (modificado) {
			System.out.println("############## DESPUES ##############");
			System.out.println(consultarDepartamentoCodigo(codigo));

		}
	}
}
