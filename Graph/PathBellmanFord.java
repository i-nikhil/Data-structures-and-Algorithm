package Graph;

//SSSP problem using Bellman Ford's algorithm
//Using adjacency matrix for ease
public class PathBellmanFord
{
    int graph[][];

    //creating adjacency matrix
    //creating vertices
    public PathBellmanFord(int v)
    {
        graph = new int[v][v];
    }

    //creating edges
    public void addEdge(int u,int v,int weight)
    {
        graph[u][v] = weight;
        //graph[v][u] = weight;//activate this to test for undirected graph
    }

    //Dijkstra from a Source Node
    public void bellmanFord(int source)
    {
        int distance[] = new int[graph.length];//distance of each vertex from source
        for (int i = 0; i < distance.length; i++)//mark all distance as ∞
            distance[i] = Integer.MAX_VALUE;
        distance[source] = 0;//mark source distance as 0

        for(int i=0;i<graph.length-1;i++)
        {
            //iterate through all the edges for v-1 times
            for(int u=0;u<graph.length;u++)
            {
                for(int v=0;v<graph.length;v++)
                {
                    // Update dist[v] only if there is an edge from u to v,
                    // and total weight of path from src to v through u is
                    // smaller than current value of dist[v]
                    if(graph[u][v]!=0 && distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + graph[u][v])
                    {
                        distance[v] = distance[u] + graph[u][v];
                    }
                }
            }
        }

        //detection of negative cycle
        //If we get a shorter path, then there is a cycle
        for(int u=0;u<graph.length;u++)
        {
            for(int v=0;v<graph.length;v++)
            {
                if(graph[u][v]!=0 && distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + graph[u][v])
                {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }
        }

        // print the constructed distance array
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < graph.length; i++)
            System.out.println(i + " \t\t\t " + distance[i]);
    }

    public static void main(String[] args)
    {
        PathBellmanFord g = new PathBellmanFord(5);
        g.addEdge(0,2,6);
        g.addEdge(0,3,6);//change 6 to -6 to check for -ve cycle
        g.addEdge(1,0,3);
        g.addEdge(2,3,2);
        g.addEdge(3,2,1);
        g.addEdge(3,1,1);
        g.addEdge(4,1,4);
        g.addEdge(4,3,2);

        g.bellmanFord(4);
    }
}
