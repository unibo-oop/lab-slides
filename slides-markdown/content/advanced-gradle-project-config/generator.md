
+++

title = "Laboratorio di Programmazione ad Oggetti"
description = "Laboratorio di Programmazione ad Oggetti, Ingegneria e Scienze Informatiche"
outputs = ["Reveal"]
aliases = ["project-config"]

+++

# Note per il progetto finale

<!-- write-here "cover.md" -->

<!-- end-write -->

---

Questo pacchetto colleziona delle slide, alcune delle quali già viste in precedenza,
che possono essere di particolare utilità per la corretta configurazione
di un progetto Gradle per il corso di Programmazione ad Oggetti.

Sono disponibili due progetti template su GitHub:
* Template Gradle "plain" https://github.com/unibo-oop/sample-gradle-project
* Template Gradle con JavaFX preconfigurato: https://github.com/unibo-oop/sample-javafx-project

---

## File ancillari per il progetto di OOP

Per OOP, alla struttura del progetto Gradle andranno aggiunti almeno altri due file

```text
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
│       ├── java
│       └── resources
├── build.gradle.kts
├── LICENSE
├── README.md
└── settings.gradle.kts
```

#### `README.md`

* File con la descrizione del progetto: autori, breve guida d'uso, link a risorse.
    * GitHub è in grado di fare il parse del file e di integrarlo nella pagina del progetto, in modo da dargli una descrizione.

#### `LICENSE`

* File con informazioni circa la licenza, necessario affinché il progetto sia open source.
* Per software open source, si raccomanda l'uso di MIT license.
* Qualunque licenza GPL-compatibile è ritenuta idonea per il progetto del corso.

---

## Installazione delle impostazioni per-utente

#### Motivazione

Spesso un software ha necessità di caricare al primo avvio delle *impostazioni di default*, quindi lasciare l'utente libero di modificarle e, se avviato successivamente caricare quelle scelte dall'utente. In caso di sistema multiutente, le impostazioni saranno diverse per ciascuno.

#### Strategia

* Si sceglie una cartella nella **home folder dell'utente** dove salvare le impostazioni.
    * È norma consolidata creare una cartella `.nomeprogramma`.
* Al primo avvio, si verifica se tale cartella esista e se contenga i file di configurazione previsti.
    * Se non è presente, o se non sono presenti e leggibili alcuni i file, si procede a caricare nella cartella di destinazione i file di default dal JAR usando `getResource()`.

---

## Awesome Java

Esiste una lista, costantemente manutenuta, che elenca le più comuni, diffuse e stabili librerie per una pletora di usi: [https://bit.ly/awesome-java](https://bit.ly/awesome-java)

#### USATELE!

* **Usare librerie e non reinventare la ruota è IMPORTANTE** e valutato
  positivamente.
*  Attenzione però a scegliere le librerie dopo aver fatto il **modello del dominio**
   dell'applicazione: **PRIMA** si studia il problema, **DOPO** si implementa una soluzione:
   siete aspiranti ingegneri, cercate di lavorare sempre top-down quando possibile, non partite dalla libreria per costruirci sopra un software, ma partite dai requisiti e - se utile - sfruttate le librerie per soddisfarli.

#### Attenzione ai framework!

Alcune librerie sono costruite come *Framework*,
ossia come ossature di applicazioni,
pensate per velocizzare la costruzione di un certo tipo di software
* Esempio tipico: l'engine per videogames [libGDX](`https://libgdx.com/`)

Uno degli scopi del progetto di OOP è quello di misurare se siate bravi designer,
ma per farlo è necessario che il design della vostra applicazione l'abbiate fatto voi e non chi ha costruito il framework.

Vi raccomandiamo quindi di **evitare i framework**!
O, al più, usarli solo *dopo che il progetto è avviato* come semplice libreria
(non semplice e non sempre possibile)

---

# Note per il progetto finale

<!-- write-here "cover.md" -->

<!-- end-write -->
