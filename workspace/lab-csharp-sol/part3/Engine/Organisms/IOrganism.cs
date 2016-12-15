using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;

namespace Unibo.ISI.ProgramazioneAdOggetti.Esercitazioni
{
  /// <summary>
  /// Interfaccia che qualsiasi organismo vivente deve implementare.
  /// </summary>
  public interface IOrganism
  {
    /// <summary>
    /// Metodo chiamato una sola volta per ciascun organismo quando viene collocato nell'ambiente.
    /// </summary>
    /// <param name="environment">Interfaccia che l'organismo può utilizzare per interagire con l'ambiente.
    /// Di solito è opportuno che l'organismo ne mantanga un riferimento in un suo campo.</param>
    void Initialize(IEnvironment environment);

    /// <summary>
    /// Lunghezza orizzontale dell'organismo.
    /// </summary>
    int Width { get; }

    /// <summary>
    /// Lunghezza verticale dell'organismo.
    /// </summary>
    int Height { get; }

    /// <summary>
    /// Metodo chiamato ogni qual volta è richiesta un'immagine che rappresenta l'attuale situazione del organismo.
    /// </summary>
    /// <param name="direction">L'attuale orientazione del organismo.</param>
    /// <returns>Una immagine che rappresenta l'attuale situazione del organismo, eventualmente generata
    /// sulla base del parametro direction e/o dell'istante di tempo attuale dell'ambiente.</returns>
    Bitmap GetCurrentSprite(Direction direction);

    /// <summary>
    /// Metodo chiamato per dare la possibilità all'organismo di modificare il proprio comportamento,
    /// in termini di direzione e velocità di movimento.
    /// </summary>
    /// <param name="direction">La direzione attuale, che può essere eventualmente modificata.</param>
    /// <param name="speed">La velocità attuale, che può essere eventualmente modificata.</param>
    void UpdateBehaviour(ref Direction direction, ref int speed);
  }
}
