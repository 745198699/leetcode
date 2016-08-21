package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> results = new ArrayList<>();
//        results.add(new ArrayList<Integer>());
//        
//        if (nums.length==0)
//        	return results;
//        
//        Arrays.sort(nums);
//        
//        for(int i:nums){
//        	List<List<Integer>> temp = new ArrayList<>();
//        	for(List<Integer> list:results){
//        		List<Integer>a = new ArrayList<>(list);
//        		a.add(i);
//        		temp.add(a);
//        	}
//        	results.addAll(temp);
//        }
//        
//        return results;
//    }
	
	public List<List<Integer>> subsets(int[] S) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();

	    if(S.length == 0){
	        return result;
	    }

	    Arrays.sort(S);
	    dfs(S, 0, new ArrayList<Integer>(), result);
	    return result;
	}

	public void dfs(int[] s, int index, List<Integer> path, List<List<Integer>> result){
	    result.add(new ArrayList<Integer>(path));

	    for(int i = index; i < s.length; i++){
	        path.add(s[i]);
	        dfs(s, i+1, path, result);
	        path.remove(path.size()-1);
	    }
	}
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[]nums = {1,2,3};
		Subsets subsets = new Subsets();
		subsets.subsets(nums);
	}

}
