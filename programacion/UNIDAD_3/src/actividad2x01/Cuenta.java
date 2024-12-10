package actividad2x01;

public class Cuenta {
    private int numero;
    private String cliente;
    private double saldo;

    /**
     * constructor con saldo a 0
     * @param numero
     * @param cliente
     */
    public Cuenta(int numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0;
    }

    /**
     * devuelve el estado de la cuenta  con formato
     * @return
     */
    public String obtenerEstado() {
        return "[Cuenta numero " + this.numero + " de " + this.cliente +
                " con saldo " + String.format("%.2f", this.saldo) + "]";
    }

    /**
     * ingresa una cantidad en la cuenta
     * @param importe
     * @return
     */
    public boolean ingresar(double importe) {
        boolean realizado = false;

        if (importe > 0) {
            this.saldo += importe;
            realizado = true;
        }

        return realizado;
    }

    /**
     * retira una cantidad de la cuenta
     * @param importe
     * @return
     */
    public boolean retirar(double importe) {
        boolean realizado = false;

        if (importe > 0 && importe <= this.saldo) {
            this.saldo -= importe;
            realizado = true;
        }

        return realizado;
    }

    /**
     * transfiere una cantida de la cuenta a otra cuenta
     * @param importe
     * @param cuentaDest
     * @return
     */
    public boolean transferir(double importe, Cuenta cuentaDest) {
        boolean realizado = false;

        if (importe > 0 && importe <= this.saldo) {
            this.saldo -= importe;
            cuentaDest.saldo += importe;
            realizado = true;
        }

        return realizado;
    }
}
