package Array;

import java.util.Scanner;

public class DoubleDimesionArray
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        int arr[][]={{1,2},{2,3},{5,8}};//3x2 array

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<2;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
        System.out.print("Enters no. of rows and columns");
        int rows=sc.nextInt();
        int columns=sc.nextInt();
        double array[][]=new double[rows][columns];

        //inserting values in array
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
                array[i][j]=sc.nextDouble();
            System.out.println();
        }

        //traversing array
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
                System.out.print(array[i][j]+" ");
            System.out.println();
        }

        //Accessing element
        System.out.print(arr[0][0]);
    }
}
