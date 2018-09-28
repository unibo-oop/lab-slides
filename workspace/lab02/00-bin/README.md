# Laboratorio 02

Nota: in questo esercizio non è necessario mostrare il risultato ai docenti per la correzione.
Ci si assicuri di aver seguito correttamente le istruzioni.
In caso di dubbi, non si esiti a contattare i docenti per una spiegazione.

## Compilazione in percorsi arbitrari

1. Si osservi la struttura del progetto: la cartella `src` contiene il sorgente.
2. Si crei una nuova cartella `bin` (usare il comando `mkdir` e non il file manager)
3. Si esegua la compilazione dentro bin
  - In Unix: `javac -d bin src/Calculator.java`
  - In Windows: `javac -d bin src\Calculator.java`
  - si noti il diverso separatore di percorso
4. Si verifichi la presenza di `Calculator.class` all'interno di `bin`
5. Si sposti il terminale dentro `bin`
6. Si esegua la classe `Calculator`

## Compilazione da percorsi arbitrari verso percorsi arbitrari

1. Si cancelli il contenuto di bin utilizzando l'apposito comando
  - In Unix: rm bin/*
  - In Windows: del bin\*
2. Si posizioni il terminale nella root del file system
  - In Unix, `/`
  - In Windows, `C:\` (o altra lettera di unità se il file non è stato scompattato in `C:`
3. Senza cambiare la posizione del terminale, si ricompili il file precedente dentro la medesima cartella `bin`
  - Si vedano le slide di laboratorio che spiegano come compilare in directory arbitrarie
4. Si verifichi la presenza di `Calculator.class` all'interno di `bin`

## Esecuzione con classpath esplicito

1. Si posizioni il terminale nella cartella che contiene `src` e `bin`
2. Da quella posizione, si esegua la classe `Calculator` usando opportunamente l'opzione `-cp` (si faccia riferimento alle slide del laboratorio)
3. Si posizioni il terminale nella root del file system
  - In Unix, `/`
  - In Windows, `C:\` (o altra lettera di unità se il file non è stato scompattato in `C:`
4. Senza cambiare la posizione del terminale, si esegua nuovamente `Calculator`
