package array;

public class Find_Minimum_in_Rotated_Sorted_Array {

    public int findMin(int[] nums) {
        int left=0;
        int right = nums.length-1;
        while(left<right){
        	if(left+1==right)
        		return nums[left]<nums[right]?nums[left]:nums[right];
        	int mid = left+((right-left)>>1);
        	if(nums[mid]<nums[mid-1])
        		return nums[mid];
        	if(nums[mid]>nums[right]){
        		left = mid +1;
        	}else{
        		right = mid -1;
        	}
        }
    	
    	return nums[left];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Find_Minimum_in_Rotated_Sorted_Array().findMin(new int []{6,1,2,3,4}));
	}

}
