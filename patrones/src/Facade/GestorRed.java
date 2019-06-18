package Facade;

public class GestorRed {
    public void initService(){
        System.out.println("Iniciando servicio de red...");
    }

    public void getStatus(){
        System.out.println("Informacion de estado de red");
    }

    public void stopService(){
        System.out.println("Finalizando servicio de red...");
    }
}
