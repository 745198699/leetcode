/**
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 */
package array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Jump_Game {

    public boolean canJump(int[] nums) {
    	int reachMax=0;
    	if(reachMax>=nums.length-1)
			return true;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]!=0){
        		reachMax = Math.max(reachMax, nums[i]+i);
        	}else if(reachMax==i)
        			return false;
        }
    	return true;
    }
	public static void main(String[] args) {
		System.out.println(new Jump_Game().canJump(new int[]{2,0,0}));
	}

}
