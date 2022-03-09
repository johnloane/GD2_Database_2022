package extendsThread;

//This class prints a particular character a certain number of times

public class PrintChar extends Thread
{
    private char charToPrint;
    private int times;

    public PrintChar(char c, int t)
    {
        this.charToPrint = c;
        this.times = t;
    }

    //Override the run() method to tell the system what the thread will do

    @Override
    public void run()
    {
        for(int i=0; i < times;i++)
        {
            System.out.print(charToPrint);
        }
    }
}
