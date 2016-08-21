package array;

public class Remove_Element {

    public int removeElement(int[] nums, int val) {
    	int len = nums.length;
    	int index=0;
    	if(len==0)
    		return 0;
    	for(int i=0;i<len;i++){
    		if(val!=nums[i]){
    			nums[index++]=nums[i];
    		}
    			
    			
    	}
    	
        return len;
    }
	public static void main(String[] args) {

	}

}
