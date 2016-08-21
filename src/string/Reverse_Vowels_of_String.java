package string;

public class Reverse_Vowels_of_String {
	public String reverseVowels(String s) {
		StringBuffer re = new StringBuffer();
		int len = s.length();
		char[]vowels = new char[len];
		int count =0;
		for(int i=0;i<s.length();i++){
			if(isVowel(s.charAt(i))){
				vowels[count++]=s.charAt(i);
			}
		}
		for(int i=0;i<s.length();i++){
			if(isVowel(s.charAt(i))){
				re.append(vowels[--count]);
			}else{
				re.append(s.charAt(i));
			}
		}
		
		
		return re.toString();
	}
	
	private boolean isVowel(char c){
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||
				c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
			return true;
		else return false;
	}
	public static void main(String[] args) {
		String s = new Reverse_Vowels_of_String().reverseVowels("Aa");
		System.out.println(s);
	}

}
