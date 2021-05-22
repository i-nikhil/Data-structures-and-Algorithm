package AVLTree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class AvlTree
{
    //root node reference
    Node root;

    public class Node
    {
        Node left,right;
        int data,height;

        //creation of node
        Node(int d)
        {
            data=d;
            left=right=null;
        }
    }

    //searching a value in AVL Tree
    public void search(Node root,int value)
    {
        if(root==null)
        {
            System.out.println("Value Not Found");
            return;
        }
        else if(root.data==value)
        {
            System.out.println("Value Found");
            return;
        }
        else if(value<root.data)
        {
            search(root.left,value);
            return;
        }
        else
        {
            search(root.right,value);
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
    //ascending order traversal
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
        }
    }

    //reverse inorder traversal
    //descending order traversal
    public void reverseInOrder(Node root)
    {
        if(root==null)
            return;
        reverseInOrder(root.right);
        System.out.print(root.data+" ");
        reverseInOrder(root.left);
    }

    //calculate the height of a node
    private int calculateHeight(Node root)
    {
        if(root==null)
            return 0;
        return 1 + Math.max(root.left!=null?root.left.height:-1 , root.right!=null?root.right.height:-1);
    }

    //right rotate
    private Node rightRotate(Node current)
    {
        Node newRoot=current.left;
        current.left=current.left.right;
        newRoot.right=current;
        current.height=calculateHeight(current);
        newRoot.height=calculateHeight(newRoot);
        return newRoot;
    }

    //left rotate
    private Node leftRotate(Node current)
    {
        Node newRoot=current.right;
        current.right=current.right.left;
        newRoot.left=current;
        current.height=calculateHeight(current);
        newRoot.height=calculateHeight(newRoot);
        return newRoot;
    }

    //insert a node in AVL Tree
    public Node insert(Node current,int value)
    {
        if(current==null)
            return new Node(value);
        else if(value<=current.data)
            current.left=insert(current.left,value);
        else
            current.right=insert(current.right,value);

        //If node is not balanced, apply rotations according to LL, LR, RR, RL conditions
        int balance = checkBalance(current.left,current.right);
        if(balance>1)//left is overloaded
        {
            if(checkBalance(current.left.left,current.left.right)>0)//LL condition
                current=rightRotate(current);
            else //LR condition
            {
                current.left=leftRotate(current.left);
                current=rightRotate(current);
            }
        }
        else if(balance<-1)//Right is overloaded
        {
            if(checkBalance(current.right.left,current.right.right)>0)//RR condition
                current=leftRotate(current);
            else //RL condition
            {
                current.right=rightRotate(current.right);
                current=leftRotate(current);
            }
        }
        if(current.left!=null)
            current.left.height=calculateHeight(current.left);
        if(current.right!=null)
            current.right.height=calculateHeight(current.right);
        current.height=calculateHeight(current);
        return current;
    }

    //helper function to check balance
    private int checkBalance(Node rootLeft, Node rootRight)
    {
        if(rootLeft ==null && rootLeft == null)//leaf node
            return 0;
        else if(rootLeft==null)//if left node is null
            return -1 - rootRight.height;
        else if(rootRight==null)//if right node is null
            return rootLeft.height + 1;
        else//none of the node is null
        return rootLeft.height - rootRight.height;
    }

    // Get minimum element node in AVL Tree
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

    //deleting a node from the AVL Tree
    public Node deleteNode(Node current, int value)
	{
		if (current == null)
		{
			System.out.println("Value not found");
			return null;
		}

		if (value < current.data)
		    current.left=deleteNode(current.left, value);
		else if (value > current.data)
		    current.right=deleteNode(current.right, value);
		else // If currentNode is the node to be deleted
		{
			if (current.left != null && current.right != null) // if nodeToBeDeleted have both children
			{
				Node temp = current;
				Node minimumFromRight = getMinimum(temp.right);
				current.data=minimumFromRight.data;
				current.right=deleteNode(current.right, minimumFromRight.data);
			}
			else if (current.left != null) // if nodeToBeDeleted has only left child
			    current = current.left;
			else if (current.right != null) // if nodeToBeDeleted has only right child
			    current = current.right;
			else // if nodeToBeDeleted do not have child (Leaf node)
				current = null;
            return current;
		}

		//If not balanced, apply rotation according to LL, LR, RR, RL conditions
        int balance = checkBalance(current.left, current.right);
        if (balance > 1) //Left is Overloaded
        {
            if (checkBalance(current.left.left, current.left.right) > 0)// LL Condition
                current = rightRotate(current);
            else// LR Condition
            {
                current.left = leftRotate(current.left);
                current = rightRotate(current);
            }
        }
        else if (balance < -1) //Right is Overloaded
        {
            if (checkBalance(current.right.right, current.right.left) > 0)// RR Condition
                current = leftRotate(current);
            else// RL Condition
            {
                current.right = rightRotate(current.right);
                current = leftRotate(current);
            }
        }
        if (current.left != null)
            current.left.height = calculateHeight(current.left);
        if (current.right != null)
            current.right.height = calculateHeight(current.right);
        current.height = calculateHeight(current);
        return current;
	}

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        //creation of AVL Tree
        AvlTree b=new AvlTree();

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
