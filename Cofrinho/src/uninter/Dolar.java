package uninter;

public class Dolar extends Moeda {
    private static final double taxaDeCambioDolarParaReal = 5.05; // taxa de câmbio dia 01.04.2024

    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public String toString() {
        return "US$" + String.format("%.2f", valor);
    }

    public double converterParaReal() {
        return valor * taxaDeCambioDolarParaReal;
    }
}