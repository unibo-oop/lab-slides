* Si acceda a [Bitbucket](https://bitbucket.org/)
* Ci si logghi con il proprio utente
* Si vada al [progetto di test](https://bitbucket.org/danysk/courses-oop-merge-conflict-test)
* Dall'interfaccia web di Bitbucket, si crei una propria fork del progetto
* Utilizzando il comando ``hg clone``, si cloni **la propria fork del progetto** all'interno di una nuova directory
* Utilizzando il comando ``hg branches``, si verifichi che il progetto ha due branches
* Utilizzando il comando ``hg branch``, si verifichi su quale branch ci si trovi attualmente
* Utilizzando il comando ``hg heads``, si verifichi che il progetto ha tre teste
* La situazione non è triviale: si utilizzi ``hg log -G`` per capire esattamente com'è strutturato il repository
* Si noti che il branch su cui ci troviamo (``default``)  ha due teste (la revision 2 e la 3, dove ci troviamo), mentre il branch ``feature`` ne ha una soltanto (revision 4).
* Si configuri Mercurial per utilizzare come algoritmo di risoluzione ``internal:merge``
* Si tenti di fare il merge delle teste del branch corrente utilizzando ``hg merge -r 2``
* Si osservi l'output di Mercurial: il merge ha generato un conflitto
* Si utilizzi il comando ``ls -ahl`` (su Windows si usi l'equivalente ``dir``) per vedere l'elenco dei file contenuti in ``src``
* Si noti che è stato creato un file ``.origin``
* Utilizzando il comando ``cat`` (in Windows si usi il comando equivalente ``type``) si osservi il contenuto dei file \texttt{HelloWorld.java.orig} e \texttt{HelloWorld.java}
* Si modifichi HelloWorld.java in modo che stampi le informazioni riguardanti l'autore (non si modifichi l'autore al momento) e che stampi nella linea successiva l'informazione sul numero di processori installati.
* Si compili nella cartella ``bin`` il file ``HelloWorld.java``
* Se ne testi il funzionamento
* Una volta che il programma è funzionante, si usi hg status per vedere lo stato del repository. Si noti che il file ``.orig`` è in stato ``?`` (non track-ato, non ignorato)
* Si elimini il file ``.orig``
* Si dichiari risolto il conflitto di merge di ``HelloWorld.java`` utilizzando propriamente il comando ``hg resolve -m``
* Si osservi che Mercurial segnala che non vi sono conflitti rimanenti
* Si salvi il merge con ``hg commit``
* Si esegua il push del nuovo stato del repository verso il repository Bitbucket
* Si osservi online la storia dei commit ed il grafo che mostra l'evoluzione dei flussi di lavoro
* Si utilizzi localmente ``hg log -G`` e si verifichi come le due storie coincidano
* Si passi al branch ``feature`` utilizzando il comando ``hg update feature``
* Si compilino e si eseguino i file Java presenti in src
* Si torni sul branch ``default``
* Si tenti il merge del branch ``feature`` dentro default, col comando ``hg merge feature``
* Si osservi che otteniamo un secondo merge conflict!
* Si risolva autonomamente il merge conflict, in maniera tale che il file risultante mostri l'autore, il numero di CPU installate nel sistema, e la memoria disponibile per la JVM.
* Una volta che il merge è completato, si osservi con ``hg log -G`` che c'è una sola testa "logica"
* Si utilizzi ``hg heads``: il vecchio branch è ancora attivo!
* Ricordando le slides ed i comandi utilizzati nella precedente lezione, si chiuda il branch ``feature``
* Si effettui il push e si verifichi lo stato del repository

> Se avete capito chiaramente come operare con un repository remoto e come risolvere i merge conflicts, siete pronti per usare Mercurial su progetti veri! CONSIGLIO: Cominciate ad utilizzarlo a tappeto. Più lo utilizzerete, meglio lo imparerete, meglio lavorerete al progetto con i vostri colleghi!
