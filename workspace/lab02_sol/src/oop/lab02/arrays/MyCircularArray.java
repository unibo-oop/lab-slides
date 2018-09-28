package oop.lab02.arrays;

public class MyCircularArray {

    public static final int ARRAY_DEF_SIZE = 10;
    private int[] array;
    private int nextPosition;

    public MyCircularArray() {
        this.array = new int[ARRAY_DEF_SIZE];
        this.nextPosition = 0;
    }

    public MyCircularArray(final int size) {
        this.array = new int[size];
        this.nextPosition = 0;
    }

    public void add(final int elem) {
        this.array[nextPosition] = elem;
        this.nextPosition = (this.nextPosition + 1) % this.array.length;
    }

    public void reset() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = 0;
        }
        this.nextPosition = 0;
    }

    public void printArray() {
        System.out.print("[");
        for (int i = 0; i < this.array.length - 1; i++) {
            System.out.print(this.array[i] + ",");
        }
        System.out.print(this.array[this.array.length - 1] + "]");
    }

    public static void main(final String[] args) {
        /*
         * 1) Creare un array circolare di dieci elementi
         */
        final MyCircularArray circularArray = new MyCircularArray(10);
        /*
         * 2) Aggiungere gli elementi da 1 a 10 e stampare il contenuto
         * dell'array circolare
         */
        for (int i = 0; i < 10; i++) {
            circularArray.add(i);
        }
        circularArray.printArray();
        System.out.println();
        /*
         * 3) Aggiungere gli elementi da 11 a 15 e stampare il contenuto
         * dell'array circolare
         */
        for (int i = 11; i <= 15; i++) {
            circularArray.add(i);
        }
        circularArray.printArray();
        System.out.println();
        /*
         * 4) Invocare il metodo reset
         */
        circularArray.reset();
        /*
         * 5) Stampare il contenuto dell'array circolare
         */
        circularArray.printArray();
        System.out.println();
        /*
         * 6) Aggiungere altri elementi a piacere e stampare il contenuto
         * dell'array circolare
         */
        circularArray.add(1);
        circularArray.add(2);
        circularArray.add(3);
        circularArray.printArray();
    }
}
