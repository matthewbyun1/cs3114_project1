package prj1;
import java.util.ArrayList;
/**
 * The implementation of Dijkstras shortest path algorithm by using a simple
 * linear search to find the unvisited node with the minimum distance estimate
 * 
 * @author Enter your names here
 * @version 1.1
 */
public class DijkstrasWithoutHeap {
    //stores edges
    private int[][] nodes;
    //stores all the node's statuses
    private boolean[] visited;
    //stores distance
    private int[] distances;
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
    public DijkstrasWithoutHeap(int n, int[][] edges) {
        // TODO complete
        nodes = new int[edges.length][3];
        for(int i = 0; i < edges.length; i++) {
            nodes[i] = edges[i];
            nodes[i][0] = edges[i][0];
            nodes[i][1] = edges[i][1];
            nodes[i][2] = edges[i][2];
        }
        
        // creates distance array and visited array
        visited = new boolean[n];
        distances = new int[n];
        for(int i = 0; i < n;i++) {
            distances[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
    }
    
    /**
     * This method finds all the neighbors of the node being inspected.
     * @param v
     * 
     * @return returns a list of all neighboring nodes
     */
    
    private ArrayList<int[]> neighbors(int v){
        ArrayList<int[]> neighbors = new ArrayList<int[]>();
        for(int i = 0; i < nodes.length; i++) {
            if(nodes[i][0] == v) {
                neighbors.add(nodes[i]);
            }
            else if(nodes[i][1] == v) {
                neighbors.add(nodes[i]);
                
                // this is just to keep the code consistent
                int temp = neighbors.get(i)[1];
                neighbors.get(i)[1] = neighbors.get(i)[0];
                neighbors.get(i)[0] = temp;
            }
        }
        return neighbors;
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
        
        // distance from original source to source will always be 0
        distances[source-1] = 0;
        visited[source-1] = true;
        
        // Priority queue with nodes directly next to source node
        ArrayList<int[]> priority_queue = new ArrayList<int[]>();
        priority_queue = this.neighbors(source);
        int u = source;
        
        // loops while priority queue has elements
        while(priority_queue.size() > 0) {
            // finds minimum value and node that produced minimum value
            int v = priority_queue.get(0)[1];
            int min_value = priority_queue.get(0)[2];
            int index = 0;
            for(int i = 1; i < priority_queue.size();i++) {
                int node_value = priority_queue.get(i)[2];
                if(min_value > node_value) {
                    min_value = node_value;
                    v = priority_queue.get(i)[1];
                    index = i;
                }
            }
            
            // removes that edge from the queue
            priority_queue.remove(priority_queue.get(index));
            
            // runs if minimum node has not been visited
            if(visited[v-1] == false) {
                visited[v-1] = true;
                distances[v-1] = distances[u-1] + min_value;
                ArrayList<int[]> v_neighbors = this.neighbors(v);
                for(int i = 0; i < v_neighbors.size(); i++) {
                    if(visited[v_neighbors.get(i)[1]-1] == false) {
                        int distance = v_neighbors.get(i)[2];
                        v_neighbors.get(i)[2] = distances[v-1] + distance;
                        priority_queue.add(v_neighbors.get(i));
                    }
                }
            }
            u = v;
            
        }
        // Any value that is still Integer.MAXVALUE in the distance array means that the node is not connected
        for(int d = 0; d < distances.length;d++) {
            if (distances[d] == Integer.MAX_VALUE) {
                distances[d] = -1;
            }
        }
        return distances;
    }
}
