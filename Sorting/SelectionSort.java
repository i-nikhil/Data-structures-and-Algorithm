package Sorting;

import java.util.*;

public class SelectionSort {
    public static int[] selection(int arr[])
    {
        int n=arr.length;
        for(int j=0;j<n;j++)
        {
            int minimumIndex=j;
            for(int i=j+1;i<n;i++)
            {
                if(arr[i]<arr[minimumIndex])
                    minimumIndex=i;
            }
            if(minimumIndex!=j)
            {
                int temp=arr[j];
                arr[j]=arr[minimumIndex];
                arr[minimumIndex]=temp;
            }
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
        int sorted[]=selection(arr);
        System.out.println(Arrays.toString(sorted));
    }
}
