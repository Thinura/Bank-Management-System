// A simple example, using an association-like record.
// (c) 2001 duane a. bailey
/**
 * An overly simplified implementation of a bank account
 * @author, 2001 duane a. bailey
 * @version $Id: BankAccount.java 8 2006-08-02 19:03:11Z bailey $
 */
public class BankAccount
{
    private String account;  // the account number
    private double balance; // the balance associated with account

    /**
     * @pre account is a string identifying the bank account
     * balance is the starting balance
     * @post constructs a bank account with desired balance
     */
    private BankAccount(String acc, double bal)
    {
        account = acc;
        balance = bal;
    }

    /**
     * Compare two Bank Accounts (non-standard equals form)
     * @pre other is a valid bank account
     * @post returns true if this bank account is the same as other
     */
    public boolean equals(Object other)
    {
        BankAccount that = (BankAccount)other;
        // two accounts are the same if account numbers are the same
        return this.account.equals(that.account);
    }

    /**
     * Account accessor.
     * @post returns the bank account number of this account
     */
    private String getAccount()
    {
        return account;
    }

    /**
     * Balance accessor.
     * @post returns the balance of this bank account
     */
    private double getBalance()
    {
        return balance;
    }

    /**
     * Deposit mutator.
     * @post deposit money in the bank account
     */
    private void deposit(double amount)
    {
        balance = balance + amount;
    }

    /**
     * Withdrawal mutator.
     * @pre there are sufficient funds in the account
     * @post withdraw money from the bank account
     */
    public void withdraw(double amount)
    {
        balance = balance - amount;
    }

    /**
     * Method to test Bank Accounts.  Is it better to invest
     * $100 over 10 years at 5%, or to invest $100 over 20 years
     * at 2.5%?
     */
    public static void main(String[] args)
    {
        // Question: is it better to invest $100 over 10 years at 5%
        //           or to invest $100 over 20 years at 2.5% interest?
        BankAccount jd = new BankAccount("Jain Dough",100.00);
        BankAccount js = new BankAccount("Jon Smythe",100.00);

        for (int years = 0; years < 10; years++)
        {
            jd.deposit(jd.getBalance() * 0.05);
        }
        for (int years = 0; years < 20; years++)
        {
            js.deposit(js.getBalance() * 0.025);
        }
        System.out.println("Jain invests $100 over 10 years at 5%.");
        System.out.println("After 10 years " + jd.getAccount() +
                " has $" + jd.getBalance());
        System.out.println("Jon invests $100 over 20 years at 2.5%.");
        System.out.println("After 20 years " + js.getAccount() +
                " has $" + js.getBalance());
    }
}
/*
Jain invests $100 over 10 years at 5%.
After 10 years Jain Dough has $162.8894626777441
Jon invests $100 over 20 years at 2.5%.
After 20 years Jon Smythe has $163.8616440290397
*/
