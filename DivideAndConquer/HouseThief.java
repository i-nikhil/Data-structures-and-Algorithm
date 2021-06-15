package DivideAndConquer;

public class HouseThief
{
    public static int find(int[] house,int index)
    {
        if(index >= house.length)
            return 0;

        int steal = house[index] + find (house,index+2);
        int skip = find(house,index+1);

        return Math.max(steal,skip);
    }

    public static void main(String[] args)
    {
        int[] house = {6,7,1,30,8,2,4};
        System.out.println(find(house,0));

        int[] house1 = {20,5,1,13,6,11,40};
        System.out.println(find(house1,0));
    }
}
