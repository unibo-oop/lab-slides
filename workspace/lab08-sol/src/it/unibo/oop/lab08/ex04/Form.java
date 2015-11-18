package it.unibo.oop.lab08.ex04;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 * @author Andrea Santi
 * @author Mirko Viroli
 * @author Danilo Pianini
 *
 */
public class Form extends JDialog {

	private static final long serialVersionUID = 5554149602964526471L;
	private static final byte SSCODE_LENGTH = 15;
	private static final int LONGEST_HUMAN_LIFE = 150;
	private static final int EXPECTED_USER_AGE = 20;

	private final JPanel contentPanel = new JPanel();
	private final JButton okButton = new JButton("OK");
	private final JTextField textFieldName;
	private final JTextField textFieldSurname;
	private final JTextField textFieldCode;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JRadioButton rdbtnMale = new JRadioButton("Maschile");
	private final JRadioButton rdbtnFemale = new JRadioButton("Femminile");

	private final JSpinner spinner;
	private boolean okState;

	/**
	 * Create the dialog.
	 * 
	 * @param v
	 *            the parent view this form refers to
	 */
	public Form(final Frame v) {
		super(v);
		setLocationByPlatform(true);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		final JPanel data = new JPanel();
		contentPanel.add(data);
		final GridBagLayout gblData = new GridBagLayout();
		gblData.columnWidths = new int[] { 0, 0, 10 };
		gblData.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 10 };
		gblData.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gblData.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		data.setLayout(gblData);

		final JLabel lblCodiceFiscale = new JLabel("Codice Fiscale");
		final GridBagConstraints gbcLblCodiceFiscale = new GridBagConstraints();
		gbcLblCodiceFiscale.anchor = GridBagConstraints.EAST;
		gbcLblCodiceFiscale.gridx = 0;
		gbcLblCodiceFiscale.gridy = 0;
		data.add(lblCodiceFiscale, gbcLblCodiceFiscale);

		textFieldCode = new JTextField();
		final GridBagConstraints gbcTextFieldCF = new GridBagConstraints();
		gbcTextFieldCF.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldCF.gridx = 1;
		gbcTextFieldCF.gridy = 0;
		data.add(textFieldCode, gbcTextFieldCF);
		textFieldCode.setColumns(10);

		final JLabel lblNome = new JLabel("Nome");
		final GridBagConstraints gbcLblNome = new GridBagConstraints();
		gbcLblNome.anchor = GridBagConstraints.EAST;
		gbcLblNome.gridx = 0;
		gbcLblNome.gridy = 1;
		data.add(lblNome, gbcLblNome);

		textFieldName = new JTextField();
		final GridBagConstraints gbcTextFieldNome = new GridBagConstraints();
		gbcTextFieldNome.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldNome.gridx = 1;
		gbcTextFieldNome.gridy = 1;
		data.add(textFieldName, gbcTextFieldNome);
		textFieldName.setColumns(SSCODE_LENGTH);

		final JLabel lblCognome = new JLabel("Cognome");
		final GridBagConstraints gbcLblCognome = new GridBagConstraints();
		gbcLblCognome.anchor = GridBagConstraints.EAST;
		gbcLblCognome.gridx = 0;
		gbcLblCognome.gridy = 2;
		data.add(lblCognome, gbcLblCognome);

		textFieldSurname = new JTextField();
		final GridBagConstraints gbcTextFieldCognome = new GridBagConstraints();
		gbcTextFieldCognome.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldCognome.gridx = 1;
		gbcTextFieldCognome.gridy = 2;
		data.add(textFieldSurname, gbcTextFieldCognome);
		textFieldSurname.setColumns(10);

		final JLabel lblAnnoDiNsacita = new JLabel("Anno di nascita");
		final GridBagConstraints gbcLblAnnoDiNsacita = new GridBagConstraints();
		gbcLblAnnoDiNsacita.anchor = GridBagConstraints.EAST;
		gbcLblAnnoDiNsacita.gridx = 0;
		gbcLblAnnoDiNsacita.gridy = 3;
		data.add(lblAnnoDiNsacita, gbcLblAnnoDiNsacita);

		spinner = new JSpinner();
		final int today = LocalDate.now().getYear();
		spinner.setModel(new SpinnerNumberModel(today - EXPECTED_USER_AGE, today - LONGEST_HUMAN_LIFE, today, 1));
		final GridBagConstraints gbcSpinner = new GridBagConstraints();
		gbcSpinner.anchor = GridBagConstraints.WEST;
		gbcSpinner.gridx = 1;
		gbcSpinner.gridy = 3;
		data.add(spinner, gbcSpinner);

		final JLabel lblSesso = new JLabel("Sesso");
		final GridBagConstraints gbcLblSesso = new GridBagConstraints();
		gbcLblSesso.anchor = GridBagConstraints.EAST;
		gbcLblSesso.gridx = 0;
		gbcLblSesso.gridy = 4;
		data.add(lblSesso, gbcLblSesso);

		buttonGroup.add(rdbtnMale);
		final GridBagConstraints gbcRdbtMaschile = new GridBagConstraints();
		gbcRdbtMaschile.anchor = GridBagConstraints.WEST;
		gbcRdbtMaschile.gridx = 1;
		gbcRdbtMaschile.gridy = 4;
		data.add(rdbtnMale, gbcRdbtMaschile);

		buttonGroup.add(rdbtnFemale);
		final GridBagConstraints gbcRdbtnFemminile = new GridBagConstraints();
		gbcRdbtnFemminile.anchor = GridBagConstraints.WEST;
		gbcRdbtnFemminile.gridx = 1;
		gbcRdbtnFemminile.gridy = 5;
		data.add(rdbtnFemale, gbcRdbtnFemminile);

		final JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		final JSeparator separator = new JSeparator();
		buttonPane.add(separator);

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				okState = true;
				setVisible(false);
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		final JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				okState = false;
				setVisible(false);
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		pack();
	}

	/**
	 * @return the person birth year
	 */
	public int getBirthYear() {
		return (Integer) this.spinner.getValue();
	}

	/**
	 * @return the person social security code
	 */
	public String getCode() {
		return this.textFieldCode.getText();
	}

	/**
	 * @return the person surname
	 */
	public String getSurname() {
		return this.textFieldSurname.getText();
	}

	/**
	 * @return the person name
	 */
	public String getUserName() {
		return this.textFieldName.getText();
	}

	/**
	 * @return the person sex
	 */
	public boolean isMale() {
		return this.rdbtnMale.isSelected();
	}

	/**
	 * @return true if "OK" has been selected
	 */
	public boolean isOKState() {
		return this.okState;
	}

	/**
	 * Resets all fields.
	 */
	public void reinit() {
		this.textFieldName.setText("");
		this.textFieldSurname.setText("");
		this.textFieldCode.setText("");
		this.rdbtnMale.setSelected(true);
		this.rdbtnMale.setSelected(false);
		this.spinner.setValue(LocalDate.now().getYear() - EXPECTED_USER_AGE);
	}
}
