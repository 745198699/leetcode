package string;

public class Add_Binary {
	public static String addBinary(String a, String b) {
		if(a==null||a.length()==0)
			return b;
		if(b==null||b.length()==0)
			return a;
		
		int aLen = a.length();
		int bLen = b.length();
		StringBuffer re = new StringBuffer();
		int carry = 0;
		int i=aLen-1;
		int j=bLen-1;
		int aInt =0;
		int bInt =0;
		while(i>=0||j>=0||carry==1){
			aInt = (i>=0)?Character.getNumericValue(a.charAt(i--)):0;
			bInt = (j>=0)?Character.getNumericValue(b.charAt(j--)):0;
			re.append(aInt^bInt^carry);
			carry = (aInt+bInt+carry)/2;
		}
		return re.reverse().toString();
	}
    
    public static void main(String[] args) {
		System.out.println(addBinary("11","11"));
	}
}
