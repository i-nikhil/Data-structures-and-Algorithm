package DynamicProgramming;

public class ZeroOneKnapsack
{
    public static int topDown(Integer[][] dp,int[] p, int[] w, int capacity, int index)
    {
        if(capacity<=0 || index<0 || index>=p.length)
            return 0;

        if(dp[index][capacity]==null)
        {
            int profit1=0;
            if(w[index]<=capacity)
                profit1 = p[index] + topDown(dp,p,w,capacity-w[index],index+1);
            int profit2 = topDown(dp,p,w,capacity,index+1);
            dp[index][capacity]=Math.max(profit1,profit2);
        }
        return dp[index][capacity];
    }

    public static int bottomUp(int[] p, int[] w, int capacity)
    {
        if (capacity <= 0 || p.length == 0 || w.length != p.length)
            return 0;
        int numberOfRows = p.length + 1;// adding 1 row to avoid array index issues
        int[][] dp = new int[numberOfRows][capacity + 1];

        for (int i = 0; i < numberOfRows; i++) // Insert 0 in 1st dummy column
            dp[i][0] = 0;
        for (int i = 0; i <= capacity; i++) // Insert 0 in last dummy row
            dp[numberOfRows - 1][i] = 0;

        for (int row = numberOfRows - 2; row >= 0; row--)
        {
            for (int column = 1; column <= capacity; column++)
            {
                int profit1 = 0;
                if (w[row] <= column) // column represents current capacity
                    profit1 = p[row] + dp[row + 1][column - w[row]];  // Taking current element
                int profit2 = dp[row + 1][column]; // Not taking current element
                dp[row][column] = Math.max(profit1, profit2);
            }
        }
        return dp[0][capacity];
    }
    public static void main(String[] args)
    {
        int[] p = {31,26,72,17};
        int[] w = {3,1,5,2};
        int capacity=7;
        Integer[][] dp = new Integer[p.length][capacity+1];
        System.out.println(topDown(dp,p,w,capacity,0));

        System.out.println(bottomUp(p,w,capacity));
    }
}
