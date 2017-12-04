import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
public class Main{
	private static int n = 0;
	private static int num[];
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		num = new int[n];
		for(int i = 0; i < n; i++){
			num[i] = cin.nextInt();
		}
		boolean noMid = true;
		Set<Integer> midSet = new HashSet<Integer>();
		for(int i = 0; i < n; i++){
			int sm = 0;
			int big = 0;
			for(int j = 0; j != i && j < n; j++){
				if(num[j] > num[i]) big ++;
				else if(num[j] < num[i]) sm++;
			}
			if(big == sm && big != 0){
				noMid = false;
				midSet.add(num[i]);
			}
		}
		
		if(noMid){
			System.out.println(-1);
		}else{
			for(int number : midSet){
				System.out.println(number);
			}
		}
	}
} 