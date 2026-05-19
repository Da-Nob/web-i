package questoes.q8;

public class Retangulo {
    private double largura;
    private double altura;
    
    public Retangulo(double largura, double altura) {
        setLargura(largura);
        setAltura(altura);
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura > 0 ? largura : 0;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura > 0 ? altura : 0;
    }

    public double area() {
        return this.largura * this.altura;
    }

    public double perimetro() {
        return this.largura + this.largura + this.altura + this.altura;
    }

    
}
