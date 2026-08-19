package controller;

import models.Caixa;
import view.CaixaView;

public class CaixaController {

    private final Caixa caixa;
    private final CaixaView view;
    private static final int numero_caixas = 5;
    private static final int fichas_caixa= 1000;
    private static final double valor_ficha = 10.0;

    public CaixaController(Caixa caixa, CaixaView view) {
        this.caixa = caixa;
        this.view = view;
    }

    public void iniciar_vendas() {
        Thread[] threadsCaixas = new Thread[numero_caixas];

        for (int i = 0; i < numero_caixas; i++) {
            final int idCaixa = i + 1;
            threadsCaixas[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < fichas_caixa; j++) {
                       caixa.registrarVendaFicha(valor_ficha);
                       view.exibeVendas(idCaixa);
                    }
                }
            }, "Thread-Caixa-" + idCaixa);
            threadsCaixas[i].start();
        }

        for (Thread t : threadsCaixas) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.err.println("Thread interrompida: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        view.exibirResultadoFinal(caixa.getSaldoCentral());
    }

}
