package com.grafos;

public class DijstraDP{
	
	GrafoDP grafo;
		int inicio;
		int cantNodos;
	public DijstraDP(GrafoDP g, int inicio) {
		grafo=g;
		this.inicio=inicio;
		cantNodos=grafo.getCantNodos();
	}
    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < cantNodos; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }
 
    // A utility function to print the constructed distance array
    void printSolution(int dist[], int n)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < cantNodos; i++)
            System.out.println(i+" Dist "+dist[i]);
    }
 
    // Funtion that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    public void dijkstra()
    {
    	int gr[][]=grafo.getGrafo();
    	
        int dist[] = new int[cantNodos]; // The output array. dist[i] will hold
                                 // the shortest distance from src to i
 
        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[cantNodos];
 
        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < cantNodos; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
 
        // Distance of source vertex from itself is always 0
        dist[inicio] = 0;
 
        // Find shortest path for all vertices
        for (int count = 0; count < cantNodos-1; count++)
        {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);
 
            // Mark the picked vertex as processed
            sptSet[u] = true;
 
            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < cantNodos; v++)
 
                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v] Integer.MAX_VALUE
                if (!sptSet[v] && gr[u][v]!=-1 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+gr[u][v] < dist[v])
                    dist[v] = dist[u] + gr[u][v];
        }
 
        // print the constructed distance array
        printSolution(dist, cantNodos);
    }
 
}
