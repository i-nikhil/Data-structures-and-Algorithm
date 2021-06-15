package GreedyAlgorithm;
import java.util.*;
class Activity
{
    int index,start,end;
    public Activity(int index,int start,int end)
    {
        this.index=index;
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
        System.out.println("Activity-"+list.get(0).index+" => "+list.get(0).start+" to "+list.get(0).end);
        for (int i = 1; i < list.size() ; i++)
        {
            Activity current = list.get(i);
            if (current.start >= previous.end)
            {
                System.out.println("Activity-"+list.get(i).index+" => "+list.get(i).start+" to "+list.get(i).end);
                previous = current;
            }
        }
    }

    public static void main(String[] args)
    {
        ArrayList<Activity> list = new ArrayList<>();
        list.add(new Activity(1,0,6));
        list.add(new Activity(2,3,4));
        list.add(new Activity(3,1,2));
        list.add(new Activity(4,5,8));
        list.add(new Activity(5,5,7));
        list.add(new Activity(6,8,9));
        find(list);
    }
}
