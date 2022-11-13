 
+++

title = "Laboratorio di Programmazione ad Oggetti"
description = "Laboratorio di Programmazione ad Oggetti, Ingegneria e Scienze Informatiche"
outputs = ["Reveal"]
aliases = ["/code-quality-tools/"]

+++

# Analisi statica

{{% import path="cover.md" %}}

---

## Analisi di qualità del codice sorgente

### "Software di analisi statica del codice" - Definizione

Software in grado di analizzare il codice sorgente per individuare:

* Potenziali bug, magari dovuti a distrazione
* Possibili miglioramenti, ottimizzazioni o pratiche difformi da quelle consigliate
* Codice duplicato, segnale di una progettazione discutibile
* Stile non conforme

#### Uso

L'analisi automatica del proprio codice consente di migliorare la qualità del codice,
aiuta ad apprendere il modo corretto di scrivere,
riduce il costo di manutenzione,
e garantisce uniformità fra le parti sviluppate da persone diverse
(aiutando quindi il sistema di controllo versione!).

---

### Code checking

I software che vedremo sono eseguibili in due modalità:

* *Stand-alone*: il software viene eseguito e genera un report
* Come *plug-in*: il software viene integrato con l'IDE (ad es. VS Code), e segnala i problemi sotto forma di warning
* Come *plugin Gradle*: Gradle viene configurato per eseguire il software nella prima modalità

Noi vedremo la terza modalità.

---

## SpotBugs (ex FindBugs)} 


SpotBugs scansiona il bytecode generato dal compilatore, e dalla sua analisi cerca di scoprire potenziali bug nel sorgente, ad esempio:

* Uguaglianza esatta fra `float` o `double`
* Utilizzo di `==` invece di `equals()`
* Mancata annotazione di annotazioni usate a runtime via reflection
* Uso errato di meccanismi di sincronizzazione
* Assenza di copie difensive
* Variabili non utilizzate
* Vulnerabilità  di sicurezza
* Tanti altri! Si veda: [https://spotbugs.readthedocs.io/en/stable/bugDescriptions.html](https://spotbugs.readthedocs.io/en/stable/bugDescriptions.html)

---

## PMD e CPD

PMD si occupa di trovare imperfezioni nel codice:

* Campi pubblici, protetti o default
* Mancato uso di final
* Singular fields
* Integra CPD (copy/paste detector) per verificare se vi siano blocchi di codice copincollati
* Tanti altri! Si veda: [https://pmd.github.io/latest/pmd_rules_java.html](https://pmd.github.io/latest/pmd_rules_java.html)

---

## Checkstyle

Cos'è: Checkstyle si occupa di trovare errori di stile:
		
* Mancanza di commento Javadoc
* Spaziature non corrette
* Parentesi assenti
* Magic numbers
* Altro: [http://checkstyle.sourceforge.net/checks.html](http://checkstyle.sourceforge.net/checks.html)

---

## Configurazione e utilizzo tramite Gradle

* Plugin
* Aggressività
* Build reports


## Soppressione

