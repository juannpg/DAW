public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

/**
 * Elección de la estructura de datos en Java
 *
 * Inicio:
 *  ├── ¿Tiene pares de clave/valor o solo valores?
 *  │      ├── Pares:
 *  │      │      ├── ¿El orden es importante?
 *  │      │      │      ├── No → HashMap
 *  │      │      │      ├── Sí:
 *  │      │      │      │      ├── ¿Orden de inserción u orden de clave?
 *  │      │      │      │      │      ├── Ordenación → TreeMap
 *  │      │      │      │      │      ├── Inserción → LinkedHashMap
 *  │      ├── Valores:
 *  │      │      ├── ¿Contiene duplicados?
 *  │      │      │      ├── Sí → ArrayList
 *  │      │      │      ├── No:
 *  │      │      │      │      ├── ¿Su tarea principal es buscar elementos (contains/remove)?
 *  │      │      │      │      │      ├── Sí:
 *  │      │      │      │      │      │      ├── ¿El orden es importante?
 *  │      │      │      │      │      │      │      ├── No → HashSet
 *  │      │      │      │      │      │      │      ├── Sí:
 *  │      │      │      │      │      │      │      │      ├── ¿Orden de inserción u orden de elemento?
 *  │      │      │      │      │      │      │      │      │      ├── Ordenación → TreeSet
 *  │      │      │      │      │      │      │      │      │      ├── Inserción → LinkedHashSet
 *  │      │      │      │      │      ├── No → ArrayList
 */
