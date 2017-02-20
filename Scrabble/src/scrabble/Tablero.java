package scrabble;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import matriz.*;

/*
 @author DINORA
 */
public class Tablero extends javax.swing.JFrame {

    Image img;
    int dimension;
    JButton[][] table;
    JButton[] fichasEnJuego = new JButton[7];
    int movX = 3;
    int movY = 3;
    Ortogonal matrix;
    Jugador gamers;
    Fichas fichasDisponibles;
    
    
    public void ObtenerDimension(int tamaño){
        dimension = tamaño;
    }
    
    public void GetMatrizLogica(Ortogonal matriz){
        matrix = matriz;
    }
    
    public void GetJugadores(Jugador gamer){
        gamers = gamer;
    }
    
    public void GetTodasFichas(Fichas todas){
        fichasDisponibles = todas;
    }
    
    
    public Tablero() {
        initComponents();
    }
     
    public void Mostrando(){
            
            
            table = new JButton[dimension][dimension];
            for(int i =0; i<dimension; i++){
                for(int j=0; j<dimension; j++){
                    table[i][j] = new JButton();
                    table[i][j].setBounds(movX, movY, 33,33);
                    
                    if (ValorNodo(i,j) == 3){
                        table[i][j].setBackground(Color.red);
                        
                    }
                    
                    if (ValorNodo(i,j) == 2){
                        table[i][j].setBackground(Color.yellow);
                       
                    }
                    movX += 34;
                    add(table[i][j]);
                }
                movY += 34;
                movX = 3;   
            }
        
        fichasEnJuego[0] = btnMano0;
        fichasEnJuego[1] = btnMano1;
        fichasEnJuego[2] = btnMano2;
        fichasEnJuego[3] = btnMano3;
        fichasEnJuego[4] = btnMano4;
        fichasEnJuego[5] = btnMano5;
        fichasEnJuego[6] = btnMano6;  
    
        PrimerTurno();
     }
    
    public void PrimerTurno(){
        Random aleatorio = new Random();
        int numero = aleatorio.nextInt(gamers.Contar())+1;
        
        BuscandoPrimero(numero);
    }
    
    public void BuscandoPrimero(int numero){
        Graficos();
        
        NodoJugador aux;                                                
        aux = gamers.getCabeza();                               //aux = primer jugador de la lista
            do{                                                 //realizar el recorrido mientras aux no sea la cabeza de nuevo
                if(aux.getNumber() == numero){                  //Si el el numero del nodo auxiliar es igual al número random                          
                    Turno(aux);
                    break;
                }
                aux = aux.getSiguiente();
            }while(aux != gamers.getCabeza());
            
                          
    }
    
    public void Turno(NodoJugador turno){
        int indice = 0;  
        jLabelTurno.setText(turno.getUser());         //Le damos al label el nombre del jugador del turno
        NodoFichas fichasTurno;                     //Recorriendo las fichas del jugador turno
            for(fichasTurno = turno.getMisFichas().getCabeza(); fichasTurno != null; fichasTurno = fichasTurno.getSiguiente()){
                if(indice == 7){   //Quitar cuando cada jugador tengan sus 7 fichas.
                    break;
                }
                fichasEnJuego[indice].setText(fichasTurno.getLetra());  //mostrar cada ficha en cada boton de fichasActivas.
                indice++;
            }  
    }
    
    public void Graficos(){
        fichasDisponibles.Graficar("fichas");
        ImageIcon cot = new ImageIcon("C:\\Users\\ESTUARDO\\Documents\\Josselyn\\fichas.png"); //Mostrando Diccionario.
        Icon z = new ImageIcon(cot.getImage().getScaledInstance(jLabelCoins.getWidth(), jLabelCoins.getHeight(), Image.SCALE_DEFAULT));
        jLabelCoins.setIcon(z);
        this.repaint();
        
        fichasDisponibles.Graficar("fichas");
        ImageIcon fot = new ImageIcon("C:\\Users\\ESTUARDO\\Documents\\Josselyn\\fichas.png"); //Mostrando Fichas actuales
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(jLabelCoins.getWidth(), jLabelCoins.getHeight(), Image.SCALE_DEFAULT));
        jLabelCoins.setIcon(icono);
        this.repaint();
        
        gamers.Graficar("jugadores");
        ImageIcon im = new ImageIcon("C:\\Users\\ESTUARDO\\Documents\\Josselyn\\jugadores.png"); //Mostrando Jugadores
        Icon ic = new ImageIcon(im.getImage().getScaledInstance(jLabelJugadores.getWidth(), jLabelJugadores.getHeight(), Image.SCALE_DEFAULT));
        jLabelCoins.setIcon(ic);
        this.repaint();
    }
    
    
    public int ValorNodo(int x, int y){
        NodoCabecera nodoGuia;          //nodo cabecera que nos ayudará para la búsqueda
        NodoOrtogonal nodoOrto;             //nodo ortogonal del cual necesitamos valor.
       
        nodoGuia = matrix.getC().Busqueda(x);
        nodoOrto = nodoGuia.getColumna().getPrimero();
        System.out.println();
        for(int i =0; i<y; i++){
            nodoOrto = nodoOrto.getAbajo();
        }
        return nodoOrto.getValor();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanelGamers = new javax.swing.JPanel();
        jLabelJugadores = new javax.swing.JLabel();
        jPanelDic = new javax.swing.JPanel();
        jLabelDic = new javax.swing.JLabel();
        jPanelCoins = new javax.swing.JPanel();
        jLabelCoins = new javax.swing.JLabel();
        jPanelMano = new javax.swing.JPanel();
        jPanelMatriz = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnMano0 = new javax.swing.JButton();
        btnMano1 = new javax.swing.JButton();
        btnMano2 = new javax.swing.JButton();
        btnMano3 = new javax.swing.JButton();
        btnMano4 = new javax.swing.JButton();
        btnMano5 = new javax.swing.JButton();
        btnMano6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        btnAddWord = new javax.swing.JButton();
        btnValidar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabelTurno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);

        jTabbedPane4.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N

        jLabelJugadores.setText("jLabel4");

        javax.swing.GroupLayout jPanelGamersLayout = new javax.swing.GroupLayout(jPanelGamers);
        jPanelGamers.setLayout(jPanelGamersLayout);
        jPanelGamersLayout.setHorizontalGroup(
            jPanelGamersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelJugadores, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        jPanelGamersLayout.setVerticalGroup(
            jPanelGamersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelJugadores, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Jugadores", jPanelGamers);

        javax.swing.GroupLayout jPanelDicLayout = new javax.swing.GroupLayout(jPanelDic);
        jPanelDic.setLayout(jPanelDicLayout);
        jPanelDicLayout.setHorizontalGroup(
            jPanelDicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDicLayout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(jLabelDic, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        jPanelDicLayout.setVerticalGroup(
            jPanelDicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDicLayout.createSequentialGroup()
                .addComponent(jLabelDic, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Diccionario", jPanelDic);

        javax.swing.GroupLayout jPanelCoinsLayout = new javax.swing.GroupLayout(jPanelCoins);
        jPanelCoins.setLayout(jPanelCoinsLayout);
        jPanelCoinsLayout.setHorizontalGroup(
            jPanelCoinsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCoins, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        jPanelCoinsLayout.setVerticalGroup(
            jPanelCoinsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCoins, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Fichas", jPanelCoins);

        jPanelMano.setToolTipText("");

        javax.swing.GroupLayout jPanelManoLayout = new javax.swing.GroupLayout(jPanelMano);
        jPanelMano.setLayout(jPanelManoLayout);
        jPanelManoLayout.setHorizontalGroup(
            jPanelManoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanelManoLayout.setVerticalGroup(
            jPanelManoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Mano Jugador", jPanelMano);

        javax.swing.GroupLayout jPanelMatrizLayout = new javax.swing.GroupLayout(jPanelMatriz);
        jPanelMatriz.setLayout(jPanelMatrizLayout);
        jPanelMatrizLayout.setHorizontalGroup(
            jPanelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanelMatrizLayout.setVerticalGroup(
            jPanelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Matriz de tablero", jPanelMatriz);

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel1.setText("Reportes");

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel2.setText("Mano Jugador Activo");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setAutoscrolls(false);
        jScrollPane2.setViewportView(jTextArea2);

        btnAddWord.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        btnAddWord.setText("Agregar");

        btnValidar.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        btnValidar.setText("Validar Tiro");
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        btnCancelar.setText("Cancelar Tiro");

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel3.setText("Turno:");

        jLabelTurno.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(737, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAddWord)
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelTurno)
                                .addGap(67, 67, 67))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(104, 104, 104))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMano0)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMano1)
                                .addGap(10, 10, 10)
                                .addComponent(btnMano2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMano3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(150, 150, 150))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnMano4)
                        .addGap(14, 14, 14)
                        .addComponent(btnMano5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMano6)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar))
                        .addGap(85, 85, 85))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTurno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddWord)
                        .addGap(148, 148, 148)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnValidar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addComponent(btnMano4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMano0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMano1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMano2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnMano6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMano5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMano3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarActionPerformed
        
    }//GEN-LAST:event_btnValidarActionPerformed
    
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
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddWord;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnMano0;
    private javax.swing.JButton btnMano1;
    private javax.swing.JButton btnMano2;
    private javax.swing.JButton btnMano3;
    private javax.swing.JButton btnMano4;
    private javax.swing.JButton btnMano5;
    private javax.swing.JButton btnMano6;
    private javax.swing.JButton btnValidar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCoins;
    private javax.swing.JLabel jLabelDic;
    private javax.swing.JLabel jLabelJugadores;
    private javax.swing.JLabel jLabelTurno;
    private javax.swing.JPanel jPanelCoins;
    private javax.swing.JPanel jPanelDic;
    private javax.swing.JPanel jPanelGamers;
    private javax.swing.JPanel jPanelMano;
    private javax.swing.JPanel jPanelMatriz;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
