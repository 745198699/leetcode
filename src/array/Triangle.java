package array;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	
	
//	public int minimumTotal(List<List<Integer>> triangle) {//自上而下
//		
//		int row = triangle.size();
//		
//		for(int i=1;i<row;i++){
//			List<Integer> list = triangle.get(i);
//			for(int j=0;j<list.size();j++){
//				int up_min =0;
//				int temp =0;
//				if(j==0){
//					up_min = triangle.get(i-1).get(0);
//					temp = list.get(0)+up_min;
//				}else if(j==i){
//					up_min = triangle.get(i-1).get(j-1);
//					temp = list.get(j)+up_min;
//				}else{
//					int up_1 = triangle.get(i-1).get(j-1);
//					int up_2 = triangle.get(i-1).get(j);
//					temp = list.get(j)+((up_1<=up_2)?up_1:up_2);
//				}
//				list.set(j, temp);
//			}
//		}
//		
//		//获取最后一行最小的数值
//		int result = triangle.get(row-1).get(0);
//		for(int i=0;i<triangle.size();i++){
//			if(triangle.get(row-1).get(i)<=result){
//				result = triangle.get(row-1).get(i);
//			}
//		}
//		
//		return result;
//    }

	public int minimumTotal(List<List<Integer>> triangle){
		
		for(int i=triangle.size()-2;i>=0;i--){
			for(int j=0;j<=i;j++){
				triangle.get(i).set(j,triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
			}
		}
		return triangle.get(0).get(0);
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);list2.add(4);
		
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(list1);
		triangle.add(list2);
		
		Triangle triangle2 = new Triangle();
		System.out.println(triangle2.minimumTotal(triangle));
	}

}
