using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;

namespace Unibo.ISI.ProgramazioneAdOggetti.Esercitazioni
{
  /// <summary>
  /// Interfaccia che viene fornita agli organismi e consente:
  /// - Di avere informazioni sull'ambiente (es. dimensioni del territorio, istante di tempo attuale)
  /// - Di eseguire alcuni funzionalità di base (es. generazione numeri casuali)
  /// </summary>
  public interface IEnvironment
  {
    /// <summary>
    /// L'istante attuale di tempo: numero progressivo che indica il passare del tempo.
    /// </summary>
    int Time { get; }

    /// <summary>
    /// Larghezza del territorio.
    /// </summary>
    int Width { get; }

    /// <summary>
    /// Altezza del territorio.
    /// </summary>
    int Height { get; }

    /// <summary>
    /// Genera un numero pseudo-casuale intero.
    /// </summary>
    /// <param name="maxValue">Limite superiore del numero da generare.</param>
    /// <returns>Un numero pseudo-causale fra 0 (incluso) e maxValue (escluso).</returns>
    int Random(int maxValue);

    /// <summary>
    /// Genera un numero pseudo-casuale fra 0.0 e 1.0.
    /// </summary>
    /// <returns>Un numero pseudo-casuale compreso fra 0.0 (incluso) e 1.0 (escluso)</returns>
    double Random();
  }

  /// <summary>
  /// Rappresenta l'orientazione di un organismo nel territorio.
  /// </summary>
  public enum Direction
  {
    /// <summary>
    /// Verso il basso
    /// </summary>
    South = 0,

    /// <summary>
    /// Verso sinistra
    /// </summary>
    West = 1,

    /// <summary>
    /// Verso destra
    /// </summary>
    East = 2,

    /// <summary>
    /// Verso l'alto
    /// </summary>
    North = 3,
  }

}
