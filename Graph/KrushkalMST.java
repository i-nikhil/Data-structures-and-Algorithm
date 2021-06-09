package Graph;

//MST using Krushkal's algorithm
//Using adjacency matrix for ease
public class KrushkalMST
{
    int[][] graph;

    //creating adjacency matrix
    //creating vertices
    public KrushkalMST(int v)
    {
        graph = new int[v][v];
    }

    //creating undirected edges
    public void addEdge(int u,int v,int weight)
    {
        graph[u][v] = weight;
        graph[v][u] = weight;
    }

    // Finds MST using Kruskal's algorithm
    public void kruskalMST()
    {
        for(int i=0;i<graph.length;i++)
            for (int j=0;j<graph.length;j++)
                if(graph[i][j]==0)
                    graph[i][j]=Integer.MAX_VALUE;

        int[] parent = new int[graph.length];

        int mincost = 0; // Cost of min MST.

        // Initialize sets of disjoint sets.
        for (int i = 0; i < graph.length; i++)
            parent[i] = i;

        // Include minimum weight edges one by one
        int edge_count = 0;
        while (edge_count < graph.length - 1)
        {
            int min = Integer.MAX_VALUE, a = -1, b = -1;
            for (int i = 0; i < graph.length; i++)
            {
                for (int j = 0; j < graph.length; j++)
                {
                    if (find(i,parent) != find(j,parent) && graph[i][j] < min)
                    {
                        min = graph[i][j];
                        a = i;
                        b = j;
                    }
                }
            }

            union(a, b,parent);
            System.out.println("Edge ("+a+","+b+") => cost:"+min);
            mincost += min;
            edge_count++;
        }
        System.out.println("\nMinimum cost = "+mincost);
    }

    // Find set of vertex i
    static int find(int i, int[] parent)
    {
        while(parent[i] != i)
            i = parent[i];
        return i;
    }

    // Does union of i and j.
    static void union(int i, int j, int[] parent)
    {
        int a = find(i,parent);
        int b = find(j,parent);
        parent[a] = b;
    }

    public static void main(String[] args)
    {
        KrushkalMST g = new KrushkalMST(5);
        g.addEdge(0,1,2);
        g.addEdge(0,3,6);
        g.addEdge(1,2,3);
        g.addEdge(1,3,8);
        g.addEdge(1,4,5);
        g.addEdge(2,4,7);
        g.addEdge(3,4,9);

        g.kruskalMST();
    }
}
