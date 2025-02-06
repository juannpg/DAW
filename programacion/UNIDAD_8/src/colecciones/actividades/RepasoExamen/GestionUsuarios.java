package colecciones.actividades.RepasoExamen;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
}
