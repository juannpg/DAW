package dao;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;

import modelo.Empleado;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;

public class GestorEmpleado {

	public static String buscarEmpleadoNombreEdad(MongoCollection<Document> collection, String nombre, int edad) throws Exception {

		String json = "";

		// Filtro: nombre = "María" y edad >= 30
		FindIterable<Document> resultados = collection.find(
			and(
				eq("nombre", nombre),
				gte("edad", edad)
			));
		
		for (Document doc : resultados) {
			json += doc.toJson() + "\n";
		}

		return json;
	}

	public static ArrayList<Empleado> buscarEmpleados(MongoCollection<Document> collection) throws Exception {
		ArrayList<Empleado> lista = new ArrayList<>();

		FindIterable<Document> resultados = collection.find();

		for (Document doc : resultados) {
			String nombre = doc.getString("nombre");
			Integer edad = doc.getInteger("edad", 0);
			String puesto = doc.getString("puesto");
			Double salario = doc.getDouble("salario");
			Boolean activo = doc.getBoolean("activo", false);

			Empleado empleado = new Empleado(nombre, edad, puesto, salario, activo);
			lista.add(empleado);
		}

		return lista;
	}


	public static long borrarEmpleadosInactivos(MongoCollection<Document> collection) throws Exception {
		Bson filtro = eq("activo", false);
		DeleteResult resultado = collection.deleteMany(filtro);

		return resultado.getDeletedCount();
	}

	public static int insertarEmpleados(MongoCollection<Document> collection, ArrayList<Empleado> empleados) throws Exception {
		List<Document> listaDocs = new ArrayList<>();

		for (Empleado e : empleados) {
			Document d = new Document("nombre", e.getNombre())
					.append("edad", e.getEdad())
					.append("puesto", e.getPuesto())
					.append("salario", e.getSalario())
					.append("activo", e.isActivo());
			listaDocs.add(d);
		}

		InsertManyResult resultado = collection.insertMany(listaDocs);

		int numeroInsertados = 0;
		for (Integer i : resultado.getInsertedIds().keySet()) numeroInsertados++;
		return numeroInsertados;
	}
}
