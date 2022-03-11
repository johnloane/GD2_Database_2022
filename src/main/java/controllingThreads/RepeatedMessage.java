package controllingThreads;

/* A class to demonstrate why synchronized methods are needed
by showing what can gappen when they are not synchronized
 */

public class RepeatedMessage implements Runnable
{
    private static Object sharedLock = new Object();

    private String message;
    private int pauseTime;

    //Field stopFlag tells the thread when to stop
    //stopFlag is declared volatile to ensure every thread should see
    //changes to it immediately
    private volatile boolean stopFlag;

    public RepeatedMessage(String message, int pauseTime)
    {
        this.message = message;
        this.pauseTime = pauseTime;
    }


    //This is the engine of the thread
    @Override
    public void run()
    {
        stopFlag = false;
        try
        {
            while(!stopFlag)
            {
                displayMessage(this);
                Thread.currentThread().sleep(pauseTime);
            }
        }
        catch(InterruptedException ie)
        {
            return;
        }
    }

    //Synchronizing this method does not solve the problem here as we are using two separate instances of the RepeatedMessage class and synchronized with lock on the current instance so there will be two separate locks each ignored by the other - need the static sharedLock where there is one sharedLock for all instances of the class to solve this problem
    private void displayMessage(RepeatedMessage repeatedMessage) throws InterruptedException
    {
        synchronized (sharedLock)
        {
            for (int i = 0; i < repeatedMessage.message.length(); i++)
            {
                System.out.print(repeatedMessage.message.charAt(i));
                Thread.currentThread().sleep(50);
            }
        }
        System.out.println();
    }

    /* A method to stop the thread */
    public void finish()
    {
        stopFlag = true;
        return;
    }
}
