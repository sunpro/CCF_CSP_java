import java.util.Scanner;
public class Main{
	public static int length;
	public static int[] num;
	public static int count = 1;
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		length = cin.nextInt();
		num = new int[length];
		for(int i = 0;i < length; i++){
			num[i] = cin.nextInt();
		}
		
		//int itemp = 0;
		for(int i = 1; i < length; i++){
			if(num[i] != num[i - 1]) count++;
		}
		System.out.print("" + count);
	}
}