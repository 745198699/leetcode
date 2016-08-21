/**
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */
package array;

public class Maximum_Product_Subarray {
	
    public int maxProduct(int[] nums) {
        int max=nums[0];
        int maxEndHere=nums[0];
        int minEndHere=nums[0];
        
        for(int i=1;i<nums.length;i++){
        	int i1=maxEndHere*nums[i];
        	int i2=minEndHere*nums[i];
        	maxEndHere=Math.max(Math.max(i1, i2),nums[i]);
        	
        	minEndHere=Math.min(Math.min(i1, i2),nums[i]);
        	
        	max=Math.max(maxEndHere, max);
        }
    	
    	
    	return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = new Maximum_Product_Subarray().maxProduct(new int[]{-4,-3,-2});
		System.out.println(max);

	}

}
