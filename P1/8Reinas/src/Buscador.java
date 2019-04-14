import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Clase Buscador
 */
public class Buscador {
    /**
     * Dimension de los tableros
     */
    private int dimension;

    /**
     *
     * @return devuelve la dimensión de los tableros
     */
    public int getDimension() {
        return dimension;
    }

    /**
     * Asigna una dimension a los tableros
     * @param dimension
     */
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    /**
     * Constructor de la clase Buscador
     * @param dimension
     */
    public Buscador(int dimension) {
        this.dimension = dimension;
    }

    /**
     * Método recursivo que va ubicando reinas en una posición si se puede
     * @param fila
     * @return devuelve una lista de tableros con soluciones
     */
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
                        //System.out.println("Fila: "+ fila+" - Columna: "+columna);
                        if(tablero.posicionSegura(celdaNueva)){
                            //System.out.println("Entra");
                            return tablero.ponerReina(celdaNueva.getFila(),celdaNueva.getColumna());
                        }
                        return t;
                    }).filter(posibleT -> posibleT!=null)).collect(Collectors.toList());

            tableros.addAll(soluciones);
        }
        return tableros;
    }


    /**
     * Método que resuelve el problema de las 8 Reinas
     * @return devuelve una lista de tableros solución
     */
    public ArrayList<Tablero> resolver(){
        return ubicarReina(dimension -1);
    }

}
