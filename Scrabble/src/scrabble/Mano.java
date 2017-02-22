//*********************************LISTA SIMPLE*************************************
package scrabble;

import java.io.File;
import java.io.FileWriter;

/* 
 @author DINORA
 */
public class Mano {
    private NodoFichas cabeza;
    
    public Mano(){
        cabeza = null;
    }
    
    public void Insertar(int idLetra, String letra, int valor){
        NodoFichas nuevo = new NodoFichas(idLetra, letra, valor);
        
        if(this.getCabeza() == null){
            setCabeza(nuevo);
        }else{
            NodoFichas aux = getCabeza();
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
          aux.setSiguiente(nuevo);
        }
    }
     public void Recorrer(){   
        NodoFichas mostrar;       
        for(mostrar = getCabeza(); mostrar != null; mostrar = mostrar.getSiguiente()){
            System.out.print(mostrar.getLetra()+"  ");
        }
    }     
    
     public void Eliminar(int entrada){
        NodoFichas actual, anterior;
        boolean encontrado;
        actual = getCabeza();
        anterior = null;
        encontrado = false;
        while((actual != null) && (!encontrado)){
            encontrado = (actual.getIdLetra() == entrada);
            if(!encontrado){
                anterior = actual;
                actual = actual.getSiguiente();
            }
        }
        
        if(actual != null){
            if (actual == getCabeza()){
                setCabeza(actual.getSiguiente());
            }else{
                anterior.setSiguiente(actual.getSiguiente());
            }
            actual = null;
        }
     
     }
    
    
    
     public void Graficar(String path, int turno){ 
        String cadena = Integer.toString(turno);
        File archivo;
        FileWriter file = null;
        String contenido;
        try {
            archivo = new File("C:\\Users\\ESTUARDO\\Desktop\\"+path+cadena+".txt");
            if(archivo.exists()){
                archivo.delete();
            }
            file = new FileWriter(archivo,true);
            contenido = CodigoGraphviz();
            file.write(contenido);

        } catch (Exception e) {
             System.err.println("Error al escribir el archivo .txt");
        }finally{
            try{
                if(null!= file){
                    file.close();
                }
            }catch(Exception e2){
                 System.err.println("Error al cerrar el archivo .dot");
            }
        }
        try {
            Runtime rt = Runtime.getRuntime();
            String[] cmd = new String[5];
            cmd[0] = "C:\\Program Files\\Graphviz2.38\\bin\\dot.exe";
            cmd[1] = "-Tpng";
            cmd[2] = "C:\\Users\\ESTUARDO\\Desktop\\"+path+cadena+".txt";
            cmd[3] = "-o";
            cmd[4] = "C:\\Users\\ESTUARDO\\Documents\\Josselyn\\"+path+cadena+".png";
            
            rt.exec(cmd);
            
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }
    } 
     
     public String CodigoGraphviz(){
        return "digraph Mano{\n"+
                CodigoInterno()+
                "}\n";
    }
    
    public String CodigoInterno(){
        String lineaGraph = "";
        if(getCabeza() == null){
            lineaGraph = "Sin palabras"; 
        }else{
            NodoFichas aux = getCabeza();
            lineaGraph +="Inicio -> ";
            while(aux!= null){
                    lineaGraph += aux.getLetra()+ "->";
                    aux = aux.getSiguiente();
            }
           lineaGraph += "Final;\n";
        }
        return lineaGraph;
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
}
