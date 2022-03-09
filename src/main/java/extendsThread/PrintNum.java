package extendsThread;

public class PrintNum extends Thread
{
    private int lastNum;

    public PrintNum(int n)
    {
        this.lastNum = n;
    }

    @Override
    public void run()
    {
        for(int i=1; i <= lastNum; i++)
        {
            System.out.print(" " + i);
        }
    }
}
