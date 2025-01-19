package arrayList.actividades.A2x03_Libros;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Libreria {
    private String nombre;
    private List<Libro> libros;

    public Libreria(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<Libro>();
    }

    private String stringLibros() {
        String librosStr = "";
        for (int i = 0; i < libros.size(); i++) {
            librosStr += "(" + i + ") " + libros.get(i).toString() + "\n";
        }
        return librosStr;
    }

    @Override
    public String toString() {
        return stringLibros();
    }

    public Collection<Libro> getLibros() {
        return this.libros;
    }

    public Libro consultarLibroPorISBN(int isbn) {
        for (Libro l : libros) {
            if (l.getIsbn() == isbn) {
                return l;
            }
        }

        return null;
    }

    public boolean insertarLibro(Libro libro) {
        if (consultarLibroPorISBN(libro.getIsbn()) != null) {
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

    public Libreria consultarLibros() {
        Libreria libreria = new Libreria(this.nombre);
        for (Libro l : libros) {
            libreria.libros.add(l);
        }
        return libreria;
    }

    public Libreria consultarLibrosPrecioDescendente() {
        Libreria libreria = new Libreria(this.nombre);
        for (Libro l : libros) {
            libreria.libros.add(l);
        }

        Collections.sort(libreria.libros, new LibreriaPrecioDescendente());

        return libreria;
    }

    public ArrayList<Libro> consultarLibrosPorEscritor(String escritor) {
        ArrayList<Libro> libreria = new ArrayList<Libro>();
        for (Libro l : libros) {
            if (l.getEscritor().equalsIgnoreCase(escritor)) {
                libreria.add(l);
            }
        }
        return libreria;
    }
}
