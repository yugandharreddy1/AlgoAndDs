package ds.io.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.print.attribute.standard.Destination;

import ds.io.Graph.Graph.GraphType;

public class ShortestPathGraph {

	static List<Integer> path=new ArrayList<Integer>();

	public static void main(String[] args) {
		AdjacencyMatrixGraph graph=new AdjacencyMatrixGraph(6, GraphType.DIRECTED);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		shortestPath(graph,1,5);
	}

	public static void shortestPath(AdjacencyMatrixGraph graph,int source,int destination){
		
		Map<Integer,DistanceInfo> distanceTable=buildDistanceTable(graph, source);       //Build the distance table  will all vertices and there last vertex

		Stack<Integer> stack=new Stack<>();                                              //Backtrack using a stack start from destination
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

	private static Map<Integer,DistanceInfo> buildDistanceTable(AdjacencyMatrixGraph graph,int source){
		
		Map<Integer,DistanceInfo> distanceTable=new HashMap<>();

		for(int j=0;j<graph.getNumVertices();j++){
			distanceTable.put(j, new DistanceInfo());      //build a Map with empty objects 
		}

		distanceTable.get(source).setDistance(0);          //Initialize the distance to the source and last vertex in the path to source
		distanceTable.get(source).setLastVertex(source);

		LinkedList<Integer> queue=new LinkedList<>();      // add the source to queue 
		queue.add(source);

		while(!queue.isEmpty()){
			int currentVertex=queue.pollFirst();
			for(int i:graph.getAdjacentVertices(currentVertex)){        //Explore the neighboring vertices of the every vertex added to the queue
				int currentDistance=distanceTable.get(i).getDistance();
				if(currentDistance==-1){                                // If the currentDistance is -1 that means that vertex is seen by first time then update its entry in distanceTable
					currentDistance=1+distanceTable.get(currentVertex).getDistance();
					distanceTable.get(i).setDistance(currentDistance);
					distanceTable.get(i).setLastVertex(currentVertex);

					//Enqueue the neighbour only if it has other adjacent vertices
					if(!graph.getAdjacentVertices(1).isEmpty()){
						queue.add(i);
					}
				}
			}

		}
		return distanceTable;

	}




}


