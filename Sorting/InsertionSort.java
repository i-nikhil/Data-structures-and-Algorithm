package Sorting;

import java.util.*;

public class InsertionSort
{
    public static void insertion(int arr[])
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
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        insertion(arr);
        System.out.println(Arrays.toString(arr));
    }
}
