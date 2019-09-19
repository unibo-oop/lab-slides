# Programmazione ad Oggetti - Laboratorio 01
## Esercizio 7 - recognizer

#### FASE 1

1. Completare e testare una classe Java che sia in grado di riconoscere la sequenza 1234 ripetuta (potenzialmente all'infinito), seguendo quanto indicato nei commenti di `TestRecognizer`.

#### Indicazioni per la soluzione

* Implementare un metodo diverso per gestire il riconoscimento di ciascun numero (`check1(int)`, `check2(int)`, `check3(int)`, ...)
  * esempio sequenza valida `1234`
```
check1(1) -> restituisce true
check2(2) -> restituisce true
check3(3) -> restituisce true
check4(4) -> restituisce true
```
  * esempio sequenza valida `123412`
```
check1(1) -> restituisce true
check2(2) -> restituisce true
check3(3) -> restituisce true
check4(4) -> restituisce true
check1(1) -> restituisce true
check2(2) -> restituisce true
```
  * esempio sequenza NON valida `12345`
```
check1(1) -> restituisce true
check2(2) -> restituisce true
check3(3) -> restituisce true
check4(4) -> restituisce true
check1(5) -> restituisce false
```
  * esempio sequenza NON valida `123452`
```
check1(1) -> restituisce true
check2(2) -> restituisce true
check3(3) -> restituisce true
check4(4) -> restituisce true
check1(5) -> restituisce false
check2(2) -> restituisce false
```
* Tenere traccia all'interno della classe delle informazioni di stato relative al prossimo carattere da riconoscere
* Implementare il metodo `nextExpectedInt` che restituisce il prossimo intero atteso nella sequenza
* Implementare il metodo `reset` che consente di resettare lo stato corrente del riconoscitore
