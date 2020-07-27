package ds.io.LeetCode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Testing {
	public static void main(String[] args) throws IOException {
		Cences c=new Cences("yogi", 1994, 2090);
		Cences c1=new Cences("c1", 1900, 2000);
		Cences c2=new Cences("c2", 2004, 2080);
		Cences c3=new Cences("c3", 2020, 2100);
		Cences c4=new Cences("c4", 1993, 2020);
		Cences c5=new Cences("c5", 1989, 2005);
		Cences c6=new Cences("c6", 1863, 1990);
		Cences c7=new Cences("c7", 1763, 2000);
		Cences c8=new Cences("c8", 2000, 2050);
		List<Cences> l=new ArrayList<>();
		l.add(c);l.add(c1);l.add(c2);l.add(c3);l.add(c4);l.add(c5);l.add(c6);l.add(c7);l.add(c8);
		
		System.out.println(findMaxPopulatedYear(l,2003));

	}
    private static int findMaxPopulatedYear(List<Cences> l, int resultYear) {
    	Map<Integer,Integer> map=new HashMap<>();
    	int pouplation=0;
    	for(int i=0;i<l.size();i++){
    		if(!map.containsKey(l.get(i).getBirthYear())){
    			map.put(l.get(i).getBirthYear(), 1);
    		}else{
    			map.put(l.get(i).getBirthYear(), map.get(l.get(i).getBirthYear())+1);
    		}
    		
    		if(!map.containsKey(l.get(i).getDeathYear())){
    			map.put(l.get(i).getDeathYear(), -1);
    		}else{
    			map.put(l.get(i).getDeathYear(), map.get(l.get(i).getDeathYear())-1);
    		}
    	}
    	
    	int lastYear=0;
    	for(int i:map.keySet()){
    		if(i<=resultYear){
    			pouplation+=map.get(i);
    		}
    	}
		return pouplation;
		
	}

}
