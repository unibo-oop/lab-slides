 
+++

title = "Laboratorio di Programmazione ad Oggetti"
description = "Laboratorio di Programmazione ad Oggetti, Ingegneria e Scienze Informatiche"
outputs = ["Reveal"]
aliases = ["/junit/"]

+++

# Testing unitario con Gradle

<!-- write-here "cover.md" -->

<!-- end-write -->

---

## Test e build lifecycle

L'esecuzione dei test *è parte integrante* del processo di costruzione del software:

* *compilazione* $\Leftarrow$ la conosciamo
* *compilazione dei test* $\Leftarrow$ **non diversa da quello che già sappiamo**
* *verifica statica della qualità dei sorgenti* $\Leftarrow$ altro lab
* *esecuzione dei test* $\Leftarrow$ **ci occupiamo di questo**
* *generazione della documentazione* $\Leftarrow$ altro lab
* *costruzione degli artefatti "deliverable"* $\Leftarrow$ altro lab
* *pubblicazione* $\Leftarrow$ magistrale :)
* *messa in produzione* $\Leftarrow$ magistrale :)

```mermaid
<!-- write-here-code "content/build-lifecycle.md" -->

<!-- end-write -->
classDef test fill:#f9f,stroke:#333,stroke-width:4px
```

---

## Build lifecycle in Gradle

Gradle *mappa* con i task il processo di costruzione del software

```mermaid
<!-- write-here-code "content/gradle-build-lifecycle.md" -->

<!-- end-write -->
classDef test fill:#f9f,stroke:#333,stroke-width:4px
classDef check fill:#f9f,stroke:#333,stroke-width:4px
classDef build fill:#f9f,stroke:#333,stroke-width:4px
```

L'esecuzione di un task implica l'esecuzione di tutti i precedenti!

* `test` (implica `compileTestJava` che implica `compileJava`): esegue tutti i test
* `check` (implica `test`): esegue i test ed eventuali controlli aggiuntivi che vedremo in futuro
* `build`: esegue sia `check` che `assemble`

Un buon modo per eseguire l'intero ciclo di vita è `./gradlew build javadoc`!

---

## Separazione fra sorgenti principali e di test

Gradle separa i sorgenti di test da quelli principali del programma in modo netto:
* Sorgenti del software: `src/main`
* Sorgenti di test: `src/test`

Questa è un'ottima pratica: quando andiamo a costruire il nostro "deliverable",
non vogliamo portarci dietro tutti i test compilati,
né tantomeno le librerie che usiamo solo per i test!

D'altra parte, vogliamo che i sorgenti di test siano in effetti parte del progetto.

---

## Configurazione di JUnit 6 in Gradle

Il plugin `java`, di per sé, non configura nessuna suite di test specifica:
va aggiunta al build file la configurazione di JUnit,
seguendo questi passi:

1. Va specificato *dove* JUnit va cercato e (se trovato) scaricato
2. Va specificato quali moduli di JUnit sono da utilizzare, e a che *versione*
    * Sono molti, e noi ne usiamo solo alcuni
3. Va detto a Gradle che vogliamo usare JUnit Platform (è il metodo di avvio dei test in JUnit 5)
    * Si veda https://junit.org/junit5/docs/current/user-guide/#overview-what-is-junit-5
4. Opzionalmente, possiamo chiedere a Gradle di mostrare più output di quanto normalmente farebbe
    * Ad esempio, mostrando quando comincia e quando termina un test, con che risultato, e mostrando il suo output su terminale
    * Diversamente, Gradle si limita a fallire se un qualche test fallisce

---

## Configurazione di JUnit 6 in Gradle

### Dove prendere le librerie

Esistono diversi *repository* con librerie, quello di riferimento per Java è **Maven Central**
* Vedremo poi in dettaglio in futuro

```kotlin
{{% import-raw from=18 to=21 path="sample-gradle-project/build.gradle.kts" %}} 
```

### Scegliere moduli e versioni

Dobbiamo specificare che sono *dipendenze*,
che ci servono *solo per i test*,
che il motore di esecuzione serve *solo a runtime*,
e che *vogliamo una specifica versione*
 
* Nel caso specifico di JUnit, per mantenere coerenti le versioni dei componenti della libreria, si usa un "*BOM*" (Bills of Material).

```kotlin
dependencies {
    {{% import-raw from=39 to=43 path="sample-gradle-project/build.gradle.kts" %}}
}
```

---

# Testing unitario con Gradle

<!-- write-here "cover.md" -->

<!-- end-write -->
