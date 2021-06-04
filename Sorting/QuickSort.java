package Sorting;

import java.util.*;

public class QuickSort
{
    public static void sort(int arr[], int l, int r)
    {
        if(l<r)
        {
            int pivot=partition(arr,l,r);
            sort(arr,l,pivot-1);
            sort(arr,pivot+1,r);
        }
    }

    private static int partition(int arr[], int l, int r)
    {
        int pivot = r;//let last element be pivot
        int i = l-1;//let it be null initially
        for (int j=l;j<=r;j++)
        {
            if(arr[j]<=arr[pivot])
            {
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        return i;//since i is the updated pivot after all swaps
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        sort(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
    }
}
