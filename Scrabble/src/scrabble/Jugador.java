//*********************************CIRCULAR SIMPLE**********************************
package scrabble;
/*
@author DINORA
 */
public class Jugador {
    private NodoJugador cabeza;
    private NodoJugador ultimo;
    
    public Jugador(){
        cabeza = null;
        ultimo = null;
    }
    
    public void Insertar(int number, String user, Mano misFichas){
        NodoJugador nuevo = new NodoJugador(number, user, misFichas);
     
        if(getCabeza() == null){
            setCabeza(nuevo);
            setUltimo(nuevo);
            getUltimo().setSiguiente(getCabeza());
        }else{
            getUltimo().setSiguiente(nuevo);
            nuevo.setSiguiente(getCabeza());
            setUltimo(nuevo);
        }
    }
    
    public boolean esVacia(){
        return getCabeza()==null;
    }
    
    public void Recorrer(){
       
       
        
        if (!esVacia()){
            NodoJugador aux = getCabeza();
            do{
                System.out.print(aux.getNumber() + "    "+ aux.getUser() + "   Sus fichas:   ");
                aux.getMisFichas().Recorrer();
                
                aux = aux.getSiguiente();
            }while(aux != getCabeza());
        }    
    }

    /**
     * @return the cabeza
     */
    public NodoJugador getCabeza() {
        return cabeza;
    }

    /**
     * @param cabeza the cabeza to set
     */
    public void setCabeza(NodoJugador cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * @return the ultimo
     */
    public NodoJugador getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(NodoJugador ultimo) {
        this.ultimo = ultimo;
    }

}
