package state;

public class GestorEjecucionOk implements InterfazGestor {
    // Objetos para cada uno de los estados
    private Estado estadoActivo;
    private Estado estadoAceptadaPeticion;
    private Estado estadoRecibidaPeticion;
    private Estado estadoOcupado;

    // dato miembro para el estado actual
    private Estado estadoActual;

    // controlar el numero de procesadores
    private int numeroProcesadores;

    public GestorEjecucionOk (int n){
        estadoActivo = new EstadoActivo(this);
        estadoOcupado = new EstadoOcupado(this);
        estadoAceptadaPeticion = new EstadoAceptadaPeticion(this);
        estadoRecibidaPeticion = new EstadoRecibidaPeticion(this);

        numeroProcesadores= n;

        //asignar estado actual
        estadoActual = estadoActivo
    }

    @Override
    public void agregarPeticion() {
        String salida = estadoActual.gestionarPeticion();
    }

    @Override
    public void chequearPeticion() {
        estadoActual.chequearPeticion();
    }

    @Override
    public void aceptarPeticion() {
        estadoActual.aceptarPeticion();
    }

    @Override
    public void ejecutarPeticion() {
        estadoActual.ejecutarPeticion();
    }

    @Override
    public void asignarEstado(Estado estado) {
        estadoActual = estado;
    }

    @Override
    public Estado obtenerEstadoActivo() {
        return estadoActivo;
    }

    @Override
    public Estado obtenerEstadoPeticionRecibida() {
        return estadoRecibidaPeticion;
    }

    @Override
    public Estado obtenerEstadoAceptarPeticion() {
        return estadoAceptadaPeticion;
    }

    @Override
    public Estado obtenerEstadoOcupado() {
        return estadoOcupado;
    }

    @Override
    public int obtenerProcesadoresLibres() {
        return numeroProcesadores;
    }

    @Override
    public int asignarProcesadoresLibres(int n) {
        numeroProcesadores = n;
        return n;
    }
}
