

/**
 * TODO description
 */
public class GraphMain {
	public static void main(String[] args) {
//    	System.out.println("hello"); 
    	Graph graph=new Graph();
    	graph.addNode(new Node("A"));
    	graph.addNode(new Node("B"));
    	graph.addNode(new Node("C"));
    	graph.addNode(new Node("D"));
    	graph.addNode(new Node("E"));
    	graph.addNode(new Node("F"));
    	graph.addNode(new Node("G"));
    	graph.addNode(new Node("H"));
    	graph.addNode(new Node("I"));
//    	graph.GraphType("undirected");
    	graph.addEdge(graph.findsNode("A"),graph.findsNode("B"),4);
    	graph.addEdge(graph.findsNode("A"),graph.findsNode("H"),8);
    	graph.addEdge(graph.findsNode("B"),graph.findsNode("C"),8);
    	graph.addEdge(graph.findsNode("B"),graph.findsNode("H"),11);
    	graph.addEdge(graph.findsNode("H"),graph.findsNode("I"),7);
    	graph.addEdge(graph.findsNode("C"),graph.findsNode("I"),2);
    	graph.addEdge(graph.findsNode("H"),graph.findsNode("G"),1);
    	graph.addEdge(graph.findsNode("I"),graph.findsNode("C"),2);
    	graph.addEdge(graph.findsNode("I"),graph.findsNode("G"),6);
    	graph.addEdge(graph.findsNode("G"),graph.findsNode("F"),2);
    	graph.addEdge(graph.findsNode("C"),graph.findsNode("D"),7);
    	graph.addEdge(graph.findsNode("C"),graph.findsNode("F"),4);
    	graph.addEdge(graph.findsNode("D"),graph.findsNode("F"),14);
    	graph.addEdge(graph.findsNode("D"),graph.findsNode("E"),9);
    	graph.addEdge(graph.findsNode("F"),graph.findsNode("E"),10);
//    	graph.CycleCheck();
    	graph.Prim(graph.findsNode("A"));
    	graph.shortestPath(graph.findsNode("A"),graph.findsNode("E"));
    	CommonSearch cs=new CommonSearch();
    	graph.GraphSearch(cs);
    	graph.CycleCheck();
    	graph.ComputeTranspose(graph);
//    	graph.searchGivenNode("A"); 
//    	graph.GraphSearch(cs); 
//    	graph.addingEdge("A", "B", 10); 
	} 
}