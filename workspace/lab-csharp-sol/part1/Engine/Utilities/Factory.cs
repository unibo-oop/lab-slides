using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Unibo.ISI.ProgramazioneAdOggetti.Esercitazioni
{
  /// <summary>
  /// Un semplice oggetto che contiene metodi per la creazione di ambiente ed organismi.
  /// </summary>
  public static class Factory
  {
    /// <summary>
    /// Crea un ambiente.
    /// </summary>
    /// <param name="width">Dimensione orizzontale del territorio.</param>
    /// <param name="height">Dimensione verticale del territorio.</param>
    /// <returns>Un riferimento a un oggetto che implementa l'interfaccia per 
    /// interagire con l'ambiente.</returns>
    public static IEnvironmentManager CreateEnvironmentManager(int width, int height)
    {
      return new SimpleEnvironmentManager(width, height);
    }

    /// <summary>
    /// Elenco di nomi di specie per le quali il metodo CreateOrganism 
    /// è in grado di creare organismi.
    /// </summary>
    public static IEnumerable<string> AvailableSpecies
    {
      get
      {
        return Enumerable.Empty<string>();
      }
    }

    /// <summary>
    /// Crea un organismo della specie richiesta.
    /// </summary>
    /// <param name="species">Il nome della specie richiesta: deve essere uno
    /// di quelli contenuti in AvailableSpecies.</param>
    /// <returns>Il nuovo organismo.</returns>
    public static IOrganism CreateOrganism(string species)
    {
      throw new NotImplementedException();
    }
  }
}
