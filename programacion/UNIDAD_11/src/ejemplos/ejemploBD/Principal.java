package ejemplos.ejemploBD;

import ejemplos.ejemploBD.dao.AccesoDepartamento;
import ejemplos.ejemploBD.excepciones.BDException;
import ejemplos.ejemploBD.modelo.Departamento;
import entrada.Teclado;

import java.util.List;

public class Principal {
    private static int menu(String mensaje, int numOpciones) {
        int opcion;
        do {
            System.out.println(mensaje);

            opcion = Teclado.leerEntero("Opción: ");
            if (opcion < 0 || opcion > numOpciones) {
                System.out.println("la opcion debe estar entre 0 y " + numOpciones);
            }
        } while (opcion < 0 || opcion > numOpciones);
        return opcion;
    }


    public static void main(String[] args) {
        try {
            int opcion;

            do {
                opcion = menu("\n(0) Salir del programa.\n" +
                        "(1) Consultar departamento por código\n" +
                        "(2) Modificar la ubicación de un departamento por código\n" +
                        "(3) Borrar un departamento por código\n" +
                        "(4) Consultar los departamentos ordenados por nombre", 4);

                switch (opcion) {
                    case 1:
                        int codigo1 = Teclado.leerEntero("codigo? ");
                        Departamento departamento1 = AccesoDepartamento.consultarDepartamentoCodigo(codigo1);
                        if (departamento1 != null) {
                            System.out.println(departamento1);
                        } else {
                            System.out.println("No existe departamento con codigo " + codigo1);
                        }
                        break;
                    case 2:
                        int codigo2 = Teclado.leerEntero("codigo? ");
                        String ubicacion2 = Teclado.leerCadena("ubicación? ");
                        boolean modificado = AccesoDepartamento.modificarUbicacionDepartamentoCodigo(codigo2, ubicacion2);
                        System.out.println(modificado ? "Departamento modificado" : "Departamento no modificado");
                        break;
                    case 3:
                        int codigo3 = Teclado.leerEntero("codigo? ");
                        boolean borrado = AccesoDepartamento.borrarDepartamentoCodigo(codigo3);
                        System.out.println(borrado ? "Departamento borrado" : "Departamento no borrado");
                        break;
                    case 4:
                        List<Departamento> listaDepartamentos = AccesoDepartamento.consultarDepartamentosOrdenNombre();
                        if (!listaDepartamentos.isEmpty()) {
                            System.out.println("Departamentos ordenados por nombre:");
                            for (Departamento departamento : listaDepartamentos) {
                                System.out.println(departamento);
                            }
                        } else {
                            System.out.println("No existen departamentos");
                        }
                        break;
                }
            } while (opcion != 0);
        } catch (BDException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
