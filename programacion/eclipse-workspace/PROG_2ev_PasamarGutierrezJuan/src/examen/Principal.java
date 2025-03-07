package examen;

import java.util.HashSet;
import java.util.TreeSet;

import entrada.Teclado;
import examen.excepciones.ExcepcionVuelo;
import examen.excepciones.ExcepcionReserva;

//Clase Principal
public class Principal {
	public static int escribirMenuOpciones() {
		System.out.println("\n Men� de opciones:");
		System.out.println("1) Dar de alta un nuevo vuelo");
		System.out.println("2) Hacer una reserva de un vuelo");
		System.out.println("3) Listar reservas de clase preferente");
		System.out.println("4) Listas vuelos de la aerol�nea");
		System.out.println("5) Salir");
		System.out.print("Seleccione una opci�n: ");

		int opcion = Teclado.leerEntero("�Opci�n (0-4)? ");
		return opcion;
	}
	
	/**
	 * un menú para gestionar la aereolina "Los enlaces vueling", sobre la que
	 * puedes dar de alta vuelos, añadirles reservas, y listar los vuelso y reserva
	 * @param args
	 */
	public static void main(String[] args) {
		Aereolinea aereolinea = new Aereolinea("Los Enlaces Vueling");
		int opcion;
		do {			
			opcion = escribirMenuOpciones();
			switch (opcion) {
			case 1:
				int numAsientos = Teclado.leerEntero( "Ingrese n�mero de asientos del vuelo: ");
				Vuelo altaVuelo = new Vuelo(numAsientos);
				if (aereolinea.altaVuelo(altaVuelo)) {
					System.out.println("Se ha dado de alta un nuevo vuelo");
				} else {
					System.out.println("Se ha dado de alta un vuelo sobreescribiendo el vuelo anterior");
				}
				break;
			case 2:				
				int idVuelo = Teclado.leerEntero("Ingrese ID del vuelo:");
				String dniReserva = Teclado.leerCadena("DNI: ");
				String tipoReserva = Teclado.leerCadena("Tipo de reserva (Preferente | Turista): ");
				try {
					boolean anadido = false;
					if (tipoReserva.equalsIgnoreCase("preferente")) {
						int numMaletasReserva = Teclado.leerEntero("Numero de maletas: ");
						boolean equipajeManoReservaP = Teclado.leerBooleano("Lleva equipaje de mano? ");
						boolean comidaReserva = Teclado.leerBooleano("Querrá una comida? ");
						ReservaAsiento rap = new ReservaPreferente(dniReserva, numMaletasReserva, equipajeManoReservaP, comidaReserva);
						anadido = aereolinea.anadirReserva(idVuelo, rap);
					} else if (tipoReserva.equalsIgnoreCase("turista")) {
						boolean equipajeManoReservaP = Teclado.leerBooleano("Lleva equipaje de mano? ");
						ReservaAsiento rap = new ReservaTurista(dniReserva, equipajeManoReservaP);
						anadido = aereolinea.anadirReserva(idVuelo, rap);
					} else {
						System.out.println("Error: Tipo de reserva no válido.");
					}
					
					if (anadido) {
						System.out.print("Reserva añadida con éxito");
					} else {
						System.out.print("Ya existe una reserva con ese DNI en ese vuelo");
					}

				} catch (ExcepcionVuelo e) {
					System.out.println(e.getMessage());
				} catch (ExcepcionReserva e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				int idVuelo2 = Teclado.leerEntero("Ingrese ID del vuelo:");
				try {
					TreeSet<ReservaPreferente> listadoPreferente = aereolinea.listarReservasPreferentes(idVuelo2);
					if (listadoPreferente.isEmpty()) {
						System.out.print("No hay reservas preferentes con el precio mayor a 300€ en ese vuelo");
					} else {
						System.out.println(listadoPreferente);
					}
				} catch (ExcepcionVuelo e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 4:
				System.out.println(aereolinea);
				break;
			case 5:
				System.out.println("Saliendo...");
				return;
			default:
				System.out.println("Opci�n inv�lida. Intente de nuevo.");
			}						
		} while (opcion != 0);
		
		System.out.println("Programa finalizado sin errores.");

	}
}
