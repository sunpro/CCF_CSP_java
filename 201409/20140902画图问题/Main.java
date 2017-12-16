import java.util.*;

public class Main{
	
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();//输入矩形的个数
		int[][] mat = new int[n][4];//定义二维数组，存放矩形的横纵坐标
		//int[4] maxMat = new int[4]; //求取所有输入矩形的范围
		for(int i=0; i<n; i++){
			for(int j = 0; j < 4; j++) {
				mat[i][j] = cin.nextInt();
			}
		}
		/*
		for(int i=0; i<n; i++){
			for(int j = 0; j < 4; j++) {
				System.out.print("" + mat[i][j]);
			}
			System.out.println();
		}
		*/
		//初始化画布
		int[][] bg = new int[100][100];
		//依次将每个矩形输入到画布上：
		int x1,y1,x2,y2 = 0;
		for(int i =0; i< n; i++) {
			
			x1 = mat[i][0];
			y1 = mat[i][1];
			x2 = mat[i][2];
			y2 = mat[i][3];
			//System.out.println("x1="+x1+", y1="+y1+", x2="+x2+", y2="+y2);
			for(int p = x1; p < x2; p++){
				for(int q = y1; q < y2; q++){
					bg[p][q] = 1;
					//System.out.println(bg[p][q]);
				}
			}
		}
		//统计画布中黑点的数量；
		int sumArea = 0;
		for (int i =0; i < 100; i++) {
			for (int j = 0; j < 100; j++)
				sumArea += bg[i][j];
		}
		
		System.out.println(sumArea);
		
	}
	
}
