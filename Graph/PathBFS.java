package Graph;

import java.util.LinkedList;
import java.util.Queue;

//SSSP problem using BFS for unweighted graph
public class PathBFS
{
    LinkedList<Integer>[] l;

    //creating adjacency list
    //creating vertices
    public PathBFS(int v)
    {
        l = new LinkedList[v];

        for(int i=0;i<v;i++)
            l[i] = new LinkedList<>();
    }

    //creating edges
    public void addEdge(int u,int v)
    {
        l[u].add(v);
        l[v].add(u);//activate this part to use for undirected graph
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
    public void BFSforSSSP(int s)
    {
        boolean[] visited = new boolean[l.length];
        int[] parent = new int[l.length];
        Queue<Integer> q = new LinkedList<>();
        parent[s]=-1;
        q.add(s);
        while (!q.isEmpty())
        {
            s = q.remove();
            visited[s]=true;
            System.out.print("Path for vertex "+s+" : ");
            pathPrint(s,parent);
            System.out.println();
            for(int i=0;i<l[s].size();i++)
            {
                int n = l[s].get(i);
                if(!visited[n])
                {
                    q.add(n);
                    visited[n]=true;
                    parent[n]=s;
                }
            }
        }
    }

    //print path of each of the vertex from source
    private void pathPrint(int destination,int parent[])
    {
        if(parent[destination]!=-1)
            pathPrint(parent[destination],parent);
        System.out.print(destination+" ");
    }

    public static void main(String[] args)
    {
        PathBFS g = new PathBFS(8);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 7);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(4, 7);
        g.addEdge(5, 6);
        g.addEdge(6, 7);

        g.printGraph();

        g.BFSforSSSP(0);
    }
}
