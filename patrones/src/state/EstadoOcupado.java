package state;

public class EstadoOcupado {
    // dato miembro asociado al sistema
    InterfazGestor gestor;

    public EstadoOcupado (InterfazGestor gestor){
        this.gestor= gestor;
    }

    public String ejecutarPeticion(){
        if (gestor.obtenerProcesadoresLibres() > 0)
            gestor.asignarEstado(gestor.obtenerEstadoActivo());


        return "ejecutada peticion...";
    }
}
