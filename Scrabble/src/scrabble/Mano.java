//*********************************LISTA SIMPLE*************************************
package scrabble;
/* 
 @author DINORA
 */
public class Mano {
    private NodoFichas cabeza;
    
    public Mano(){
        cabeza = null;
    }
    
    public void Insertar(String letra, int valor){
        NodoFichas nuevo = new NodoFichas(letra, valor);
        
        if(this.getCabeza() == null){
            setCabeza(nuevo);
        }else{
            NodoFichas aux = getCabeza();
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
          aux.setSiguiente(nuevo);
        }
    }
     public void Recorrer(){   
        NodoFichas mostrar;       
        for(mostrar = getCabeza(); mostrar != null; mostrar = mostrar.getSiguiente()){
            System.out.print(mostrar.getLetra()+"  ");
        }
    }
     
   
     
    public void EliminarLista(){
        while(getCabeza()!= null){
            setCabeza(getCabeza().getSiguiente());
        }
    }

    /**
     * @return the cabeza
     */
    public NodoFichas getCabeza() {
        return cabeza;
    }

    /**
     * @param cabeza the cabeza to set
     */
    public void setCabeza(NodoFichas cabeza) {
        this.cabeza = cabeza;
    }
}
