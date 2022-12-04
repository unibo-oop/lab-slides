using System;

namespace BankAccountWithDelegate
{
   class Program
   {
      static void Main(string[] args)
      {
         var account = new BankAccount();
         account.Deposit(1000);
         Console.WriteLine(account.Withdraw(100,a=>1));
         Console.WriteLine(account.Withdraw(100,new Fee(BasicFee)));
         Console.WriteLine(account.Withdraw(100,BasicFee));
         Console.WriteLine(account.Withdraw(100, delegate(int amount) { return 1; }));
         
         Fee f = new Fee(BasicFee);
         Func<int, int> f2 = BasicFee;
         Func<int, int> f3 = Program.BasicFee;
         int i = 0;
         Func<int, int> f4 = j => i++;
         Console.WriteLine(f4(5)+" "+i); // vere lambda
         Action<int> a = i => Console.WriteLine(i);
         Action<int> a2 = Console.WriteLine;
         a(5);
         Delegate d = f;

      }

      private static int BasicFee(int a) => a / 10;

   }

   public delegate int Fee(int amount);

   public interface IBankAccount
   {
      int Amount { get; }
         
      void Deposit(int amount);

      int Withdraw(int amount, Fee fee);
   }

   public class BankAccount : IBankAccount
   {
      public int Amount { get; private set; } = 0;

      public void Deposit(int amount) => Amount += amount;

      public int Withdraw(int amount, Fee fee)
      {
         if (Amount <= amount + fee(amount)) return 0;
         Amount -= (amount + fee(amount));
         return amount;
      }
   }
   
}