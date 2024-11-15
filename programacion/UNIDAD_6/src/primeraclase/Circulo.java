package primeraclase;

public class Circulo {

    // Atributos
    private double radio;
    // Ojo, String siempre en Mayuscula porque no es primitivo sino es clase
    private String color;

    /**
     * Constructor vacío
     */
    public Circulo() {
        radio=0;
        color="";
    }

    /**
     * Constructor con radio
     * @param rad
     */
    public Circulo(double rad){
        radio = rad;
        // El círculo se crea sin color
        color = "";
    }

    /**
     * Constructor con color sin radio
     * @param rad
     */
    public Circulo(String col){
        radio = 0;
        // El círculo se crea sin color
        color = col;
    }

    /**
     * Constructor con radio y color
     * @param rad
     */
    public Circulo(double rad, String col){
        radio = rad;
        color = col;
    }


    /**
     *
     * @return
     */
    public double getRadio(){ // obtiene el radio
        return radio; // retorna el radio
    }

    /**
     *
     * @param valor
     */
    public void setRadio(double valor){ // pone el valor del radio
        radio = valor;
    }

    /**
     *
     * @return
     */
    public String getColor(){
        return color;
    }

    /**
     *
     * @param valor
     */
    public void setColor(String valor) {
        color = valor;
    }

    /**
     * Calcula el area del circulo
     */
    public double calcularArea(){
        return Math.PI * radio * radio;
    }

    /**
     * Calcula el perimetro del circulo
     */
    public double calcularPerimetro(){
        return Math.PI * 2 * radio;
    }

    /**
     * Saca por pantalla un circulo
     */
    public String toString() {
        return "Circulo [radio=" + radio + ", color=" + color + "]";
    }

}
