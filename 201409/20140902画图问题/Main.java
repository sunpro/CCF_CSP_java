import java.util.Scanner;
public class Main{
	public static int num = 0;
	public static int sumSect = 0;
	public static int sum = 0;
	public static int matrix[][];
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		num = cin.nextInt();
		matrix = new int[num][4];
		for(int i = 0; i < num; i++){
			for(int j = 0; j < 4; j++){
				matrix[i][j] = cin.nextInt();
			}
		}
		for(int i = 0; i < num; i++){
			for(int j = i + 1; j < num ; j++){
				sumSect += section(matrix[i],matrix[j]);
			}
		}
		for(int i = 0; i < num ; i++){
			sum += (matrix[i][2] - matrix[i][0]) * (matrix[i][3] - matrix[i][1]);
		}
		System.out.print(sum - sumSect + "");
	}
	private static int section(int[] a, int[] b){
		int s = 0;
		int up=0, bottom=0, left=0, right = 0;
		if(a[0] <= b[0] & a[2] > b[0] & a[2] <= b[2]){
			up = a[2]; 
			bottom = b[0];
			if(a[1] <= b[1] & a[3] > b[1] & a[3] <= b[3]){
				left = b[1];
				right = a[3];
			}else if(a[1] <= b[1] & a[3] > b[3]){
				left = b[1];
				right = b[3];
			}else if(a[1] > b[1] & a[1] < b[3] & a[3] <= b[3]){
				left = a[1];
				right = a[3];
			}else if(a[1] > b[1] & a[1] < b[3] & a[3] > b[3]){
				left = a[1];
				right = b[3];
			}
		}else if(a[0] <= b[0] & a[2] > b[2]){
			up = b[2];
			bottom = b[0];
			if(a[1] <= b[1] & a[3] > b[1] & a[3] <= b[3]){
				left = b[1];
				right = a[3];
			}else if(a[1] <= b[1] & a[3] > b[3]){
				left = b[1];
				right = b[3];
			}else if(a[1] > b[1] & a[1] < b[3] & a[3] <= b[3]){
				left = a[1];
				right = a[3];
			}else if(a[1] > b[1] & a[1] < b[3] & a[3] > b[3]){
				left = a[1];
				right = b[3];
			}
		}else if(a[0] > b[0] & a[0] < b[2] & a[2] <= b[2]){
			up = a[2];
			bottom = a[0];
			if(a[1] <= b[1] & a[3] > b[1] & a[3] <= b[3]){
				left = b[1];
				right = a[3];
			}else if(a[1] <= b[1] & a[3] > b[3]){
				left = b[1];
				right = b[3];
			}else if(a[1] > b[1] & a[1] < b[3] & a[3] <= b[3]){
				left = a[1];
				right = a[3];
			}else if(a[1] > b[1] & a[1] < b[3] & a[3] > b[3]){
				left = a[1];
				right = b[3];
			}
		}else if(a[0] > b[0] & a[0] < b[2] & a[2] > b[2]){
			up = b[2];
			bottom = a[0];
			if(a[1] <= b[1] & a[3] > b[1] & a[3] <= b[3]){
				left = b[1];
				right = a[3];
			}else if(a[1] <= b[1] & a[3] > b[3]){
				left = b[1];
				right = b[3];
			}else if(a[1] > b[1] & a[1] < b[3] & a[3] <= b[3]){
				left = a[1];
				right = a[3];
			}else if(a[1] > b[1] & a[1] < b[3] & a[3] > b[3]){
				left = a[1];
				right = b[3];
			}
		}
		return (up - bottom ) * (right - left);
	}
}