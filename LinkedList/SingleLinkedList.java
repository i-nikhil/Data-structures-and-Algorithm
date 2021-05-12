package LinkedList;

import java.util.Scanner;

public class SingleLinkedList
{
    class Node
    {
        int data;
        Node next;

        //creation of node
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    //head reference
    private Node head;

    //insertion at front
    public void insertFront(int data)
    {
        Node new_node=new Node(data);
        new_node.next=head;
        head=new_node;
    }

    //insertion at end
    public void insertEnd(int data)
    {
        Node new_node=new Node(data);
        if(head==null)
        {
            head=new_node;
            return;
        }
        Node temp=head;
        while (temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=new_node;
    }

    //insertion after a value
    public void insertAfter(int key,int data)
    {
        Node new_node=new Node(data);

        if(head==null)
            return;

        Node A = head,B=head.next;
        while (A!=null && A.data!=key)
        {
            if(B==null)
                return;
            A=B;
            B=B.next;
        }
        A.next=new_node;
        new_node.next=B;
    }

    //delete 1st matching element
    public void deleteElement(int key)
    {
        Node temp=head,prev=null;
        if(head!=null && head.data==key)
        {
            head=head.next;
            return;
        }

        while (temp!=null && temp.data!=key)
        {
            prev=temp;
            temp=temp.next;
        }
        if(temp==null)
            return;
        prev.next=temp.next;

    }

    //delete at a index
    public void deleteIndex(int position)
    {
        if(head==null)
            return;
        if(position==0)
        {
            head=head.next;
            return;
        }
        Node temp=head;
        for(int i=0;temp!=null && i<position-1;i++)
            temp=temp.next;
        if(temp==null || temp.next==null)
            return;
        temp.next=temp.next.next;
    }

    //searching a element
    public void searchElement(int key)
    {
        if(head==null)
        {
            System.out.println("Not Found");
            return;
        }
        Node temp = head;
        int count = 0;

        while (temp!=null && temp.data!=key)
        {
            temp=temp.next;
            count++;
        }
        if(temp==null)
        {
            System.out.println("Not Found");
            return;
        }
        System.out.println("Found at Index "+count);
    }

    //traversing the linked list
    public void printList()
    {
        Node temp=head;
        while (temp!=null)
        {
            System.out.print(" "+temp.data);
            temp=temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        SingleLinkedList li=new SingleLinkedList();

        while (true)
        {
            System.out.println("_____________________________________________");
            System.out.println("ENTER YOUR CHOICE FOR LINKED LIST OPERATIONS");
            System.out.println("	PRESS 1 FOR INSERTING AT FRONT	");
            System.out.println("	PRESS 2 FOR INSERTING AT END	");
            System.out.println("	PRESS 3 FOR INSERTING AFTER ELEMENT");
            System.out.println("	PRESS 4 FOR DELETING AN ELEMENT	");
            System.out.println("	PRESS 5 FOR DELETING FROM A INDEX	");
            System.out.println("	PRESS 6 FOR DISPLAYING THE LIST	");
            System.out.println("	PRESS 7 FOR SEARCHING AN ELEMENT");
            System.out.println("	PRESS 8 TO DELETE LIST AND EXIT");
            System.out.println("______________________________________________");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:System.out.print("Enter Element:");
                    li.insertFront(sc.nextInt());
                    break;
                case 2:System.out.print("Enter Element:");
                    li.insertEnd(sc.nextInt());
                    break;
                case 3:System.out.print("Enter Element:");
                    int data = sc.nextInt();
                    System.out.print("Enter Key:");
                    int key = sc.nextInt();
                    li.insertAfter(key,data);
                    break;
                case 4:System.out.print("Enter Element:");
                    li.deleteElement(sc.nextInt());
                    break;
                case 5:System.out.print("Enter Index:");
                    li.deleteIndex(sc.nextInt());
                    break;
                case 6:li.printList();
                    break;
                case 7:System.out.print("Enter Element:");
                    li.searchElement(sc.nextInt());
                    break;
                case 8:li=null;
                    System.exit(0);
                    break;
                default:System.out.println("Wrong Choice:");
            }
        }
    }

}
