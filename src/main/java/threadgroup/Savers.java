package threadgroup;

public class Savers
{
    private static PiggyBank piggyBank = new PiggyBank();
    private Thread thread[] = new Thread[100];

    public static void main(String[] args)
    {
        Savers testSavers = new Savers();
        System.out.println("Balance " + piggyBank.getBalance());
    }

    public Savers()
    {
        ThreadGroup g1 = new ThreadGroup("Savers");
        boolean done = false;

        for(int i=0; i < 100; i++)
        {
            thread[i] = new Thread(g1, new AddAPennyThread(piggyBank), "t"+i);
            thread[i].start();
        }

        while(!done)
        {
            if(g1.activeCount() == 0)
            {
                done = true;
            }
        }
    }
}
