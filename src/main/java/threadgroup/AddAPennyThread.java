package threadgroup;

public class AddAPennyThread extends Thread
{
    private PiggyBank piggyBank;

    public AddAPennyThread(PiggyBank piggy)
    {
        this.piggyBank = piggy;
    }

    @Override
    public void run()
    {
        addAPenny(piggyBank);
    }

    private synchronized static void addAPenny(PiggyBank piggyBank)
    {
        int newBalance = piggyBank.getBalance() + 1;

        try
        {
            Thread.sleep(5);
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie.getMessage());
        }
        piggyBank.setBalance(newBalance);
    }


}
