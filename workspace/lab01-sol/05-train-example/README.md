# Programmazione ad Oggetti - Laboratorio 01
## Esercizio 5 - train

#### FASE 1

1. Implementare una classe Java che modelli il concetto di treno, con le seguenti caratteristiche:
  * Campi:
    - `int nTotSeats` (Numero dei posti totali del treno)
    - `int nFirstClassSeats` (Numero dei posti in prima classe)
    - `int nSecondClassSeats` (Numero dei posti in seconda classe)
    - `int nFirstClassReservedSeats` (Numero dei posti in prima classe già prenotati)
    - `int nSecondClassReservedSeats` (NUmero dei posti in seconda classe già prenotati)
  * Metodi:
    - `void build(???)` (inizializzare opportunamente i campi. Si valuti quale sia un set di argomenti di input corretto e più piccolo possibile per il metodo suddetto)
    - `void reserveFirstClassSeats(int)` (consente di riservare dei posti in prima classe)
    - `void reserveSecondClassSeats(int)` (consente di riservare dei posti in seconda classe)
    - `double getTotOccupancyRatio()` (percentuale globale di posti occupati)
    - `double getFirstClassOccupancyRatio()` (percentuale posti occupati in prima classe)
    - `double getSecondClassOccupancyRatio()` (percentuale posti occupati in seconda classe)
    - `void deleteAllReservations()` (annulla tutte le prenotazioni)
    * *Nota*: Si gestisca correttamente la conversione da `int` a `double` all'atto del calcolo della percentuale di posti occupati. Si fa presente che le operazioni fra tipi primitivi in Java funzionano allo stesso modo delle operazioni fra `int` e `double` in C (compilato per processori a 64bit) - chiedere al docente o al tutor in caso di dubbi.
2. Si completi la classe `UseTrain` seguendo i commenti in essa contenuti
3. Si compili e si esegua
