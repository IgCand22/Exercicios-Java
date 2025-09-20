import java.util.Scanner;

public class Ex1028 {
    public static class Recursivo{
        public int verificar(int maior, int menor){
            if(menor <= 0){
                return maior;
            }
            return verificar(menor, maior%menor);
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
            for(int i = 0; i < n_elementos; i++){
                System.out.println(vetor[i]);
            }
        }

    }

    public static void main(String[] args) {
        Recursivo n = new Recursivo();
        int maior;
        int menor;
        Scanner scan = new Scanner(System.in);
        Vetor vetor = new Vetor(scan.nextInt());
        for(int i = 0; i < vetor.capacidade; i++){
            int n1 = scan.nextInt();
            int n2 = scan.nextInt();

            if (n2 > n1){
                menor = n1;
                maior = n2;
            }
            maior = n1;
            menor = n2;

            vetor.addElementoFinal(n.verificar(maior, menor));
        }
        vetor.imprimirVetor();
    }
}
