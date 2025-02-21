package clases;

public class SocioPremium extends Socio {
    private boolean carnetDeEstudiante;

    public SocioPremium(String dni, String nombre, int edad, int cuentaBancaria, boolean entrenador, DatosEntrenamiento datosEntrenamiento, boolean carnetDeEstudiante) {
        super(dni, nombre, edad, cuentaBancaria, entrenador, datosEntrenamiento);
        this.carnetDeEstudiante = carnetDeEstudiante;
    }

    @Override
    public String toString() {
        return " SocioPremium" + "\n" +
                "\t\tcarnetDeEstudiante=" + carnetDeEstudiante + "\n" +
                 super.toString();
    }

    @Override
    public double calcularCuotaMensual() {
        double cuota = 0;
        if (this.edad > 65) {
            cuota = 40;
        } else {
            cuota = 60;
        }

        if (this.carnetDeEstudiante) {
            cuota -= cuota * 0.1;
        }

        if (this.entrenador) {
            cuota += this.datosEntrenamiento.getDuracionTotal() * 35;
        }

        return cuota;
    }
}
