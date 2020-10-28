
import java.util.LinkedList;


public class Neighbor {
	public Node neighbor;
	public  Node end;
    public  Edge edge;
        
    public Neighbor() {
        end = null;
        edge = null;
    }
        
    public Neighbor( Node endNode,  Edge edge ) {
        end = endNode;
        this.edge = edge;
//        System.out.println("My Sorce Node "+edge.getStartNode() +" Source Node neighbor "+end);
    }
//    public void NodeNeighbor(Node nbr) {
//		neighbor=nbr;
//	}
//    public void display() {
//		System.out.println("end Node "+end +"  "+edge);
//	}
}