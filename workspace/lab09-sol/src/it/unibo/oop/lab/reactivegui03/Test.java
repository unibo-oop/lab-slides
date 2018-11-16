package it.unibo.oop.lab.reactivegui03;

/**
 * TestMatrix class for third reactive GUI.
 * 
 *
 */
public final class Test {

    private Test() {

    }

    /*
     * Realizzare una classe C3GUI con costruttore a zero arg, che aggiunga
     * all'esercizio precedente la seguente funzionalità: - dopo 10 secondi
     * dalla partenza dell'applicazione, i pulsanti e si disabilitino e il
     * conteggio si fermi comunque - fare attenzione a non creare corse critiche
     * 
     * Suggerimenti: - si usi un ulteriore agente.. - si rifattorizzi se
     * necessario/utile la struttura della soluzione
     */

    /**
     * 
     * @param args
     *            unused
     * 
     */
    public static void main(final String... args) {
        new AnotherConcurrentGUI();

    }
}
