package ejemplos.ejemploBD.dao;

import ejemplos.ejemploBD.config.ConfigMySql;
import ejemplos.ejemploBD.modelo.Departamento;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoDepartamento {
    // Consultar el departamento por codigo
    public static Departamento consultarDepartamentoCodigo(int codigo) throws SQLException, ClassNotFoundException {
        Departamento departamentoReturn = null;
        Connection conexion = null;

        conexion = ConfigMySql.abrirConexion();

        String query = "SELECT * FROM departamento WHERE codigo = " + codigo;

        Statement sentencia = conexion.createStatement();
        ResultSet resultado = sentencia.executeQuery(query);

        String nombre = "", ubicacion = "";
        if (resultado.next()) {
            nombre = resultado.getString("nombre");
            ubicacion = resultado.getString("ubicacion");

            departamentoReturn = new Departamento(codigo, nombre, ubicacion);
        }

        ConfigMySql.cerrarConexion(conexion);
        return departamentoReturn;
    }

    // Modificar la ubicacion de un departamento
    public static boolean modificarUbicacionDepartamentoCodigo(int codigo, String ubicacion) throws SQLException, ClassNotFoundException {
        int filasAfectadas = 0;
        Connection conexion = null;

        conexion = ConfigMySql.abrirConexion();
        Statement sentencia = conexion.createStatement();

        String queryUpdate = "UPDATE departamento SET ubicacion = '" + ubicacion +
                "' WHERE codigo = " + codigo;
        filasAfectadas = sentencia.executeUpdate(queryUpdate);

        ConfigMySql.cerrarConexion(conexion);
        return filasAfectadas == 1;
    }

    // Borrar un departamento por codigo
    public static boolean borrarDepartamentoCodigo(int codigo) throws SQLException, ClassNotFoundException {
        int filas = 0;
        Connection conexion = null;

        conexion = ConfigMySql.abrirConexion();
        Statement sentencia = conexion.createStatement();

        String queryDelete = "DELETE FROM departamento WHERE codigo = " + codigo;
        filas = sentencia.executeUpdate(queryDelete);

        ConfigMySql.cerrarConexion(conexion);
        return filas == 1;
    }

    // Consultar todos los departamentos ordenados por nombre
    public static List<Departamento> consultarDepartamentosOrdenNombre() throws SQLException, ClassNotFoundException {
        List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
        Connection conexion = null;

        conexion = ConfigMySql.abrirConexion();

        String query = "SELECT * FROM departamento ORDER BY nombre";
        Statement sentencia = conexion.createStatement();
        ResultSet resultado = sentencia.executeQuery(query);

        while (resultado.next()) {
            Departamento departamento = new Departamento(resultado.getInt("codigo"),
                    resultado.getString("nombre"), resultado.getString("ubicacion"));
            listaDepartamentos.add(departamento);
        }

        ConfigMySql.cerrarConexion(conexion);
        return listaDepartamentos;
    }
}
