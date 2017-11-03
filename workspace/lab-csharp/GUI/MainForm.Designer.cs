namespace Unibo.ISI.ProgramazioneAdOggetti.Esercitazioni
{
  partial class MainForm
  {
    /// <summary>
    /// Required designer variable.
    /// </summary>
    private System.ComponentModel.IContainer components = null;

    /// <summary>
    /// Clean up any resources being used.
    /// </summary>
    /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
    protected override void Dispose(bool disposing)
    {
      if (disposing && (components != null))
      {
        components.Dispose();
      }
      base.Dispose(disposing);
    }

    #region Windows Form Designer generated code

    /// <summary>
    /// Required method for Designer support - do not modify
    /// the contents of this method with the code editor.
    /// </summary>
    private void InitializeComponent()
    {
      this.components = new System.ComponentModel.Container();
      this.environmentTimer = new System.Windows.Forms.Timer(this.components);
      this.comboBoxSpecies = new System.Windows.Forms.ComboBox();
      this.environmentViewer = new Unibo.ISI.ProgramazioneAdOggetti.Esercitazioni.NoBackgroundPaintPanel();
      this.SuspendLayout();
      // 
      // environmentTimer
      // 
      this.environmentTimer.Enabled = true;
      this.environmentTimer.Interval = 150;
      this.environmentTimer.Tick += new System.EventHandler(this.environmentTimer_Tick);
      // 
      // comboBoxSpecies
      // 
      this.comboBoxSpecies.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
      this.comboBoxSpecies.Enabled = false;
      this.comboBoxSpecies.FormattingEnabled = true;
      this.comboBoxSpecies.Location = new System.Drawing.Point(530, 12);
      this.comboBoxSpecies.Name = "comboBoxSpecies";
      this.comboBoxSpecies.Size = new System.Drawing.Size(127, 21);
      this.comboBoxSpecies.TabIndex = 1;
      // 
      // environmentViewer
      // 
      this.environmentViewer.Location = new System.Drawing.Point(12, 12);
      this.environmentViewer.Name = "environmentViewer";
      this.environmentViewer.Size = new System.Drawing.Size(512, 384);
      this.environmentViewer.TabIndex = 0;
      this.environmentViewer.Paint += new System.Windows.Forms.PaintEventHandler(this.environmentViewer_Paint);
      this.environmentViewer.MouseClick += new System.Windows.Forms.MouseEventHandler(this.environmentViewer_MouseClick);
      // 
      // MainForm
      // 
      this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
      this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
      this.ClientSize = new System.Drawing.Size(668, 411);
      this.Controls.Add(this.comboBoxSpecies);
      this.Controls.Add(this.environmentViewer);
      this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
      this.MaximizeBox = false;
      this.Name = "MainForm";
      this.Text = "ISI - Programmazione ad oggetti - Esercitazione C#";
      this.ResumeLayout(false);

    }

    #endregion

    private System.Windows.Forms.Timer environmentTimer;
    private NoBackgroundPaintPanel environmentViewer;
    private System.Windows.Forms.ComboBox comboBoxSpecies;
  }
}