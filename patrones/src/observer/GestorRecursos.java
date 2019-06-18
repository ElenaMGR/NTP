package observer;

public interface GestorRecursos {
    public void registrar(Observador objeto);
    public void eliminar(Observador objeto);
    public void notificar();
}
