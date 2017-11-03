using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;

namespace Unibo.ISI.ProgramazioneAdOggetti.Esercitazioni
{
  /// <summary>
  /// Classe di utilità per estrarre sprite da un'immagine.
  /// Assume che tutti gli sprite dentro all'immagine abbiano la stessa dimensione.
  /// </summary>
  public class SpriteLoader
  {
    private Bitmap bmp;

    /// <summary>
    /// Costruttore che carica l'immagine da file.
    /// </summary>
    public SpriteLoader(string bitmapFileName, int spriteWidth, int spriteHeight)
      : this(new Bitmap(bitmapFileName), spriteWidth, spriteHeight)
    {
    }

    /// <summary>
    /// Costruttore che riceve direttamente l'immagine come oggetto Bitmap.
    /// </summary>
    public SpriteLoader(Bitmap image, int spriteWidth, int spriteHeight)
    {
      bmp = image;
      bmp.SetResolution(96, 96);
      SpriteWidth = spriteWidth;
      SpriteHeight = spriteHeight;
      if (bmp.Width % SpriteWidth != 0 || bmp.Height % SpriteHeight != 0)
      {
        throw new ArgumentException("Invalid bitmap or sprite size.");
      }
      Columns = bmp.Width / SpriteWidth;
      Rows = bmp.Height / SpriteHeight;
    }

    /// <summary>
    /// Larghezza di ogni sprite in pixel.
    /// </summary>
    public int SpriteWidth { get; private set; }

    /// <summary>
    /// Altezza di ogni sprite in pixel.
    /// </summary>
    public int SpriteHeight { get; private set; }

    /// <summary>
    /// Numero di sprite in orizzontale.
    /// </summary>
    public int Columns { get; private set; }

    /// <summary>
    /// Numero di sprite in verticale.
    /// </summary>
    public int Rows { get; private set; }

    /// <summary>
    /// Indexer che consente l'estrazione di uno sprite come nuova bitmap.
    /// </summary>
    /// <param name="y">Indice 0-based della riga dello sprite.</param>
    /// <param name="x">Indice 0-based della colonna dello sprite.</param>
    /// <returns>Una nuova istanza di Bitmap contenente lo sprite.</returns>
    public Bitmap this[int y, int x]
    {
      get
      {
        Bitmap newBmp = new Bitmap(SpriteWidth, SpriteHeight);
        using (Graphics g = Graphics.FromImage(newBmp))
        {
          g.DrawImage(bmp, 0, 0, new Rectangle(x * SpriteWidth, y * SpriteHeight, SpriteWidth, SpriteHeight), GraphicsUnit.Pixel);
        }
        return newBmp;
      }
    }

  }
}
