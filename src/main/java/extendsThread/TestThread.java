package extendsThread;

public class TestThread
{
    public static void main(String[] args)
    {
        //Create 3 threads
        PrintChar printA = new PrintChar('a', 100);
        PrintChar printB = new PrintChar('b', 100);
        PrintNum print100 = new PrintNum(100);

        //Nothing will happen unless we start the threads
        printA.start();
        printB.start();
        print100.start();
    }
}
