package Graph;

//SSSP problem using Dijkstra's algorithm on weighted graph
//Using adjacency matrix for ease
public class PathDijkstra
{
    int graph[][];

    //creating adjacency matrix
    //creating vertices
    public PathDijkstra(int v)
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
    public void dijkstra(int source)
    {
        int distance[] = new int[graph.length];//distance of each vertex from source
        Boolean visited[] = new Boolean[graph.length];
        for (int i = 0; i < distance.length; i++)//mark all distance as ∞
        {
            distance[i] = Integer.MAX_VALUE;
            visited[i]=false;
        }
        distance[source]=0;//mark source distance as 0

        for (int i = 0; i < graph.length-1; i++)
        {
            int u = minDistance(distance, visited);
            visited[u] = true;
            for (int v = 0; v < graph.length; v++)

                // Update dist[v] only if is not in visited, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!visited[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE
                        && distance[u] + graph[u][v] < distance[v])
                    distance[v] = distance[u] + graph[u][v];
        }
        // print the constructed distance array
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < graph.length; i++)
            System.out.println(i + " \t\t\t " + distance[i]);
    }

    private int minDistance(int distance[], Boolean visited[])
    {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < distance.length; v++)
        {
            if (!visited[v] && distance[v] <= min)
            {
                min = distance[v];
                min_index = v;
            }
        }

        return min_index;
    }

    public static void main(String[] args)
    {
        PathDijkstra g = new PathDijkstra(5);
        g.addEdge(0,2,6);
        g.addEdge(0,3,6);
        g.addEdge(1,0,3);
        g.addEdge(2,3,2);
        g.addEdge(3,2,1);
        g.addEdge(3,1,1);
        g.addEdge(4,1,4);
        g.addEdge(4,3,2);

        g.dijkstra(4);
    }
}

