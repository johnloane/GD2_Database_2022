package bankaccount;

public class BankMain
{
    public static void main(String[] args)
    {
        //Create an account which will shared by the threads
        Account a = new Account(1000);

        Runnable runner = new AccountThread(a);

        System.out.println("Start the threads");
        Thread niallThread = new Thread(runner, "Niall");
        Thread stephenThread = new Thread(runner, "Stephen");
        Thread hernelThread = new Thread(runner, "Hernel");

        niallThread.start();
        stephenThread.start();
        hernelThread.start();

        //Wait for threads to finish
        try
        {
            niallThread.join();
            stephenThread.join();
            hernelThread.join();
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie.getMessage());
        }

        System.out.println("Account balance is " + a.getBalance());

    }
}
