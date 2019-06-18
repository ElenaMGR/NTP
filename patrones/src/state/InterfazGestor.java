package state;

public interface InterfazGestor {
    // declaracion los metodos disponibles
    public void agregarPeticion();
    public void chequearPeticion();
    public void aceptarPeticion();
    public void ejecutarPeticion();

    // metodo para asisgnar estado activo
    public void asignarEstado(Estado estado);

    // metodo para obgtener los estados
    public Estado obtenerEstadoActivo();
    public Estado obtenerEstadoPeticionRecibida();
    public Estado obtenerEstadoAceptarPeticion();
    public Estado obtenerEstadoOcupado();

    // metodo para controlar el numero de procesadores
    public int obtenerProcesadoresLibres();
    public int asignarProcesadoresLibres (int n);
}
