import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.util.Map;

/**
 * Práctica 1 NTP 8 Reinas
 */
public class ReinasTest {
    static Tablero tablero;
    /**
     * Codigo a ejecutar antes de realizar las llamadas a los métodos
     * de la clase; incluso antes de la propia instanciación de la
     * clase. Por eso el método debe ser estatico
     */
    @BeforeClass
    public static void inicializacion() {
        System.out.println("Metodo inicializacion conjunto pruebas");
        tablero = new Tablero(10);
    }

    /**
     * Test que comprueba el metodo toString
     */
    @Test
    public void testToStringConReinas() {
        tablero.ponerReina(3,3);
        tablero.ponerReina(6,6);
        String resultado = tablero.toString();
        System.out.println(resultado);
        assertTrue(resultado.contains("R"));
    }

    /**
     * Test que comprueba el metodo toString
     */
    @Test
    public void testToStringSinReinas() {
        String resultado = tablero.toString();
        System.out.println(resultado);
        assertTrue(!resultado.contains("R"));
    }


}