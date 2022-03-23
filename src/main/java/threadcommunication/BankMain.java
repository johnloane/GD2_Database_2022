package threadcommunication;

public class BankMain
{
    public static void main(String[] args)
    {
        BankAccount myAccount = new BankAccount();

        //Create the spender thread
        Spender spenderThread = new Spender(myAccount);
        //Create the saver thread
        Saver saver = new Saver(myAccount);
        Thread saverThread = new Thread(saver);

        spenderThread.start();
        saverThread.start();

        int time;
        if(args.length == 0)
        {
            time = 10000;
        }
        else
        {
            time = Integer.parseInt(args[0]) * 1000;
        }
        try
        {
            Thread.currentThread().sleep(time);
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie.getMessage());
        }

        myAccount.close();
    }
}
