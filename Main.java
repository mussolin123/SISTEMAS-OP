import atividade.AddVetorMaster;

public class Main {

    private static final int TAMANHO = 100000;
    private static final int NTRHEADS = 7;

    public static void main(String[] args) {

        // Criar vetores
        double[] a = new double[TAMANHO];
        double[] b = new double[TAMANHO];

        for (int i = 0; i < TAMANHO; i++) {
            a[i] = Math.random();
            b[i] = Math.random();
        }

        // Instanciar Master
        AddVetorMaster mrm = new AddVetorMaster(a, b, NTRHEADS);

        // Marcar o tempo de início da execução
        long startTime = System.nanoTime();

        // Executar a soma dos vetores
        mrm.calcVetores();
        double[] c = mrm.getVetorR();

        // Marcar o tempo de fim da execução
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        // Imprimir o resultado e o tempo de execução
        System.out.println("Vetor resultado:");
        for (double value : c) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println("Tempo de execução: " + duration + " nanossegundos");
    }
}