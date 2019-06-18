package state;

public class EstadoActivo implements Estado {
    // dato miembro asociado al sistema
    InterfazGestor gestor;

    public EstadoActivo (InterfazGestor gestor){
        this.gestor=gestor;
    }

    public String gestionarPeticion(){
        // se cambia estado a recibida peticion
        gestor.asignarEstado(gestor.obtenerEstadoPeticionRecibida());
        return "gestionada peticion...";
    }
}
