package ds.io.Graph;

import java.util.List;

import ds.io.Graph.Graph.GraphType;

public class GraphDepthFirstSearch {
public static void main(String[] args) {
	
	AdjacencySetGraph graph=new AdjacencySetGraph();
	int numvertices=5;
	graph.AdjacencySetGraph(numvertices, GraphType.UNDIRECTED);
	graph.addEdge(5, 6);
	graph.addEdge(7, 6);
	graph.addEdge(7, 8);
	graph.addEdge(7, 9);
	graph.addEdge(5, 9);
	int[] visited=new int[numvertices];
	for(int i=0;i<numvertices;i++){
		depthFirstSearch(graph,visited,i);
	}
	
}

private static void depthFirstSearch(AdjacencySetGraph graph, int[] visited, int currentVertex) {
	
	if(visited[currentVertex]==1){
		return;
	}
	visited[currentVertex]=1;
	
	List<Integer> list=graph.getAdjacentVertices(currentVertex);
	
	for(int element:list){
		depthFirstSearch(graph, visited, element);
	}
	
	System.out.println(currentVertex+" ->");
}
}
