/**
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.


More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
package array;

public class Maximum_Subarray {

	public int maxSubArray(int[] A) {
//		int maxSoFar=A[0], maxEndingHere=A[0];
//		for (int i=1;i<A.length;++i){
//			maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
//			maxSoFar=Math.max(maxSoFar, maxEndingHere); 
//		}
//		return maxSoFar;
		
		int max=A[0];
		int maxEndWith=A[0];
		for(int i=1;i<A.length;i++){
			if(maxEndWith<0){
				maxEndWith=A[i];
			}else{
				maxEndWith+=A[i];
			}
			max=Math.max(maxEndWith, max);
		}
		
		
		return max;
	}

	public static void main(String[] args) {
		int i=new Maximum_Subarray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
		System.out.println(i);
	}

}
