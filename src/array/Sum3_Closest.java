package array;
import java.util.*;
public class Sum3_Closest {
	public static void main(String[] args) {
		int i=new Sum3_Closest().threeSumClosest(new int[]{1,1,1,0}, 100);
		System.out.println(i);
	}

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int minDif=Integer.MAX_VALUE;
		int res=0;
		for(int i=0;i<nums.length;i++){
			int start = i+1;
			int end = nums.length-1;
			while(start<end){
				int sum = nums[i]+nums[start]+nums[end];
				if(sum==target)
					return target;
				else if(sum<target){
					start++;
				}else{
					end--;
				}
				if(Math.abs(sum-target)<Math.abs(minDif)){
					minDif=sum-target;
					res=sum;
				}
					
			}
		}
		return res;
	}
//	public int threeSumClosest(int[] nums, int target) {
//		Arrays.sort(nums);
//		int minDif=Integer.MAX_VALUE;
//		for(int i=0;i<nums.length-2;i++){
//			int curDif=Two(nums,nums[i],i+1,target-nums[i]);
//			if(curDif==0)
//				return target;
//			if(Math.abs(curDif)<Math.abs(minDif)){
//				minDif=curDif;
//			}
//		}
//		
//		return target+minDif;
//	}
//	private int Two(int []nums,int z,int start,int target){
//		int minDif=Integer.MAX_VALUE;
//		int end = nums.length-1;
//		while(start<end){
//			int sum = nums[start]+nums[end];
//			if(sum==target)
//				return 0;
//			else if(sum>target){
//				end--;
//			}else{
//				start++;
//			}
//			if(Math.abs(sum-target)<Math.abs(minDif))
//				minDif=sum-target;
//		}
//		return minDif;
//	}
	//    public int threeSumClosest(int[] nums, int target) {
	//    	Arrays.sort(nums);
	//    	int min=Integer.MAX_VALUE;
	//    	int minSum=0;
	//    	for(int i=0;i<nums.length-2;i++){
	//    		if(i>0&&nums[i-1]==nums[i])
	//    			continue;
	//    		for(int j=i+1;j<nums.length-1;j++){
	//    			if(j>i+1&&nums[j-1]==nums[j])
	//    				continue;
	//    			for(int k=j+1;k<nums.length;k++){
	//    				if(k>j+1&&nums[k-1]==nums[k])
	//        				continue;
	//    				int sum = nums[i]+nums[j]+nums[k];
	//    				if(sum<target)
	//    				{
	//    					minSum=sum;
	//    					min=Math.abs(target-sum);
	//    				}else if(sum==target)
	//    					return sum;
	//    				else{
	//    					int dif = sum-target;
	//    					if(dif<=min){
	//    						min = sum;
	//    						minSum=sum;
	//    						break;
	//    					}
	//    					else{
	//    						break;
	//    					}
	//    				}
	//    			}
	//    		}
	//    	}
	//    	return minSum;
	//    }

}
