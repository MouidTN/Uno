import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
public class Deck {
    public ArrayList<Card> Karten;
    public ArrayList<Card> gesamteKarten;

    public Deck() {
        Karten = new ArrayList<Card>(70);
        gesamteKarten = new ArrayList<Card>(70);
        KartenBauen();
        gesamteKartenBauen();             
    }


    //Diese Methode inistialisiert das Kartendeck
    public void KartenBauen() {
        Card.KarteFarbe[] list = Card.KarteFarbe.values();
        for (int i = 0; i < list.length - 1; i++) {
            //So itierieren wir auf die vier Farben:
            Card.KarteFarbe currentColor = list[i];
            //Das ist fuer die Karte mit Wert Null . Sie muss auf Seite implementiert werden , weil es gibt nur eine
            //davon duer jede Farbe
            Karten.add(new Card(currentColor, Card.Wert.getWert(0)));
            for (int j = 1; j < 5; j++) {//war 8
                Karten.add(new Card(currentColor, Card.Wert.getWert(j)));
                Karten.add(new Card(currentColor, Card.Wert.getWert(j)));
                //Das haben wir zweimal gemacht , weil jede Karte mit Wert zwischen 1 und 7 muss fuer jede Farbe zweimal
                //existieren
            }
            //List von besondere Karten mit Farben
            ArrayList<Card.Wert> list1 = new ArrayList<Card.Wert>();
            list1.add(Card.Wert.PLUSZWEI);
            list1.add(Card.Wert.UMKEHREN);
            list1.add(Card.Wert.UEBERSPRING);
            for (Card.Wert element : list1) {
                Karten.add(new Card(currentColor, element));
                Karten.add(new Card(currentColor, element));
            }
        }
        //List von besondere Karten ohne Farben
        ArrayList<Card.Wert> list2 = new ArrayList<Card.Wert>();
        list2.add(Card.Wert.VIERFARBIG);
        list2.add(Card.Wert.PLUSVIER);
        for (Card.Wert element : list2) {
            for (int k = 0; k < 4; k++) {
                Karten.add(new Card(Card.KarteFarbe.BESONDERE, element));
            }
        }
    }
    
    
    public void gesamteKartenBauen() {
        Card.KarteFarbe[] list = Card.KarteFarbe.values();
        for (int i = 0; i < list.length - 1; i++) {
            //So itierieren wir auf die vier Farben:
            Card.KarteFarbe currentColor = list[i];
            //Das ist fuer die Karte mit Wert Null . Sie muss auf Seite implementiert werden , weil es gibt nur eine
            //davon duer jede Farbe
            gesamteKarten.add(new Card(currentColor, Card.Wert.getWert(0)));
            for (int j = 1; j < 5; j++) {
                gesamteKarten.add(new Card(currentColor, Card.Wert.getWert(j)));
                gesamteKarten.add(new Card(currentColor, Card.Wert.getWert(j)));
                //Das haben wir zweimal gemacht , weil jede Karte mit Wert zwischen 1 und 7 muss fuer jede Farbe zweimal
                //existieren
            }
            //List von besondere Karten mit Farben
            ArrayList<Card.Wert> list1 = new ArrayList<Card.Wert>();
            list1.add(Card.Wert.PLUSZWEI);
            list1.add(Card.Wert.UMKEHREN);
            list1.add(Card.Wert.UEBERSPRING);
            for (Card.Wert element : list1) {
                gesamteKarten.add(new Card(currentColor, element));
                gesamteKarten.add(new Card(currentColor, element));
            }
        }
        //List von besondere Karten ohne Farben
        ArrayList<Card.Wert> list2 = new ArrayList<Card.Wert>();
        list2.add(Card.Wert.VIERFARBIG);
        list2.add(Card.Wert.PLUSVIER);
        for (Card.Wert element : list2) {
            for (int k = 0; k < 4; k++) {
                gesamteKarten.add(new Card(Card.KarteFarbe.BESONDERE, element));
            }
        }
    }
    
    
    

    //fama method okhra tchabhelha
    public void replaceDeckWith(ArrayList<Card> param ){//method hedhi akthareya ghalta
        this.Karten = param;
    }

    public boolean istLeer(){
        return Karten.size()==0;
    }

    public void shuffle(){
        int n = Karten.size();
        Random random = new Random();
        for (int i = 0; i < Karten.size(); i++) {
           int randomValue = i + random.nextInt(n - i);
           Card randomCard = Karten.get(randomValue);
           Karten.set(randomValue,Karten.get(i));
           Karten.set(i,randomCard);
        }
    }

    public class KeineKarteMehrInDeckException extends Exception {
        public KeineKarteMehrInDeckException(String msg){
            super(msg);
        }
    }


    //usually this method is called drawCard : it's for taking the top card of the deck into hand
    public Card pullCard() throws KeineKarteMehrInDeckException{
        if (istLeer()) {
            throw new KeineKarteMehrInDeckException("Es gibt Keine Karten mehr in Deck !");
        }
        Karten.remove(Karten.size()-1);
        return Karten.get(Karten.size()-1);
    }

    public ImageIcon drawCardImage() throws KeineKarteMehrInDeckException{
        if (istLeer()) {
            throw new KeineKarteMehrInDeckException("Es gibt Keine Karten mehr in Deck !");
        }
        return new ImageIcon(Karten.get(Karten.size()-1).toString()+".png");
    }


    public ArrayList<Card> gezogeneKarten(int n){
        if (n<0) throw new IllegalArgumentException("Sie koennen nicht negative Anzahl von Karten vom Deck ziehen!");
        if (n>Karten.size()) throw new IllegalArgumentException("Anzahl von Karten zu ziehen gibt es nicht mehr in Deck! ");
        ArrayList<Card> list = new ArrayList<Card>();
        for (int i = 0 ; i<n ; i++){
            System.out.println("Groesse Von Deck ist jetzt = "+Karten.size());
            list.add(Karten.get(Karten.size()-1));
            Karten.remove(Karten.size()-1);
            System.out.println("Gezogene Karte : "+list.get(i));
        }  
        return list;
    }
    
    
    public Card toCard(String s){//nkaml ne5demha.............
        StringBuffer sb=new StringBuffer(s);
        int indexOfStrich =s.indexOf("-");
        String colorS=sb.substring(0, indexOfStrich);
        System.out.println("String ta3 color : "+colorS);
        String valueS= sb.substring(indexOfStrich+1);
        System.out.println("String ta3 value : "+valueS);
        Card card = null;
        for ( Card element : gesamteKarten){
            if (element.getColor().toString().equals(colorS) && element.getValue().toString().equals(valueS)) {
                card = new Card(element.getColor(), element.getValue());
                break;
            }
        }
        return card;
    }


}
