/*
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].
 */
package array;

public class Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
    	int re[]=new int[nums.length];
        re[0]=1;
        //左侧所有元素的乘积
        for(int i=1;i<nums.length;i++)
        	re[i]=re[i-1]*nums[i-1];
        
        //再累乘右侧元素
        int temp=1;
        for(int i=nums.length-1;i>=0;i--){
        	re[i]*=temp;
        	temp*=nums[i];
        }
    	
    	return re;
    }
	public static void main(String[] args) {
		Product_of_Array_Except_Self array_Except_Self = new Product_of_Array_Except_Self();
		array_Except_Self.productExceptSelf(new int[]{1,2,3,4});
	}

}
