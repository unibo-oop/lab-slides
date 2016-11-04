package it.unibo.oop.lab04.bank;

public class DebugTestBankAccount {

    private DebugTestBankAccount() {}
    
    public static void main(final String[] args) {
        final AccountHolder usr1 = new AccountHolder("Mario", "Rossi", 1);
		final AccountHolder arsenioLupin = new AccountHolder("Arsenio", "Lupin", 2);

        final BankAccount b1 = new SimpleBankAccount(usr1.getUserID(), 1000);

        b1.deposit(usr1.getUserID(), 500);
        b1.deposit(usr1.getUserID(), 1000);
        b1.withdraw(1, 700);
        b1.depositFromATM(usr1.getUserID(), 100);

        System.out.println("Mario Rossi current balance is " + b1.getBalance());

        for (int i = 0; i < 5; i++) {
            b1.withdraw(1, 500);
        }

        b1.deposit(usr1.getUserID(), 2000);
        System.out.println("Mario Rossi current balance is " + b1.getBalance());

        b1.withdraw(arsenioLupin.getUserID(), 3000);
        System.out.println("Mario Rossi current balance is " + b1.getBalance());
    }
}
