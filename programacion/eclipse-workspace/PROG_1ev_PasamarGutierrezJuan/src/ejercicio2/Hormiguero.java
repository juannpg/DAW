package ejercicio2;

public class Hormiguero {
	private Obrera[] vectorObreras;
	private int numElementos;
	
	/**
	 * constructor que crea la clase como un vector de hormigas proporcionado por parametros
	 * @param numMaximo
	 */
	public Hormiguero(int numMaximo) {
		this.vectorObreras = new Obrera[numMaximo];
		this.numElementos = 0;
	}
	
	public String toString() {
		String resultado = "Hormiguero [hormigas=";
		for (int i = 0; i < this.numElementos; i++) {
			if (i != this.numElementos - 1) {
				resultado.concat(this.vectorObreras[i].toString() + ", ");
			}
			resultado.concat(this.vectorObreras[i].toString());
		}
		resultado.concat("]");
		
		return resultado;
	}
	
	/**
	 * añade siempre y cuando el vector no esté lleno la hormiga por parametros
	 * en la primera posicion no nula
	 * @param obrera
	 * @return
	 */
	public boolean añadir(Obrera obrera) {
	    boolean insertado = false;
	    
        if (this.numElementos < this.vectorObreras.length) {
            this.vectorObreras[this.numElementos] = obrera;
            this.numElementos++;
            insertado = true;
        }

	    return insertado;
	}
	
	/**
	 * por cada hormiga en el vector consigue comida en un día pasado por parametros
	 * @param diaSemana
	 */
	public void conseguirComida(int diaSemana) {
		for (int i = 0; i < this.numElementos; i++) {
			this.vectorObreras[i].conseguirComida(diaSemana);
		}
	}
	
	/**
	 * devuelve toda la comida acumulada en el homriguero
	 * @return
	 */
	public int comidaAcumulada() {
		int acumulada = 0;
		
		for (int i = 0; i < this.numElementos; i++) {
			acumulada += this.vectorObreras[i].totalAcumulada();
		}
		
		return acumulada;
	}
	
	/**
	 * devuelve la hormiga u hormigas que más comida han acumulado
	 * @return
	 */
	public String[] maximaProduccion() {
		int contadorMaximas = 1;
		
		Obrera mayor = this.vectorObreras[0];
		for (int i = 1; i < this.numElementos; i++) {
			if (this.vectorObreras[i].totalAcumulada() >= mayor.totalAcumulada()) {
				mayor = this.vectorObreras[i];
				contadorMaximas++;
			}
		}
		
		String[] mayores = new String[contadorMaximas];
		for (int i = 0; i < this.numElementos; i++) {
			boolean añadido = false;
			for (int j = 0; j < contadorMaximas && !añadido; j++) {
				if (this.vectorObreras[i].totalAcumulada() >= mayor.totalAcumulada() && mayores[j] == null) {
					mayor = this.vectorObreras[i];
					mayores[j] = this.vectorObreras[i].toString();
					añadido = true;
				}
			}
		}
		
		return mayores;
	}
	
	public int getNumElementos() {
		return this.numElementos;
	}
}
