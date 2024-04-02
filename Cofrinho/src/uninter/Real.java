package uninter;

public class Real extends Moeda {
    public Real(double valor) {
        super(valor);
    }

    @Override
    public String toString() {
        return "R$" + String.format("%.2f", valor);
    }
}
