package implementsRunnable;

public class PrintChar implements Runnable
{
    private char charToPrint;
    private int times;

    public PrintChar(char c, int t)
    {
        this.charToPrint = c;
        this.times = t;
    }

    @Override
    public void run()
    {
        for(int i=0; i < times;i++)
        {
            System.out.print(charToPrint);
        }
    }
}
