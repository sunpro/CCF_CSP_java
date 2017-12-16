import java.util.*;

public class Main {
	
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();//获取输入个数
		int[] num = new int[n];
		for(int i = 0; i<n; i++) {
			num[i] = cin.nextInt();
		}
		//排序
		Arrays.sort(num);
		/*
		for(int i = 0; i<n; i++) {
			System.out.print(num[i] + ", ");
		}
		System.out.println();
		*/////////
		int most = 0; //出现次数最多的数
		int max = 0;
		int count = 0;
		int last = num[0];
		int now =0;
		for(int i = 0; i<n; i++) {
			now = num[i];
			if(now == last){ //统计目前这个数的出现的次数；
				count++;
				
			}else{
				count = 1;
			}
			last = now;
			if(count > max){
				most = now;
				max = count;
			}
		}
		System.out.println(most);
	}
	
}

