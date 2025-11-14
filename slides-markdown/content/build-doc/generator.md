 
+++

title = "Laboratorio di Programmazione ad Oggetti"
description = "Laboratorio di Programmazione ad Oggetti, Ingegneria e Scienze Informatiche"
outputs = ["Reveal"]
aliases = ["javadoc"]

+++

# Documentazione del codice

<!-- write-here "cover.md" -->

<!-- end-write -->

---

## Documentare il codice sorgente

La documentazione di un progetto software è un aspetto *fondamentale*
Al fine di garantirne la *manutenibilità*
* Siamo cosı̀ sicuri di ricordarci, a distanza di settimane, del perché
  abbiamo adottato una certa architettura, scritto una certa classe, una
  data estensione di una classe, un certo metodo?
* Arriva in azienda un nuovo sviluppatore: come fa a costruirsi il
  background necessario per lavorare su un progetto software esistente?
  Al fine di aumentare la comprensione del codice
    * Cosa farà mai il metodo `doStuff()` sviluppato dal collega?
    * Ci sono dei metodi che sono disponibili solo per ragioni di compatibilità e che non dovrei più utilizzare?

---

## `javadoc`

Strumento di supporto per la generazione automatica di documentazione HTML di software Java
tramite utilizzo di una specifica sintassi nei commenti

### Funzionamento

* Il tool processa tutti commenti del tipo `/** ... */`
* I commenti devono trovarsi in posizioni specifiche: *in testa* a dichiarazione di interfacce/classi o dei loro membri
* Esiste una sintassi specifica per esprimere informazioni specifiche
    * significato dei parametri di un metodo
    * significato dei type-parameters di una classe generica
    * valore di ritorno di un metodo
    * eventuali eccezioni e condizioni che le scatenano
    * informazioni circa la *deprecazione*, ad esempio metodi da preferire a quello corrente

---

## Build lifecycle

La costruzione dellla documentazione *è parte integrante* del processo di costruzione del software:

* *compilazione* $\Leftarrow$ la conosciamo
* *compilazione dei test* $\Leftarrow$ altro lab
* *verifica statica della qualità dei sorgenti* $\Leftarrow$ altro lab
* *esecuzione dei test* $\Leftarrow$ altro lab
* *generazione della documentazione* $\Leftarrow$ **ci occupiamo di questo**
* *costruzione degli artefatti "deliverable"* $\Leftarrow$ altro lab
* *pubblicazione* $\Leftarrow$ magistrale :)
* *messa in produzione* $\Leftarrow$ magistrale :)

```mermaid
<!-- write-here-code "content/build-lifecycle.md" -->

<!-- end-write -->
classDef docs fill:#f9f,stroke:#333,stroke-width:4px
```

---

## Build lifecycle in Gradle

Gradle *mappa* con i task il processo di costruzione del software

```mermaid
<!-- write-here-code "content/gradle-build-lifecycle.md" -->

<!-- end-write -->
classDef docs fill:#f9f,stroke:#333,stroke-width:4px
```

L'esecuzione di un task implica l'esecuzione di tutti i precedenti!

* `javadoc` implica `compileJava`
* per il resto è isolato dal resto della build!

Un buon modo per eseguire l'intero ciclo di vita è `./gradlew build javadoc`!

---

### Esempio

```java
import java.util.List;
/**
 * This is an exemplary documentation of a class named {@code Something}.
 * It is possible to use <i>HTML tags</i> in this text, and special characters such as &amp; must be
 * escaped as uyou would escape them in HTML.
 * Code can be written in {@code code tags}. Other entities can be linked via {@code @link}, e.g.,
 * the {@link List} interface, or the {@link List#of(Object...)} method.
 *
 * @param <T> This is the documentation specific for the class parameter {@code T}
 * @see List#size()
 * @deprecated This contains information on the reason why this class should not be used in new code,
 * when (if) will eventually be removed, and what to use as a replacement.
 */
@Deprecated
interface Something<T> {
    /**
     * This is the documentation of a method. The text is still HTML.
     * 
     * @param subject Documents the parameter @{code subject}
     * @param count Documents the parameter @{code count} (one entry per parameter)
     * @return Provides information on the returned information
     * @throws IOException Provides detail on the causes that may trigger an @{code IOException}
     * @throws IllegalArgumentException If more exceptions are thrown, each should get documented
     * 
     */
    @Deprecated
    int doIt(List<T> subject, int count) throws IOException { ... }
}
```

---

## Tag informativi

`@param`
* Utilizzabile nei commenti relativi a costruttori/metodi o in classi parametriche
* Descrive parametro di input oppure type-parameters per classi/metodi generici
* Una entry per parametro

`@return`
* Utilizzabile nei commenti relativi ai metodi
* Descrive il valore di ritorno
* Solo uno per metodo

`@throws`
* Utilizzabile nei commenti relativi a costruttori/metodi che possono lanciare eccezione
* Descrive l’eccezione e il motivo per cui viene lanciata

`@see`
* Indica eventuali altre entità la cui documentazione potrebbe essere di interesse per chi legge
* Ad esempio, una funzionalità su generiche collezioni potrebbe linkare `List` e `Set`

---

## Informazioni di deprecazione

### Deprecazione

La deprecazione è il processo di *demarcazione di codice esistente* come *non più utile* nella codebase,
tipicamente perché rimpiazzato da *nuovi componenti* con un design rivisto e migliorato.

Questo codice viene solo marchiato come deprecato e non rimosso immediatamente per evitare problemi di retrocompatibilità.

Ciononostante, il suo utilizzo in nuovo codice è *fortemente scoraggiato*,
mentre il passaggio al codice sostitutivo è *fortemente raccomandato*.

### Deprecazione in Java

In Java, le entità deprecate vanno annotate con `@Deprecated`,
e opportunamente documentate col tag `@deprecated`
* Utilizzabile nei commenti relativi a entità annotate con `@Deprecated`
* Indica che quella particolare entità è stata *deprecata*:
è ancora disponibile per ragioni di retrocompatibilità,
ma è opportuno non utilizzarlo nello sviluppo di nuovo codice
* Si dovrebbe indicare cosa andrebbe usato in sostituzione
(per facilitare l'adozione delle nuove API)

---

## Tag descrittivi

Questi tag servono a migliorare la formattazione del testo, senza dover passare per tag HTML.
Tipicamente appaiono nel testo principale.

`{@link target}`
* Consente di fare collegamenti ipertestuali a entità della stessa classe o esterne
* Esempi di utilizzo:
    * `{@link qualified.name.of.OtherClass#someMethod}`
    * `{@link #someMethodOfSameClass}`
    * `{@link #someFieldOfSameClass}`

`{@code testo}`
* Formatta il `testo` con un font monospaziato

`{@inheritDoc}`
* Utilizzabile in metodi che fanno override (preferibilmente, annotati con `@Override`)
* "Copia" la Javadoc della superclasse in quella corrente
* Da utilizzare per evitare ripetizioni,
se viene implementato un metodo e l'uso esterno non è diverso da quello previsto dall'interfaccia/superclasse.

---

## Altri tag

Esistono alcuni tag aggiuntivi il cui utilizzo è *scoraggiato*
(almeno in questo corso).
Questo, tipicamente, perché indicano informazioni che sono reperibili a partire dal sistema di controllo versione,
ma che, a differenza delle informazioni tracciate da quest'ultimo, sono manuali

`@since`
* Indica la prima versione in cui una certa entità è apparsa
* Utile, per il JDK per sapere se una certa entità sarà disponibile in JVM più vecchie
* Può avere senso anche per progetti versionati

`@author`
* Indica l'autore della classe/interfaccia (in caso di autori multipli, un tag per autore)
* La stessa informazione è deducibile dal controllo versione, si raccomanda di **non usarlo**

`@version`
* Indica la versione di una certa classe/interfaccia
* Va mantenuta manualmente,
è meglio lasciare la gestione delle versioni al sistema di controllo versione,
si raccomanda di **non usarlo**

---

## Cosa commentare, linee guida

* Inserire sempre un commento che descrive il ruolo e il funzionamento generale dell'**interfaccia**/**classe**/**record**
* Inserire un commento per tutti i **costruttori** (**parametri** e **return value** inclusi), **metodi**, e **campi** *con livello di accesso `public` e `protected`*
* Non è necessario avere commenti javadoc su metodi `private` (non sono comunque chiamabili dal codice cliente)
* Non è necessario ri-documentare metodi di cui si fa override,
a meno che non vi siano peculiarità non rilevate nella documentazione della superclasse:
quando possibile, utilizzare `{@inheritDoc}`.

#### Utilizzare i sorgenti che vi forniamo in lab come riferimento!

---

## Generazione della Javadoc tramite Gradle

Il tool `javadoc` è molto potente e ricco di opzioni,
usarlo direttamente è un esercizio non banale
che va oltre lo scopo di questo corso.

È possibile però appoggiarsi a Gradle per generare documentazione con impostazioni di default ragionevoli.

Il plugin `java` di Gradle aggiunge un task `javadoc` che documenta automaticamente tutto il sorgente in `src/main/java`,
generando il sito web relativo in `build/`

**NOTA --** In caso di javadoc incompleta, il task fallisce! 

---

# Documentazione del codice

<!-- write-here "cover.md" -->

<!-- end-write -->
