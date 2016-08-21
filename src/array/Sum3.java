package array;
import java.util.*;
public class Sum3 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums==null||nums.length<3)
			return res;
		Arrays.sort(nums);
		
		if(nums[nums.length-1]*3<0||nums[0]*3>0)
			return res;
		
		for(int i=0;i<nums.length;i++){
			if(nums[i]==0){
				if(i+2<nums.length&&nums[i+2]==0)
					res.add(Arrays.asList(0,0,0));
				break;
			}
			
			if(nums[i]+2*nums[nums.length-1]<0)//too small
				continue;
			if(nums[i]*3>0)//too large
				break;
			if(i>0&&nums[i]==nums[i-1])//skip duplicate
				continue;
			
			TwoSum(res,nums[i],nums,i+1,0-nums[i]);
		}
		System.out.println(res.toString());
		return res;
	}
	
	private void TwoSum(List<List<Integer>>res,int x,int[]nums,int i,int target){
		int start = i;int end = nums.length-1;
		while(start<end){
			if(nums[start]+nums[end]==target){
				res.add(Arrays.asList(x,nums[start],nums[end]));
				//skip duplicate
				int cur = nums[start];
				while(++start<end&&nums[start]==cur)
					;
				cur = nums[end];
				while(--end>start&&nums[end]==cur)
					;
				continue;
			}
			if(nums[start]+nums[end]>target){
				end--;
			}else{
				start++;
			}
		}
	}
	public static void main(String[] args) {
		new Sum3().threeSum(new int[]{2,0,-2,-5,-5,-3,2,-4});
	}

}
