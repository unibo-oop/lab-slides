package it.unibo.oop.lab08.ex04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Andrea Santi
 * @author Danilo Pianini
 *
 */
public class Controller implements IController {

	private final Set<IView> view = new HashSet<>();
	private IModel model;
	private String fileName;
	
	/**
	 * Builds a new controller working with an empty model.
	 */
	public Controller() {
		model = new Model();
	}

	@Override
	public void addView(final IView v) {
		v.attachViewObserver(this);
		view.add(v);
	}
	
	@Override
	public void commandAdd(final String name, final String surname, final String code, final int birthYear, final boolean male) {
		try {
			model.add(name, surname, code, birthYear, male);
			for (final IView v : view) {
				v.addData(name, surname, code, birthYear, male);
			}
		} catch (Exception e) {
			displayException(e);
		}
	}

	@Override
	public void commandLoad() {
		try {
			final ObjectInput ois = new ObjectInputStream(new FileInputStream(fileName));
			model = (IModel) ois.readObject();
			ois.close();
			this.reSendAll();
		} catch (Exception e) {
			displayException(e);
		}
	}

	@Override
	public void commandQuit() {
		System.exit(0);
	}

	@Override
	public void commandResend() {
		reSendAll();
	}

	@Override
	public void commandSave() {
		try {
			final ObjectOutput oos = new ObjectOutputStream(new FileOutputStream(fileName));
			oos.writeObject(model);
			oos.close();
		} catch (Exception e) {
			displayException(e);
		}
	}

	private void displayException(final Throwable e) {
		for (final IView v : view) {
			v.commandFailed(e.getMessage());
		}
	}

	@Override
	public void removeView(final IView v) {
		view.remove(v);
	}

	private void reSend(final IView v) {
		v.clearData();
		final Iterator<Person> it = model.iterator();
		while (it.hasNext()) {
			final Person p = it.next();
			v.addData(p.getName(), p.getSurname(), p.getCode(), p.getBirthYear(), p.isMale());
		}
	}

	private void reSendAll() {
		for (final IView v : view) {
			reSend(v);
		}
	}

	/**
	 * @param file
	 *            the new file name
	 */
	public void setFileName(final String file) {
		this.fileName = file;
	}

}
