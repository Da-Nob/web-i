package questoes.q6;

public class ContaBancaria {
    private String numero;
    private double saldo;

    public ContaBancaria(String numero, double saldo) {
        this.numero = numero;
        setSaldo(saldo);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo > 0 ? saldo : 0;
    }

    public void depositar(double deposito) {
        if (deposito > 0) saldo += deposito;
        else throw new Error("nao deposita 0");
    }

    public void sacar(double saque) {
        if (saldo > 0 && saldo >= saque) saldo -= saque;
        else throw new Error("nao saca 0");
    }

    public double consultarSaldo() {
        return saldo > 0 ? this.saldo : 0;
    }
}
