import java.util.Scanner;
public class Main{
	public static int n;
	public static int[][] matrix;
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		matrix = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				matrix[i][j] = cin.nextInt();
			}
		}
		for(int i = 2; i <= n+n; i++){
			if(i % 2 == 0 & i <= n ){
				for(int j = i - 1 - 1; j >= 0; j--){
					System.out.print(matrix[j][i - 2 - j] + " ");
				}
			}else if(i % 2 == 0 & i > n){
				for(int j = n -1; j >= i - n -1; j--){
					System.out.print(matrix[j][i - 2 - j] + " ");
				}
			}else if(i % 2 == 1 & i <= n){
				for(int j = i - 1 - 1; j >= 0; j--){
					System.out.print(matrix[i - 2 - j][j] + " ");
				}
			}else if(i % 2 == 1 & i > n){
				for(int j = n -1; j >= i - n -1; j--){
					System.out.print(matrix[i - 2 - j][j] + " ");
				}
			}
		}
	}
}