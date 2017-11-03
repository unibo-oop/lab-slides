using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Unibo.ISI.ProgramazioneAdOggetti.Esercitazioni
{
  class EnvironmentManager : BaseEnvironmentManager
  {
    private Bitmap backgroundBmp;

    public EnvironmentManager(int width, int height)
      : base(width, height)
    {
      // Crea la bitmap di background
        backgroundBmp = new Bitmap(width, height);

            var gr = Graphics.FromImage(backgroundBmp); // gr permette di "disegnare" su backgroundBmp
      
        var tiles = new SpriteLoader(@"..\..\..\Images\Background.png", 32, 32);
        var separators = new char[] { ',', '\n', '\r' };
        var text = File.ReadAllText(@"..\..\..\Data\Background.txt"); // legge tutto il contenuto del file come un'unica stringa
                                                                    // separa in sottostringhe rimuovendo tutti i separatori, poi usa LINQ per trasformare in un array di int
        var values = text.Split(separators, StringSplitOptions.RemoveEmptyEntries).Select(x => int.Parse(x)).ToArray();
        // ora values contiene tutti i valori nel file letti da sinistra a destra e dall'alto in basso
        int k = 0; // scorre l'immagine nello stesso orgine incrementando questo indice k
        for (int y = 0; y < height; y += tiles.SpriteHeight)
        {
            for (int x = 0; x < width; x += tiles.SpriteWidth)
            {
                gr.DrawImage(tiles[0, values[k++]], x, y); // applica lo sprite giusto nella posizione giusta
            }
        }
      
    }

    protected override OrganismInfo TryAddOrganism(IOrganism organism, int x, int y)
    {
      /*
       * Esercitazione - Parte 4
       * Traccia per implementare questo metodo:
       * - Creare un'istanza di OrganismInfo impostandone opportunamente le proprietà (X,Y in base ai parametri x,y, 
       *   Direction in maniera random).
       * - Controllare se il BoundingBox dell'organismo è contenuto in envRect (con un metodo apposito 
       *   della struct Rectangle) e se è libero (con IsRegionEmpty definito in questa classe):
       *   in caso affermativo ritornare il riferimento al OrganismInfo creato, altrimenti tornare null.
       */
      throw new NotImplementedException();
    }

    /// <summary>
    /// Restituisce true se il rettangolo region non interseca
    /// alcun bounding box degli organismi, eccetto l'organismo excluded.
    /// </summary>
    private bool IsRegionEmpty(Rectangle region, OrganismInfo excluded)
    {
      return !organisms.Where(x => x != excluded).Any(x => x.BoundingBox.IntersectsWith(region));
    }

    protected override void DrawBackground(Graphics gr)
    {
      gr.DrawImage(backgroundBmp, 0, 0);
    }

    public override void AdvanceTime()
    {
      base.AdvanceTime();
      foreach (var o in organisms)
      {
        Direction dir = o.Direction;
        int speed = o.Speed;
        o.Organism.UpdateBehaviour(ref dir, ref speed);
        o.Direction = dir;
        o.Speed = speed;
        TryMove(o);
      }
    }

    /// <summary>
    /// Se l'organismo o si può muovere nella direzione e con la velocità desiderata,
    /// aggiorna la posizione di "o" e ritorna true, altrimenti ritorna false.
    /// </summary>
    private bool TryMove(OrganismInfo o)
    {
      /*
       * Esercitazione - Parte 4
       * Traccia per implementare questo metodo: la variabile locale rect
       * può essere spostata di un offset (dx,dy) calcolato in base a o.Direction e a o.Speed.
       * Ad esempio, se o.Direction è Direction.North e o.Speed è 3, allora dx = 0 e dy = -3.
       * Dopo aver calcolato dx e dy, trovare fra i metodi della struct Rectangle qual è il 
       * più idoneo a spostare il rettango appunto di dx e dy.
       * A questo punto il movimento è valido se rect:
       *   1) è contenuto dentro a envRect (trovare un apposito metodo per verificarlo...) e
       *   2) nessun altro organismo eccetto "o" occupa la regione rect (usare il metodo 
       *      IsRegionEmpty di questa classe...).
       * Se il movimento è valido, aggiornare o.X e o.Y e tornare true, altrimenti false.
       */
      Rectangle rect = o.BoundingBox;
      throw new NotImplementedException();
    }
  }
}
