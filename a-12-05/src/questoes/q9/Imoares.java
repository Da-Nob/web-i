package questoes.q9;

import java.util.Scanner;

public class Imoares {
    public static void main(String args[]) {
        Scanner ip = new Scanner(System.in);

        System.out.print("Inicio: ");
        int ini = ip.nextInt();

        System.out.print("fim: ");
        int fim = ip.nextInt();

        int c = ini;
        int impares = 0;

        while (c <= fim) {
            
            if (c % 2 != 0) impares += 1;

            c+= 1;
        }

        System.out.println("Total de ímpares: " + impares);
    }
}
