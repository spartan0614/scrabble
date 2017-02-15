//**************************************LISTA SIMPLE*************************************
package scrabble;
import java.io.File;
import java.io.FileWriter;

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

    public void Graficar(){ 
        File archivo;
        FileWriter file = null;
        String contenido;
        
        try {
            archivo = new File("C:\\Users\\ESTUARDO\\Desktop\\grafico.txt");
            file = new FileWriter(archivo,true);
            contenido = CodigoGraphviz();
            file.write(contenido);
            //file.write("Hola mundo");
            
        } catch (Exception e) {
             System.err.println("Error al escribir el archivo grafico.txt");
        }finally{
            try{
                if(null!= file){
                    file.close();
                }
            }catch(Exception e2){
                 System.err.println("Error al cerrar el archivo aux_grafico.dot");
            }
        }
  
        try {
            Runtime rt = Runtime.getRuntime();
            String[] cmd = new String[5];
            cmd[0] = "C:\\Program Files\\Graphviz2.38\\bin\\dot.exe";
            cmd[1] = "-Tpng";
            cmd[2] = "C:\\Users\\ESTUARDO\\Desktop\\grafico.txt";
            cmd[3] = "-o";
            cmd[4] = "C:\\Users\\ESTUARDO\\Documents\\Josselyn\\dic.png";
            
            rt.exec(cmd);
            
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }
    } 
    
    
    public String CodigoGraphviz(){
        return "digraph Diccionario{\n"+
                CodigoInterno()+
                "}\n";
    }
    
    public String CodigoInterno(){
        String lineaGraph = "";
        if(getCabeza() == null){
            lineaGraph = "Sin palabras"; 
        }else{
            NodoDic aux = getCabeza();
            lineaGraph +="Inicio -> ";
            while(aux!= null){
                    lineaGraph += aux.getPalabra() + "->";
                    aux = aux.getSiguiente();
            }
           lineaGraph += "Final;\n";
        }
        return lineaGraph;
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
