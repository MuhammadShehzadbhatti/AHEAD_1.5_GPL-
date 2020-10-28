
import java.util.LinkedList;


abstract class Edge$$Directed extends Neighbor implements EdgeInterface{
	public Node start,end=null;
	public void theEdge(Node startNode, Node endNode){
		start=startNode;
		end=endNode;
	}
//	Override
	public void theEdge(Node startNode, Node endNode,int weight){
//		start=startNode;
//		end=endNode;
	}
	public Node getStartNode() {
		return ((Edge) this).start;
	}
	public Node getEndNode() {
		return ((Edge) this).end;
	}
	public void display( ) {
		 System.out.println( "start Node = " + start.getName() + " end Node = " + end.getName() );
	}
	public void setWeight(int weight){}
    public int getWeight() { return 0; }
    public Node getOtherNode( Node node ) {
    	 if(node == start)
             return end;
         else if(node == end)
             return start;
         else
             return null;
    }
    public void adjustAdorns( EdgeInterface theEdge ) {
    	
    }
		
}


public class Edge extends  Edge$$Directed  implements EdgeInterface{
	private int weight;
	public void theEdge( Node start,  Node end, int weight ) {
	    super.theEdge( start,end );
	    ((Edge) this).weight = weight;
	}
	public void adjustAdorns( Edge edge ) {
		setWeight(edge.getWeight());
		super.adjustAdorns( edge );
	}
	public void setWeight(int weight){
        ((Edge) this).weight = weight;
    }
    public int getWeight(){
        return ((Edge) this).weight;
    }
    public void display() {
        System.out.print( " Weight=" + getWeight() );
        super.display();
    }
}