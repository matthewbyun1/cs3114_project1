package prj1;
import java.util.ArrayList;
/**
 * 
 * The implementation of Dijkstras shortest path algorithm by using
 * min-heaps
 * 
 * @author Enter your names here
 */
public class DijkstrasWithHeap {
    private int nodes;
    private int[][] edges;
    /**
     * Constructor of the class
     * 
     * @param n:
     *            number of nodes of the graph
     * @param edges:
     *            the set of edges of the graph. Each row of 'edges' is in the
     *            form of [u, v, w], which means that there is an edge between u
     *            and v with weight w. So edges[i][0] and edges[i][1] are the
     *            end-points of the i-th edge and edges[i][2] is its weight
     */
    public DijkstrasWithHeap(int n, int[][] edges) {
        //TODO complete
        nodes = n;
        this.edges = edges;
    }


    /**
     * This method computes and returns the distances of all nodes of the graph
     * from the source node
     * 
     * @param source
     * 
     * @return an array containing the distances of the nodes of the graph from
     *         source. Element i of the returned array represents the distance
     *         of node i from the source
     */
    public int[] run(int source) {
        //TODO complete
        // array to be returned
        int[] distances = new int[nodes];
        for(int i = 0; i < distances.length;i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        
        // unvisited/visited nodes
        ArrayList<HeapNode> visited = new ArrayList<HeapNode>();
        ArrayList<HeapNode> unvisited = new ArrayList<HeapNode>();
        MinHeap mh = new MinHeap(nodes, 2);
        for(int i = 1; i <= nodes; i++) {
            unvisited.add(mh.getHeapNodes()[i]);
        }
        
        source = source-1;
        
        
        
        return distances;
    }

}
