# Complete the implementation of `ObjectClonerUtil`

Follow the comments in the class file.

## Assumptions
The class to be cloned provides:

* A 0-ary constructor
* A setter for every getter

## Completare ObjectCloneUtil
Passi da seguire:
1. Recuperare dalla classe dell'oggetto fornita in input il costruttore con zero argomenti;
2. Creare l'oggetto che dovrà essere il risultato dell'operazione di cloning invocando tale costruttore;
3. Clonare l'oggetto fornito in input via reflection appoggiandosi ai getter/setter, in particolare:
  * Usare il metodo setXXX per settare nell'oggetto da restituire il valore recuperato tramite il metodo getXXX;
  * Appoggiarsi al metodo getDeclaringClass della classe Method per verificare che un certo metodo appartenga alla classe di interesse e non di una eventuale super-classe;
  * Appoggiarsi al metodo getReturnType della classe Method per recuperare il valore di ritorno di un metodo.

## TEST
Complete the implementation of the JUnit test class `TestCloner`. **Suggestion**: do it before finishing the implementation of ObjectClonerUtil.
