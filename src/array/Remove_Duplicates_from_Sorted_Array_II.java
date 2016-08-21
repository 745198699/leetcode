/*
 * Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
package array;

public class Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
    	if(nums.length<=1)
    		return nums.length;
        int index=1;
        for(int i=2;i<nums.length;i++){
        	if(nums[i]==nums[index]&&nums[i]==nums[index-1]){
        		continue;
        	}else{
        		nums[++index]=nums[i];
        	}
        }
    	
    	return index+1;
    }
	
	public static void main(String[] args) {
		Remove_Duplicates_from_Sorted_Array_II array_II = new Remove_Duplicates_from_Sorted_Array_II();
		System.out.println(array_II.removeDuplicates(new int[]{1,1,1,1,1,1,2,2}));
	}
}
