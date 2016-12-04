/**
Given nums = [-2, 0, 3, -5, 2, -1]
sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
 */
package dp;
import java.awt.font.NumericShaper;
import java.util.*;
public class NumArray {
	int sums[];
    public NumArray(int[] nums) {
    	int len = nums.length;
        sums = new int[len];
        int sum=0;
        for(int i=0;i<len;i++){
        	sum+=nums[i];
        	sums[i]=sum;
        }
    }

    public int sumRange(int i, int j) {
        if(i==0)
        	return sums[j];
        return sums[j]-sums[i-1];
    }
    
	public static void main(String[] args) {
		int i = new NumArray(new int[]{-2,0,3,-5,2,-1}).sumRange(2, 5);
		System.out.println(i);
	}

}
