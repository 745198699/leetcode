package string;

import java.math.BigInteger;
import java.util.*;

public class Restore_IP_Addresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<>();

		backTrack(list,"", s, 4);

		return list;
	}

	private void backTrack(List<String> list,String cur, String remain,int n){
		if(n==0){
//			if(remain.length()>3)
//				return;
//			if(remain.length()>1&&remain.startsWith("0"))
//				return;
//			int remainInt = Integer.parseInt(remain);
//			if((remainInt>=1&&remainInt<=255)||
//					(remainInt==0&&remain.length()==1)){
//				list.add(cur+remain);
//			}
			if(remain.length()==0)
				list.add(cur.substring(0,cur.length()-1));
			return;
		}

		int count =1;
		int remainLen = remain.length();
		while(remainLen>0&&count<=3){
			String cut = remain.substring(0,count);
			int cutInt = Integer.parseInt(cut);
			if(cutInt>255||(cut.length()>1&&cut.startsWith("0")))
				break;

			backTrack(list, cur+cut+".", remain.substring(count), n-1);

			remainLen--;count++;
		}


	}




	public static void main(String[] args) {
		System.out.println(new Restore_IP_Addresses().restoreIpAddresses("010010"));
	}

}
