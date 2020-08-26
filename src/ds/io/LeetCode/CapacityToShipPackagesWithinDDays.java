package ds.io.LeetCode;

public class CapacityToShipPackagesWithinDDays {

	public static void main(String[] args) {
		int[] weights = {1,2,3,4,5,6,7,8,9,10};
		int D = 5;
		shipWithinDays(weights,D);

	}
	public static int shipWithinDays(int[] weights, int D) {
		/*
		 * Find the least possible capacity of ship. It will be maximum of -> the
		 * largest item or the weight on one ship if the weight is evenly distributed on
		 * all the ships i.e. (sum_of_all_items)/(total_ships)
		 */
		int heaviestItem = weights[0];
		int weightSum = 0;
		for (int x : weights) {
			heaviestItem = Math.max(heaviestItem, x);
			weightSum += x;
		}
		int avgWeightOnShip = (int) weightSum / D;
		// Minimum required weight capacity of a ship
		int minWeight = Math.max(heaviestItem, avgWeightOnShip);

		// Start from minimum possible size to maximum possible
		for (int i = minWeight; i <= weights.length * minWeight; i++) {
			int[] ship = new int[D];
			int index = 0;
			// Fill all the ships
			for (int j = 0; j < ship.length; j++) {
				// Try to fit as many items as possible
				while (index < weights.length && ship[j] + weights[index] < i) {
					ship[j] += weights[index];
					index++;
				}
			}
			if (index == weights.length)
				return i - 1;
		}
		return 0;
	}
}
