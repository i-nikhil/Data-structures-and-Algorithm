package DynamicProgramming;

public class Fibonacci
{
    public static int topDown(int n,int[] fib)
    {
        if(n<1)
            return -1;
        else if(n==1)
            return 0;
        else if(n==2)
            return 1;
        if(fib[n]==0)
            fib[n] = topDown(n-1,fib)+topDown(n-2,fib);
        return fib[n];
    }

    public static int bottomUp(int n)
    {
        if(n<1)
            return -1;
        else if(n==1)
            return 0;
        else if(n==2)
            return 1;
        int[] fib = new int[n+1];
        fib[1]=0;
        fib[2]=1;
        for(int i=3;i<=n;i++)
            fib[i]=fib[i-1]+fib[i-2];
        return fib[n];
    }
    public static void main(String[] args)
    {
        int n = 6;
        int[] arr = new int[n+1];
        System.out.println(topDown(n,arr));

        System.out.println(bottomUp(n));
    }
}
