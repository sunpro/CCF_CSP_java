

import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int m = cin.nextInt();
		int[][] move = new int[m][2];
		for(int i = 0; i < m; i++) {
			move[i][0] = cin.nextInt();
			move[i][1] = cin.nextInt();
		}
		//initialize;
		List<Integer> slist = new ArrayList<>();
		for(int i = 1; i <= n; i++){
			slist.add(i);
		}
		//move
		int index = 0;
		int q = 0;
		for(int i = 0; i < m; i++) {
			index = slist.indexOf(move[i][0]);
			slist.remove(index);
			slist.add(index + move[i][1], move[i][0]);
		}
		for(int i : slist)
			System.out.print(i + " ");
	}
}