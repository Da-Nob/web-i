package questoes.q6;

public class Operacoes {
    public static void main(String args[]) {
        ContaBancaria c1 = new ContaBancaria("12eyr", 100);

        System.out.println("Saldo atual: " + c1.consultarSaldo());

        c1.depositar(100);

        System.out.println("Saldo atual: " + c1.consultarSaldo());

        c1.sacar(200);

        System.out.println("Saldo atual: " + c1.consultarSaldo());
    }
}
