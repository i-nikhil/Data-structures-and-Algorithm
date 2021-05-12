package LinkedList;

import java.util.*;
class DoubleCircularLinkedList
{
    //head reference
    private Node head;

    //tail reference
    private Node tail;

    class Node
    {
        int data;
        Node next;
        Node prev;

        //creation of node
        Node(int d)
        {
            data=d;
            next=null;
            prev=null;
        }
    }

    //insertion of element at front
    public void push(int data)
    {
        Node new_node=new Node(data);
        if(head==null)
        {
            head=new_node;
            tail=new_node;
            tail.next=head;
            head.prev=tail;
            return;
        }
        new_node.next=head;
        head.prev=new_node;
        head=new_node;
        tail.next=new_node;
        new_node.prev=tail;
    }

    //insertion of element at end
    public void append(int data)
    {
        Node new_node=new Node(data);
        if(head==null)
        {
            head=new_node;
            tail=new_node;
            tail.next=head;
            head.prev=tail;
            return;
        }
        tail.next=new_node;
        new_node.prev=tail;
        tail=new_node;
        tail.next=head;
        head.prev=tail;
    }

    //insertion after a value
    public void insertAfter(int key,int data)
    {
        if(head==null)
            return;
        Node new_node=new Node(data);
        if(tail.data==key)
        {
            tail.next=new_node;
            new_node.prev=tail;
            tail=new_node;
            tail.next=head;
            head.prev=tail;
            return;
        }
        Node A = head, B = head.next;
        while(A!=tail && A.data!=key)
        {
            A=B;
            B=B.next;
        }
        A.next=new_node;
        new_node.prev=A;
        new_node.next=B;
        B.prev=new_node;
    }

    //delete first matching element
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
            head.prev=tail;
            return;
        }
        Node temp=head,prev=null;
        while(temp!=tail && temp.data!=key)
        {
            prev=temp;
            temp=temp.next;
        }
        if(temp!=tail)//found at middle
        {
            prev.next=temp.next;
            temp.next.prev=prev;
        }
        else if(temp==tail && temp.data==key)//Found at tail
        {
            prev.next=temp.next;
            temp.next.prev=prev;
            tail=prev;
        }
        else
            System.out.println("Not Found");
    }

    //delete element at an index
    public void deleteIndex(int position)
    {
        if(head==null)
            return;

        if(position==0 && head==tail)
        {
            head=null;
            tail=null;
            return;
        }
        if(position==0)
        {
            head=head.next;
            tail.next=head;
            head.prev=tail;
            return;
        }
        Node temp=head.next,prev=head;
        int count = 1;
        while(temp!=head && count!=position)
        {
            prev=temp;
            temp=temp.next;
            count+=1;
        }
        if(temp==head)//invalid index
            return;
        else if(temp==tail)//at tail
        {
            prev.next=temp.next;
            temp.next.prev=prev;
            tail=prev;
        }
        else//in middle
        {
            prev.next=temp.next;
            temp.next.prev=prev;
        }
    }

    //search first matching element
    public void searchElement(int key)
    {
        if(head==null)
        {
            System.out.println("Not Found");
            return;
        }
        Node last = head;
        int count = 0;
        while(last!=tail && last.data!=key)
        {
            last=last.next;
            count+=1;
        }
        if(last!=tail)//found at middle
            System.out.println("Found at index "+count);
        else if(last==tail && last.data==key)//found at tail
            System.out.println("Found at index "+count);
        else
            System.out.println("Not Found");
    }

    //traversing the list
    public void printList()
    {
        if(head==null)
            return;
        Node node=head;
        while(node!=tail)
        {
            System.out.print(" "+node.data);
            node=node.next;
        }
        System.out.println(" "+node.data);
    }

    //reverse traversing the list
    public void reversePrint()
    {
        if(head==null)
            return;
        Node node=tail;
        while(node!=head)
        {
            System.out.print(" "+node.data);
            node=node.prev;
        }
        System.out.println(" "+node.data);
    }

    //main block
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        //creation of Double Circular linked list
        DoubleCircularLinkedList li=new DoubleCircularLinkedList();

        while(true)
        {
            System.out.println("_____________________________________________");
            System.out.println("ENTER YOUR CHOICE FOR DOUBLE CIRCULAR LINKED LIST OPERATIONS");
            System.out.println("	PRESS 1 FOR INSERTING AT FRONT	");
            System.out.println("	PRESS 2 FOR INSERTING AT END	");
            System.out.println("	PRESS 3 FOR INSERTING AFTER ELEMENT");
            System.out.println("	PRESS 4 FOR DELETING AN ELEMENT	");
            System.out.println("	PRESS 5 FOR DELETING FROM A INDEX");
            System.out.println("	PRESS 6 FOR DISPLAYING THE LIST	");
            System.out.println("	PRESS 7 FOR REVERSE DISPLAYING THE LIST	");
            System.out.println("	PRESS 8 FOR SEARCHING AN ELEMENT");
            System.out.println("	PRESS 9 TO DELETE LIST AND EXIT");
            System.out.println("______________________________________________");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:System.out.print("Enter Element:");
                    li.push(sc.nextInt());
                    break;
                case 2:System.out.print("Enter Element:");
                    li.append(sc.nextInt());
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
                case 7:li.reversePrint();
                    break;
                case 8:System.out.print("Enter Element:");
                    li.searchElement(sc.nextInt());
                    break;
                case 9:li=null;
                    System.exit(0);
                    break;
                default:System.out.println("Wrong Choice:");
            }
        }
    }
}
