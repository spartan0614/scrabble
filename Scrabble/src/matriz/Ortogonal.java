package matriz;
import java.util.ArrayList;
import java.util.List;
/*
    @author DINORA
 */
public class Ortogonal {
    private Cabeceras c;
    private Laterales l;
    boolean tieneMayorValor = false;
    
    List<Integer> xDobles = new ArrayList<>();
    List<Integer> yDobles = new ArrayList<>();
    List<Integer> xTriples = new ArrayList<>();
    List<Integer> yTriples = new ArrayList<>();
    
    public Ortogonal(){
        c = new Cabeceras();
        l = new Laterales();
    }
    
    public void GetDoubleX(List<Integer> xD){
        xDobles = xD;
    }
    public void GetDoubleY(List<Integer> yD){
        yDobles = yD;
    }
    public void GetTripleX(List<Integer> xT){
        xTriples = xT;
    }
    public void GetTripleY(List<Integer> yT){
        yTriples= yT;
    }
    
    
    public void Insertar(int x, int y, int valor, boolean taken){ 
        NodoOrtogonal nuevo = new NodoOrtogonal(x,y,valor,taken);
        
        if(getC().Existe(x)== false){
            getC().Insertar(x);
        }
        if(getL().Existe(y)== false){
            getL().Insertar(y);
        }
        NodoCabecera auxC;
        NodoLateral auxL;
        auxC = getC().Busqueda(x);
        auxL = getL().Busqueda(y);
        
        auxC.getColumna().Insertar(nuevo);
        auxL.getFila().Insertar(nuevo);
        System.out.println();
    }
    
    public void Llenar(int x, int y){
        for(int i= 0; i<x; i++){
            for(int j = 0; j<y; j++){
               
                Insertar(i,j,1,false);
                
//                for(int k = 0; k<xDobles.size(); k++){
//                    if(xDobles.get(k)== i && yDobles.get(k) == j ){
//                        Insertar(i,j,2,false);
//                       
//                    }
//                }
//                for(int w = 0; w<xTriples.size(); w++){
//                    if(xTriples.get(w)== i && yTriples.get(w) == j ){
//                        Insertar(i,j,3,false);
//                    }
//                }
               
            }
        }     
    } 

    /**
     * @return the c
     */
    public Cabeceras getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Cabeceras c) {
        this.c = c;
    }

    /**
     * @return the l
     */
    public Laterales getL() {
        return l;
    }

    /**
     * @param l the l to set
     */
    public void setL(Laterales l) {
        this.l = l;
    }
}
