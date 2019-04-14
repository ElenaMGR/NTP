/**
 * Clase Celda
 */
public class Celda {
    /**
     * Fila y columna de la celda
     */
    private int fila, columna;

    /**
     *
     * @return devuelve la fila de la celda
     */
    public int getFila() {
        return fila;
    }

    /**
     * Asigna una fila a una celda
     * @param fila
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     *
     * @return devuelve la columna de la celda
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Asigna columna a celda
     * @param columna
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * Constructor de la clase celda dada una fila y una columna
     * @param fila
     * @param columna
     */
    public Celda(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * Método que comprueba si hay conflicto con otra celda dada
     * Se comprueba que no están en la misma fila ni columna ni en la misma diagonal
     * @param otraCelda
     * @return devuelve un booleano de si hay conflicto
     */
    public boolean hayConflicto(Celda otraCelda){
        boolean conflicto = false;
        if (fila == otraCelda.getFila() || columna==otraCelda.getColumna() ||
                Math.abs(fila-otraCelda.getFila())==Math.abs(columna-otraCelda.getColumna()))
            conflicto = true;
        return conflicto;
    }
}
