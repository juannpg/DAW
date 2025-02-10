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
        LinkedList<String> hash = new LinkedList<>();
        for (String correo : this.mapaUsuarios.keySet()) {
            if (consultarTipoUsuario(correo)) {
                Comprador c = (Comprador) this.mapaUsuarios.get(correo);
                if (c.tieneFavorito(codProd)) hash.add(c.getCorreo());
            }
        }

        return hash;
    }
}
