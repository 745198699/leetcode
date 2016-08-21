/*
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 */
package array;

public class Plus_One {
	public int[] plusOne(int[] digits) {
		for(int i=digits.length-1;i>=0;i--){
			if(digits[i]<9){
				digits[i]++;
				return digits;
			}
			digits[i]=0;
		}
		//if not return in-For,mean the digits is 99……9
		int [] newDigits = new int[digits.length+1];
		newDigits[0]=1;
		return newDigits;
	}
//    public int[] plusOne(int[] digits) {
//        int[]re = new int[digits.length+1];
//        int jinwei=1;
//        for(int i=re.length-1;i>0;i--){
//        	re[i]=(digits[i-1]+jinwei)%10;
//        	jinwei=(digits[i-1]+jinwei)/10;
//        }
//        if(jinwei==1){
//        	re[0]=1;
//        	return re;
//        }
//        else{
//        	int[]a=new int[digits.length];
//        	for(int i=0;i<a.length;i++){
//        		a[i]=re[i+1];
//        	}
//        	return a;
//        }
//    }
    public static void main(String[] args) {
		Plus_One one = new Plus_One();
		for(int i:one.plusOne(new int[]{9}))
			System.out.print(i+".");
	}
}
