// ********************** LISTA CIRCULAR SIMPLE***************************
package scrabble;
/*
  @author DINORA
 */
public class NodoJugador {
    private int number;
    private String user;
    private Mano misFichas;
    
    private NodoJugador siguiente;
    
    public NodoJugador(int number, String user, Mano misFichas){
        this.number = number;
        this.user = user;
        this.misFichas = misFichas;
        
        setSiguiente(this);
    }
    
    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the misFichas
     */
    public Mano getMisFichas() {
        return misFichas;
    }

    /**
     * @param misFichas the misFichas to set
     */
    public void setMisFichas(Mano misFichas) {
        this.misFichas = misFichas;
    }

    /**
     * @return the siguiente
     */
    public NodoJugador getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoJugador siguiente) {
        this.siguiente = siguiente;
    }
    
}
