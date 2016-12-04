package array;
import java.util.*;
public class Find_All_Duplicates_in_Array {
    public List<Integer> findDuplicates(int[] nums) {
    	List<Integer> res = new ArrayList<>();
    	
    	for(int i=0;i<nums.length;i++){
    		int index = Math.abs(nums[i])-1;
    		if(nums[index] < 0){
    			res.add(index+1);
    		}
    		nums[index] = -nums[index];
    	}
    	
    	
    	return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
