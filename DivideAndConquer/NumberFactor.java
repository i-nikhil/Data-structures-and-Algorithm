package DivideAndConquer;

public class NumberFactor
{
    public static int ways(int N)
    {
        if(N==0||N==1||N==2)
            return 1;
        if(N==3)
            return 2;
        return ways(N-1) + ways(N-3) + ways(N-4);
    }

    public static void main(String[] args)
    {
        System.out.println(ways(4));
        System.out.println(ways(5));
        System.out.println(ways(8));
    }
}
