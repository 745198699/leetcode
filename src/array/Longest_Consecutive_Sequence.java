/**
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */
package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Longest_Consecutive_Sequence {
//    public int longestConsecutive(int[] nums) {
//    	if(nums.length==0||nums==null)
//    		return 1;
//        int max =0;
//        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//        for(int num:nums){
//        	if(map.containsKey(num)){//如果map中有num，表示num是重复出现的，忽略
//        		continue;
//        	}else{
//        		int left = (map.containsKey(num-1))?map.get(num-1):0;
//        		int right= (map.containsKey(num+1))?map.get(num+1):0;
//        		int cur_len = right+left+1;
//        		map.put(num, cur_len);
//        		map.put(num-left, cur_len);
//        		map.put(num+right, cur_len);
//        		max=Math.max(max, cur_len);
//        	}
//        }
//        
//        
//        return max;
//    }
	
	public int longestConsecutive(int[] nums) {
		int max=0;
		Set<Integer> set = new HashSet<Integer>();
		for(int num:nums)
			set.add(num);
		for(int num:nums)
		{
			if(set.contains(num-1))
				continue;
			else{
				int len=0;
				while(set.contains(num++)){
					len++;
				}
				max=Math.max(max, len);
			}
		}
		
		return max;
	}

	public static void main(String[] args) {

	}

}
