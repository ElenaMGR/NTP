package state;

public class EstadoRecibidaPeticion {
    // dato miembro asociado al sistema
    InterfazGestor gestor;

    public EstadoRecibidaPeticion (InterfazGestor gestor){
        this.gestor= gestor;
    }

    public String chequearPeticion(){
        // Se acepta la peticion si hay procesadores libres
        if (gestor.obtenerProcesadoresLibres() > 0)
            gestor.asignarEstado(gestor.obtenerEstadoAceptarPeticion());
        else
            gestor.asignarEstado(gestor.obtenerEstadoActivo());

        return "chequeada peticion...";
    }
}
