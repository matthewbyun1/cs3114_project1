package prj1;

/**
 * In this class, we implement the d-ary min-heap data structure
 * 
 * @author Matthew Byun
 *
 */
public class MinHeap {
    // The parameter d in the d-ary min-heap
    private int d;

    // The array representation of your min-heap (It is not required to use this)
    private HeapNode[] nodes;

    /**
     * Constructor
     * 
     * @param n:
     *            maximum number of elements in the min-heap at each time
     * @param d:
     *            parameter d in the d-ary min-heap
     */
    public MinHeap(int n, int d) {
        // TODO complete
        this.d = d;
        this.nodes = new HeapNode[n+1];
        this.nodes[0] = new HeapNode(0,0);
    }

    /**
     * This method returns the number of full levels in the heap.
     * 
     * @return the number of full levels in the heap
     */
    public int full_levels() {
        //TODO complete
        if(nodes.length - 1 == 0){
            return 0;
        }
        else{
            int level = 1;
            int node_in_level = 1;
            for(int i = 1; i < 100; i++){
                node_in_level = this.d * node_in_level;
                if(nodes.length-1 <= node_in_level){
                    return level;
                }
                level = level + 1;
            }
        }
        return -1;
    }

    /**
     * This method inserts a new element with "id" and "value" into the min-heap
     * 
     * @param id
     * @param value
     */
    public void insert(int id, int value) {

        // Creates an array with existing nodes plus new node at the end
        HeapNode new_node = new HeapNode(id, value);
        int new_length = nodes.length + 1;
        HeapNode[] temp  = new HeapNode[new_length];
        for (int i = 0; i < nodes.length; i++){
            temp[i] = this.nodes[i];
        }
        temp[new_length-1] = new_node;

        // Loop to swap new node with parent if parent value is greater than new node value
        int index = new_length-1;
        while(index > 1 && temp[index/d].getValue() > new_node.getValue()){
            // Finds index of new node
            for (int j = 1; j < temp.length; j++){
                if(temp[j] == new_node){
                    index = j;
                }
            }
            // Swaps parent with new node
            HeapNode parent_node = temp[index/d];
            temp[index/d] = new_node;
            temp[index] = parent_node;
            }
        // Updates heap array
        nodes = temp;
    }


    /**
     * This method extracts the min value of the heap
     * 
     * @return an array consisting of two integer elements: id of the minimum
     *         element and the value of the minimum element
     * 
     *         So for example, if the minimum element has id = 5 and value = 1,
     *         you should return the array [5, 1]
     */
    public int[] extractMin() {
        // The minimum value should always be the first element in the heap array
        int[] min = new int[2];
        min[0] = nodes[1].getId();
        min[1] = nodes[1].getValue();
        
        // Swap first and last elements in array, delete the last element
        nodes[1] = nodes[nodes.length - 1];
        int new_length = nodes.length - 1;
        HeapNode[] temp  = new HeapNode[new_length];
        for (int i = 0; i < temp.length; i++){
            temp[i] = this.nodes[i];
        }
        
        // Check if new parent is greater than its children. If it is, swap parent with the child with smaller value.
        // Else, do nothing.
        HeapNode swapped_node = nodes[1];
        int index = 1;
        
        
        return min;
    }


    /**
     * This method takes an id and a new value newValue for the corresponding
     * node, and updates the data structure accordingly
     * 
     * @param id
     * @param newValue
     */
    public void decreaseKey(int id, int newValue) {
        // TODO complete
    }


    /**
     * This method returns the array representation of heap
     * 
     * @return the array representation of heap
     */
    public int[] getHeap() {
        int[] heap = new int[nodes.length];
        heap[0] = Integer.MIN_VALUE;
        for(int i = 1; i < nodes.length; i++) {
            heap[i] = nodes[i].getValue();
        }
        return heap;
    }

    /**
     * the toString method that returns a string with the values of the heap in
     * the array representation.
     * This method can help you find the issues of your code when you want to
     * debug.
     * 
     * @return string form of the array representation of heap
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.nodes.length; i++) {
            if (nodes[i] != null) {
                sb.append(nodes[i].getValue());
                sb.append(' ');
            }
        }
        return sb.toString();
    }
    
}