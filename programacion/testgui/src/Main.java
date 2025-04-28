import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import org.bson.types.ObjectId;

public class Main {
    public static class Trabajador {

        private String identificador;
        private String dni;
        private String nombre;
        private String apellidos;
        private String direccion;
        private String telefono;
        private String puesto;
        /**
         * @param identificador
         * @param dni
         * @param nombre
         * @param apellidos
         * @param direccion
         * @param telefono
         * @param puesto
         */
        public Trabajador(String identificador, String dni, String nombre,
                          String apellidos, String direccion, String telefono, String puesto) {
            this.identificador = identificador;
            this.dni = dni;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.direccion = direccion;
            this.telefono = telefono;
            this.puesto = puesto;
        }
        /**
         * @return the identificador
         */
        public String getIdentificador() {
            return identificador;
        }
        /**
         * @param identificador the identificador to set
         */
        public void setIdentificador(String identificador) {
            this.identificador = identificador;
        }
        /**
         * @return the dni
         */
        public String getDni() {
            return dni;
        }
        /**
         * @param dni the dni to set
         */
        public void setDni(String dni) {
            this.dni = dni;
        }
        /**
         * @return the nombre
         */
        public String getNombre() {
            return nombre;
        }
        /**
         * @param nombre the nombre to set
         */
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        /**
         * @return the apellidos
         */
        public String getApellidos() {
            return apellidos;
        }
        /**
         * @param apellidos the apellidos to set
         */
        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }
        /**
         * @return the direccion
         */
        public String getDireccion() {
            return direccion;
        }
        /**
         * @param direccion the direccion to set
         */
        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }
        /**
         * @return the telefono
         */
        public String getTelefono() {
            return telefono;
        }
        /**
         * @param telefono the telefono to set
         */
        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }
        /**
         * @return the puesto
         */
        public String getPuesto() {
            return puesto;
        }
        /**
         * @param puesto the puesto to set
         */
        public void setPuesto(String puesto) {
            this.puesto = puesto;
        }

    }
    private static MongoDatabase baseDatos;
    private static MongoClient cliente;

    private static final String URI = "mongodb://localhost:27017";
    private static final String nombre = "empresagui";

    public static MongoDatabase abrirConexion() {
        if (baseDatos == null) {
            cliente = MongoClients.create(URI);
            baseDatos = cliente.getDatabase(nombre);
        }
        return baseDatos;
    }

    public static void cerrarConexion() {
        if (cliente != null) {
            cliente.close();
            cliente = null;
            baseDatos = null;
        }
    }

    private static MongoDatabase conexion = abrirConexion();
    private static MongoCollection<Document> trabajadores = conexion.getCollection("trabajadores");


    public static boolean esta(Trabajador t) {
        ObjectId objectId = new ObjectId(t.getIdentificador());
        FindIterable<Document> iterable = trabajadores.find(and(eq("_id", objectId)));
        return iterable.first() != null;
    }

    public static boolean bajaTrabajador(String t) {
        ObjectId objectId = new ObjectId(t);
        Document document = new Document("_id", objectId);
        DeleteResult resultado = trabajadores.deleteOne(document);
        return resultado.getDeletedCount() == 1;
    }

    public static void main(String[] args) {
        boolean borrado = bajaTrabajador("680f3e9b02915e798bfcd2ae");
        System.out.println(borrado);
    }
}
