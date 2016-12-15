using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Unibo.ISI.ProgramazioneAdOggetti.Esercitazioni
{
  public partial class MainForm : Form
  {
    IEnvironmentManager  environmentManager;

    public MainForm()
    {
      InitializeComponent();
      environmentManager = Factory.CreateEnvironmentManager(environmentViewer.Width, environmentViewer.Height);
      comboBoxSpecies.Items.AddRange(Factory.AvailableSpecies.ToArray());
      if (comboBoxSpecies.Items.Count > 0)
      {
        comboBoxSpecies.Enabled = true;
        comboBoxSpecies.SelectedIndex = 0;
      }
    }

    private Bitmap environmentBmp;

    private void environmentViewer_Paint(object sender, PaintEventArgs e)
    {
      if (environmentBmp != null)
      {
        e.Graphics.DrawImage(environmentBmp, 0, 0);
      }
      else
      {
        e.Graphics.FillRectangle(SystemBrushes.Control, environmentViewer.ClientRectangle);
      }
    }

    private void environmentTimer_Tick(object sender, EventArgs e)
    {
      environmentManager.AdvanceTime();
      if (environmentBmp == null || environmentBmp.Width != environmentViewer.Width || environmentBmp.Height != environmentViewer.Height)
      {
        environmentBmp = new Bitmap(environmentViewer.Width, environmentViewer.Height);
      }
      using (var gr = Graphics.FromImage(environmentBmp))
      {
        environmentManager.Draw(gr);
      }
      environmentViewer.Invalidate();
    }

    private void environmentViewer_MouseClick(object sender, MouseEventArgs e)
    {
      var species = (string)comboBoxSpecies.SelectedItem;
      if (species==null || !environmentManager.AddOrganism(Factory.CreateOrganism(species), e.X, e.Y))
      {
        MessageBox.Show("Cannot add a new organism.", "Information", MessageBoxButtons.OK, MessageBoxIcon.Information);
      }
    }

  }



  class NoBackgroundPaintPanel : Panel
  {
    protected override void OnPaintBackground(PaintEventArgs e)
    {
      if (DesignMode)
      {
        base.OnPaintBackground(e);
      }
    }
  }
}
