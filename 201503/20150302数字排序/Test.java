import java.util.Scanner;
public class Test{
	public static int length;
	public static int num[];
	public static int max = 0;
	public static int count[];
	public static int index[];
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		length = cin.nextInt();
		num = new int[length];
		for(int i = 0; i < length; i++){
			num[i]  = cin.nextInt();
			if(max < num[i]) max = num[i];
		}
		
		count = new int[max];
		index = new int[max];
		//initialize index
		for(int i = 0; i < max; i++){
			index[i] = i;
		}
		
		for(int i : num){
			count[i - 1] ++;
		}
		//out;
		//for(int i: count){
		//	System.out.print(i + " ");
		//}
		//paixu
		for(int i = max; i > 0; i--){
			for(int j = 0; j < i - 1; j++){
				if(count[j]<count[j+1]){
					int temp = count[j+1];
					count[j + 1] = count[j];
					count[j] = temp;
					temp = index[j+1];
					index[j + 1] = index[j];
					index[j] = temp;
				} 
			}
		}
		for(int i = 0; i < max; i++){
			if(count[i] == 0) break;
			System.out.println((index[i]+1) + " " + count[i]);
		}
	}
}