package ds.io.LeetCode;

import java.util.LinkedList;
import java.util.List;

import ds.io.Graph.AdjacencyMatrixGraph;
import ds.io.Graph.Graph.GraphType;

public class NumberofConnectedComponentsInAnUndirectedgraph {
	static int[] visited;
	static AdjacencyMatrixGraph graph;
	public static void main(String[] args) {
		graph=new AdjacencyMatrixGraph(6, GraphType.DIRECTED);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		visited=new int[6];
		NumberOfconnectedComponents(graph);
	}

	private static int NumberOfconnectedComponents(AdjacencyMatrixGraph graph) {
		for(int i=0;i<graph.getNumVertices();i++){
			visited[i]=-1;
		}
		int count=0;

		for(int v=0;v<graph.getNumVertices();v++){
			if(visited[v]==-1){
				DFS(v,visited);
				count++;
			}
		}


		return count;

	}

	private static void DFS(int v, int[] visited) {
		visited[v]=1;
		LinkedList<Integer> queue=new LinkedList<>();      // add the source to queue 
		queue.add(v);

		while(!queue.isEmpty()){
			int currentVertex=queue.pollFirst();
			for(int i:graph.getAdjacentVertices(currentVertex)){   
				if(visited[currentVertex]==-1){
					DFS(v,visited);
				}
			}
		}	
	}
}
