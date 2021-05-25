package Hashing;

import java.util.*;

public class DirectChaining
{
    LinkedList<String> []hashTable;

    //Array of Linked list references is created
    public DirectChaining(int length)
    {
        hashTable = new LinkedList[length];
    }

    //Hash function to be used on keys
    private int hashFunction(String x,int m)
    {
        char []ch = x.toCharArray();
        int sum=0;
        for (int i=0;i<x.length();i++)
            sum+=ch[i];
        return sum%m;
    }

    //insert key in Hash Table
    public void insert(String value)
    {
        int index = hashFunction(value,hashTable.length);

        if(hashTable[index]==null)
        {
            hashTable[index] = new LinkedList<>();
            hashTable[index].add(value);
        }
        else
            hashTable[index].add(value);
    }

    //search for a given value in hash table
    public void search(String value)
    {
        int index = hashFunction(value,hashTable.length);

        if(hashTable[index]!=null && hashTable[index].contains(value))
            System.out.println("Found at index: "+index);
        else
            System.out.println("Not Found");
    }

    //delete key from hash table
    public void delete(String value)
    {
        int index = hashFunction(value,hashTable.length);

        if(hashTable[index]!=null && hashTable[index].contains(value))
        {
            hashTable[index].remove(value);
        }
        else
            System.out.println("Not Found");
    }

    //display hash table
    public void display()
    {
        for(int i=0;i<hashTable.length;i++)
        {
            //if(hashTable[i]!=null)
                System.out.println(i+" - "+hashTable[i]);
        }
    }

    //delete entire hash table
    public void deleteHashTable()
    {
        hashTable=null;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length: ");
        DirectChaining h = new DirectChaining(sc.nextInt());

        while(true)
        {
            System.out.println("\n_____________________________________");
            System.out.println("ENTER YOUR CHOICE FOR HASH OPERATIONS");
            System.out.println("	PRESS 1 TO INSERT A KEY");
            System.out.println("	PRESS 2 TO SEARCH A KEY");
            System.out.println("	PRESS 3 TO DELETE A KEY");
            System.out.println("	PRESS 4 TO DISPLAY HASH TABLE");
            System.out.println("	PRESS 5 TO DELETE TABLE AND EXIT");
            System.out.println("______________________________________");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:System.out.print("Enter Element: ");
                    h.insert(sc.next());
                    break;
                case 2:System.out.print("Enter Element: ");
                    h.search(sc.next());
                    break;
                case 3:System.out.print("Enter Element: ");
                    h.delete(sc.next());
                    break;
                case 4:h.display();
                    break;
                case 5:h.deleteHashTable();
                    System.exit(0);
                default:System.out.println("Wrong Choice:");
            }
        }

    }
}
