package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets2 {
	
    public List<List<Integer>> subsetsWithDup(int[] nums) {
//    	List<List<Integer>> results_L = new ArrayList<>();
    	List<List<Integer>> results = new ArrayList<>();
		results.add(new ArrayList<Integer>());
		  
		if (nums.length==0)
			return results;
		  
		Arrays.sort(nums);
		  
		for(int i:nums){
			List<List<Integer>> temp = new ArrayList<>();
			for(List<Integer> list:results){
				List<Integer>a = new ArrayList<>(list);
				a.add(i);
				temp.add(a);
			}
		  	results.addAll(temp);
		}
		return results;
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]nums = {1,2,2};
		Subsets2 subsets = new Subsets2();
		subsets.subsetsWithDup(nums);
	}

}
