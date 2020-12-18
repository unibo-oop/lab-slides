
# Programmazione ad Oggetti - Laboratorio 01
## Esercizio 0 - helloworld

#### FASE 1 - Comprensione e prima compilazione
1. Con l'editor di testo scelto (e.g. Atom) si apra il file `HelloWorld.java`.
2. Si studi il comportamento della classe prima di procedere ai punti successivi (chiedere al docente in caso di dubbi).
3. Si posizioni un terminale all'interno della cartella utilizzando in modo opportuno il comando `cd`
4. Si compili il sorgente della classe
  * utilizzando il comando `javac HelloWorld.java` per invocare il compilatore java
5. Si esegua il programma ottenuto
  * utilizzando il comando `java HelloWorld` per invocare la JVM
6. Si abbia la certezza di aver compreso  il "perché nel comando `javac` è stato utilizzato il nome del file con l'estensione, mentre nel comando `java` no?" Si interpelli il docente in caso di dubbi.

#### FASE 2 - Prime modifiche ai sorgenti
7. Si aggiunga una stampa a video con un messaggio diverso a piacere
8. Si ricompili il sorgente, si riesegua il programma e se ne verifichi il corretto funzionamento
9. Si aggiunga al messaggio modificato anche la stampa della computazione di `50 + 50 * 50`.
  * NOTA 1: la computazione deve essere svolta dall'interprete Java (ovvero non deve essere inserito il risultato precalcolato nella stringa di output)
  * NOTA 2: il risultato atteso in standard output è qualcosa del tipo: `Hello, world! 2550`
  * NOTA 3: quanto richiesto al punto (9) deve essere risolto in una sola riga di codice: non si possono dichiarare variabili e  tutte le operazioni devono essere svolte *internamente* alla chiamata a `System.out.println()`
11. Si compili e si esegua, verificando il funzionamento
