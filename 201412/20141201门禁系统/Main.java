import java.util.Scanner;
public class Main{
	public static int sum;//hang
	public static int[] num;
	public static int[] count;
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		sum = cin.nextInt();
		num = new int[sum];
		for(int i = 0; i < sum; i++){
			num[i]  = cin.nextInt();
		}
		count = new int[sum];
		
		for(int i = 0; i < sum; i++){
			System.out.print(++count[num[i] - 1] + " ");
		}
		for(int i = 0; i < sum; i++){
			
		}
	}
}