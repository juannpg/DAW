package dao;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import config.ConfigMongo;
import org.bson.Document;

import modelo.Trabajador;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;

public class AccesoTrabajadores {
    private static MongoDatabase conexion = ConfigMongo.abrirConexion();
    private static MongoCollection<Document> trabajadores = conexion.getCollection("trabajadores");
    private static MongoCollection<Document> puestos = conexion.getCollection("puestos");

    public static boolean esta(Trabajador t) {
        FindIterable<Document> iterable = trabajadores.find(and(eq("dni", t.getDni())));
        return iterable.first() != null;
    }

    public static boolean altaTrabajador(Trabajador t) {
        if (esta(t)) {
            return false;
        }

        Document document = new Document("dni", t.getDni())
                .append("nombre", t.getNombre())
                .append("apellidos", t.getApellidos())
                .append("direccion", t.getDireccion())
                .append("telefono", t.getTelefono() + "")
                .append("puesto", t.getPuesto());
        InsertOneResult resultado = trabajadores.insertOne(document);
        return resultado.getInsertedId() != null;
    }

    public static boolean bajaTrabajador(String dni) {
        DeleteResult resultado = trabajadores.deleteMany(eq("dni", dni));
        return resultado.getDeletedCount() == 1;
    }

    public Trabajador buscarTrabajador(String dni) {
        FindIterable<Document> iterable = trabajadores.find(eq("dni", dni));
        for (Document doc : iterable) {
            return new Trabajador(doc.getObjectId("_id"), doc.getString("dni"), doc.getString("nombre"), doc.getString("apellidos"),
                    doc.getString("direccion"), doc.getString("telefono"), doc.getString("puesto"));
        }
        return null;
    }

    public static boolean modificarTrabajador(Trabajador t)  {
        if (!esta(t)) {
            return false;
        }

        Document doc = new Document();
        doc.append("dni", t.getDni());
        doc.append("nombre", t.getNombre());
        doc.append("apellidos", t.getApellidos());
        doc.append("direccion", t.getDireccion());
        doc.append("telefono", t.getTelefono());
        doc.append("puesto", t.getPuesto());
        trabajadores.replaceOne(eq("dni", t.getDni()), doc);
        return true;
    }

    public static void insertarTrabajadoresAlCargarElFichero(ArrayList<Trabajador> trabajadoresList) {
        for (Trabajador t : trabajadoresList) {
            Document d = new Document("dni", t.getDni())
                    .append("nombre", t.getNombre())
                    .append("apellidos", t.getApellidos())
                    .append("direccion", t.getDireccion())
                    .append("telefono", t.getTelefono())
                    .append("puesto", t.getPuesto());

            if (!esta(t)) {
                trabajadores.insertOne(d);
            } else {
                try {
                    modificarTrabajador(t);
                } catch (Exception e) {
                    continue;
                }
            }
        }
    }

    public static ArrayList<Trabajador> obtenerTrabajadores() {
        ArrayList<Trabajador> lista = new ArrayList<>();

        FindIterable<Document> resultados = trabajadores.find();

        for (Document doc : resultados) {
            ObjectId id = doc.getObjectId("_id");
            String dni = doc.getString("dni");
            String nombre = doc.getString("nombre");
            String apellidos = doc.getString("apellidos");
            String direccion = doc.getString("direccion");
            String telefono = doc.getString("telefono");
            String puesto = doc.getString("puesto");
            Trabajador t = new Trabajador(id, dni, nombre, apellidos, direccion, telefono, puesto);
            lista.add(t);
        }

        return lista;
    }

    public static String[][] listarTrabajadores() {
        ArrayList<Trabajador> lista = obtenerTrabajadores();
        String[][] datos = new String[lista.size()][7];
        for (int i = 0; i < lista.size(); i++) {
            Trabajador t = lista.get(i);
            String[] fila = new String[7];
            fila[0] = t.getIdentificador().toString();
            fila[1] = t.getDni();
            fila[2] = t.getNombre();
            fila[3] = t.getApellidos();
            fila[4] = t.getDireccion();
            fila[5] = t.getTelefono();
            fila[6] = t.getPuesto();

            datos[i] = fila;
        }
        return datos;
    }

    public static ArrayList<String> obtenerPuestos() {
        ArrayList<String> lista = new ArrayList<>();

        FindIterable<Document> resultados = puestos.find();

        for (Document doc : resultados) {
            String puesto = doc.getString("puesto");
            lista.add(puesto);
        }

        return lista;
    }
}
