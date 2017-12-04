import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int[] num = new int[n];
		for(int i = 0; i < n; i++){
			num[i] = cin.nextInt();
		}
		
		int mid = -1;
		for(int i = 0, sma = 0, big = 0; i < n; sma = 0, big = 0, i++){
			for(int j = 0; j < n; j++){
				if (num [j] < num[i]) sma ++;
				if (num [j] > num[i]) big++;
			}
			if(sma != 0 && sma == big) {
				mid = num[i];
				break;
			}
		}
		System.out.println(mid);
	}
}
