package examen;

public class CosasStrings {
	String cadena = "AABB";
	
	int posicion = cadena.indexOf('A');
	int ultimaPosicion = cadena.lastIndexOf('A');
	
	boolean empiezaCon = cadena.startsWith("A");
	boolean terminaCon = cadena.endsWith("a");
	
	String cadena2 = "";
	boolean iguales = cadena.equals(cadena2);
	
	String[] splitPorCadena = cadena.split("A");
	
	String splitPorIndex = cadena.substring(0, 2);

}
