import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlujoEnteros {
    public static void main (String args[]){
        Integer[] valores = {2,9,5,0,3,7,1,4,8,6};

        Stream<Integer> flujo = Arrays.stream(valores);

        System.out.printf("Valores originales: %s%n", Arrays.asList(valores));

        //ordenación sobre el flujo
        List<Integer> lista = flujo.sorted().collect(Collectors.toList());
        System.out.printf("Valores ordenados: %s%n", lista);

        List<Integer> lista2 = Arrays.stream(valores).filter(x -> x > 4).sorted().collect(Collectors.toList());
        System.out.printf("Valores ordenados: %s%n", lista2);

    }
}
