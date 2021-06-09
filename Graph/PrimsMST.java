package Graph;

//MST using Prim's algorithm
//Using adjacency matrix for ease
public class PrimsMST
{
    int[][] graph;

    //creating adjacency matrix
    //creating vertices
    public PrimsMST(int v)
    {
        graph = new int[v][v];
    }

    //creating undirected edges
    public void addEdge(int u,int v,int weight)
    {
        graph[u][v] = weight;
        graph[v][u] = weight;
    }

    // Function to construct and print MST
    void prims()
    {
        int[] parent = new int[graph.length];
        int[] distance = new int[graph.length];
        Boolean[] visited = new Boolean[graph.length];
        for (int i = 0; i < graph.length; i++)
        {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        distance[0] = 0; //source vertex
        parent[0] = -1; //parent is null for source vertex

        // The MST will have V vertices
        for (int count = 0; count < graph.length - 1; count++)
        {
            int u = minKey(distance, visited);// Pick thd minimum distance vertex which is unvisited
            visited[u] = true;// mark as visited
            // Update distance and parent index of the adjacent vertices of the picked vertex.
            // Consider only those vertices which are not yet visited (included in MST)
            for (int v = 0; v < graph.length; v++)
            {
                if (graph[u][v] != 0 && !visited[v] && graph[u][v] < distance[v])
                {
                    parent[v] = u;
                    distance[v] = graph[u][v];
                }
            }
        }

        // print the constructed MST
        System.out.println("Edge \tWeight");
        for (int i = 1; i < graph.length; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    // A utility function to find the unvisited vertex with minimum distance
    int minKey(int[] distance, Boolean[] visited)
    {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < graph.length; v++)
            if (!visited[v] && distance[v] < min)
            {
                min = distance[v];
                min_index = v;
            }
        return min_index;
    }

    public static void main(String[] args)
    {
        PrimsMST g = new PrimsMST(5);
        g.addEdge(0,1,2);
        g.addEdge(0,3,6);
        g.addEdge(1,2,3);
        g.addEdge(1,3,8);
        g.addEdge(1,4,5);
        g.addEdge(2,4,7);
        g.addEdge(3,4,9);

        g.prims();
    }
}
