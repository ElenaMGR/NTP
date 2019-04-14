import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

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
        Tablero t = tablero.ponerReina(3,3);
        t = t.ponerReina(6,6);
        String resultado = t.toString();
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

    /**
     * Test que comprueba ubicarReina
     */
    @Test
    public void testUbicarReinaDimension4() {
        int dimension = 4;
        Buscador buscador = new Buscador(dimension);

        ArrayList<Tablero> soluciones = buscador.resolver();

        System.out.println("Total soluciones: "+soluciones.size());
        assertEquals(2,soluciones.size());
        System.out.println("Soluciones encontradas: ");

        soluciones.forEach(solucion -> {
            int totalReinas = 0;
            System.out.println(solucion.toString());
            totalReinas = solucion.toString().split("R",-1).length-1;
            System.out.println("Reinas encontradas: "+totalReinas);
            assertEquals(4,totalReinas);
        });
    }


    /**
     * Test que comprueba ubicarReina
     */
    @Test
    public void testUbicarReinaDimension10() {
        int dimension = 10;
        Buscador buscador = new Buscador(dimension);

        ArrayList<Tablero> soluciones = buscador.resolver();

        System.out.println("Total soluciones: "+soluciones.size());
        assertEquals(724,soluciones.size());
        System.out.println("Soluciones encontradas: ");

        soluciones.forEach(solucion -> {
            int totalReinas = 0;
            System.out.println(solucion.toString());
            totalReinas = solucion.toString().split("R",-1).length-1;
            System.out.println("Reinas encontradas: "+totalReinas);
            assertEquals(10,totalReinas);
        });
    }


}