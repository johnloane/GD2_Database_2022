package bankaccount;

public class AccountThread implements Runnable
{
    private Account acc;

    public AccountThread(Account acc)
    {
        this.acc = acc;
    }

    @Override
    public void run()
    {
        //Increase the amount in the account by 100 ten times
        for(int i=0; i < 10; i++)
        {
            this.acc.deposit(100);
        }
    }
}
