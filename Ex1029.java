import java.util.Scanner;

public class Ex1029 {
    public static class FibonnaciRecursivo{
        private int valorCalculado;
        private int calls;

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
        int[] vetor;
        int capacidade;
        int n_elementos;

        public Vetor(int capacidade){
            this.capacidade = capacidade;
            this.vetor = new int[capacidade];
            n_elementos = 0;
        }

        public boolean vetorCheio(){
            return n_elementos == capacidade;
        }

        public void addElementoFinal(int elemento){
            if (vetorCheio()){
                System.out.println("Vetor está na capacidade máxima");
                return;
            }
            vetor[n_elementos] = elemento;
            n_elementos++;
        }

        public void imprimirVetor(){
            for(int i = 0; i < capacidade/3; i++){
                System.out.println("fib(" + vetor[i] + ")" + " " + vetor[i+1] + " " + "calls" + vetor[i+2]);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int qtdNum = scan.nextInt();
        Vetor vetor = new Vetor(qtdNum*3);
        for (int i = 0; i < qtdNum; i++) {
            FibonnaciRecursivo fib = new FibonnaciRecursivo();
            int numero = scan.nextInt();
            vetor.addElementoFinal(numero);
            vetor.addElementoFinal(fib.seqFib(numero));
            vetor.addElementoFinal(fib.getCalls());
        }
        vetor.imprimirVetor();
    }
}
