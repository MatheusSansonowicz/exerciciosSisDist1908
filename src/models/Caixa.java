package models;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Caixa {

    private double saldoCentral = 0;
    private final Lock saldoLock = new ReentrantLock();

    public  Caixa() {}

    public double getSaldoCentral() {
        return saldoCentral;
    }

    public void setSaldoCentral(double saldoCentral) {
        this.saldoCentral = saldoCentral;
    }

    public Lock getSaldoLock() {
        return saldoLock;
    }

    public double registrarVendaFicha(double valor) {
        saldoLock.lock();
        try {
            this.saldoCentral += valor;
            return this.saldoCentral;
        } finally {
            saldoLock.unlock();
        }
    }
}
