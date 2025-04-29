/**
 *
 */
package modelo;

import java.util.ArrayList;

/**
 * @author alumno
 *
 */
public class Empresa {

	ArrayList <Trabajador> trabajadores;


	/**
	 * @param trabajadores
	 */
	public Empresa(ArrayList<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}

	/**
	 * Comprueba si un trabajador est� en la lista
	 * @param t
	 * @return
	 */
	public boolean esta(Trabajador t){
		for(int i=0; i<trabajadores.size(); i++){
			if(trabajadores.get(i).getIdentificador() == t.getIdentificador()){
				return true;
			}
		}
		return false;
	}

	/**
	 * Devuelve la posici�n en la que se encuentra un trabajador
	 * busc�ndolo por dni
	 * @return
	 */
	public int devolverPosicion(String identificador){
		for(int i=0; i<trabajadores.size(); i++){
			if (trabajadores.get(i).getIdentificador().equals(identificador)){
				return i;
			}
		}
		return -1;
	}

	/**
	 * Si el trabajador no est� en la lista, lo a�ade
	 * @param t
	 */
	public boolean altaTrabajador(Trabajador t){
		if(!esta(t)){
			trabajadores.add(t);
			return true;
		}
		else return false;
	}
	/**
	 * Da de baja un trabajador busc�ndolo por c�digo
	 */
	public boolean bajaTrabajador(String identificador){
		int posicion = devolverPosicion(identificador);
		if(posicion > -1){
			trabajadores.remove(posicion);
			return true;
		}
		else return false;
	}
	/**
	 * Devuelve un trabajador
	 * @return
	 */
	public Trabajador buscarTrabajador(String identificador){
		for(int i=0; i<trabajadores.size(); i++){
			if(trabajadores.get(i).getIdentificador().equals(identificador)) {
				return( trabajadores.get(i));
			}
		}
		return null;
	}
	/**
	 * Permite modificar el valor de los atributos de un objeto Trabajador
	 * @return
	 */
	public void modificarTrabajador(String identificador, String dni, String nombre, String apellidos, String direccion, String telefono, String puesto){
		int posicion = devolverPosicion(identificador);
		trabajadores.get(posicion).setDni(dni);
		trabajadores.get(posicion).setNombre(nombre);
		trabajadores.get(posicion).setApellidos(apellidos);
		trabajadores.get(posicion).setDireccion(direccion);
		trabajadores.get(posicion).setTelefono(telefono);
		trabajadores.get(posicion).setPuesto(puesto);
	}

	/**
	 * Devuelve una matriz que se utilizar� para listar los trabajadores
	 * @return
	 */
	public String[][] listarTrabajadores(){
		String [][] datos = new String[trabajadores.size()][7];
		for (int i=0; i<trabajadores.size(); i++){
			String[] fila = new String [7];

			fila[1] = trabajadores.get(i).getDni();
			fila[2] = trabajadores.get(i).getNombre();
			fila[3] = trabajadores.get(i).getApellidos();
			fila[4] = trabajadores.get(i).getDireccion();
			fila[6] = trabajadores.get(i).getPuesto();

			datos[i] = fila;
		}
		return datos;
	}

	public ArrayList<Trabajador> getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}
}
