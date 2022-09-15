/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mouid
 */
public class Card {
    
    public enum KarteFarbe {
        ROT,
        BLAU,
        GELB,
        GRUEN,
        BESONDERE;
        private static final KarteFarbe[] listVonFarben = KarteFarbe.values();

        public static KarteFarbe getKarteFarbe(int i) {
            return listVonFarben[i];
        }

    }

    public enum Wert {
        NULL, EINS, ZWEI, DREI, VIER, PLUSZWEI, PLUSVIER, UMKEHREN, UEBERSPRING , VIERFARBIG;
        private static final Wert[] listVonWerten = Wert.values();

        public static Wert getWert(int i) {
            return listVonWerten[i];
        }
    }


    public  KarteFarbe color;
    public  Wert value;

    public Card(KarteFarbe color, Wert value) {
        this.color = color;
        this.value = value;
    }

    public KarteFarbe getColor() {
        return color;
    }
   
    public Wert getValue() {
        return value;
    }
    
    public void setColor(KarteFarbe color){
        this.color = color;
    }
    
    
    

    @Override
    public String toString(){
        return color+"-"+value;
    }
    
    
}
