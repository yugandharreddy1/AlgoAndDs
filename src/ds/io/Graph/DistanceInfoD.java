package ds.io.Graph;

public class DistanceInfoD {

	
	private int distance;
	private int lastVertex;
	
	public  DistanceInfoD() {
		this.distance=Integer.MAX_VALUE;
		this.lastVertex=-1;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getLastVertex() {
		return lastVertex;
	}
	public void setLastVertex(int lastVertex) {
		this.lastVertex = lastVertex;
	}



}
