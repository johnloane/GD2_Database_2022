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
}
