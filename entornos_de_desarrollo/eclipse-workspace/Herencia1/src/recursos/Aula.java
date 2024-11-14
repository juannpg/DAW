package recursos;

public class Aula extends Recurso {
	private String localizacion;
	
	public Aula(String nombre, String descripcion, String localizacion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.localizacion = localizacion;
	}
	
	public String decirLocalizacion() {
		return this.localizacion;
	}
}
