package Queue;

import java.util.Scanner;

public class Queue
{
    //first node reference
    private Node front;

    //last node reference
    private Node rear;

    //size of queue
    int size;

    public class Node
    {
        int data;
        Node next;

        //creation of node
        Node(int d)
        {
            data=d;
            next=null;
        }
    }

    //return the size of queue
    public int getSize()
    {
        return size;
    }

    //check if stack is empty or not
    public boolean isEmpty()
    {
        return getSize()==0;
    }

    //insert element in a queue
    public void enQueue(int data)
    {
        Node new_node=new Node(data);
        if(isEmpty())
        {
            front=new_node;
            rear=new_node;
        }
        else
        {
            rear.next=new_node;
            rear=new_node;
        }
        size++;
    }

    //remove element from queue
    public int deQueue()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty");
            return -1;
        }
        int result = front.data;
        front=front.next;
        if(front==null)
            rear=null;
        size--;
        return result;
    }

    //peek front of queue
    public int peekFront()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty");
            return -1;
        }
        return front.data;
    }

    //peek rear of data
    public int peekRear()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty");
            return -1;
        }
        return rear.data;
    }

    //print queue elements
    public void printQueue()
    {
        //if you want to return array of elements just make the return type as int[] & activate the commented lines
        //int arr[]=new int[size];
        if(isEmpty())
        {
            System.out.println("Queue is Empty");
            return;
            //return arr;
        }
        Node temp=front;
        //int i=0;
        while (temp!=null)
        {
            //arr[i++]=temp.data;
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
        //return arr;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        //creation of Queue
        Queue q = new Queue();

        while(true)
        {
            System.out.println("_________________________________________");
            System.out.println("ENTER YOUR CHOICE FOR QUEUE OPERATIONS");
            System.out.println("	PRESS 1 FOR ENQUEUE	");
            System.out.println("	PRESS 2 FOR DEQUEUE	");
            System.out.println("	PRESS 3 FOR PEEK FRONT");
            System.out.println("	PRESS 4 FOR PEEK REAR");
            System.out.println("	PRESS 5 FOR CHECK EMPTY	");
            System.out.println("	PRESS 6 PRINT QUEUE ELEMENTS");
            System.out.println("    PRESS 7 TO GET SIZE OF QUEUE");
            System.out.println("	PRESS 8 TO DELETE QUEUE AND EXIT");
            System.out.println("__________________________________________");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:System.out.print("Enter Element:");
                    q.enQueue(sc.nextInt());
                    break;
                case 2:System.out.println(q.deQueue()+" deQueued");
                    break;
                case 3:System.out.println("Front = "+q.peekFront());
                    break;
                case 4:System.out.println("Rear = "+q.peekRear());
                    break;
                case 5:System.out.println(q.isEmpty()?"Queue is Empty":"Queue is not empty");
                    break;
                case 6:q.printQueue();
                    break;
                case 7:System.out.println("Size of Queue = "+q.getSize());
                    break;
                case 8:q=null;
                    System.exit(0);
                    break;
                default:System.out.println("Wrong Choice");
            }
        }
    }
}
