package array;

public class Search_Insert_Position {
	
//    public int searchInsert(int[] nums, int target) {
//    	int len = nums.length;
//    	if(len==0)
//    		return 0;
//    	int start = 0;int end = len-1;
//    	while(end-start>1){
//    		int mid = (start+end)/2;
//    		if(nums[mid]>target){
//    			end = mid;
//    		}else if(nums[mid]<target){
//    			start = mid;
//    		}else{
//    			return mid;
//    		}
//    	}
//    	if(nums[start]==target)
//    		return start;
//    	if(nums[end]==target)
//    		return end;
//    	
//    	if(nums[start]>target)
//    		return start;
//    	else if(nums[end]<target)
//    		return end+1;
//    	else 
//    		return start+1;
//        
//    }

	public int searchInsert(int[] nums, int target) {
		int start = 0;int end = nums.length-1;
		while(start<=end){
//			int mid = (start+end)/2;
			int mid = start+(end-start)/2;
			if(nums[mid]==target)
				return mid;
			else if(nums[mid]>target)
				end = mid-1;
			else
				start = mid+1;
		}
		
		return start;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[]={0,1,2,3,5};
//		int nums[]={1,3};
		int tar = 4;
		Search_Insert_Position insert_Position = new Search_Insert_Position();
		System.out.println(insert_Position.searchInsert(nums, tar));
	}

}
