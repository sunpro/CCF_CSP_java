import java.util.Scanner;
public class Main{
	private static int num;
	private static int[] a;
	private static int total = 100;
	private static int ticket[] = new int[total];
	private static Boolean flag = false; 
	
	public static void main(String[] args){
		for(int  i = 0; i < total; i++){
			ticket[i] = i+1;
		}
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		a = new int[num];
		for(int i = 0; i < num ; i++){
			a[i] = sc.nextInt();
		}
		int count;
		for(int anum : a){
			count = 0;
			for(int i = 0; i< total; i++){
				if(ticket[i] != 0 && count < anum) count++;
				if(ticket[i] == 0 && count < anum ) count = 0;
				if((i+1)%5 == 0 && count < anum ) count = 0;
				if (count == anum){
					for(int k = i - count + 1; k <= i; k++){
						System.out.print(k+1 + " ");
						ticket[k] = 0;
					}
					System.out.print("\n");
					count = 0;
					flag = true;
					break;
				}
			}
			if(!flag){
				for(int i = 0; i< total; i++){
					if(ticket[i] != 0 && count <= anum) {
						count ++;
						ticket[i] = 0;
						System.out.print(i+1 + " " );
					}
					if(count == anum) {
						System.out.print("\n");
						break;
						
					}
				}
			}
			flag = false;
		}
	}
}