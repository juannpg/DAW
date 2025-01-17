package arrayList.actividades.A2x03_Libros;

import java.util.ArrayList;
import java.util.List;

public class Libreria {
    private String nombre;
    private List<Libro> libros;

    public Libreria(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<Libro>();
    }

    private boolean estaLibroPorISBN(int isbn) {
        for (Libro l : libros) {
            if (l.getIsbn() == isbn) {
                return true;
            }
        }

        return false;
    }

    public boolean insertarLibro(Libro libro) {
        if (estaLibroPorISBN(libro.getIsbn())) {
            return false;
        }

        libros.add(libro);
        return true;
    }

    public boolean eliminarLibroPorISBN(int isbn) {
        for (Libro l : libros) {
            if (l.getIsbn() == isbn) {
                libros.remove(l);
                return true;
            }
        }

        return false;
    }
}
