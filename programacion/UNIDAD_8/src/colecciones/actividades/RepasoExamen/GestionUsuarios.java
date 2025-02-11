package colecciones.actividades.RepasoExamen;

import colecciones.actividades.RepasoExamen.exepciones.excepcionProductoFavorito;
import colecciones.actividades.RepasoExamen.exepciones.excepcionUsuario;

import java.util.*;

public class GestionUsuarios {
    private Map<String, Usuario> mapaUsuarios;

    public GestionUsuarios() {
        this.mapaUsuarios = new HashMap<String, Usuario>();
    }

    public GestionUsuarios(Map<String, Usuario> mapaUsuarios) {
        this.mapaUsuarios = mapaUsuarios;
    }

    public boolean insertarUsuario(Usuario usuario) {
        return this.mapaUsuarios.putIfAbsent(usuario.getCorreo(), usuario) == null;
    }

    @Override
    public String toString() {
        String str = "";
        for (String key : mapaUsuarios.keySet()) {
            str = str.concat(mapaUsuarios.get(key).toString()) + "\n";
        }

        return str;
    }

    public GestionUsuarios ordenarPorClave() {
        TreeMap<String, Usuario> treeMap = new TreeMap<String, Usuario>(this.mapaUsuarios);
        return new GestionUsuarios(treeMap);
    }

    public GestionUsuarios ordenPorClaveDescendente() {
        TreeMap<String, Usuario> treeMap = new TreeMap<>(new OrdenClaveDescendente());
        treeMap.putAll(this.mapaUsuarios);
        return new GestionUsuarios(treeMap);
    }

    public Usuario consultarPorCorreo(String correo) {
        return this.mapaUsuarios.get(correo);
    }

    public void actualizarPorCorreo(Usuario u, String nombre, String apellido1, String apellido2, String contraseña) {
        u.setNombre(nombre);
        u.setApellido1(apellido1);
        u.setApellido2(apellido2);
        u.setContraseña(contraseña);
    }

    public boolean borrarPorCorreo(String c) {
        return this.mapaUsuarios.remove(c) != null;
    }

    /**
     * devuelve true si es un comprador
     * @param c
     * @return
     */
    public boolean consultarTipoUsuario(String c) {
        return this.mapaUsuarios.get(c) instanceof Comprador;
    }

    public boolean estaUsuario(String c) {
        return this.mapaUsuarios.containsKey(c);
    }

    public void añadirProductoFavorito(String correo, Producto p) throws excepcionUsuario, excepcionProductoFavorito {
        if (!estaUsuario(correo)) {
            throw new excepcionUsuario(excepcionUsuario.usuarioNoExiste);
        }

        if (!consultarTipoUsuario(correo)) {
            throw new excepcionUsuario(excepcionUsuario.noEsComprador);
        }

        Comprador c = (Comprador) this.mapaUsuarios.get(correo);
        if (!c.añadirProductoFavorito(p)) {
            throw new excepcionProductoFavorito(excepcionProductoFavorito.esFavorito);
        }
    }

    public void borrarProductoFavorito(String correo, int prod) throws excepcionUsuario, excepcionProductoFavorito {
        if (!estaUsuario(correo)) {
            throw new excepcionUsuario(excepcionUsuario.usuarioNoExiste);
        }

        if (!consultarTipoUsuario(correo)) {
            throw new excepcionUsuario(excepcionUsuario.noEsComprador);
        }

        Comprador c = (Comprador) this.mapaUsuarios.get(correo);
        if (!c.borrarProductoFavorito(prod)) {
            throw new excepcionProductoFavorito(excepcionProductoFavorito.noEsFavorito);
        }
    }

    public LinkedList<String> obtenerCorreosFavoritos(int codProd) {
        LinkedList<String> list = new LinkedList<>();
        for (String correo : this.mapaUsuarios.keySet()) {
            if (consultarTipoUsuario(correo)) {
                Comprador c = (Comprador) this.mapaUsuarios.get(correo);
                if (c.tieneFavorito(codProd)) list.add(c.getCorreo());
            }
        }

        return list;
    }

    public LinkedList<Administrador> obtenerAdministradoresCategoria(String cat) {
        LinkedList<Administrador> list = new LinkedList<>();
        for (String correo : this.mapaUsuarios.keySet()) {
            if (!consultarTipoUsuario(correo)) {
                Administrador a = (Administrador) this.mapaUsuarios.get(correo);
                if (a.coincideCategoria(cat) && a.isRevisaEscritos())
                    list.add(a);
            }
        }

        return list;
    }

    public ArrayList<Usuario> ordenarPorNombreYApellidos() {
        ArrayList<Usuario> arrayList = new ArrayList<>(this.mapaUsuarios.values());
        arrayList.sort(new OrdenNombreApellido());
        return arrayList;
    }

    public HashSet<Producto> obtenerListaFavoritosComprador(String correo) throws  excepcionUsuario {
        if (!estaUsuario(correo)) {
            throw new excepcionUsuario(excepcionUsuario.usuarioNoExiste);
        }

        if (!consultarTipoUsuario(correo)) {
            throw new excepcionUsuario(excepcionUsuario.noEsComprador);
        }

        Comprador c = (Comprador) this.mapaUsuarios.get(correo);
        return c.getProductosFavs();
    }

    public Producto obtenerProductoMasFavoritos() {
        TreeMap<Producto, Integer> mapaValores = new TreeMap<>();
        for (Usuario u : this.mapaUsuarios.values()) {
            if (u instanceof Comprador c) {
                for (Producto p : c.getProductosFavs()) {
                    mapaValores.put(p, mapaValores.getOrDefault(p, 0) + 1);
                }
            }
        }

        Producto productoMasFavorito = null;
        int maxFavoritos = 0;

        for (Map.Entry<Producto, Integer> entry : mapaValores.entrySet()) {
            if (entry.getValue() > maxFavoritos) {
                maxFavoritos = entry.getValue();
                productoMasFavorito = entry.getKey();
            }
        }

        return productoMasFavorito;
    }
}
