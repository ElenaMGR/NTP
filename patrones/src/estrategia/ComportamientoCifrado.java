package estrategia;

public interface ComportamientoCifrado {
    public default void cifrar(String texto){
        System.out.println("Comportamiento cifrado directo....");
    }
}
