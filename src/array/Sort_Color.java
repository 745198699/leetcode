package array;

public class Sort_Color {

//    public void sortColors(int[] nums) {
//    	int left = 0;
//    	int right = nums.length-1;
//    	int temp = -1;
//    	for(int i=0;i<=right;i++){
//    		
//    		if(nums[i]==0){
//    			temp = nums[left];
//    			nums[left] = nums[i];
//    			nums[i]=temp;
//    			left++;
//    		}
//    		if(nums[i]==2){
//    			temp = nums[right];
//    			nums[right]=nums[i];
//    			nums[i]=temp;
//    			right--;
//    			i--;
//    		}
//    		
//    	}
//    }
	public void sortColors(int[] nums) {
		int count0=0,count1=0,count2=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==0)
				count0++;
			if(nums[i]==1)
				count1++;
			if(nums[i]==2)
				count2++;
		}
		
		for(int i = 0; i < nums.length; i++) {
	        if (i < count0) {nums[i] = 0;}
	        else if (i < count0 + count1) {nums[i] = 1;}
	        else {nums[i] = 2;}
	    }
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[]={2,1,0,1,2};
		Sort_Color color = new Sort_Color();
		color.sortColors(nums);
		for(int i:nums)
			System.out.println(i);
	}

}
