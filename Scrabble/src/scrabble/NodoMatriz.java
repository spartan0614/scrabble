package scrabble;
/*
 @author DINORA
 */
public class NodoMatriz {
    private int pointX;
    private int pointY;
    private int valor;
    private boolean taken;
    
    private NodoMatriz siguiente;
    private NodoMatriz anterior;
    private NodoMatriz arriba;
    private NodoMatriz abajo;
   
    public NodoMatriz(int pointX, int pointY, int valor, boolean taken){
        this.pointX = pointX;
        this.pointY = pointY;
        this.valor = valor;
        this.taken = taken;
    }
    /**
     * @return the pointX
     */
    public int getPointX() {
        return pointX;
    }

    /**
     * @param pointX the pointX to set
     */
    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    /**
     * @return the pointY
     */
    public int getPointY() {
        return pointY;
    }

    /**
     * @param pointY the pointY to set
     */
    public void setPointY(int pointY) {
        this.pointY = pointY;
    }

    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * @return the taken
     */
    public boolean isTaken() {
        return taken;
    }

    /**
     * @param taken the taken to set
     */
    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    /**
     * @return the siguiente
     */
    public NodoMatriz getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoMatriz siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the anterior
     */
    public NodoMatriz getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(NodoMatriz anterior) {
        this.anterior = anterior;
    }

    /**
     * @return the arriba
     */
    public NodoMatriz getArriba() {
        return arriba;
    }

    /**
     * @param arriba the arriba to set
     */
    public void setArriba(NodoMatriz arriba) {
        this.arriba = arriba;
    }

    /**
     * @return the abajo
     */
    public NodoMatriz getAbajo() {
        return abajo;
    }

    /**
     * @param abajo the abajo to set
     */
    public void setAbajo(NodoMatriz abajo) {
        this.abajo = abajo;
    }
    
    
}
