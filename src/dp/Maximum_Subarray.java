package dp;

public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
    	int max = nums[0];
    	int max_end_here = nums[0];
    	for(int i=1;i<nums.length;i++){
    		if(max_end_here<0)
    			max_end_here = nums[i];
    		else
    			max_end_here+=nums[i];
    		max = Math.max(max_end_here, max);
    	}
    	return max;
    }
//    	if(nums==null || nums.length==0)
//    		return 0;
//        int dp[] = new int[nums.length];
//        int cur_max = Integer.MIN_VALUE;
//        dp[0] = nums[0];
//        for(int i=1;i<nums.length;i++){
//        	dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
//        	cur_max = Math.max(cur_max, dp[i]);
//        }
//        return cur_max;
//    }
}
