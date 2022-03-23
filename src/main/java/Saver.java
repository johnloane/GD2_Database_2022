public class Saver implements Runnable
{
    private BankAccount account;

    public Saver(BankAccount ba)
    {
        account = ba;
    }


    @Override
    public void run()
    {
        while(account.isOpen())
        {
            try
            {
                if(account.deposit(100))
                {
                    System.out.println("100 successfully deposited");
                }
                Thread.currentThread().sleep(1000);
            }
            catch(InterruptedException ie)
            {
                System.out.println(ie.getMessage());
            }
        }
    }
}
