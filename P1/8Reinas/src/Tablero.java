import java.util.ArrayList;

/**
 * Clase Tablero
 */
public class Tablero {
    /**
     * Dimension del tablero (solo hay tableros cuadrados)
     */
    private int dimension;
    /**
     * Contenido del tablero
     * Solo se guardan las celdas donde hay reina
     */
    private ArrayList<Celda> contenido;

    /**
     * Constructor del tablero
     * @param dimension dimension del tablero
     */
    public Tablero(int dimension) {
        this.dimension = dimension;
        contenido = new ArrayList<Celda>();
    }

    /**
     *
     * @return devuelve la dimension del tablero
     */
    public int getDimension() {
        return dimension;
    }

    /**
     * Asigna una dimension dada al tablero
     * @param dimension
     */
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    /**
     *
     * @return devuelve el contenido del tablero
     */
    public ArrayList<Celda> getContenido() {
        return contenido;
    }

    /**
     * Asigna un contenido al tablero
     * @param contenido
     */
    public void setContenido(ArrayList<Celda> contenido) {
        this.contenido = contenido;
    }

    /**
     * Método que pone una reina en el tablero en la fila y columna dada
     * Se crea una copia tablero con el contenido donde poner la reina
     * @param fila
     * @param columna
     * @return devuelve el tablero creado con la nueva reina
     */
    public Tablero ponerReina (int fila, int columna){
        Tablero t = new Tablero(dimension);
        t.contenido.addAll(contenido);
        t.contenido.add(new Celda(fila,columna));
        return t;
    }


    /**
     * Método que comprueba si una posicion (celda) es segura
     * @param otraCelda
     * @return devuelve un booleano que indica si la posición es segura
     */
    public boolean posicionSegura (Celda otraCelda){
        return !(contenido.stream().anyMatch( celda ->
                celda.hayConflicto(otraCelda) == true ));
    }

    /**
     * X - No hay reina
     * R - Hay reina
     * @return String que contiene el tablero
     */
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
