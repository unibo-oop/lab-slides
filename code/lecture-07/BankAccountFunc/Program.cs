using System;

namespace BankAccountFunc
{
    public interface IBankAccount
   {
      public int Balance { get; }
      public string Name { get; }

      public void Deposit(int amount);
      public void Withdraw(int amount);
   }
   
   public class FlexibleBankAccount : IBankAccount
   {
      public int Balance { get; private set; }
      public string Name { get; }

      private Func<int,int> _computeFee;

      private Action<int,int> _action;

      public FlexibleBankAccount(string name, Func<int,int> computeFee, Action<int,int> action)
      {
         _computeFee = computeFee;
         _action = action;
         Name = name;
      }

      public void Deposit(int amount) => Balance += amount;

      public void Withdraw(int amount)
      {
         var fee = _computeFee(amount);
         if (Balance < amount + fee) _action(Balance, amount);
         else Balance -= (amount + fee);
      }

      public override string ToString() => $"Name: {Name}, Balance: {Balance}";
   }
   
   class UseFlexibleBankAccounts
   {
      static void Main(string[] args)
      {
         var ba1 = new FlexibleBankAccount(
            "a", 
            _ => 1,
            (_, a) => Console.WriteLine("Could not withdraw " + a));
         // var ba1 = new FlexibleBankAccount("a", BusinessFee, OnConsoleAction);
         ba1.Deposit(1000); // 1000
         ba1.Withdraw(50);  // 950
         ba1.Withdraw(150); // 699
         ba1.Withdraw(1000); // 699, + console output
         Console.WriteLine(ba1.Balance); // 699

         Action<int, int> act2 = (_, a) => Console.WriteLine("Could not withdraw " + a); 
         act2 += (b, a) => Console.Error.WriteLine($"ERROR on Withdrawal: {b}:{a}"); 
         var ba2 = new FlexibleBankAccount("a", a => a > 100 ?1 : 0, act2);
         ba2.Deposit(1000); // 1000
         ba2.Withdraw(50);  // 949
         ba2.Withdraw(150); // 798
         ba2.Withdraw(1000); // 798, + console/error outputs
         Console.WriteLine(ba2.Balance); // 700
      }
   }
}