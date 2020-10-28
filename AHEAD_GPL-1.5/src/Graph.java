 
import java.util.Comparator;
import java.util.Iterator;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;



abstract class Graph$$Position { 
	public boolean isDirected=false;
	LinkedList nodeList;
	LinkedList edgeList;
	public Graph$$Position() {
		nodeList =new LinkedList();
		edgeList =new LinkedList();
	}
	public void sortEdges(Comparator c) {
        Collections.sort(edgeList, c);
    }
	public NodeItr getNode(){
		return new NodeItr(((Graph) this));
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


abstract class Graph$$Directed extends  Graph$$Position  {
	public boolean isDirected = true;
	private LinkedList edgeList;
	public Graph$$Directed() { super(); 

		edgeList=new LinkedList(); }
 
	public void sortEdges(Comparator c) {
        Collections.sort(edgeList, c);
    }
	public EdgeInterface addEdge(Node start,Node end,int weight) {
		Edge edge=new Edge();
		edge.theEdge(start, end, weight);
		edgeList.add(edge); 
		start.addNeighbor(new Neighbor(end, edge));
		display();
		return edge;
	}
	public EdgeInterface addEdge(Node start,Node end) {
		Edge edge=new Edge();
		edge.theEdge(start, end);
		edgeList.add(edge); 
		start.addNeighbor(new Neighbor(end, edge));
		display();
		return edge;
	}
	public Node findsNode(String nodeName) {
		Node node=null;
		for (NodeItr nodeItr=getNode();nodeItr.hasNext();) {
			node=nodeItr.next();
			if (node.getName()==nodeName) {
				return node;
			}
		}
		return null; 
	}
	public EdgeItr getEdges() {
		return new EdgeItr() {
		    private Iterator iter = edgeList.iterator();
			public EdgeInterface next() { return (EdgeInterface)iter.next(); }
			public boolean hasNext() { return iter.hasNext(); }
	    };
	}

	public void display() { 
	//		    	 int i;
		System.out.println( "--Directed Graph Nodes--" );
		System.out.println( "Nodes " );
		for ( NodeItr nodeiter = getNode(); nodeiter.hasNext() ; )
			nodeiter.next().display();
		System.out.println( "--Directed Graph Edge--" );
		System.out.println( "Edges " );
		for ( EdgeItr edgeiter = getEdges(); edgeiter.hasNext(); )
			edgeiter.next().display();
	}
	public Graph Prim(Node node) {
		return null;
	}

	public void shortestPath() {
		
	}
      // inherited constructors


}



public class Graph extends  Graph$$Directed  {
	Node source=null;
	Node target=null;
	public void shortestPath(Node from, Node to) {
		Node n=null;
         LinkedList queue = new LinkedList();
        LinkedList visited = new LinkedList();
        for (NodeItr nodeItr=getNode();nodeItr.hasNext();) {
        	Node node=nodeItr.next();
			if (node==from)
				source=from;
			else if(node==to)
				target=to;
        }
        Node trgtNode=null;
//        System.out.println("source find null : "+source.name);
        source.shortestDistance=0;
        queue.add(source);

//    	System.out.print("source in SP : " +source.name );
//        for ( NodeItr nodeItr = getNode(); nodeItr.hasNext(); )
//        {
//            Node nn = nodeItr.next();
//        	if (source!=nn) {
//                queue.add( nn );
//			}
//        }
//        System.out.println("queue length " +queue.size());
		Node previous=source;
        while(!queue.isEmpty()) {
        	Node currentNode=(Node)queue.poll();
        	if (!visited.contains(currentNode)) {
        		visited.add(currentNode);
//			}
        	int weight=0;
//        	while(trgtNode!=target) {
	        	for (EdgeItr edgeItr = currentNode.getEdges(); edgeItr.hasNext();) {
					EdgeInterface edge=edgeItr.next();
					weight=edge.getWeight();
					trgtNode=edge.getOtherNode(currentNode);
	//	        		System.out.println("visited in SP : "+currentNode.name);
					int distanceFromeU = currentNode.shortestDistance + weight;
					if (distanceFromeU < trgtNode.shortestDistance) {
						trgtNode.shortestDistance = distanceFromeU;
						trgtNode.prnt = currentNode;
						queue.add(trgtNode);
					}
				}
        	}
//        	while (en.hasMoreElements()) {
//				type type = (type) en.nextElement();
//				
//			}
//        	n=(Node)queue.poll();
//        	for (EdgeItr edgeItr = n.getEdges(); edgeItr.hasNext();) {
//				System.out.println("weight and nodes "+n.name +"  ");
//			}
//        	n=(Node)queue.poll();
//        	System.out.println("_______"+n.name);
        }
        
//        return null;
	}
      // inherited constructors


	public Graph (  ) { super(); }
}