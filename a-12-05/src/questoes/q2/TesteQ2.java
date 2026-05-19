package questoes.q2;

public class TesteQ2 {
    public static void main(String[] args) {
        Produto p1 = new Produto("Cadeira", 18.99, 5);

        System.out.println(p1.getValorEstoque());
        p1.getInfos();
    }
}