package state;

public class EstadoAceptadaPeticion implements Estado {
    // dato miembro asociado al sistema
    InterfazGestor gestor;

    public EstadoAceptadaPeticion (InterfazGestor gestor){
        this.gestor= gestor;
    }

    public String aceptarPeticion(){
        gestor.asignarProcesadoresLibres(gestor.obtenerProcesadoresLibres()-1);
        gestor.asignarEstado(gestor.obtenerEstadoOcupado());
        return "aceptada peticion...";
    }
}
