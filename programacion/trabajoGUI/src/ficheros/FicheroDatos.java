package ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import config.ConfigMongo;
import dao.AccesoTrabajadores;
import modelo.Trabajador;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class FicheroDatos {
	private static MongoDatabase conexion = ConfigMongo.abrirConexion();
	private static MongoCollection<Document> trabajadores = conexion.getCollection("trabajadores");
	public static void escribirTrabajadores(String ruta, ArrayList<Trabajador> trabajadores){

		DataOutputStream fichero = null;
		try {
			fichero = new DataOutputStream (new FileOutputStream(ruta));
			for (int i=0; i<trabajadores.size(); i++){
				fichero.writeInt(0);
				fichero.writeUTF(trabajadores.get(i).getDni());
				fichero.writeUTF(trabajadores.get(i).getNombre());
				fichero.writeUTF(trabajadores.get(i).getApellidos());
				fichero.writeUTF(trabajadores.get(i).getDireccion());
				fichero.writeUTF(trabajadores.get(i).getTelefono());
				fichero.writeUTF(trabajadores.get(i).getPuesto());
			}
		}
		catch (FileNotFoundException e1){
			System.out.printf("Error al abrir fichero para escritura");
		}
		catch (IOException e){
			System.out.printf("Error al escribir en el fichero%n");
		}
		finally {
			try {
				fichero.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void insertarTrabajadoresAlIniciar(String rutaFichero) {

		DataInputStream ficheroDatos=null;
		Trabajador t = null;
		try {
			ficheroDatos=new DataInputStream(new FileInputStream(rutaFichero));
			while (true){
				// debido a que uso mongo suprimo el id
				int identificador = ficheroDatos.readInt();
				String dni =ficheroDatos.readUTF();
				String nombre =ficheroDatos.readUTF();
				String apellidos =ficheroDatos.readUTF();
				String direccion =ficheroDatos.readUTF();
				String telefono =ficheroDatos.readUTF();
				String puesto =ficheroDatos.readUTF();
				t = new Trabajador(dni,nombre,apellidos,direccion,telefono,puesto);
				boolean alta = AccesoTrabajadores.altaTrabajador(t);
				if (!alta) {
					try {
						Document doc = new Document()
							.append("dni", t.getDni())
							.append("nombre", t.getNombre())
							.append("apellidos", t.getApellidos())
							.append("direccion", t.getDireccion())
							.append("telefono", t.getTelefono())
							.append("puesto", t.getPuesto());
						trabajadores.replaceOne(eq("dni", t.getDni()), doc);
					} catch (Exception e) {
						continue;
					}
				}
			}
		}
		catch (EOFException e){

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				ficheroDatos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
