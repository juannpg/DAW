package persona;

public class Prueba {
	public static void main(String[] args) {
		Persona vecina = new Persona("Luisa", "Gutiérrez", 19780);
		Alumno juan = new Alumno("Juan", "Pasamar Gutiérrez", 2006);
		
		vecina.imprime();
		juan.imprime();
		
		juan.ponGrupo("DAW", 'T');
		juan.imprimeGrupo();
	}
}
