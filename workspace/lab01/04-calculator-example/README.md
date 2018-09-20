# Laboratorio 01

## Svolgimento dell'esercizio

1. Si implementi da zero la classe `Calculator` che realizza una semplice calcolatrice in grado di lavorare su numeri `double`, che possegga:
  * Campi: nessuno (in qualche modo questa classe è "degenere" in OOP)
  * Metodi:
    - `double add(double, double)`: addizione
    - `double sub(double, double)`: sottrazione
    - `double mul(double, double)`: moltiplicazione
    - `double div(double, double)`: divisione
2. Si testi il comportamento della classe seguendo le linee guida in `TestCalculator`
3. Si modifichi la classe `Calculator` aggiungendo:
  * Campi:
    - `int nOpDone` (conta il numero di operazioni compiute dalla calcolatrice)
    - `double lastRes` (memorizza l'ultimo risultato computato)
  * Metodi:
    - `void build()` (inizializza a zero i due campi)
  * Modifiche ai metodi esistenti
    - Si modifichino i metodi esistenti per far sì che utilizzino opportunamente i due nuovi campi della classe
4. Si verifichi il funzionamento della nuova calcolatrice modificando `TestCalculator` in modo che stampi il valore dei due nuovi campi dopo ogni operazione.
