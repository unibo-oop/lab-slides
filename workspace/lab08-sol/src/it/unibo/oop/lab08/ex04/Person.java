package it.unibo.oop.lab08.ex04;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Andrea Santi
 * @author Danilo Pianini
 *
 */
public class Person implements Serializable {
	
	private static final long serialVersionUID = -6507009699496712389L;
	
	private final String n;
	private final String surName;
	private final String sscode;
	private final int birthDate;
	private final boolean male;
	private int hash;
	
	/**
	 *
	 * @param name
	 *            the name
	 * @param surname
	 *            the surname
	 * @param code
	 *            the social security code
	 * @param birthYear
	 *            the year of birth
	 * @param isMale
	 *            true if the person is male
	 */
	public Person(final String name, final String surname, final String code, final int birthYear, final boolean isMale) {
		Objects.requireNonNull(name);
		this.n = name;
		Objects.requireNonNull(surname);
		this.surName = surname;
		Objects.requireNonNull(code);
		this.sscode = code;
		Objects.requireNonNull(birthYear);
		this.birthDate = birthYear;
		Objects.requireNonNull(isMale);
		this.male = isMale;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return n;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surName;
	}

	/**
	 * @return the social security code
	 */
	public String getCode() {
		return sscode;
	}

	/**
	 * @return the year of birth
	 */
	public int getBirthYear() {
		return birthDate;
	}

	/**
	 * @return true if the person is male
	 */
	public boolean isMale() {
		return male;
	}

	@Override
	public int hashCode() {
		/*
		 * Lazy-init hash
		 */
		if (hash == 0) {
			hash = sscode.hashCode();
		}
		return hash;
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof Person) {
			return sscode.equals(((Person) obj).sscode);
		}
		return false;
	}
	
	
	
	
}
