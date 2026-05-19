package questoes.q4;

public class Aluno {
    private String nome;
    private double nota;

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getConceito(double nota) {
        if (nota >= 9) return "A";
        else if (nota >= 7 || nota < 8.9) return "B";
        else return "C";
    }


}
