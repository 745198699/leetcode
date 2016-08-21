package string;

public class Reverse_String {
    public String reverseString(String s) {
        char[] chs = s.toCharArray();
        int left=0,right=s.length()-1;
        while(left<right){
        	char temp = chs[left];
        	chs[left]=chs[right];
        	chs[right]=temp;
        	left++;
        	right--;
        }
        
        return new String(chs);
    }

	public static void main(String[] args) {
		String s = new Reverse_String().reverseString("hello");
		System.out.println(s);
	}

}
