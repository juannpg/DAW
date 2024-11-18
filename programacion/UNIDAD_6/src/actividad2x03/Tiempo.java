package actividad2x03;

public class Tiempo {
    private int horas;
    private int minutos;
    private int segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public String toString() {
        return "Tiempo{" +
                "horas=" + horas +
                ": minutos=" + minutos +
                ": segundos=" + segundos +
                '}';
    }

    public boolean sumar(Tiempo t) {
        if (this.horas + t.horas < 24 && this.minutos + t.minutos < 60 && this.segundos + t.segundos < 60) {
            this.horas += t.horas;
            this.minutos += t.minutos;
            this.segundos += t.segundos;
        }

        return this.horas < 24 && this.minutos < 60 && this.segundos < 60;
    }

    public boolean restar(Tiempo t) {
        if (this.horas - t.horas >= 0 && this.minutos - t.minutos >= 0 && this.segundos - t.segundos >= 0) {
            this.horas -= t.horas;
            this.minutos -= t.minutos;
            this.segundos -= t.segundos;
        }

        return this.horas >= 0 && this.minutos >= 0 && this.segundos >= 0;
    }

//    public boolean validar() {
//        return this.horas >= 0 && this.horas < 24 && this.minuthisos >= 0 && this.minuthisos < 60 && this.segundos >= 0 && this.segundos < 60;
//    }
}
