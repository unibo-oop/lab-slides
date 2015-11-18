package it.unibo.oop.lab08.ex04;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 * @author Andrea Santi
 * @author Mirko Viroli
 * @author Danilo Pianini
 *
 */
public class View extends JFrame implements IView {

	private static final long serialVersionUID = 4944349615829626265L;
	private static final String WINDOW_TITLE = "PersonEditor";
	private static final String[] PROPS = new String[] { "Name", "Surname", "Code", "Birth Year", "Gender" };
	private static final Object[][] INIT_DATA = new Object[][] {};
	private final DefaultTableModel tm = new DefaultTableModel(INIT_DATA, PROPS);
	private final JButton bLoad = new JButton("Load");
	private final JButton bSave = new JButton("Save");
	private final JButton bAdd = new JButton("Add");
	private final JButton bQuit = new JButton("Quit");
	private final JButton bClear = new JButton("Clear");
	private final JCheckBox cSort = new JCheckBox("Sorting?");
	private final Form formDialog = new Form(this);

	private IController ctrl;

	/**
	 * Builds a new View.
	 */
	public View() {
		super(WINDOW_TITLE);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		buildLayout();
		setHandlers();
		pack();
		setLocationByPlatform(true);
		setVisible(true);
	}

	@Override
	public void attachViewObserver(final IController controller) {
		this.ctrl = controller;
	}

	@Override
	public void commandFailed(final String message) {
		JOptionPane.showMessageDialog(this, message, "An error occurred", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void addData(final String name, final String surname, final String code, final int birthYear, final boolean male) {
		tm.addRow(new Object[] { name, surname, code, birthYear, male });
	}

	@Override
	public void clearData() {
		tm.setDataVector(INIT_DATA, PROPS);
	}

	@Override
	public boolean wantsSorted() {
		return this.cSort.isSelected();
	}

	private void buildLayout() {
		final JTable table = new JTable(tm);
		final JScrollPane scroll = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		final JPanel pEastInternal = new JPanel(new GridBagLayout());
		GridBagConstraints cnst = new GridBagConstraints();
		cnst.gridy = 0;
		cnst.fill = GridBagConstraints.HORIZONTAL;
		pEastInternal.add(bLoad, cnst);
		cnst.gridy++;
		pEastInternal.add(bAdd, cnst);
		cnst.gridy++;
		pEastInternal.add(bSave, cnst);
		cnst.gridy++;
		pEastInternal.add(bQuit, cnst);
		cnst.gridy++;
		pEastInternal.add(bClear, cnst);
		cnst.gridy++;
		pEastInternal.add(cSort, cnst);

		final JPanel pEast = new JPanel(new FlowLayout());
		pEast.add(pEastInternal);

		final JPanel jp = new JPanel();
		this.add(jp);
		jp.setLayout(new BorderLayout());
		jp.add(scroll, BorderLayout.CENTER);
		jp.add(pEast, BorderLayout.EAST);
	}

	private void setHandlers() {
		this.bLoad.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				ctrl.commandLoad();
			}
		});
		this.bSave.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				ctrl.commandSave();
			}
		});
		this.bQuit.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				quitHandler();
			}
		});
		this.bAdd.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				formDialog.reinit();
				formDialog.setVisible(true);
			}
		});
		this.bClear.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				ctrl.commandClear();
			}
		});
		this.cSort.addItemListener(new ItemListener() {
			public void itemStateChanged(final ItemEvent e) {
				ctrl.commandResend();
			}
		});
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(final WindowEvent e) {
				quitHandler();
			}
		});
		this.formDialog.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(final ComponentEvent e) {
				if (formDialog.isOKState()) {
					ctrl.commandAdd(formDialog.getUserName(), formDialog.getSurname(), formDialog.getCode(),
							formDialog.getBirthYear(), formDialog.isMale());
				}
			}
		});
	}

	private void quitHandler() {
		final int n = JOptionPane.showConfirmDialog(this, "Do you really want to quit?", "Quitting..", JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION) {
			ctrl.commandQuit();
		}
	}
}
