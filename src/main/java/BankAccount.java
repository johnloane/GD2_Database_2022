public class BankAccount
{
    private double balance;
    private boolean isOpen = true;

    /*
    Withdraw an amount from the account. If the funds are insufficient, it will wait until the funds are available or the account is closed
    @param amount The amount to be withdrawn
    @return true if the withdrawal is successful, false otherwise
    @exception InterruptedException of another thread interrupts
     */
    public synchronized boolean withdraw(double amount) throws InterruptedException
    {
        while(amount > balance && isOpen())
        {
            System.out.println("Waiting for some money ....");
            wait();
        }
        boolean result = false;
        if(isOpen())
        {
            balance -= amount;
            System.out.println("Withdrew " + amount);
            result = true;
        }
        return result;
    }

    /*
    Deposit an amount into the account provided that account is open
    When the desposit is successful it will notify all waiting operations that there is more money in the account
    @param amount Amount to deposit
    @return true if deposit success, otherwise false
     */

    public synchronized boolean deposit(double amount)
    {
        if(isOpen())
        {
            balance += amount;
            notifyAll();
            return true;
        }
        else
        {
            return false;
        }
    }

    /*
    Checks to see if the account is open
    @return true if it is open, otherwise false
     */

    public synchronized boolean isOpen()
    {
        return isOpen;
    }

    /*
    Close the bank account
     */
    public synchronized void close()
    {
        isOpen = false;
        notifyAll();
    }
}
