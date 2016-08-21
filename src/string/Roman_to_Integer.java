package string;

public class Roman_to_Integer {
//	String[][]table = {
//	{"","I","II","III","IV","V","VI","VII","VIII","IX"},
//	{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
//	{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
//	{"","M","MM","MMM"}
//};
//String[]table2 = {"I","V","X","L","C","D","M"};
	public int romanToInt(String s) {
		int re=0;
		int i=0;
		while(i<s.length()){
			switch(s.charAt(i)){
			case 'I':
				if(i+1<s.length()&&s.charAt(i+1)=='V'){
					re+=4;
					i+=2;
				}else if(i+1<s.length()&&s.charAt(i+1)=='X'){
					re+=9;
					i+=2;
				}else{
					re+=1;
					i++;
				}
				break;
			case 'V':
				re+=5;
				i++;
				break;
			case 'X':
				if(i+1<s.length()&&s.charAt(i+1)=='L'){
					re+=40;
					i+=2;
				}else if(i+1<s.length()&&s.charAt(i+1)=='C'){
					re+=90;
					i+=2;
				}else{
					re+=10;
					i++;
				}
				break;
			case 'L':
				re+=50;
				i++;
				break;
			case 'C':
				if(i+1<s.length()&&s.charAt(i+1)=='D'){
					re+=400;
					i+=2;
				}else if(i+1<s.length()&&s.charAt(i+1)=='M'){
					re+=900;
					i+=2;
				}else{
					re+=100;
					i++;
				}
				break;
			case 'D':
				re+=500;
				i++;
				break;
			case 'M':
				re+=1000;
				i++;
				break;
			default:
				break;
			}
		}
		return re;
	}
	public static void main(String[] args) {
		System.out.println(new Roman_to_Integer().romanToInt("LXXXIX"));
	}

}
