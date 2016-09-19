== StrictBankAccountImpl ==
Analizzare la classe StrictBankAccount, lievemente modificata rispetto alla versione 
già vista.

== Modifiche a StrictBankAccount ==
Modificare la classe StrictBankAccount in modo che:
 - Venga lanciata una eccezione WrongAccountHolderException, tutte le volte che viene 
   tentata una operazione da un utente non autorizzato.
 - Venga lanciata una eccezione NotEnoughFoundsException, tutte le volte che non può 
   essere effettuato un prelievo (fondi insufficienti).
 - Venga lanciata una eccezione TransactionsOverQuotaException, tutte le volte che il 
   numero di operazioni fatte tramite ATM sia superiore a nMaxATMTransactions 
   (parametro passato al costruttore di StrictBankAccount).

== TEST ==
Completare il test JUnit TestStrictBankAccount, facendo riferimento ai commenti riportati
nel test stesso
