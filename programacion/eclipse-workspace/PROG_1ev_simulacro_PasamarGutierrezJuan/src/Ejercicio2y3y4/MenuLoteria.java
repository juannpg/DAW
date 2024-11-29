package Ejercicio2y3y4;
import entrada.Teclado;


public class MenuLoteria {
	/**
	 * muestra un menu de 4 opciones y lo repite hasta que el usuario elige una opcion valida
	 * @return
	 */
	 public static int menu() {	
        int opcion;
        final int MAX_OPCIONES = 3;
        do {
            System.out.println("\n(0) Salir del programa.\n" +
                    "(1) Celebración sorteo\n" +
                    "(2) Mostrar todos los sorteos celebrados\n" +
                    "(3) Comprobar aciertos en el sorteo de la lotería por fecha\n" +
                    "Marcar opciones del 1 al 3");

            opcion = Teclado.leerEntero("¿Opcion (0-3? ");
            if (opcion < 0 || opcion > MAX_OPCIONES) {
                System.out.println("la opcion debe estar entre 0 y 3");
            }
        } while (opcion < 0 || opcion > MAX_OPCIONES);
        return opcion;
    }
	 
	/**
	 * crea un vector de loteria donde almacenaremos sorteos. ofrece el menu al usuario y hace distintas acciones
	 * @param args
	 */
	public static void main(String[] args) {
		final int CAPACIDAD = 20;
		Loteria loteria = new Loteria(CAPACIDAD);
		
		int opcion;
		
		do {
			opcion = menu();
			
			switch (opcion) {
			case 1:
				String fechaCelebrar = Teclado.leerCadena("Escriba una fecha con formato dd/mm/yyyy: ");
				
				Primitiva primitiva = new Primitiva(fechaCelebrar);
				if (loteria.añadir(primitiva)) {
					System.out.println("Nuevo sorteo almacenado:");
					primitiva.toString();
				} else {
					System.out.println("Error al celebrar el sorteo");
				}
				break;
				
			case 2:
				System.out.println(loteria.toString());
				break;
				
			case 3:
				String fechaComprobar = Teclado.leerCadena("Escriba una fecha con formato dd/mm/yyyy: ");				
				
				final int LIMITE = 6;
				int[] boletoUsuario = Primitiva.leeBoletoUsuario(LIMITE);
				int comprobar = loteria.comprobar(fechaComprobar, boletoUsuario);
				
				if (comprobar != -1) {
					System.out.println("Número de aciertos: " + comprobar);
				} else {
					System.out.println("No existe tal fecha.");
				}
				break;
				
			default:
				System.out.println("La opción debe estar entre 0 y 3");
			}
		} while (opcion != 0);
	}
}
