package colecciones.actividades.RepasoExamen;

import java.util.HashMap;
import java.util.Map;

public class GestionUsuarios {
    private Map<String, Usuario> mapaUsuarios;

    public GestionUsuarios() {
        this.mapaUsuarios = new HashMap<String, Usuario>();
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
}
