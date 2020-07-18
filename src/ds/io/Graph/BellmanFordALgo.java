package ds.io.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import ds.io.Graph.Graph.GraphType;

public class BellmanFordALgo {

	public static void main(String[] args) {
		GraphDijkstra graph=new GraphDijkstra(6, GraphType.DIRECTED);
		graph.addEdge(1, 2,2);
		graph.addEdge(1, 3,-4);
		graph.addEdge(2, 3,1);
		graph.addEdge(2, 4,4);
		graph.addEdge(3, 4,5);
		graph.addEdge(3, 5,-5);
		shortestPath(graph,1,5);
	}

	private static void shortestPath(GraphDijkstra graph, int source, int destination) {
		Map<Integer,DistanceInfoB> distanceTable=buildDistanceTable(graph,source,destination);
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

	private static Map<Integer, DistanceInfoB> buildDistanceTable(GraphDijkstra graph, int source, int destination) {
		Map<Integer,DistanceInfoB> distanceTable=new HashMap<>();

		for(int j=0;j<graph.getNumVertices();j++){
			distanceTable.put(j, new DistanceInfoB()); //  add Distance table entry for each node in the graph
		}


		//set up distace of the specificed source
		distanceTable.get(source).setDistance(0);
		distanceTable.get(source).setLastVertex(source);

		LinkedList<Integer> queue=new LinkedList<>();   //set up a sinple queue to explore all the vertices regardless of priorierty 


		for(int i=0;i<graph.getNumVertices()-1;i++){  //we need to iterate V-1 times

			for(int v=0;v<graph.getNumVertices();v++){
				queue.add(v);  //add all the vertices to the queue so we can explore every edge in this graph
			}


			//Keep track of the edges visited so we visit each edge just once in every iteration 
			Set<String> visitedEdges=new HashSet<>();
			while(!queue.isEmpty()){
				int currentVertex=queue.pollFirst();

				for(int neighbor:graph.getAdjacentVertices(currentVertex)){
					String edge=String.valueOf(currentVertex)+String.valueOf(neighbor);    //edge is repersented as a String of "01" ia an edge going from vertex 0 to vertex 1


					//Do not visit edges more than once in each iteration 
					if(visitedEdges.contains(edge)){
						continue;
					}

					visitedEdges.add(edge);

					int distance=distanceTable.get(currentVertex).getDistance()+graph.getWeightedEdge(currentVertex, neighbor);

					//Check the distances of the vertices and update if shoter routes are found
					if(distanceTable.get(neighbor).getDistance()>distance){
						distanceTable.get(neighbor).setDistance(distance);
						distanceTable.get(neighbor).setLastVertex(currentVertex);
					}
				}
			}


			//add all the vertices to the queue one last time to check for negitive cycle
			for(int v=0;v<graph.getNumVertices();v++){
				queue.add(v);
			}

			while(!queue.isEmpty()){
				int currentVertex=queue.pollFirst();

				for(int neighbor:graph.getAdjacentVertices(currentVertex)){   

					int distance=distanceTable.get(currentVertex).getDistance()+graph.getWeightedEdge(currentVertex, neighbor);

					//If the distance table can be updated for any vertex after number of vertices -1 iterations
					//it means we have a negitive cycle in the graph

					if(distanceTable.get(neighbor).getDistance()>distance){
						System.out.println("The Graph has a -ve Cycle");
					}
				}
			}
		}
		return distanceTable;
	}


}
