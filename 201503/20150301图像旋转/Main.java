import java.util.Scanner;
public class Main{
	public static int row;//hang
	public static int column;//lie
	public static int[][] pic;
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		row = cin.nextInt();
		column = cin.nextInt();
		pic = new int[row][column];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				pic[i][j] = cin.nextInt();
			}
		}
		for(int i = 0; i < column; i++){
			for(int j = 0; j < row; j++){
				System.out.print( pic[j][column - 1 - i] + " ");;
			}
			System.out.print("\n");
		}
	}
}