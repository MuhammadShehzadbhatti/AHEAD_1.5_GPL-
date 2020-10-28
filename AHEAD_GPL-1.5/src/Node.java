
import java.util.LinkedList;
import java.util.Iterator;


abstract class Node$$Position {
//	public static LinkedList queueList=new LinkedList();
	public boolean visited = false;
	public LinkedList neighbors = new LinkedList();
	public String name=null;
	Node$$Position(){	}
	Node$$Position(String name){
		this.name=name;
	}
	public Node setName( String name ) {
	    ((Node) this).name = name;
	    return ( Node ) ((Node) this);
	}

	public String getName( ) {  
		return ((Node) this).name;
	}	

	public LinkedList getNodeNeighbors( )
    {
      return neighbors;
    }
    public NodeItr getNeighbors( ){
        return new NodeItr( ){
            private Iterator iter =  neighbors.iterator( );
            public Node next( ) {
              return ( ( Neighbor )iter.next( ) ).end;
            } 
            public boolean hasNext( ){
              return iter.hasNext( );
            }
        };
    }
    
    //---------//
    public void addNeighbor( Neighbor nbr ) {
        neighbors.add( nbr );
    } 
//	public NodeItr getNeighbors() {
//		return new NodeItr() {
//			private Iterator iter = neighbors.iterator();
//			public Node next() { return ((Neighbor)iter.next()).end; }
//			public boolean hasNext() { return iter.hasNext(); }
//		};
//	}
    public EdgeItr getEdges()
    {
        return new EdgeItr(){
            private Iterator iter = neighbors.iterator();
            public EdgeInterface next( ){
              return ( ( EdgeInterface ) ( ( Neighbor ) iter.next( ) ).edge );
            }
            public boolean hasNext() { return iter.hasNext(); }
        };
    }
    public void display() {
        System.out.print( " Node " + name + " connected to: " );

        for(NodeItr nodeitr = getNeighbors(); nodeitr.hasNext(); )
         {
            Node node = nodeitr.next();
            System.out.print( node.getName() + ", " ); 
        }

        System.out.println();
    }
    //for common search start
    public void init_Node( CommonSearch cs ){
        visited = false;
        cs.init_Node( ( Node ) ((Node) this) );
//        if ( visited )
//            System.out.print("visited");
//        else
//            System.out.println("!visited");
        display();
    }
//    Node n;
//    public void nodeSearch( CommonSearch cs ){
//	    int     s, c;
//	    Node  node; 
//	    Node  head;
//        cs.preVisitAction( ( Node ) this );
//        if (visited )
//        {
//            return;
//        }
//        
//        visited = true;
////        this.display();
//        cs.preVisitAction( ( Node ) this );
//
//        for ( NodeItr nodeItr = getNeighbors( ); nodeItr.hasNext( ); )
//        {
//            node = nodeItr.next( );
//
//            if ( !node.visited )
//            {
//            	SharedVariablesContainer.queueList.add( node );
//            }
//
//        } // end of for
//        //if queue is not null
//        while( SharedVariablesContainer.queueList.size( )!= 0 )
//        {
//            head = ( Node ) SharedVariablesContainer.queueList.get( 0 );
//            SharedVariablesContainer.queueList.remove( 0 );
//            head.nodeSearch( cs );
////            System.out.println("visit in while ;"+head.visited);
//        }
//        if ( visited )
//            System.out.print("visited");
//        else
//            System.out.println("!visited");
//       this.display();
//    }
    //for common search end
    
//    public void nodeSearch( CommonSearch cs ){
//        Node node;
//        cs.previousVisited( ( Node ) this );
//        
//        if ( visited )
//            return;
//        visited = true;
//        this.display();
//        for ( NodeItr  nodeitr = getNeighbors(); nodeitr.hasNext(); ){
//            node = nodeitr.next( );
//            cs.findNeighbor( ( Node ) this, node );
//            node.nodeSearch( cs );
//        }
//       cs.nextVisiting( ( Node ) this );
//    }
    Node n;
    public void nodeSearch( CommonSearch cs ){
	    int     s, c;
	    Node  node; 
	    Node  head;
        cs.preVisitAction( ( Node ) ((Node) this) );
        if (visited )
        {
            return;
        }
        
        visited = true;
//        this.display();
        cs.preVisitAction( ( Node ) ((Node) this) );

        for ( NodeItr nodeItr = getNeighbors( ); nodeItr.hasNext( ); )
        {
            node = nodeItr.next( );

            if ( !node.visited )
            {
            	SharedVariablesContainer.queueList.add( node );
            }

        } // end of for
        //if queue is not null
        while( SharedVariablesContainer.queueList.size( )!= 0 )
        {
            head = ( Node ) SharedVariablesContainer.queueList.get( 0 );
            SharedVariablesContainer.queueList.remove( 0 );
            head.nodeSearch( cs );
//            System.out.println("visit in while ;"+head.visited);
        }
//        if ( visited )
//            System.out.print("visited");
//        else
//            System.out.println("!visited");
//       this.display();
    }
    
}


abstract class Node$$Directed extends  Node$$Position  {
    public LinkedList neighbors = new LinkedList();
    public Node setName( String name ) {
	    ((Node) this).name = name;
	    return ( Node ) ((Node) this); 
	}
    public void addNeighbor( Neighbor nbr ) {
    	neighbors.add( nbr );
    } 
    public NodeItr getNeighbors() {
    	return new NodeItr() {
            private Iterator iter = neighbors.iterator();
            public Node next() { return ((Neighbor)iter.next()).end; }
            public boolean hasNext() { return iter.hasNext(); }
        };
    }
    public EdgeItr getEdges()
    {
        return new EdgeItr()
            {
                private Iterator iter = neighbors.iterator();
                public EdgeInterface next( )
                {
                  return ( ( EdgeInterface ) ( ( Neighbor ) iter.next( ) ).edge );
                }
                public boolean hasNext() { return iter.hasNext(); }
            };
    }
    public void display() {
        System.out.print( " Node " + getName() + " connected to: " );
        for(NodeItr nodeitr = getNeighbors(); nodeitr.hasNext(); )
         {
            Node node = nodeitr.next();
            System.out.print( node.getName() + ", " ); 
        }
        System.out.println();
    }
      // inherited constructors


	Node$$Directed ( String name ) { super(name); }
	Node$$Directed (  ) { super(); }
//    public void adjustAdorns(Neighbor sourceNeighbor) {
//		
//	}
//    public void nodeSearch() {
//        System.out.println(":::::::::::::::::::");
//		
//	}
}

/**
 * TODO description
 */
public class Node extends  Node$$Directed {
	public int shortestDistance = Integer.MAX_VALUE;
//	public Node prnt,source,target,trgtNode;
	public Node prnt;
	public void display() {
		super.display();
	}
      // inherited constructors


	Node ( String name ) { super(name); }
	Node (  ) { super(); }
//	@Override
//	public int compareTo(Node other) {
//		return Double.compare(shortestDistance, other.shortestDistance);
//	}
}