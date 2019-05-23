package estrategia;

public class Prueba {
    public static void main (String args[]){
        // se crea objeto de control de acceso
        ControlAcceso controlador = new ControlAcceso();

        // se asignan los comportamientos
        controlador.asignarComportamientoAcceso( new AccesoPwd() );
        controlador.asignarComportamientoCifrado( new CifradoNormal() );

        controlador.acceder();
        controlador.cifrar("Hola mundo");

        // de forma dinámica puedo cambiar el comportamiento
        controlador.asignarComportamientoCifrado( new CifradoNulo() );
        controlador.cifrar("Hola, mundo");
    }
}
