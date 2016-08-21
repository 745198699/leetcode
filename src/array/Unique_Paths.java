package array;

import java.math.BigInteger;

public class Unique_Paths {
	
	
//	public int uniquePaths(int m, int n) {//数学排列组合计算
//		int a = (m-1)+(n-1);
//		int b = (m-1);
//		
//		BigInteger c = new BigInteger("1");
//		BigInteger i = new BigInteger("1");
//		
//		while(i.intValue()<=m-1){
//			c=c.multiply(i);
//			i=i.add(new BigInteger("1"));
//		}
//		
//		BigInteger d = new BigInteger("1");
//		BigInteger j = new BigInteger("0");
//		while(j.intValue()<b){
//			int x = a-j.intValue();
//			BigInteger temp = new BigInteger(x+"");
//			d = d.multiply(temp);
//			j=j.add(new BigInteger("1"));
//		}
//		
//		
//		System.out.println("d:"+d+"c:"+c);
//        return d.divide(c).intValue();
//    }

	
//	public int uniquePaths(int m,int n){//二维数组
//		int[][] a = new int[m][n];
//		for (int i = 0; i < m; i++) {  
//            a[i][0] = 1;  
//        }  
//        for (int i = 0; i < n; i++) {  
//            a[0][i] = 1;  
//        }  
//        for (int i = 1; i < m; i++) {  
//            for (int j = 1; j < n; j++) {  
//                a[i][j] = a[i-1][j] + a[i][j-1];  
//            }  
//        }  
//        return a[m-1][n-1];  
//	}
	
	public int uniquePaths(int m, int n) {  //一维数组
        // DP with 1 dimension array  
        int[] a = new int[n];  
        for (int j = 0; j < n; j++) {  
            a[j] = 1;  
        }  
        for (int i = 1; i < m; i++) {  
            for (int j = 1; j < n; j++) {  
                a[j] += a[j-1];  
            }  
        }  
        return a[n-1];  
    } 
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Unique_Paths paths = new Unique_Paths();
		System.out.println(paths.uniquePaths(3,3));

	}

}
