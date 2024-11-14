package persona;

public class Persona {
	protected String nombre;
	protected String apellidos;
	protected int anyoNacimiento;
	
	public Persona() {}

	public Persona(String nombre, String apellidos, int anyoNacimiento) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.anyoNacimiento = anyoNacimiento;
	}
	
	public void imprime() {
		System.out.println("Datos personales: " + nombre
						+ " " + apellidos + " " + anyoNacimiento);
	}
}
