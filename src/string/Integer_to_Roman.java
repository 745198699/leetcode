package string;

public class Integer_to_Roman {
	
	public String intToRoman(int num) {
		int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

	    StringBuilder sb = new StringBuilder();

	    for(int i=0;i<values.length;i++) {
	        while(num >= values[i]) {
	            num -= values[i];
	            sb.append(strs[i]);
	        }
	    }
	    return sb.toString();
	}
    public String intToRoman2(int num) {
    	String[][]table = {
    			{"","I","II","III","IV","V","VI","VII","VIII","IX"},
    			{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
    			{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
    			{"","M","MM","MMM"}
    		};
    	
        int num1 = num%10;
        num/=10;
        int num2 = num%10;
        num/=10;
        int num3 = num%10;
        num/=10;
        int num4 = num%10;
        num/=10;
        return table[3][num4]+table[2][num3]+table[1][num2]+table[0][num1];
    }
    
    public static void main(String[] args) {
		System.out.println(new Integer_to_Roman().intToRoman(9));
	}
}
