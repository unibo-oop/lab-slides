# Programmazione ad Oggetti - Laboratorio 02
## Esercizio 2 - classpath compilation

#### Uso del classpath in fase di compilazione e classpath multipercorso

1. Si provi a compilare il file `UseComplex.java` dentro la cartella `bin` (da creare).
  - Oh-oh... Errore.
2. Si legga attentamente l'errore: di cosa si lamenta il compilatore?
3. La classe fornita richiede `ComplexNum` per poter funzionare, ma `ComplexNum` è fornito nel precedente esercizio: utilizzando appropriatamente l'opzione `-cp` di `javac`, si compili `UseComplex.java` dentro la cartella `bin`, sfruttando la classe *compilata* nell'esercizio precedente.
  - È vietato SPOSTARE file (sorgenti o compilati)
  - È vietato ricompilare il sorgente di `ComplexNum`
  - Si lasci il terminale posizionato nella cartella che contiene src
  - Si ricordi che `..` significa "livello directory superiore a quella corrente" (ossia, la cartella dentro cui la cartella corrente è posizionata).
  - Si fa presente che `javac -d bin -cp ../01-packages/bin FILEDACOMPILARE` istruisce `javac` informandolo che deve utilizzare anche le classi compilate presenti dentro il percorso `../01-packages/bin`
4. Si esegua `UseComplex` col comando `java -cp bin oop.lab02.math.UseComplex`
  - Oh-oh... Errore. Lo si legga attentamente: perché l'interprete ha dato errore? (Nota: se non dà errore, chiamare il docente, è stato necessariamente commesso un errore al punto 3).
5. Si esegua la classe `oop.lab02.math.UseComplex` usando opportunamente più percorsi nel classpath, a tal proposito si ricorda che:
    - Il separatore di percorsi è `:` su Linux e `;` su Windows
    - Il comando `java -cp bin:../01-packages/bin NOMEDELLACLASSE` (formato Unix, usare `;` come separatore in Windows) istruisce l'interprete Java dicendogli di andare a caricare classi non solo dalla posizione corrente, ma anche dalla cartella `bin`, e dalla cartella `../01-packages/bin`
