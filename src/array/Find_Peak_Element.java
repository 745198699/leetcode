package array;

public class Find_Peak_Element {

    public int findPeakElement(int[] nums) {
    	int left=0;
    	int right=nums.length-1;
    	while(left<right){
    		if(left+1==right)
    			return (nums[left]>nums[right])?left:right;
    		int mid = left+((right-left)>>1);
    		if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1])
    			return mid;
    		if(nums[mid-1]<nums[mid+1]){//上升阶段
    			left=mid+1;
    		}else{//下降阶段
    			right=mid-1;
    		}
    	}
    	
    	return left;
    }
	public static void main(String[] args) {
		System.out.println(new Find_Peak_Element().findPeakElement(new int[]{2,1}));
	}

}
