# Si svolgano i punti descritti di seguito. Se l'esercizio non viene completato entro 20 minuti, si passi agli esercizi in Java.

* Si acceda a [Bitbucket](https://bitbucket.org/)
* Ci si logghi con il proprio utente
* Si vada al [progetto di test](git@bitbucket.org:danysk/courses-oop-git-merge-conflict-test.git)
* Dall'interfaccia web di Bitbucket, si crei una propria fork del progetto
* Utilizzando il comando ``git clone`` appropriatamente, si cloni **la propria fork del progetto** all'interno di una nuova directory
* Si verifichi di aver clonato correttamente con `git status`
* Utilizzando il comando `git branch -a`, si verifichi quanti branch remoti abbia il repository.
* Si noti l'esistenza di un branch remoto di nome `feature`
* Si crei un branch locale `feature` che faccia tracking del branch remoto con il medesimo nome
* Si usi `git branch` per verificare che siano ora presenti due branch locali (`master` e `feature`)
* Si si assicuri di essere sul branch `master`. Se non si è su quel branch, si usi correttamente il sottocomando `checkout` per tornarci
* Si utilizzi `git log --graph --all` per capire esattamente come sia strutturato il repository
* Si tenti di fare il merge del branch `feature` dentro il branch `master`, utilizzando in modo idoneo il sottocomando `merge`
* Si genera un conflitto di merge!
* Si utilizzi git status per capire quali file confliggono. Si noti come il suddetto comando espliciti che il problema è derivante dal fatto che `both modified`.
* Si apra il file che fa conflitto, e lo si modifichi perché stampi sia le informazioni circa l'autore che quelle riguardanti il numero di processori logici installati sulla macchina.
* Si verifichi che il file sia stato modificato correttamente compilandolo ed eseguendolo (usando `javac` e `java` da terminale)
* Si aggiunga la versione modificata e con il conflitto risolto del file al tracker, usando correttamente il sottocomando `add`
* Si usi `git status` per verificare lo stato della staging area
* Si utilizzi correttamente il comando `git commit` per unire i due branch definitivamente, creando il "merge commit"
* Si utilizzi `git log --graph --all` per verificare che i due branch siano stati uniti correttamente
* Si correttamente il sottocomando `branch` con l'opzione `-d` per eliminare il branch `feature`
* Si utilizzi `git push` per caricare sulla propria fork online del repository le modifiche fatte
* Si osservi online lo stato del repository
* Si elimini anche online il branch `feature`

> Se avete capito chiaramente come operare con un repository remoto e come risolvere i merge conflicts, siete pronti per usare Git su progetti veri! CONSIGLIO: Cominciate ad utilizzarlo a tappeto. Più lo utilizzerete, meglio lo imparerete, meglio lavorerete al progetto con i vostri colleghi!
