/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */

package array;

public class Minimum_Size_Subarray_Sum {
	public int minSubArrayLen(int s, int[] nums) {
		//两个指针
		int startidx=0,endidx;
		int sum = 0;
		int minilength=Integer.MAX_VALUE;
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
			if(sum>=s) {
				endidx = i;
				for(int j=startidx; j<endidx; j++) {
					if(sum-nums[j]>=s) {
						sum = sum - nums[j];
						startidx ++;
					}else {
						break;
					}
				}
				minilength = Math.min(minilength, endidx-startidx+1);
			}
		}

		return minilength == Integer.MAX_VALUE ? 0 : minilength;
	}


	public int minSubArrayLen2(int s, int[] nums) {

		return solveNlogN(s,nums);
	}

	private int solveN(int s,int[]nums){
		if(nums==null||nums.length==0)
			return 0;
		int minlen =  Integer.MAX_VALUE;
		int[]sums = new int[nums.length+1];
		sums[0]=0;
		for(int i=0;i<nums.length;i++){
			sums[i+1]=sums[i]+nums[i];
		}
		int left=0,right=1;
		for(right=1;right<sums.length;right++){
			if(sums[right]-sums[left]>=s){
				while(left<=right&&sums[right]-sums[left]>=s){
					left++;
				}
				minlen=((right-left+1)<minlen?right-left+1:minlen);
			}
		}

		return minlen==Integer.MAX_VALUE?0:minlen;
	}

	private int solveNlogN(int s,int[]nums){
		int minlen =  Integer.MAX_VALUE;
		int[]sums = new int[nums.length+1];
		sums[0]=0;
		for(int i=0;i<nums.length;i++){
			sums[i+1]=sums[i]+nums[i];
		}
		for(int i=0;i<sums.length;i++){
			int end=binary_search(sums, i+1, sums.length-1, s+sums[i]);
			if (end == sums.length) break;
			minlen = ((end-i<minlen)?end-i:minlen);
		}
		return minlen==Integer.MAX_VALUE?0:minlen;
	}
	private int binary_search(int[]nums,int start,int end,int target){
		while(start<=end){
			int mid = start+((end-start)>>1);
			if(nums[mid]==target)
				return mid;
			if(target<nums[mid])
				end=mid-1;
			else
				start=mid+1;
		}
		return start;
	}
}
