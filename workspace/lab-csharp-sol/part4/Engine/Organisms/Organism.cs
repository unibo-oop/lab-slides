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

  // a)
  abstract class Organism : IOrganism
  {
    protected IEnvironment environment;

    protected Organism(int width, int height)
    {
      Width = width;
      Height = height;
    }

    public void Initialize(IEnvironment environment)
    {
      // salva il riferimento all'interfaccia per usi futuri
      this.environment = environment;
    }

    public int Width { get; private set; }

    public int Height { get; private set; }

    public abstract Bitmap GetCurrentSprite(Direction direction);

    public abstract void UpdateBehaviour(ref Direction direction, ref int speed);
  }

  // b)
  abstract class Vegetable : Organism
  {
    private Bitmap sprite;

    protected Vegetable(Bitmap sprite)
      : base(sprite.Width, sprite.Height)
    {
      this.sprite = sprite;
    }

    public override Bitmap GetCurrentSprite(Direction direction)
    {
      // un unico sprite che non dipende dalla direzione
      return sprite;
    }

    public override void UpdateBehaviour(ref Direction direction, ref int speed)
    {
      // è un vegetale: sta fermo
    }
  }

  // c)
  abstract class Tree : Vegetable
  {
    private static SpriteLoader spriteLoader = new SpriteLoader(@"..\..\..\Images\Trees.png", 64, 64);

    protected Tree(int spriteIndex)
      : base(spriteLoader[0, spriteIndex])
    {
    }
  }

  // d)
  class FirTree : Tree
  {
    public FirTree()
      : base(0)
    {
    }
  }

  // e)
  class PalmTree : Tree
  {
    public PalmTree()
      : base(1)
    {
    }
  }

  // f)
  abstract class SmallPlant : Vegetable
  {
    private static SpriteLoader spriteLoader = new SpriteLoader(@"..\..\..\Images\SmallPlants.png", 32, 32);

    protected SmallPlant(int spriteIndex)
      : base(spriteLoader[0, spriteIndex])
    {
    }
  }

  // g)
  class Shrub : SmallPlant
  {
    public Shrub()
      : base(6)
    {
    }
  }

  // h)
  abstract class Animal : Organism
  {
    private static SpriteLoader spriteLoader = new SpriteLoader(@"..\..\..\Images\Animals.png", 32, 48);
    private const int Frames = 3;

    private Dictionary<Direction, Bitmap[]> sprites;
    private int timeToNextDirectionChange = -1; // -1 in modo che al primo UpdateBehaviour agisca subito
    private int lastSpeed; // qui si memorizza l'ultima velocità nota

    protected Animal(int firstSpriteRow, int firstSpriteColumn)
      : base(spriteLoader.SpriteWidth, spriteLoader.SpriteHeight)
    {
      // caricamento degli sprite nel dictionary
      sprites = new Dictionary<Direction, Bitmap[]>();
      for (int d = 0; d < 4; d++)
      {
        sprites.Add((Direction)d, Enumerable.Range(0, Frames).Select(i => spriteLoader[firstSpriteRow + d, firstSpriteColumn + i]).ToArray());
      }
    }

    public override Bitmap GetCurrentSprite(Direction direction)
    {
      // se è fermo, sempre frame 1 (punto 6 [facoltativo]), 
      // altrimenti uno dei 3 frame in base a environment.Time
      return sprites[direction][lastSpeed == 0 ? 1 : environment.Time % Frames];
    }

    public override void UpdateBehaviour(ref Direction direction, ref int speed)
    {
      if (timeToNextDirectionChange == -1 || environment.Time >= timeToNextDirectionChange)
      {
        // se è la prima volta (-1) oppure è il momento di cambiare, sceglie nuova direzione 
        // e velocità in modo random
        direction = (Direction)environment.Random(4);
        speed = 1 + environment.Random(5);
        // anche il prossimo momento di "cambiamento" è scelto in modo random
        timeToNextDirectionChange = environment.Time + 10 + environment.Random(20);
      }
      lastSpeed = speed; // la memorizza in moda da poterla utilizzare in GetCurrentSprite
    }
  }

  // i)
  class Dog : Animal
  {
    public Dog()
      : base(0, 3)
    {
    }
  }

  // i)
  class Cat : Animal
  {
    public Cat()
      : base(0, 6)
    {
    }
  }

  // i)
  class Sheep : Animal
  {
    public Sheep()
      : base(4, 3)
    {
    }
  }

  // i)
  class Goat : Animal
  {
    public Goat()
      : base(4, 0)
    {
    }
  }

  // i)
  class Mouse : Animal
  {
    public Mouse()
      : base(0, 9)
    {
    }
  }

}
