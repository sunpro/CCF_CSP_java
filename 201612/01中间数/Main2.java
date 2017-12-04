import java.util.Scanner;
public class Main2{
	private static int n = 0;
	private static int num[];
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		num = new int[n];
		for(int i = 0; i < n; i++){
			num[i] = cin.nextInt();
		}
		int result = -1;
		for(int i = 0; i < n; i++){
			int sm = 0;
			int big = 0;
			for(int j = 0; j < n; j++){
				if(num[j] > num[i]) big++;
				else if(num[j] < num[i]) sm++;
			}
			if(big == sm && (big != 0 || sm != 0)){
				result = num[i];
			}
		}
		System.out.println(result);
	}
} 