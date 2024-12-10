public class Encantamiento extends Permanente{
    private Tierra tierraEncantada;

    public Encantamiento(Tierra tierraEncantada) {
        this.tierraEncantada = tierraEncantada;
    }

    public Tierra getTierraEncantada() {
        return this.tierraEncantada;
    }

    public void setTierraEncantada(Tierra nueva) {
        this.tierraEncantada = nueva;
    }
}
