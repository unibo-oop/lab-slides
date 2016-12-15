using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Unibo.ISI.ProgramazioneAdOggetti.Esercitazioni
{
  /// <summary>
  /// Interfaccia che consente di gestire l'ambiente. Può essere utilizzata da
  /// una GUI per simulare il comportamento dell'ambiente.
  /// </summary>
  public interface IEnvironmentManager
  {
    /// <summary>
    /// Richiede l'aggiunta di un nuovo organismo all'ambiente.
    /// </summary>
    /// <param name="organism">L'organismo da aggiungere.</param>
    /// <param name="x">La coordinata X in cui dovrà essere posizionato.</param>
    /// <param name="y">La coordinata Y in cui dovrà essere posizionato.</param>
    /// <returns>true se è stato possibile aggiungere l'organismo, false altrimenti.</returns>
    bool AddOrganism(IOrganism organism, int x, int y);

    /// <summary>
    /// Disegna una rappresentazione grafica dell'ambiente.
    /// </summary>
    /// <param name="gr">La superficie su cui disegnare.</param>
    void Draw(Graphics gr);

    /// <summary>
    /// Chiede all'ambiente di passare all'istante di tempo successivo.
    /// </summary>
    void AdvanceTime();
  }
}
