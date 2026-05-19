package questoes.q5;

import java.util.Scanner;

public class MaiorEMenor {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int maior = 0;
        int menor = 0;
        boolean primeiro = true;
        while (true) {
            System.out.print("Digite alguns numero [-1 para parar]: ");
            int numero = ip.nextInt();

            if(numero < 0) {
                break;
            }

            if (primeiro) {
                menor = numero;
                maior = numero;
                primeiro = false;
            } else {
                if (numero < menor) {
                    menor = numero;
                }

                if (numero > maior) {
                    maior = numero;
                }
            }



            
        }

        System.out.printf("O maior numero digitado foi %d%n e o menor numero digitado foi %d", maior, menor);
    }
}
