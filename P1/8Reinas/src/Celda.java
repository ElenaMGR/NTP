public class Celda {
    private int fila, columna;

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public Celda(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public boolean hayConflicto(Celda otraCelda){
        boolean conflicto = false;
        if (fila == otraCelda.getFila() || columna==otraCelda.getColumna() ||
                Math.abs(fila-otraCelda.getFila())==Math.abs(columna-otraCelda.getColumna()))
            conflicto = true;
        return conflicto;
    }
}
