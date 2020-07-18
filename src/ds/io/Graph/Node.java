package ds.io.Graph;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Node {

	private int VertexNumber;
	private Set<Integer> adjacencySet=new HashSet<>();
	
	public Node(int VertexNumber){
		this.VertexNumber=VertexNumber;
	}
	
	public int getVertexNumber(){
		return VertexNumber;
	}
	
	public void addEdge(int vertexNumber){
		adjacencySet.add(vertexNumber);
	}
	
	public ArrayList<Integer> getAdajentVertices(){
		ArrayList<Integer> sortedList=new ArrayList<>(adjacencySet);
		Collections.sort(sortedList);
		return sortedList;
		
	}
}
