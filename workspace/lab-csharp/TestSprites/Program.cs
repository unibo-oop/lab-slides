using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Drawing;

namespace Unibo.ISI.ProgramazioneAdOggetti.Esercitazioni
{
  class Program
  {
    static void Main(string[] args)
    {
            /* Esercitazione - Parte 1)
             * 
             * Modificare questa console application come segue:
             * 
             * a) Creare un'istanza della classe SpriteLoader usando l'immagine che si trova (come path relativo) 
             *    nel file @"..\..\..\Images\Animals.png". Tale immagine contiene sprite di dimensione 32x48 pixel.
             *    
             * b) Salvare lo sprite che si trova nella quinta riga e terza colonna nel file "goat.bmp".
             *    Suggerimento: cercare un metodo che consenta il salvataggio fra i membri della classe Bitmap.
             *    Eseguire l'applicazione e verificare nella cartella dell'eseguibile che il file sia effettivamente 
             *    salvato e con il giusto contenuto.
             *    NOTA: Sulla classe SpriteLoader è stato definito un Indexer multidimensionale su oggetti di tipo Bitmap,
             *    sui quali è possibile richiamare il metodo Save(string name).
             *
             * c) Salvare tutti gli sprite in file con nome "Sprite_<i>_<j>.bmp" dove i e j sono gli indici di riga
             *    e colonna, rispettivamente. C\onsiglio: usare string.Format(...) per formattare i nomi dei file,
             *    cercare su msdn o altrove esempi del suo utilizzo che è analogo al Console.WriteLine visto nei lucidi.
             */

            SpriteLoader sl = new SpriteLoader(@"..\..\..\Images\Animals.png", 32, 48);

            sl[4, 2].Save(@"..\..\..\Images\goat.bmp");

            for (int i = 0; i < sl.Rows; i++)
            {
                for (int j = 0; j < sl.Columns; j++)
                {
                    sl[i, j].Save(string.Format("Sprite_{0}_{1}.bmp", i, j));
                    //sl[i, j].Save(@"..\..\..\Images\Sprite_" + i + "_" + j + ".bmp");
                }
            }
                
                    
        }
    }
}
