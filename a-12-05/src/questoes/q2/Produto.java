package questoes.q2;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco > 0 ? preco : 0;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade > 0 ? quantidade : 0;
    }

    public double getValorEstoque() {
        return quantidade * preco;
    }

    public void getInfos() {
    System.out.println("Nome: " + getNome());
    System.out.printf("Preço: R$ %.2f%n", getPreco());
    System.out.println("Quantidade: " + getQuantidade());
    System.out.printf("Valor estoque: R$ %.2f%n", getValorEstoque());
}

}
