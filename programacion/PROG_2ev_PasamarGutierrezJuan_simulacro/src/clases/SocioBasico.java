package clases;

public class SocioBasico extends Socio {
    private static final String[] TURNOS = { "M", "T", "MD" };

    public String turno;
    public boolean taquilla;

    public SocioBasico(String dni, String nombre, int edad, int cuentaBancaria, boolean entrenador, DatosEntrenamiento datosEntrenamiento, String turno, boolean taquilla) {
        // si el turno no es valido error
        super(dni, nombre, edad, cuentaBancaria, entrenador, datosEntrenamiento);
        this.turno = turno;
        this.taquilla = taquilla;
    }

    @Override
    public String toString() {
        return "clases.SocioBasico{" + "\n" +
                "\tturno='" + turno + '\'' + "\n" +
                "\ttaquilla=" + taquilla + "\n" +
                "} " + super.toString();
    }

    @Override
    public double calcularCuotaMensual() {
        double cuota = 0;
        if (this.edad > 65) {
            if (this.turno.equals("M")) {
                cuota = 25;
            } else if (this.turno.equals("T")) {
                cuota = 30;
            } else {
                cuota = 20;
            }
        } else {
            if (this.turno.equals("M")) {
                cuota = 35;
            } else if (this.turno.equals("T")) {
                cuota = 40;
            } else {
                cuota = 30;
            }
        }

        if (this.taquilla) {
            cuota +=2;
        }

        if (this.entrenador) {
            cuota += this.datosEntrenamiento.getDuracionTotal() * 40;
        }

        return cuota;
    }
}
