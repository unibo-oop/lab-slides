class ComplexNum {

   //...Inserire qui la dichiarazione dei campi della classe
  
  void build (double re, double im){
     // ...Inserire qui l'inizializzazione dei campi con i parametri forniti in input 
  }
  
  boolean equal (ComplexNum num){
    /*
     * Implementare il metodo in modo che restituisca true se e solo se il numero complesso è
     * uguale al parametro num passato in input
     */
    return false;
  }
  
  void add(ComplexNum num){
    /*
     * Implementare il metodo in modo che venga aggiunto il numero complesso passato in input
     */
  }
  
  String toStringRep(){
    /*
     * Implementare il metodo in modo che restituisca una rappresentazione testuale del numero complesso
     */
    return "";
  }
  
  public static void main(String args[]){
    /*
     * Testare la classe come segue:
     * 
     * 1) Creare il numero complesso 3+5i e memorizzarlo nella variabile c1
     * 2) Creare il numero complesso 7-4i e memorizzarlo nella variabile c2
     * 3) Creare il numero complesso -2+3i e memorizzarlo nella variabile c3
     * 4) Creare il numero complesso -2+3i e memorizzarlo nella variabile c4
     * 5) Stampare in standard output la rappresentazione testuale di c1,c2,c3,c4
     *    restituita dal metodo toStringRep()
     * 6) Sommare a c1 c2
     * 7) Sommare a c2 c4
     * 8) Stampare nuovamente in standard output la rappresentazione testuale di c1,c2,c3,c4
     * 9) Controllare se l'output corrisponde a quanto preventivato
     * 10) Invocare il metodo equal su c3 per tre volte, passando come input c1,c2,c4. Stampare il risultato
     *     di ciascuna invocazione in standard output
     * 11) Controllare se l'output corrisponde a quanto preventivato
     */
  }
}
