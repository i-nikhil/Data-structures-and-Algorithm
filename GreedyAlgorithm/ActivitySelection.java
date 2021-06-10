package GreedyAlgorithm;
import java.util.*;
class Activity
{
    int start,end;
    public Activity(int start,int end)
    {
        this.start=start;
        this.end=end;
    }
}
public class ActivitySelection
{
    public static void find(ArrayList<Activity> list)
    {
        //Implementing Comparator interface
        // Specify which variable(end) of Activity class should be used for sorting
        Comparator<Activity> c = Comparator.comparingInt(o -> o.end);
        list.sort(c);//Collections.sort(c);
        Activity previous = list.get(0);
        System.out.println(list.get(0).start+" to "+list.get(0).end);
        for (int i = 1; i < list.size() ; i++)
        {
            Activity current = list.get(i);
            if (current.start >= previous.end)
            {
                System.out.println(list.get(i).start+" to "+list.get(i).end);
                previous = current;
            }
        }
    }

    public static void main(String[] args)
    {
        ArrayList<Activity> list = new ArrayList<>();
        list.add(new Activity(0,6));
        list.add(new Activity(3,4));
        list.add(new Activity(1,2));
        list.add(new Activity(5,8));
        list.add(new Activity(5,7));
        list.add(new Activity(8,9));
        find(list);
    }
}
