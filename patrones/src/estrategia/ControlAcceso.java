package estrategia;

public class ControlAcceso {
    private ComportamientoAcceso gestorAcceso;
    private ComportamientoCifrado gestorCifrado;

    public void asignarComportamientoAcceso(ComportamientoAcceso comportamiento){
        gestorAcceso=comportamiento;
    }

    public void asignarComportamientoCifrado(ComportamientoCifrado comportamiento){
        gestorCifrado=comportamiento;
    }

    public void acceder(){
        gestorAcceso.acceder();
    }

    public void cifrar (String texto){
        gestorCifrado.cifrar(texto);
    }


}
