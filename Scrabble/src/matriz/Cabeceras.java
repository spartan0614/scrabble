package matriz;

/*
    @author DINORA
 */
public class Cabeceras {
    private NodoCabecera primero;
    private NodoCabecera ultimo;
    
    public Cabeceras(){
        primero = null;
        ultimo = null;
    }
    
public void Insertar(int X){
        NodoCabecera nuevo = new NodoCabecera(X);
        
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
    
    public void InsertarFrente(NodoCabecera nuevo){
        getPrimero().setAnterior(nuevo);
        nuevo.setSiguiente(getPrimero());
        setPrimero(getPrimero().getAnterior());
    }
    
    public void InsertarFinal(NodoCabecera nuevo){
        getUltimo().setSiguiente(nuevo);
        nuevo.setAnterior(getUltimo());                              
        setUltimo(getUltimo().getSiguiente());                       
    }
    
    public void InsertarMedio(NodoCabecera nuevo){
        NodoCabecera aux;
        NodoCabecera aux2;
        aux = getPrimero();
        while(aux.getX() < nuevo.getX()){
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
            NodoCabecera aux = getPrimero();
            while(aux != null){
                System.out.println(aux.getX());
                aux = aux.getSiguiente();
            }
        }
    }
    
    public boolean Existe(int x){
        NodoCabecera aux;
        aux = getPrimero();
            while(aux != null){
                if(aux.getX() == x){
                    //System.out.println("SI EXISTE");
                    return true;
                }else if(aux.getSiguiente() == null){
        
                    return false;
                }
            aux = aux.getSiguiente();
            }
        return false;
    }
    
    public NodoCabecera Busqueda(int x){
        if (Existe(x)){
            NodoCabecera aux;
            aux = getPrimero();
            while(aux.getX() != x){
                aux = aux.getSiguiente();
            }
             //System.out.println(aux.getX());
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
    public NodoCabecera getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(NodoCabecera primero) {
        this.primero = primero;
    }

    /**
     * @return the ultimo
     */
    public NodoCabecera getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(NodoCabecera ultimo) {
        this.ultimo = ultimo;
    }
    
   

    
    
}
