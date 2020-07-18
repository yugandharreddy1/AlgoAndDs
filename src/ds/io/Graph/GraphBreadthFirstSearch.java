package ds.io.Graph;

import java.util.List;
import java.util.Queue;

import ds.io.Graph.Graph.GraphType;

public class GraphBreadthFirstSearch {

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
			breadthFirstSearch(graph,visited,i);
		}
		
	}

	private static void breadthFirstSearch(AdjacencySetGraph graph, int[] visited, int currentVertex) {
		@SuppressWarnings("unchecked")
		Queue<Integer> queue=new Queue(Integer.class);
		queue.add(currentVertex);
		while(!queue.isEmpty()){
			int vertex=queue.poll();
			if(visited[vertex]==1){
				continue;
			}
			
			System.out.println(vertex+"->");
			
			List<Integer> list =graph.getAdjacentVertices(vertex);
			
			for(int v:list){
				if(visited[v]!=-1){
					queue.add(v);
				}
			}
		}
	}
}
