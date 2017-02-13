//   *********************************COLA********************************
package scrabble;
/*
@author DINORA
 */
public class NodoFichas {
    private String letra;
    private int valor;
    
    private NodoFichas siguiente;
    
    public NodoFichas(String letra,int valor){
        this.letra = letra;
        this.valor = valor;
    }

    /**
     * @return the letra
     */
    public String getLetra() {
        return letra;
    }

    /**
     * @param letra the letra to set
     */
    public void setLetra(String letra) {
        this.letra = letra;
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
     * @return the siguiente
     */
    public NodoFichas getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoFichas siguiente) {
        this.siguiente = siguiente;
    }
}
