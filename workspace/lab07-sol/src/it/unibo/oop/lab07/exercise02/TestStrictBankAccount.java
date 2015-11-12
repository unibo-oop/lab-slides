package it.unibo.oop.lab07.exercise02;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link it.unibo.oop.lab07.exercise02.StrictBankAccountImpl}.
 * 
 * @author Andrea Santi
 * @author Matteo Casadei
 *
 */
public class TestStrictBankAccount {

    /**
     * Used to test Exceptions on
     * {@link it.unibo.oop.lab07.exercise02.StrictBankAccountImpl}.
     */
    @Test
    public void testBankOperations() {
        // 1) Creare due StrictBankAccount assegnati a due AccountHolder a
        // scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
        final AccountHolder usr1 = new AccountHolder("Mario", "Rossi", 1);
        final AccountHolder usr2 = new AccountHolder("Luigi", "Bianchi", 2);

        final StrictBankAccountImpl account1 = new StrictBankAccountImpl(usr1.getUserID(), 10000, 10);
        final StrictBankAccountImpl account2 = new StrictBankAccountImpl(usr2.getUserID(), 10000, 10);

        // 2) Effetture un numero di operazioni a piacere per testare il lancio
        // delle eccezioni per i casi di interesse

        try {
            account1.deposit(4, 100);
            fail();
        } catch (WrongAccountHolderException e) {
            assertNotNull(e);
        }

        for (int i = 0; i < 10; i++) {
            try {
                account2.depositFromATM(usr2.getUserID(), 1);
            } catch (TransactionsOverQuotaException | WrongAccountHolderException e) {
                fail("Not exceeded yet max no. transactions!");
            }
        }

        /*
         * Questa istruzione genererà una eccezione di tipo
         * TransactionsOverQuotaException
         */
        try {
            account2.depositFromATM(usr2.getUserID(), 1);
            fail("Should raise the exception signaling that we exceeded max no. transactions!");
        } catch (TransactionsOverQuotaException | WrongAccountHolderException e) {
            assertNotNull(e);
        }

        try {
            /*
             * Questa istruzione genererà una eccezione di tipo
             * NotEnoughFoundsException
             */
            account1.withdraw(usr1.getUserID(), 50000);
        } catch (WrongAccountHolderException e) {
            fail();
        } catch (NotEnoughFoundsException e) {
            assertNotNull(e);
        }
    }

}
