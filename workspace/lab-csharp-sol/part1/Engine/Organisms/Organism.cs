using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace Unibo.ISI.ProgramazioneAdOggetti.Esercitazioni
{
  /* Esercitazione - Parte 3
   * 
   * Definire le seguenti classi:
   * a) Organism, classe astratta che implementa IOrganism, contenente come minimo:
   *      - un costruttore protetto che riceve due parametri int width ed height (le dimensioni dell'organismo);
   *      - le proprietà Width ed Height (richieste dall'interfaccia);
   *      - il metodo Initialize (richiesto dall'interfaccia) che semplicemente salva l'interfaccia passata in un campo protetto;
   *      - il metodo GetCurrentSprite (richiesto dall'interfaccia) come metodo astratto;
   *      - il metodo UpdateBehaviour (richiesto dall'interfaccia) come metodo astratto.
   * 
   * b) Vegetable, classe astratta derivata da Organism, contenente come minimo:
   *      - un costruttore protetto che riceve un parametro Bitmap (lo sprite che rappresenta graficamente tale organismo);
   *      - l'implementazione del metodo astratto GetCurrentSprite della classe base;
   *      - l'implementazione del metodo astratto UpdateBehaviour della classe base (che semplicemente non deve fare nulla, 
   *        ipotizzando che i vegetali rimangano sempre fermi).
   * 
   * c) Tree, classe astratta derivata da Vegetable, contenente come minimo:
   *      - un membro privato statico di tipo SpriteLoader, inizializzato costruendo un'istanza di SpriteLoader
   *        a partire dall'immagine situata in "..\..\..\Images\Trees.png" contenente sprite di dimensione 64x64
   *        disposti su una sola riga;
   *      - un costruttore protetto che riceva un parametro int "spriteIndex" e passi al costruttore della classe
   *        base lo sprite corrispondente con l'aiuto del membro statico di cui sopra.
   *        
   * d) FirTree, classe derivata da Tree che utilizza lo sprite di indice 0.
   * 
   * e) PalmTree, classe derivata da Tree che utilizza lo sprite di indice 1.
   *        
   * f) SmallPlant, classe astratta derivata da Vegetable, con funzionamento analogo a Tree, ma che utilizza l'immagine
   *      "..\..\..\Images\SmallPlants.png", contenente sprite di dimensione 32x32 disposti su una sola riga.
   * 
   * g) Shrub, classe derivata da SmallPlant che utilizza lo sprite di indice 6.
   * 
   * h) Animal, classe astratta derivata da Organism, contenente come minimo:
   *      - un membro privato statico di tipo SpriteLoader, inizializzato costruendo un'istanza di SpriteLoader
   *        a partire dall'immagine situata in "..\..\..\Images\Animals.png" contenente sprite di dimensione 32x48.
   *      - un costruttore protetto che riceve come parametri due int (firstSpriteRow e firstSpriteColumn) che
   *        indicano la posizione del primo sprite da considerare;
   *      - l'implementazione del metodo astratto GetCurrentSprite della classe base;
   *      - l'implementazione del metodo astratto UpdateBehaviour della classe base.
   *      
   *  i) Dog, Cat, Mouse, Sheep, Goat: classi derivata da Animal, con opportuni indici di sprite iniziale.
   *  
   */

}
