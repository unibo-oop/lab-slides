using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Unibo.ISI.ProgramazioneAdOggetti.Esercitazioni
{
  [TestClass]
  public class EnvironmentTests
  {
    // Crea l'istanza da testare
    const int TestWidth = 300;
    const int TestHeight = 200;
    private IEnvironmentManager envMan = Factory.CreateEnvironmentManager(TestWidth, TestHeight);

    [TestMethod]
    public void TestFactory()
    {
      Assert.IsNotNull(envMan, "Environment manager non creato.");
    }

    [TestMethod]
    public void TestIEnvironment1()
    {
      // Esercitazione Parte 2: si chiede che envMan implementi anche IEnvironment
      Assert.IsInstanceOfType(envMan, typeof(IEnvironment), "L'environment manager non implementa IEnvironment.");

      // Esercitazione Parte 2: test su IEnvironment (Width/Height/Time)
      IEnvironment e = (IEnvironment)envMan;
      Assert.AreEqual(TestWidth, e.Width, "Larghezza non corretta.");
      Assert.AreEqual(TestHeight, e.Height, "Altezza non corretta.");
      Assert.AreEqual(0, e.Time, "L'istante di tempo iniziale non è zero.");
      for (int i = 1; i < 100; i++)
      {
        envMan.AdvanceTime();
        Assert.AreEqual(i, e.Time, "Tempo dopo {0} avanzamenti: {1}.", i, e.Time);
      }
    }

    [TestMethod]
    public void TestIEnvironment2()
    {
      // Esercitazione Parte 2: test su IEnvironment (Random)
      IEnvironment e = (IEnvironment)envMan;
      for (int i = 0; i < 100; i++)
      {
        var r = e.Random(5);
        Assert.IsTrue(r >= 0 && r < 5, "Numero casuale fuori intervallo.");
        var rd = e.Random();
        Assert.IsTrue(rd >= 0.0 && rd < 1.0, "Numero casuale fuori intervallo.");
      }
    }
  }
}
