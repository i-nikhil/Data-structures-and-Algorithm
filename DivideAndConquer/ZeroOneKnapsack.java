package DivideAndConquer;

public class ZeroOneKnapsack
{
    public static int find(int[] p, int[] w, int capacity, int index)
    {
        if(capacity<=0 || index<0 || index>=p.length)
            return 0;

        int profit1=0;
        if(w[index]<=capacity)
            profit1 = p[index] + find(p,w,capacity-w[index],index+1);
        int profit2 = find(p,w,capacity,index+1);
        return Math.max(profit1,profit2);
    }

    public static void main(String[] args)
    {
        int[] p = {31,26,72,17};
        int[] w = {3,1,5,2};
        System.out.println(find(p,w,7,0));
    }
}
