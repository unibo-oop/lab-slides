using System;
using System.Collections.Generic;

namespace BankAccountStrategies
{
   public interface IBankAccount
   {
      public int Balance { get; }
      public string Name { get; }

      public void Deposit(int amount);
      public void Withdraw(int amount);
   }
   public interface IFeeCalculator
   {
      int Fee(int amount);
   }

   public interface IWithdrawAction
   {
      void Handler(int balance, int amount);
   }
   
   public class StandardFee : IFeeCalculator
   {
      public int Fee(int amount) => 1;
   }
   
   public class BusinessFee : IFeeCalculator
   {
      public int Fee(int amount) => amount > 100 ? 1 : 0;
   }

   public class OnConsoleAction : IWithdrawAction
   {
      public void Handler(int balance, int amount) => 
         Console.WriteLine("Could not withdraw "+amount);
   }
   
   public class ErrorAction : IWithdrawAction
   {
      public void Handler(int balance, int amount) => 
         Console.Error.WriteLine($"ERROR on Withdrawal: {balance}:{amount}");
   }

   public class FlexibleBankAccount : IBankAccount
   {
      public int Balance { get; private set; }
      public string Name { get; }

      private IFeeCalculator _feeCalculator;

      private ISet<IWithdrawAction> _actions;

      public FlexibleBankAccount(string name, IFeeCalculator feeCalculator, ISet<IWithdrawAction> actions)
      {
         _feeCalculator = feeCalculator;
         _actions = actions;
         Name = name;
      }

      public void Deposit(int amount) => Balance += amount;

      public void Withdraw(int amount)
      {
         var fee = _feeCalculator.Fee(amount);
         if (Balance < amount + fee)
         {
            foreach (var wa in _actions) wa.Handler(Balance, amount);
         }
         else Balance -= (amount + fee);
      }

      public override string ToString() => $"Name: {Name}, Balance: {Balance}";
   }
   
   class UseFlexibleBankAccounts
   {
      static void Main(string[] args)
      {
         var actions1 = new HashSet<IWithdrawAction>(new []{new OnConsoleAction()});
         var ba1 = new FlexibleBankAccount("a", new BusinessFee(), actions1);
         ba1.Deposit(1000); // 1000
         ba1.Withdraw(50);  // 950
         ba1.Withdraw(150); // 699
         ba1.Withdraw(1000); // 699, + console output
         Console.WriteLine(ba1.Balance); // 699
         
         var actions2 = new HashSet<IWithdrawAction>(
            new IWithdrawAction[]{new OnConsoleAction(), new ErrorAction()});
         var ba2 = new FlexibleBankAccount("a", new StandardFee(), actions2);
         ba2.Deposit(1000); // 1000
         ba2.Withdraw(50);  // 949
         ba2.Withdraw(150); // 798
         ba2.Withdraw(1000); // 798, + console/error outputs
         Console.WriteLine(ba2.Balance); // 700
      }
   }

}