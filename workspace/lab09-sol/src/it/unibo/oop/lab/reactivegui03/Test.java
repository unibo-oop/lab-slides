package it.unibo.oop.lab.reactivegui03;

/**
 * Third reactive GUI.
 *
 */
public final class Test {

    private Test() {
    }

    /*
     * Realizzare una classe AnotherConcurrentGUI con costruttore vuoto, che
     * aggiunga all'esercizio precedente la seguente funzionalità: - dopo 10 secondi
     * dalla partenza dell'applicazione, i pulsanti si disabilitino e il conteggio
     * si fermi comunque - fare attenzione a non creare corse critiche
     * 
     * Suggerimenti:
     * 
     * si usi un ulteriore agente
     * 
     * si rifattorizzi se necessario/utile la struttura della soluzione
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
