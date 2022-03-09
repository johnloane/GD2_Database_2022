package implementsRunnable;

import extendsThread.PrintChar;
import extendsThread.PrintNum;

public class TestThread
{
    public static void main(String[] args)
    {
        //Create 3 threads
        //Extra step to create the thread from the Runnable
        Thread printA = new Thread(new implementsRunnable.PrintChar('a', 100));
        Thread printB = new Thread(new implementsRunnable.PrintChar('b', 100));
        Thread print100 = new Thread(new implementsRunnable.PrintNum(100));

        //Nothing will happen unless we start the threads
        printA.start();
        printB.start();
        print100.start();
    }
}
