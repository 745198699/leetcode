package array;

public class Trapping_Rain_Water {
	
//	public int trap(int[] height) { //time out
//		if(height.length==0)
//			return 0;
//		//get max height
//        int max_height = height[0];
//        for(int i=0;i<height.length;i++){
//        	if(max_height<=height[i])
//        		max_height = height[i];
//        }
//        
//        
//        boolean isStart = false;
//        int count =0;
//        for(int h=0;h<max_height;h++){//height循环
//        	int temp=0;
//        	for(int i=0;i<height.length;i++){
//        		if(height[i]<=h&&isStart){
//        			temp++;
//        		}
//        		
//        		if(height[i]>h&&!isStart){
//        			isStart=true;
//        		}
//        		
//        		if(height[i]>h&&isStart){
//        			count+=temp;
//        			temp=0;
//        		}
//        	}
//        	temp=0;
//        	isStart=false;
//        	
//        }
//		
//		return count;
//    }
	
//	public int trap(int[] A) {
//        int i = 0, j = A.length - 1, result = 0, plank = 0;
//        while(i <= j){
//            plank = plank < Math.min(A[i], A[j]) ? Math.min(A[i], A[j]) : plank;
//            result = A[i] >= A[j] ? result + (plank - A[j--]) : result + (plank - A[i++]);
//        }
//        return result;
//    }
	
	public int trap(int []height){
		
		if(height.length<=2)
			return 0;
		
		//get max height
		int max_height = height[0];
		int max_index = 0;
		for(int i=0;i<height.length;i++){
			if(max_height<=height[i]){
				max_height = height[i];
				max_index=i;
			}
		}
		
		int result=0;
		
		int jubu_max_l=height[0];
		for(int i=1;i<max_index;i++){
			if(height[i]>=jubu_max_l)
				jubu_max_l = height[i];
			else
				result += (jubu_max_l-height[i]);
		}
		int jubu_max_r =height[height.length-1];
		for(int i=height.length-2;i>max_index;i--){
			if(height[i]>=jubu_max_r)
				jubu_max_r=height[i];
			else
				result += (jubu_max_r-height[i]);
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[]height = {0,1,0,2,1,0,1,3,2,1,2,1};
//		int []height = {};
		Trapping_Rain_Water  rain_Water = new Trapping_Rain_Water();
		System.out.println(rain_Water.trap(height));
	}

}
