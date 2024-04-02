package uninter;

public class Euro extends Moeda {
    private static final double taxaDeCambioEuroParaReal = 5.43; // taxa de câmbio dia 01.04.2024

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public String toString() {
        return "€" + String.format("%.2f", valor);
    }

    public double converterParaReal() {
        return valor * taxaDeCambioEuroParaReal;
    }
}

