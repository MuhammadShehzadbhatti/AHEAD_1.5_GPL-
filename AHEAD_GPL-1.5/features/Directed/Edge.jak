
import java.util.LinkedList;
public class Edge extends Neighbor implements EdgeInterface{
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
		return this.start;
	}
	public Node getEndNode() {
		return this.end;
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