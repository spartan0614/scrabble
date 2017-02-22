package matriz;
import java.io.File;
import java.io.FileWriter;
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
    
    public void Graficar(String path){ 
        File archivo;
        FileWriter file = null;
        String contenido;
        try {
            archivo = new File("C:\\Users\\ESTUARDO\\Desktop\\"+path+".txt");
            if(archivo.exists()){
                archivo.delete();
            }
            file = new FileWriter(archivo,true);
            contenido = CodigoInterno();
            file.write(contenido);

        } catch (Exception e) {
             System.err.println("Error al escribir el archivo matriz.txt");
        }finally{
            try{
                if(null!= file){
                    file.close();
                }
            }catch(Exception e2){
                 System.err.println("Error al cerrar el archivo matriz.dot");
            }
        }
        try {
            Runtime rt = Runtime.getRuntime();
            String[] cmd = new String[5];
            cmd[0] = "C:\\Program Files\\Graphviz2.38\\bin\\dot.exe";
            cmd[1] = "-Tpng";
            cmd[2] = "C:\\Users\\ESTUARDO\\Desktop\\"+path+".txt";
            cmd[3] = "-o";
            cmd[4] = "C:\\Users\\ESTUARDO\\Documents\\Josselyn\\"+path+".png";
            
            rt.exec(cmd);
            
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }
    } 
    
    
//    public String CodigoGraphviz(){
//        return "digraph Matriz{\n"+
//                CodigoInterno()+
//                "}\n";
//    }
    
    public String CodigoInterno(){
        
        NodoCabecera cabeceraH = c.getPrimero();
        String lineaGraph = "";
        int count = 0;
        
        do{
            count +=1;
            String aux1 = "Sub"+Integer.toString(count)+"{\n";
            lineaGraph += aux1;
            lineaGraph += "rank = same;\n";
            String aux2 = "";
            NodoOrtogonal Vaux = cabeceraH.getColumna().getPrimero();
            
            do{
                String coordenada = Integer.toString(Vaux.getX())+","+Integer.toString(Vaux.getY())+"\n";
                lineaGraph += coordenada;
                lineaGraph +="[shape = box];\n";
                aux2 = Integer.toString(Vaux.getValor());
                if(Vaux.getAbajo()!= null){
                    aux2 += "->";
                }else{
                    aux2 += "[constraint = false];\n";
                }
                Vaux = Vaux.getAbajo();
                
            }while(Vaux != null);
            lineaGraph += aux2;
            lineaGraph += "}\n";
            cabeceraH = cabeceraH.getSiguiente();
        }while(cabeceraH != null);
        
        
        NodoLateral cabeceraL = l.getPrimero();
        
        do{
            NodoOrtogonal Haux = cabeceraL.getFila().getPrimero();
            do{
                if(Haux.getDerecha() != null){
                    lineaGraph += "->";
                }else{
                    lineaGraph+= ";\n";
                }
                Haux = Haux.getDerecha();
            }while(Haux != null);
            cabeceraL = cabeceraL.getSiguiente();
        }while(cabeceraL != null);
        
        lineaGraph += "probando ->"+Integer.toString(c.getPrimero().getColumna().getPrimero().getValor());
        
        
        return lineaGraph;
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
