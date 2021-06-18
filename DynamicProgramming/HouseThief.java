package DynamicProgramming;

public class HouseThief
{
    public static int topDown(int[] dp,int[] house,int index)
    {
        if(index >= house.length)
            return 0;
        if(dp[index]==0)
        {
            int steal = house[index] + topDown(dp,house,index+2);
            int skip = topDown(dp,house,index+1);
            dp[index]= Math.max(steal,skip);
        }
        return dp[index];
    }
    public static int BottomUp(int[] house)
    {
        int[]  dp = new int[house.length+2];
        //to take zero for first two invalid house
        for(int i=house.length-1;i>=0;i--)
            dp[i]=Math.max(house[i]+dp[i+2],dp[i+1]);
        return dp[0];
    }
    public static void main(String[] args)
    {
        int[] house={6,7,1,30,8,2,4};
        int[] arr=new int[house.length];
        System.out.println(topDown(arr,house,0));

        System.out.println(BottomUp(house));
    }
}
