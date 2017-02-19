package matriz;

/*
 @author DINORA
 */
public class ListaVertical {
    private NodoOrtogonal primero;
    private NodoOrtogonal ultimo;
    
    public ListaVertical(){
        primero = null;
        ultimo = null;
    }
    
    public void Insertar(NodoOrtogonal nuevo){
         
       if(Vacia()){
            primero = ultimo = nuevo;   
        }else{
            if(nuevo.getY() < getPrimero().getY()){
                InsertarFrente(nuevo);
            }else if(nuevo.getY() > getUltimo().getY()){
                InsertarFinal(nuevo);
            }else{
                InsertarMedio(nuevo);
            }
        }
    }
    
    public void InsertarFrente(NodoOrtogonal nuevo){
        getPrimero().setArriba(nuevo);
        nuevo.setAbajo(getPrimero());
        setPrimero(getPrimero().getArriba());
    }
    
    public void InsertarFinal(NodoOrtogonal nuevo){
        getUltimo().setAbajo(nuevo);
        nuevo.setArriba(getUltimo());
        setUltimo(getUltimo().getAbajo());
    }
    
    public void InsertarMedio(NodoOrtogonal nuevo){
        NodoOrtogonal aux;
        NodoOrtogonal aux2;
        aux = getPrimero();
        while(aux.getY() < nuevo.getY()){
            aux = aux.getAbajo();
        }
        aux2 = aux.getArriba();
        aux2.setAbajo(nuevo);
        aux.setArriba(nuevo);
        nuevo.setAbajo(aux);
        nuevo.setArriba(aux2);
    }
    
    public void Recorrer(){
        if(!Vacia()){
            NodoOrtogonal aux = getPrimero();
            while(aux != null){
                System.out.println(aux.getY());
                aux = aux.getAbajo();
            }
        }
    }
    
    public boolean Vacia(){
        return getPrimero() == null;
    }

    /**
     * @return the primero
     */
    public NodoOrtogonal getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(NodoOrtogonal primero) {
        this.primero = primero;
    }

    /**
     * @return the ultimo
     */
    public NodoOrtogonal getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(NodoOrtogonal ultimo) {
        this.ultimo = ultimo;
    }
    
}
