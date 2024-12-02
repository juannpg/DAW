package ejercicio2;

import java.util.Arrays;

import entrada.Teclado;

public class Principal {
	/**
	 * se muestra un menu al usuario y se le deja introducir la opcion deseada
	 * hasta que esté en nuestro rango de opciones
	 * @return
	 */
    public static int menu() {
    	final int OPCION_MAXIMA = 4;
    	
        int opcion;
        do {
            System.out.println("\n(0) Salir del programa\n" +
                    "(1) Creación del hormiguero\n" +
                    "(2) Añadir homriga\n" +
                    "(3) Sacar hormigas a por comida\n" +
                    "(4) Buscar hormigas de máxima producción\n");

            opcion = Teclado.leerEntero("Elija una opción: ");
            if (opcion < 0 || opcion > OPCION_MAXIMA) {
                System.out.println("la opcion debe estar entre 0 y " + OPCION_MAXIMA);
            }
        } while (opcion < 0 || opcion > OPCION_MAXIMA);
        return opcion;
    }
    
    /**
     * consigue comida del hormiguero un numero de veces pasado por parametros cada dia de la semana
     * @param numVeces
     * @param hormiguero
     */
    public static void conseguirComida(int numVeces, Hormiguero hormiguero) {
    	for (int i = 0; i < 7; i++) {
    		for (int j = 0; j < numVeces; j++) {
    			hormiguero.conseguirComida(i);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	int opcion;
    	
    	Hormiguero hormiguero = null;
    	
    	do {
    		opcion = menu();
    		
    		switch (opcion) {
    		case 1:
    			// crear hormiguero con una capacidad introducida por teclado
    			int capacidadHormiguero = Teclado.leerEntero("Introduce el número de homrigas del hormiguero: ");
    			hormiguero = new Hormiguero(capacidadHormiguero);
    			System.out.println("Homriguero creado con capacidad para " + capacidadHormiguero + " hormigas.");
    			break;
    		case 2:
    			// insertar una hormiga en el hormiguero si está creado
    			if (hormiguero == null) {
    				System.out.println("Primero debe crear un hormiguero.");
    			} else {
    				Obrera obreraInsertar = new Obrera();
    				if (hormiguero.añadir(obreraInsertar)) {
    					System.out.println("Homriga añadida al hormiguero: " + obreraInsertar.toString());
    				} else {
    					System.out.println("No se pueden añadir más hormigas, el hormiguero está lleno.");
    				}
    			}
    			break;
    		case 3:
    			// sacar a las hormigas a por comida todos los días de la semana un numero de veces
    			if (hormiguero != null && hormiguero.getNumElementos() != 0) {
        			int numVeces = Teclado.leerEntero("Introduce el número de veces al día que hay que sacar a las hormigas: ");
        			conseguirComida(numVeces, hormiguero);
        			System.out.println(hormiguero.toString());
        			System.out.println("Comida total acumulada en el hormiguero: " + hormiguero.comidaAcumulada());
    			} else {
    				System.out.println("Primero debes crear un hormiguero y una hormiga.");
    			}
    			break;
    		case 4:
    			// mostrar la hormiga de máxima producción
    			if (hormiguero != null && hormiguero.getNumElementos() != 0) {
    				System.out.println(Arrays.toString(hormiguero.maximaProduccion()));
    			} else {
    				System.out.println("Primero debes crear un hormiguero y una hormiga.");
    			}
    			break;
    		default:
    		}
    	} while (opcion != 0);
    }
}
