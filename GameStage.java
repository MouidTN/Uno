package GUI;

import Logik.*;

import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.joining;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author mouid
 */
public class GameStage extends javax.swing.JFrame {
    

    private AddPlayersName addPlayers = new AddPlayersName();
    ArrayList<String> h = new ArrayList<>();
    String[] spIds ;
    Game game;
    ArrayList<JButton> buttonsVonKarten = new ArrayList<JButton>();
    //ArrayList<String>
    ArrayList<String> KartenId1;
    ArrayList<String> KartenId2;
    
    PopUp window;
    /**
     * Creates new form GameStage
     */
    
   
    public GameStage() throws Deck.KeineKarteMehrInDeckException, Exception{
        initComponents();
        spIds = new String[2];
        spIds[0]=addPlayers.SpielerID[0];
        //System.out.println("essm lowl fi constructor ta3 stageGame:"+spIds[0]);
        spIds[1]=addPlayers.SpielerID[1];
        //System.out.println("essm theni fi constructor ta3 stageGame:"+spIds[1]);
        this.game = new Game();
        if ( game == null) {
            System.out.println("game is null!");
        }
        fillArrayListWithButtons();
        //game.Zug = 0;
        //game.start(game);
        setSpielerId();
        try {ObereKarteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("Einos-Bilder/PNGs/small/"+game.getTopCardImage())) );}
        catch ( Exception e){ System.out.println("Keine Icon ist zur Oberekarte zugewiesen !");}
        //setButtonIcons();//
        
    }
        
    
                
    
    
    public void setSpielerId(){
        Sp1id.setText(spIds[0]);
        Spid2.setText(spIds[1]);
        
    }
    
   
    public void setButtonIcons(){
        if (game.Zug ==0){jLabel1.setText("Zug von ersten Spieler !");}
        else if ( game.Zug  % 2 == 0  && game.Zug != 0) {jLabel1.setText("Zug von ersten Spieler !");}
        else { jLabel1.setText("Zug von zweiten Spieler !");}
     
        String listString1;
        
        //System.out.println("Game.SpielerID[0]="+Game.SpielerID[0]);
        listString1 = game.getSpielerHand(Game.SpielerID[0]).stream().map(Object::toString).collect(Collectors.joining(","));
        //System.out.println("Spiler 1 Hand fi setButtonIcons() :"+game.getSpielerHand(addPlayers.SpielerID[0]));
        //System.out.println("listString1="+listString1);
        String[] KartenNamen1 = listString1.split(",");
        System.out.println("ArrayList von Karten von ersten Spieler hat die Geoesse  : "+KartenNamen1.length);
        KartenId1 = new ArrayList<>(Arrays.asList(KartenNamen1));
        for ( int i = 0; i<13;i++){
            try {
               System.out.println("Die Karte in Button "+(i+1)+"hat schon ihre Bild da  :"+KartenId1.get(i));
               buttonsVonKarten.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("Einos-Bilder/PNGs/small/"+ KartenId1.get(i)+".png")));
            } catch (Exception e){
                System.out.println("Das Bild ist nicht eingetragen!");
            }
        }

        String listString2;
        //System.out.println("spIds[1] ="+spIds[1]);
        //System.out.println("Game.SpielerID[1]="+Game.SpielerID[1]);
        listString2 = game.getSpielerHand(Game.SpielerID[1]).stream().map(Object::toString).collect(Collectors.joining(","));
        //System.out.println("Spiler 2 Hand fi setButtonIcons() :"+game.getSpielerHand(addPlayers.SpielerID[1]));
        //System.out.println("listString2="+listString1);
        String[] KartenNamen2 = listString2.split(",");
        System.out.println("ArrayList von Karten von zweiten Spieler hat die Geoesse  : "+KartenNamen2.length);
        KartenId2 = new ArrayList<>(Arrays.asList(KartenNamen2));
        for ( int i = 0; i<13;i++){
            try {
               buttonsVonKarten.get(i+13).setIcon(new javax.swing.ImageIcon(getClass().getResource("Einos-Bilder/PNGs/small/"+ KartenId2.get(i)+".png")));
               System.out.println("Die Karte in Button "+(i+1)+"hat schon ihre Bild da  :"+KartenId2.get(i));
               //njareb nsale7 path : yodher keynou ghalt
            } catch (Exception e){
                System.out.println("Das Bild ist nicht eingetragen!");
            }
        }
        
        
        
        ObereKarteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("Einos-Bilder/PNGs/small/"+game.getTopCardImage())) );
        
        for (int i = KartenId1.size(); i<13;i++){
            buttonsVonKarten.get(i).setIcon(null);//um die gespielte Karten nicht wieder zu zeigen!
        }
        
        for (int i = KartenId2.size()+13; i<26;i++){
            buttonsVonKarten.get(i).setIcon(null);//um die gespielte Karten nicht wieder zu zeigen!
        }
        
        
        if (game.GameOver()){
            JLabel msg = null ;
            if (game.Hand1.size()==0){
               msg = new JLabel("Der erste Spieler hat gewonnen!");
            } else if (game.Hand2.size()==0){
               msg = new JLabel("Der zweite Spieler hat gewonnen!");
            }
            msg.setFont(new Font("Segoe UI Black",PLAIN,18));
            JOptionPane.showMessageDialog(null,msg);
        }
        
    }
    
    public void fillArrayListWithButtons(){
        buttonsVonKarten.add(jButton1);
        buttonsVonKarten.add(jButton2);
        buttonsVonKarten.add(jButton3);
        buttonsVonKarten.add(jButton4);
        buttonsVonKarten.add(jButton5);
        buttonsVonKarten.add(jButton6);
        buttonsVonKarten.add(jButton7);
        buttonsVonKarten.add(jButton8);
        buttonsVonKarten.add(jButton9);
        buttonsVonKarten.add(jButton11);
        buttonsVonKarten.add(jButton10);
        buttonsVonKarten.add(jButton12);
        buttonsVonKarten.add(jButton13);
        buttonsVonKarten.add(jButton14);
        buttonsVonKarten.add(jButton15);
        buttonsVonKarten.add(jButton16);
        buttonsVonKarten.add(jButton17);
        buttonsVonKarten.add(jButton18);
        buttonsVonKarten.add(jButton19);
        buttonsVonKarten.add(jButton20);
        buttonsVonKarten.add(jButton21);
        buttonsVonKarten.add(jButton22);
        buttonsVonKarten.add(jButton23);
        buttonsVonKarten.add(jButton24);
        buttonsVonKarten.add(jButton25);
        buttonsVonKarten.add(jButton26);
        
        
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        Sp1id = new javax.swing.JLabel();
        ZiehenButton = new javax.swing.JButton();
        ObereKarteButton = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        Spid2 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EINOS");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 720));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton1");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("jButton1");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("jButton1");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("jButton1");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("jButton1");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("jButton1");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("jButton1");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton11.setText("jButton1");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton10.setText("jButton1");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton12.setText("jButton1");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("jButton1");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("jButton1");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        Sp1id.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Sp1id.setText("SPIELER 1:");

        ZiehenButton.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        ZiehenButton.setForeground(new java.awt.Color(102, 0, 51));
        ZiehenButton.setText("KARTE ZIEHEN");
        ZiehenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZiehenButtonActionPerformed(evt);
            }
        });

        ObereKarteButton.setText("jButton44");
        ObereKarteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObereKarteButtonActionPerformed(evt);
            }
        });

        jButton23.setText("jButton1");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton25.setText("jButton1");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton24.setText("jButton1");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton26.setText("jButton1");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        Spid2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Spid2.setText("SPIELER 2:");

        jButton15.setText("jButton1");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("jButton1");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("jButton1");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("jButton1");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("jButton1");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setText("jButton1");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setText("jButton1");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setText("jButton1");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Einos-Bilder/PNGs/large/card_back_alt_large.png"))); // NOI18N
        jButton27.setText("jButton27");

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 153, 0));
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Spid2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179)
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Sp1id)
                        .addGap(7, 7, 7)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(ObereKarteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(246, 246, 246))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ZiehenButton)
                .addGap(225, 225, 225))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ZiehenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(ObereKarteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Spid2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sp1id, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ZiehenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZiehenButtonActionPerformed
        // TODO add your handling code here:
        if (game.Zug % 2 ==0) {
            if (game.Hand1.size()>11) {
                JLabel msg = new JLabel(spIds[0]+"kann jetzt keine Karte Mehr ziehen ! Er hat schon genung!");
                msg.setFont(new Font("Segoe UI Black",PLAIN,18));
                JOptionPane.showMessageDialog(null,msg);
            }else {
                JLabel msg = new JLabel(spIds[0]+" hat eine Karte gezogen ");
                msg.setFont(new Font("Segoe UI Black",PLAIN,18));
                JOptionPane.showMessageDialog(null,msg);
                game.Hand1.add(game.deck.gezogeneKarten(1).get(0));
            }
        } else {
            if (game.Hand2.size()>11) {
                JLabel msg = new JLabel(spIds[1]+"kann jetzt keine Karte Mehr ziehen ! Er hat schon genung!");
                msg.setFont(new Font("Segoe UI Black",PLAIN,18));
                JOptionPane.showMessageDialog(null,msg);
            }else {
                JLabel msg = new JLabel(spIds[1]+" hat eine Karte gezogen ");
                msg.setFont(new Font("Segoe UI Black",PLAIN,18));
                JOptionPane.showMessageDialog(null,msg);
                game.Hand2.add(game.deck.gezogeneKarten(1).get(0));
            }
        }
        //this.setSpielerId();
        this.setButtonIcons();
    }//GEN-LAST:event_ZiehenButtonActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        if ( KartenId2.get(0)!=null){
            int i = 0;
            String KarteId = KartenId2.get(0);
            window = new PopUp(KartenId2.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        if ( KartenId1.get(12)!=null){
            int i = 12;
            String KarteId = KartenId1.get(12);
            window = new PopUp(KartenId1.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        if ( KartenId1.get(11)!=null){
            int i = 11;
            String KarteId = KartenId1.get(11);
            window = new PopUp(KartenId1.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if ( KartenId1.get(9)!=null){
            int i = 9;
            String KarteId = KartenId1.get(9);
            window = new PopUp(KartenId1.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        if ( KartenId1.get(10)!=null){
            int i = 10;
            String KarteId = KartenId1.get(10);
            window = new PopUp(KartenId1.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if ( KartenId1.get(8)!=null){
            int i = 8;
            String KarteId = KartenId1.get(8);
            window = new PopUp(KartenId1.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if ( KartenId1.get(7)!=null){
            int i = 7;
            String KarteId = KartenId1.get(7);
            window = new PopUp(KartenId1.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if ( KartenId1.get(6)!=null){
            JLabel msg = new JLabel("You just clicked to use  "+KartenId1.get(6));
            msg.setFont(new Font("Segoe UI Black",PLAIN,18));
            JOptionPane.showMessageDialog(null,msg);
            int i = 6;
            String KarteId = KartenId1.get(6);
            window = new PopUp(KartenId1.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if ( KartenId1.get(5)!=null){
            JLabel msg = new JLabel("You just clicked to use  "+KartenId1.get(5));
            msg.setFont(new Font("Segoe UI Black",PLAIN,18));
            JOptionPane.showMessageDialog(null,msg);
            int i = 5;
            String KarteId = KartenId1.get(5);
            window = new PopUp(KartenId1.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:if ( KartenId1.get(0)!=null){
            if ( KartenId1.get(4)!=null){
                JLabel msg = new JLabel("You just clicked to use  "+KartenId1.get(4));
                msg.setFont(new Font("Segoe UI Black",PLAIN,18));
                JOptionPane.showMessageDialog(null,msg);
                int i = 4;
                String KarteId = KartenId1.get(4);
                window = new PopUp(KartenId1.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
                window.setVisible(true);
                window.setResizable(false);
                window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if ( KartenId1.get(3)!=null){
            JLabel msg = new JLabel("You just clicked to use  "+KartenId1.get(3));
            msg.setFont(new Font("Segoe UI Black",PLAIN,18));
            JOptionPane.showMessageDialog(null,msg);
            int i = 3;
            String KarteId = KartenId1.get(3);
            window = new PopUp(KartenId1.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        if ( KartenId1.get(2)!=null){
            JLabel msg = new JLabel("You just clicked to use  "+KartenId1.get(2));
            msg.setFont(new Font("Segoe UI Black",PLAIN,18));
            JOptionPane.showMessageDialog(null,msg);
            int i = 2;
            String KarteId = KartenId1.get(2);
            window = new PopUp(KartenId1.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if ( KartenId1.get(1)!=null){
            JLabel msg = new JLabel("You just clicked to use  "+KartenId1.get(1));
            msg.setFont(new Font("Segoe UI Black",PLAIN,18));
            JOptionPane.showMessageDialog(null,msg);
            int i = 1;
            String KarteId = KartenId1.get(1);
            window = new PopUp(KartenId1.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if ( KartenId1.get(0)!=null){
            JLabel msg = new JLabel("You just clicked to use  "+KartenId1.get(0));
            msg.setFont(new Font("Segoe UI Black",PLAIN,18));
            JOptionPane.showMessageDialog(null,msg);
            
            int i = 0;
            String KarteId = KartenId1.get(0);
            window = new PopUp(KartenId1.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        if ( KartenId2.get(9)!=null){
            int i = 9;
            String KarteId = KartenId2.get(9);
            window = new PopUp(KartenId2.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        if ( KartenId2.get(11)!=null){
            int i = 11;
            String KarteId = KartenId2.get(11);
            window = new PopUp(KartenId2.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        if ( KartenId2.get(10)!=null){
            int i = 10;
            String KarteId = KartenId2.get(10);
            window = new PopUp(KartenId2.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        if ( KartenId2.get(12)!=null){
            int i = 12;
            String KarteId = KartenId2.get(12);
            window = new PopUp(KartenId2.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        if ( KartenId2.get(1)!=null){
            int i = 1;
            String KarteId = KartenId2.get(1);
            window = new PopUp(KartenId2.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        if ( KartenId2.get(2)!=null){
            int i = 2;
            String KarteId = KartenId2.get(2);
            window = new PopUp(KartenId2.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        if ( KartenId2.get(3)!=null){
            int i = 3;
            String KarteId = KartenId2.get(3);
            window = new PopUp(KartenId2.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        if ( KartenId2.get(4)!=null){
            int i = 4;
            String KarteId = KartenId2.get(4);
            window = new PopUp(KartenId2.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        if ( KartenId2.get(5)!=null){
            int i = 5;
            String KarteId = KartenId2.get(5);
            window = new PopUp(KartenId2.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        if ( KartenId2.get(6)!=null){
            int i = 6;
            String KarteId = KartenId2.get(6);
            window = new PopUp(KartenId2.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        if ( KartenId2.get(7)!=null){
            int i = 7;
            String KarteId = KartenId2.get(7);
            window = new PopUp(KartenId2.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        if ( KartenId2.get(8)!=null){
            int i = 8;
            String KarteId = KartenId2.get(8);
            window = new PopUp(KartenId2.get(i), game , i ,buttonsVonKarten,this , ObereKarteButton);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void ObereKarteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObereKarteButtonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ObereKarteButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GameStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GameStage().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ObereKarteButton;
    private javax.swing.JLabel Sp1id;
    private javax.swing.JLabel Spid2;
    private javax.swing.JButton ZiehenButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
