import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;


public class MainTest {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int[] num = new int[n];
		for(int i = 0; i < n; i++){
			num[i] = cin.nextInt();
		}
		
		//int mid = -1;
		Set<Integer> setMid = new HashSet<Integer>();
		for(int i = 0, sma = 0, big = 0; i < n; sma = 0, big = 0, i++){
			for(int j = 0; j < n; j++){
				if (num [j] < num[i]) sma ++;
				if (num [j] > num[i]) big++;
			}
			if(sma != 0 && sma == big) {
				//mid = num[i];
				setMid.add(num[i]);
				//break;
			}
		}
		if(setMid.size() == 0)
			System.out.println(-1);
		else
			for(int mid : setMid){
				System.out.println(mid);
			}
		
	}
}
