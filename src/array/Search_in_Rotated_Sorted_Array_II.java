/*
Follow up for "Search in Rotated Sorted Array":

What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
 */
package array;

public class Search_in_Rotated_Sorted_Array_II {


	public boolean search(int[] nums, int target) {
		int left =0,right=nums.length-1;
		while(left<right){
			int mid = (left+right)/2;
			if(nums[mid]==target)
				return true;
			if(nums[mid]>nums[left]){//转折点在右侧
				if(target<nums[mid]&&target>=nums[left])
					right = mid -1;
				else
					left = mid +1;
			}else if(nums[mid]<nums[left]){//转折点在左侧
				if(target>nums[mid]&&target<=nums[right])
					left = mid +1;
				else
					right = mid -1;
				
			}else{//nums[mid]==nums[left]，此时无法判断转折点的位置，所以仅把left+1
				left++;
			}
		}
		if(target==nums[left])
			return true;
		else
			return false;
		
	}
	public static void main(String[] args) {
		int nums [] = {1,0,1,1,1};
		System.out.println(new Search_in_Rotated_Sorted_Array_II().search(nums, 0));
	}

}
