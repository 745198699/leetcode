package string;

public class Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
    	if(s.length()==0)
    		return 0;
        int re = 0 ;
        //ignore ' ' in the end of s
        int i=s.length()-1;
        while(i>=0&&s.charAt(i)==' ') i--;
        while(i>=0){
        	if(s.charAt(i)!=' '){
        		re++;i--;
        	}
        	else
        		break;
        }
        return re;
    }
	public static void main(String[] args) {
		System.out.println(new Length_of_Last_Word().lengthOfLastWord("   "));
	}

}
