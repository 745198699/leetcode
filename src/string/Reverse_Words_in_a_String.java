package string;

public class Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        String [] words = s.split(" ");
        StringBuffer res = new StringBuffer();
        for(int i=words.length-1;i>=0;i--){
        	if(!words[i].equals(""))
        		res = res.append(" ").append(words[i]);
        }
        return res.toString().trim();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Reverse_Words_in_a_String().reverseWords("a      b"));
	}

}
