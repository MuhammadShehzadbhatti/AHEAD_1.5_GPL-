
import java.util.LinkedList;
import java.util.Iterator;
public class Edge extends Neighbor implements EdgeInterface{
	public Node start,end=null;
	public void theEdge(Node startNode, Node endNode){
		start=startNode;
		end=endNode;
	}
	public void theEdge(Node startNode, Node endNode,int weight){
//		start=null;
//		end=null;
	}
	public Node getStart(){
		return this.start;
	}
	public Node getEnd(){
		return this.end;
	}
	public void display( ){
		 System.out.println( "start Node = " + getStartNode().getName() + " end Node = " + getEndNode().getName() );
	}
	public void setWeight(int weight){
		
	}
    public int getWeight(){ 
    	return 0; 
    }
    public Node getOtherNode( Node node ) {
    	 if(node == start)
             return end;
         else if(node == end)
             return start;
         else
             return null;
    }
    public Node getStartNode( ){
        return start;
    }
    public Node getEndNode( ){
        return end;
    }
    public void adjustAdorns( EdgeInterface theEdge ) {
    }
		
}