package bankaccount;

public class Account
{
    private double balance;

    public Account()
    {
        this.balance = 0;
    }

    public Account(double balance)
    {
        this.balance = balance;
    }

    public synchronized void deposit(double amount)
    {
        double temp;
        temp = this.balance;

        try
        {
            Thread.sleep(500);
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " depositing current balance is " + temp);
        temp += amount;
        balance = temp;
    }

    public void withdraw(double amount)
    {
        try
        {
            Thread.sleep(500);
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie.getMessage());
        }

        balance -= amount;
    }

    public double getBalance()
    {
        return balance;
    }
}
