package oop.lab02.constructors;

public class Smartphone {

    public static final boolean DEF_HAS_GPS = true;
    public static final boolean DEF_HAS_3G = true;
    public static final boolean DEF_HAS_NFC = true;
    public static final int DEF_SD_SIZE = 8192;
    public static final int DEF_RAM_SIZE = 1024;
    public static final int DEF_N_CPU = 2;

    public int nCPU;
    public int ram;
    public int sdSize;
    public String brand;
    public String model;
    public boolean hasGPS;
    public boolean has3G;
    public boolean hasNFC;

    public void printStringRep() {
        System.out.println("n CPU(s): " + this.nCPU);
        System.out.println("RAM amount: " + ram);
        System.out.println("SD size: " + this.sdSize);
        System.out.println("brand: " + this.brand);
        System.out.println("model: " + this.model);
        System.out.println("hasGPS: " + this.hasGPS);
        System.out.println("has3G: " + this.has3G);
        System.out.println("hasNFC: " + this.hasNFC + "\n");
    }

    public static void main(final String[] args) {
        /*
         * 1) Creare lo smarthpone HTC One sdSize:1024
         * 
         * 2) Creare lo smarthpone Samsung Galaxy Note 3 nCPU:4 ram:2048
         * sdSize:8192 gps:true nfc:true 3g:true
         * 
         * 3) Creare lo smarthpone iPhone 5S nfc:false
         * 
         * 4) Creare lo smarthpone Google Nexus 4 gps:true 3g:true
         * 
         * 5) Utilizzare il metodo printStringRep per stampare in standard
         * output le informazioni di ciascun telefono
         */
    }
}
