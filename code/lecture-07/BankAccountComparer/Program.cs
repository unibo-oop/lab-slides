using System;
using System.Collections.Generic;

namespace BankAccountComparer
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

         var accounts = new List<BankAccount>(new []{ba1, ba2, ba3});
         var richest = GeneralHelpers.Max(accounts, new Richer());
         Console.WriteLine(richest);
         
         // use in List<T> library class, to sort
         accounts.Sort(new Richer());
         Console.WriteLine(accounts[0]+" "+accounts[1]+" "+accounts[2]);
      }
   }
   /*
    * ICompare is defined: ICompare<in T>
    * Hence, where a IComparer<BankAccount> is expected, we can pass
    * a IComparer<IBankAccount>! Thanks contra-variance!!
    */
   public class Richer : IComparer<IBankAccount>
   {
      public int Compare(IBankAccount x, IBankAccount y)
      {
         return x.Balance - y.Balance;
      }
   }
   
   class GeneralHelpers {

      public static T Max<T>(IEnumerable<T> elements, IComparer<T> comparer) where T : class
      {
         T max = null;
         foreach (var t in elements)
         {
            if (max == null || comparer.Compare(t, max) > 0) max = t;
         }
         return max;
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
}