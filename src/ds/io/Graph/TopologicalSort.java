package ds.io.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ds.io.Graph.Graph.GraphType;

public class TopologicalSort {
	public static void main(String[] args) {
		AdjacencyMatrixGraph graph=new AdjacencyMatrixGraph(6, GraphType.DIRECTED);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		System.out.println(graph.getIndegree(1));
		System.out.println(graph.getIndegree(2));
		System.out.println(graph.getIndegree(3));
		System.out.println(graph.getIndegree(4));
		System.out.println(topologicalSort(graph));
	}

	public static List<Integer> topologicalSort(AdjacencyMatrixGraph graph) {
		LinkedList<Integer> queue=new LinkedList<>();
		Map<Integer,Integer> indegreeMap=new HashMap<>();


		for(int v=0;v<graph.getNumVertices();v++){
			int indgree=graph.getIndegree(v);     //indgree no of vertices point to this vertex
			indegreeMap.put(v, indgree);
			if(indgree==0){
				queue.add(v);                     // if indreee is 0 that means thats the starting vertex and we will add that to queue
			}

		}


		List<Integer> sortedList=new ArrayList<>();

		while(!queue.isEmpty()){
			
			int vertex=queue.pollLast();
			sortedList.add(vertex);              //will populated the sorted list based on the indgree =0 last indegree was added to queue and will poulate queu for sorted order


			List<Integer> adjacentVertices=graph.getAdjacentVertices(vertex);     //get adjacent vertices of the current vertex and loop over them

			for(int adjacentVertex:adjacentVertices){
				int updatedIndgree=indegreeMap.get(adjacentVertex)-1;             // update the indgree of all the adajacent verteices and if updated indgree is 0 then add to queue 
				indegreeMap.remove(adjacentVertex);
				indegreeMap.put(adjacentVertex, updatedIndgree);

				if(updatedIndgree==0){
					queue.add(adjacentVertex);
				}
			}

			if(sortedList.size()!=graph.getNumVertices()){
				System.out.println("Cyclic Graph");                               // if sorted list and size didnt match then its a cyclic graph
			}
		}

		return sortedList;

	}
}
