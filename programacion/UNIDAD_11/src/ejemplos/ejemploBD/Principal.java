package ejemplos.ejemploBD;

import ejemplos.ejemploBD.config.ConfigMySql;
import ejemplos.ejemploBD.dao.AccesoDepartamento;
import ejemplos.ejemploBD.dao.AccesoEmpleado;
import ejemplos.ejemploBD.excepciones.BDException;
import ejemplos.ejemploBD.modelo.Departamento;
import ejemplos.ejemploBD.modelo.Empleado;
import entrada.Teclado;

import java.util.ArrayList;
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
        int opcion;
        try {
            ConfigMySql.setContrasena();

            do {
                opcion = menu("\n(0) Salir del programa.\n" +
                        "-----------------------------------------\n" +
                        "(1) Añadir departamento\n" +
                        "(2) Consultar departamento por código\n" +
                        "(3) Consultar los departamentos ordenados por nombre\n" +
                        "(4) Modificar la ubicación de un departamento por código\n" +
                        "(5) Borrar un departamento por código\n" +
                        "-----------------------------------------\n" +
                        "(6) Insertar empleado\n" +
                        "(7) Consultar empleado por codigo\n" +
                        "(8) Consultar todos los empleados\n" +
                        "(9) Consultar empleados con mayor salario a dado\n" +
                        "(10) Modificar departamento de un empleado\n" +
                        "(11) Borrar empleado por codigo\n" +
                        "-----------------------------------------", 11);

                try {
                    switch (opcion) {
                        case 1:
                            String nombre5 = Teclado.leerCadena("Nombre: ");
                            String ubicacion5 = Teclado.leerCadena("Ubicacion: ");
                            boolean anadido = AccesoDepartamento.anadirDepartamento(nombre5, ubicacion5);
                            System.out.println(anadido ? "departamento añadido" : "departamento no añadido");
                            break;
                        case 2:
                            int codigo2 = Teclado.leerEntero("codigo? ");
                            String ubicacion2 = Teclado.leerCadena("ubicación? ");
                            boolean modificado = AccesoDepartamento.modificarUbicacionDepartamentoCodigo(codigo2, ubicacion2);
                            System.out.println(modificado ? "Departamento modificado" : "Departamento no modificado");
                            break;
                        case 3:
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
                        case 4:
                            int codigo1 = Teclado.leerEntero("codigo? ");
                            Departamento departamento1 = AccesoDepartamento.consultarDepartamentoCodigo(codigo1);
                            if (departamento1 != null) {
                                System.out.println(departamento1);
                            } else {
                                System.out.println("No existe departamento con codigo " + codigo1);
                            }
                            break;
                        case 5:
                            int codigo3 = Teclado.leerEntero("codigo? ");
                            boolean borrado = AccesoDepartamento.borrarDepartamentoCodigo(codigo3);
                            System.out.println(borrado ? "Departamento borrado" : "Departamento no borrado");
                            break;
                        case 6:
                            String nombre8 = Teclado.leerCadena("Nombre : ");
                            String fechaAlta8 = Teclado.leerCadena("Fecha alta: ");
                            float salario8 = (float) Teclado.leerReal("salario: ");
                            System.out.println("Departamentos disponibles:");

                            // muestro los departamentos existentes
                            List<Departamento> listaDepartamentos8 = AccesoDepartamento.consultarDepartamentosOrdenNombre();
                            for (Departamento d8 : listaDepartamentos8) {
                                System.out.println(d8);
                            }

                            // lista con los codigos de los departamentos
                            List<Integer> codigosDepartamentos = new ArrayList<>(listaDepartamentos8.size());
                            for (Departamento departamento : listaDepartamentos8) {
                                codigosDepartamentos.add(departamento.getCodigo());
                            }

                            // le hago escoger el departamento existente
                            int codigoDepartamento8 = Teclado.leerEntero("Codigo del departamento: ");
                            while (!codigosDepartamentos.contains(codigoDepartamento8)) {
                                System.out.println("Codigo no valido");
                                codigoDepartamento8 = Teclado.leerEntero("Codigo del departamento: ");
                            }

                            boolean anadido8 = AccesoEmpleado.anadirEmpleado(nombre8, fechaAlta8, salario8, codigoDepartamento8);
                            System.out.println(anadido8 ? "empleado añadido" : "empleado no añadido");
                            break;
                        case 7:
                            int codigo6 = Teclado.leerEntero("Codigo: ");
                            Empleado empleado6 = AccesoEmpleado.consultarEmpleadoCodigo(codigo6);
                            System.out.println(empleado6 != null ? empleado6 : "no encontrado");
                            break;
                        case 8:
                            List<Empleado> listaEmpleados11 = AccesoEmpleado.consultarEmpleados();
                            if (!listaEmpleados11.isEmpty()) {
                                System.out.println("Empleados:");
                                for (Empleado empleado : listaEmpleados11) {
                                    System.out.println(empleado);
                                }
                            } else {
                                System.out.println("No existen empleados");
                            }
                            break;
                        case 9:
                            float salario7 = (float) Teclado.leerReal("salario: ");
                            List<Empleado> listaEmpleados = AccesoEmpleado.consultarEmpleadosConMasSalario(salario7);
                            if (!listaEmpleados.isEmpty()) {
                                System.out.println("Empleados con mayor salario que " + salario7);
                                for (Empleado empleado : listaEmpleados) {
                                    System.out.println(empleado);
                                }
                            } else {
                                System.out.println("No existen empleados");
                            }
                            break;
                        case 10:
                            int codigo10 = Teclado.leerEntero("Codigo: ");
                            System.out.println("Departamentos disponibles:");

                            // muestro los departamentos existentes
                            List<Departamento> listaDepartamentos10 = AccesoDepartamento.consultarDepartamentosOrdenNombre();
                            for (Departamento d : listaDepartamentos10) {
                                System.out.println(d);
                            }

                            // lista con los codigos de los departamentos
                            List<Integer> codigosDepartamentos10 = new ArrayList<>(listaDepartamentos10.size());
                            for (Departamento departamento : listaDepartamentos10) {
                                codigosDepartamentos10.add(departamento.getCodigo());
                            }

                            // le hago escoger el departamento existente
                            int codigoDepartamento10 = Teclado.leerEntero("Codigo del departamento: ");
                            while (!codigosDepartamentos10.contains(codigoDepartamento10)) {
                                System.out.println("Codigo no valido");
                                codigoDepartamento10 = Teclado.leerEntero("Codigo del departamento: ");
                            }

                            boolean modificado10 = AccesoEmpleado.modificarDepartamentoCodigo(codigo10, codigoDepartamento10);
                            System.out.println(modificado10 ? "Empelado modificado" : "Empelado no modificado");
                            break;
                        case 11:
                            int codigo9 = Teclado.leerEntero("codigo? ");
                            boolean borrado9 = AccesoEmpleado.borrarEmpleadoCodigo(codigo9);
                            System.out.println(borrado9 ? "Empleado borrado" : "Empleado no borrado");
                            break;
                    }
                } catch (BDException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } while (opcion != 0);
        } catch (BDException e) {
            System.out.println(e.getMessage());
        }
    }
}
