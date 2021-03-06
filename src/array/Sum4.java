package array;
import java.util.*;
public class Sum4 {
	public static void main(String[] args) {
		new Sum4().fourSum(new int[]{-2,-1,0,0,0,0,0,0,0,1,2,2,2,2,2,2}, 0);
	}

//		public List<List<Integer>> fourSum(int[] nums, int target) {
//			Arrays.sort(nums);
//			
//			List<List<Integer>> result = new ArrayList<List<Integer>>();
//			List<Integer> cur = new ArrayList<Integer>();
//			if(nums.length<4)
//				return result;
//			for(int i=0;i<nums.length-3;i++){
//				if(i>0&&nums[i]==nums[i-1])
//					continue;
//				for(int j=i+1;j<nums.length-2;j++){
//					if(j>i+1&&nums[j]==nums[j-1])
//						continue;
//					for(int k=j+1;k<nums.length-1;k++){
//						if(k>j+1&&nums[k]==nums[k-1])
//							continue;
//						int rest = target-nums[i]-nums[j]-nums[k];
//						int restIndex = binarySearch(nums, k+1, rest);
//						if(restIndex!=-1){
//							cur.add(nums[i]);
//							cur.add(nums[j]);
//							cur.add(nums[k]);
//							cur.add(nums[restIndex]);
//							result.add(new ArrayList<Integer>(cur));
//							cur.clear();
//						}
//							
//					}
//				}
//			}
//			System.out.println(result);
//			return result;
//		}
//		
//		private int binarySearch(int[]nums,int start,int rest){
//			int end = nums.length-1;
//			while(start<=end){
//				int mid = start+(end-start)/2;
//				if(nums[mid]==rest)
//					return mid;
//				else if(nums[mid]>rest)
//					end = mid -1;
//				else 
//					start=mid+1;
//			}
//			return -1;
//		}
	public List<List<Integer>> fourSum(int[] nums, int target) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		int len = nums.length;
		if (nums == null || len < 4)
			return res;

		Arrays.sort(nums);

		int max = nums[len - 1];
		if (4 * nums[0] > target || 4 * max < target)
			return res;

		int i, z;
		for (i = 0; i < len; i++) {
			z = nums[i];
			if (i > 0 && z == nums[i - 1])// avoid duplicate
				continue;
			if (z + 3 * max < target) // z is too small
				continue;
			if (4 * z > target) // z is too large
				break;
			if (4 * z == target) { // z is the boundary
				if (i + 3 < len && nums[i + 3] == z)
					res.add(Arrays.asList(z, z, z, z));
				break;
			}

			threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
		}

		return res;
	}

	/*
	 * Find all possible distinguished three numbers adding up to the target
	 * in sorted array nums[] between indices low and high. If there are,
	 * add all of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, the three numbers))
	 */
	public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
			int z1) {
		if (low + 1 >= high)
			return;

		int max = nums[high];
		if (3 * nums[low] > target || 3 * max < target)
			return;

		int i, z;
		for (i = low; i < high - 1; i++) {
			z = nums[i];
			if (i > low && z == nums[i - 1]) // avoid duplicate
				continue;
			if (z + 2 * max < target) // z is too small
				continue;

			if (3 * z > target) // z is too large
				break;

			if (3 * z == target) { // z is the boundary
				if (i + 1 < high && nums[i + 2] == z)
					fourSumList.add(Arrays.asList(z1, z, z, z));
				break;
			}

			twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
		}

	}

	/*
	 * Find all possible distinguished two numbers adding up to the target
	 * in sorted array nums[] between indices low and high. If there are,
	 * add all of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
	 */
	public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
			int z1, int z2) {

		if (low >= high)
			return;

		if (2 * nums[low] > target || 2 * nums[high] < target)
			return;

		int i = low, j = high, sum, x;
		while (i < j) {
			sum = nums[i] + nums[j];
			if (sum == target) {
				fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

				x = nums[i];
				while (++i < j && x == nums[i]) // avoid duplicate
					;
				x = nums[j];
				while (i < --j && x == nums[j]) // avoid duplicate
					;
			}
			if (sum < target)
				i++;
			if (sum > target)
				j--;
		}
		return;
	}

}
