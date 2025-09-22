import java.util.Scanner;

public class Ex1029 {
    public static class FibonnaciRecursivo{
        public int valorCalculado;
        public int resultado;
        private int calls;

        public FibonnaciRecursivo(int valorCalculado){
            this.valorCalculado = valorCalculado;
            this.resultado = seqFib(valorCalculado);
        }

        public int getCalls(){
            return calls-1;
        }

        public int seqFib(int valor){
            calls++;
            if (valor == 0){
                return 0;
            } else if (valor == 1) {
                return 1;
            }
            return seqFib(valor-1) + seqFib(valor-2);
        }
    }

    public static class Vetor{
        FibonnaciRecursivo[] vetor;
        int capacidade;
        int n_elementos;

        public Vetor(int capacidade){
            this.capacidade = capacidade;
            this.vetor = new FibonnaciRecursivo[capacidade];
            n_elementos = 0;
        }

        public boolean vetorCheio(){
            return n_elementos == capacidade;
        }

        public void addElementoFinal(FibonnaciRecursivo elemento){
            if (vetorCheio()){
                System.out.println("Vetor está na capacidade máxima");
                return;
            }
            vetor[n_elementos] = elemento;
            n_elementos++;
        }

        public void imprimirVetor(){
            for(int i = 0; i < capacidade; i++){
                System.out.println("fib(" + vetor[i].valorCalculado + ") = " + vetor[i].getCalls() + " " + "calls = " +  vetor[i].resultado );
            }
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int qtdNum = scan.nextInt();
        Vetor vetor = new Vetor(qtdNum);
        for (int i = 0; i < qtdNum; i++){
            vetor.addElementoFinal(new FibonnaciRecursivo(scan.nextInt()));
        }
        vetor.imprimirVetor();
    }
}
