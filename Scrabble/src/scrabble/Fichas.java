//**************************************** COLA ************************************
package scrabble;

import java.io.File;
import java.io.FileWriter;

/*
  @author DINORA
 */
public class Fichas {
    private NodoFichas cabeza;
    private NodoFichas fin;
    
    public Fichas(){
        cabeza = null;
        fin = null;
    }
    
    public void Insertar(int idLetra, String letra, int valor){
        NodoFichas nuevo = new NodoFichas(idLetra, letra, valor);
    
        if(this.getCabeza() == null && this.getFin() == null){
            setCabeza(nuevo);
        }else{
            fin.setSiguiente(nuevo);
        }
    setFin(nuevo);
    }
    
    
    public NodoFichas Quitar(){   //sale un elemento frente y retorna la ficha que se sacó
        NodoFichas aux = null;
        if (!colaVacia()){
            aux = getCabeza();
            setCabeza(getCabeza().getSiguiente());
        }else{
            System.out.print("No se puede eliminar de una cola vacia");
        }
        return aux;
    }
    
    public boolean colaVacia(){
        return (getCabeza() == null);
    }
    
    public void Imprimir(){
        NodoFichas aux;
        for(aux = getCabeza(); aux != null; aux = aux.getSiguiente()){
            System.out.print(aux.getLetra() + "    ");
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
            cmd[2] = "C:\\Users\\ESTUARDO\\Desktop\\"+path+".txt";
            cmd[3] = "-o";
            cmd[4] = "C:\\Users\\ESTUARDO\\Documents\\Josselyn\\"+path+".png";
            
            rt.exec(cmd);
            
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }
    } 
     
     public String CodigoGraphviz(){
        return "digraph Fichas{\n"+
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
            while(aux!= getFin()){
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

    /**
     * @return the fin
     */
    public NodoFichas getFin() {
        return fin;
    }

    /**
     * @param fin the fin to set
     */
    public void setFin(NodoFichas fin) {
        this.fin = fin;
    }
    
}
