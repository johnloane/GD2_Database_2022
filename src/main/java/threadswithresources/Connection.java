package threadswithresources;

public class Connection implements Runnable
{
    private String name;
    private Resource r;

    public Connection(String name, Resource r)
    {
        this.name = name;
        this.r = r;
    }

    @Override
    public void run()
    {
        r.getConnection(name);
        //Now sleep to allow other threads to work
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie.getMessage());
        }
        r.freeConnection(name);
    }
}
