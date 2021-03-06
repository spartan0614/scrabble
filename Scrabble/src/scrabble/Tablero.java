package scrabble;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import matriz.*;

/*
 @author DINORA
 */
public class Tablero extends javax.swing.JFrame {

    Image img;
    int dimension;
    JButton[][] table;
    JButton[] fichasEnJuego = new JButton[7];
    JCheckBox[] fichasCambio = new JCheckBox[7];
    int[] idFichas = new int[7];
    int[] valorFichas = new int[7];
    
    int movX = 3;
    int movY = 3;
    Ortogonal matrix;
    Jugador gamers;
    Fichas fichasDisponibles;
    Dictionary diccionario;
    String turnoGraficar;
    NodoJugador auxTurno;
    
    
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
    
    public void GetDiccionario(Dictionary palabras){
        diccionario = palabras;
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
        
        fichasCambio[0] = Check0;
        fichasCambio[1] = Check1;
        fichasCambio[2] = Check2;
        fichasCambio[3] = Check3;
        fichasCambio[4] = Check4;
        fichasCambio[5] = Check5;
        fichasCambio[6] = Check6;
        
    
        PrimerTurno();
        Graficos();
     }
    
    public void PrimerTurno(){
        Random aleatorio = new Random();
        int numero = aleatorio.nextInt(gamers.Contar())+1;
        System.out.println(gamers.Contar());
        BuscandoPrimero(numero);
    }
    
    public void BuscandoPrimero(int numero){
        NodoJugador aux;                                                
        aux = gamers.getCabeza();  
        
        if(aux.getNumber()== numero){
            Turno(aux);
        }else{
            while(aux.getSiguiente() != gamers.getCabeza()){
                if(aux.getNumber() == numero){                                           
                    Turno(aux);
                    break;
                }
                aux = aux.getSiguiente();
            }             
        }
        
    }
    
    public void Turno(NodoJugador turno){
        int indice = 0;  
        jLabelTurno.setText(turno.getUser());         //Le damos al label el nombre del jugador del turno
        NodoFichas fichasTurno;                     //Recorriendo las fichas del jugador turno
            for(fichasTurno = turno.getMisFichas().getCabeza(); fichasTurno != null; fichasTurno = fichasTurno.getSiguiente()){
                fichasEnJuego[indice].setText(fichasTurno.getLetra());  //mostrar cada ficha en cada boton de fichasActivas.
                fichasCambio[indice].setText(fichasTurno.getLetra());   //mostrar cada ficha en los botones de cambio
                idFichas[indice] = fichasTurno.getIdLetra();        //matriz lógica que contiene los id de letras para poder hacer cambios.
                valorFichas[indice] = fichasTurno.getValor();       //matriz lógica que contiene los valores de las letras
                indice++;
            }
            
        turno.getMisFichas().Graficar("jugador", turno.getNumber());
        turnoGraficar = Integer.toString(turno.getNumber());
        auxTurno = turno;
        
    }
    
   
    
    public void Graficos(){
        gamers.Graficar("jugadores");
        ImageIcon im = new ImageIcon("C:\\Users\\ESTUARDO\\Documents\\Josselyn\\jugadores.png"); //Mostrando Jugadores
        Icon ic = new ImageIcon(im.getImage().getScaledInstance(jLabelJugadores.getWidth(), jLabelJugadores.getHeight(), Image.SCALE_DEFAULT));
        jLabelJugadores.setIcon(ic);
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
        jLabelMano = new javax.swing.JLabel();
        jPanelMatriz = new javax.swing.JPanel();
        jLabelMatriz = new javax.swing.JLabel();
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
        jTextAreaNew = new javax.swing.JTextArea();
        btnAddWord = new javax.swing.JButton();
        btnValidar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabelTurno = new javax.swing.JLabel();
        Check0 = new javax.swing.JCheckBox();
        Check1 = new javax.swing.JCheckBox();
        Check2 = new javax.swing.JCheckBox();
        Check3 = new javax.swing.JCheckBox();
        Check4 = new javax.swing.JCheckBox();
        Check5 = new javax.swing.JCheckBox();
        Check6 = new javax.swing.JCheckBox();
        btnCambiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);

        jTabbedPane4.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jTabbedPane4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane4MouseClicked(evt);
            }
        });

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
            .addGroup(jPanelManoLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabelMano, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanelManoLayout.setVerticalGroup(
            jPanelManoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMano, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Mano Jugador", jPanelMano);

        javax.swing.GroupLayout jPanelMatrizLayout = new javax.swing.GroupLayout(jPanelMatriz);
        jPanelMatriz.setLayout(jPanelMatrizLayout);
        jPanelMatrizLayout.setHorizontalGroup(
            jPanelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMatriz, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        jPanelMatrizLayout.setVerticalGroup(
            jPanelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMatriz, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Matriz de tablero", jPanelMatriz);

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel1.setText("Reportes");

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel2.setText("Mano Jugador Activo");

        jTextAreaNew.setColumns(20);
        jTextAreaNew.setRows(5);
        jTextAreaNew.setAutoscrolls(false);
        jScrollPane2.setViewportView(jTextAreaNew);

        btnAddWord.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        btnAddWord.setText("Agregar");
        btnAddWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddWordActionPerformed(evt);
            }
        });

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

        btnCambiar.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        btnCambiar.setText("Cambiar");
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(739, 739, 739)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAddWord)
                                    .addComponent(Check6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCambiar)
                                        .addGap(8, 8, 8))
                                    .addComponent(Check5)
                                    .addComponent(Check4))
                                .addGap(62, 62, 62))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(104, 104, 104)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(jLabelTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(Check2)
                                                    .addComponent(Check0)
                                                    .addComponent(Check1)
                                                    .addComponent(Check3))))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMano0)
                                .addGap(18, 18, 18)
                                .addComponent(btnMano1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMano2)
                                .addGap(18, 18, 18)
                                .addComponent(btnMano3)
                                .addGap(4, 4, 4)))
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
                        .addComponent(jLabelTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnAddWord)
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Check2)
                                        .addGap(10, 10, 10)
                                        .addComponent(Check0)
                                        .addGap(3, 3, 3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Check4)
                                        .addGap(18, 18, 18)))
                                .addComponent(Check5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(Check1)))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Check3)
                            .addComponent(Check6))
                        .addGap(18, 18, 18)
                        .addComponent(btnCambiar)
                        .addGap(76, 76, 76)))
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
        auxTurno = auxTurno.getSiguiente();
        Turno(auxTurno);
    }//GEN-LAST:event_btnValidarActionPerformed

    private void jTabbedPane4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane4MouseClicked
        if(jTabbedPane4.getSelectedIndex() == 0){
            gamers.Graficar("jugadores");
            ImageIcon im = new ImageIcon("C:\\Users\\ESTUARDO\\Documents\\Josselyn\\jugadores.png"); //Mostrando Jugadores
            Icon ic = new ImageIcon(im.getImage().getScaledInstance(jLabelJugadores.getWidth(), jLabelJugadores.getHeight(), Image.SCALE_DEFAULT));
            jLabelJugadores.setIcon(ic);
            this.repaint();
        }else if(jTabbedPane4.getSelectedIndex() ==1){
            diccionario.Graficar("diccionario");
            ImageIcon cot = new ImageIcon("C:\\Users\\ESTUARDO\\Documents\\Josselyn\\diccionario.png"); //Mostrando Diccionario.
            Icon z = new ImageIcon(cot.getImage().getScaledInstance(jLabelDic.getWidth(), jLabelDic.getHeight(), Image.SCALE_DEFAULT));
            jLabelDic.setIcon(z);
            this.repaint();
        }else if(jTabbedPane4.getSelectedIndex() ==2){
            fichasDisponibles.Graficar("fichas");
            ImageIcon fot = new ImageIcon("C:\\Users\\ESTUARDO\\Documents\\Josselyn\\fichas.png"); //Mostrando Fichas actuales
            Icon icono = new ImageIcon(fot.getImage().getScaledInstance(jLabelCoins.getWidth(), jLabelCoins.getHeight(), Image.SCALE_DEFAULT));
            jLabelCoins.setIcon(icono);
            this.repaint();
        }else if(jTabbedPane4.getSelectedIndex() ==3){
            ImageIcon fot = new ImageIcon("C:\\Users\\ESTUARDO\\Documents\\Josselyn\\jugador"+turnoGraficar+".png"); //Mostrando Fichas del jugador
            Icon icono = new ImageIcon(fot.getImage().getScaledInstance(jLabelMano.getWidth(), jLabelMano.getHeight(), Image.SCALE_DEFAULT));
            jLabelMano.setIcon(icono);
            this.repaint();
        }
//        }else if(jTabbedPane4.getSelectedIndex() == 4){
//            matrix.Graficar("Lamatriz");
//            ImageIcon fot = new ImageIcon("C:\\Users\\ESTUARDO\\Documents\\Josselyn\\Lamatriz.png"); //Mostrando Fichas actuales
//            Icon icono = new ImageIcon(fot.getImage().getScaledInstance(jLabelMatriz.getWidth(), jLabelMatriz.getHeight(), Image.SCALE_DEFAULT));
//            jLabelMatriz.setIcon(icono);
//            this.repaint();
//            
//        }
        
    }//GEN-LAST:event_jTabbedPane4MouseClicked

    private void btnAddWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddWordActionPerformed
        diccionario.Insertar(jTextAreaNew.getText());
        jTextAreaNew.setText("");
    }//GEN-LAST:event_btnAddWordActionPerformed

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        NodoFichas fuera;
        for(int i= 0; i<7; i++){
            if( fichasCambio[i].isSelected()){   //si un CheckBox está seleccionado
                
                fichasDisponibles.Insertar(idFichas[i],fichasCambio[i].getText(), valorFichas[i]); //insertamos a la cola los datos de la ficha
                fichasCambio[i].setText("");                                                          //Quitamos el texto del CheckBox.
                fichasEnJuego[i].setText("");                                       //Quitamos el texto al boton.
                idFichas[i] = 0;                                                    //quitar el id de la ficha
                valorFichas[i] = 0;                                                 //quitamos el valor de la ficha
                auxTurno.getMisFichas().Eliminar(idFichas[i]);                      //Eliminamos de la lista simple
                fuera = fichasDisponibles.Quitar();                                 //Quitamos una ficha de la cola.
                auxTurno.getMisFichas().Insertar(fuera.getIdLetra(), fuera.getLetra(), fuera.getValor()); //Ingresamos una nueva letra a la lista simple.
                fichasCambio[i].setText(fuera.getLetra());                              //Le damos nuevo texto al CheckBox
                fichasEnJuego[i].setText(fuera.getLetra());                                  //Le damos nuevo texto al boton
                idFichas[i] = fuera.getIdLetra();                                            //le damos nuevo id a la lista lógica
                valorFichas[i] = fuera.getValor();                                           //le damos nuevo valor a la lista lógica       
            }
        }
       
        
    }//GEN-LAST:event_btnCambiarActionPerformed
    
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
    private javax.swing.JCheckBox Check0;
    private javax.swing.JCheckBox Check1;
    private javax.swing.JCheckBox Check2;
    private javax.swing.JCheckBox Check3;
    private javax.swing.JCheckBox Check4;
    private javax.swing.JCheckBox Check5;
    private javax.swing.JCheckBox Check6;
    private javax.swing.JButton btnAddWord;
    private javax.swing.JButton btnCambiar;
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
    private javax.swing.JLabel jLabelMano;
    private javax.swing.JLabel jLabelMatriz;
    private javax.swing.JLabel jLabelTurno;
    private javax.swing.JPanel jPanelCoins;
    private javax.swing.JPanel jPanelDic;
    private javax.swing.JPanel jPanelGamers;
    private javax.swing.JPanel jPanelMano;
    private javax.swing.JPanel jPanelMatriz;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTextArea jTextAreaNew;
    // End of variables declaration//GEN-END:variables
}
