package interview.preperation.kit.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * 
 * @author Manivannan
 *
 *Given skyline of a city merge the buildings
 *
 *Time Complexity: O(NLogN)
 *Space Complexity: O(N)
 *
 */
public class SkylineProblem {

	class BuildingPoint implements Comparable<BuildingPoint>{
		int x;
		int height;
		boolean isStart;
		
		@Override
		public int compareTo(BuildingPoint o) {
			//Return positive value if current object is greater than specified object
			//Return negative value if current object is less than specified object
			//Return 0 if both objects are equal
			
			/*
			 * If two buildingPoints are not at same point then store the smallest first
			 * else
			 * if both are starting points then store the point with highest height first
			 * if both are ending points then store the point with smaller height first
			 * if one is ending point and other is starting point then store the starting point first
			 * */
			if(this.x != o.x) {
				return this.x - o.x;
			}else {
				return ((this.isStart)? -this.height: this.height) - ((o.isStart? -o.height: o.height));
			}
		}
		
	}
	
	public ArrayList<int[]> getSkyline(int buildings[][]) {
		
		BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
		int i = 0;
		for(int[] building : buildings) {
			buildingPoints[i] = new BuildingPoint();
			buildingPoints[i].x = building[0];
			buildingPoints[i].height = building[2];
			buildingPoints[i].isStart = true;
			
			buildingPoints[i + 1] = new BuildingPoint();
			buildingPoints[i + 1].x = building[1];
			buildingPoints[i + 1].height = building[2];
			buildingPoints[i + 1].isStart = false;
			
			i = i + 2;
		}
		
		Arrays.sort(buildingPoints);
		
		/*for(BuildingPoint buildingPoint : buildingPoints) {
			System.out.println(buildingPoint.x + " " + buildingPoint.height +" "+ buildingPoint.isStart);
		}*/
		
		//TreeMap stores the key-value pairs in sorted order. Here we are using the height as key and values as the count.
		//We can also use priority queue for this but it takes O(N) time for remove(object) whereas TreeMap take O(NLogN) time for removal of object.
		TreeMap<Integer, Integer> queue = new TreeMap<Integer, Integer>();
		
		queue.put(0,  1);//Set initial height value as 0
		
		ArrayList<int[]> result = new ArrayList<int[]>();
		int previousMax = 0, currentMax = 0;
		for(BuildingPoint buildingPoint : buildingPoints) {
			
			if(buildingPoint.isStart) {
				
				//If map has the key then increment and update its value
				queue.compute(buildingPoint.height, (key, value) -> {
					if(value != null) {
						return value + 1;
					}else {
						return 1;
					}
				});
				
			}else {
				//If map has the key then decrement and update its value
				queue.compute(buildingPoint.height, (key, value) -> {
					if(value == 1) {
						return null;
					}else {
						return value - 1;
					}
				});
				
			}
			
			currentMax = queue.lastKey();
			
			if(currentMax != previousMax) {
				result.add(new int[] {buildingPoint.x, currentMax});
				previousMax = currentMax;
			}
			
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		int [][] buildings = {{1,3,4},{3,4,4},{2,6,2},{8,11,4}, {7,9,3},{10,11,2}};
		
		ArrayList<int[]> criticalPoints = new SkylineProblem().getSkyline(buildings);
		
		for(int[] p : criticalPoints) {
			System.out.println(p[0] + " " + p[1]);
		}
		
	}
	
}
