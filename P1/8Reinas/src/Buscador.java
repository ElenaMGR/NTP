import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Buscador {
    private int dimension;

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Buscador(int dimension) {
        this.dimension = dimension;
    }

    public ArrayList<Tablero> ubicarReina(int fila){
        ArrayList<Tablero> tableros = new ArrayList<Tablero>();
        // caso base: si la fila es -1, entonces crear un tablero vacio y
        // almacenarlo en una lista de tableros (que solo tendra este elemento)
        if (fila == -1)
            tableros.add(new Tablero(dimension));
        else{
            // caso inductivo:
            //recoger en soluciones la salida de otra llamada a ubicarReina,
            //pero pasando como argumento fila-1 (es decir, el metodo se basa
            //en que ya estan ubicadas las reinas en filas inferiores procede
            //a agregar otra reina mas)
            List<Tablero> soluciones = ubicarReina(fila-1);
            // para cada una de las soluciones (tableros con reinas hasta fila-1):
                // para cada columna:
                    //crear celda para (fila, columna)
                    //si la celda es segura en el tablero que representa la solucion
                    //considerada, ubicar la reina en el tablero y almacenarla
                    //para su devolucion
                //fin para
            //fin para
            soluciones = soluciones.stream().flatMap(tablero ->
                    IntStream.range(0,dimension).boxed().map(columna ->{
                        Celda celdaNueva = new Celda(fila,columna);
                        Tablero t = null;
                        if(tablero.posicionSegura(celdaNueva)){
                            return tablero.ponerReina(celdaNueva.getFila(),celdaNueva.getColumna());
                        }
                        return t;
                    }).filter(posibleT -> posibleT!=null)).collect(Collectors.toList());

            tableros.addAll(soluciones);
        }
        return tableros;
    }



    public ArrayList<Tablero> resolver(){
        return ubicarReina(dimension -1);
    }

    public static void main(String args[]) {
        Buscador buscador = new Buscador(6);

        ArrayList<Tablero> solucion = buscador.resolver();
        System.out.println(solucion.size());
        if(solucion.size() > 0){
            System.out.println("Soluciones encontradas: \n");
            solucion.stream().forEach(tablero -> {
                System.out.println(tablero.toString());
                System.out.println("------------------------------------------------------------");
                System.out.println("------------------------------------------------------------" + "\n");

            });
        }
        else{
            System.out.println("Ninguna solución encontrada");
        }

    }
}
