package matriz;
/*
 @author DINORA
 */
/*********************************NODO ORTOGONAL***********************************/
public class NodoOrtogonal {
    private int X;
    private int Y;
    private int valor;
    private boolean taken;
    
    private NodoOrtogonal derecha;
    private NodoOrtogonal izquierda;
    private NodoOrtogonal arriba;
    private NodoOrtogonal abajo;
   
    public NodoOrtogonal(int X,int Y, int valor, boolean taken){
        this.X = X;
        this.Y = Y;
        this.valor = valor;
        this.taken = taken;
    }
    /**
     * @return the pointX
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
     * @return the pointY
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
     * @return the derecha
     */
    public NodoOrtogonal getDerecha() {
        return derecha;
    }

    /**
     * @param derecha the siguiente to set
     */
    public void setDerecha(NodoOrtogonal derecha) {
        this.derecha = derecha;
    }

    /**
     * @return the izquierda
     */
    public NodoOrtogonal getIzquierda() {
        return izquierda;
    }

    /**
     * @param izquierda the anterior to set
     */
    public void setIzquierda(NodoOrtogonal izquierda) {
        this.izquierda = izquierda;
    }

    /**
     * @return the arriba
     */
    public NodoOrtogonal getArriba() {
        return arriba;
    }

    /**
     * @param arriba the arriba to set
     */
    public void setArriba(NodoOrtogonal arriba) {
        this.arriba = arriba;
    }

    /**
     * @return the abajo
     */
    public NodoOrtogonal getAbajo() {
        return abajo;
    }

    /**
     * @param abajo the abajo to set
     */
    public void setAbajo(NodoOrtogonal abajo) {
        this.abajo = abajo;
    }   
}
