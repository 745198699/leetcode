/*
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
package array;

import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle {
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> reList = new ArrayList<List<Integer>>();
//        if(numRows==0)
//        	return reList;
//        List<Integer> line_one = new ArrayList<Integer>();
//        line_one.add(1);
//        reList.add(line_one);
//        for(int i=2;i<=numRows;i++){
//        	List<Integer> last_row = reList.get(i-2);
//        	List<Integer> cur_row = new ArrayList<Integer>();
//        	
//        	for(int j=1;j<=i;j++){
//        		if(j==1)
//        			cur_row.add(last_row.get(0));
//        		else if(j==i)
//        			cur_row.add(last_row.get(j-2));
//        		else
//        			cur_row.add(last_row.get(j-2)+last_row.get(j-1));
//        	}
//        	reList.add(cur_row);
//        }
//        
//        
//        return reList;
//    }
	public List<List<Integer>> generate(int numRows)
	{
	    List<List<Integer>> allrows = new ArrayList<List<Integer>>();
	    ArrayList<Integer> row = new ArrayList<Integer>();
	    for(int i=0;i<numRows;i++)
	    {
	        row.add(0, 1);
	        for(int j=1;j<row.size()-1;j++)
	            row.set(j, row.get(j)+row.get(j+1));
	        allrows.add(new ArrayList<Integer>(row));
	    }
	    return allrows;

	}
    public static void main(String[] args) {
    	Pascal_Triangle pascal_Triangle = new Pascal_Triangle();
    	pascal_Triangle.generate(4);
	}
}
