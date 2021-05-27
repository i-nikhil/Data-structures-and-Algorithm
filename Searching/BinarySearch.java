package Searching;

import java.util.*;

public class BinarySearch
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println("Enter value to be searched: ");
        int value=sc.nextInt();
        int index=Binary(arr,value);
        if(index==-1)
            System.out.println("Not Found");
        else
            System.out.println("Found at index "+index);
    }

    private static int Binary(int[] arr, int value)
    {
        //Arrays.sort(arr);
        int l=0, r=arr.length-1,mid;
        while (l<=r)
        {
            mid = l+(r-l)/2;
            if(arr[mid]==value)
                return mid;
            else if(arr[mid]<value)
                l=mid+1;
            else
                r=mid-1;
        }
        return -1;
    }
}
