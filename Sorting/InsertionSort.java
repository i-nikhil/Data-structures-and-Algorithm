package Sorting;

import java.util.*;

public class InsertionSort
{
    public static int[] insertion(int arr[])
    {
        for(int i=1;i<arr.length;i++)
        {
            int temp=arr[i], j=i;
            while (j>0 && arr[j-1]>temp)
            {
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=temp;
        }
        return arr;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int sorted[]=insertion(arr);
        System.out.println(Arrays.toString(sorted));
    }
}
