# Esercizio con Mercurial

Tenendo a mente quanto spiegato finora, facendo uso delle informazioni nelle slides precedenti, e se necessario aiutandosi con la tabella dei comandi presentata nei laboratori precedenti, svolgere **in ordine** i seguenti punti.

> Nota: l'esercizio va completato entro un tempo limite di 20 minuti.
> Superato questo tempo, si passi all'esercizio 1 in Java, e si completi l'esercizio su Mercurial a casa.
> Si sfrutti il forum per risolvere gli eventuali dubbi.
> È **molto** importante che, anche se questo esercizio non è completo, vi focalizziate sulla sperimentazione dei nuovi concetti che avete appreso a lezione riguardanti Java.

* Si configuri Mercurial, creando il file di configurazione appropriato a seconda che si stia usando un sistema *nix o Windows
* Si apra un terminale
* Si crei una nuova cartella
* Ci si posizioni col terminale nella nuova cartella
* Si inizializzi un nuovo repository Mercurial
* Si crei, utilizzando un editor di testo (e.g. JEdit) un file ``HelloWorld.java``, che contenga una sola classe ``HelloWorld`` ed un metodo main con una sola ``println``
* Si osservi lo stato del repository con ``hg status``. Il file appare, il suo stato è non tracciato e non ignorato.
* Si aggiunga ``HelloWorld.java`` al repository
* Si osservi lo stato del repository con ``hg status``. Si noti che lo stato del file è passato ad ``A`` (aggiunto)
* Si effettui il primo commit, inserendo un commit message sensato (ad esempio ``create new HelloWorld class``), senza utilizzare l'opzione ``-m``
* Si osservi nuovamente lo stato del repository con ``hg status``
* Si osservi la history dei commit utilizzando ``hg log``
* Si modifichi ``HelloWorld.java``, cambiando la stringa che viene stampata nella ``println``
* Si osservi nuovamente lo stato del repository con ``hg status``
* Si osservi la modifica fatta al file ``HelloWorld.java`` utilizzando propriamente ``hg diff``
* Si faccia il commit delle modifiche, stavolta utilizzando l'opzione ``-m``
* Si compili nella cartella ``bin`` il file HelloWorld.java
* Si osservi nuovamente lo stato del repository con ``hg status``. Si noti che Mercurial rileva dei nuovi file che non sono ancora tracciati
* Dato che non desideriamo tracciare file che possono essere compilati, si scriva un file ``.hgignore`` che faccia sì che Mercurial ignori tutti i file con estensione ``.class`` e tutti i file nel cui path è presente una cartella chiamata ``bin``
* Si verifichi con ``hg status`` che il file compilato non viene più mostrato fra quelli tracciabili, mentre viene mostrato ``.hgignore``
* Si aggiunga ``.hgignore`` al tracker e si faccia commit
* Modificare ``HelloWorld.java`` in modo tale che non compili. Assicurarsi che non compili utilizzando ``javac``
* Correggere l'errore inserito facendo roll back con ``hg update --clean``
* Verificare con ``hg status`` che il repository sia stato portato allo stato precedente, quindi compilarlo con ``javac``
* Tornare al primo commit effettuato con ``hg update -r0 --clean``
* Ricompilare ed eseguire, verificando che si sia tornati allo stato iniziale
* Ora vogliamo aggiungere una nuova feature: un file readme.
* Si crei un nuovo branch chiamato ``readme``
* Creare un nuovo file ``README.txt`` utilizzando un editor di testo. Inserire al suo interno nome, cognome e matricola.
* Si aggiunga ``README.txt`` al tracker
* Si faccia commit
* Si utilizzi hg branches per vedere quali rami di sviluppo sono attivi
* Si utilizzi hg log -G per vedere la storia del repository con il grafico a fianco
* Si rinomini, utilizzando ``hg mv``, ``README.txt`` in ``README.md``
* Verificare con ``hg status`` quale sia lo stato del repository
* Si faccia commit della modifica
* Si osservi nuovamente la storia del progetto con ``hg log -G``
* Utilizzando ``hg update -r3``, si torni al momento precedente la rinominazione del file
* Si verifichi (comando ls in Unix, dir in Windows) che il file si chiama nuovamente ``README.txt``
* Si modifichi ``README.txt``, modificando la matricola
* Si esegua un commit
* SI noti che Mercurial segnala che abbiamo creato una nuova testa all'interno del branch corrente! Questa è una situazione poco gradevole, e vogliamo risolverla.
* Si utilizzi ``hg log -G`` per vedere lo stato attuale del repository.
* Si osservi, utilizzando ``hg heads``, che si abbiano tre linee di sviluppo totali, di cui due sul branch ``readme``: in una il file si chiama ``README.md`` e contiene la vecchia matricola, nell'altra c'è la nuova matricola, ma il file si chiama ``README.txt``
* Si uniscano le linee di sviluppo con ``hg merge -r4`` (se tutto è stato eseguito correttamente, il commit da mergere è il numero 4)
* Si noti come Mercurial sia sufficientemente intelligente da capire che si tratta dello stesso file modificato e spostato: se non si sono fatti errori, non ci saranno merge conflict
* Si faccia un commit per concludere l'operazione di merge.
* Si osservi con hg heads che ora vi sono solo due linee di sviluppo, su due branch diversi (``readme`` e ``default``)
* Si utilizzi ``hg log -G`` per osservare la storia del repository. Si noti che il commit corrente ha due parent.
* Il nostro README file è pronto, e vogliamo unirlo al branch ``default``
* Si torni al branch ``default`` usando ``hg update default``
* Si esegua il merge dei due branch, utilizzando il comando ``hg merge readme``
* Si concluda il merge eseguendo un commit
* Si osservi lo stato sia con ``hg log -G`` che con ``hg heads`` che con ``hg branches``: il repository ha un solo "top" commit, ma ha ancora due teste, e una appartiene al branch readme, ora marcato come ``(inactive`` in ``hg branches``
* Vogliamo chiudere il branch readme
* Si torni al branch readme con ``hg update readme``
* Si informi Mercurial che non si svilupperà ulteriormente su quella linea, utilizzando ``hg commit --close-branch``
* Si torni all'ultima versione usando ``hg update default``
* Si utilizzi ``hg heads`` e ``hg branches`` per verificare che Mercurial rilevi una sola linea di sviluppo attiva
* Si cancellino tutti i file dal repository a mano (senza utilizzare ``hg rm``, ma semplicemente rimuovendoli)
* Si osservi lo stato del repository con ``hg status``
* Si ripristinino i file cancellati con ``hg update --clean``
* Si rimuova dal tracking il file ``README.md`` utilizzando ``hg rm``
* Si faccia il commit della modifica
* Utilizzando hg log con l'opzione -G, si osservi tutta la storia del repository, quindi si visualizzino solo le ultime due operazioni usando opportunamente l'opzione ``--limit``.
