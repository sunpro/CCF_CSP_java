import java.util.Scanner;
public class Main{
	public static int n;
	public static int num[];
	public static int count = 0;
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		num = new int[n];
		for(int i = 0; i < n; i++){
			num[i] = cin.nextInt();
		}
		for(int i = 0; i < n-1; i++){
			for(int j = i+1; j < n; j++){
				if(num[i] + num[j] == 0) {
					count++;
					break;
				}
					
			}
		}
		System.out.println("" + count);
	}
}