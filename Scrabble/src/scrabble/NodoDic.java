// *****************************LISTA SIMPLE******************************
package scrabble;
/*
 @author DINORA
 */
public class NodoDic {
    private String palabra;
    private NodoDic siguiente;
    
    public NodoDic(String palabra){
        this.palabra = palabra;
    }    

    /**
     * @return the palabra
     */
    public String getPalabra() {
        return palabra;
    }

    /**
     * @param palabra the palabra to set
     */
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    /**
     * @return the siguiente
     */
    public NodoDic getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoDic siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
