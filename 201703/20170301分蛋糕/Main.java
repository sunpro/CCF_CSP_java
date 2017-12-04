import java.util.Scanner;

public class Main {
	private final static boolean DEBUG = false;
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int k = cin.nextInt();
		//System.out.println();
		int[] cake = new int[n];
		for(int i =0; i < n; i++)
			cake[i] = cin.nextInt();
		if(DEBUG)
			printArr(cake);
		//devide
		int temp = k;
		int index = 0;
		int count =0;
		while(temp > 0 && index < n){
			temp = temp - cake[index++];
			if(temp <= 0){
				count++;
				temp = k;
			}
		}
		if(temp < k){
				count++;
			}
		System.out.println(count);
		
	}
	private static int findmin(int[] arr, int s, int e){
		int min = Integer.MAX_VALUE;
		for(int i = s+1; i <= e; i++){
			int temp = arr[i];
			if(temp != -1 && temp < min){
				min = temp;
				arr[i] = -1;
			}
		}
		return min;
	}
	private static void printArr(int[] arr) {
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
}