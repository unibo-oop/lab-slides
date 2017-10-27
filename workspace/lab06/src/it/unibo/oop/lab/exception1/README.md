# Instructions

## BaseRobotTest
Read the class very carefully. It uses JUnit as a test suite 

== Test BaseRobotTest ==
- Analizzare ed eseguire il test JUnit BaseRobotTest

== Metodo move su RobotEnvironment ==
Modificare il metodo move della classe RobotEnvironment in modo che generi l’eccezione 
PositionOutOfBoundException (fornita) nel caso in cui si cerchi di spostarsi al di 
fuori dei limiti dell’ambiente.

Linee guida
- Cambiare il valore di ritorno in void
- Aggiungere la clausola throws PositionOutOfBoundException alla signature del metodo
- Gestire nel codice il lancio dell’eccezione per il caso di interesse


== Modifica a Robot ==
Modificare adeguatamente la classe it.unibo.oop.lab07.exercise01.Robot a seguito della 
modifica apportata a RobotEnvironment.

Linee guida
- Aggiungere la clausola throws PositionOutOfBoundException alla signature del metodo 
  moveToPosition: non sarà compito della classe Robot gestire l’eccezione 
  PositionOutOfBoundException, bensì dei suoi utilizzatori.
- Rifattorizzare adeguatamente il comportamento del metodo moveToPosition.
- In cascata, rifattorizzare anche i vari moveUp/moveDown che
  utilizzano moveToPosition.
- Aggiungere la clausola throws PositionOutOfBoundException alle signature dei vari 
  metodi.
  
== Test BaseRobotTest.testRobotMovementBase() ==
- Modificare il test testRobotMovementBase in BaseRobotTest, in modo da verificare la 
  corretta implementazione dell'eccezione PositionOutOfBoundException.

= SUGGERIMENTO =
Utilizzare l'assertion "assertTrue" per verificare che l'esecuzione del metodo entri o meno
all'iterno del blocco catch dell'eccezione.

  
== Eccezione NotEnoughBatteryException ==
Realizzare l'eccezione NotEnoughBatteryException, lanciata tutte le volte che viene
chiesto al robot di muoversi (in una qualunque direzione) in presenza di un livello di 
batteria non sufficiente.

Linee guida
- NotEnoughBatteryException dovrà estendere Exception
- Rifattorizzare adeguatamente il comportamento del metodo moveToPosition (valore di 
  ritorno void e aggiungere NotEnoughBatteryException alla clausola throws)
- Utilizzare il costrutto throw per lanciare una eccezione quando richiesto
- Rifattorizzare i metodi moveUp/moveDown

== Test BaseRobotTest.testRobotBatteryBase() ==
- Modificare il test testRobotBatteryBase() in BaseRobotTest, in modo da verificare la 
  corretta implementazione dell'eccezione NotEnoughBatteryException 
