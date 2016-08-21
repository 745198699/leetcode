package string;

public class Decode_Ways {

	public static void main(String[] args) {
		System.out.println(new Decode_Ways().numDecodings("101"));
	}

	public int numDecodings(String s) {
		if(s.length()==0||s.equals("0"))
			return 0;
		if(s.length()==1)
			return 1;
		int [] re = new int[s.length()];
		re[0]=1;
		if(s.length()>=2){
			String ss = s.substring(0,2);
			int ii = Integer.parseInt(ss);
			if(ii<10)
				return 0;
			else if(ii==10||ii==20)
				re[1]=1;
			else if(ii%10==0)
				return 0;
			else if(ii<26)
				re[1]=2;
			else
				re[1]=1;
	//    		if(s.charAt(0)=='0') //s:*0
	//        		return 0;
	//        	else if(s.charAt(0)<='2'&&s.charAt(1)=='0'){  //s:10 20
	//        		re[1]=1;
	//        	}else if(s.charAt(0)>='3'&&s.charAt(1)=='0')  //30 40..
	//        		return 0;
	//        	else if(Integer.parseInt(s.substring(0,2))<=26){  //s<=26
	//        		re[1]=2;
	//        	}else{  //s>26
	//        		re[1]=1;
	//        	}
		}
		
	    for(int i=2;i<s.length();i++){
	    	if(s.charAt(i)=='0'&&(s.charAt(i-1)>='3'||s.charAt(i-1)=='0')){ //出现了30 40 ... 00
	    		return 0;
	    	}else if(s.charAt(i)=='0')  //10 20
	    		re[i]=re[i-2];
	    	else if(Integer.parseInt(s.substring(i-1,i+1))>=11&&Integer.parseInt(s.substring(i-1,i+1))<=26) //不是01~09  并且1<=s<=26
	    		re[i]=re[i-1]+re[i-2];
	    	else    //s>26 
	    		re[i]=re[i-1];
	    }
	    
	    return re[s.length()-1];
	}
}
