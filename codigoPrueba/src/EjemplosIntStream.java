import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EjemplosIntStream {
    //datos para trabajar
    private int[] valores;

    public EjemplosIntStream (int numeroValores){
        valores = new int[numeroValores];
        Random generador = new Random();
        generador.setSeed(0);
        for (int i=0; i<numeroValores; i++){
            valores[i]=generador.nextInt(101);
        }
    }

    //listado de valores en modo imperativo
    public void mostrarValoresImperativo(){
        for (int i=0; i<valores.length; i++){
            System.out.printf("%d ",valores[i]);
        }
        System.out.println();
    }

    public void mostrarValoresFuncional(){
        //creacion del flujo
        IntStream flujo = IntStream.of(valores);

        //se define la operacion a aplicar sobre cada valor
        IntConsumer operacion = valor -> System.out.printf("%d ", valor);

        //se usa el flujo
        flujo.forEach(operacion);
        System.out.println();

    }

    public void mostrarValoresFuncional2 (){
        IntStream.of(valores).forEach(valor->System.out.printf("%d ",valor));
    }

    public void mostrarValoresFuncional3 (){
        IntStream.of(valores).forEach(System.out::println);
    }

    //contar valores de la colección
    public long contarValoresFuncional(){
        return IntStream.of(valores).count();
    }

    // sumar valores en modo imperativo
    public long sumarValoresImperativo(){
        long suma=0;
        for (int i=0; i< valores.length; i++){
            suma = suma + valores[i];
        }

        return suma;
    }

    //sumar valores funcional
    public long sumarValoresFuncional(){
        return IntStream.of(valores).sum();
    }

    //sumar valores funcional con reduce
    public long sumarValoresFuncionalReduce(){
        return IntStream.of(valores).reduce(0, (x,y)->x+y);
    }

    //producto con reduce
    public double multiplicarValoresFuncional(){
        return IntStream.of(valores).asDoubleStream().reduce(1.0, (x,y)->x*y);
    }

    //suma funcional de los valores al cuadrado
    public double sumaValoresAlCuadrado(){
        return IntStream.of(valores).asDoubleStream().reduce(0.0,(x,y)->x+y*y);
    }

    //minimo con reduce
    public int calcularMinimoFuncionalReduce(){
        return IntStream.of(valores).reduce(valores[0],(x,y)->{
            if (x<y) return x;
            else return y;
        });
    }

    public int calcularMinimoFuncional(){
        OptionalInt resultado = IntStream.of(valores).min();
        return resultado.orElse(-1);
    }

    public int calcularMaximoFuncional(){
        return IntStream.of(valores).max().getAsInt();
    }

    // Filtrado de valores pares
    public int[] obtenerParesFuncional(){
        /*IntStream flujo = IntStream.of(valores);

        //creo el predicado para el filtrado
        IntPredicate predicado = x -> x%2 == 0;

        IntStream flujo2 = flujo.filter(predicado);
        return flujo2.toArray();*/

        return IntStream.of(valores).filter(x -> x%2 == 0).toArray();
    }

    //Mezcla de predicados
    public int[] predicadosComplejos(){
        //predicado para valores pares
        IntPredicate pares = x -> x%2 == 0;
        //predicado para valores mayores que 5
        IntPredicate mayores5 = x -> x > 5;
        //Ambos predicados
        IntPredicate total = pares.and(mayores5);

        //Es equivalente a la siguiente expresión lambda
        IntPredicate totalLambda = x-> (x %2 == 0 && x > 5);

        return IntStream.of(valores).filter(total).toArray();
    }

    //operación para filtrar pares, multiplicarlos por factor y ordenar
    public double[] filtrarMultiplicarOrdenar (double factor){
        return IntStream.of(valores).filter(x -> x%2 == 0).mapToDouble(x -> x*factor).sorted().toArray();
    }

    //main
    public static void main (String args[]){
        //crear objeto de la clase
        EjemplosIntStream objeto = new EjemplosIntStream(20);

        //mostramos valores con metodo imperativo
        objeto.mostrarValoresImperativo();
        objeto.mostrarValoresFuncional();
        //objeto.mostrarValoresFuncional2();
        //objeto.mostrarValoresFuncional3();

        System.out.println("Suma de valores: ");
        System.out.println("Suma funcional: "+ objeto.sumarValoresFuncional());
        System.out.println("Suma funcional: "+ objeto.sumarValoresFuncionalReduce());

        System.out.println("Suma funcional de los valores al cuadrado: "+ objeto.sumaValoresAlCuadrado());
        System.out.println("Minimo con reduce: "+ objeto.calcularMinimoFuncionalReduce());
        System.out.println("Minimo: "+ objeto.calcularMinimoFuncional());

    }
}
