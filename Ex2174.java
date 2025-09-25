import java.util.Scanner;

public class Ex2174 {

    public static class Pokemon{
        String nome;

        public Pokemon(String nome){
            this.nome = nome;
        }
    }
    private Pokemon[] vetor;
    private int n_elementos;
    private int capacidade;

    public Ex2174(int capacidade) {
        this.capacidade = capacidade;
        this.vetor = new Pokemon[capacidade];
        this.n_elementos = 0;
    }

    public void addFinal(Pokemon pokemon) {
        if (n_elementos == capacidade) {
            throw new IllegalStateException("A lista está cheia");
        }
        vetor[n_elementos] = pokemon;
        n_elementos++;
    }

    public void removeFinal() {
        if (n_elementos == 0) {
            throw new IllegalStateException("A lista está vazia");
        }
        n_elementos--;
    }

    public int contRepetido(){
        if (vazio()){
            return -1;
        }
        int repetido = 0;
        for (int i = 0; i < capacidade; i++){
            for(int j = i+1; j < capacidade; j++){
                if (i == capacidade-1){
                    if (vetor[i].nome.equals(vetor[i-1].nome)){
                        repetido++;
                    }
                }
                if (vetor[i].nome.equals(vetor[j].nome)){
                    repetido++;
                }
                if (repetido == capacidade){
                    return 1;
                }
            }
        }
        return capacidade - (repetido-1);
    }

    public boolean vazio(){
        return n_elementos == 0;
    }

    public void imprimirLista() {
        System.out.println("Pokemon : ");
        for (int i = 0; i < n_elementos; i++) {
            System.out.println(vetor[i].nome);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Ex2174 lista = new Ex2174(scan.nextInt());
        int pokemonsDisponiveis = 151;

        for (int i = 0; i < lista.capacidade; i++) {
            lista.addFinal(new Pokemon(scan.next()));
        }

        int qtdFalta = pokemonsDisponiveis - lista.contRepetido();

        System.out.println("Falta(m) " + qtdFalta + " pomekon(s).");

    }
}
