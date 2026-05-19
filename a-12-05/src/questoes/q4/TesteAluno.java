package questoes.q4;

public class TesteAluno {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("Daniel", 10);

        System.out.printf("O conceito do aluno %s, é %s" , a1.getNome(), a1.getConceito(10));
    }
}
