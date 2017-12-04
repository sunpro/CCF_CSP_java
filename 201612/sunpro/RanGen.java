import java.util.Random;
public class RanGen{
	public RanGen(){}
	
	public static int[] randomGen(int n){
		return randomGen(n,0,10);
	}
	public static int[] randomGen(int n,int end){
		return randomGen(n,0,end);
	}
	public static int[] randomGen(int n, int start, int end){
		Random r = new Random();
		int randArr[] = new int[n];
		for(int i = 0; i < n; i++){
			randArr[i] = r.nextInt(end - start) + start;
		}
		return randArr;
	}
} 
