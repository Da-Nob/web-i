package questoes.q3;

import java.util.Scanner;

public class Fatorial {
    public static void main(String[] args) {

        Scanner ip = new Scanner(System.in);

        System.out.print("Digite um nuero: ");
        int numero = ip.nextInt();

        int resul = 1;
        int index = numero;

        while (index > 0) {
            resul *= index;
            index--;
        }
        System.out.print(resul);
    }
}
