package singletonV1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tarea implements Runnable{
    public void run(){
        GestorBBDD gestor = GestorBBDD.obtenerGestor();

        // simular la realización de alguna tarea
        for (int i = 0; i<10000; i++);
    }
}

class Prueba{
    public static void main(String args[]){
        // creamos pool de hebras
        ExecutorService ex = Executors.newFixedThreadPool(100);

        // se agregan las tareas
        for (int i=0; i<100; i++){
            ex.execute(new Tarea());
        }

        // se resetea ejecutor
        ex.shutdown();

        // se observa el contador
        System.out.println("Instancias: "+ GestorBBDD.obtenerContador());
    }
}
