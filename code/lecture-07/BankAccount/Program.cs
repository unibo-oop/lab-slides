using System;
using System.Collections.Generic;

namespace BankAccount
{
   class UseBankAccounts
   {
      static void Main(string[] args)
      {
         var ba1 = new BankAccount("a");
         ba1.Deposit(1000);
         ba1.Withdraw(100);
         Console.WriteLine(ba1.Balance); // 899

         var ba2 = new BankAccount("b");
         ba2.Deposit(1000);
         ba2.Withdraw(1200); // Can't be done
         Console.WriteLine(ba2.Balance); // 1000
         
         var ba3 = new BankAccount("c" );
         ba3.Deposit(500);

         var accounts = new List<IBankAccount>(new []{ba1, ba2, ba3});
         var richest = BankAccountHelpers.Richest(accounts);
         Console.WriteLine(richest);

      }
   }
   
   public interface IBankAccount
   {
      public int Balance { get; }
      public string Name { get; }
      public void Deposit(int amount);
      public void Withdraw(int amount);
   }

   public class BankAccount : IBankAccount
   {
      public int Balance { get; private set; }
      public string Name { get; }

      public BankAccount(string name) => Name = name;

      public void Deposit(int amount) => Balance += amount;

      public void Withdraw(int amount)
      {
         if (Balance < amount + 1) Console.WriteLine("Can't withdraw!");
         else Balance -= (amount + 1);
      }

      public override string ToString() => $"Name: {Name}, Balance: {Balance}";
   }

   public class BankAccountHelpers
   {
      public static IBankAccount Richest(IEnumerable<IBankAccount> accounts)
      {
         IBankAccount top = null;
         foreach (var account in accounts)
         {
            if (top == null || account.Balance > top.Balance) top = account;
         }
         return top;
      }
   }
}