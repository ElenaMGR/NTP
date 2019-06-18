package observer;

public class MonitorLog implements Observador {
    private GestorRecursos sistemaObservado;

    public MonitorLog (){ }

    public MonitorLog (GestorRecursos sistema){
        sistemaObservado = sistema;
        sistemaObservado.registrar(this);
    }

    public void actualizar (String info){
        System.out.println("Monitor log: "+info);
        sistemaObservado.eliminar(this);
        sistemaObservado.registrar(this);
    }
}
