# Terminare l'implementazione del metodo classe ObjectClonerUtil seguendo le linee guida riportate nei commenti:

Il metodo dovrà restituire una versione clonata di un oggetto (con opportune caratteristiche, vedere sotto) fornito in input

## Assunzioni
La classe dell'oggetto da clonare ha:
* Un costruttore con zero argomenti
* Un insieme completo di getter/setter
  
Questi elementi serviranno per eseguire il cloning via reflection

## Completare ObjectCloneUtil
Passi da seguire:
1. Recuperare dalla classe dell'oggetto fornita in input il costruttore con zero argomenti;
2. Creare l'oggetto che dovrà essere il risultato dell'operazione di cloning invocando tale costruttore;
3. Clonare l'oggetto fornito in input via reflection appoggiandosi ai getter/setter, in particolare:
  * Usare il metodo setXXX per settare nell'oggetto da restituire il valore recuperato tramite il metodo getXXX;
  * Appoggiarsi al metodo getDeclaringClass della classe Method per verificare che un certo metodo appartenga alla classe di interesse e non di una eventuale super-classe;
  * Appoggiarsi al metodo getReturnType della classe Method per recuperare il valore di ritorno di un metodo.

## TEST
Completare l'implementazione della classe di test JUnit, TestingCloner, per effettuare il test della classe ObjectClonerUtil.
