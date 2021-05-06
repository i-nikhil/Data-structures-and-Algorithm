package Array;

import java.util.*;

public class OneDimensionArray
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        //static declaration and intialization
        int arr1[]={1,2,3,4,5};

        for(int i = 0;i < arr1.length;i++)
            System.out.println(arr1[i]);

        System.out.println("Enter size of array:");
        int n=sc.nextInt();

        //dynamic declaration
        char arr2[]=new char[n];

        //toString() is a predefined function present in the Arrays class to print 1D array elements
        System.out.println(Arrays.toString(arr2));

        //dynamic initialization
        for(int i = 0;i < arr2.length;i++)
            arr2[i]=sc.next().charAt(0);

        //traversing
        for(int i = 0;i < arr2.length;i++)
            System.out.println(arr2[i]);

        //accessing a element
        System.out.println(arr1[4]);

        //searching
        for(int i = 0;i < arr2.length;i++)
        {
            if(arr2[i]=='a')
            {
                System.out.println("Found at index"+i);
                break;
            }
        }
    }
}
