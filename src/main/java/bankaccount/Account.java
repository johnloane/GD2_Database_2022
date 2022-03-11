package bankaccount;

public class Account
{
    private static Object sharedLock = new Object();
    private double balance;

    public Account()
    {
        this.balance = 0;
    }

    public Account(double balance)
    {
        this.balance = balance;
    }

    public void deposit(double amount)
    {
        synchronized (sharedLock)
        {
            double temp;
            temp = this.balance;

            try
            {
                Thread.sleep(500);
            } catch (InterruptedException ie)
            {
                System.out.println(ie.getMessage());
            }
            System.out.println(Thread.currentThread().getName() + " depositing current balance is " + temp);
            temp += amount;
            balance = temp;
        }
    }

    public void withdraw(double amount)
    {
        synchronized (sharedLock)
        {
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException ie)
            {
                System.out.println(ie.getMessage());
            }
            System.out.println(Thread.currentThread().getName() + " withdrawing current balance is " + balance);
            balance -= amount;
        }
    }

    public double getBalance()
    {
        return balance;
    }
}
