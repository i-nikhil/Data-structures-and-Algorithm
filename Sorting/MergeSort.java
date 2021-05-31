package Sorting;

import java.util.*;

public class MergeSort
{
    public static void sort(int arr[], int l, int r)
    {
        if(l<r)
        {
            int m = l+(r-l)/2;
            sort(arr,l,m);
            sort(arr,m+1,r);

            merge(arr,l,m,r);
        }
    }

    private static void merge(int arr[],int l,int m,int r)
    {
        int n1=m-l+1, n2=r-m;

        int L[]=new int[n1];
        int R[]=new int[n2];

        for(int i=0;i<n1;i++)
            L[i]=arr[l+i];
        for(int i=0;i<n2;i++)
            R[i]=arr[m+1+i];

        int i=0,j=0,k=l;
        while (i<n1 && j<n2)
        {
            if(L[i]<=R[j])
            {
                arr[k]=L[i];
                i++;
            }
            else
            {
                arr[k]=R[j];
                j++;
            }
            k++;
        }

        //copy remaining elements of L[] and R[] if any

        while (i<n1)
        {
            arr[k]=L[i];
            i++;
            k++;
        }

        while (j<n2)
        {
            arr[k]=R[j];
            j++;
            k++;
        }
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
