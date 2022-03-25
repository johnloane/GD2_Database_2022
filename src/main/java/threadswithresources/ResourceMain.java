package threadswithresources;

public class ResourceMain
{
    public static void main(String[] args)
    {
        Resource r = new Resource();

        Thread t1 = new Thread(new Connection("t1", r));
        Thread t2 = new Thread(new Connection("t2", r));
        Thread t3 = new Thread(new Connection("t3", r));
        Thread t4 = new Thread(new Connection("t4", r));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
