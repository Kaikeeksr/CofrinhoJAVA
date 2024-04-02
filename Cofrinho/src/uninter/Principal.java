//MAIN

package uninter;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cofrinho cofrinho = new Cofrinho();

        // MENU
        int op;
        do {
            System.out.println("COFRINHO!");
            // Menu de opções
            System.out.println("1 - Adicionar moeda");
            System.out.println("2 - Remover moeda");
            System.out.println("3 - Listar todas as moedas");
            System.out.println("4 - Calcular valor total");
            System.out.println("0 - Encerrar");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    addMoeda(cofrinho, scanner);
                    break;
                case 2:
                    removerMoeda(cofrinho, scanner);
                    break;
                case 3:
                    cofrinho.listarMoedas();
                    break;
                case 4:
                    // Calculando o valor total em Real de todas as moedas
                    double totalReal = 0;
                    for (Moeda moeda : cofrinho.getMoedas()) {
                        if (moeda instanceof Real) {
                            totalReal += moeda.getValor();
                        } else if (moeda instanceof Dolar) {
                            totalReal += ((Dolar) moeda).converterParaReal();
                        } else if (moeda instanceof Euro) {
                            totalReal += ((Euro) moeda).converterParaReal();
                        }
                    }
                    System.out.println("Valor total em Real: R$" + String.format("%.2f", totalReal));
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (op != 0);
    }

    public static void addMoeda(Cofrinho cofrinho, Scanner scanner) {
        System.out.println("Escolha a moeda a ser adicionada:");
        System.out.println("1 - Real");
        System.out.println("2 - Dólar");
        System.out.println("3 - Euro");

        int escolha = scanner.nextInt();
        double valor;

        // Solicita valor da moeda a ser adicionada
        switch (escolha) {
            case 1:
                System.out.println("Digite o valor da moeda em reais:");
                valor = scanner.nextDouble();
                break;
            case 2:
                System.out.println("Digite o valor da moeda em dólares:");
                valor = scanner.nextDouble();
                break;
            case 3:
                System.out.println("Digite o valor da moeda em euros:");
                valor = scanner.nextDouble();
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        // Cria objeto de moeda baseado na escolha do usuário
        Moeda moeda;

        switch (escolha) {
            case 1:
                moeda = new Real(valor);
                break;
            case 2:
                moeda = new Dolar(valor);
                break;
            case 3:
                moeda = new Euro(valor);
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }
        cofrinho.addMoeda(moeda);
        System.out.println("Moeda adicionada com sucesso!");
    }

    public static void removerMoeda(Cofrinho cofrinho, Scanner scanner) {
        // Remove moeda selecionada pelo usuário
        cofrinho.listarMoedas();
        System.out.println("Digite o número da moeda a ser removida:");
        int indice = scanner.nextInt() - 1;
        cofrinho.removerMoeda(indice);
        System.out.println("Moeda removida com sucesso!");
    }
}
