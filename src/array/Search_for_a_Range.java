/*
Given a sorted array of integers, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].
For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */
package array;

public class Search_for_a_Range {
	
    public int[] searchRange(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int [] results = new int [2];
        while(left<=right){
        	int mid = (left+right)/2;
        	if(nums[mid]==target){
        		//search left range
        		int lefttemp = mid;
        		while(nums[lefttemp]==target)
        		{
        			lefttemp--;
        			if(lefttemp==-1)
        				break;
        		}
        		results[0]=lefttemp+1;
        		//search right range
        		int righttemp = mid;
        		while(nums[righttemp]==target)
        		{
        			righttemp++;
        			if(righttemp==nums.length)
        				break;
        		}
        		results[1]=righttemp-1;
        		return results;
        	}
        	if(target<nums[mid])
        		right = mid-1;
        	else
        		left = mid +1;
        }
        //如果没有在循环里面内return，说明没有匹配到target，返回[-1,-1]
    	results[0]=results[1]=-1;
    	return results;
    }
	
	
	
	
	public static void main(String[] args) {
		int nums[]={1,1,1,1,1,1};
//		int re[] = new Search_for_a_Range().searchRange(nums, 1);
//		int re[] = new Solution1().searchRange(nums, 1);
//		System.out.println(re[0]+"~"+re[1]);
		new Solution2().searchRange(nums, 1);
	}

}
class Solution1 {
    public int[] searchRange(int[] A, int target) {
        int start = Solution1.firstGreaterEqual(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, Solution1.firstGreaterEqual(A, target + 1) - 1};
    }

    //find the first number that is greater than or equal to target.
    //could return A.length if target is greater than A[A.length-1].
    //actually this is the same as lower_bound in C++ STL.
    private static int firstGreaterEqual(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            //low <= mid < high
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                //should not be mid-1 when A[mid]==target.
                //could be mid even if A[mid]>target because mid<high.
                high = mid;
            }
        }
        return low;
    }
}

class Solution2{
	public int[] searchRange(int[] A, int target) {
		System.out.println(findFirst(A, target));
		System.out.println(findLast(A, target));
		return new int[]{findFirst(A, target),findLast(A, target)};
	}
	private int findFirst(int[] A, int target){
		int result = -1;
		int left=0,right=A.length-1;
		while(left<=right){
			int mid = left+((right-left)>>1);
//			int mid = (left+right)/2;
			if(target == A[mid]){
				result=mid;
			}
			if(target<=A[mid]){
				right=mid-1;
			}else{
				left=mid+1;
			}
		}
		return result;
	}
	private int findLast(int[] A, int target){
		int result =-1;
		int left=0,right=A.length-1;
		while(left<=right){
			int mid = left+((right-left)>>1);
			if(A[mid]==target)
				result=mid;
			if(target>=A[mid])
				left=mid+1;
			else
				right=mid-1;
		}
		return result;
	}
}