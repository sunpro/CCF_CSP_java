public class Test{
	public static void main(String args[]){
		long tB1 = System.currentTimeMillis();
		for(int i = 0; i< 10000; i++){
			System.out.print(i + "\r\n");
		}
		long tA1 = System.currentTimeMillis();
		
		long tB2 = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 10000; i++){
			sb.append(i + "\n");
		}
		System.out.print(sb.toString());
		long tA2 = System.currentTimeMillis();
		
		long tB3 = System.currentTimeMillis();
		StringBuilder sb2 = new StringBuilder();
		for(int i = 0; i < 10000; i++){
			sb2.append(i + "\r");
		}
		System.out.print(sb.toString());
		long tA3 = System.currentTimeMillis();
		System.out.println(tA1 - tB1);
		System.out.println(tA2 - tB2);
		System.out.println(tA3 - tB3);
	}
	
} 
