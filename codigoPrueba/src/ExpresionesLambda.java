import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;

public class ExpresionesLambda {
    //main para probar
    public static void main(String args[]){
        //expresion lambda para sumar valores
        IntBinaryOperator exp1 = (int x, int y) -> {
            return x + y;
        };

        //ejecución de expresión
        int res1 = exp1.applyAsInt(7,15);
        System.out.println("resultado1: "+res1);

        //expresión lambda para dobles
        DoubleBinaryOperator exp2 = (double x, double y) -> (x + y);

        Consumer <Integer> exp3 = valor -> System.out.println("valor: " + valor);
        exp3.accept(4);

        //expresion con Runnable
        Runnable exp4 = () -> System.out.println("mensaje.....");
        exp4.run();

        IntBinaryOperator exp5 = new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left+right;
            }
        };




    }
}
