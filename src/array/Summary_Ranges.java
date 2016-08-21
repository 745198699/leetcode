package array;

import java.util.ArrayList;
import java.util.List;

public class Summary_Ranges {
	
	
//    public List<String> summaryRanges(int[] nums) {
//    	
//    	List<String> results = new ArrayList<String>();
//    	if (nums.length==0)
//    		return results;
//    	int start = nums[0];
//    	int end = nums[0];
//        for(int i=1;i<nums.length;i++){
//        	if((nums[i]-nums[i-1])==1){
//        		end=nums[i];
//        	}else {
//        		if(start==end)
//        			results.add(start+"");
//        		else
//        			results.add(start+"->"+end);
//				
//				start=nums[i];
//				end = nums[i];
//			}
//        }
//        
//        if(start==end)
//			results.add(start+"");
//		else
//			results.add(start+"->"+end);
//    	
//    	return results;
//    }

	public List<String> summaryRanges(int[] nums) {
		 List<String> results = new ArrayList<String>();
		 
		 for(int i=0;i<nums.length;i++){
			 int start = nums[i];
			 while((i<nums.length-1)&&(nums[i+1]-nums[i])==1){
				 i++;
			 }
			 if(start==nums[i]){
				 results.add(start+"");
			 }else{
				 results.add(start+"->"+nums[i]);
			 }
//			 start = nums[i+1];
		 }
		 
		 
		 
		 return results;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[]nums = {0,1,2,4,5,7};
//		int [] nums={};
		Summary_Ranges ranges = new Summary_Ranges();
		ranges.summaryRanges(nums);
	}

}
