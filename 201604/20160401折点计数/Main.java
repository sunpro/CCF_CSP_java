import java.util.Scanner;
public class Main{
	private static int num;
	private static int[] a;
	private static int count = 0;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		a = new int[num];
		for(int i = 0; i < num; i++){
			a[i] = sc.nextInt();
		}
		for(int i = 0; i < num - 2; i++){
			if((a[i+1] - a[i]) * (a[i+2] - a[i+1]) < 0)
				count++;
		}
		System.out.print("" + count);
	}
}