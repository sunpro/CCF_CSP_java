import java.util.Scanner;
import java.lang.Math;
public class Main{
	public static void main(String[] args){
		int[] price;
		int count;
		Scanner sc = new Scanner(System.in);
		count = sc.nextInt();
		price = new int[count];
		for (int i = 0; i < count; i++){
			price[i] = sc.nextInt();
		}
		int max = 0;
		for(int i = 0; i < count -1; i++){
			int maxtemp = Math.abs(price[i+1] - price[i]);
			if(maxtemp > max){
				max = maxtemp;
			}
		}
		System.out.print(max + "");
	}
}