import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlujoCadenas {
    public static void main (String args[]){
        String[] cadenas= {"Rojo", "Naranja", "Amarillo", "Verde", "azul", "indigo", "Violeta"};

        //creacion de flujo
        //Arrays.stream(cadenas).map(cadena -> cadena.toUpperCase());
        List<String> lista = Arrays.stream(cadenas).map(String::toUpperCase).collect(Collectors.toList());
        System.out.printf("Cadenas: %s%n", lista);

        //ordenación con detalles
        List<String> lista2 = Arrays.stream(cadenas).filter(cadena -> cadena.compareToIgnoreCase("m")>0).
                sorted(String.CASE_INSENSITIVE_ORDER.reversed()).collect(Collectors.toList());
        System.out.printf("Cadenas al final: %s%n", lista2);
    }
}
