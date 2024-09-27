package ejemplos;

public class Conversiones {
	
	public static void main(String[] args) {
		
		// Conversi�n entre tipos de datos primitivos
		// Escala mayor a menor: 1. Double 2. Float 3. Long 4. Int 5. Short 6. Byte
		
		/* Reglas:
			short, int, long, float, double = byte
     		int, long, float, double = short
        	int, long, float, double = char
        	long, float, double = int
        	float, double = long
        	double = float 
         */
		
		// Asignar a un tipo de dato grande uno m�s peque�o -> directa
        int big = 1234567890;
        double largo = big;
        System.out.println("Integer: " + big + "\n");
        System.out.println("Largo: " + largo + "\n");
        
        ////////////////////
        
        // Asignar a un tipo de dato peque�o otro m�s grande --> cast + p�rdida de informaci�n
        big = 1234567890;
        short corto = (short) big;
        System.out.println("Integer: " + big + "\n");
        System.out.println("Corto: " + corto + "\n");
        
        float n = 100.04f;
        int k = (int) n;
        System.out.println("Float: " + n + "\n");
        System.out.println("Integer: " + k + "\n");
    }


}
