package Searching;

import java.util.Scanner;

public class LinearSearch
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
        int index=linear(arr,value);
        if(index==-1)
            System.out.println("Not Found");
        else
            System.out.println("Found at index "+index);
    }

    private static int linear(int[] arr, int value)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==value)
                return i;
        }
        return -1;
    }
}
