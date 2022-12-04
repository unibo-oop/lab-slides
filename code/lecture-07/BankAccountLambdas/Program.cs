using System;
using System.Collections.Generic;
using BankAccountDelegates;

namespace BankAccountLambdas
{
   class UseFlexibleBankAccounts
   {
      static void Main(string[] args)
      {
         // use of anonymous function in-line where needed
         var ba1 = new FlexibleBankAccount(
            "a",
            _ => 1, // lambda of the form x=><exp>
            (_, a) => Console.WriteLine("Could not withdraw " + a)); 
         ba1.Deposit(1000); // 1000
         ba1.Withdraw(50); // 950
         ba1.Withdraw(150); // 699
         ba1.Withdraw(1000); // 699, + console output
         Console.WriteLine(ba1.Balance); // 699

         WithdrawAction act2 = (_, a) => Console.WriteLine("Could not withdraw " + a); 
         act2 +=  (b, a) => Console.Error.WriteLine($"ERROR on Withdrawal: {b}:{a}"); 
         var ba2 = new FlexibleBankAccount("a", amount => amount > 100 ? 1 : 0 , act2);
         ba2.Deposit(1000); // 1000
         ba2.Withdraw(50); // 949
         ba2.Withdraw(150); // 798
         ba2.Withdraw(1000); // 798, + console/error outputs
         Console.WriteLine(ba2.Balance); // 700

         // Use in libraries...
         List<int> list = new List<int>(new int[]{10,30,20,40,5});
         list.Sort((i,j) => i-j);
         foreach(var i in list) Console.WriteLine(i); // 5,10,20,30,..
         list.Sort((i,j) => j-i);
         foreach(var i in list) Console.WriteLine(i); // 40,30,20,..
      }
   }
}