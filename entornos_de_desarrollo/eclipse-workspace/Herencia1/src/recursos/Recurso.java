package recursos;

public class Recurso {
	protected String nombre;
	protected String descripcion;
	
	public Recurso() {}
	public Recurso(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public String decirNombre() {
		return this.nombre;
	}
	
	public String decirDescripcion() {
		return this.descripcion;
	}
}
