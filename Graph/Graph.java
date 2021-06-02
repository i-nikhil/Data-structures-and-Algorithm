package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph
{
    LinkedList<Integer> l[];

    //creating adjacency list
    //creating vertices
    public Graph(int v)
    {
        l = new LinkedList[v];

        for(int i=0;i<v;i++)
            l[i] = new LinkedList<>();
    }

    //creating edges
    public void addEdge(int u,int v)
    {
        l[u].add(v);
        //l[v].add(u);//activate this part to use for undirected graph
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

    //BFS Traversal
    public void printBFS(int s)
    {
        boolean visited[]=new boolean[l.length];
        Queue<Integer> q = new LinkedList<>();
        visited[s]=true;
        q.add(s);
        while (!q.isEmpty())
        {
            s = q.remove();
            System.out.print(s+" ");
            for(int i=0;i<l[s].size();i++)
            {
                int n = l[s].get(i);
                if(!visited[n])
                {
                    visited[n]=true;
                    q.add(n);
                }
            }
        }
        System.out.println();
    }

    //DFS traversal
    public void printDFS(int s)
    {
        boolean visited[]=new boolean[l.length];
        recursiveDFS(s,visited);
        System.out.println();
    }

    //DFS utility function
    private void recursiveDFS(int s, boolean visited[])
    {
        visited[s]=true;
        System.out.print(s+" ");
        for(int i=0;i<l[s].size();i++)
        {
            int n=l[s].get(i);
            if(!visited[n])
                recursiveDFS(n,visited);
        }
    }


    public static void main(String[] args)
    {
        //directed graph
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);
        g.printGraph();
        System.out.print("BFS = ");
        g.printBFS(2);


        //undirected graph
        Graph g1 = new Graph(6);
        g1.addEdge(0,1);
        g1.addEdge(0,2);
        g1.addEdge(1,3);
        g1.addEdge(2,4);
        g1.addEdge(3,5);
        g1.addEdge(4,5);
        g1.addEdge(1,4);
        g1.addEdge(3,4);
        g1.printGraph();
        System.out.print("BFS = ");
        g1.printBFS(0);


        g.printGraph();
        System.out.print("DFS = ");
        g.printDFS(2);

        g1.printGraph();
        System.out.print("DFS = ");
        g1.printDFS(0);

    }
}
