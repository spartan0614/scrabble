package matriz;
/*
@author DINORA
 */
public class NodoCabecera {
    private int X;
    private NodoCabecera siguiente;
    private NodoCabecera anterior;
    private ListaVertical columna;
    
    public NodoCabecera(int X){
        this.X = X;
        columna = new ListaVertical();
        siguiente = null;
        anterior= null;
    }

    /**
     * @return the X
     */
    public int getX() {
        return X;
    }

    /**
     * @param X the X to set
     */
    public void setX(int X) {
        this.X = X;
    }

    /**
     * @return the siguiente
     */
    public NodoCabecera getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoCabecera siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the anterior
     */
    public NodoCabecera getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(NodoCabecera anterior) {
        this.anterior = anterior;
    }

    /**
     * @return the columna
     */
    public ListaVertical getColumna() {
        return columna;
    }

    /**
     * @param columna the columna to set
     */
    public void setColumna(ListaVertical columna) {
        this.columna = columna;
    }
    
    
    
}
