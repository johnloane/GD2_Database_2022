package controllingThreads;

public class ControlMain
{
    public static void main(String[] args)
    {
        try
        {
            RepeatedMessage m1 = new RepeatedMessage("HELLO", 500);
            Thread m1t = new Thread(m1);
            m1t.start();
            RepeatedMessage m2 = new RepeatedMessage("ola", 111);
            Thread m2t = new Thread(m2);
            m2t.start();

            //Pause and let the threads run for 5 seconds
            Thread.currentThread().sleep(5000);
            m1.finish();
            m2.finish();
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie.getMessage());
        }
        finally
        {
            //flush the output buffer
            System.out.println();
        }
    }
}
