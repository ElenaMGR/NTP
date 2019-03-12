import java.security.SecureRandom;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class NumerosAleatorios {
    public static void main(String args[]){
        SecureRandom generador = new SecureRandom();

        // se define el numero de muestras a generar
        long muestras = 100_000_000;

        // se generan las muestras
        Stream<Integer> valores = generador.ints(muestras, 1, 7).boxed();

        //agrupar los valores y contarlos
        Map<Integer,Long> mapa =  valores.collect(Collectors.groupingBy(Function.identity(),Collectors.counting() ));

        mapa.forEach((valor,contador) -> {
            System.out.printf("%-10d%-10d%f%n", valor, contador, ((double) contador/muestras));
        });
    }
}
