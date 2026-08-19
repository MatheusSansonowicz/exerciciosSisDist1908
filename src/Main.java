import controller.CaixaController;
import models.Caixa;
import view.CaixaView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n--- MENU DE EXERCÍCIOS ---");
            System.out.println("Pressione 1 para exercicio 1;");
            System.out.println("Pressione 2 para exercicio 2;");
            System.out.println("Pressione 3 ou outro para sair;");
            System.out.print("Escolha uma opção: ");

            try {

                int opcao = sc.nextInt();

                switch (opcao) {

                    case 1:

                        System.out.println("Executando Exercício 1...");
                        Caixa caixa = new Caixa();
                        CaixaView view = new CaixaView(caixa);
                        CaixaController caixa_controller = new CaixaController(caixa, view);
                        caixa_controller.iniciar_vendas();
                        break;

                    case 2:

                        System.out.println("Executando Exercício 2...");

                        break;
                     default:
                        System.out.println("Encerrando o programa...");
                        rodando = false;
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Dígito inválido! Encerrando a aplicação.");
                rodando = false;
            }
        }
        sc.close();
    }
}