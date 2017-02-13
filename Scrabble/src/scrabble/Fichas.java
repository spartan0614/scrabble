//**************************************** COLA ************************************
package scrabble;
/*
  @author DINORA
 */
public class Fichas {
    private NodoFichas cabeza;
    private NodoFichas fin;
    
    public Fichas(){
        cabeza = null;
        fin = null;
    }
    
    public void Insertar(String letra, int valor){
        NodoFichas nuevo = new NodoFichas(letra, valor);
    
        if(this.getCabeza() == null && this.getFin() == null){
            setCabeza(nuevo);
        }else{
            fin.setSiguiente(nuevo);
        }
    setFin(nuevo);
    }
    
    public NodoFichas Quitar(){   //sale un elemento frente y retorna la ficha que se sacó
        NodoFichas aux = null;
        if (!colaVacia()){
            aux = getCabeza();
            setCabeza(getCabeza().getSiguiente());
        }else{
            System.out.print("No se puede eliminar de una cola vacia");
        }
        return aux;
    }
    
    public boolean colaVacia(){
        return (getCabeza() == null);
    }
    
    public void Imprimir(){
        NodoFichas aux;
        for(aux = getCabeza(); aux != null; aux = aux.getSiguiente()){
            System.out.print(aux.getLetra() + "    ");
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

    /**
     * @return the fin
     */
    public NodoFichas getFin() {
        return fin;
    }

    /**
     * @param fin the fin to set
     */
    public void setFin(NodoFichas fin) {
        this.fin = fin;
    }
    
}
