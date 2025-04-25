import dao.GestorEmpleado;
import modelo.Empleado;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;

import org.bson.Document;

public class AppPrincipal {
	public static void main(String[] args) {

		try {
			// Ejemplo de buscar todos los empleados de la base de datos
			MongoDatabase conexion = ConfigMongo.abrirConexion();
			MongoCollection<Document> empleados = conexion.getCollection("empleados");

			mostrarTodosLosEmpleados(empleados);
			buscarYMostrarEmpleadoPorNombreYEdad(empleados, "María", 30);
			borrarEmpleadosInactivos(empleados);

			ArrayList<Empleado> empleados2 = new ArrayList<>();
			empleados2.add(new Empleado("Ana García", 30, "Analista", 32000.50, true));
			empleados2.add(new Empleado("Luis Torres", 45, "Gerente", 55000.00, true));
			empleados2.add(new Empleado("María López", 28, "Desarrolladora", 38000.75, true));
			empleados2.add(new Empleado("Carlos Díaz", 50, "Contador", 42000.00, false));
			empleados2.add(new Empleado("Lucía Fernández", 35, "Diseñadora", 36000.00, true));
			insertarEmpleados(empleados, empleados2);


		} catch (Exception e) {
			System.err.println("❌ Error: " + e.getMessage());
		} finally {
			// 4. Cerrar conexión
			ConfigMongo.cerrarConexion();
		}
	}
	
	/**
	 * 
	 * @param empleados
	 * @throws Exception
	 */
	private static void mostrarTodosLosEmpleados(MongoCollection<Document> empleados) throws Exception {
		ArrayList<Empleado> lista = GestorEmpleado.buscarEmpleados(empleados);
		System.out.println("📋 Empleados:");
		for (Empleado e : lista) {
			System.out.println(e.toString());
		}
	}
	
	/**
	 * 
	 * @param empleados
	 * @param nombre
	 * @param edad
	 * @throws Exception
	 */
	private static void buscarYMostrarEmpleadoPorNombreYEdad(MongoCollection<Document> empleados, String nombre,
			int edad) throws Exception {
		String json = GestorEmpleado.buscarEmpleadoNombreEdad(empleados, nombre, edad);
		System.out.println("\n🔍 Empleados con nombre '" + nombre + "' y edad >= " + edad + ":");
		System.out.println(json);
	}

	public static void borrarEmpleadosInactivos(MongoCollection<Document> empleados) throws Exception {
		long borrados = GestorEmpleado.borrarEmpleadosInactivos(empleados);
		System.out.println(borrados + " empleados borrados");
	}

	public static void insertarEmpleados(MongoCollection<Document> empleados, ArrayList<Empleado> empleados2) throws Exception {
		int insertados = GestorEmpleado.insertarEmpleados(empleados, empleados2);
		System.out.println(insertados + " empleados insertados");
	}
}
