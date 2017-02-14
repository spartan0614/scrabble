//**************************************LISTA SIMPLE*************************************
package scrabble;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        FileWriter file = null;
        PrintWriter writer;
        try {
            file = new FileWriter("C:\\Users\\ESTUARDO\\Documents\\grafico.txt");
            writer = new PrintWriter(file);
            writer.print(CodigoGraphviz());   
        } catch (Exception e) {
             System.err.println("Error al escribir el archivo grafico.txt");
        }
  
        try {
            Runtime rt = Runtime.getRuntime();
            String[] cmd = new String[5];
            cmd[0] = "C:\\Program Files\\Graphviz2.38\\bin\\dot.exe";
            cmd[1] = "-Tpng";
            cmd[2] = "C:\\Users\\ESTUARDO\\Documents\\grafico.txt";
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
        String lineaGraph = null;
        if(getCabeza() == null){
            lineaGraph = "Sin palabras"; 
        }else{
            NodoDic aux = getCabeza();
            while(aux!= null){
                if (lineaGraph == null){
                    lineaGraph = aux.getPalabra() + "->" + aux.getSiguiente().getPalabra() +";\n";
                    aux = aux.getSiguiente();
                }
                    lineaGraph += aux.getPalabra() + "->" + aux.getSiguiente().getPalabra() +";\n";
                    aux = aux.getSiguiente();
            }
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
