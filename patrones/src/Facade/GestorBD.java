package Facade;

public class GestorBD {
    public void start(){
        System.out.println("Iniciando servicio Gestor BD...");
    }

    public void login(){
        System.out.println("Iniciando acceso a BD...");
    }

    public void getData(){
        System.out.println("Obteniendo informacion sobre BD...");
    }

    public void close(){
        System.out.println("Cierre de sesion en GestorBD....");
    }
}
