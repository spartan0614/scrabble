//*********************************CIRCULAR SIMPLE**********************************
package scrabble;

import java.io.File;
import java.io.FileWriter;

/*
@author DINORA
 */
public class Jugador {
    private NodoJugador cabeza;
    private NodoJugador ultimo;
    
    public Jugador(){
        cabeza = null;
        ultimo = null;
    }
    
    public void Insertar(int number, String user, Mano misFichas){
        NodoJugador nuevo = new NodoJugador(number, user, misFichas);
     
        if(getCabeza() == null){
            setCabeza(nuevo);
            setUltimo(nuevo);
            getUltimo().setSiguiente(getCabeza());
        }else{
            getUltimo().setSiguiente(nuevo);
            nuevo.setSiguiente(getCabeza());
            setUltimo(nuevo);
        }
    }
    
    public boolean esVacia(){
        return getCabeza()==null;
    }
    
   
    public void Recorrer(){
        if (!esVacia()){
            NodoJugador aux = getCabeza();
            do{
                System.out.println(aux.getNumber() + "    "+ aux.getUser() + "   Sus fichas:   ");
                aux.getMisFichas().Recorrer();
                
                aux = aux.getSiguiente();
            }while(aux != getCabeza());
        }    
    }
    
     public int Contar(){
        int total = 1;
         NodoJugador aux = getCabeza();
            while(aux.getSiguiente() != getCabeza()){
                total ++;
                aux = aux.getSiguiente();
            } 
        return total; 
    }
     
    public void Graficar(String path){ 
        File archivo;
        FileWriter file = null;
        String contenido;
        try {
            archivo = new File("C:\\Users\\ESTUARDO\\Desktop\\"+path+".txt");
            if(archivo.exists()){
                archivo.delete();
            }else{
                file = new FileWriter(archivo,true);
                contenido = CodigoGraphviz();
                file.write(contenido);
            }
            
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
            NodoJugador aux = getCabeza();
            //lineaGraph += aux.getUser()+ "-> ";
            do{
                lineaGraph += aux.getUser()+"->";
                aux = aux.getSiguiente();
            }while(aux!= getCabeza());
            
           lineaGraph += getCabeza().getUser();
        }
        return lineaGraph;
    } 
    

    /**
     * @return the cabeza
     */
    public NodoJugador getCabeza() {
        return cabeza;
    }

    /**
     * @param cabeza the cabeza to set
     */
    public void setCabeza(NodoJugador cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * @return the ultimo
     */
    public NodoJugador getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(NodoJugador ultimo) {
        this.ultimo = ultimo;
    }

}
