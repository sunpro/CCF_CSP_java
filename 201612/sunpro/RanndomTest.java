import java.util.Random;
public class RandomTest{
	
	public static void main(String args[]){
		Random r = new Random();
		for(int i = 0; i < 10; i++){
			System.out.println("nextInt():" + r.nextInt());
			System.out.println("nextInt(10):" + r.nextInt(10));
		}
		Random rt = new Random(System.currentTimeMillis());
		for(int i = 0; i < 10; i++){
			System.out.println("rtnextInt():" + rt.nextInt());
			System.out.println("rtnextInt(10):" + rt.nextInt(10));
		}
	}
}