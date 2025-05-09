package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import config.ConfigMongo;
import excepciones.ExcepcionCSV;
import excepciones.ExcepcionJSON;
import org.bson.Document;

import modelo.Trabajador;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;
import regex.RegEx;

import static com.mongodb.client.model.Filters.*;

public class AccesoTrabajadores {
    private static MongoDatabase conexion = ConfigMongo.abrirConexion();
    private static MongoCollection<Document> trabajadores = conexion.getCollection("trabajadores");
    private static MongoCollection<Document> puestos = conexion.getCollection("puestos");

    public static boolean esta(Trabajador t, String oid) {
        FindIterable<Document> iterable = (oid != null)
            ? trabajadores.find(and(eq("_id", new ObjectId(oid))))
            : trabajadores.find(and(eq("dni", t.getDni())));

        return iterable.first() != null;
    }

    public static Trabajador buscarTrabajadorOid(String oid) {
        FindIterable<Document> iterable = trabajadores.find(eq("_id", new ObjectId(oid)));
        for (Document doc : iterable) {
            return new Trabajador(doc.getObjectId("_id"), doc.getString("dni"), doc.getString("nombre"), doc.getString("apellidos"),
                    doc.getString("direccion"), doc.getString("telefono"), doc.getString("puesto"));
        }
        return null;
    }

    /**
     * encuentra  trabajadores en base a varios campos. si un campo no se ha
     * porporcionado, se busca cualquier coincidencia en ese campo
     * @param t
     * @return
     */
    public static ArrayList<Trabajador> buscarTrabajadaroesPorVariosCampos(Trabajador t) {
        ArrayList<Trabajador> lista = new ArrayList<>();

        FindIterable<Document> iterable = trabajadores.find(and(
                t.getDni().isEmpty() ? regex("dni", ".+", "i") : eq("dni", t.getDni()),
                t.getNombre().isEmpty() ? regex("nombre", ".+", "i") : regex("nombre", "^" + Pattern.quote(t.getNombre()) + "$", "i"),
                t.getApellidos().isEmpty() ? regex("apellidos", ".+", "i") : regex("apellidos", "^" + Pattern.quote(t.getApellidos()) + "$", "i"),
                t.getDireccion().isEmpty() ? regex("direccion", ".+", "i") : regex("direccion", "^" + Pattern.quote(t.getDireccion()) + "$", "i"),
                t.getTelefono().isEmpty() ? regex("telefono", ".+", "i") : regex("telefono", "^" + Pattern.quote(t.getTelefono()) + "$", "i"),
                t.getPuesto().isEmpty() ? regex("puesto", ".+", "i") : regex("puesto", "^" + Pattern.quote(t.getPuesto()) + "$", "i")
        ));

        for (Document doc : iterable) {
            lista.add(new Trabajador(doc.getObjectId("_id"), doc.getString("dni"), doc.getString("nombre"), doc.getString("apellidos"),
                    doc.getString("direccion"), doc.getString("telefono"), doc.getString("puesto")));
        }

        return lista;
    }

    public static boolean altaTrabajador(Trabajador t) {
        if (esta(t, null)) {
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

    /**
     * usado de normal al querer modificar un trabajador desde gui
     * @param t
     * @param oid
     */
    public static boolean[] modificarTrabajador(Trabajador t, String oid) {
        boolean[] resultado = {true, false, false, false, false, false, false};

        if (t.getDni().equals("") || t.getDni().length() != 9) {
            resultado[1] = true;
            resultado[0] = false;
        }
        if (!RegEx.dniBien(t.getDni())) {
            resultado[1] = true;
            resultado[0] = false;
        }
        if (esta(t, oid)) {
            resultado[1] = true;
            resultado[0] = false;
        }
        if (t.getNombre().equals("")) {
            resultado[2] = true;
            resultado[0] = false;
        }
        if (t.getApellidos().equals("")) {
            resultado[3] = true;
            resultado[0] = false;
        }
        if (t.getDireccion().equals("")) {
            resultado[4] = true;
            resultado[0] = false;
        }
        if (t.getTelefono().length() != 9) {
            resultado[5] = true;
            resultado[0] = false;
        }
        if (!RegEx.telefonoBien(t.getTelefono())) {
            resultado[5] = true;
            resultado[0] = false;
        }
        if (t.getPuesto().equals("") || t.getPuesto().equalsIgnoreCase("seleccione")) {
            resultado[6] = true;
            resultado[0] = false;
        }

        if (!resultado[0]) {
            return resultado;
        }

        Document doc = new Document();
        doc.append("dni", t.getDni());
        doc.append("nombre", t.getNombre());
        doc.append("apellidos", t.getApellidos());
        doc.append("direccion", t.getDireccion());
        doc.append("telefono", t.getTelefono());
        doc.append("puesto", t.getPuesto());
        trabajadores.replaceOne(eq("_id", new ObjectId(oid)), doc);
        return resultado;
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

    public static String[][] listarTrabajadores(ArrayList<Trabajador> lista) {
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

    public static void exportarCsv(String ruta) throws ExcepcionCSV {
        ArrayList<Trabajador> lista = obtenerTrabajadores();
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(new File(ruta), false));

            for (Trabajador t : lista) {
                bw.write(t.toStringWithSeparators());
                bw.newLine();
            }
        } catch (IOException ioe) {
            throw new ExcepcionCSV(ExcepcionCSV.errorAbrir);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException ioe) {
                throw new ExcepcionCSV(ExcepcionCSV.errorCerrar);
            }
        }
    }

    public static void exportarJson(String ruta) throws ExcepcionJSON {
        ArrayList<Trabajador> lista = obtenerTrabajadores();
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(new File(ruta), false));
            bw.write("{");
            bw.newLine();
            bw.write("\t\"trabajadores\": [");
            bw.newLine();
            for (int i = 0; i < lista.size(); i++) {
                Trabajador t = lista.get(i);
                bw.write(t.toStringJson());
                if (i != lista.size() - 1) {
                    bw.write(",");
                }
                bw.newLine();
            }
            bw.write("\t]");
            bw.newLine();
            bw.write("}");
            bw.newLine();
        } catch (IOException ioe) {
            throw new ExcepcionJSON(ExcepcionJSON.errorAbrir);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException ioe) {
                throw new ExcepcionJSON(ExcepcionJSON.errorCerrar);
            }
        }
    }
}
