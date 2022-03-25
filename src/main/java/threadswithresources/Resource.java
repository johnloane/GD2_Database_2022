package threadswithresources;

public class Resource
{
    private boolean conFree;

    public Resource()
    {
        this.conFree = true;
    }

    public synchronized void getConnection(String name)
    {
        System.out.println(name + " Entered getConnection() ");
        while(conFree == false)
        {
            try
            {
                System.out.println(name + " waiting in getConnection()");
                wait();
                System.out.println(name + " notified in getConnection()");
            }
            catch(InterruptedException ie)
            {
                System.out.println(ie.getMessage());
            }
        }
        conFree = false;
        notifyAll();
    }

    public synchronized void freeConnection(String name)
    {
        System.out.println(name + " Entered freeConnection()");
        while(conFree == true)
        {
            try
            {
                wait();
            }
            catch(InterruptedException ie)
            {
                System.out.println(ie.getMessage());
            }
        }
        conFree = true;
        notifyAll();
    }
}
