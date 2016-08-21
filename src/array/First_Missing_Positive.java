package array;

public class First_Missing_Positive {
	public int firstMissingPositive(int[] nums) {
		byte[] mark = new byte[150000];  
		mark[0]|=1;//set 0 mark,方便后续分析
		for(int i : nums){
			if(i>0){
				int byteBlock = i/8;//确定i在第几个byte里面
				int byteIndex = i%8;//确定i在byte中具体的位置
				mark[byteBlock]|=1<<byteIndex;//把i在byte[]中的标记位设置1
			}
		}
		
		for(int i=0;i<mark.length;i++){
			if(mark[i]!=255){ //如果为255，说明btye中标记位全部为1，如果不是255，说明存在0
				for(int j=0;j<=7;j++){
					if(mark[i]!=(mark[i]|(1<<j))){//找到具体的低位的0
						return (j+8*i);
					}
				}
			}
		}

		return -1;
	}
	public static void main(String[] args) {
		new First_Missing_Positive().firstMissingPositive(new int[]{1,2,3,5});
	}

}
