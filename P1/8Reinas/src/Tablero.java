import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tablero {
    private int dimension;
    private ArrayList<Celda> contenido;

    public Tablero(int dimension) {
        this.dimension = dimension;
        contenido = new ArrayList<Celda>();
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public ArrayList<Celda> getContenido() {
        return contenido;
    }

    public void setContenido(ArrayList<Celda> contenido) {
        this.contenido = contenido;
    }

    public Tablero ponerReina (int fila, int columna){
        Tablero t = new Tablero(dimension);
        t.contenido.addAll(contenido);
        t.contenido.add(new Celda(fila,columna));
        return t;
    }


    public boolean posicionSegura (Celda otraCelda){
        return !(contenido.stream().anyMatch( celda ->
                celda.hayConflicto(otraCelda) == true ));
    }

    @Override
    public String toString(){
         String visualizarTablero = "";
         for (int fila = 0; fila < dimension; fila++){
             for (int columna = 0; columna < dimension; columna++){
                 int finalFila = fila;
                 int finalColumna = columna;
                 if (contenido.stream().anyMatch(
                         celda -> (celda.getFila() == finalFila && celda.getColumna() == finalColumna) == true
                 )){
                     visualizarTablero+="R ";
                 }
                 else{
                     visualizarTablero+="X ";
                 }
             }
             visualizarTablero+="\n";
        }
         return visualizarTablero;
    }

}
