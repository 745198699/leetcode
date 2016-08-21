/*
shortest step of jump game
 */
package array;

import java.util.LinkedList;
import java.util.Queue;

public class Jump_Game2 {

//    public int jump(int[] nums) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(0);
//        for(int step=1;step<nums.length-1;step++){
//        	int index = queue.poll();
//        	for(int i=1;i<=nums[index];i++){
//        		if((index+i)>=nums.length-1)
//        			return step;
//        		queue.add(index+i);
//        	}
//        }
//    	return -1;
//    }
    public int jump(int[] nums) {
    	int currentMax=0;
    	int nextMax=0;
    	int step=0;
    	int i=0;
    	while(i<=nums.length-1){
    		currentMax=nextMax;
    		if(nextMax>=nums.length-1)
	    		return step;
	    	while(i<=currentMax){
	    		nextMax=Math.max(nextMax, nums[i]+i);
	    		i++;
	    	}
	    	step++;
    	}
    	return 0;
    }
    public static void main(String[] args) {
		new Jump_Game2().jump(new int[]{0});
	}
}
