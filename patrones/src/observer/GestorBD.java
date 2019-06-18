package observer;

import java.util.Vector;

public class GestorBD implements GestorRecursos {
    // cadena para guardar la informacion interna
    private String infoEstado;

    // vector de objetos observadores
    private Vector<Observador> observadores;

    // constructor de la clase
    public GestorBD(){
        observadores = new Vector<>();
    }

    // metodo para suscripcion
    public void registrar (Observador observador){
        observadores.add(observador);
    }

    // metodo de baja
    public void eliminar (Observador observador){
        observadores.remove(observador);
    }

    // metodo de notificacion
    public void notificar (){
        for (Observador observador: observadores){
            observador.actualizar(infoEstado);
        }
    }

    // ejemplo de metodo que produce cambio en el sistema
    public void borrarDatos(){
        infoEstado="Borrado de datos de BBDD";
        notificar();
    }
}
