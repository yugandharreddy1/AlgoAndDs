package ds.io.Graph;

import java.beans.Visibility;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import ds.io.Graph.Graph.GraphType;

public class KruskalAlgoSpanningTree {

	public static void main(String[] args) {
		GraphDijkstra graph=new GraphDijkstra(6, GraphType.DIRECTED);
		graph.addEdge(1, 2,2);
		graph.addEdge(1, 3,-4);
		graph.addEdge(2, 3,1);
		graph.addEdge(2, 4,4);
		graph.addEdge(3, 4,5);
		graph.addEdge(3, 5,-5);
		SpanningTree(graph);
	}

	private static void SpanningTree(GraphDijkstra graph) {

		//A priority queue to store and retrive the edges on the basis of their weights
		PriorityQueue<EdgeInfo> queue=new PriorityQueue<>(new Comparator<EdgeInfo>() {

			@Override
			public int compare(EdgeInfo o1, EdgeInfo o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}
		});
		
		//Add all edges to the priority Queue
		for(int i=0;i<graph.getNumVertices();i++){
			for(int neighbour:graph.getAdjacentVertices(i)){
				queue.add(new EdgeInfo(i, neighbour, graph.getWeightedEdge(i, neighbour)));
			}
		}
		
		Set<Integer> visitedVertices=new HashSet<>();
		Set<EdgeInfo> spanningTree =new HashSet<>();
		Map<Integer,Set<Integer>> edgeMap=new HashMap<>();
		
		for(int v=0;v<graph.getNumVertices();v++){
			edgeMap.put(v,(Set<Integer>) new HashMap<Integer,Set<Integer>>());
		}

		while(!queue.isEmpty() && spanningTree.size()<graph.getNumVertices()-1){
			EdgeInfo currentEdge=queue.poll();
			
			//Add the new edge to the edge map and see if it ends up in  a cycle.
			//if yes then discared this edge and get the next edge from Priority queue
			
			edgeMap.get(currentEdge.getVertex1()).add(currentEdge.getVertex2());
			if(hasCycle(edgeMap)){
				edgeMap.get(currentEdge.getVertex1()).remove(currentEdge.getVertex2());
				continue;
			}
			
			spanningTree.add(currentEdge);
			
			//Add both vertices to the visited list,the set will ensure that only one copy of the vertex exists
			visitedVertices.add(currentEdge.getVertex1());
			visitedVertices.add(currentEdge.getVertex2());
		}
		
		//check whether all vertices have been covered with the spannign tree.
		if(visitedVertices.size()!=graph.getNumVertices()){
			System.out.println("Mininmal spanning tree is not possible");
		}else{
			System.out.println("Minimal spanning tree using Kruskal's algo");
			for(EdgeInfo edgeInfo:spanningTree){
				System.out.println(edgeInfo);
			}
		}
	}

	private static boolean hasCycle(Map<Integer, Set<Integer>> edgeMap) {
		for(Integer sourceVertex:edgeMap.keySet()){
			LinkedList<Integer> queue=new LinkedList<>();
			queue.add(sourceVertex);
			Set<Integer> visitedVertices=new HashSet<>();
			while(!queue.isEmpty()){
				int currentVertex=queue.pollFirst();
				if(visitedVertices.contains(currentVertex)){
					return true;
				}
				
				visitedVertices.add(currentVertex);
				queue.addAll(edgeMap.get(currentVertex));
			}
		}
		return false;
	}
}
