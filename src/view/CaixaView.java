package view;

import models.Caixa;

public class CaixaView {

    Caixa caixa;
    public CaixaView(Caixa caixa) {
        this.caixa = caixa;
    }

    public void exibeVendas(int idCaixa) {
        System.out.println("Caixa: " +idCaixa + "fez venda, o saldo agora é: " + caixa.getSaldoCentral());
    }

    public void exibirResultadoFinal(double saldoFinal) {
        System.out.println("=== VENDAS ENCERRADAS ===");
        System.out.printf("Saldo final acumulado no caixa central: R$ %,.2f%n", saldoFinal);
    }
}