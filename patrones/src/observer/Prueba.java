package observer;

public class Prueba {
    public static void main (String args[]){
        // se crea el gestor de recursos
        GestorBD gestor = new GestorBD();

        // se crean los observadores
        MonitorLog mlog = new MonitorLog();
        MonitorVisual mvisual = new MonitorVisual();

        // se registran los observadores en el servicio de notificacion
        gestor.registrar(mlog);
        gestor.registrar(mvisual);

        // se produce el cambio en el sistema observador
        gestor.borrarDatos();

        // se da de baja un sistema
        gestor.eliminar(mlog);
        gestor.borrarDatos();
    }
}
