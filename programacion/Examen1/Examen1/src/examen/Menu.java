package examen;

import entrada.Teclado;

public class Menu {
    public static int menu() {
        int opcion;
        do {
            System.out.println("\n(0) Salir del programa.\n" +
                    "(1) TEXTO.\n" +
                    "(2) TEXTO.\n" +
                    "(3) TEXTO.\n");

            opcion = Teclado.leerEntero("Opción: ");
            if (opcion < 0 || opcion > 3) {
                System.out.println("la opcion debe estar entre 0 y 3");
            }
        } while (opcion < 0 || opcion > 3);
        return opcion;
    }
    
    public static void main(String[] args) {
    	int opcion;
    	
    	do {
    		opcion = menu();
    		
    		switch (opcion) {
    		case 1:
    			
    			break;
    		case 2:
    			
    			break;
    		default:
    			
    		}
    	} while (opcion != 0);
    }
}
