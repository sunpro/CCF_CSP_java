public class Out{
	public static void main(String args[]){
		long timeBefore = System.currentTimeMillis();
		for(int i = 0; i < 100; i++){
			System.out.println(i);
		}
		long timeAfter = System.currentTimeMillis();
		System.out.println(timeAfter - timeBefore);
	}
} 
