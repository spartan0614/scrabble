package matriz;

/*
    @author DINORA
 */
public class NodoLateral {
     private int Y;
    private NodoLateral siguiente;
    private NodoLateral anterior;
    private ListaHorizontal  fila;
    
    public NodoLateral(int Y){
        this.Y = Y;
        fila = new ListaHorizontal();
        siguiente = null;
        anterior= null;
    }

    /**
     * @return the Y
     */
    public int getY() {
        return Y;
    }

    /**
     * @param Y the Y to set
     */
    public void setY(int Y) {
        this.Y = Y;
    }

    /**
     * @return the siguiente
     */
    public NodoLateral getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoLateral siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the anterior
     */
    public NodoLateral getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(NodoLateral anterior) {
        this.anterior = anterior;
    }

    /**
     * @return the fila
     */
    public ListaHorizontal getFila() {
        return fila;
    }

    /**
     * @param fila the fila to set
     */
    public void setFila(ListaHorizontal fila) {
        this.fila = fila;
    }
}
