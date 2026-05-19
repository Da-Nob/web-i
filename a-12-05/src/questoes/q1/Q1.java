package questoes.q1;

import java.util.Scanner;

public class Q1 {
    public static void executar(Scanner ip) {

        System.out.println("Qual sua idade? ");
        int idade = ip.nextInt();

        System.out.print(idade > 17 ? "maior" : "menor");
    }
}
