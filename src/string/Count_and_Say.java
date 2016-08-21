package string;

public class Count_and_Say {

	public String countAndSay(int n) {
		StringBuffer sb = new StringBuffer();
		sb.append("1");
		for(int i=1;i<n;i++){
			sb=getRe2(sb);
		}
	
		return sb.toString();
	}
	
	private StringBuffer getRe2(StringBuffer s){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<s.length();){
			int count =1;
			while(i+count<s.length()&&s.charAt(i+count)==s.charAt(i))
				count++;
			sb.append(count).append(s.charAt(i));
			i+=count;
		}
		
		return sb;
	}
	
	private StringBuffer getRe(StringBuffer s){
		if(s.length()==1)
			return new StringBuffer("1").append(s);
		StringBuffer re=new StringBuffer();
		int count=1;
		for(int i=1;i<s.length();i++){
			if(s.charAt(i)==s.charAt(i-1)){
				count++;
			}else{
				re.append(count+""+s.charAt(i-1));
				count=1;
			}
		}
		re.append(count+""+s.charAt(s.length()-1));
		return re;
	}
}
