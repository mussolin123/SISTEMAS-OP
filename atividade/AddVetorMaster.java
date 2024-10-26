package atividade;

import modelo.AddVetorThread;

public class AddVetorMaster {
    private double[] a,b,c;
    private int numThreads;
    private int tamanho;
    private Thread[] V_threads;

    public AddVetorMaster(
        double[] a,
        double[] b,
        int numThreads
    ){
        this.a = a;
        this.b = b;
        this.numThreads = numThreads;
        this.tamanho = a.length;
    }
    public void calcVetores(){
        int fatia = (int) Math.floor(tamanho/numThreads);
        int extra = tamanho % numThreads;
        int inicio, fim;
        V_threads = new Thread[numThreads];
        c = new double[tamanho];

        for (int i = 0; i < numThreads; i++) {
            inicio = calcInicio(i, extra, fatia);
            fim = calcFim(i, extra, fatia, inicio);
            V_threads[i] = new Thread(
            new AddVetorThread(a, b, c, inicio, fim, i)
            );
            V_threads[i].start();
        }
    }

    public double[] getVetorR(){
        joinThreads();
        return c;
    }

    private int calcInicio(int i, int extra, int fatia){

        if(i < extra){
            return i * (fatia + 1);
        }
        return extra *(fatia+1) + (i-extra)*fatia;
        
    }
    private int calcFim(int i, int extra, int fatia, int t_inicio){
        return(i < extra) ? t_inicio + fatia : t_inicio + fatia - 1;
        
    }

    private void joinThreads(){
            try{
                for (int i = 0; i < numThreads; i++){
                    V_threads[i].join();
            }
        }catch (Exception e){
               
        }
         
    } 
}

