package Hashing;

import java.util.*;
public class DoubleHashing
{
    String[] hashTable;
    int usedCells;


    //Empty array is created
    DoubleHashing(int length)
    {
        hashTable = new String[length];
        usedCells = 0;
    }

    //HashFunction to be used on Keys
    private int hashFunction(String x, int m)
    {
        char[] ch = x.toCharArray();
        int sum = 0;
        for (int i = 0; i < x.length(); i++)
            sum += ch[i];
        return sum % m;
    }

    //2nd Hash Function
    private int secondHashFunction(String x, int m)
    {
        char[] ch = x.toCharArray();
        int sum = 0;
        for (int i = 0; i < x.length(); i++)
        {
            if(ch[i]%2==0)
                sum += (2*ch[i]);
            else
                sum += (3*ch[i]);
        }
        return sum % m;
    }

    // Insert key in HashTable
    public void insert(String value)
    {
        double loadFactor = usedCells * 1.0 / hashTable.length;
        if (loadFactor >= 0.75)
            rehashKeys(value);
        else
        {
            int x = hashFunction(value, hashTable.length);
            int y = secondHashFunction(value, hashTable.length);
            for (int i = 0; i < hashTable.length; i++)
            {
                int newIndex = (x + i * y) % hashTable.length;
                // If there is a collision then we go to the next index
                // and keep going till we reach starting index.
                if (hashTable[newIndex] == null)
                {
                    hashTable[newIndex] = value;
                    usedCells+=1;
                    return;
                }
            }
        }
    }

    //Creates a new HashTable and does ReHashing
    private void rehashKeys(String newStringToBeInserted)
    {
        usedCells = 0; //reset it as we are now dealing with fresh HashTable
        ArrayList<String> data = new ArrayList<>();
        for (String s : hashTable)
        {
            if (s != null)
                data.add(s);
        }
        data.add(newStringToBeInserted);

        hashTable = new String[hashTable.length * 2]; // make new table with double size
        for (String s : data) // push all old data into new table
            insert(s);
    }


    //Search for a given key in hashTable
    public void search(String value)
    {
        int index = hashFunction(value, hashTable.length);
        for (int i = index; i < index + hashTable.length; i++)
        {
            int newIndex = i % hashTable.length;
            if (hashTable[newIndex]!=null && hashTable[newIndex].equals(value))
            {
                System.out.println("Found at index: "+newIndex);
                return;
            }
        }
        System.out.println("Not found");
    }


    //Delete key from HashTable
    public void delete(String value)
    {
        int index = hashFunction(value, hashTable.length);
        for (int i = index; i < index + hashTable.length; i++)
        {
            int newIndex = i % hashTable.length;
            if (hashTable[newIndex]!=null && hashTable[newIndex].equals(value))
            {
                hashTable[newIndex] = null;
                return;
            }
        }
        System.out.println("Not found");
    }

    // Display the hash table
    public void display()
    {
        for (int i = 0; i < hashTable.length; i++)
        {
            //if(hashTable[i]!=null)
            System.out.println(i+" - "+hashTable[i]);
        }
    }

    //Deletes entire HashTable
    public void deleteHashTable()
    {
        hashTable = null;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length: ");
        DoubleHashing h = new DoubleHashing(sc.nextInt());

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