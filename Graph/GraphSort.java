package Graph;
import java.util.*;

public class GraphSort
{
    LinkedList<Integer>[] l;

    //creating adjacency list
    //creating vertices
    public GraphSort(int v)
    {
        l = new LinkedList[v];

        for(int i=0;i<v;i++)
            l[i] = new LinkedList<>();
    }

    //creating edges
    //Topological sort is only possible on Directed Acyclic Graph
    public void addEdge(int u,int v)
    {
        l[u].add(v);
    }

    //print the adjacency list
    public void printGraph()
    {
        for(int i=0;i<l.length;i++)
        {
            System.out.print("|"+i+"|");
            for(int j=0;j<l[i].size();j++)
                System.out.print("-->"+l[i].get(j));
            System.out.println();
        }
    }

    //perform topological sort
    public void topologicalSort()
    {
        Stack<Integer> stack=new Stack<>();
        boolean[] visited =new boolean[l.length];

        for(int i=0;i<l.length;i++)
        {
            if(!visited[i])
                topologicalSortUtil(i,visited,stack);
        }
        while (!stack.empty())
            System.out.print(stack.pop()+" ");
    }

    //utility recursive function used by topologicalSort()
    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack)
    {
        for(int i=0;i<l[v].size();i++)
        {
            int n=l[v].get(i);
            if(!visited[n])
                topologicalSortUtil(n,visited,stack);
        }
        visited[v]=true;
        stack.push(v);
    }

    public static void main(String[] args)
    {
        GraphSort g = new GraphSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.printGraph();
        System.out.println("Topological sort of the given graph:");
        g.topologicalSort();
    }
}
