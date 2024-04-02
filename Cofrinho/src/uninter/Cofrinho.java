package uninter;

//IMPORTAÇÕES
import java.util.ArrayList;
import java.util.List;

public class Cofrinho {
    private List<Moeda> moedas;

    //CONSTRUTOR	
    public Cofrinho() {
        moedas = new ArrayList<>();
    }

    public void addMoeda(Moeda moeda) {
        moedas.add(moeda);
    }

    public void removerMoeda(int indice) {
    	//verifica se o índice é válido
        if (indice >= 0 && indice < moedas.size()) {
            moedas.remove(indice);
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public void listarMoedas() {
        System.out.println("Moedas no cofrinho:");
        for (int i = 0; i < moedas.size(); i++) {
        	//Imprime o índice + string que representa a moeda
            System.out.println((i + 1) + ". " + moedas.get(i));
        }
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Moeda moeda : moedas) {
        	// Soma os valores de todas as moedas na lista
            total += moeda.getValor();
        }
        return total;
    }

    public List<Moeda> getMoedas() {
        return moedas;
    }
}
