package singletonV1;

public class GestorBBDD {
    private static GestorBBDD gestor = null;
    private static int contadorInstancias=0;
    // Para no permitir la creacion de objetos desde fuera de la clse,
    // se hace el constructor privado
    private GestorBBDD(){
        contadorInstancias++;
    }

    // Método que permite en acceso a la única instancia de la clase
    public static GestorBBDD obtenerGestor(){
        if (gestor == null) {
            synchronized (GestorBBDD.class) {
                if (gestor == null) {
                    gestor = new GestorBBDD();
                }
            }
        }
        return gestor;
    }

    public static int obtenerContador(){
        return contadorInstancias;
    }
}
