package oop.lab03.encapsulation;

import oop.lab03.interfaces.IBankAccount;

public class BankAccount implements IBankAccount {

	private double balance;
	private int nTransactions;
	private final int usrID;

	private static final double ATM_TRANSACTION_FEE = 1;
	private static final double MANAGEMENT_FEE = 5;

	public BankAccount(final int usrID, final double balance) {
		this.usrID = usrID;
		this.balance = balance;
		this.nTransactions = 0;
	}

	private void transactionOp(final int usrID, final double amount) {
		if (checkUser(usrID)) {
			this.balance += amount;
			this.incTransactions();
		}
	}

	public void deposit(final int usrID, final double amount) {
		this.transactionOp(usrID, amount);
	}

	public void withdraw(final int usrID, final double amount) {
		this.transactionOp(usrID, -amount);
	}

	public void depositFromATM(final int usrID, final double amount) {
		this.deposit(usrID, amount - BankAccount.ATM_TRANSACTION_FEE);
	}

	public void withdrawFromATM(final int usrID, final double amount) {
		this.withdraw(usrID, amount + BankAccount.ATM_TRANSACTION_FEE);
	}

	private void incTransactions() {
		this.nTransactions++;
	}

	public void computeManagementFees(final int usrID) {
		if (checkUser(usrID)) {
			this.balance -= BankAccount.MANAGEMENT_FEE;
		}
	}

	public double getBalance() {
		return this.balance;
	}

	public int getNTransactions() {
		return this.nTransactions;
	}

	private boolean checkUser(final int id) {
		return this.usrID == id;
	}
}