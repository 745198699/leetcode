package string;

public class ZigZag_Conversion {
	public String convert(String s, int numRows) {
		if(s.equals("")||s==null)
			return "";
		if(numRows==1)
			return s;
		StringBuffer resBuffer = new StringBuffer();
		for(int i=0;i<numRows;i++){
			int index = i;
			while(index<s.length()){
				resBuffer.append(s.charAt(index));
				index+=(2*numRows-2);
				if(i>0&&i<numRows-1){
					if(index-i*2<s.length())
						resBuffer.append(s.charAt(index-i*2));
				}
			}
		}


		return resBuffer.toString();
	}
}
