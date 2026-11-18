
+++

title = "Laboratorio di Programmazione ad Oggetti"
description = "Laboratorio di Programmazione ad Oggetti"
outputs = ["Reveal"]
aliases = ["/build-systems-basics/"]

+++

# Build systems e introduzione a gradle

<!-- write-here "cover.md" -->

<!-- end-write -->

---

<!-- write-here "shared-slides/build-systems/it-gradle-basics.md" -->

<!-- end-write -->

---

<!-- write-here "shared-slides/build-systems/it-gradle-wrapper.md" -->

<!-- end-write -->

---

## Eseguire applicazioni con Gradle: il plugin `application`

Il plugin `java` si occupa di *compilare*, ma non di *eseguire*.

`application` è un plugin incluso in Gradle che configura una classe come "main class" per il software
* Aggiunge il task `run`, che compila il progetto ed esegue la main class
    * Il classpath (compilati, risorse, librerie) viene configurato da Gradle
* Usa la stessa JVM configurata per la compilazione (vedi *toolchain*, più avanti)

```kotlin
plugins {
    java
    application
}

application {
    // Nome qualificato della classe contenente il main
    mainClass = "it.unibo.myapp.MyApplication"
}
```

* `./gradlew run` compila ed esegue `it.unibo.myapp.MyApplication`
    * Sostituisce il lancio manuale di `java -cp build/classes/java/main ...` a mano!

---

## Utilizzo di `application` con multipli `main` tramite proprietà di progetto

Nel caso in cui vi fossero più classi con un main, è possibile passare a Gradle il nome di classe da lanciare.

Per farlo, sfruttiamo il concetto di *proprietà* del progetto.

Le proprietà sono associazioni chiave-valore fra due stringhe che possono essere:
* fornite come configurazione del sistema **$\leftarrow$ non lo vediamo**
* fornite come variabile d'ambiente **$\leftarrow$ non lo vediamo**
* scritte in un file `gradle.properties` *$\leftarrow$ per OOP cambia poco rispetto a scriverlo nel `build.gradle.kts`*
* passate da terminale in formato `-Pnome=valore` *$\leftarrow$ utile se si hanno più main*

Scrivendo quanto segue nel `build.gradle.kts`

```kotlin
application {
    // prende la main class dalle proprietà di  progetto
    mainClass = providers.gradleProperty("myMainClass")
}
```

È possibile poi scegliere la main class da avviare usando:
* `./gradlew run -PmyMainClass=...`
    * (sostituendo ai `...` il nome qualificato della main class)

Ad esempio, se abbiamo due classi con main `it.unibo.oop.Pluto` e `it.unibo.oop.Paperino` nel nostro progetto, possiamo lanciare:
* `./gradlew run -PmyMainClass=it.unibo.oop.Pluto`
    * per eseguire `Pluto`
* `./gradlew run -PmyMainClass=it.unibo.oop.Paperino`
    * per eseguire `Paperino`

---

## Anche Java è una dipendenza

**Problema**: quale versione di Java usa Gradle per compilare ed eseguire?
* Di default, *la stessa JVM su cui gira Gradle*
    * ossia quella indicata da `JAVA_HOME`, o il primo `java` trovato nel `PATH`
* Quindi **dipende dalla macchina** su cui si lancia la build!

Cosa può andare storto?
* Il progetto usa costrutti di Java 25, ma sulla macchina di un collega è installato Java 17
    * $\Rightarrow$ errori di compilazione difficili da interpretare
* Il progetto è compilato con un JDK più recente di quello usato per eseguirlo
    * $\Rightarrow$ `UnsupportedClassVersionError` a runtime
* Progetti diversi richiedono versioni diverse di Java
    * $\Rightarrow$ si finisce a modificare `JAVA_HOME` a mano a seconda del progetto

Esattamente lo stesso problema già risolto per Gradle con il *wrapper*:
vogliamo **dichiarare** la versione di Java nel progetto, e che sia il build system a procurarla.

---

## Java toolchains

Una **toolchain** è un JDK (compilatore, JVM, `javadoc`, ...) di una specifica versione,
che Gradle usa per costruire il progetto,
**indipendentemente** dalla JVM su cui gira Gradle stesso.

La versione si dichiara nel `build.gradle.kts`:

```kotlin
java {
    toolchain {
        // Versione di Java usata per compilare ed eseguire il progetto
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}
```

La toolchain viene usata da tutti i task Java:
* compilazione (`compileJava`, `compileTestJava`)
* esecuzione dei test (`test`)
* generazione della documentazione (`javadoc`)
* esecuzione dell'applicazione (`run`, dal plugin `application`)

---

## Java toolchains: dove trova il JDK Gradle?

1. **Auto-detection**: Gradle cerca i JDK già installati nel sistema
    * nei percorsi standard del sistema operativo, in `JAVA_HOME`, in SDKMAN!, in IntelliJ IDEA, ...
    * `./gradlew javaToolchains` elenca i JDK trovati
2. **Auto-provisioning**: se nessun JDK compatibile è installato, Gradle può *scaricarlo* automaticamente
    * Richiede di indicare a Gradle *da dove* scaricarlo
    * Il modo più semplice è applicare il plugin `foojay-resolver-convention` nel `settings.gradle.kts`

`settings.gradle.kts`
```kotlin
{{% import-raw path="sample-gradle-project/settings.gradle.kts" %}}
```

I JDK scaricati vengono salvati in `~/.gradle/jdks`, e riutilizzati da tutti i progetti.

**Nota**: per lanciare Gradle serve comunque *una* JVM installata,
ma non è più necessario che sia quella corretta per il progetto!

---

# Build systems e introduzione a gradle

<!-- write-here "cover.md" -->

<!-- end-write -->
