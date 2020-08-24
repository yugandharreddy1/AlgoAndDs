package ds.io.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {

	public static void main(String[] args) {
		int n = 3;
		int [][] edges = {{0,1,100},{1,2,100},{0,2,500}};
		int	src = 0, dst = 2, k = 1;
		findCheapestPrice(n,edges,src,dst,k);
	}
	static class Destination {
         int city, cost, stops;
         Destination(int city, int cost, int stops) {
             this.city = city;
             this.cost = cost;
             this.stops = stops;
         }
     }
 
 
     public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
         int[][] costs = new int[n][n];
         for (int[] flight : flights) {
             costs[flight[0]][flight[1]] = flight[2];
         }
         Queue<Destination> destinations = new LinkedList<>();
         destinations.add(new Destination(src, 0, 0));
         int[] tripCosts = new int[n];
         Arrays.fill(tripCosts, -1);
         tripCosts[src] = 0;
         while (!destinations.isEmpty()) {
             Destination d = destinations.poll();
             if (d.stops > K) continue;
             for (int i = 0; i < n; i++) {
                 if (costs[d.city][i] == 0) continue;
                 int cost = d.cost + costs[d.city][i];
                 if (tripCosts[i] == -1 || cost < tripCosts[i]) {
                     tripCosts[i] = cost;
                     destinations.add(new Destination(i, cost, d.stops + 1));
                 }
             }
         }
         return tripCosts[dst];
     }
}
