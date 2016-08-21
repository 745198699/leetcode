package array;

public class Find_Minimum_in_Rotated_Sorted_Array_II {
	public int findMin(int[] nums) {
	    int left=0;int right = nums.length-1;
	    while(left<right){
	    	if(left+1==right)
	    		return nums[left]>nums[right]?nums[right]:nums[left];
	    	int mid = left+((right-left)>>1);
	    	if(nums[mid]<nums[mid-1])//找到转折点，return
	    		return nums[mid];
	    	if(nums[mid]==nums[left]&&nums[mid]==nums[right])
	    		//存在翻转，但是确定mid和转折点的位置关系，仅做left++处理
	    		left++;
	    	else if(nums[mid]>=nums[left]&&nums[mid]>nums[right]){
	    		//存在翻转，转折点在mid右侧
	    		left=mid+1;
	    	}else if(nums[mid]<nums[left]&&nums[mid]<=nums[right]){
	    		//存在翻转，转折点在mid的左侧
	    		right=mid-1;
	    	}else if(nums[mid]>=nums[left]&&nums[mid]<=nums[right]){
	    		//left和right之间不存在翻转，所以最小值是nums[left]
	    		return nums[0];
	    	}
	    }
	    //if not return in while,then left==right
		return nums[left];
	}
}
