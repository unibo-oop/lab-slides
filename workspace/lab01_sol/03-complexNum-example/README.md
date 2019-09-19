# Programmazione ad Oggetti - Laboratorio 01
## Esercizio 3 - complexnum

#### FASE 1

1. Si completi la classe `ComplexNum` aggiungendo:
  * Campi:
    - `double re` (parte reale)
    - `double im` (parte immaginaria)
  * Metodi:
    - `void build(double, double)` (inizializza l'oggetto di tipo `ComplexNum` con i parametri forniti in input. Essi sono, in ordine, la parte reale e quella immaginaria
    - `boolean equal(ComplexNum)` (restituisce `true` se il numero complesso passato in ingresso è uguale a quello su cui viene invocato il metodo, ossia `this`)
    - `void add(ComplexNum)` (aggiunge al `ComplexNum` su cui viene invocato il metodo, ossia `this`, il `ComplexNum` passato come parametro)
    - `String toStringRep()` (restituisce una rappresentazione testuale del numero, ad esempio: `"5.0"`, `"5.2+2.223i"`, `"3.0i"`, `"0.0"`, `"-4.0i"`, `"-4.0-i"`)
2. Si seguano le istruzioni nei commenti di `TestComplexNum` per implementare una classe di test
3. Si compili e si esegua per verificare il funzionamento
