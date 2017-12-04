import java.util.Scanner;
public class Main{
	public static int length;
	public static int num[];
	public static int count = 0;
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		length = cin.nextInt();
		num = new int[length];
		for(int i = 0; i < length; i++){
			num[i] = cin.nextInt();
		}
		for(int i = length; i > 0; i--){
			for(int j = 0; j < i - 1;j++){
				if(num[j] < num[j + 1]){
					num[j] = num[j] + num[j+1];
					num[j+1] = num[j] - num[j+1];
					num[j] = num[j] - num[j+1];
				}
			}
		}
		for(int i = 0; i < length - 1; i++){
			if(num[i] - num[i+1] == 1) count++;
		}
		System.out.print(count + "");
	}
}