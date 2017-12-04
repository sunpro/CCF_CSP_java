//import com.sunpro.java.*;
public class Main {
	
	public static void main(String args[]) {
		java.util.Scanner cin = new java.util.Scanner(System.in);
		int n = cin.nextInt();
		int[] num = new int[n];
		for(int i = 0; i < n; i++){
			num[i] = cin.nextInt();
		}
		//Print.printArray(num);
		
		//int n = 999;
		//int[] n1 = com.sunpro.java.RandomGenerator.randGenerator(499,99);
		//int[] n2 = com.sunpro.java.RandomGenerator.randGenerator(499,899);
		//for(int i = 0; i < 499; i++)
		//	n2[i] += 101;
		//int[] num = new int[999];
		//System.arraycopy(n1, 0, num, 0, 499);
		//System.arraycopy(n2, 0, num, 500, 499);
		//num[499] = 100;
		
		
		
		//
		boolean flag = false;
		boolean stop = false;
		int count = 0;
		for(int i = 0; i < n;) {
			count = 0;
			for(int j = 0; j < n; j++) {
				if(num[j] > num[i])
					count++;
				else if(num[j] < num[i])
					count--;
			}
			if(count == 0) {
				System.out.println(num[i]);
				flag = true;
				break;
			}
			else if(count > 0){
				int x = num[i];
				while(i < n-1 && num[++i] <= x);
			}else {
				int x = num[i];
				while(i < n-1 && num[++i] >= x);
			}
			if(i >= n-1 )
				break;;
		}
		if(!flag)
			System.out.println(-1);
	}
}