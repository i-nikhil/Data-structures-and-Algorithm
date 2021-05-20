package BinarySearchTree;

import java.util.*;
import java.util.Queue;

public class BinarySearchTree
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

    //search an element
    public void search(Node root, int value)
    {
        if (root == null)
        {
            System.out.println("Value not found");
            return;
        }
        else if (root.data == value)
        {
            System.out.println("Value found");
            return;
        }
        else if (value < root.data)
        {
            search(root.left, value);
            return;
        }
        else
        {
            search(root.right, value);
            return;
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
    //Ascending order  BST traversal
    public void inOrder(Node root)
    {
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    //reverse in order traversal
    //Descending order  BST traversal
    public void reverseInOrder(Node root)
    {
        if(root==null)
            return;
        reverseInOrder(root.right);
        System.out.print(root.data+" ");
        reverseInOrder(root.left);
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
        while(!q.isEmpty())
        {
            Node temp=q.remove();//deQueue
            System.out.print(temp.data+" ");
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
    }

    //insert an element
    public Node insert(Node root, int key)
    {
        if (root == null)
        {
            root = new Node(key);
            return root;
        }
        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);
        return root;
    }

    // Get minimum element node in BST
    public Node getMinimum(Node root)
    {
        if(root==null)
        {
            System.out.println("Tree is empty");
            return null;
        }
        if (root.left == null)
            return root;
        else
            return getMinimum(root.left);
    }

    //delete node from BST
    public Node deleteNode(Node root, int value)
    {
        if (root == null)
        {
            System.out.println("Value not found");
            return null;
        }

        if (value < root.data)
            root.left=deleteNode(root.left, value);
        else if (value > root.data)
            root.right=deleteNode(root.right, value);
        else // If currentNode is the node to be deleted
        {
            if (root.left != null && root.right != null) // if nodeToBeDeleted have both children
            {
                Node temp = root;
                Node minimumFromRight = getMinimum(temp.right);
                root.data=minimumFromRight.data;
                root.right=deleteNode(root.right, minimumFromRight.data);
            }
            else if (root.left != null) // if nodeToBeDeleted has only left child
                root = root.left;
            else if (root.right != null) // if nodeToBeDeleted has only right child
                root = root.right;
            else // if nodeToBeDeleted do not have child (Leaf node)
                root = null;
        }
        return root;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        //creation of Binary Search Tree
        BinarySearchTree b=new BinarySearchTree();

        while(true)
        {
            System.out.println("\n_______________________________________");
            System.out.println("ENTER YOUR CHOICE FOR TREE OPERATIONS");
            System.out.println("	PRESS 1 TO INSERT VALUE");
            System.out.println("	PRESS 2 FOR PRE ORDER TRAVERSAL	");
            System.out.println("	PRESS 3 FOR IN ORDER TRAVERSAL");
            System.out.println("	PRESS 4 FOR POST ORDER TRAVERSAL");
            System.out.println("	PRESS 5 FOR LEVEL ORDER TRAVERSAL");
            System.out.println("	PRESS 6 FOR PRINT ASCENDING ORDER");
            System.out.println("	PRESS 7 FOR PRINT DESCENDING ORDER");
            System.out.println("	PRESS 8 TO SEARCH A VALUE");
            System.out.println("    PRESS 9 TO DELETE A NODE");
            System.out.println("	PRESS 10 TO DELETE TREE AND EXIT");
            System.out.println("________________________________________");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:System.out.print("Enter Element: ");
                    b.root=b.insert(b.root,sc.nextInt());
                    break;
                case 2:b.preOrder(b.root);
                    break;
                case 3:b.inOrder(b.root);
                    break;
                case 4:b.postOrder(b.root);
                    break;
                case 5:b.levelOrder();
                    break;
                case 6:b.inOrder(b.root);
                    break;
                case 7:b.reverseInOrder(b.root);
                    break;
                case 8:System.out.print("Enter value to be searched: ");
                    b.search(b.root,sc.nextInt());
                    break;
                case 9:System.out.print("Enter element to be deleted: ");
                    b.root=b.deleteNode(b.root,sc.nextInt());
                    break;
                case 10:b.root=null;
                    System.exit(0);
                    break;
                default:System.out.println("Wrong Choice:");
            }
        }
    }
}
