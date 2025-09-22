import java.util.Scanner;

public class Ex1178 {
    private static class Nodo {
        public float elemento;
        public Nodo proximo;

        public Nodo(float elemento) {
            this.elemento = elemento;
            this.proximo = null;
        }
    }

    private Nodo primeiro;
    private Nodo ultimo;
    private int n_elementos;

    public Ex1178() {
        this.primeiro = null;
        this.ultimo = null;
        this.n_elementos = 0;
    }

    public float divisaoRecursiva(float valor){
        if (valor == 0) {
            insereFinal(valor);
            return 0;
        }
        insereFinal(valor);
        return divisaoRecursiva(valor/2);
    }

    public void insereFinal(float elemento) {
        Nodo novoNodo = new Nodo(elemento);
        if (ultimo == null) {
            primeiro = novoNodo;
            ultimo = novoNodo;
        } else {
            ultimo.proximo = novoNodo;
            ultimo = novoNodo;
        }
        n_elementos++;
    }

    public void imprimirLista() {
        int i = 0;
        Nodo atual = primeiro;
        while (i <= 99) {
            System.out.printf("N[" + i + "] = " + "%.4f",atual.elemento);
            System.out.println();
            i++;
            atual = atual.proximo;
        }
    }

    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Ex1178 n =  new Ex1178();
    n.divisaoRecursiva(scan.nextFloat());
    n.imprimirLista();
    }
}
