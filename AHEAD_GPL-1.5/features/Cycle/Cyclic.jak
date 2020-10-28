
public class Cyclic extends CommonSearch{
	public boolean isCycle;
	public int counter;
	public boolean isDirected;
//	public Node next;
	public int WHITE = 0;
	public int GRAY  = 1;
	public int BLACK = 2;  
	public Cyclic() {
	}
	public Cyclic( boolean type ) {
		isCycle = false;
	    counter   = 0;
	    isDirected = type;
	}	
	public void init_Node(Node node) {
	    node.nodeCycle = Integer.MAX_VALUE;
	    node.nodeColor = WHITE; // initializing with white color 
	}	 
	public void preVisitAction( Node node ) {
	    // This assigns the values on the way in
	    if ( node.visited!=true ) { 
	    	node.nodeCycle = counter++;
	    	node.nodeColor = GRAY; 
	    }
	}	
	public void nextVisiting( Node node ) {
		node.nodeColor = BLACK;
	    counter--;
	} 
	public void checkNeighborAction( Node nodeSource,Node nodeTarget ){
	    if ( isDirected ){
	        if ( ( nodeSource.nodeColor == GRAY ) && ( nodeTarget.nodeColor == GRAY ) ){
	            isCycle = true;         
	        }
	    }
	    else{ // undirected case
	        if ( ( nodeSource.nodeColor == GRAY ) && ( nodeTarget.nodeColor == GRAY ) 
	             && nodeSource.nodeColor != nodeTarget.nodeColor+1 ){
	        	isCycle = true;
	        }
	    }

//		System.out.println(" Cycle : " +isCycle);
		
	} 
}