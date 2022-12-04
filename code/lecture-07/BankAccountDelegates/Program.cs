using System;

namespace BankAccountDelegates
{
   public interface IBankAccount
   {
      public int Balance { get; }
      public string Name { get; }

      public void Deposit(int amount);
      public void Withdraw(int amount);
   }
   
   public delegate int ComputeFee(int amount);
   public delegate void WithdrawAction(int balance, int amount);
   
   public class FlexibleBankAccount : IBankAccount
   {
      public int Balance { get; private set; }
      public string Name { get; }

      private ComputeFee _computeFee;

      private WithdrawAction _action;

      public FlexibleBankAccount(string name, ComputeFee computeFee, WithdrawAction action)
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
      private static int StandardFee(int amount) => 1;
      private static int BusinessFee(int amount) => amount > 100 ? 1 : 0;
      private static void OnConsoleAction(int balance, int amount) => 
            Console.WriteLine("Could not withdraw "+amount);
      private static void ErrorAction(int balance, int amount) => 
            Console.Error.WriteLine($"ERROR on Withdrawal: {balance}:{amount}");

      static void Main(string[] args)
      {
         var fee1 = new ComputeFee(BusinessFee);
         var act1 = new WithdrawAction(OnConsoleAction); 
         var ba1 = new FlexibleBankAccount("a", fee1, act1);
         // var ba1 = new FlexibleBankAccount("a", BusinessFee, OnConsoleAction);
         ba1.Deposit(1000); // 1000
         ba1.Withdraw(50);  // 950
         ba1.Withdraw(150); // 699
         ba1.Withdraw(1000); // 699, + console output
         Console.WriteLine(ba1.Balance); // 699

         var fee2 = new ComputeFee(StandardFee);
         var act2 = new WithdrawAction(OnConsoleAction) + new WithdrawAction(ErrorAction);  
         var ba2 = new FlexibleBankAccount("a", fee2, act2);
         ba2.Deposit(1000); // 1000
         ba2.Withdraw(50);  // 949
         ba2.Withdraw(150); // 798
         ba2.Withdraw(1000); // 798, + console/error outputs
         Console.WriteLine(ba2.Balance); // 700
      }
   }

}