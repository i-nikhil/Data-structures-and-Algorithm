package GreedyAlgorithm;

import java.util.*;

class Item
{
    int index, weight, value;
    double density;
    public Item(int index,int weight, int value)
    {
        this.index=index;
        this.weight=weight;
        this.value=value;
        this.density=value*1.0/weight;
    }
}
public class FractionalKnapsack
{
    public static void find(ArrayList<Item> list,int capacity)
    {
        //Implementing Comparator interface
        // Specify which variable(density) of Item class should be used for sorting
        Comparator<Item> c = Comparator.comparingDouble(o -> o.density);

        list.sort(c);

        int usedCapacity = 0;//used weight in knapsack
        double totalValue = 0;//cost of items taken in Knapsack
        for(int i=list.size()-1;i>=0;i--)
        {
            if(usedCapacity==capacity)//if Knapsack is full then stop
                break;
            //if full consumption possible then consume it
            if(usedCapacity+list.get(i).weight <= capacity)
            {
                usedCapacity+=list.get(i).weight;
                System.out.println("Take complete item : "+list.get(i).index);
                totalValue+=list.get(i).value;
            }
            else //else consume fractionally
            {
                int remaining = capacity - usedCapacity;
                double value = list.get(i).density*remaining;
                System.out.println("Take "+remaining+" unit of item : " + list.get(i).index);
                usedCapacity+=remaining;
                totalValue+=value;
            }

        }
        System.out.println("\nTotal Price of items in Knapsack : "+totalValue);
    }

    public static void main(String[] args)
    {
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item(1,6,6));
        list.add(new Item(2,10,2));
        list.add(new Item(3,3,1));
        list.add(new Item(4,5,8));
        list.add(new Item(5,1,3));
        list.add(new Item(6,3,5));

        find(list,5);
    }
}