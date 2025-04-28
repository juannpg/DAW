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
                .append("telefono", t.getTelefono())
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
                    doc.getString("direccion"), doc.getInteger("telefono"), doc.getString("puesto"));
        }
        return null;
    }

    public static void modificarTrabajador(Trabajador t) throws Exception {
        if (!esta(t)) {
            throw new Exception("El trabajador no existe");
        }

        Document doc = new Document();
        doc.append("dni", t.getDni());
        doc.append("nombre", t.getNombre());
        doc.append("apellidos", t.getApellidos());
        doc.append("direccion", t.getDireccion());
        doc.append("telefono", t.getTelefono());
        doc.append("puesto", t.getPuesto());
        trabajadores.replaceOne(eq("dni", t.getDni()), doc);
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
            int telefono = doc.getInteger("telefono");
            String puesto = doc.getString("puesto");
            Trabajador t = new Trabajador(id, dni, nombre, apellidos, direccion, telefono, puesto);
            lista.add(t);
        }

        return lista;
    }
}
