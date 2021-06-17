package DynamicProgramming;

public class NumberFactor
{
    public static int topDown(int N, int[] dp)
    {
        if(N==0||N==1||N==2)
            return 1;
        if(N==3)
            return 2;
        if(dp[N]==0)
            dp[N]=topDown(N-1,dp) + topDown(N-3,dp) + topDown(N-4,dp);
        return dp[N];
    }

    public static int bottomUp(int N)
    {
        if(N==0||N==1||N==2)
            return 1;
        if(N==3)
            return 2;
        int[] dp =new int[N+1];
        dp[0]=dp[1]=dp[2]=1;
        dp[3]=2;
        for(int i=4;i<=N;i++)
            dp[i]=dp[i-1]+dp[i-3]+dp[i-4];
        return dp[N];
    }
    public static void main(String[] args)
    {
        int n=8;
        int[] arr =new int[n+1];
        System.out.println(topDown(n,arr));

        System.out.println(bottomUp(n));
    }
}
