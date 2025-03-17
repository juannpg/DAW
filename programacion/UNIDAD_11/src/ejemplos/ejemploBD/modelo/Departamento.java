package ejemplos.ejemploBD.modelo;
public class Departamento {
	private int codigo;
	private String nombre;
	private String ubicacion;
	
	public Departamento(int codigo, String nombre, String ubicacion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return "Departamento{" +
				"codigo=" + codigo +
				", nombre='" + nombre + '\'' +
				", ubicacion='" + ubicacion + '\'' +
				'}';
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
