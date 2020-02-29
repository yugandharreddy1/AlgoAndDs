package ds.io.LeepCode;

import java.util.*;
import java.util.Map.Entry;

public class Test {

	public static void main(String[] args) {
		String[] a = { "SOC1", "SOC2", "SOC3", "SOC4","SOC5" };
		HashMap<String, Double> map = new HashMap<String, Double>();
		map.put("SOC1", 100.00);
		map.put("SOC2", 200.00);
		map.put("SOC3", 300.00);
		map.put("SOC4", 400.00);
		map.put("SOC5",500.00);
		List<List<String>> list = new Test().getAllCombinations(Arrays.asList(a));
		for (List<String> arr : list) {
			StringBuffer socs = new StringBuffer();

			for (String temp : arr) {
				socs.append(temp.trim() + ";");
			}
			String tsoc = socs.toString();

			tsoc = tsoc.substring(0, tsoc.length() - 1);

			if (!map.containsKey(tsoc)) {
				String[] k = tsoc.split(";");
				Double sum = sum(k, map);
				if (!map.containsValue(sum)) {
					map.put(tsoc, sum);
				}
			}
		}
		for (Entry<String, Double> entry : map.entrySet())  
        System.out.println( "["+entry.getKey()+"]" +" "+  entry.getValue()); 
} 
	

	private static Double sum(String[] k, HashMap<String, Double> map) {
		Double sum = 0.00;
		for (String temp : k) {

			if (map.containsKey(temp)) {
				sum = sum + map.get(temp);
			}
		}

		return sum;
	}

	public List<List<String>> getAllCombinations(List<String> elements) {
		List<List<String>> combinationList = new ArrayList<List<String>>();
		for (long i = 1; i < Math.pow(2, elements.size()); i++) {
			List<String> list = new ArrayList<String>();
			for (int j = 0; j < elements.size(); j++) {
				if ((i & (long) Math.pow(2, j)) > 0) {
					list.add(elements.get(j) + " ");
				}
			}
			combinationList.add(list);
		}
		return combinationList;
	}
}