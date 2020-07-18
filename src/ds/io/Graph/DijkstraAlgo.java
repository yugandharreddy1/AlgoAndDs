package ds.io.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import ds.io.Graph.Graph.GraphType;

public class DijkstraAlgo {



	public static void main(String[] args) {
		GraphDijkstra graph=new GraphDijkstra(6, GraphType.DIRECTED);
		graph.addEdge(1, 2,2);
		graph.addEdge(1, 3,4);
		graph.addEdge(2, 3,1);
		graph.addEdge(2, 4,4);
		graph.addEdge(3, 4,5);
		graph.addEdge(3, 5,5);
		shortestPath(graph,1,5);
	}

	private static void shortestPath(GraphDijkstra graph, int source, int destination) {
		Map<Integer,DistanceInfoD> distanceTable=buildDistanceTable(graph,source,destination);
		
		Stack<Integer> stack=new Stack<>();
		stack.push(destination);
		

		int previousVertex=distanceTable.get(destination).getLastVertex();               //backtrack by getting last vertex of every node and add it to stack.
		while(previousVertex!=-1 && previousVertex!=source){
			stack.push(previousVertex);
			previousVertex=distanceTable.get(previousVertex).getLastVertex();            //change previous vertex every time till its not equal to source
		}

		if(previousVertex==-1){                                                          //if periousVertex is -1 then there is no path from source to destination 
			System.out.println("there is no path form node source "+source +" to destination "+destination);
		}
		else{                                                                             // Else print the stack
			System.out.print("Smallest Path is  " +source);
			while(!stack.isEmpty()){
				System.out.print("-->"+stack.pop());
			}
		}
		
	}

	private static Map<Integer, DistanceInfoD> buildDistanceTable(GraphDijkstra graph, int source,int destination) {
		
		
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
		
		Map<Integer,VertexInfoD> vertecInfoMap=new HashMap<>();          // vertexInfo stores the vertex id and distance from source 
		
		VertexInfoD sourceVertexInfo =new VertexInfoD(source, 0);        //adding the source to the priority queue and setup a mapping to the vertex info for every vertex in the queue
		queue.add(sourceVertexInfo);
		vertecInfoMap.put(source, sourceVertexInfo);
		
		
		while(!queue.isEmpty()){
			VertexInfoD vertexInfoD=queue.poll();                        //Access the Priority queue to find the closest vertex - following Greedy algorithm
			int currentVertex=  vertexInfoD.getVertexId();
			
			for(Integer neighbour:graph.getAdjacentVertices(currentVertex)){     //iterate through all its neighbors 
				
				
				//Get the new distance ,account for the weighted edge
				//The distance to the adjacent vertex is now the distance of current vertex +weight of the edge
				int distance=distanceTable.get(currentVertex).getDistance()+graph.getWeightedEdge(currentVertex,neighbour);
				
				
				//If we find a new shortest path to the neighbour update
				//the distance and the last vertex
				if(distanceTable.get(neighbour).getDistance()>distance){
					distanceTable.get(neighbour).setDistance(distance);                                          //UPDATE
					distanceTable.get(neighbour).setLastVertex(currentVertex);
					
					
					//We've found a new path to the neighbor so remove old node from priority queue
					VertexInfoD neighbourVertecInfo=vertecInfoMap.get(neighbour);
					if(neighbourVertecInfo!=null){                                                               //REMOVE
						queue.remove(neighbourVertecInfo);
					}
					
					
					//Add the neighbour back with a new updated distance
					neighbourVertecInfo=new VertexInfoD(neighbour, distance);
					queue.add(neighbourVertecInfo);                                                              //ADD
					vertecInfoMap.put(neighbour, neighbourVertecInfo);
				}
			}
		}
		
		return distanceTable;
	}

}
