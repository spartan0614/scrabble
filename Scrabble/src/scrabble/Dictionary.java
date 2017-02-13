//**************************************LISTA SIMPLE*************************************
package scrabble;
/*
  @author DINORA
 */
public class Dictionary {
    private NodoDic cabeza;
    
    public Dictionary(){
        cabeza = null;
    }
    
    public void Insertar(String palabra){    //Insertar palabras al diccionario.
        NodoDic nuevo = new NodoDic(palabra);
        
        if(this.getCabeza() == null){
            setCabeza(nuevo);
        }else{
            NodoDic aux = getCabeza();
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
          aux.setSiguiente(nuevo); 
        }
    }
        
    public void Recorrer(){   //Metodo para comprobar si la lista está llena.
        NodoDic mostrar;       
        for(mostrar = getCabeza(); mostrar != null; mostrar = mostrar.getSiguiente()){
            System.out.println(mostrar.getPalabra());
        }
    }

    /**
     * @return the cabeza
     */
    public NodoDic getCabeza() {
        return cabeza;
    }

    /**
     * @param cabeza the cabeza to set
     */
    public void setCabeza(NodoDic cabeza) {
        this.cabeza = cabeza;
    }
    
}
