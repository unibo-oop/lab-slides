using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using BankAccountDelegates;

namespace BankAccountAnonymous
{
   class UseFlexibleBankAccounts
   {
      private static void OnConsoleAction(int balance, int amount) =>
         Console.WriteLine("Could not withdraw " + amount);

      private static void ErrorAction(int balance, int amount) =>
         Console.Error.WriteLine($"ERROR on Withdrawal: {balance}:{amount}");

      static void Main(string[] args)
      {
         // use of anonymous function to fill a variable
         WithdrawAction act1 = delegate(int balance, int amount)
         {
            Console.WriteLine("Could not withdraw " + amount);
         };
         // use of anonymous function in-line where needed
         var ba1 = new FlexibleBankAccount("a", delegate(int amount) { return 1; }, act1);
         ba1.Deposit(1000); // 1000
         ba1.Withdraw(50); // 950
         ba1.Withdraw(150); // 699
         ba1.Withdraw(1000); // 699, + console output
         Console.WriteLine(ba1.Balance); // 699

         ComputeFee fee2 = delegate(int amount) { return amount > 100 ? 1 : 0; };
         // cannot use them to chain delegates
         var act2 = new WithdrawAction(OnConsoleAction) + new WithdrawAction(ErrorAction);
         var ba2 = new FlexibleBankAccount("a", fee2 , act2);
         ba2.Deposit(1000); // 1000
         ba2.Withdraw(50); // 949
         ba2.Withdraw(150); // 798
         ba2.Withdraw(1000); // 798, + console/error outputs
         Console.WriteLine(ba2.Balance); // 700

         // Use in libraries...
         List<int> list = new List<int>(new int[]{10,30,20,40,5});
         list.Sort(delegate(int i, int i1) { return i - i1; });
         foreach(var i in list) Console.WriteLine(i); // 5,10,20,30,..
         list.Sort(delegate(int i, int i1) { return i1 - i; });
         foreach(var i in list) Console.WriteLine(i); // 40,30,20,..
      }
   }
}