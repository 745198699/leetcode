/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 */
package array;

public class Search_in_Rotated_Sorted_Array {
	
    public int search(int[] nums, int target) {
    	if(nums.length==0)
    		return -1;
    	
    	return getIndex(nums,0,nums.length-1,target);
    	

    }
    
    private int binarySearch(int []nums,int start,int end,int target){
    	while(start<=end){
			int mid = (start+end)/2;
			if(target>nums[mid])
				start=mid+1;
			else if(target<nums[mid])
				end=mid-1;
			else
				return mid;
		}
		return -1;
    }

    private int getIndex(int nums[],int start,int end,int target){
        int MID = (start+end) /2;
        
        if(nums[MID]>nums[start]){
        	if(target<=nums[MID]&&target>=nums[start]){
        		return binarySearch(nums, start, MID, target);
        	}else{
        		return getIndex(nums, MID, end,target);
        	}
        }
        else if(nums[MID]<nums[start]){
        	if(target>=nums[MID]&&target<=nums[end]){
        		return binarySearch(nums, MID, end, target);
        	}else{
        		return getIndex(nums, start, MID,target);
        	}
        }else{
        	if(nums[start]==target)
        		return start;
        	else if(nums[end]==target)
        		return end;
        	else
        		return -1;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search_in_Rotated_Sorted_Array array = new Search_in_Rotated_Sorted_Array();
		int [] nums = {1,3};
		int target = 3;
		System.out.println(array.search(nums, target));
	}

}
