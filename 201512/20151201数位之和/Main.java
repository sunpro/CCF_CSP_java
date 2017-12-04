import java.util.Scanner;
public class Main{
	public static int num;
	public static int l;
	public static int sum = 0;
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		num = cin.nextInt();
		l = String.valueOf(num).length();
		for(;l>0; l--){
			sum += Integer.parseInt(String.valueOf(num).substring(l-1,l));
		}
		System.out.print("" + sum);
	}
}