package matriz;

/*
    @author DINORA
 */
public class ListaHorizontal {
    private NodoOrtogonal primero;
    private NodoOrtogonal ultimo;
    
    public ListaHorizontal(){
        primero = null;
        ultimo = null;
    }
    
    public void Insertar(NodoOrtogonal nuevo){ 
        if(Vacia()){
            primero = ultimo = nuevo;   
        }else{
            if(nuevo.getX() < getPrimero().getX()){
                InsertarFrente(nuevo);
            }else if(nuevo.getX() > getUltimo().getX()){
                InsertarFinal(nuevo);
            }else{
                InsertarMedio(nuevo);
            }
        }
    }
    
    public void InsertarFrente(NodoOrtogonal nuevo){
        getPrimero().setIzquierda(nuevo);
        nuevo.setDerecha(getPrimero());
        setPrimero(getPrimero().getIzquierda());
    }
    
    public void InsertarFinal(NodoOrtogonal nuevo){
        getUltimo().setDerecha(nuevo);
        nuevo.setIzquierda(getUltimo());                              
        setUltimo(getUltimo().getDerecha());                       
    }
    
    public void InsertarMedio(NodoOrtogonal nuevo){
        NodoOrtogonal aux;
        NodoOrtogonal aux2;
        aux = getPrimero();
        while(aux.getX() < nuevo.getX()){
            aux = aux.getDerecha();
        }
        aux2 = aux.getIzquierda();
        aux2.setDerecha(nuevo);
        aux.setIzquierda(nuevo);
        nuevo.setDerecha(aux);
        nuevo.setIzquierda(aux2);
    }
    
    public void Recorrer(){
        if(!Vacia()){
            NodoOrtogonal aux = getPrimero();
            while(aux != null){
                System.out.println(aux.getX());
                aux = aux.getDerecha();
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
