package scrabble;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
  @author DINORA
 */
public class Principal extends javax.swing.JFrame {
    public Dictionary listDictionary;
    public Fichas pieza;
    public AddGamers send;
    int dimension = 0;
    List<Integer> xDobles = new ArrayList();
    List<Integer> yDobles = new ArrayList();
    List<Integer> xTriples = new ArrayList();
    List<Integer> yTriples = new ArrayList();
    
    
    int A = 0; //1
    int E = 0; //2
    int O = 0; //3
    int I = 0; //4
    int S = 0; //5
    int N = 0; //6
    int L = 0; //7
    int R = 0; //8
    int U = 0; //9
    int T = 0; //10
    int D = 0; //11
    int G = 0; //12
    int C = 0; //13
    int B = 0; //14
    int M = 0; //15
    int P = 0; //16
    int H = 0; //17
    int F = 0; //18
    int V = 0; //19
    int Y = 0; //20
    int Q = 0; //21
    int J = 0; //22
    int Ñ = 0; //23
    int X = 0; //24
    int Z = 0; //25
    boolean all = false; //indicará si ya están repartidas las 95 fichas.
    int contador = 0;
    int[] coins = new int[95];
    
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        listDictionary = new Dictionary();
        pieza = new Fichas();
        send = new AddGamers();
    }

    public void leerArchivo(){
        JFileChooser fc = new JFileChooser();       //abriendo ventana para selección de archivo XML
        int seleccion = fc.showOpenDialog(fc);
        
        if(seleccion == JFileChooser.APPROVE_OPTION){ //si se da en aceptar
           File fichero = fc.getSelectedFile();
           
           DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(fichero.getAbsolutePath());
                
                NodeList diccionary = doc.getElementsByTagName("diccionario");   //etiqueta <diccionario>
                Node p = diccionary.item(0);
                Element words = (Element) p;
                NodeList wordList = words.getElementsByTagName("palabra");  //etiqueta <palabra>
                for(int i = 0; i< wordList.getLength(); i++){                
                    Node theWord = wordList.item(i);                     
                    Element wordElement = (Element) theWord;
                    listDictionary.Insertar(wordElement.getTextContent());
                }
                
                NodeList tamaño = doc.getElementsByTagName("dimension");   //etiqueta <dimension>
                Node t = tamaño.item(0);
                Element lenghtElement = (Element) t;
                dimension = Integer.parseInt(lenghtElement.getTextContent());
                System.out.println(dimension);
                
                NodeList dobles = doc.getElementsByTagName("dobles");       //etiqueta <dobles>
                Node d = dobles.item(0);
                Element plustwo = (Element) d;
                NodeList sectionD = plustwo.getElementsByTagName("casilla");  //etiqueta <casilla>
                for(int k = 0; k< sectionD.getLength(); k++){
                    Node NodeDouble = sectionD.item(k);
                        if(NodeDouble.getNodeType() == Node.ELEMENT_NODE){
                            Element ElementDouble = (Element) NodeDouble;
                            xDobles.add(Integer.parseInt(ElementDouble.getElementsByTagName("x").item(0).getTextContent()));
                            yDobles.add(Integer.parseInt(ElementDouble.getElementsByTagName("y").item(0).getTextContent()));   
                        }                   
                }
                
                NodeList triples = doc.getElementsByTagName("triples");       //etiqueta <triples>
                Node t3 = triples.item(0);
                Element plusthree = (Element) t3;
                NodeList sectionT = plusthree.getElementsByTagName("casilla");  //etiqueta <casilla>
                for(int q = 0; q< sectionT.getLength(); q++){
                    Node NodeT = sectionT.item(q);
                        if(NodeT.getNodeType() == Node.ELEMENT_NODE){
                            Element ElementTriple = (Element) NodeT;
                            xTriples.add(Integer.parseInt(ElementTriple.getElementsByTagName("x").item(0).getTextContent()));
                            yTriples.add(Integer.parseInt(ElementTriple.getElementsByTagName("y").item(0).getTextContent()));   
                        }                   
                }
              
                
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    public void RevolverFichas(){ 
        while (!all){
            Random aleatorio = new Random();
            int numero = aleatorio.nextInt(25)+1;
            
            if(A==12 && E==12 && O==9 && I==6 && S==6 && N==5 && L==4 && R==5 && U==5 && T==4 && D==5 && G==2 &&
               C==4 && B==2 && M==2 && P==2 && H==2 && F==1 && V==1 && Y==1 && Q==1 && J==1 && Ñ==1 && X==1 && Z==1){
                    all = true;
            } else {
                if(numero==1 && A<12){ 
                    coins[contador] = numero;
                    A +=1;
                    contador +=1;
                }
                if(numero==2 && E<12){
                    coins[contador] = numero;
                    E += 1;
                    contador +=1;
                }
                if(numero==3 && O<9){
                    coins[contador] = numero;
                    O +=1;
                    contador +=1;
                }
                if(numero==4 && I<6){
                    coins[contador] = numero;
                    I +=1;
                    contador +=1;
                }
                if(numero==5 && S<6){
                    coins[contador] = numero;
                    S +=1;
                    contador +=1;
                }
                if(numero==6 && N<5){
                    coins[contador] = numero;
                    N +=1;
                    contador +=1;
                }
                if(numero==7 && L<4){
                    coins[contador] = numero;
                    L +=1;
                    contador +=1;
                }
                if(numero==8 && R<5){
                    coins[contador] = numero;
                    R +=1;
                    contador +=1;
                }
                if(numero==9 && U<5){
                    coins[contador] = numero;
                    U +=1;
                    contador +=1;
                }
                if(numero==10 && T<4){
                    coins[contador] = numero;
                    T +=1;
                    contador +=1;
                }
                if(numero==11 && D<5){
                    coins[contador] = numero;
                    D +=1;
                    contador +=1;
                }
                if(numero==12 && G<2){
                    coins[contador] = numero;
                    G +=1;
                    contador +=1;
                }
                if(numero==13 && C<4){
                    coins[contador] = numero;
                    C +=1;
                    contador +=1;
                }
                if(numero==14 && B<2){
                    coins[contador] = numero;
                    B +=1;
                    contador +=1;
                }
                if(numero==15 && M<2){
                    coins[contador] = numero;
                    M +=1;
                    contador +=1;
                }
                if(numero==16 && P<2){
                    coins[contador] = numero;
                    P +=1;
                    contador +=1;
                }
                if(numero==17 && H<2){
                    coins[contador] = numero;
                    H +=1;
                    contador +=1;
                }
                if(numero==18 && F<1){
                    coins[contador] = numero;
                    F +=1;
                    contador +=1;
                }
                if(numero==19 && V<1){
                    coins[contador] = numero;
                    V +=1;
                    contador +=1;
                }
                if(numero==20 && Y<1){
                    coins[contador] = numero;
                    Y +=1;
                    contador +=1;                    
                }
                if(numero==21 && Q<1){
                    coins[contador] = numero;                    
                    Q +=1;
                    contador +=1;                    
                }
                if(numero==22 && J<1){
                    coins[contador] = numero;
                    J +=1;
                    contador +=1;
                }
                if(numero==23 && Ñ<1){
                    coins[contador] = numero;
                    Ñ +=1;
                    contador +=1;
                }
                if(numero==24 && X<1){
                    coins[contador] = numero;   
                    X +=1;
                    contador +=1; 
                }
                if(numero==25 && Z<1){
                    coins[contador] = numero;
                    Z +=1;
                    contador +=1;  
                }
            }//fin IF principal
            System.out.println();
        } //fin de while
    } 
    
    public void FichasEnCola(){
        for(int i=0; i< coins.length; i++){
            if(coins[i] == 1){     //A
                pieza.Insertar("A", 1);
            }
            if(coins[i] == 2){      //E
                pieza.Insertar("E", 1);
            }
            if(coins[i] == 3){      //O
                pieza.Insertar("O", 1);
            }
            if(coins[i] == 4){      //I
                pieza.Insertar("I", 1);
            }
            if(coins[i] == 5){      //S
                pieza.Insertar("S", 1);
            }
            if(coins[i] == 6){      //N
                pieza.Insertar("N", 1);
            }
            if(coins[i] == 7){      //L
                pieza.Insertar("L", 1);
            }
            if(coins[i] == 8){      //R
                pieza.Insertar("R", 1);
            }
            if(coins[i] == 9){      //U
                pieza.Insertar("U", 1);
            }
            if(coins[i] == 10){     //T
                pieza.Insertar("T",1);
            }
            if(coins[i] == 11){     //D
                pieza.Insertar("D", 2);
            }
            if(coins[i] == 12){     //G
                pieza.Insertar("G", 2);
            }
            if(coins[i] == 13){     //C
                pieza.Insertar("C", 3);
            }
            if(coins[i] == 14){     //B
                pieza.Insertar("B", 3);
            }
            if(coins[i] == 15){     //M
                pieza.Insertar("M", 3);
            }
            if(coins[i] == 16){     //P
                pieza.Insertar("P", 3);
            }
            if(coins[i] == 17){     //H
                pieza.Insertar("H", 4);
            }
            if(coins[i] == 18){     //F
                pieza.Insertar("F", 4);
            }
            if(coins[i] == 19){     //V
                pieza.Insertar("V", 4);
            }
            if(coins[i] == 20){     //Y
                pieza.Insertar("Y", 4);
            }
            if(coins[i] == 21){     //Q
                pieza.Insertar("Q", 5);
            }
            if(coins[i] == 22){     //J
                pieza.Insertar("J", 8);
            }
            if(coins[i] == 23){     //Ñ
                pieza.Insertar("Ñ", 8);
            }
            if(coins[i] == 24){     //X
                pieza.Insertar("X", 8);
            }
            if(coins[i] == 25){     //Z
                pieza.Insertar("Z", 10);
            }
        }
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnArchivo = new javax.swing.JButton();
        btnJugar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnArchivo.setText("Leer archivo");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        btnJugar.setText("Jugar");
        btnJugar.setEnabled(false);
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ESTUARDO\\Documents\\NetBeansProjects\\Scrabble\\scrabble.png")); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        leerArchivo();
        btnJugar.setEnabled(true);
       
    }//GEN-LAST:event_btnArchivoActionPerformed

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        RevolverFichas();               //Revolviendo Fichas
        FichasEnCola();                 //Ingresando 95 fichas en cola
        send.GetLista(pieza);           //Enviando 95 fichas
        listDictionary.Graficar();      //Graficando la lista simple de palabras que contiene el diccionario.
         for(int i=0; i<xDobles.size(); i++){
                System.out.println("Dobles: " + i + "   " + xDobles.get(i).toString() + yDobles.get(i).toString());
                System.out.println("Triples: " + i + "   " + xTriples.get(i).toString() + yTriples.get(i).toString());
        }  
        
        send.setVisible(true);          
    }//GEN-LAST:event_btnJugarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnJugar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
