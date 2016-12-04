package array;
import java.util.*;
public class Find_All_Numbers_Disappeared_in_Array {
	//	public List<Integer> findDisappearedNumbers(int[] nums) {
	//		List<Integer> res = new ArrayList<>();
	//		int len = nums.length;
	//		for(int i=0;i<len;i++){
	//			if(nums[i]==i+1||nums[i]==0)
	//				continue;
	//			if(nums[i] == nums[nums[i]-1]){
	//				nums[i]=0;
	//				continue;
	//			}
	//			int temp = nums[nums[i]-1];
	//			nums[nums[i]-1] = nums[i];
	//			nums[i] = temp;
	//			i--;
	//		}
	//		for(int i=0;i<len;i++){
	//			if(nums[i]==0)
	//				res.add(i+1);
	//		}
	//
	//		return res;
	//	}
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int len = nums.length;
		for(int i=0;i<len;i++){
			int index = Math.abs(nums[i])-1;
			if(nums[index]>0)
				nums[index] = -nums[index];
		}
		for(int i=0;i<len;i++){
			if(nums[i]>0){
				res.add(i+1);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		System.err.println(new Find_All_Numbers_Disappeared_in_Array().findDisappearedNumbers(new int[]{1,3,3,5,5}));
	}
}
