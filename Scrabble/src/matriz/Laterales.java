package matriz;

/*
    @author DINORA
 */
public class Laterales {
    private NodoLateral primero;
    private NodoLateral ultimo;
    
    public Laterales(){
        primero = null;
        ultimo = null;
    }
    
public void Insertar(int Y){
        NodoLateral nuevo = new NodoLateral(Y);
        
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
    
    public void InsertarFrente(NodoLateral nuevo){
        getPrimero().setAnterior(nuevo);
        nuevo.setSiguiente(getPrimero());
        setPrimero(getPrimero().getAnterior());
    }
    
    public void InsertarFinal(NodoLateral nuevo){
        getUltimo().setSiguiente(nuevo);
        nuevo.setAnterior(getUltimo());                              
        setUltimo(getUltimo().getSiguiente());                       
    }
    
    public void InsertarMedio(NodoLateral nuevo){
        NodoLateral aux;
        NodoLateral aux2;
        aux = getPrimero();
        while(aux.getY() < nuevo.getY()){
            aux = aux.getSiguiente();
        }
        aux2 = aux.getAnterior();
        aux2.setSiguiente(nuevo);
        aux.setAnterior(nuevo);
        nuevo.setSiguiente(aux);
        nuevo.setAnterior(aux2);
    }
    
    public void Recorrer(){
        if(!Vacia()){
            NodoLateral aux = getPrimero();
            while(aux != null){
                System.out.println(aux.getY());
                aux = aux.getSiguiente();
            }
        }
    }
    
    public boolean Existe(int y){
        if(Vacia()){
            return false;
        }else{
            NodoLateral aux;
            aux = getPrimero();
            while(aux != null){
                if(aux.getY() == y){
                    //System.out.println("SI EXISTE");
                    return true;
                }else if(aux.getSiguiente() == null){
        
                    return false;
                }
            aux = aux.getSiguiente();
            }
        }
        return false;
    }
    
    public NodoLateral Busqueda(int y){
        if (Existe(y)){
            NodoLateral aux;
            aux = getPrimero();
            while(aux.getY() != y){
                aux = aux.getSiguiente();
            }
            //System.out.print(aux.getY());
            return aux;
        }else {
            
        }
        return null;
    }
    
    public boolean Vacia(){
        return getPrimero() == null;
    }    
 
    /**
     * @return the primero
     */
    public NodoLateral getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(NodoLateral primero) {
        this.primero = primero;
    }

    /**
     * @return the ultimo
     */
    public NodoLateral getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(NodoLateral ultimo) {
        this.ultimo = ultimo;
    }
}
