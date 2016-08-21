/**
Given an array of integers and an integer k,
find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 */
package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
//    	Map<Integer,Integer> map = new HashMap<>();
//    	for(int i=0;i<nums.length;i++){
//    		Integer index = map.get(nums[i]);
//    		if(index==null)
//    			map.put(nums[i], i);
//    		else{
//    			if(i-index<=k)
//    				return true;
//    			else
//    				map.put(nums[i],i);
//    		}
//    	}
//    	
//    	return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
