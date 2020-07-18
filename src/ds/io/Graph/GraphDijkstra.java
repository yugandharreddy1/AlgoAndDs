package ds.io.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ds.io.Graph.Graph.GraphType;

public class GraphDijkstra implements Graph{
	


	private int[][] adjacencyMatrix;
	private GraphType graphType=GraphType.DIRECTED;
	private int numVertices=0;

	public  GraphDijkstra(int numVertices,GraphType graphType) {

		this.numVertices=numVertices;
		this.graphType=graphType;
		adjacencyMatrix=new int [numVertices][numVertices];

		for(int i=0;i<numVertices;i++){
			for(int j=0;j<numVertices;j++){
				adjacencyMatrix[i][j]=0;
			}
		}


	}
	
	public int getNumVertices() {
		return numVertices;
	}

	public void setNumVertices(int numVertices) {
		this.numVertices = numVertices;
	}

	public int[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}

	public int getIndegree(int v){
		if(v<0||v>=numVertices){
			System.out.println("vertrices number is not valid");
		}
		int indegree=0;
		
		for(int i=0;i<numVertices;i++){
			if(adjacencyMatrix[i][v]!=0){
				indegree++;
			}
		}
		return indegree;
	}

	public void addEdge(int v1, int v2,int weight) {
		if(v1>=numVertices||v1<0||v2>=numVertices||v2<0){
			System.out.println("vertix number  is not valid");
		}
		
		adjacencyMatrix[v1][v2]=weight;
		
		if(graphType==GraphType.UNDIRECTED){
			adjacencyMatrix[v2][v1]=weight;
			
		}

	}

	@Override
	public List<Integer> getAdjacentVertices(int v) {
		if(v>=numVertices||v<0){
			System.out.println("vertix number is not valid");
		}
		
		List<Integer> adjacentverticesList=new ArrayList<>();
		for(int i=0;i<numVertices;i++){
			if(adjacencyMatrix[v][i]!=0){
				adjacentverticesList.add(i);
			}
		}
		
		Collections.sort(adjacentverticesList);
		return adjacentverticesList;
	}

	public int getWeightedEdge(int currentVertex, Integer neighbour) {
		
		return adjacencyMatrix[currentVertex][neighbour];
	}

	@Override
	public void addEdge(int v1, int v2) {
		// TODO Auto-generated method stub
		
	}



}
