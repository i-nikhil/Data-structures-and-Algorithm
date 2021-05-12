package Stack;
import java.util.*;
public class Stack
{
    //top reference
    private Node top;
    private int size;
    class Node
    {
        int data;
        Node next;

        //creating new node
        Node(int d)
        {
            data=d;
            next=null;
        }
    }

    //pushing element in the stack
    public void push(int data)
    {
        Node new_node = new Node(data);
        new_node.next=top;
        top=new_node;
        size++;
    }

    //popping elements from a stack
    public int pop()
    {
        if(isEmpty())
        {
            System.out.println("Underflow Situation");
            return -1;
        }
        int result = top.data;
        top=top.next;
        size--;
        return result;
    }

    //peeking the top
    public int peek()
    {
        if(isEmpty())
        {
            System.out.println("Stack is Empty");
            return -1;
        }
        return top.data;
    }

    //check if the stack is empty or not
    public boolean isEmpty()
    {
        if(top==null)
            return true;
        return false;
    }

    //printing the elements of the stack
    public void printStack()
    {
        if(isEmpty())
        {
            System.out.println("Stack is Empty");
            return;
        }
        Node temp = top;
        while (temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    //return the size of stack
    public int getSize()
    {
        return size;
    }


    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        //creation of Double Circular linked list
        Stack s=new Stack();

        while(true)
        {
            System.out.println("_________________________________________");
            System.out.println("ENTER YOUR CHOICE FOR STACK OPERATIONS");
            System.out.println("	PRESS 1 FOR PUSH	");
            System.out.println("	PRESS 2 FOR POP	");
            System.out.println("	PRESS 3 FOR PEEK");
            System.out.println("	PRESS 4 FOR CHECK EMPTY	");
            System.out.println("	PRESS 5 PRINT STACK ELEMENTS");
            System.out.println("    PRESS 6 TO GET SIZE OF STACK");
            System.out.println("	PRESS 7 TO DELETE STACK AND EXIT");
            System.out.println("__________________________________________");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:System.out.print("Enter Element:");
                    s.push(sc.nextInt());
                    break;
                case 2:System.out.println(s.pop()+" popped");
                    break;
                case 3:System.out.println("Top = "+s.peek());
                    break;
                case 4:System.out.println(s.isEmpty()==true?"Stack is Empty":"Stack is not empty");
                    break;
                case 5:s.printStack();
                    break;
                case 6:System.out.println("Size of Stack = "+s.getSize());
                    break;
                case 7:s=null;
                    System.exit(0);
                    break;
                default:System.out.println("Wrong Choice:");
            }
        }

    }
}
