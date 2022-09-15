

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mouid
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Random;

public class Game {
    public boolean aktuelleSpieler = false;
    public String[] SpielerID = new String[2];
    String SpielStand;/////////////////////////
    private Deck deck;
    private ArrayList<Card> Hand1= new ArrayList<>(13);
    private ArrayList<Card> Hand2= new ArrayList<>(13);
    private ArrayList<Card> Stock;
    private Card aktuelleKarte;
    private Card obereKarte;
   
    public Game (String id1 , String id2){
        deck = new Deck();
        deck.shuffle();
        Stock = new ArrayList<Card>();
        SpielerID[0] = id1;
        SpielerID[1] = id2;
        System.out.println("0000000000000000000000");
        aktuelleSpieler=false;
        System.out.println("11111111111111111111111");
        Hand1 = deck.gezogeneKarten(7);
        Hand2 = deck.gezogeneKarten(7);
        System.out.println("22222222222222222222222");
        setRandomErsteKarte();
         if (obereKarte != null ) {System.out.println("Die Obere Karte ist : "+obereKarte);}
         else { System.out.println("Programme 7abch ye5dm 5ater oberkarte null");}
        System.out.println("3333333333333333333333");
        System.out.println("der Hand vom ersten Spieler :"+Hand1);
        System.out.println("der Hand vom zweiten Spieler :"+Hand2);
        System.out.println("Die obere Karte :"+obereKarte);
    }

    public void setRandomErsteKarte(){
        //boolean kannDieErsteSein ;
        //int n = deck.gesamteKarten.size();
        Card h = new Card(Card.KarteFarbe.ROT , Card.Wert.PLUSZWEI);
        /*h = deck.gesamteKarten.get(new Random().nextInt(n));
        kannDieErsteSein = !(h.getColor() == Card.KarteFarbe.BESONDERE) &&( h.getValue()== Card.Wert.EINS || h.getValue()== Card.Wert.ZWEI || h.getValue()== Card.Wert.DREI  ||
                h.getValue()== Card.Wert.VIER );
        while ( true ){
            h = deck.gesamteKarten.get(new Random().nextInt(n));

            if (kannDieErsteSein) {deck.Karten.remove(h);break;}
        }*/
        obereKarte = h;
        deck.Karten.remove(h);
    }
    
    public int aktuelleSpielerIndex(){
        int x ;
        if (aktuelleSpieler){ x = 0;}
        else  {x = 1;}
        return x ;
    }
    
    
    
    public void scannenUndEineKarteSpielenFuerErsteSpieler() throws IOException  {
        System.out.println("Der erste Spieler waehlt eine Karte:");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String nameVonKarte = br.readLine();
        if (nameVonKarte.equals("KARTE ZIEHEN")){
            if (Hand1.size()>11) { System.out.println("Spieler 1 kann jetzt keine Karte Mehr ziehen ! Er hat schon genung!");}
            else {
               Hand1.add(deck.gezogeneKarten(1).get(0));
            }
        }
        else {
            Card gespielteKarte = deck.toCard(nameVonKarte);
            System.out.println("gespielte Karte ist : "+gespielteKarte);
            Card card1 = null;
            Card card2 = null;
            Card card3 = null;
            Card card4 = null;
            Card card5 = null;
            boolean A1 = false;
            boolean A2 = false;
            boolean A3 = false;
            boolean A4 = false;
            boolean A5 = false;
            for ( Card element : Hand1){
               if (element.toString().equals(nameVonKarte) && validKarte(deck.toCard(nameVonKarte))){//DHAHRLI MOCHKL TA3 NULL ENOU IF HEDHI MEME PAS NOD5LELHA
                     System.out.println("Die Karte "+element+"gibt es in dem Hand von ersten Spieler und sie ist spielbar!");
                    if ( element.getValue() == Card.Wert.UEBERSPRING || element.getValue() == Card.Wert.UMKEHREN){//9A3D NCOMPARI FI ELEMENT MCH CARTE LI 7ACHTI BEHA!!!
                       System.out.println("1: D5alt li part I");
                       card1 = element;
                       A1 = true;
                    } 
                    else if (element.getValue() == Card.Wert.PLUSVIER){
                       System.out.println("1: D5alt li part II");
                       A2=true;
                       card2 = element;
                       ArrayList<Card> listVonDieVierZuAddierenKarten = deck.gezogeneKarten(4);
                       Hand2.add(listVonDieVierZuAddierenKarten.get(0));
                       Hand2.add(listVonDieVierZuAddierenKarten.get(1));
                       Hand2.add(listVonDieVierZuAddierenKarten.get(2));
                       Hand2.add(listVonDieVierZuAddierenKarten.get(3));
                       while (true){
                            System.out.println("Wahlen Sie eine Farbe: GELB , ROT , BLAU oder GRUEN");
                            String farbeString = br.readLine();
                            if (farbeString.equals("GELB")) {card2.setColor(Card.KarteFarbe.GELB);break;}
                            else if (farbeString.equals("ROT")) {card2.setColor(Card.KarteFarbe.ROT);break;}
                            else if (farbeString.equals("GRUEN")) {card2.setColor(Card.KarteFarbe.GRUEN);break;}
                            else if (farbeString.equals("BLAU")) {card2.setColor(Card.KarteFarbe.BLAU);break;}
                            else{
                               System.out.println("Sie haben keine gueltige Farbe gewaehlt! Nochmal bitte !");
                            }
                        }
                       System.out.println("Die obere Karte :"+obereKarte);
                       break;//???????????????????
                    }else if (element.getValue() == Card.Wert.PLUSZWEI){
                        System.out.println("1: D5alt li part III");
                        A3=true;
                        card3=element;
                        ArrayList<Card> listVonDieZweiZuAddierenKarten = deck.gezogeneKarten(2);
                        Hand2.add(listVonDieZweiZuAddierenKarten.get(0));
                        Hand2.add(listVonDieZweiZuAddierenKarten.get(1));
                       //scannenUndEineKarteSpielenFuerErsteSpieler();NEIN NICHT NOCHMAL SPIELEN
                    } 
                    else if (element.getValue() == Card.Wert.VIERFARBIG){
                        System.out.println("1: D5alt li part IV");
                        A4 = true;
                        card4=element;
                        System.out.println("Jetzt wir haben eine Vierfarbige Karte fuer zweite Spieler!");
                        while (true){
                            System.out.println("Wahlen Sie eine Farbe: GELB , ROT , BLAU oder GRUEN");
                            String farbeString = br.readLine();
                            if (farbeString.equals("GELB")) {card4.setColor(Card.KarteFarbe.GELB);break;}
                            else if (farbeString.equals("ROT")) {card4.setColor(Card.KarteFarbe.ROT);break;}
                            else if (farbeString.equals("GRUEN")) {card4.setColor(Card.KarteFarbe.GRUEN);break;}
                            else if (farbeString.equals("BLAU")) {card4.setColor(Card.KarteFarbe.BLAU);break;}
                            else{
                               System.out.println("Sie haben keine gueltige Farbe gewaehlt! Nochmal bitte !");
                            }
                        } 
                        break ; //za3ma hedhi t7el mochkelt fierfarbig ?????????????????
                    } else{
                        System.out.println("1: D5alt li part V");
                        A5 = true;
                        card5= element;
                       //break; break hier fuehrt zu Fehlermeldung . Also wegmachen
                    }
                }
            }
            if (A1){ 
                System.out.println("card1 :"+card1);
                Hand1.remove(card1);
                obereKarte =card1;
                if (Hand1.size()==0) System.out.println("Der erste Spieler hat gewonnen!");
                System.out.println("der Hand vom ersten Spieler :"+Hand1);
                System.out.println("der Hand vom zweiten Spieler :"+Hand2);
                System.out.println("Die obere Karte :"+obereKarte);
                scannenUndEineKarteSpielenFuerErsteSpieler();
            }
            else if (A2){
                System.out.println("card2 :"+card2);
                Hand1.remove(card2);
                obereKarte =card2;
                System.out.println("der Hand vom ersten Spieler :"+Hand1);
                System.out.println("der Hand vom zweiten Spieler :"+Hand2);
                System.out.println("Die obere Karte :"+obereKarte);
            }
            else if (A3){
                System.out.println("card3 :"+card3);
                Hand1.remove(card3);
                obereKarte =card3;
                System.out.println("der Hand vom ersten Spieler :"+Hand1);
                System.out.println("der Hand vom zweiten Spieler :"+Hand2);
                System.out.println("Die obere Karte :"+obereKarte);
            }
            else if (A4){
                System.out.println("card4 :"+card4);
                Hand1.remove(card4);
                obereKarte =card4;
                System.out.println("der Hand vom ersten Spieler :"+Hand1);
                System.out.println("der Hand vom zweiten Spieler :"+Hand2);
                System.out.println("Die obere Karte :"+obereKarte);
            }
            else {
                System.out.println("card5 :"+card5);
                obereKarte = card5;
                Hand1.remove(card5);
                System.out.println("der Hand vom ersten Spieler :"+Hand1);
                System.out.println("der Hand vom zweiten Spieler :"+Hand2);
                System.out.println("Die obere Karte :"+obereKarte);
            }
        }
    }
           
                  
    
    
    public void scannenUndEineKarteSpielenFuerZweiteSpieler() throws IOException  {
        System.out.println("Der zweite Spieler waehlt eine Karte:");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String nameVonKarte = br.readLine();
        if (nameVonKarte.equals("KARTE ZIEHEN")){
            if (Hand2.size()>11) { System.out.println("Spieler 2 kann jetzt keine Karte Mehr ziehen ! Er hat schon genung!");}
            else {
               Hand2.add(deck.gezogeneKarten(1).get(0));
            }
        }
        else {
            Card gespielteKarte = deck.toCard(nameVonKarte);
            System.out.println("gespielte Karte ist : "+gespielteKarte);
            Card card1 = null;
            Card card2 = null;
            Card card3 = null;
            Card card4 = null;
            Card card5 = null;
            boolean A1 = false;
            boolean A2 = false;
            boolean A3 = false;
            boolean A4 = false;
            boolean A5 = false;
            for ( Card element : Hand2){
               if (element.toString().equals(nameVonKarte) && validKarte(deck.toCard(nameVonKarte))){
                   System.out.println("Die Karte "+element+"gibt es in dem Hand von ersten Spieler und sie ist spielbar!");
                    if (validKarte(deck.toCard(nameVonKarte))) System.out.println("Die Karte ist spielbar!");
                    if ( element.getValue() == Card.Wert.UEBERSPRING || element.getValue() == Card.Wert.UMKEHREN){//9A3D NCOMPARI FI ELEMENT MCH CARTE LI 7ACHTI BEHA!!!
                       System.out.println("2: D5alt li part I");
                       card1 = element;
                       A1 = true;
                    } 
                    else if (element.getValue() == Card.Wert.PLUSVIER){
                       System.out.println("2: D5alt li part II");
                       A2=true;
                       card2 = element;
                       ArrayList<Card> listVonDieVierZuAddierenKarten = deck.gezogeneKarten(4);
                       Hand1.add(listVonDieVierZuAddierenKarten.get(0));
                       Hand1.add(listVonDieVierZuAddierenKarten.get(1));
                       Hand1.add(listVonDieVierZuAddierenKarten.get(2));
                       Hand1.add(listVonDieVierZuAddierenKarten.get(3));
                       while (true){
                            System.out.println("Wahlen Sie eine Farbe: GELB , ROT , BLAU oder GRUEN");
                            String farbeString = br.readLine();
                            if (farbeString.equals("GELB")) {card2.setColor(Card.KarteFarbe.GELB);break;}
                            else if (farbeString.equals("ROT")) {card2.setColor(Card.KarteFarbe.ROT);break;}
                            else if (farbeString.equals("GRUEN")) {card2.setColor(Card.KarteFarbe.GRUEN);break;}
                            else if (farbeString.equals("BLAU")) {card2.setColor(Card.KarteFarbe.BLAU);break;}
                            else{
                               System.out.println("Sie haben keine gueltige Farbe gewaehlt! Nochmal bitte !");
                            }
                        }
                       System.out.println("Die obere Karte :"+obereKarte);
                       break;//???????????????????
                    }else if (element.getValue() == Card.Wert.PLUSZWEI){
                        System.out.println("2: D5alt li part III");
                        A3=true;
                        card3=element;
                        ArrayList<Card> listVonDieZweiZuAddierenKarten = deck.gezogeneKarten(2);
                        Hand1.add(listVonDieZweiZuAddierenKarten.get(0));
                        Hand1.add(listVonDieZweiZuAddierenKarten.get(1));
                       //scannenUndEineKarteSpielenFuerErsteSpieler();NEIN NICHT NOCHMAL SPIELEN
                    } 
                    else if (element.getValue() == Card.Wert.VIERFARBIG){
                        System.out.println("2: D5alt li part IV");
                        A4 = true;
                        card4=element;
                        System.out.println("Jetzt wir haben eine Vierfarbige Karte fuer zweite Spieler!");
                        while (true){
                            System.out.println("Wahlen Sie eine Farbe: GELB , ROT , BLAU oder GRUEN");
                            String farbeString = br.readLine();
                            if (farbeString.equals("GELB")) {card4.setColor(Card.KarteFarbe.GELB);break;}
                            else if (farbeString.equals("ROT")) {card4.setColor(Card.KarteFarbe.ROT);break;}
                            else if (farbeString.equals("GRUEN")) {card4.setColor(Card.KarteFarbe.GRUEN);break;}
                            else if (farbeString.equals("BLAU")) {card4.setColor(Card.KarteFarbe.BLAU);break;}
                            else{
                               System.out.println("Sie haben keine gueltige Farbe gewaehlt! Nochmal bitte !");
                            }
                        } 
                        break ; //za3ma hedhi t7el mochkelt fierfarbig ?????????????????
                    } else{
                        System.out.println("2: D5alt li part V");
                        A5 = true;
                        card5= element;
                       //break; break hier fuehrt zu Fehlermeldung . Also wegmachen
                    }
                }
            }
            if (A1){ 
                System.out.println("card1 :"+card1);
                Hand2.remove(card1);
                obereKarte =card1;
                if (Hand2.size()==0) System.out.println("Der zweite Spieler hat gewonnen!");
                System.out.println("der Hand vom ersten Spieler :"+Hand1);
                System.out.println("der Hand vom zweiten Spieler :"+Hand2);
                System.out.println("Die obere Karte :"+obereKarte);
                scannenUndEineKarteSpielenFuerZweiteSpieler();
            }
            else if (A2){
                System.out.println("card2 :"+card2);
                Hand2.remove(card2);
                obereKarte =card2;
                System.out.println("der Hand vom ersten Spieler :"+Hand1);
                System.out.println("der Hand vom zweiten Spieler :"+Hand2);
                System.out.println("Die obere Karte :"+obereKarte);
            }
            else if (A3){
                System.out.println("card3 :"+card3);
                Hand2.remove(card3);
                obereKarte =card3;
                System.out.println("der Hand vom ersten Spieler :"+Hand1);
                System.out.println("der Hand vom zweiten Spieler :"+Hand2);
                System.out.println("Die obere Karte :"+obereKarte);
            }
            else if (A4){
                System.out.println("card4 :"+card4);
                Hand2.remove(card4);
                obereKarte =card4;
                System.out.println("der Hand vom ersten Spieler :"+Hand1);
                System.out.println("der Hand vom zweiten Spieler :"+Hand2);
                System.out.println("Die obere Karte :"+obereKarte);
            }
            else {
                System.out.println("card5 :"+card5);
                obereKarte = card5;
                Hand2.remove(card5);
                System.out.println("der Hand vom ersten Spieler :"+Hand1);
                System.out.println("der Hand vom zweiten Spieler :"+Hand2);
                System.out.println("Die obere Karte :"+obereKarte);
            }
        }
    }
    
    
    

    public void start(Game game) throws Deck.KeineKarteMehrInDeckException , Exception{//initialisieren ta3 string ta3 stand bch tsir fi methode hedhi
        while (!GameOver()){
            System.out.println("Die obere Karte :"+obereKarte);
            System.out.println("der Hand vom ersten Spieler :"+Hand1);
            System.out.println("der Hand vom zweiten Spieler :"+Hand2);
           
           System.out.println("Der Zug von ersten Spieler !!");
           scannenUndEineKarteSpielenFuerErsteSpieler();
           if (Hand1.size()==0) System.out.println("Der erste Spieler hat gewonnen!");
           System.out.println("Die obere Karte :"+obereKarte);
           System.out.println("der Hand vom ersten Spieler :"+Hand1);
           System.out.println("der Hand vom zweiten Spieler :"+Hand2);
        
           System.out.println("Der Zug von zweiten Spieler !!");
           scannenUndEineKarteSpielenFuerZweiteSpieler();
           if (Hand1.size()==0) System.out.println("Der zweite Spieler hat gewonnen!");
           System.out.println("Die obere Karte :"+obereKarte);
           System.out.println("der Hand vom ersten Spieler :"+Hand1);
           System.out.println("der Hand vom zweiten Spieler :"+Hand2);
        }
    }

    /*public Card getTopCard(){
        return new Card(Farbe1,Wert1);
    }*/

    /*public ImageIcon getTopCardImage() {
        return new ImageIcon(Farbe1+"-"+Wert1+".png");
    }*/
    
    public boolean  GameOver(){
        boolean A = false;
        if (Hand1.size()==0 || Hand2.size()==0 ){
           A = true;
        }
        return A;
    }

    /*public String getAktuelleSpieler(){
        return this.SpielerID[this.aktuelleSpielerIndex()];
    }*/
    //lehne fama method getpreviousplayer 3malthech

    public String[] getSpielerID(){
        return SpielerID;
    }

    public ArrayList<Card> getSpielerHand(String spielerId){
        if (!SpielerID[0].equals(spielerId) && !SpielerID[1].equals(spielerId) ){
            throw new IllegalArgumentException("Es gibt keine Spieler mit solchen Name!");
        }
        ArrayList<Card> Hand = new ArrayList<>();
        if (spielerId.equals(SpielerID[0])){
            Hand = Hand1;
        } else if (spielerId.equals(SpielerID[1])) {
            Hand = Hand2;
        }
        return Hand;
    }

    public int getSpielerHandSize(String SpielerId){
        return getSpielerHand(SpielerId).size();
    }

    public Card getSpielerKarte(String spielerId , int index){
        ArrayList<Card>  hand = getSpielerHand(spielerId);
        return hand.get(index);
    }

    //lehne fama method is empty hand 3malthech

    public boolean validKarte(Card card){
        //Eine Karte ist valid genannt , wenn sie entweder die selbe Farbe oder die selbe Wert wie die vorherige hat !
        if (card.getColor()==obereKarte.getColor()) System.out.println("Die Farbe ist valid");
        if (card.getValue() == obereKarte.getValue()) System.out.println("Der Wert ist valid");
        return (card.getColor()==obereKarte.getColor()  || card.getValue() == obereKarte.getValue() || card.getValue() == Card.Wert.VIERFARBIG 
                || card.getValue() == Card.Wert.PLUSVIER);
    }

    


    public void MakePulls(String spielerId) throws UngultigSpielerZugException , Deck.KeineKarteMehrInDeckException {
        if (deck.istLeer()){
            deck.replaceDeckWith(Stock);
            deck.shuffle();
        }
        getSpielerHand(spielerId).add(deck.pullCard());
    }
}

   


class UngultigSpielerZugException extends Exception{
    String spielerId;

    public UngultigSpielerZugException(String message) {
        super(message);
    }

    public String getSpielerId() {
        return spielerId;
    }
}

class UngultigFarbeException extends Exception{
    private Card.KarteFarbe  erwartene;
    private Card.KarteFarbe gegeben;

    public UngultigFarbeException(String message, Card.KarteFarbe erwartene, Card.KarteFarbe gegeben) {
        super(message);
        this.erwartene = erwartene;
        this.gegeben= gegeben;
    }
}

class UngultigWertException extends Exception{
    private Card.KarteFarbe  erwartene;
    private Card.KarteFarbe gegeben;

    public UngultigWertException(String message, Card.KarteFarbe erwartene, Card.KarteFarbe gegeben) {
        super(message);
        this.erwartene = erwartene;
        this.gegeben= gegeben;
    }
}
