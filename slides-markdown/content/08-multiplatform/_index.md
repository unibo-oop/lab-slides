 
+++

title = "Laboratorio di Programmazione ad Oggetti"
description = "Laboratorio di Programmazione ad Oggetti, Ingegneria e Scienze Informatiche"
outputs = ["Reveal"]
aliases = ["/multiplatform/"]

+++

# Programmazione multipiattaforma

{{% import path="cover.md" %}}

---


### "Write once, run anywhere..."

Lo slogan, coniato originariamente da Sun Microsystems per illustrare i benefici del linguaggio Java, vale *a patto che*:
		
* **"write" sia fatta in modo corretto e robusto**;
    * ovvero, sia adottato un approccio di programmazione adeguato.
* **sia possibile distribuire ciascuna applicazione per qualunque piattaforma**.
    * ovvero, sia predisposto un packaging efficace.


---

## Accesso al file system

### Path e Separatori

Inserire dei *path assoluti* nel proprio sorgente è **sempre** fonte di problemi quando si scrive software multipiattaforma:

* `C:\Users\UserName\file` --- Non funzionerà su piattaforma *nix, e non funzionerà se l'utente Windows non è "UserName".
* `C:\MyProgram\file` --- Non funzionerà su piattaforma *nix, e non funzionerà se
l'installazione di Windows è sana e il software non è avviato con diritti di amministratore.
* `/home/username/file` --- Non funzionerà su piattaforma Windows, e non funzionerà se l'utente non è `username`.


#### Problemi


* I *separatori* per i path cambiano a seconda dell'OS
* La *struttura del file system* cambia con l'OS
* I *diritti* di lettura e scrittura cambiano con la configurazione



---

### Proprietà di sistema

Java fornisce nella classe `System` un metodo

```java
String getProperty(String p)
```

che consente di accedere a proprietà di sistema


#### Proprietà relative al file system


* `file.separator` --- Restituisce `\` per Windows e `/` per Unix
* `java.home` --- La directory di installazione di Java
* `user.dir` --- La directory da cui il comando `java` è stato invocato
* `user.home` --- Restituisce la home directory dell'utente che ha lanciato `java`
* `user.name` --- Restituisce il nome utente

```java
public static final String PROP_FILE_SEPARATOR = "file.separator";

String separator = System.getProperty(PROP_FILE_SEPARATOR);
```


---

## Accesso ai dettagli del sistema

### Funzionalità OS-specifiche


* Talvolta è possibile che in una applicazione si debbano utilizzare librerie non disponibili o non licenziate per alcune piattaforme.
* A supporto di ciò, Java fornisce delle proprietà che consentono di *identificare OS, versione, e JVM corrente*.


#### Proprietà relative al sistema


* `java.version` --- La versione di `java` in uso. Si potrebbe decidere di non usare una funzionalità che si sa non esistere o essere buggata.
* `os.arch` --- L'architettura della CPU come rilevata dall'OS (es. x86, i386, amd64, x86\_64, IA64N, arm, ...)
* `os.name` --- Il nome del sistema operativo (es. Linux, MacOS X, MacOS, Windows 8.1, Windows 10, Solaris, FreeBSD,  ...)
* `os.version` --- Restituisce per Windows il numero di versione effettivo (es.
Windows 10 restituisce 10.0), per MacOS il numero di versione (es. 10.3.4), per Linux la versione
del kernel (es. 4.17)



---

## GUI scalabili e internazionalizzazione

### GUI scalabili -- Motivazioni


#### Flessibilità

Diversamente dagli anni 90, i dispositivi oggi hanno una *densità di pixel per area* **estremamente** variabile. Si va da 120 *PPI (Pixel Per Inch)* a 640 PPI, su schermi di dimensione estremamente variabile (da 3 a 200 pollici).



#### Multipiattaforma

Piattaforme diverse, anche a parità di schermo, possono adottare diverse convenzioni:

* Diversa grandezza di bordi
* Diversa spaziatura, dimensione e tipo di font
* Diverso sistema di decorazioni


Questi elementi sono stabiliti dal *window manager* (del *windowing system* del sistema utilizzato) e non dallo sviluppatore dell'applicazione. Come indicazione generale vale che **un'applicazione ben sviluppata eredita il "look and feel" dal sistema su cui sta girando**.


---

### Esempio: Finestra non ridimensionabile e bassa risoluzione


![](imgs/lowres.jpg)

---

### Esempio: Finestra non ridimensionabile e alta risoluzione


![](imgs/brokensword.png)

---

### Best-practices per la costruzione di GUI

* A proposito della specifica delle dimensioni
    * La *dimensione di default* della finestra va calcolata *in base alla dimensione dello schermo*.
    * E' opportuno **non** *specificare dimensioni assolute in pixel* per i componenti della GUI, ma dimensionarli **in termini relativi** *rispetto al container*.
        * Anche per i layout è opportuno non utilizzare dimensioni fisse in pixel.
* A proposito dei font
    * I *font* possono essere allegati all'applicazione
    * La *dimensione dei font* può essere resa *relativa* alla dimensione corrente della view.
* *L'utente deve essere libero di ridimensionare l'interfaccia a piacimento per adattarla alla
propria configurazione di schermi*


---

### Supporto multilingua per le UI


* Sarebbe opportuno definire la UI una sola volta e cambiare dinamicamente le parti scritte (il testo) a seconda dell'impostazione della lingua di sistema (o della nostra applicazione).

* In realtà, non solo per la lingua ma anche per il formato dei numeri, la valuta, le convenzioni sulla data, ...
    * un **locale** è un insieme di parametri che definiscono la lingua dell'utente, la sua regione, e le sue preferenze di visualizzazione delle GUI
    * un esempio di locale è `en_US_UNIX` (lingua inglese, Stati Uniti, piattaforma UNIX)


#### Java Resource Bundles

Java fornisce una architettura per l'internazionalizzazione (**i18n = internationalization**), che fa uso di "**ResourceBundle**" e di una serie di file di supporto (*properties files*).

- per localizzazione (**l10n = localization**) si intende invece il processo di adattare un prodotto internazionalizzato a un particolare locale

Per approfondimenti (per implementare il supporto multilingua):

* [https://docs.oracle.com/javase/tutorial/i18n/resbundle/index.html](https://docs.oracle.com/javase/tutorial/i18n/resbundle/index.html)
* [http://tutorials.jenkov.com/java-internationalization/resourcebundle.html](http://tutorials.jenkov.com/java-internationalization/resourcebundle.html)



---

## Corretta configurazione di un progetto Gradle

---

### Risorse nei progetti Gradle

```
src/
  main/
    java/
    test/
    resources/
build.gradle.kts
settings.gradle.kts
```


* La cartella `src/main/resources` contiene le risorse del progetto opportunamente organizzate

    * Per risorse si intendono icone, file di testo, video, immagini, modelli 3D e qualunque cosa sia necessaria al corretto funzionamento del programma ma non sia una libreria o un file sorgente.


<!--

#### `README.md`


* File con la descrizione del progetto: autori, breve guida d'uso, link a risorse.

    * GitHub è in grado di fare il parse del file e di integrarlo nella pagina del progetto, in modo da dargli una descrizione.




#### `LICENSE`


* File con informazioni circa la licenza.

    * Necessario affinché il progetto sia open source.
    * Progetti il cui codice è disponibile ma non hanno alcuna licenza applicata sono automaticamente coperti da copyright.
    * Per software open source, si raccomanda l'uso di Apache License 2.0, MIT license, o BSD license.
    * Qualunque licenza GPL-compatibile è ritenuta idonea per il progetto del corso.


-->


## Font ed encoding

### Font ed encoding

Le più note piattaforme utilizzano di default encoding diversi:

* **UTF-8** --- default su Linux, può essere considerato lo standard de-facto.
* **MacRoman** --- default su MacOS, raramente causa artefatti se riconvertito ad altri formati.
* **ISO-8859-1** --- default su Windows, può causare artefatti su quasi tutti i caratteri non ASCII se convertito a UTF-8.


#### Encoding per il codice sorgente

Solitamente, il codice sorgente si sviluppa utilizzando la codifica UTF-8

    * Essenziale se si utilizzano caratteri non inclusi nella tabella ASCII (caratteri accentati, ad esempio).



---

### Carattere di new line

Unix e Windows differiscono anche per il carattere di newline

* `\n` --- Su Linux e MacOS X (e su tutti i sistemi non Windows).
* `\r` --- Su MacOS 9 e precedenti
* `\r\n` --- Windows


#### Pillola di storia


* Il "carriage return" è un'eredità dovuta alla compatibilità con MS-DOS
* Che a sua ha ereditato la cosa dalla compatibilità con CP/M-80
* A quel tempo, le stampanti erano macchine da scrivere elettromeccaniche
* `\r` riportava il rullo con la carta al margine sinistro
    - quindi, sposta il cursore di scrittura all'inizio della riga corrente
* Anche se queste stampanti non sono più in uso, alcuni produttori (come HP) mantengono la compatibilità su alcuni prodotti
* Ad oggi, si usa `\r` solo per realizzare animazioni su terminale (far sì che la nuova linea cancelli la precedente)

---

#### Standardizzazione


* Entrambi i sistemi (Unix/Windows) "digeriscono" entrambi i newline
* Ma se due membri del team usano impostazioni diverse, il DVCS considererà ogni file modificato come integralmente cambiato ad ogni salvataggio

    * Diff incomprensibili
    * Storia del progetto compromessa
    * Difficoltà di produrre patch e ripristinare il lavoro precedente

* Facciamo una scelta, e utilizziamo un solo formato
* La nostra scelta sarà `\n` (**Unix newline**)



---

### Configurazione di encoding e newline in VS Code


* `File -> Preferences -> Settings`
* Per l'opzione `Text Editor -> Files -> Encoding` selezionare `UTF-8`
* Per l'opzione `Test Editor -> Files -> Eol` selezionare `LF`

* In basso a destra nella finestra di VS Code c'è l'indicazione della codifica e di EOL per il file selezionato

![](imgs/vscode-encoding-eol.png)

---

## Caricamento di risorse dal classpath

### Risorse caricate dal classpath


* Abbiamo visto finora il *classpath* come l'insieme dei *percorsi* dove la virtual machine va a cercare le classi da caricare
    * Come abbiamo visto usando l'opzione `-cp` di `java` e `javac`, il classpath può contenere indifferentemente dei path o dei JAR (o anche degli zip)
* Esso includerà tipicamente anche le risorse del progetto, i JAR delle dipendenze importate, etc. 
* Come possiamo accedere a queste risorse in modo uniforme?

    * Ossia caricarle sia che si trovino sul file system, sia che si trovino nel JAR eseguibile, sia che vengano incluse in un JAR di risorse separato.

* Java fornisce un'utilità per caricare risorse dal **classpath**

---

### `ClassLoader.getSystemResource` e `ClassLoader.getSystemResourceAsStream`

{{% smaller %}}

```java
public abstract class ClassLoader {
  public static ClassLoader getSystemClassLoader();
  public static URL getSystemResource(String name);
  public static InputStream getSystemResourceAsStream(String name);
  public URL getResource(String name);
  // ...
```

* Questo approccio al *resource loading* è detto **location-independent** in quanto non importa dove il codice viene eseguito fin tanto che l'ambiente viene correttamente impostato per trovare le risorse.
* Un **class loader** (istanza di `ClassLoader`) è un'oggetto responsabile per il *caricamento di classi e risorse*
    * ogni class loader ha un class loader padre, per sfruttare un meccanismo di delega
    * il parent di default è il **system class loader** che carica classi e risorse *dal classpath*
* Una **risorsa di sistema** (system resource) è una risorsa "built-in" del sistema software, oppure disponibile nel sistema host (ad es. nel filesystem locale)
    * Per esempio, l'implementazione di base ricerca nel `CLASSPATH`
* L'argomento di `getSystemResource` e `getSystemResourceAsStream` è il **nome di una risorsa** (non un percorso del filesystem!), che è una stringa separata da `/` che identifica la risorsa
    * L'interpretazione del nome della risorsa dipende dall'implementazione
    * Il system class loader usa il nome come un path per cercare la risorsa a partire dalle entry del classpath
* `ClassLoader.getSystemResource()` equivale a `ClassLoader.getSystemClassLoader().getResource()`

{{% /smaller %}}


---


### Risorse caricate dal classpath -- Esempi


#### Caricamento di File

```java
final InputStream in = ClassLoader.getSystemResourceAsStream("/settings/settings");
final BufferedReader br = new BufferedReader(new InputStreamReader(in));
final String line = br.readLine();
in.close();
```



#### Caricamento di Immagini

```java
final URL imgURL = ClassLoader.getSystemResource("/images/gandalf.jpg");
final ImageIcon icon = new ImageIcon(imgURL);
final JLabel lab1 = new JLabel(icon);
```


---

## Installazione delle impostazioni per-utente

### Installazione delle impostazioni


#### Motivazione

Spesso un software ha necessità di caricare al primo avvio delle *impostazioni di default*, quindi lasciare l'utente libero di modificarle e, se avviato successivamente caricare quelle scelte dall'utente. In caso di sistema multiutente, le impostazioni saranno diverse per ciascuno.



#### Strategia


* Si sceglie una cartella nella **home folder dell'utente** dove salvare le impostazioni.
    * È norma consolidata creare una cartella `.nomeprogramma`.
* Al primo avvio, si verifica se tale cartella esista e se contenga i file di configurazione previsti.
    * Se non è presente, o se non sono presenti e leggibili alcuni i file, si procede a caricare nella cartella di destinazione i file di default dal JAR usando `getResource()`.




---

## Ricerca/Utilizzo di librerie

### Uso di Librerie

* Durante lo sviluppo di un software, spesso emerge la necessità di realizzare componenti a supporto della propria applicazione, utili per incapsulare un determinato comportamento/funzionalità ma non cruciali per la logica applicativa.
* Nella maggior parte dei casi una tale libreria/componente è già stato sviluppato da qualcun altro!
* Risulta opportuno avvalersi di librerie già disponibili e testate ...
    *  ... dopo aver letto attentamente la documentazione e averne compreso a fondo il comportamento!



---

### Librerie particolarmente utili

* **Google Guava** ([https://github.com/google/guava](https://github.com/google/guava))

    * Il progetto Guava di Google raccoglie diverse librerie core sviluppate da Google che possono essere utilizzate per lo sviluppo di applicazioni.
    * Ad esempio, sono disponibili librerie per Collections Management, Concurrency, I/O, String Processing, ...

* **Apache Commons** ([https://commons.apache.org](https://commons.apache.org))

    * Estensioni al linguaggio (Commons Lang3)
    * Libreria matematica estesa (Commons Math3)
    * Accesso semplificato all'I/O (Commons IO)
    * Costruzione semi automatica di una command line (Commons CLI)
    * Encoding e crittazione (Commons Codec), compressione (Commons Compress)

* **Static Logger Facade for Java (SLF4J)** ([http://www.slf4j.org](http://www.slf4j.org))

    * Backend-independent logging (addio `println`)



---

### Top 20 Java Library

[
![](imgs/top-20-java-libraries.png)
](http://blog.takipi.com/we-analyzed-60678-libraries-on-github-here-are-the-top-100)

---

### Awesome Java

Esiste una lista, costantemente manutenuta, che elenca le più comuni, diffuse e stabili librerie per una pletora di usi: [https://bit.ly/awesome-java](https://bit.ly/awesome-java)

**U-SA-TE-LE**!

* **Usare librerie e non reinventare la ruota è IMPORTANTE** e valutato
positivamente.
*  Attenzione però a scegliere le librerie dopo aver fatto il **modello del dominio**
dell'applicazione: **PRIMA** si studia il problema, **DOPO** si implementa una soluzione:
siete aspiranti ingegneri, cercate di lavorare sempre top-down quando possibile, non partite dalla libreria per costruirci sopra un software, ma partite dai requisiti e - se utile - sfruttate le librerie per soddisfarli.


---

### The Maven Central Repository


* Costituisce una delle più ampie collezioni di librerie e componenti Java open-source.

    * È il repository di default per Apache Maven (noto tool per il project management).
    * Bintray JCenter è un superset di Maven Central.

* Rappresenta uno dei modi più rapidi per accedere a librerie sviluppate da altri sviluppatori e distribuire le proprie.
* Consente di ricercare e scaricare pressoché qualunque libreria a supporto utile nelle proprie applicazioni open-source.
* `https://search.maven.org/`

