package it.unibo.oop.lab04.bank;

import static it.unibo.oop.lab04.Assertions.assertEquals;

//CHECKSTYLE:OFF
public final class TestBankAccount {

    // Tolerance for double comparisons, to account for floating-point rounding errors  
    private static final double EPSILON = 1e-7;

    private TestBankAccount() {
    }

    public static void main(final String[] args) {
        final var usr1 = new AccountHolder("Mario", "Rossi", 1);
        final var usr2 = new AccountHolder("Luigi", "Bianchi", 2);

        final double startAmount = 10000;
        final double withdraw = 15000;
        final double deposit = 10000;
        final double expectedFinal1 = 4995;
        final double expectedFinal2 = 19994.8;

        final BankAccount acc1 = new SimpleBankAccount(usr1.getUserID(), 0);
        final BankAccount acc2 = new ExtendedStrictBankAccount(usr2.getUserID(), 0);
        final var balance1 = usr1.getName() + " " + usr1.getSurname() + " account balance";
        final var balance2 = usr2.getName() + " " + usr2.getSurname() + " account balance";

        assertEquals(balance1, 0d, acc1.getBalance(), EPSILON);
        assertEquals(balance2, 0d, acc2.getBalance(), EPSILON);

        acc1.deposit(usr1.getUserID(), startAmount);
        assertEquals(balance1, startAmount, acc1.getBalance(), EPSILON);
        acc2.deposit(usr2.getUserID(), startAmount);
        assertEquals(balance2, startAmount, acc2.getBalance(), EPSILON);
        acc1.withdraw(usr1.getUserID(), withdraw);
        assertEquals(balance1, startAmount - withdraw, acc1.getBalance(), EPSILON);
        acc2.withdraw(usr2.getUserID(), withdraw);
        assertEquals(balance2, startAmount, acc2.getBalance(), EPSILON);
        acc1.deposit(usr1.getUserID(), deposit);
        assertEquals(balance1, startAmount - withdraw + deposit, acc1.getBalance(), EPSILON);
        acc2.deposit(usr2.getUserID(), deposit);
        assertEquals(balance2, startAmount + deposit, acc2.getBalance(), EPSILON);
        acc1.computeManagementFees(usr1.getUserID());
        assertEquals(balance1, expectedFinal1, acc1.getBalance(), EPSILON);
        acc2.computeManagementFees(usr2.getUserID());
        assertEquals(balance2, expectedFinal2, acc2.getBalance(), EPSILON);
    }
}
