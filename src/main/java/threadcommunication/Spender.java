package threadcommunication;

public class Spender extends Thread
{
    private BankAccount account;

    public Spender(BankAccount ba)
    {
        this.account = ba;
    }

    @Override
    public void run()
    {
        while(account.isOpen())
        {
            try
            {
                if(account.withdraw(500))
                {
                    System.out.println("Successfully withdrew 500");
                }
                sleep(1000);
            }
            catch(InterruptedException ie)
            {
                System.out.println(ie.getMessage());
            }
        }
    }
}
