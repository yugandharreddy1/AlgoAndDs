package ds.io.Graph;

import java.util.ArrayList;
import java.util.List;

import ds.io.Graph.Graph.GraphType;

public class AdjacencySetGraph implements Graph{
	
	private List<Node> verticesList=new ArrayList<Node>();
	private GraphType graphType=GraphType.DIRECTED;
	private int numVertices=0;
	
	
	public void AdjacencySetGraph(int numVerices,GraphType graphType){
		this.numVertices=numVerices;
		for(int i=0;i<numVerices;i++){
			verticesList.add(new Node(i));//for Adjacency list the node will have a linked list instaded of set
		}
		this.graphType=graphType;
	}
	
	
	public int getIndegree(int v){
		if(v<0||v>=numVertices){
			System.out.println("vertrices number is not valid");
		}
		int indegree=0;
		
		for(int i=0;i<numVertices;i++){
			if(getAdjacentVertices(i).contains(v)){
				indegree++;
			}
		}
		return indegree;
	}
	

	@Override
	public void addEdge(int v1, int v2) {

		if(v1>=numVertices||v1<0||v2>=numVertices||v2<0){
			System.out.println("vertix number  is not valid");
		}
		
		verticesList.get(v1).addEdge(v2);
		
		if(graphType==GraphType.UNDIRECTED){
			verticesList.get(v2).addEdge(v1);
			
		}
		
	}

	@Override
	public List<Integer> getAdjacentVertices(int v) {
		if(v>=numVertices||v<0){
			System.out.println("vertix number is not valid");
		}
		
		return verticesList.get(v).getAdajentVertices();
	}

}
