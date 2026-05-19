package questoes.q8;

public class TesteRetangulo {
    public static void main(String args[]) {
        Retangulo r1 = new Retangulo(12.50, 42.55);

        System.out.printf("A area é %.2f%n", r1.area());

        System.out.printf("o perimetro é: %.2f", r1.perimetro());
    }
}
