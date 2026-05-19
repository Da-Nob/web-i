package questoes.q7;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        
        System.out.print("Escolha uma opcao: ");
        System.out.println("1 Cadastrar ");
        System.out.println("2 Consultar: ");
        System.out.println("3 Atualizar: ");
        System.out.println("4 Excluir: ");

        int op = ip.nextInt();

        switch (op) {
            case 1:
                System.out.println("Escolheu cadstrao");
                break;
            case 2:
                System.out.println("Escolheu consultar");
                break;
            case 3:
                System.out.println("Escolheu atualizar");
                break;
            case 4:
                System.out.println("Escolheu excluir");
                break;
            default:
                System.out.println("valor invalido");
                break;
        }
    }
}
