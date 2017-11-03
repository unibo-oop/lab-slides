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

        // I nomi delle specie disponibili, abbinati a un delegate che ne crea l'istanza corrispondente
        private static Dictionary<string, Func<IOrganism>> availableSpeciesMap = InitializeAvailableSpeciesMap();

        // Metodo statico che inizializza il campo statico availableSpeciesMap
        private static Dictionary<string, Func<IOrganism>> InitializeAvailableSpeciesMap()
        {
            var dic = new Dictionary<string, Func<IOrganism>>();
            // chiave: nome specie, valore: un delegate che crea un'istanza dell'oggetto
            dic.Add("Fir", () => new FirTree());
            dic.Add("Palm", () => new PalmTree());
            dic.Add("Shrub", () => new Shrub());
            dic.Add("Dog", () => new Dog());
            dic.Add("Cat", () => new Cat());
            dic.Add("Mouse", () => new Mouse());
            dic.Add("Sheep", () => new Sheep());
            dic.Add("Goat", () => new Goat());
            return dic;
        }

        /// <summary>
        /// Elenco di nomi di specie per le quali il metodo CreateOrganism 
        /// è in grado di creare organismi.
        /// </summary>
        public static IEnumerable<string> AvailableSpecies
        {
            get
            {
                return availableSpeciesMap.Keys; // i nomi sono le chiavi contenute nel dictionary
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
            return availableSpeciesMap[species](); // esegue il delegate abbinato alla chiave species
        }
    }
}
