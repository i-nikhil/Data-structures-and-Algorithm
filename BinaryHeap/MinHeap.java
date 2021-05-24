package BinaryHeap;

import java.util.Scanner;

public class MinHeap
{
    private int[] arr;
    private int size;

    //constructor for creating empty Min Heap
    public MinHeap(int capacity)
    {
        //we are adding one here so that the first cell of the array can be left blank all the time
        arr = new int [capacity+1];
        size = 0;
    }

    //peek the head of the Heap
    public int peek()
    {
        if(size == 0)
        {
            System.out.println("Heap is Empty!");
            return -1;
        }
        return arr[1];
    }

    //return the size of Heap
    public int getSize()
    {
        return size;
    }

    //level order traversal
    public void levelOrder()
    {
        for(int i=1; i<=size;i++)
            System.out.print(arr[i]+" ");
    }

    //insert a new value in Heap
    public void insert(int value)
    {
        if(size == arr.length-1)
        {
            System.out.println("Heap is full!");
            return;
        }
        //doing +1 because "size" always points to the last occupied cell of the array
        arr[size+1] = value;
        size++;
        heapifyBottomToTop(size);
    }

    private void heapifyBottomToTop(int index)
    {
        int parent = index/2;

        // we are at root of the heap, hence no more heapifying is required
        if(index <= 1)
            return;

        //if current value is smaller than its parent, then we need to swap
        if(arr[index]<arr[parent])
        {
            int tmp = arr[index];
            arr[index] = arr[parent];
            arr[parent] = tmp;
        }

        heapifyBottomToTop(parent);
    }

    //Extract Head of Heap
    public int extractMinimum()
    {
        if(size == 0)
        {
            System.out.println("Heap is Empty !");
            return -1;
        }
        int extractedValue = arr[1];
        arr[1] = arr[size];
        size--;
        heapifyToptoBottom(1);
        return extractedValue;
    }

    private void heapifyToptoBottom(int index)
    {
        int left = index*2;
        int right = (index*2)+1;
        int smallestChild;

        if(size < left)//there is no child
            return;
        else if(size == left)//if there is only left child
        {
            if(arr[index]>arr[left])
            {
                int tmp = arr[index];
                arr[index]=arr[left];
                arr[left]=tmp;
            }
            return;
        }
        else//if both child are present
        {
            //find the smallest child
            if(arr[left]<arr[right])
                smallestChild=left;
            else
                smallestChild=right;
            //if parent is greater that the smallest child, we have to swap
            if(arr[index]>arr[smallestChild])
            {
                int tmp=arr[index];
                arr[index]=arr[smallestChild];
                arr[smallestChild]=tmp;
            }
        }
        heapifyToptoBottom(smallestChild);
    }

    //delete the Heap
    public void deleteHeap()
    {
        arr=null;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length: ");
        MinHeap h = new MinHeap(sc.nextInt());

        while(true)
        {
            System.out.println("\n_______________________________________");
            System.out.println("ENTER YOUR CHOICE FOR HEAP OPERATIONS");
            System.out.println("	PRESS 1 TO INSERT");
            System.out.println("	PRESS 2 TO PEEK");
            System.out.println("	PRESS 3 TO GET SIZE");
            System.out.println("	PRESS 4 FOR LEVEL ORDER TRAVERSAL");
            System.out.println("	PRESS 5 TO EXTRACT MINIMUM");
            System.out.println("	PRESS 6 TO DELETE HEAP AND EXIT");
            System.out.println("________________________________________");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:System.out.print("Enter Element: ");
                    h.insert(sc.nextInt());
                    break;
                case 2:System.out.println("Head = "+h.peek());
                    break;
                case 3:System.out.println("Size = "+h.getSize());
                    break;
                case 4:h.levelOrder();
                    break;
                case 5:System.out.println("Extracted Minimum = "+h.extractMinimum());
                    break;
                case 6:h.deleteHeap();
                    System.exit(0);
                    break;
                default:System.out.println("Wrong Choice:");
            }
        }
    }
}
