using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Unibo.ISI.ProgramazioneAdOggetti.Esercitazioni
{
  /// <summary>
  /// Un'implementazione di base IEnvironmentManager che implementa alcune logiche generali
  /// e funzionalità di base, lasciando alcuni dettagli alle classi derivate (Pattern Template Method).
  /// </summary>
  abstract class BaseEnvironmentManager : IEnvironmentManager
  {
    private Random rnd = new Random();

    /// <summary>
    /// Classe utilizzata internamente dal EnvironmentManager e da sue eventuali classi derivate.
    /// Contiene informazioni su un organismo e il suo stato attuale.
    /// </summary>
    protected class OrganismInfo
    {
      /// <summary>
      /// L'organismo vivente.
      /// </summary>
      public IOrganism Organism { get; set; }

      /// <summary>
      /// Coordinata X dell'organismo.
      /// </summary>
      public int X { get; set; }

      /// <summary>
      /// Coordinata Y dell'organismo.
      /// </summary>
      public int Y { get; set; }

      /// <summary>
      /// Orientazione del organismo.
      /// </summary>
      public Direction Direction { get; set; }

      /// <summary>
      /// Velocità di movimento del organismo: 0 se non sta cercando di muoversi.
      /// </summary>
      public int Speed { get; set; }

      /// <summary>
      /// Attuale regione rettangolare occupata dall'organismo, calcolata 
      /// in base alle sue coordinate x/Y e dimensioni Width/Height;
      /// </summary>
      public Rectangle BoundingBox
      {
        get
        {
          return new Rectangle(X - Organism.Width / 2, Y - Organism.Height / 2, Organism.Width, Organism.Height);
        }
      }
    }

    /// <summary>
    /// Il territorio dell'ambiente (dimensioni in pixel).
    /// </summary>
    protected Rectangle envRect;

    /// <summary>
    /// Tutti gli organismi attualmente presenti nell'ambiente.
    /// </summary>
    protected List<OrganismInfo> organisms = new List<OrganismInfo>();

    /// <summary>
    /// Predispone l'aggiunta di un nuovo organismo, creando una corrispondente istanza
    /// di OrganismInfo. Se non è possibile creare il nuovo organismo nella posizione richiesta,
    /// restituisce null. Questo metodo va implementato nelle classi derivate.
    /// </summary>
    protected abstract OrganismInfo TryAddOrganism(IOrganism organism, int x, int y);

    /// <summary>
    /// Disegna lo sfondo del territorio. 
    /// Questo metodo va implementato nelle classi derivate.
    /// </summary>
    protected abstract void DrawBackground(Graphics gr);

    public BaseEnvironmentManager(int width, int height)
    {
      envRect = new Rectangle(0, 0, width, height);
    }

    public bool AddOrganism(IOrganism organism, int x, int y)
    {
      // Pattern Template Method: qui è implementata la logica generale
      // di aggiunta di un organismo, lasciando alcune scelte al metodo
      // astratto TryAddOrganism che dovrà essere implementato in una 
      // classe derivata.
      OrganismInfo oi = TryAddOrganism(organism, x, y); 
      if (oi == null)
      { // Non è possiile aggiungerlo
        return false;
      }
      // È possibile aggiungerlo
      organisms.Add(oi);

      /* Esercitazione - Parte 2)
       * Dopo aver aggiunto l'organismo, è necessario chiamare
       * il suo metodo Initialize. Questo è il punto giusto per farlo.
       */

      return true;
    }

    public void Draw(Graphics gr)
    {
      // Pattern Template Method: qui è implementata la logica generale
      // di disegno, lasciando il disegno dello sfondo al metodo
      // astratto DrawBackground che dovrà essere implementato in una 
      // classe derivata.      
      DrawBackground(gr);
      foreach (var c in organisms)
      {
        var sprite = c.Organism.GetCurrentSprite(c.Direction);
        gr.DrawImage(sprite, c.X - sprite.Width / 2, c.Y - sprite.Height / 2);
      }
    }

    public virtual void AdvanceTime()
    {
      /* Esercitazione - Parte 2)
       * Qui dovrà essere gestito il passare del tempo, come suggerito 
       * nel testo dell'esercitazione.
       */
      throw new NotImplementedException();
    }
  }
}
