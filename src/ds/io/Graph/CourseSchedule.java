package ds.io.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ds.io.Graph.Graph.GraphType;

public class CourseSchedule {

	public static void main(String[] args) {
		List<Integer> courseList=new ArrayList<>();
		courseList.add(101);
		courseList.add(102);
		courseList.add(103);
		courseList.add(104);
		courseList.add(105);
		courseList.add(106);
		courseList.add(107);
		
		Map<Integer,List<Integer>> prereqs=new HashMap<>();
		
		prereqs.put(101, Arrays.asList(102,103));
		prereqs.put(103, Arrays.asList(105));
		prereqs.put(104, Arrays.asList(105));
		prereqs.put(105, Arrays.asList(107));
		
		System.out.println(order(courseList,prereqs));
	}

	private static List<Integer> order(List<Integer> courseList, Map<Integer, List<Integer>> prereqs) {
		AdjacencyMatrixGraph graph=new AdjacencyMatrixGraph(courseList.size(), GraphType.DIRECTED);
		Map<Integer,Integer> courseIdMap=new HashMap<>();
		Map<Integer,Integer> idCourseMap=new HashMap<>();
		
		for(int i=0;i<courseList.size();i++){
			courseIdMap.put(courseList.get(i),i);
			idCourseMap.put(i, courseList.get(i));
		}
		
		for(Map.Entry<Integer,List<Integer>> prereq: prereqs.entrySet()){
			for(Integer course:prereq.getValue()){
				graph.addEdge(courseIdMap.get(prereq.getKey()), courseIdMap.get(course));
			}
		}
		
		List<Integer> courseIdList=TopologicalSort.topologicalSort(graph);
		
		List<Integer> courseScheduleList=new ArrayList<>();
		
		for(int courseId:courseList){
			courseScheduleList.add(idCourseMap.get(courseId));
		}
		
		return courseScheduleList;
	}
}
