package GreedyAlgorithm;
import java.util.*;

public class CoinChange
{
    public static void find(int[] coins,int amt)
    {
        Arrays.sort(coins);
        int i = coins.length-1;
        while(amt>0)
        {
            int count = amt/coins[i];
            if(count>0)
            {
                System.out.println("Rs. "+coins[i]+" x "+count);
                amt-=count*coins[i];
            }
            i--;
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        find(coins,70);
        find(coins,121);
        find(coins,2045);
        find(coins,10000);
        find(coins,654321);
    }
}
