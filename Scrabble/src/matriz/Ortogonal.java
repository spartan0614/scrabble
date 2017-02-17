package matriz;
import java.util.ArrayList;
import java.util.List;
/*
    @author DINORA
 */
public class Ortogonal {
    private Cabeceras c;
    private Laterales l;
    List<Integer> xDobles = new ArrayList();
    List<Integer> yDobles = new ArrayList();
    List<Integer> xTriples = new ArrayList();
    List<Integer> yTriples = new ArrayList();
    
    public Ortogonal(){
        c = new Cabeceras();
        l = new Laterales();
    }
    
    public void GetDoubleX(List<Integer> xD){
        xDobles = xD;
    }
    public void GetDoubleY(List<Integer> yD){
        xDobles = yD;
    }
    public void GetTripleX(List<Integer> xT){
        xDobles = xT;
    }
    public void GetTripleY(List<Integer> yT){
        xDobles = yT;
    }
    
    public void Insertar(int x, int y, int valor, boolean taken){ 
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
        
        auxC.getColumna().Insertar(x, y, valor, taken);
        auxL.getFila().Insertar(x, y, valor, taken);
        System.out.println();
    }
    
    public void Llenar(int x, int y){
        for(int j= 0; j<y; j++){
            for(int i = 0; i<x; i++){
                Insertar(i,j,1,false);
            }
        System.out.println();
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
