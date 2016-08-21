/*
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].


 */
package array;

import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> re = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
        	re.add(0, 1);
        	for(int j=1;j<re.size()-1;j++){
        		re.set(j, re.get(j)+re.get(j+1));
        	}
        }
        
        return re;
    }
    
    public static void main(String[] args) {
		Pascal_Triangle_II ii = new Pascal_Triangle_II();
		ii.getRow(3);
	}
}
