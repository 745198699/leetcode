/**
Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array,
and it should return false if every element is distinct.
 */
package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Contains_Duplicate {
	
	
	public boolean containsDuplicate(int[] nums) {
	    byte[] mark = new byte[150000];
	    for (int i : nums) {
	        int j = i/8;
	        int k = i%8;
	        int check = 1<<k;
	        if ((mark[j] & check) != 0) {
	            return true;
	        }
	        mark[j]|=check;
	    }
	    return false;
	}

//		Set<Integer> set = new HashSet<>();
//		for(int n:nums){
//			if(set.contains(n))
//				return true;
//			set.add(n);
//		}
//		return false;
//	}
//    public boolean containsDuplicate(int[] nums) {
//        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//        for(int n:nums){
//        	if(map.containsKey(n))
//        		return true;
//        	else
//        		map.put(n,1);
//        }
//    	
//    	return false;
//    }
    public static void main(String[] args) {
		new Contains_Duplicate().containsDuplicate(new int[]{1,2,3,3});
	}
}
