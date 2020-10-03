# Programmazione ad Oggetti - Laboratorio 02

## Esercizio 6 - constructors

#### FASE 1 - Costruttori

1. Si osservi e poi si rimuova dalle classi `Train` e `Student` il metodo `void main(String[])` ed il metodo `void build(...)`
    - Si noti come tra l'istanziazione di uno `Student` e la sua "costruzione" mediante `build` l'oggetto si trovi in uno stato semanticamente inconsistente
2. Si implementi un costruttore a zero argomenti per `Train`
    - I campi dovranno essere inizializzati con valori di default *sensati* a vostra scelta
3. Si implementi un costruttore con un set minimale di parametri atto ad inizializzare un'istanza della classe
4. Si implementi in autonomia il costruttore della classe `Student`
5. Si seguano le istruzioni riportate in `UseConstructors`
6. Facendo riferimento a quanto discusso a lezione circa la possibilità di richiamare costruttori esistenti nel corpo di un altro costruttore tramite istruzione `this`, si modifichi il costruttore a zero argomenti di Train in modo che riusi quello che accetta parametri per l'inizializzazione.
7. Si crei (se non già realizzato) un costruttore `Train(int, int)` dove gli argomenti passati siano i posti in prima e seconda classe, rispettivamente.
8. Si seguano le istruzioni in `UseConstructorsEvolved` per effettuare il test.

#### FASE 2 - Esercizio più avanzato

1. Si completi la classe `oop.lab02.constructors.Smartphone` con i campi:
    - `int nCPU, ram, sdSize`
    - `String brand, model`
    - `boolean hasGPS, hasNFC, has3G`
2. Si implementino nella classe suddetta i seguenti costruttori:
    - `Smartphone(String brand, String model)`
    - `Smartphone(String brand, String model, int sdSize, boolean hasGPS, boolean has3g)`
    - `Smartphone(String brand, String model, int sdSize)`
    - `Smartphone(String brand, String model, boolean hasNFC)`
    - Costruttore con un argomento per campo (NB: ci si assicuri di usare `this` per richiamare i costruttori esistenti)
3. Si utilizzino i commenti riportati nel `main` della classe per scrivere un test ed eseguirlo.
