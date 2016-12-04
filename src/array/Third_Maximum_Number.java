package array;

public class Third_Maximum_Number {
    public int thirdMax(int[] nums) {
        long third_max = Long.MIN_VALUE;
        long second_max = Long.MIN_VALUE;
        long max = Long.MIN_VALUE;
        int count = 0;
        for(int i:nums){
        	if(i==max || i==second_max || i==third_max)
        		continue;
        	if(i>max){
        		third_max = second_max;
        		second_max = max;
        		max = i;
        		count++;
        	}else if(i>second_max){
        		third_max = second_max;
        		second_max = i;
        		count++;
        	}else if(i>third_max){
        		third_max=i;
        		count++;
        	}
        }
        
        return (int) ((count>=3)?third_max:max);
    }
    public static void main(String[] args) {
		System.out.println(new Third_Maximum_Number().thirdMax(new int[]{1,2,Integer.MIN_VALUE}));
	}
}
