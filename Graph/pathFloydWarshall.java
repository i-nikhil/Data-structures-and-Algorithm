package Graph;

//APSP problem using Floyd Warshall's algorithm
//Using adjacency matrix for ease
public class pathFloydWarshall
{
    int graph[][];

    //creating adjacency matrix
    //creating vertices
    public pathFloydWarshall(int v)
    {
        graph = new int[v][v];
    }

    //creating edges
    public void addEdge(int u,int v,int weight)
    {
        graph[u][v] = weight;
        //graph[v][u] = weight;//activate this to test for undirected graph
    }

    public void FloydWarshall()
    {
        int distance[][] = new int[graph.length][graph.length];

        //populate the distance matrix with edge weight,
        //for non-edge mark ∞, and for same vertex 0.
        for (int i = 0; i < graph.length; i++)
        {
            for (int j = 0; j < graph.length; j++)
            {
                if(graph[i][j]!=0)
                    distance[i][j] = graph[i][j];
                else if(graph[i][j]==0 && i==j)
                    distance[i][j] = 0;
                else
                    distance[i][j]=999999;
            }
        }

        //iterate through all vertices, considering it via for all edges
        for(int x=0;x<graph.length;x++)
        {
            for(int u=0;u<graph.length;u++)
            {
                for(int v=0;v<graph.length;v++)
                {
                    // If via 'x' is the shortest path from u to v, then update distance[u][v]
                    if (distance[u][v] > distance[u][x] + distance[x][v])
                        distance[u][v] = distance[u][x] + distance[x][v];
                }
            }
        }

        //Printing the results
        System.out.println("The following matrix shows the shortest distances between every pair of vertices");
        for (int i=0; i<distance.length; i++)
        {
            for (int j=0; j<distance.length; j++)
            {
                if (distance[i][j]==999999)
                    System.out.print("∞   ");//INF
                else
                    System.out.print(distance[i][j]+"   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        pathFloydWarshall g=new pathFloydWarshall(4);
        g.addEdge(0,1,8);
        g.addEdge(0,3,1);
        g.addEdge(1,2,1);
        g.addEdge(2,0,4);
        g.addEdge(3,1,2);
        g.addEdge(3,2,9);
        g.FloydWarshall();

        pathFloydWarshall g1=new pathFloydWarshall(4);
        g1.addEdge(0,1,5);
        g1.addEdge(1,2,3);
        g1.addEdge(2,3,1);
        g1.addEdge(0,3,10);
        g1.FloydWarshall();
    }
}