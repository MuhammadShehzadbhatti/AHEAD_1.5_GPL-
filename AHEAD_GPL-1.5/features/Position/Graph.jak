 
import java.util.Comparator;
import java.util.Iterator;
import java.util.Collections;
import java.util.LinkedList;

public class Graph { 
	public boolean isDirected=false;
	LinkedList nodeList;
	LinkedList edgeList;
	public Graph() {
		nodeList =new LinkedList();
		edgeList =new LinkedList();
	}
	public void sortEdges(Comparator c) {
        Collections.sort(edgeList, c);
    }
	public NodeItr getNode(){
		return new NodeItr(this);
	}  
	public void sortNodes(Comparator c) {
	    Collections.sort(nodeList, c);
	}
    void addNode( Node node ) {
    	nodeList.add(node);
    }
	EdgeInterface addEdge( Node start, Node end ) {
		Edge edge=new Edge();
		edge.theEdge(start, end);
		edgeList.add(edge); 
		start.addNeighbor(new Neighbor(end, edge));
		end.addNeighbor(new Neighbor(start, edge));
		display();
		return edge;
	}
	EdgeInterface addEdge( Node start, Node end ,int weight) {
		Edge edge=new Edge();
		edge.theEdge(start, end, weight);
		edgeList.add(edge); 
		start.addNeighbor(new Neighbor(end, edge));
		end.addNeighbor(new Neighbor(start, edge));
		display();
		return edge;
	}
	public  EdgeInterface findsEdge( Node srcNode,Node trgtNode ){
		EdgeInterface edge;
		for( EdgeItr edgeitr = srcNode.getEdges(); edgeitr.hasNext(); ){
			edge = edgeitr.next();
			if ( ( edge.getStartNode().getName().equals( srcNode.getName() ) &&
			edge.getEndNode().getName().equals( trgtNode.getName() ) ) ||
			( edge.getStartNode().getName().equals( trgtNode.getName() ) &&
			edge.getEndNode().getName().equals( srcNode.getName() ) ) )
				return edge;
		}
		return null;
	}
	public void display() {
		System.out.println( "Nodes " );
		for ( NodeItr nodeiter = getNode(); nodeiter.hasNext() ; )
			nodeiter.next().display();
		System.out.println( "Edges " );
		for ( EdgeItr edgeiter = getEdges(); edgeiter.hasNext(); )
				edgeiter.next().display();
	}
	Node findsNode( String nodeName ){
		Node node=null;
		for (NodeItr nodeItr=getNode();nodeItr.hasNext();) {
			node=nodeItr.next();
			if (node.getName()==nodeName) {
				return node;
			}
		}
		return node;
	}
	
	public EdgeItr getEdges() {
        return new EdgeItr() {
            private Iterator iter = edgeList.iterator();
            public EdgeInterface next() { return (EdgeInterface)iter.next(); }
            public boolean hasNext() { return iter.hasNext(); }
        };
    }
	//Defaults start
	public  Graph ComputeTranspose( Graph graph ){
		return null;
	}
	public boolean CycleCheck() {
        return false;
    }
	public void nodeSearch() {
		
	}
	public Graph Prim(Node node) {
		return null;
	}
	public void shortestPath() {
		
	}
	//Defaults end
	//Searching start
    public void GraphSearch( CommonSearch cs ){
        System.out.println(":::::::::::::::::::");
        NodeItr nodeItr = getNode( );
        if ( nodeItr.hasNext( ) == false ){
            return;
        }
        while(nodeItr.hasNext( ) ){
            Node node = nodeItr.next( );
            node.init_Node( cs );
        }
        for (nodeItr = getNode( ); nodeItr.hasNext( ); ){
            Node node = nodeItr.next( );
            if ( !node.visited ){
                cs.nextRegionAction( node );
                node.nodeSearch( cs );
            }
        }
    }
	//Searching end
    //find Cycle start
//    Cyclic cyclic =new Cyclic(isDirected);
   //find Cycle end
}
