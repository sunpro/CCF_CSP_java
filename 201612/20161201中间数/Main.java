public class Main {
	
	public static void main(String args[]) {
		java.util.Scanner cin = new java.util.Scanner(System.in);
		int n = cin.nextInt();
		int[] num = new int[n];
		for(int i = 0; i < n; i++)
			num[i] = cin.nextInt();
		
		java.util.Arrays.sort(num);
		
		
	}
}