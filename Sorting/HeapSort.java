package Sorting;

import BinaryHeap.MinHeap;

import java.util.*;

public class HeapSort
{
    public static void sort(int arr[])
    {
        MinHeap h=new MinHeap(arr.length);
        for(int i=0;i<arr.length;i++)
            h.insert(arr[i]);
        for(int i=0;i<arr.length;i++)
            arr[i]=h.extractMinimum();
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
