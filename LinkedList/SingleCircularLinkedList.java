package LinkedList;
import java.util.*;

public class SingleCircularLinkedList
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
    Node head;

    //tail reference
    Node tail;

    //insertion at front
    public void insertFront(int data)
    {
        Node new_node=new Node(data);

        if(head==null)
        {
            head=new_node;
            tail=new_node;
            tail.next=head;
            return;
        }
        new_node.next=head;
        head=new_node;
        tail.next=new_node;
    }

    //insertion at end
    public void insertEnd(int data)
    {
        Node new_node=new Node(data);
        if(head==null)
        {
            head=new_node;
            tail=new_node;
            tail.next=head;
            return;
        }
        tail.next=new_node;
        tail=new_node;
        tail.next=head;
    }

    //insertion after a value
    public void insertAfter(int key,int data)
    {
        Node new_node=new Node(data);

        if(head==null)
            return;

        if(tail.data==key)
        {
            tail.next=new_node;
            tail=new_node;
            tail.next=head;
            return;
        }
        Node A = head,B=head.next;
        while (A!=tail && A.data!=key)
        {
            A=B;
            B=B.next;
        }
        A.next=new_node;
        new_node.next=B;
    }

    //delete 1st matching element
    public void deleteElement(int key)
    {
        if(head==null)
            return;

        if(head==tail && head.data==key)
        {
            head=null;
            tail=null;
            return;
        }

        if(head.data==key)
        {
            head=head.next;
            tail.next=head;
            return;
        }

        Node temp=head,prev=null;

        while (temp!=tail && temp.data!=key)
        {
            prev=temp;
            temp=temp.next;
        }
        if(temp!=tail)//element is in middle
        {
            prev.next=temp.next;
        }
        else if(temp==tail && tail.data==key)//found at tail
        {
            prev.next=temp.next;
            tail=prev;
        }
        else//not found
        {
            System.out.println("Not Found");
        }
    }

    //delete at a index
    public void deleteIndex(int position)
    {
        if(head==null)
            return;
        if(position==0 && head==tail)
        {
            head=tail=null;
            return;
        }
        if(position==0)
        {
            head=head.next;
            tail.next=head;
            return;
        }
        Node prev=head,temp=head.next;
        int count=1;
        while (temp!=head && count!=position)
        {
            prev=temp;
            temp=temp.next;
            count+=1;
        }
        if(temp==head)//invalid index
        {
            return;
        }
        else if(temp==tail)//at tail
        {
            prev.next = temp.next;
            tail = prev;
        }
        else//at middle
        {
            prev.next = temp.next;
        }
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

        while (temp!=tail && temp.data!=key)
        {
            temp=temp.next;
            count++;
        }
        if(temp!=tail)//found at middle
            System.out.println("Found at index "+count);
        else if(temp==tail && temp.data==key)//found at tail
            System.out.println("Found at index "+count);
        else
            System.out.println("Not Found");
    }

    //traversing the linked list
    public void printList()
    {
        if(head==null)
            return;
        Node temp=head;
        while (temp!=tail)
        {
            System.out.print(" "+temp.data);
            temp=temp.next;
        }
        System.out.println(" "+temp.data);
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        SingleCircularLinkedList li=new SingleCircularLinkedList();

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
