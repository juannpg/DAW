package principal;
import entrada.Teclado;

public class GestionPrincipal {

	/**
	 * Visualiza en consola el menú de opciones del programa principal.
	 */
	public static void escribirMenuOpcionesPrincipal() {
		System.out.println();
		System.out.println("*********** MENÚ PRINCIPAL ***********");
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Exportar las clases a fichero de texto"); 
		System.out.println("(2) Sacar billete"); 
		System.out.println("(3) Actualizar viajero"); 
		System.out.println("(4) Consultar viajeros en estación y día"); 
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int opcion;
		do {
			escribirMenuOpcionesPrincipal();
			opcion = Teclado.leerEntero("Opción?");
			switch (opcion) {
			// Salir del programa.
			case 0:
				System.out.println("Finalizando programa.");
				break;
				
			// TODO: Exportar las clases a fichero de texto.
			case 1:
				System.out.println("\n*********** EXPORTAR TABLA CLASE A FICHERO ***********");
				break;
								
			// TODO: Sacar un billete
			case 2:
				System.out.println("\n*********** SACAR BILLETE ***********");
				break;
			
			// TODO: Actualizar viajero
			case 3:
				System.out.println("\n*********** ACTUALIZAR VIAJERO ***********");				
				break;
				
			// TODO: Consultar viajeros en estación y día
			case 4:
				System.out.println("\n*********** CONSULTAR VIAJEROS EN ESTACIÓN Y DÍA ***********");				
				break;
						 
			default:
				System.out.println("La opción de menú debe estar comprendida entre 0 y 4.");
			}
		}
		while (opcion != 0);
	}
}
