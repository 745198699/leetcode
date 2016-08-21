package string;

public class Multiply_Strings {
    public String multiply(String num1, String num2) {
        int token = 0;
        char[]n1 = num1.toCharArray();
        char[]n2 = num2.toCharArray();
        int[][]re = new int[n2.length][n1.length+n2.length];
//        int start=0;//记录起始位置
        for(int i=num2.length()-1;i>=0;i--){
        	int int2 = Character.getNumericValue(n2[i]); // 选取第二个数的一位，与第一个数做乘法
        	int i1 = n1.length-1;
        	int index = re[0].length-1-(num2.length()-1-i);
        	token =0 ;
        	
        	while(i1>=0||token>0){
            	int int1 = i1>=0 ? Character.getNumericValue(n1[i1]):0;
            	int mulRes = int1*int2+token;
            	token = mulRes/10;
            	int ch = mulRes%10;
            	re[num2.length()-1-i][index]=ch;
//            	start = index;
            	i1--;
            	index--;
            }
        }
        
        //累加re[][]中的乘法结果
        char[]res = new char[re[0].length];
        int temp=0;
        for(int i=res.length-1;i>=0;i--){
        	int add=0;
        	for(int j=0;j<re.length;j++){
        		add+=re[j][i];
        	}
        	add+=temp;
        	res[i]=(char)('0'+add%10);
        	temp = add/10;
        }
        int start = 0;
        for(char c : res)
        {
        	if(c!='0'){
        		break;
        	}else{
        		start++;
        	}
        }
        
        return start==res.length?"0":new String(res, start, res.length-start).trim();
        
    }
	public static void main(String[] args) {
		System.out.println(new Multiply_Strings().multiply("12", "3"));
	}
}
