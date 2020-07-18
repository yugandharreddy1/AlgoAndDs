package ds.io.Graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import ds.io.Graph.Graph.GraphType;

public class PrimsAlgoSpanningTree {
	public static void main(String[] args) {
		GraphDijkstra graph=new GraphDijkstra(6, GraphType.DIRECTED);
		graph.addEdge(1, 2,2);
		graph.addEdge(1, 3,-4);
		graph.addEdge(2, 3,1);
		graph.addEdge(2, 4,4);
		graph.addEdge(3, 4,5);
		graph.addEdge(3, 5,-5);
		SpanningTree(graph,1);
	}

	private static void SpanningTree(GraphDijkstra graph, int source) {
		Map<Integer,DistanceInfoD> distanceTable=new HashMap<>();

		//Set up priority queue which returns nodes in order of shortest distance from source - THE GREEDY SOLUTION 
		PriorityQueue<VertexInfoD> queue=new PriorityQueue<>(new Comparator<VertexInfoD>(){
			@Override
			public int compare(VertexInfoD v1,VertexInfoD v2){
				return ((Integer)v1.getDistance()).compareTo(v2.getDistance());  //sort by shortest distance
			}
		});



		for(int j=0;j<graph.getNumVertices();j++){
			distanceTable.put(j, new DistanceInfoD());   //add distance table entry for each node in the Graph
		}


		distanceTable.get(source).setDistance(0);
		distanceTable.get(source).setLastVertex(source);

		Map<Integer,VertexInfoD> vertexInfoMap=new HashMap<>();          // vertexInfo stores the vertex id and distance from source 

		VertexInfoD sourceVertexInfo =new VertexInfoD(source, 0);        //adding the source to the priority queue and setup a mapping to the vertex info for every vertex in the queue
		queue.add(sourceVertexInfo);
		vertexInfoMap.put(source, sourceVertexInfo);

		Set<String> spanningTree=new HashSet<>();                         //The spanning tree is the set of edges connecting all the nodes of the graph and edge is represented by "01" if it connects vertices 0 and 1
		Set<Integer> visitedVertices=new HashSet<>();                      // the vertices which weve already include in the spanning tree


		while(!queue.isEmpty()){

			VertexInfoD vertexInfo=queue.poll();
			int currentVertex=vertexInfo.getVertexId();

			//Do not re-visit vertices which are already part of the tree
			if(visitedVertices.contains(currentVertex)){
				continue;
			}
			visitedVertices.add(currentVertex);

			//If the current vertex is a source we do not have an edge yet
			if(currentVertex!=source){
				String edge=String.valueOf(currentVertex)+String.valueOf(distanceTable.get(currentVertex).getLastVertex());
				if(!spanningTree.contains(edge)){
					spanningTree.add(edge);
				}
			}

			for(Integer neighbour:graph.getAdjacentVertices(currentVertex)){
				int distance=graph.getWeightedEdge(currentVertex, neighbour);

				//If we find a new shortest path to the neighbour update the distance and last vertex.
				if(distanceTable.get(neighbour).getDistance()>distance){
					distanceTable.get(neighbour).setDistance(distance);
					distanceTable.get(neighbour).setLastVertex(currentVertex);

					VertexInfoD neighbourVertexInfo=vertexInfoMap.get(neighbour);
					if(neighbourVertexInfo!=null){
						queue.remove(neighbourVertexInfo);
					}

					neighbourVertexInfo=new VertexInfoD(neighbour, distance);
					vertexInfoMap.put(neighbour, neighbourVertexInfo);
					queue.add(neighbourVertexInfo);
				}
			}

		}

		for(String edge:spanningTree){
			System.out.println(edge);
		}
	}

}
