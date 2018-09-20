# Laboratorio 01

## Svolgimento dell'esercizio

1. Completare e testare una classe Java che sia in grado di riconoscere la sequenza 1234 ripetuta (potenzialmente all'infinito), seguendo quanto indicato nei commenti di `TestRecognizer`.

### Traccia per la soluzione

* Implementare un metodo diverso per gestire il riconoscimento di ciascun numero (`check1`, `check2`, `check3`...)
* Tenere traccia all'interno della classe delle informazioni di stato relative al prossimo carattere da riconoscere
* Implementare il metodo `nextExpectedInt` che restituisce il prossimo intero atteso nella sequenza
* Implementare il metodo `reset` che consente di resettare lo stato corrente del riconoscitore
