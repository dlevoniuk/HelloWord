public class TestHelloWord
{
    public static void main (String[] arg)
    {
        int test = 10;
        float test1 = 123f;
        System.out.println("Hello word" + test);

        try (TestResourcesFree resources = new TestResourcesFree())
        {
            resources.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        TestStaticConstructor.GetInstanse().Execute("Test1");
        System.out.println("Completed");
    }
}

class TestStaticConstructor
{
    private static TestStaticConstructor _instance = new TestStaticConstructor();

    protected TestStaticConstructor()
    {
        System.out.println("Constructor");
    }

    public static TestStaticConstructor GetInstanse()
    {
        return _instance;
    }

    public void Execute(String input)
    {
        switch (input)
        {
            case "Test1":
            {
                System.out.println("Test1");
            }
            default:
            {
                System.out.println("Default");
            }
        }
        System.out.println("Execute");
    }
}

class TestResourcesFree implements java.lang.AutoCloseable
{
    public void execute() throws Exception
    {
        throw new Exception();
    }

    public void close() throws Exception
    {
        System.out.println("Completed");
    }
}
