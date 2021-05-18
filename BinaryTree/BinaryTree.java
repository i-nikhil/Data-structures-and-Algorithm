package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree
{
    //root node reference
    Node root;

    public class Node
    {
        Node left,right;
        int data;

        //creation of node
        Node(int d)
        {
            data=d;
            left=right=null;
        }
    }

    //pre order traversal
    public void preOrder(Node root)
    {
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //in order traversal
    public void inOrder(Node root)
    {
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    //post order traversal
    public void postOrder(Node root)
    {
        if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    //level order traversal
    public void levelOrder()
    {
        if(root==null)
            return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);//enQueue
        while (!q.isEmpty())
        {
            Node temp=q.remove();//deQueue
            System.out.print(temp.data+" ");
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
            /*correction was at this point
              in place of q.add(temp.right)
              q.add(temp.left), was adding
              root.left and root.right, now
              its working fine :)*/
        }
    }

    //searching element in tree
    public void searchValue(int value)
    {
        if(root==null)
        {
            System.out.print("Tree is Empty");
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);//enQueue
        while (!q.isEmpty())
        {
            Node temp=q.remove();//deQueue
            if(temp.data==value)
            {
                System.out.println("Value Found");
                return;
            }
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        System.out.println("Value Not Found");
    }

    //insert a node at the deepest place in tree
    public void insert(int value)
    {
        Node new_node=new Node(value);
        if(root==null)
        {
            root=new_node;
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);//enQueue
        while (!q.isEmpty())
        {
            Node temp = q.remove();//deQueue
            if(temp.left==null)
            {
                temp.left=new_node;
                return;
            }
            if(temp.right==null)
            {
                temp.right=new_node;
                return;
            }
            else
            {
                q.add(temp.left);
                q.add(temp.right);
            }
        }
    }

    //delete node from binary tree
    public void deleteNode(int value)
    {
        if(root==null)
        {
            System.out.print("Tree is Empty");
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);//enQueue
        while (!q.isEmpty())
        {
            Node temp=q.remove();//deQueue
            //if node is found then copy data of deepest node here and delete the deepest node
            if(temp.data==value)
            {
                temp.data=deleteDeepestNode();
                return;
            }
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        System.out.println("Value Not Found");
    }

    //delete and return deepest node data
    public int deleteDeepestNode()
    {
        if(root==null)
        {
            System.out.print("Tree is Empty");
            return -1;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);//enQueue
        Node previous,current=null;
        int result=0;
        while (!q.isEmpty())
        {
            previous=current;
            current=q.remove();//deQueue
            if(current.left==null)
            {
                result=previous.right.data;
                previous.right=null;
                return result;
            }
            else if(current.right==null)
            {
                result=current.left.data;
                current.left=null;
                return result;
            }
            q.add(current.left);
            q.add(current.right);
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        //creation of Binary Tree
        BinaryTree b=new BinaryTree();

        while(true)
        {
            System.out.println("\n_______________________________________");
            System.out.println("ENTER YOUR CHOICE FOR TREE OPERATIONS");
            System.out.println("	PRESS 1 FOR INSERT VALUE AT DEEP");
            System.out.println("	PRESS 2 FOR PRE ORDER TRAVERSAL	");
            System.out.println("	PRESS 3 FOR IN ORDER TRAVERSAL");
            System.out.println("	PRESS 4 FOR POST ORDER TRAVERSAL");
            System.out.println("	PRESS 5 FOR LEVEL ORDER TRAVERSAL");
            System.out.println("	PRESS 6 TO SEARCH A VALUE");
            System.out.println("    PRESS 7 TO DELETE A NODE");
            System.out.println("	PRESS 8 TO DELETE TREE AND EXIT");
            System.out.println("________________________________________");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:System.out.print("Enter Element: ");
                    b.insert(sc.nextInt());
                    break;
                case 2:b.preOrder(b.root);
                    break;
                case 3:b.inOrder(b.root);
                    break;
                case 4:b.postOrder(b.root);
                    break;
                case 5:b.levelOrder();
                    break;
                case 6:System.out.print("Enter element to be searched: ");
                    b.searchValue(sc.nextInt());
                    break;
                case 7:System.out.print("Enter element to be deleted: ");
                    b.deleteNode(sc.nextInt());
                    break;
                case 8:b.root=null;
                    System.exit(0);
                    break;
                default:System.out.println("Wrong Choice:");
            }
        }
    }
}
