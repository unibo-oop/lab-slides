package it.unibo.oop.lab04.bank;

// CHECKSTYLE:OFF
public class DebugTestBankAccount {

    private DebugTestBankAccount() {}
    
    public static void main(final String[] args) {
        // 1) Creare l' AccountHolder relativo a Mario Rossi con id 1
        final AccountHolder usr1 = new AccountHolder("Mario", "Rossi", 1);

        // 1) Creare l' AccountHolder relativo ad Arsenio Lupin con id 2
        final AccountHolder arsenioLupin = new AccountHolder("Arsenio", "Lupin", 2);

        final BankAccount b1 = new SimpleBankAccount(usr1.getUserID(), 1000);

        b1.deposit(usr1.getUserID(), 500);

        b1.deposit(usr1.getUserID(), 1000);

        b1.withdraw(1, 700);

        b1.depositFromATM(usr1.getUserID(), 100);

        System.out.println("Mario Rossi current balance is " + b1.getBalance());

        // withdraw 500 Euro, 5 times
        for (int i = 0; i < 5; i++) {
            b1.withdraw(1, 500);
        }

        b1.deposit(usr1.getUserID(), 2000);
        System.out.println("Mario Rossi current balance is " + b1.getBalance());

        // robbery attempted by Lupin on Rossi's account
        b1.withdraw(arsenioLupin.getUserID(), 3000);
        System.out.println("Mario Rossi current balance is " + b1.getBalance());
    }
}