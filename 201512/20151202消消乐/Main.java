import java.util.Scanner;
import java.lang.Math;
public class Main{
	public static int row;
	public static int column;
	public static int[][] matrix1;
	public static int[][] matrix2;
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		row = cin.nextInt();
		column = cin.nextInt();
		matrix1 = new int[row][column];
		matrix2 = new int[row][column];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				matrix1[i][j] = cin.nextInt();
				matrix2[i][j] = matrix1[i][j];
			}
		}
		int count = 1;
		for(int i = 0; i < row; i++){
			count = 1;
			for(int j = 0; j < column - 1; j++){
				if(matrix1[i][j] == matrix1[i][j+1]) count++;
				else{
					if(count < 3) count = 1;
					else{
						for(int k = j - count + 1; k <= j; k++){
							matrix1[i][k] = 0;
						}
						count = 1;
					}
				}
			}
			if (count >= 3){
				for(int k = column - 1 - count + 1; k <= column - 1; k++){
					matrix1[i][k] = 0;
				}
			}
		}
		for(int i = 0; i < column; i++){
			count = 1;
			for(int j = 0; j < row - 1; j++){
				if(matrix2[j][i] == matrix2[j+1][i]) count++;
				else{
					if(count < 3) count = 1;
					else{
						for(int k = j - count + 1; k <= j; k++){
							matrix2[k][i] = 0;
						}
						count = 1;
					}
				}
			}
			if(count >= 3){
				for(int k = row - 1 - count + 1; k <= row - 1; k++){
					matrix2[k][i] = 0;
				}
			}
		}
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				System.out.print((int)Math.sqrt(matrix1[i][j] * matrix2[i][j]) + " ");
			}
			System.out.println();
		}
	}
}