package questoes.q10;

import java.util.Scanner;

public class TesteCalcukadora {
    public static void main(String args[]) {
        Scanner ip = new Scanner(System.in);

        System.out.print("digite o numero o primeiro numero: ");
        int n1 = ip.nextInt();

        System.out.print("digite o numero o segunfo numero: ");
        int n2 = ip.nextInt();

        Calculadora c1 = new Calculadora(n1, n2);

        System.out.println("a soma é: " + c1.somar(n1, n2));
        System.out.println("a subtracao é: " + c1.subtrair(n1, n2));
        System.out.println("a multiplicacao é: " + c1.multiplicar(n1, n2));
        System.out.print("a divisao é: " + c1.dividir(n1, n2));
    }
}
