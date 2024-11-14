package persona;

public class Alumno extends Persona {
	protected String grupo;
	protected char horario;
	
	public Alumno() {}

	public Alumno(String nombre, String apellidos, int anyoNacimiento) {
		super(nombre, apellidos, anyoNacimiento);
	}
	
	public void ponGrupo(String grupo, char horario) {
		if (grupo == null || grupo.length() == 0) {
			System.out.println("Grupo no válido");
		} else if (horario != 'M' && horario != 'T') {
			System.out.println("Horario no válido");
		} else {
			this.grupo = grupo;
			this.horario = horario;
		}
	}
	
	public void imprimeGrupo() {
		System.out.println("Grupo " + grupo + horario);
	}
}
