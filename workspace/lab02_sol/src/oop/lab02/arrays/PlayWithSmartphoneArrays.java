package oop.lab02.arrays;

import oop.lab02.constructors.Smartphone;

public class PlayWithSmartphoneArrays {

    /*
     * All methods are static: this class must never get instanced
     */
    private PlayWithSmartphoneArrays() {
    }

    public static int search(final Smartphone[] array, final String brand) {
        int returnValue = 0;
        for (final Smartphone phone : array) {
            if (phone.getBrand().equals(brand)) {
                returnValue++;
            }
        }
        return returnValue;
    }

    public static int search(final Smartphone[] array, final boolean hasNFC, final boolean hasGPS) {
        int returnValue = 0;
        for (final Smartphone phone : array) {
            if (phone.hasNFC() == hasNFC && phone.hasGPS() == hasGPS) {
                returnValue++;
            }
        }
        return returnValue;
    }

    public static int search(final Smartphone[] array, final int nCPUs, final int sdSize, final boolean has3G) {
        int returnValue = 0;
        for (final Smartphone phone : array) {
            if (phone.getCPUs() == nCPUs && phone.getSdSize() == sdSize && phone.has3G() == has3G) {
                returnValue++;
            }
        }
        return returnValue;
    }

    public static void main(final String[] args) {
        final Smartphone[] phones = new Smartphone[5];

        /*
         * 1) Creare lo smarthpone HTC One ram:1024 sdSize
         */
        phones[0] = new Smartphone("HTC", "One", 1024);

        /*
         * 2) Creare lo smarthpone Samsung Galaxy Note 3 ram:2048 sdSize:8192 gps:true
         * nfc:true 3g:true
         */
        phones[1] = new Smartphone(4, 2048, 8192, "Samsung", "Galaxy Note 3", true, true, true);

        /*
         * 3) Creare lo smarthpone iPhone 5S nfc:false
         */
        phones[2] = new Smartphone("Apple", "iPhone 5S", false);

        /*
         * 4) Creare lo smarthpone Google Nexus 4 gps:true 3g:true
         */
        phones[3] = new Smartphone("Google", "Nexus 4", true, true);

        /*
         * 5) Creare lo smarthpone Acer Liquid cpu:2 ram:512 sdSize:8192 gps: true
         * 3g:true nfc: false
         */
        phones[4] = new Smartphone(2, 512, 8192, "Acer", "Liquid", true, true, false);

        /*
         * 6) Eseuguire diverse operazioni di ricerca con i metodi search implementati e
         * controllare la corrispondenza del numero dei telefoni facenti match
         */
        System.out.println("The number of HTC smartphones is: " + search(phones, "HTC"));
        System.out.println("The number of smartphones with NFC & GPS is: " + search(phones, true, true));
        System.out.println("The number of smartphones with 1 CPU 2048 MB sd and 3g is: "
                + search(phones, 2, 8192, true));
    }
}
